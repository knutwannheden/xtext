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
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.util.EcoreUtil;

/**
 * @author Knut Wannheden - Initial contribution and API
 */
public class EClasses {

	  public static EClass getEClass(final URI uri) {
	    EPackage ePackage = EPackage.Registry.INSTANCE.getEPackage(uri.trimFragment().toString());
	    if (ePackage != null) {
	      if (ePackage.eResource() != null) {
	        return (EClass) ePackage.eResource().getEObject(uri.fragment());
	      }
	      for (EClassifier eClassifier : ePackage.getEClassifiers()) {
	        if (EcoreUtil.getURI(eClassifier).equals(uri) && eClassifier instanceof EClass) {
	          return (EClass) eClassifier;
	        }
	      }
	    }
	    return null;
	  }

	  public static EReference getEReference(final URI uri) {
	    EPackage ePackage = EPackage.Registry.INSTANCE.getEPackage(uri.trimFragment().toString());
	    if (ePackage == null) {
	      return null;
	    }
	    if (ePackage.eResource() != null) {
	      EObject eObject = ePackage.eResource().getEObject(uri.fragment());
	      return eObject instanceof EReference ? (EReference) eObject : null; // NOPMD Null assignment
	    }
	    for (EClassifier eClassifier : ePackage.getEClassifiers()) {
	      if (eClassifier instanceof EClass) {
	        for (EReference ref : ((EClass) eClassifier).getEReferences()) {
	          if (EcoreUtil.getURI(ref).equals(uri)) {
	            return ref;
	          }
	        }
	      }
	    }
	    return null;
	  }

}
