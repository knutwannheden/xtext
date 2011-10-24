/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.builder.builderState;

import java.util.Collection;
import java.util.Collections;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.resource.IReferenceDescription;
import org.eclipse.xtext.resource.IResourceDescription;
import org.eclipse.xtext.resource.IResourceDescriptionsExtension.ReferenceMatchPolicy.MatchType;
import org.eclipse.xtext.resource.ISelectable;
import org.eclipse.xtext.resource.impl.AbstractCompoundSelectable;

import com.google.common.base.Function;
import com.google.common.base.Predicate;
import com.google.common.collect.HashMultimap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.ImmutableSetMultimap;
import com.google.common.collect.Iterables;
import com.google.common.collect.Maps;
import com.google.common.collect.Multimap;
import com.google.common.collect.Sets;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class ResourceDescriptionsData extends AbstractCompoundSelectable implements IResourceDescriptionsData {

	private final Map<URI, IResourceDescription> resourceDescriptionMap;
	private final Multimap<QualifiedName, IResourceDescription> lookupMap;

	public ResourceDescriptionsData(Iterable<IResourceDescription> descriptions) {
		resourceDescriptionMap = Maps.uniqueIndex(descriptions, new Function<IResourceDescription, URI>() {
			public URI apply(IResourceDescription from) {
				return from.getURI();
			}
		});
		ImmutableSetMultimap.Builder<QualifiedName, IResourceDescription> builder = ImmutableSetMultimap.builder();
	    for (IResourceDescription description: descriptions) {
	    	for(IEObjectDescription object: description.getExportedObjects()) {
	    		QualifiedName lowerCase = object.getName().toLowerCase();
	    		builder.put(lowerCase, description);
	    	}
	    }
	    lookupMap = builder.build();
	}
	
	protected ResourceDescriptionsData(Map<URI, IResourceDescription> resourceDescriptionMap, Multimap<QualifiedName, IResourceDescription> lookupMap) {
		this.resourceDescriptionMap = resourceDescriptionMap;
		this.lookupMap = lookupMap;
	}
	
	public ResourceDescriptionsData copy(Set<URI> toBeUpdated, Set<URI> toBeDeleted) {
		return new ResourceDescriptionsData(
				Maps.newHashMap(resourceDescriptionMap),
				HashMultimap.create(lookupMap));
	}

	public Iterable<IResourceDescription> getAllResourceDescriptions() {
		return resourceDescriptionMap.values();
	}

	public IResourceDescription getResourceDescription(URI uri) {
		return resourceDescriptionMap.get(uri);
	}

	public void removeDescription(URI uri) {
		IResourceDescription oldDescription = resourceDescriptionMap.remove(uri);
		if (oldDescription != null) {
			for(IEObjectDescription object: oldDescription.getExportedObjects()) {
				lookupMap.remove(object.getName().toLowerCase(), oldDescription);
			}
		}
	}
	
	@Override
	public Iterable<IEObjectDescription> getExportedObjects(final EClass type, final QualifiedName qualifiedName, final boolean ignoreCase) {
		if (lookupMap.containsKey(qualifiedName.toLowerCase())) {
			Collection<IResourceDescription> candidates = lookupMap.get(qualifiedName.toLowerCase());
			return Iterables.concat(Iterables.transform(candidates, new Function<ISelectable, Iterable<IEObjectDescription>>() {
				public Iterable<IEObjectDescription> apply(ISelectable from) {
					if (from != null)
						return from.getExportedObjects(type, qualifiedName, ignoreCase);
					return Collections.emptyList();
				}
			}));
		}
		return Collections.emptyList();
	}
	
	@Override
	public Iterable<IEObjectDescription> getExportedObjectsByObject(EObject object) {
		URI resourceURI = EcoreUtil2.getNormalizedResourceURI(object);
		IResourceDescription description = getResourceDescription(resourceURI);
		if (description == null)
			return Collections.emptyList();
		return description.getExportedObjectsByObject(object);
	}
	
	@Override
	protected Iterable<IResourceDescription> getSelectables() {
		return resourceDescriptionMap.values();
	}

	public Set<URI> getAllURIs() {
		return resourceDescriptionMap.keySet();
	}

	public void addDescription(URI uri, IResourceDescription newDescription) {
		removeDescription(uri);
		if (newDescription != null) {
			resourceDescriptionMap.put(uri, newDescription);
			for(IEObjectDescription object: newDescription.getExportedObjects()) {
				lookupMap.put(object.getName().toLowerCase(), newDescription);
			}
		}
	}

	public Iterable<IResourceDescription> findAllReferencingResources(Iterable<IResourceDescription> targetResources,
			final ReferenceMatchPolicy matchPolicy) {
		if (Iterables.isEmpty(targetResources)) {
			return ImmutableSet.of();
		}

		final boolean matchReferences = matchPolicy.includes(MatchType.REFERENCES);
		final boolean matchNames = matchPolicy.includes(MatchType.IMPORTED_NAMES);

		final Set<URI> targetUris = Sets.newHashSetWithExpectedSize(Iterables.size(targetResources));
		final Set<QualifiedName> exportedNames = Sets.newHashSet();
		for (IResourceDescription resource : targetResources) {
			if (matchReferences)
				targetUris.add(resource.getURI());
			if (matchNames)
				for (IEObjectDescription obj : resource.getExportedObjects()) {
						exportedNames.add(obj.getName().toLowerCase());
				}
		}

		return Iterables.filter(getAllResourceDescriptions(), new Predicate<IResourceDescription>() {
			public boolean apply(final IResourceDescription input) {
				if (matchReferences) {
					for (IReferenceDescription ref : input.getReferenceDescriptions()) {
						if (targetUris.contains(ref.getTargetEObjectUri().trimFragment())) {
							return true;
						}
					}
				}
				if (matchNames) {
					for (QualifiedName name : input.getImportedNames()) {
						if (exportedNames.contains(name.toLowerCase())) {
							return true;
						}
					}
				}
				return false;
			}
		});
	}

	public Iterable<IResourceDescription> findObjectReferencingResources(
			Iterable<IEObjectDescription> targetObjects, final ReferenceMatchPolicy matchPolicy) {
		if (Iterables.isEmpty(targetObjects)) {
			return ImmutableSet.of();
		}

		final boolean matchReferences = matchPolicy.includes(MatchType.REFERENCES);
		final boolean matchNames = matchPolicy.includes(MatchType.IMPORTED_NAMES);

		final Set<URI> targetUris = Sets.newHashSetWithExpectedSize(Iterables.size(targetObjects));
		final Set<QualifiedName> exportedNames = Sets.newHashSet();
		for (IEObjectDescription obj : targetObjects) {
			if (matchReferences)
				targetUris.add(obj.getEObjectURI());
			if (matchNames)
				exportedNames.add(obj.getName().toLowerCase());
		}

		return Iterables.filter(getAllResourceDescriptions(), new Predicate<IResourceDescription>() {
			public boolean apply(final IResourceDescription input) {
				if (matchReferences) {
					for (IReferenceDescription ref : input.getReferenceDescriptions()) {
						if (targetUris.contains(ref.getTargetEObjectUri())) {
							return true;
						}
					}
				}
				if (matchNames) {
					for (QualifiedName name : input.getImportedNames()) {
						if (exportedNames.contains(name.toLowerCase())) {
							return true;
						}
					}
				}
				return false;
			}
		});
	}

	public Iterable<IReferenceDescription> findReferencesToObjects(final Iterable<URI> targetObjects) {
	    return Iterables.concat(Iterables.transform(getAllResourceDescriptions(), new Function<IResourceDescription, Iterable<IReferenceDescription>>() {
	        public Iterable<IReferenceDescription> apply(final IResourceDescription from) {
	          return Iterables.filter(from.getReferenceDescriptions(), new Predicate<IReferenceDescription>() {
	            public boolean apply(final IReferenceDescription input) {
	              return Iterables.contains(targetObjects, input.getTargetEObjectUri());
	            }
	          });
	        }
	      }));
	}

}
