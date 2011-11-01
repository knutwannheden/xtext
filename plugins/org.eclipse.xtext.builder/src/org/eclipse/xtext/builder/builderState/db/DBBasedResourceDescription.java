/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.builder.builderState.db;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.resource.IReferenceDescription;
import org.eclipse.xtext.resource.IResourceDescription;

/**
 * Resource description implementation delegating all queries to the {@link DBBasedBuilderState index}.
 * 
 * @author Knut Wannheden - Initial contribution and API
 */
public class DBBasedResourceDescription implements IResourceDescription {

	private final DBBasedBuilderState index;
	private final URI uri;

	/**
	 * Creates a new instance tied to the given index.
	 * 
	 * @param index
	 *            index used as a resource to compute contained or related objects.
	 * @param uri
	 *            URI of the actual resource this object describes
	 */
	public DBBasedResourceDescription(final DBBasedBuilderState index, final URI uri) {
		this.index = index;
		this.uri = uri;
	}

	public URI getURI() {
		return uri;
	}

	public boolean isEmpty() {
		return !getExportedObjects().iterator().hasNext();
	}

	public Iterable<IEObjectDescription> getExportedObjects(final EClass type, final QualifiedName name,
			final boolean ignoreCase) {
		return index.getExportedObjects(uri, type, name, ignoreCase);
	}

	public Iterable<IEObjectDescription> getExportedObjectsByType(final EClass type) {
		return index.getExportedObjectsByType(uri, type);
	}

	public Iterable<IEObjectDescription> getExportedObjectsByObject(final EObject object) {
		URI base = EcoreUtil.getURI(object).trimFragment();
		return uri.equals(base) ? index.getExportedObjectsByObject(object) : null;
	}

	public Iterable<IEObjectDescription> getExportedObjects() {
		return index.getExportedObjects(uri);
	}

	public Iterable<QualifiedName> getImportedNames() {
		return index.getImportedNames(uri);
	}

	public Iterable<IReferenceDescription> getReferenceDescriptions() {
		return index.getReferenceDescriptions(uri);
	}

}
