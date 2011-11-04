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
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.resource.IEObjectDescription;

/**
 * @author Knut Wannheden - Initial contribution and API
 */
public class ImmutableEObjectDescription implements IEObjectDescription {

	private static final String[] EMPTY_ARRAY = new String[0];

	private final QualifiedName name;
	private final URI uri;
	private final EClass eClass;
	private final Object[] userData;

	public ImmutableEObjectDescription(final QualifiedName name, final URI uri, final EClass eClass,
			final Object[] userData) {
		this.name = name;
		this.uri = uri;
		this.eClass = eClass;
		this.userData = userData;
	}

	public static ImmutableEObjectDescription copyOf(IEObjectDescription obj) {
		return new ImmutableEObjectDescription(obj.getName(), obj.getEObjectURI(), obj.getEClass(),
				getUserDataArray(obj));
	}

	public QualifiedName getName() {
		return name;
	}

	public QualifiedName getQualifiedName() {
		return name;
	}

	public URI getEObjectURI() {
		return uri;
	}

	public EObject getEObjectOrProxy() {
		InternalEObject obj = (InternalEObject) EcoreUtil.create(eClass);
		obj.eSetProxyURI(uri);
		return obj;
	}

	public EClass getEClass() {
		return eClass;
	}

	public String getUserData(final String key) {
		if (userData == null) return null;

		int count = userData.length / 2;
		for (int i = 0; i < count; i++) {
			if (userData[i].equals(key)) {
				return (String) userData[count + i];
			}
		}
		return null;
	}

	public String[] getUserDataKeys() {
		if (userData == null) return EMPTY_ARRAY;

		int count = userData.length / 2;
		String[] keys = new String[count];
		System.arraycopy(userData, 0, keys, 0, count);
		return keys;
	}

	@Override
	public String toString() {
		return "ImmutableEObjectDescription(" + getName().toString() + ")";
	}

	public static Object[] getUserDataArray(final IEObjectDescription obj) {
		String[] keys = obj.getUserDataKeys();
		if (keys.length == 0) return null;

		Object[] result = new String[keys.length * 2];
		for (int i = 0; i < keys.length; i++) {
			result[i] = keys[i];
			result[keys.length + i] = obj.getUserData(keys[i]);
		}
		return result;
	}

}
