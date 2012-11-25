/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.common.types.ui.refactoring.participant;

import java.util.Iterator;

import org.eclipse.core.resources.IProject;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.jdt.core.IJavaElement;
import org.eclipse.xtext.common.types.access.IJvmTypeProvider;
import org.eclipse.xtext.common.types.access.jdt.TypeURIHelper;
import org.eclipse.xtext.naming.IQualifiedNameProvider;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.resource.IResourceDescription;
import org.eclipse.xtext.resource.IResourceDescriptions;
import org.eclipse.xtext.util.Strings;

import com.google.inject.Inject;

/**
 * Helps to resolve {@link JvmIdentifiableElement}s corresponding to {@link IJavaElement}s.
 * 
 * @author Jan Koehnlein - Initial contribution and API
 */
public class JvmElementFinder {

	@Inject
	private IJvmTypeProvider.Factory typeProviderFactory;

	@Inject
	private TypeURIHelper typeURIHelper;

	@Inject
	private IResourceDescriptions resourceDescriptions;

	@Inject
	private IQualifiedNameProvider qualifiedNameProvider;

	public EObject getCorrespondingJvmElement(IJavaElement javaElement, ResourceSet resourceSet) {
		typeProviderFactory.findOrCreateTypeProvider(resourceSet);
		URI jvmElementURI = typeURIHelper.getFullURI(javaElement);
		return (jvmElementURI != null) ? resourceSet.getEObject(jvmElementURI, true) : null;
	}

	public EObject findJvmElementDeclarationInIndex(EObject jvmElement, IProject project, ResourceSet resourceSet) {
		// TODO lookup top level type container in index instead? 
		QualifiedName qualifiedName = qualifiedNameProvider.getFullyQualifiedName(jvmElement);
		if (qualifiedName != null) {
			for (IResourceDescription resourceDescription : resourceDescriptions.getAllResourceDescriptions()) {
				if (resourceDescription.getURI().isPlatformResource()
						&& Strings.equal(project.getName(), resourceDescription.getURI().segment(1))) {
					Iterator<IEObjectDescription> matches = resourceDescription.getExportedObjects(jvmElement.eClass(),
							qualifiedName, true).iterator();
					if(matches.hasNext()) {
						URI eObjectURI = matches.next().getEObjectURI();
						return resourceSet.getEObject(eObjectURI, true);
					}
				}
			}
		}
		return null;
	}
	
	
}
