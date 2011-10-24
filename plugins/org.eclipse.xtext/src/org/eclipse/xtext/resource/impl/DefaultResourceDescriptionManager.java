/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.resource.impl;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.resource.DescriptionUtils;
import org.eclipse.xtext.resource.IContainer;
import org.eclipse.xtext.resource.IDefaultResourceDescriptionStrategy;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.resource.IResourceDescription;
import org.eclipse.xtext.resource.IResourceDescription.Delta;
import org.eclipse.xtext.resource.IResourceDescriptions;
import org.eclipse.xtext.resource.IResourceDescriptionsExtension;
import org.eclipse.xtext.resource.IResourceDescriptionsExtension.ReferenceMatchPolicy;
import org.eclipse.xtext.resource.IResourceServiceProvider;
import org.eclipse.xtext.resource.containers.IAllContainersState;
import org.eclipse.xtext.util.IResourceScopeCache;

import com.google.common.base.Function;
import com.google.common.base.Predicate;
import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Collections2;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Iterables;
import com.google.common.collect.Multimap;
import com.google.common.collect.Sets;
import com.google.inject.Inject;
import com.google.inject.Provider;
import com.google.inject.Singleton;

/**
 * Default implementation of the {@link IResourceDescription.Manager}. Customize by binding another
 * {@link IDefaultResourceDescriptionStrategy}.
 * 
 * @author Sebastian Zarnekow - Initial contribution and API
 * @author Sven Efftinge
 * @author Jan Koehnlein
 */
