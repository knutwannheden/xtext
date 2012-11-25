/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.typesystem.internal;

import java.util.Map;

import org.eclipse.jdt.annotation.NonNullByDefault;
import org.eclipse.xtext.common.types.JvmIdentifiableElement;
import org.eclipse.xtext.common.types.JvmTypeParameter;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.typesystem.computation.ILinkingCandidate;
import org.eclipse.xtext.xbase.typesystem.references.LightweightMergedBoundTypeArgument;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@NonNullByDefault
public abstract class AbstractResolvedReference<Expression extends XExpression> extends AbstractLinkingCandidate<Expression> {
	
	protected final JvmIdentifiableElement resolvedElement;
	private final Map<JvmTypeParameter, LightweightMergedBoundTypeArgument> typeParameterMapping;
	
	protected AbstractResolvedReference(Expression expression, JvmIdentifiableElement resolvedElement,
			ExpressionTypeComputationState state) {
		super(expression, state);
		this.resolvedElement = resolvedElement;
		this.typeParameterMapping = initializeTypeParameterMapping();
	}

	@Override
	protected Map<JvmTypeParameter, LightweightMergedBoundTypeArgument> getTypeParameterMapping() {
		return typeParameterMapping;
	}

	@Override
	public boolean isPreferredOver(ILinkingCandidate other) {
		return true;
	}
	
	public void resolveLinkingProxy() {
		// nothing to do
	}
	
	@Override
	public JvmIdentifiableElement getFeature() {
		return resolvedElement;
	}
	
	@Override
	public String toString() {
		return getClass().getSimpleName() + " [" + resolvedElement.getIdentifier() + "]";
	}

}
