/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.tests.typesystem

import com.google.inject.Inject
import org.eclipse.xtext.junit4.InjectWith
import org.eclipse.xtext.junit4.XtextRunner
import org.eclipse.xtext.xbase.XBlockExpression
import org.eclipse.xtext.xbase.XExpression
import org.eclipse.xtext.xbase.XMemberFeatureCall
import org.eclipse.xtext.xbase.XNullLiteral
import org.eclipse.xtext.xbase.junit.typesystem.PublicReentrantTypeResolver
import org.eclipse.xtext.xbase.junit.typesystem.PublicResolvedTypes
import org.eclipse.xtext.xbase.lib.util.ReflectExtensions
import org.eclipse.xtext.xbase.tests.AbstractXbaseTestCase
import org.eclipse.xtext.xbase.typesystem.computation.ITypeComputationState
import org.eclipse.xtext.xbase.typesystem.computation.ITypeComputer
import org.eclipse.xtext.xbase.typesystem.internal.ExpressionTypeComputationState
import org.eclipse.xtext.xbase.typesystem.internal.ResolvedTypes
import org.eclipse.xtext.xbase.typesystem.internal.RootExpressionComputationState
import org.eclipse.xtext.xbase.typesystem.references.AnyTypeReference
import org.junit.Ignore
import org.junit.Test
import org.junit.runner.RunWith

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@RunWith(typeof(XtextRunner))
@InjectWith(typeof(XbaseNewTypeSystemInjectorProvider))
class TypeComputationStateTest extends AbstractXbaseTestCase implements ITypeComputer {
		
	@Inject PublicReentrantTypeResolver resolver
	
	@Inject extension ReflectExtensions
	
	@Test
	def void testChildrenAddEntryForParent() {
		resolver.typeComputer = this 
		val expression = expression("{ null }")
		val resolution = new PublicResolvedTypes(resolver)
		val any = new AnyTypeReference(resolution.getReferenceOwner())
		new RootExpressionComputationState(resolution, resolver.batchScopeProvider.newSession(expression.eResource), expression, resolver, any).computeTypes
		assertEquals(any.toString, resolution.getActualType(expression).toString)
		assertEquals(any.toString, resolution.getActualType(expression.eContents.head as XNullLiteral).toString)
	}
	
	@Test
	def void testTypeOnlyRegisteredOnce_01() {
		resolver.typeComputer = this 
		val expression = expression("{ null }")
		val resolution = new PublicResolvedTypes(resolver)
		val any = new AnyTypeReference(resolution.getReferenceOwner())
		new RootExpressionComputationState(resolution, resolver.batchScopeProvider.newSession(expression.eResource), expression, resolver, any).computeTypes
		val expressionTypes = resolution.basicGetExpressionTypes
		val typesForNullLiteral = expressionTypes.get((expression as XBlockExpression).expressions.head)
		assertEquals(typesForNullLiteral.toString, 1, typesForNullLiteral.filter[ returnType ].size)
		assertEquals(typesForNullLiteral.toString, 1, typesForNullLiteral.filter[ !returnType ].size)
		val typesForBlock = expressionTypes.get(expression)
		assertEquals(typesForBlock.toString, 1, typesForBlock.filter[ returnType ].size)
		assertEquals(typesForBlock.toString, 1, typesForBlock.filter[ !returnType ].size)
	}

	@Test
	def void testTypeOnlyRegisteredOnce_02() {
		val expression = expression("1.toString") as XMemberFeatureCall
		resolver.initializeFrom(expression)
		val resolution = new PublicResolvedTypes(resolver)
		val any = new AnyTypeReference(resolution.getReferenceOwner())
		new RootExpressionComputationState(resolution, resolver.batchScopeProvider.newSession(expression.eResource), expression, resolver, any).computeTypes
		val expressionTypes = resolution.basicGetExpressionTypes
		expression.eAllContents.forEach [
			val types = expressionTypes.get(it as XExpression)
//			assertEquals(types.toString, 1, types.filter[ returnType ].size)
			assertEquals(types.toString, 1, types.filter[ !returnType ].size)
		]
	}
	
	@Ignore("TODO FixMe")
	@Test
	def void testTypeOnlyRegisteredOnce_03() {
		val expression = expression("<String>newArrayList.map[toUpperCase]") as XMemberFeatureCall
		resolver.initializeFrom(expression)
		val resolution = new PublicResolvedTypes(resolver)
		val any = new AnyTypeReference(resolution.getReferenceOwner())
		new RootExpressionComputationState(resolution, resolver.batchScopeProvider.newSession(expression.eResource), expression, resolver, any).computeTypes
		val expressionTypes = resolution.basicGetExpressionTypes
		expression.eAllContents.forEach [
			val typesForMemberFeatureCall = expressionTypes.get(it as XExpression)
			assertEquals(it + " " + typesForMemberFeatureCall.toString, 1, typesForMemberFeatureCall.filter[ returnType ].size)
			assertEquals(typesForMemberFeatureCall.toString, 1, typesForMemberFeatureCall.filter[ !returnType ].size)
		]
	}
	
	override computeTypes(XExpression expression, ITypeComputationState state) {
		assertTrue("state is instanceof ExpressionTypeComputationState", state instanceof ExpressionTypeComputationState)
		val expectedType = state.getExpectations.head.getExpectedType
		if (expression instanceof XNullLiteral) {
			val casted = state as ExpressionTypeComputationState
			val resolution = casted.<ResolvedTypes>get("resolvedTypes")
			val parentResolution = casted.<ExpressionTypeComputationState>get("parent").<ResolvedTypes>get("resolvedTypes")
			assertNull(parentResolution.getActualType(expression.eContainer as XExpression))
			state.acceptActualType(expectedType)
			assertNull(parentResolution.getActualType(expression))
			assertEquals(expectedType.identifier, resolution.getActualType(expression).identifier)
			assertNull(parentResolution.getActualType(expression.eContainer as XExpression))
		} else {
			assertTrue(expression instanceof XBlockExpression)
			val nullLiteral = expression.eContents.head as XNullLiteral
			state.computeTypes(nullLiteral)
			val resolution = state.<ResolvedTypes>get("resolvedTypes")
			assertEquals(expectedType.identifier, resolution.getActualType(nullLiteral).identifier)
		}
	}
	
}