@Singleton
public class DefaultResourceDescriptionManager implements IResourceDescription.Manager,
		IResourceDescription.ManagerExtension {

	@Inject
	private IDefaultResourceDescriptionStrategy strategy;

	@Inject
	private IContainer.Manager containerManager;

	@Inject
	private IResourceScopeCache cache = IResourceScopeCache.NullImpl.INSTANCE;

	@Inject
	private DescriptionUtils descriptionUtils;

	@Inject
	private IResourceServiceProvider serviceProvider;

	@Inject
	private IAllContainersState containersState;

	private static final String CACHE_KEY = DefaultResourceDescriptionManager.class.getName()
			+ "#getResourceDescription";

	public IResourceDescription getResourceDescription(final Resource resource) {
		return cache.get(CACHE_KEY, resource, new Provider<IResourceDescription>() {
			public IResourceDescription get() {
				return internalGetResourceDescription(resource, strategy);
			}
		});
	}

	public Delta createDelta(IResourceDescription oldDescription, IResourceDescription newDescription) {
		return new DefaultResourceDescriptionDelta(oldDescription, newDescription);
	}

	protected IResourceDescription internalGetResourceDescription(Resource resource,
			IDefaultResourceDescriptionStrategy strategy) {
		return new DefaultResourceDescription(resource, strategy, cache);
	}

	public IContainer.Manager getContainerManager() {
		return containerManager;
	}

	public void setContainerManager(IContainer.Manager containerManager) {
		this.containerManager = containerManager;
	}

	public void setCache(IResourceScopeCache cache) {
		this.cache = cache;
	}

	public IResourceScopeCache getCache() {
		return cache;
	}

	public boolean isAffected(Delta delta, IResourceDescription candidate) throws IllegalArgumentException {
		if (!isInterestedIn(delta))
			return false;
		Set<QualifiedName> names = Sets.newHashSet();
		addExportedNames(names, delta.getOld());
		addExportedNames(names, delta.getNew());
		return !Collections.disjoint(names, getImportedNames(candidate));
	}

	protected Collection<QualifiedName> getImportedNames(IResourceDescription candidate) {
		return Sets.newHashSet(candidate.getImportedNames());
	}

	protected void addExportedNames(Set<QualifiedName> names, IResourceDescription resourceDescriptor) {
		if (resourceDescriptor == null)
			return;
		Iterable<IEObjectDescription> iterable = resourceDescriptor.getExportedObjects();
		for (IEObjectDescription ieObjectDescription : iterable) {
			names.add(ieObjectDescription.getName().toLowerCase());
		}
	}

	public boolean isAffected(Collection<Delta> deltas, IResourceDescription candidate, IResourceDescriptions context) {
		Collection<Delta> interestingDeltas = Collections2.filter(deltas, new Predicate<Delta>() {
			public boolean apply(Delta input) {
				return isInterestedIn(input);
			}
		});
		if (interestingDeltas.isEmpty())
			return false;

		Set<URI> outgoingReferences = descriptionUtils.collectOutgoingReferences(candidate);
		if (!outgoingReferences.isEmpty()) {
			for (IResourceDescription.Delta delta : interestingDeltas)
				if (outgoingReferences.contains(delta.getUri()))
					return true;
		}
		// this is a tradeoff - we could either check whether a given delta uri is contained
		// in a reachable container and check for intersecting names afterwards, or we can do
		// the other way round
		// unfortunately there is no way to decide reliably which algorithm scales better
		// note that this method is called for each description so we have something like a 
		// number of deltas x number of resources which is not really nice
		List<IContainer> containers = null;
		Collection<QualifiedName> importedNames = getImportedNames(candidate);
		for (IResourceDescription.Delta delta : interestingDeltas) {
			// not a java resource - delta's resource should be contained in a visible container
			// as long as we did not delete the resource
			URI uri = delta.getUri();
			if ((uri.isPlatform() || uri.isArchive()) && delta.getNew() != null) {
				if (containers == null)
					containers = containerManager.getVisibleContainers(candidate, context);
				boolean descriptionIsContained = false;
				for (int i = 0; i < containers.size() && !descriptionIsContained; i++) {
					descriptionIsContained = containers.get(i).hasResourceDescription(uri);
				}
				if (!descriptionIsContained)
					return false;
			}
			if (isAffected(importedNames, delta.getNew()) || isAffected(importedNames, delta.getOld())) {
				return true;
			}
		}
		return false;
	}

	protected boolean isAffected(Collection<QualifiedName> importedNames, IResourceDescription description) {
		if (description != null) {
			for (IEObjectDescription desc : description.getExportedObjects())
				if (importedNames.contains(desc.getName().toLowerCase()))
					return true;
		}
		return false;
	}

	public DescriptionUtils getDescriptionUtils() {
		return descriptionUtils;
	}

	public void setDescriptionUtils(DescriptionUtils descriptionUtils) {
		this.descriptionUtils = descriptionUtils;
	}

	public void setStrategy(IDefaultResourceDescriptionStrategy strategy) {
		this.strategy = strategy;
	}

	/**
	 * @since 2.1
	 */
	protected boolean isManagerFor(URI uri) {
		return serviceProvider.canHandle(uri);
	}

	/**
	 * @since 2.1
	 */
	protected boolean isInterestedIn(Delta delta) {
		return delta.haveEObjectDescriptionsChanged();
	}

	/**
	 * @since 2.1
	 */
	public Collection<URI> getAffectedResources(Collection<Delta> deltas, final Collection<URI> candidates,
			IResourceDescriptionsExtension context) {
		Collection<Delta> interestingDeltas = Collections2.filter(deltas, new Predicate<Delta>() {
			public boolean apply(Delta input) {
				return isInterestedIn(input);
			}
		});
		if (interestingDeltas.isEmpty())
			return ImmutableSet.of();

		final Set<URI> references = Sets.newHashSet();
		Predicate<URI> filter = new Predicate<URI>() {
			public boolean apply(final URI input) {
				return !references.contains(input) && isManagerFor(input) && candidates.contains(input);
			}
		};

		final Set<IResourceDescription> changedOrDeletedResources = Sets.newHashSet();
		Iterable<IEObjectDescription> changedOrDeletedObjects = ImmutableSet.of();
		final Multimap<String, IResourceDescription> addedResources = ArrayListMultimap.create();
		final Multimap<String, IEObjectDescription> addedObjects = ArrayListMultimap.create();

		for (Delta delta : interestingDeltas) {
			String container = getContainer(delta.getUri());
			if (delta instanceof IResourceDescription.DeltaExtension) {
				IResourceDescription.DeltaExtension detailedDelta = (IResourceDescription.DeltaExtension) delta;
				changedOrDeletedObjects = Iterables.concat(detailedDelta.getChangedObjects(),
						detailedDelta.getDeletedObjects());
				addedObjects.putAll(container, detailedDelta.getAddedObjects());
			} else {
				if (delta.getOld() != null) {
					changedOrDeletedResources.add(delta.getNew() != null ? delta.getNew() : delta.getOld());
				} else {
					addedResources.put(container, delta.getNew());
				}
			}
		}

		if (!changedOrDeletedResources.isEmpty()) {
			Iterables.addAll(references, Iterables.transform(
					context.findAllReferencingResources(changedOrDeletedResources, ReferenceMatchPolicy.ALL),
					new Function<IResourceDescription, URI>() {
						public URI apply(final IResourceDescription from) {
							return from.getURI();
						}
					}));
		}
		if (!Iterables.isEmpty(changedOrDeletedObjects)) {
			Iterables.addAll(references, Iterables.transform(
					context.findObjectReferencingResources(changedOrDeletedObjects, ReferenceMatchPolicy.ALL),
					new Function<IResourceDescription, URI>() {
						public URI apply(final IResourceDescription from) {
							return from.getURI();
						}
					}));
		}

		for (String container : addedResources.keySet()) {
			for (IResourceDescription res : context.findAllReferencingResources(addedResources.get(container),
					ReferenceMatchPolicy.IMPORTED_NAMES)) {
				URI uri = res.getURI();
				if (filter.apply(uri) && isContainerVisible(uri, container)) {
					references.add(uri);
				}
			}
		}
		for (String container : addedObjects.keySet()) {
			for (IResourceDescription res : context.findObjectReferencingResources(addedObjects.get(container),
					ReferenceMatchPolicy.IMPORTED_NAMES)) {
				URI uri = res.getURI();
				if (filter.apply(uri) && isContainerVisible(uri, container)) {
					references.add(uri);
				}
			}
		}

		return references;
	}

	// FIXME this only works for StateBasedContainerManager
	private String getContainer(URI uri) {
	    return containersState.getContainerHandle(uri);
	}

	// FIXME this only works for StateBasedContainerManager
	private boolean isContainerVisible(URI uri, String container) {
		return containersState.getVisibleContainerHandles(containersState.getContainerHandle(uri)).contains(container);
	}

}
