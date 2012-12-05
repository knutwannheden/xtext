/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.typesystem.util;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.xbase.typing.IJvmTypeReferenceProvider;
import org.eclipse.xtext.xtype.impl.XComputedTypeReferenceImplCustom;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 * TODO JavaDoc, toString
 */
public abstract class AbstractReentrantTypeReferenceProvider implements IJvmTypeReferenceProvider {

	private boolean computing = false;

	public final JvmTypeReference getTypeReference(@NonNull XComputedTypeReferenceImplCustom context) {
		if (computing)
			return handleReentrantInvocation(context);
		try {
			computing = true;
			return doGetTypeReference(context);
		} finally {
			computing = false;
		}
	}
	
	protected JvmTypeReference handleReentrantInvocation(@NonNull XComputedTypeReferenceImplCustom context) {
		return null;
	}

	protected abstract JvmTypeReference doGetTypeReference(@NonNull XComputedTypeReferenceImplCustom context);
}
