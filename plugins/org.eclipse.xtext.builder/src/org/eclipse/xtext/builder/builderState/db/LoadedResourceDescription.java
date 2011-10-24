/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.builder.builderState.db;

import java.util.List;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.resource.IReferenceDescription;
import org.eclipse.xtext.resource.IResourceDescription;
import org.eclipse.xtext.resource.impl.EObjectDescriptionLookUp;

import com.google.common.collect.Lists;

/**
 * @author Knut Wannheden - Initial contribution and API
 */
public class LoadedResourceDescription implements IResourceDescription {

	  private final URI uri;

	  private EObjectDescriptionLookUp lookUp;
	  private List<IEObjectDescription> exportedObjects;

	  private List<QualifiedName> importedNames;
	  private List<IReferenceDescription> referenceDescriptions;

	  public LoadedResourceDescription(final URI uri) {
	    this.uri = uri;
	  }

	  public URI getURI() {
	    return uri;
	  }

	  public boolean isEmpty() {
	    return getLookUp().isEmpty();
	  }

	  public Iterable<IEObjectDescription> getExportedObjects(final EClass type, final QualifiedName name, final boolean ignoreCase) {
	    return getLookUp().getExportedObjects(type, name, ignoreCase);
	  }

	  public Iterable<IEObjectDescription> getExportedObjectsByType(final EClass type) {
	    return getLookUp().getExportedObjectsByType(type);
	  }

	  public Iterable<IEObjectDescription> getExportedObjectsByObject(final EObject object) {
	    return getLookUp().getExportedObjectsByObject(object);
	  }

	  public List<IEObjectDescription> getExportedObjects() {
	    if (exportedObjects == null) {
	      exportedObjects = Lists.newArrayList();
	    }
	    return exportedObjects;
	  }

	  public List<QualifiedName> getImportedNames() {
	    if (importedNames == null) {
	      importedNames = Lists.newArrayList();
	    }
	    return importedNames;
	  }

	  public List<IReferenceDescription> getReferenceDescriptions() {
	    if (referenceDescriptions == null) {
	      referenceDescriptions = Lists.newArrayList();
	    }
	    return referenceDescriptions;
	  }

	  private EObjectDescriptionLookUp getLookUp() {
	    if (lookUp == null) {
	      lookUp = new EObjectDescriptionLookUp(getExportedObjects());
	    }
	    return lookUp;
	  }

}
