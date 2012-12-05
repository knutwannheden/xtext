/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.typesystem.internal;

import java.util.EnumSet;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jdt.annotation.NonNullByDefault;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.xtext.common.types.JvmIdentifiableElement;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.typesystem.computation.ITypeComputationResult;
import org.eclipse.xtext.xbase.typesystem.conformance.ConformanceHint;
import org.eclipse.xtext.xbase.typesystem.references.AnyTypeReference;
import org.eclipse.xtext.xbase.typesystem.references.ITypeReferenceOwner;
import org.eclipse.xtext.xbase.typesystem.references.LightweightTypeReference;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 * TODO JavaDoc, toString
 */
@NonNullByDefault
public class NoTypeResult implements ITypeComputationResult {

	private EObject context;
	private ITypeReferenceOwner owner;

	public NoTypeResult(@Nullable EObject context, ITypeReferenceOwner owner) {
		this.context = context;
		this.owner = owner;
	}
	
	public LightweightTypeReference getReturnType() {
		return new AnyTypeReference(owner);
	}
	
	@Nullable
	public XExpression getExpression() {
		return null;
	}
	
	public LightweightTypeReference getActualExpressionType() {
		throw new UnsupportedOperationException("TODO implement me");
	}
	
	public LightweightTypeReference getExpectedExpressionType() {
		throw new UnsupportedOperationException("TODO implement me");
	}

	public LightweightTypeReference getActualType(@Nullable JvmIdentifiableElement element) {
		throw new UnsupportedOperationException("TODO implement me");
	}
	
	public EnumSet<ConformanceHint> getConformanceHints() {
		throw new UnsupportedOperationException("TODO implement me");
	}
	
	@Override
	public String toString() {
		return String.format("No result in context of %s", String.valueOf(context));
	}

}
