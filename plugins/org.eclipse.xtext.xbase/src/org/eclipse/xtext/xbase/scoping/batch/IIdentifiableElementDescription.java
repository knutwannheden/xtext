/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.scoping.batch;

import java.util.Map;

import org.eclipse.jdt.annotation.NonNullByDefault;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.xtext.common.types.JvmIdentifiableElement;
import org.eclipse.xtext.common.types.JvmTypeParameter;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.typesystem.references.LightweightMergedBoundTypeArgument;
import org.eclipse.xtext.xbase.typesystem.references.LightweightTypeReference;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 * TODO JavaDoc
 */
@NonNullByDefault
public interface IIdentifiableElementDescription extends IEObjectDescription {

	JvmIdentifiableElement getElementOrProxy();
	
	String getShadowingKey();
	
	int getBucketId();

	@Nullable
	LightweightTypeReference getImplicitReceiverType();

	@Nullable
	XExpression getImplicitReceiver();
	
	Map<JvmTypeParameter, LightweightMergedBoundTypeArgument> getImplicitReceiverTypeParameterMapping();
	
	@Nullable
	LightweightTypeReference getSyntacticReceiverType();
	
	@Nullable
	XExpression getSyntacticReceiver();
	
	Map<JvmTypeParameter, LightweightMergedBoundTypeArgument> getSyntacticReceiverTypeParameterMapping();
	
	@Nullable
	XExpression getImplicitFirstArgument();
	
	@Nullable
	LightweightTypeReference getImplicitFirstArgumentType();
	
	Map<JvmTypeParameter, LightweightMergedBoundTypeArgument> getImplicitFirstArgumentTypeParameterMapping();
	
	boolean isVisible();

	boolean isStatic();
	
	boolean isExtension();
	
}
