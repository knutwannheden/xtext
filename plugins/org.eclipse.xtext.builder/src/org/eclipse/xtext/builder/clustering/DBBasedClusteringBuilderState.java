/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.builder.clustering;

import java.util.Collection;
import java.util.Map;
import java.util.Set;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.util.URI;
import org.eclipse.xtext.builder.builderState.IResourceDescriptionsData;
import org.eclipse.xtext.builder.builderState.db.DBBasedBuilderState;
import org.eclipse.xtext.builder.builderState.db.DBBasedResourceDescriptionsData;
import org.eclipse.xtext.builder.impl.BuildData;
import org.eclipse.xtext.resource.IResourceDescription;
import org.eclipse.xtext.resource.IResourceDescription.Delta;

import com.google.common.collect.Iterables;
import com.google.common.collect.Maps;
import com.google.inject.Inject;
import com.google.inject.Provider;

/**
 * @author Knut Wannheden - Initial contribution and API
 */
public class DBBasedClusteringBuilderState extends ClusteringBuilderState {

	@Inject
	private Provider<DBBasedBuilderState> builderStateProvider;

	private Map<URI, IResourceDescription> oldDescriptions = Maps.newHashMap();

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
	protected void setResourceDescriptionsData(IResourceDescriptionsData newData) {
		((DBBasedResourceDescriptionsData) newData).commitChanges();
		super.setResourceDescriptionsData(newData);
	}

	@Override
	protected Collection<Delta> doUpdate(BuildData buildData, IResourceDescriptionsData newData,
			IProgressMonitor monitor) {
		try {
			loadToBeBuiltResources(buildData);
			return super.doUpdate(buildData, newData, monitor);
		} finally {
			oldDescriptions.clear();
		}
	}

	// FIXME properly handle old descriptions in DB
	private void loadToBeBuiltResources(BuildData buildData) {
		oldDescriptions.clear();
		for (URI uri : Iterables.concat(buildData.getToBeUpdated(), buildData.getToBeDeleted())) {
			IResourceDescription resourceDescription = getResourceDescription(uri);
			oldDescriptions.put(uri, resourceDescription != null ? new CopiedResourceDescription(resourceDescription) : null);
		}
	}

	@Override
	public IResourceDescription getResourceDescription(URI uri) {
		if (oldDescriptions.containsKey(uri))
			return oldDescriptions.get(uri);
		return super.getResourceDescription(uri);
	}

}
