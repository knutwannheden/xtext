/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.builder.builderState;

import java.util.Collection;
import java.util.Set;

import org.eclipse.emf.common.util.URI;
import org.eclipse.xtext.resource.IResourceDescription;
import org.eclipse.xtext.resource.IResourceDescriptions;
import org.eclipse.xtext.resource.IResourceDescriptionsExtension;

/**
 * @since 2.3
 * @author Knut Wannheden - Initial contribution and API
 */
public interface IResourceDescriptionsData extends IResourceDescriptions, IResourceDescriptionsExtension {

	Set<URI> getAllURIs();

	IResourceDescriptionsData copy(boolean keepOldState);

	void addDescription(URI uri, IResourceDescription newDescription);

	void removeDescription(URI uri);

	void removeDescriptions(Collection<URI> collection);

}