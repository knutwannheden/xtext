/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.builder.builderState;

import static com.google.common.collect.Sets.*;

import java.util.Collection;
import java.util.Collections;
import java.util.Set;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.OperationCanceledException;
import org.eclipse.core.runtime.SubMonitor;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.xtext.builder.impl.BuildData;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.resource.IResourceDescription;
import org.eclipse.xtext.resource.IResourceDescription.Delta;
import org.eclipse.xtext.resource.impl.AbstractResourceDescriptionChangeEventSource;
import org.eclipse.xtext.resource.impl.DefaultResourceDescriptionDelta;
import org.eclipse.xtext.resource.impl.ResourceDescriptionChangeEvent;

import com.google.common.base.Function;
import com.google.common.collect.Collections2;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;
import com.google.inject.Inject;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 * @author Knut Wannheden
 */
public abstract class AbstractBuilderState extends AbstractResourceDescriptionChangeEventSource implements
		IBuilderState {

	private volatile IResourceDescriptionsData resourceDescriptionData = new ResourceDescriptionsData(
			Collections.<IResourceDescription> emptyList());

	@Inject
	private IMarkerUpdater markerUpdater;

	@Inject
	private PersistedStateProvider persister;

	private volatile boolean isLoaded = false;

	public synchronized void load() {
		setResourceDescriptionsData(new ResourceDescriptionsData(persister.load()));
	}

	protected void ensureLoaded() {
		if (!isLoaded) {
			load();
			isLoaded = true;
		}
	}

	protected Set<URI> ensureNotNull(Set<URI> uris) {
		return uris != null ? uris : Collections.<URI> emptySet();
	}

	protected void setResourceDescriptionsData(IResourceDescriptionsData newData) {
		resourceDescriptionData = newData;
	}

	protected void updateMarkers(IResourceDescription.Delta delta, ResourceSet resourceSet, IProgressMonitor monitor) {
		markerUpdater.updateMarkers(delta, resourceSet, monitor);
	}

	protected IResourceDescriptionsData getResourceDescriptionsData() {
		return resourceDescriptionData;
	}

	protected IResourceDescriptionsData getCopiedResourceDescriptionsData(Set<URI> toBeUpdated, Set<URI> toBeDeleted) {
		return resourceDescriptionData.copy(true);
	}

	public Iterable<IResourceDescription> getAllResourceDescriptions() {
		ensureLoaded();
		return resourceDescriptionData.getAllResourceDescriptions();
	}

	public IResourceDescription getResourceDescription(URI uri) {
		ensureLoaded();
		return resourceDescriptionData.getResourceDescription(uri);
	}

	public void setPersister(PersistedStateProvider persister) {
		this.persister = persister;
	}

	public synchronized ImmutableList<IResourceDescription.Delta> update(BuildData buildData, IProgressMonitor monitor) {
		ensureLoaded();
		final SubMonitor subMonitor = SubMonitor.convert(monitor, Messages.AbstractBuilderState_0, 1);
		subMonitor.subTask(Messages.AbstractBuilderState_0);
		if (buildData.isEmpty())
			return ImmutableList.of();
		if (monitor.isCanceled())
			throw new OperationCanceledException();

		final IResourceDescriptionsData newData = getCopiedResourceDescriptionsData(buildData.getToBeUpdated(), buildData.getToBeDeleted());
		try {
			final Collection<IResourceDescription.Delta> result = doUpdate(buildData, newData, subMonitor.newChild(1));

			final ResourceDescriptionChangeEvent event = new ResourceDescriptionChangeEvent(result, this);
			commit(newData);
			notifyListeners(event);
			return event.getDeltas();
		} catch (RuntimeException e) {
			rollback(newData);
			throw e;
		}
	}

	protected abstract Collection<IResourceDescription.Delta> doUpdate(BuildData buildData,
			IResourceDescriptionsData newData, IProgressMonitor monitor);

	public synchronized ImmutableList<IResourceDescription.Delta> clean(Set<URI> toBeRemoved, IProgressMonitor monitor) {
		ensureLoaded();
		toBeRemoved = ensureNotNull(toBeRemoved);

		SubMonitor subMonitor = SubMonitor.convert(monitor, Messages.AbstractBuilderState_0, 2);
		subMonitor.subTask(Messages.AbstractBuilderState_0);
		if (toBeRemoved.isEmpty())
			return ImmutableList.of();
		if (monitor.isCanceled())
			throw new OperationCanceledException();

		final IResourceDescriptionsData newData = getCopiedResourceDescriptionsData(ImmutableSet.<URI> of(), toBeRemoved);
		try {
			Collection<IResourceDescription.Delta> deltas = doClean(toBeRemoved, subMonitor.newChild(1));
			if (monitor.isCanceled())
				throw new OperationCanceledException();
			newData.removeDescriptions(Collections2.transform(deltas,
					new Function<IResourceDescription.Delta, URI>() {
						public URI apply(Delta from) {
							return from.getOld().getURI();
						}
					}));
			ResourceDescriptionChangeEvent event = new ResourceDescriptionChangeEvent(deltas, this);
			if (monitor.isCanceled())
				throw new OperationCanceledException();
			subMonitor.setWorkRemaining(event.getDeltas().size());
			for(IResourceDescription.Delta delta : event.getDeltas()) {
				updateMarkers(delta, null, subMonitor);
				subMonitor.worked(1);
			}
			// update the reference
			commit(newData);
			notifyListeners(event);
			return event.getDeltas();
		} catch (RuntimeException e) {
			rollback(newData);
			throw e;
		}
	}

	protected void commit(final IResourceDescriptionsData newData) {
		setResourceDescriptionsData(newData);
	}

	protected void rollback(IResourceDescriptionsData newData) {
	}

	protected Collection<IResourceDescription.Delta> doClean(Set<URI> toBeRemoved, IProgressMonitor monitor) {
		SubMonitor subMonitor = SubMonitor.convert(monitor, Messages.AbstractBuilderState_2, toBeRemoved.size());
		subMonitor.subTask(Messages.AbstractBuilderState_2);
		Set<IResourceDescription.Delta> result = newLinkedHashSet();
		for (URI toDelete : toBeRemoved) {
			IResourceDescription resourceDescription = getResourceDescription(toDelete);
			if (resourceDescription != null) {
				result.add(new DefaultResourceDescriptionDelta(resourceDescription, null));
			}
			subMonitor.worked(1);
		}
		return result;
	}

	public Iterable<IEObjectDescription> getExportedObjects() {
		ensureLoaded();
		return resourceDescriptionData.getExportedObjects();
	}

	public Iterable<IEObjectDescription> getExportedObjects(EClass type, QualifiedName name, boolean ignoreCase) {
		ensureLoaded();
		return resourceDescriptionData.getExportedObjects(type, name, ignoreCase);
	}

	public Iterable<IEObjectDescription> getExportedObjectsByType(EClass type) {
		ensureLoaded();
		return resourceDescriptionData.getExportedObjectsByType(type);
	}

	public Iterable<IEObjectDescription> getExportedObjectsByObject(EObject object) {
		ensureLoaded();
		return resourceDescriptionData.getExportedObjectsByObject(object);
	}

	public boolean isEmpty() {
		ensureLoaded();
		return resourceDescriptionData.isEmpty();
	}

}
