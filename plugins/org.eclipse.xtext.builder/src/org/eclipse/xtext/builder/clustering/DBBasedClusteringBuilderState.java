/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.builder.clustering;

import org.eclipse.xtext.builder.builderState.IResourceDescriptionsData;
import org.eclipse.xtext.builder.builderState.db.DBBasedBuilderState;
import org.eclipse.xtext.builder.builderState.db.DBBasedResourceDescriptionsData;

import com.google.inject.Inject;
import com.google.inject.Provider;

/**
 * @author Knut Wannheden - Initial contribution and API
 */
public class DBBasedClusteringBuilderState extends ClusteringBuilderState {

	@Inject
	private Provider<DBBasedBuilderState> builderStateProvider;

	@Override
	public synchronized void load() {
		setResourceDescriptionsData(new DBBasedResourceDescriptionsData(builderStateProvider.get()));
	}

	@Override
	protected IResourceDescriptionsData getCopiedResourceDescriptionsData() {
		IResourceDescriptionsData result = super.getCopiedResourceDescriptionsData();
		((DBBasedResourceDescriptionsData) result).beginChanges();
		return result;
	}

	@Override
	protected void setResourceDescriptionsData(IResourceDescriptionsData newData) {
		((DBBasedResourceDescriptionsData) newData).commitChanges();
		super.setResourceDescriptionsData(newData);
	}

}
