/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.typesystem.util;

import java.util.Map;

import org.eclipse.jdt.annotation.NonNullByDefault;
import org.eclipse.xtext.common.types.JvmTypeParameter;
import org.eclipse.xtext.xbase.typesystem.references.ITypeReferenceOwner;
import org.eclipse.xtext.xbase.typesystem.references.LightweightMergedBoundTypeArgument;
import org.eclipse.xtext.xbase.typesystem.references.LightweightTypeReference;
import org.eclipse.xtext.xbase.typesystem.references.ParameterizedTypeReference;
import org.eclipse.xtext.xbase.typesystem.references.UnboundTypeReference;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 * TODO JavaDoc, toString
 */
@NonNullByDefault
public abstract class TypeParameterByUnboundSubstitutor extends CustomTypeParameterSubstitutor {

	public TypeParameterByUnboundSubstitutor(Map<JvmTypeParameter, LightweightMergedBoundTypeArgument> typeParameterMapping,
			ITypeReferenceOwner owner) {
		super(typeParameterMapping, owner);
	}
	
	@Override
	public LightweightTypeReference doVisitUnboundTypeReference(UnboundTypeReference reference, ConstraintVisitingInfo param) {
		return copy(reference);
	}
	
	@Override
	protected LightweightTypeReference getUnmappedSubstitute(ParameterizedTypeReference reference, JvmTypeParameter type, ConstraintVisitingInfo visiting) {
		UnboundTypeReference result = createUnboundTypeReference(type);
		return result;
	}
	
	protected abstract UnboundTypeReference createUnboundTypeReference(JvmTypeParameter type);
	
}
