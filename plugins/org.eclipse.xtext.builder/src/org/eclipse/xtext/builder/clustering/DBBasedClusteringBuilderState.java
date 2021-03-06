/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.builder.clustering;

import java.util.Set;

import org.eclipse.emf.common.util.URI;
import org.eclipse.xtext.builder.builderState.IResourceDescriptionsData;
import org.eclipse.xtext.builder.builderState.db.DBBasedBuilderState;
import org.eclipse.xtext.builder.builderState.db.DBBasedResourceDescriptionsData;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.resource.IReferenceDescription;
import org.eclipse.xtext.resource.IResourceDescription;
import org.eclipse.xtext.resource.IResourceDescriptionsExtension;

import com.google.inject.Inject;
import com.google.inject.Provider;

/**
 * @author Knut Wannheden - Initial contribution and API
 */
public class DBBasedClusteringBuilderState extends ClusteringBuilderState implements IResourceDescriptionsExtension {

	@Inject
	private Provider<DBBasedBuilderState> builderStateProvider;

	@Override
	public synchronized void load() {
		setResourceDescriptionsData(new DBBasedResourceDescriptionsData(builderStateProvider.get()));
	}

	@Override
	protected IResourceDescriptionsData getCopiedResourceDescriptionsData(Set<URI> toBeUpdated, Set<URI> toBeDeleted) {
		IResourceDescriptionsData result = super.getCopiedResourceDescriptionsData(toBeUpdated, toBeDeleted);
		((DBBasedResourceDescriptionsData) result).beginChanges();
		return result;
	}

	@Override
	protected void commit(IResourceDescriptionsData newData) {
		((DBBasedResourceDescriptionsData) newData).commitChanges();
		super.commit(newData);
	}

	@Override
	protected void rollback(IResourceDescriptionsData newData) {
		((DBBasedResourceDescriptionsData) newData).rollbackChanges();
		super.rollback(newData);
	}

	@Override
	protected IResourceDescription getIndexableDescriptionCopy(IResourceDescription description) {
		return super.getIndexableDescriptionCopy(description);
	}

	public Iterable<IResourceDescription> findAllReferencingResources(Iterable<IResourceDescription> targetResources,
			ReferenceMatchPolicy matchPolicy) {
		return ((DBBasedResourceDescriptionsData) getResourceDescriptionsData()).findAllReferencingResources(targetResources, matchPolicy);
	}

	public Iterable<IResourceDescription> findObjectReferencingResources(Iterable<IEObjectDescription> targetObjects,
			ReferenceMatchPolicy matchPolicy) {
		return ((DBBasedResourceDescriptionsData) getResourceDescriptionsData()).findObjectReferencingResources(targetObjects, matchPolicy);
	}

	public Iterable<IReferenceDescription> findReferencesToObjects(Iterable<URI> targetObjects) {
		return ((DBBasedResourceDescriptionsData) getResourceDescriptionsData()).findReferencesToObjects(targetObjects);
	}

}
