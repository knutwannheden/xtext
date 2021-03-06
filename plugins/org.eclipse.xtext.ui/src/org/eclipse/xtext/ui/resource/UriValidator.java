/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.resource;

import org.eclipse.core.resources.IStorage;
import org.eclipse.core.runtime.IPath;
import org.eclipse.emf.common.util.URI;
import org.eclipse.xtext.resource.IResourceServiceProvider;

import com.google.inject.Inject;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
public class UriValidator {
	
	@Inject
	private IResourceServiceProvider.Registry registry = IResourceServiceProvider.Registry.INSTANCE;

	public boolean isValid(URI uri, IStorage storage) {
		if (uri==null)
			return false;
		IResourceServiceProvider resourceServiceProvider = registry.getResourceServiceProvider(uri);
		if (resourceServiceProvider!=null) {
			if (resourceServiceProvider instanceof IResourceUIServiceProvider) {
				return ((IResourceUIServiceProvider) resourceServiceProvider).canHandle(uri, storage);
			} else {
				return resourceServiceProvider.canHandle(uri);
			}
		}
		return false;
	}
	
	
	/**
	 * @return whether there's possibly an {@link IResourceServiceProvider} for the given storage
	 * @since 2.4
	 */
	public boolean isPossiblyManaged(IStorage storage) {
		IPath fullPath = storage.getFullPath();
		if (fullPath == null)
			return true;
		if (!registry.getContentTypeToFactoryMap().isEmpty())
			return true;
		return registry.getExtensionToFactoryMap().containsKey(fullPath.getFileExtension());
	}

}
