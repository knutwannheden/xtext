/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.resource;

import static com.google.common.collect.Lists.*;

import java.util.Collection;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.resource.IResourceDescription.Delta;
import org.eclipse.xtext.resource.impl.DefaultResourceDescriptionDelta;
import org.eclipse.xtext.resource.impl.DefaultResourceDescriptionManager;

import com.google.common.base.Predicate;
import com.google.common.collect.Collections2;

/**
 * 
 * Installs the derived state in non-linking mode and discards it right after {@link EObjectDescription} creation.
 * 
 * @author Sven Efftinge - Initial contribution and API
 * @since 2.1
 */
public class DerivedStateAwareResourceDescriptionManager extends DefaultResourceDescriptionManager {

	@Override
	protected IResourceDescription internalGetResourceDescription(final Resource resource,
			IDefaultResourceDescriptionStrategy strategy) {
		DerivedStateAwareResource res = (DerivedStateAwareResource) resource;
		boolean isInitialized = res.fullyInitialized || res.isInitializing;
		try {
			if (!isInitialized) {
				res.eSetDeliver(false);
				res.installDerivedState(true);
			}
			IResourceDescription description = super.internalGetResourceDescription(resource, strategy);
			if (!isInitialized) {
				// make sure the eobject descriptions are being built.
				newArrayList(description.getExportedObjects());
			}
			return description;
		} finally {
			if (!isInitialized) {
				res.discardDerivedState();
				res.eSetDeliver(true);
			}
		}
	}

	// FIXME required because NameBasedEObjectDescription#getEObjectURI() throws an exception
	@Override
	public Collection<URI> getAffectedResources(final Collection<Delta> deltas, Collection<URI> candidates,
			final IResourceDescriptionsExtension context) {
		return Collections2.filter(candidates, new Predicate<URI>(){
			public boolean apply(URI input) {
				return isAffected(deltas, ((IResourceDescriptions) context).getResourceDescription(input), (IResourceDescriptions) context);
			}});
	}

}
