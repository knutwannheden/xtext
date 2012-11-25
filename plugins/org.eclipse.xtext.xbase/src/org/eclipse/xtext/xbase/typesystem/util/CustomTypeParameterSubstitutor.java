/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.typesystem.util;

import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jdt.annotation.NonNullByDefault;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.common.types.JvmTypeConstraint;
import org.eclipse.xtext.common.types.JvmTypeParameter;
import org.eclipse.xtext.common.types.JvmTypeParameterDeclarator;
import org.eclipse.xtext.common.types.JvmUpperBound;
import org.eclipse.xtext.xbase.typesystem.references.ArrayTypeReference;
import org.eclipse.xtext.xbase.typesystem.references.ITypeReferenceOwner;
import org.eclipse.xtext.xbase.typesystem.references.LightweightMergedBoundTypeArgument;
import org.eclipse.xtext.xbase.typesystem.references.LightweightTypeReference;
import org.eclipse.xtext.xbase.typesystem.references.OwnedConverter;
import org.eclipse.xtext.xbase.typesystem.references.ParameterizedTypeReference;
import org.eclipse.xtext.xbase.typesystem.references.UnboundTypeReference;
import org.eclipse.xtext.xbase.typesystem.references.WildcardTypeReference;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@NonNullByDefault
public abstract class CustomTypeParameterSubstitutor extends TypeParameterSubstitutor<ConstraintVisitingInfo> {

	protected CustomTypeParameterSubstitutor(Map<JvmTypeParameter, LightweightMergedBoundTypeArgument> typeParameterMapping,
			ITypeReferenceOwner owner) {
		super(typeParameterMapping, owner);
	}
	
	@Override
	public LightweightTypeReference doVisitParameterizedTypeReference(ParameterizedTypeReference reference, ConstraintVisitingInfo visiting) {
		if (reference.isResolved() && reference.isOwnedBy(getOwner()))
			return reference;
		JvmType type = reference.getType();
		if (type instanceof JvmTypeParameter) {
			JvmTypeParameter typeParameter = (JvmTypeParameter) type;
			if (!visiting.tryVisit(typeParameter)) {
				LightweightTypeReference mappedReference = getDeclaredUpperBound(visiting.getCurrentDeclarator(), visiting.getCurrentIndex(), visiting);
				getTypeParameterMapping().put((JvmTypeParameter)type, new LightweightMergedBoundTypeArgument(mappedReference, VarianceInfo.INVARIANT));
				return mappedReference;
			}
			try {
				LightweightMergedBoundTypeArgument boundTypeArgument = getTypeParameterMapping().get(type);
				if (boundTypeArgument != null && boundTypeArgument.getTypeReference() != reference) {
					LightweightTypeReference result = boundTypeArgument.getTypeReference().accept(this, visiting);
					if (boundTypeArgument.getVariance() == VarianceInfo.OUT) {
						WildcardTypeReference wildcard = new WildcardTypeReference(getOwner());
						wildcard.addUpperBound(result);
						result = wildcard;
					} else if (boundTypeArgument.getVariance() == VarianceInfo.IN) {
						WildcardTypeReference wildcard = new WildcardTypeReference(getOwner());
						JvmType objectType = getOwner().getServices().getTypeReferences().findDeclaredType(Object.class, type);
						wildcard.addUpperBound(new ParameterizedTypeReference(getOwner(), objectType));
						wildcard.setLowerBound(result);
						result = wildcard;
					}
					return result;
				} else {
					LightweightTypeReference mappedReference = getUnmappedSubstitute(reference, (JvmTypeParameter) type, visiting);
					if (mappedReference != null) {
						getTypeParameterMapping().put((JvmTypeParameter)type, new LightweightMergedBoundTypeArgument(mappedReference, VarianceInfo.INVARIANT));
						return mappedReference;
					}
				}
			} finally {
				visiting.didVisit(typeParameter);
			}
		}
		ParameterizedTypeReference result = new ParameterizedTypeReference(getOwner(), type);
		for(int i = 0; i < reference.getTypeArguments().size(); i++) {
			LightweightTypeReference argument = reference.getTypeArguments().get(i);
			visiting.pushInfo(type instanceof JvmTypeParameterDeclarator ? (JvmTypeParameterDeclarator) type : null, i);
			LightweightTypeReference visitedArgument = argument.accept(this, visiting);
			result.addTypeArgument(visitedArgument);
		}
		return result;
	}
	
	@Nullable
	protected abstract LightweightTypeReference getUnmappedSubstitute(ParameterizedTypeReference reference, JvmTypeParameter type, ConstraintVisitingInfo visiting);
	
	protected LightweightTypeReference getDeclaredUpperBound(JvmTypeParameterDeclarator type, int parameterIndex, ConstraintVisitingInfo visiting) {
		if (type.getTypeParameters().size() > parameterIndex) {
			JvmTypeParameter typeParameter = type.getTypeParameters().get(parameterIndex);
			LightweightTypeReference result = getDeclaredUpperBound(typeParameter, visiting);
			if (result != null)
				return result;
		}
		return getObjectReference(type);
	}

	protected LightweightTypeReference getObjectReference(EObject context) {
		JvmType objectType = getOwner().getServices().getTypeReferences().findDeclaredType(Object.class, context);
		return new ParameterizedTypeReference(getOwner(), objectType);
	}

	@Nullable
	protected LightweightTypeReference getDeclaredUpperBound(JvmTypeParameter typeParameter, ConstraintVisitingInfo visiting) {
		if (!typeParameter.getConstraints().isEmpty()) {
			JvmTypeConstraint constraint = typeParameter.getConstraints().get(0);
			if (constraint instanceof JvmUpperBound) {
				LightweightTypeReference reference = new OwnedConverter(getOwner()).toLightweightReference(constraint.getTypeReference());
				return reference.accept(this, visiting);
			}
		}
		return null;
	}
	
	@Override
	public LightweightTypeReference substitute(LightweightTypeReference original) {
		if (original instanceof ArrayTypeReference) {
			LightweightTypeReference componentType = original.getComponentType();
			if (componentType instanceof UnboundTypeReference) {
				LightweightTypeReference substitutedComponentType = substitute(componentType);
				return new ArrayTypeReference(getOwner(), substitutedComponentType);
			}
		}
		if (original instanceof UnboundTypeReference) {
			ConstraintVisitingInfo visitingInfo = createVisiting();
			JvmTypeParameter typeParameter = ((UnboundTypeReference) original).getTypeParameter();
			JvmTypeParameterDeclarator declarator = typeParameter.getDeclarator();
			visitingInfo.pushInfo(declarator, declarator.getTypeParameters().indexOf(typeParameter));
			LightweightTypeReference result = original.accept(this, visitingInfo);
			return result;
		} else {
			LightweightTypeReference result = original.accept(this, createVisiting());
			return result;
		}
	}
	
	@Override
	protected ConstraintVisitingInfo createVisiting() {
		return new ConstraintVisitingInfo();
	}
}
