/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.typesystem.internal;

import java.util.List;

import org.eclipse.jdt.annotation.NonNullByDefault;
import org.eclipse.xtext.common.types.JvmIdentifiableElement;
import org.eclipse.xtext.common.types.JvmTypeParameter;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.typesystem.computation.ILinkingCandidate;
import org.eclipse.xtext.xbase.typesystem.references.LightweightBoundTypeArgument;
import org.eclipse.xtext.xbase.typesystem.references.LightweightTypeReference;
import org.eclipse.xtext.xbase.typesystem.references.OwnedConverter;
import org.eclipse.xtext.xbase.typesystem.references.UnboundTypeReference;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 * TODO JavaDoc, toString - delegates to parent except for the reassigned types
 */
@NonNullByDefault
public class ReassigningStackedResolvedTypes extends StackedResolvedTypes {
	
	protected ReassigningStackedResolvedTypes(ResolvedTypes parent) {
		super(parent);
	}
	
	@Override
	public void acceptLinkingInformation(XExpression expression, ILinkingCandidate candidate) {
		getParent().acceptLinkingInformation(expression, candidate);
	}
	
	@Override
	protected OwnedConverter getConverter() {
		return getParent().getConverter();
	}
	
	@Override
	protected void acceptType(XExpression expression, TypeData typeData) {
		getParent().acceptType(expression, typeData);
	}

	@Override
	public void setType(JvmIdentifiableElement identifiable, LightweightTypeReference reference) {
		getParent().setType(identifiable, reference);
	}

	@Override
	public void acceptHint(Object handle, LightweightBoundTypeArgument boundTypeArgument) {
		getParent().acceptHint(handle, boundTypeArgument);
	}
	
	@Override
	protected void acceptUnboundTypeReference(Object handle, UnboundTypeReference reference) {
		getParent().acceptUnboundTypeReference(handle, reference);
	}
	
	@Override
	public List<LightweightBoundTypeArgument> getAllHints(Object handle) {
		return getParent().getAllHints(handle);
	}
	
	@Override
	protected void mergeInto(ResolvedTypes parent) {
		throw new UnsupportedOperationException("Should not be invoked");
	}
	
	@Override
	protected UnboundTypeReference createUnboundTypeReference(XExpression expression,
			JvmTypeParameter type) {
		throw new UnsupportedOperationException("Should not be invoked");
	}
	
	@Override
	protected void mergeIntoParent() {
		throw new UnsupportedOperationException("Should not be invoked");
	}
	
	@Override
	protected void performMergeIntoParent() {
		throw new UnsupportedOperationException("Should not be invoked");
	}
	
	@Override
	protected void prepareMergeIntoParent() {
		throw new UnsupportedOperationException("Should not be invoked");
	}
}