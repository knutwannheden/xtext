/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.junit4;

import junit.framework.Assert;

import org.eclipse.emf.ecore.EValidator;
import org.eclipse.xtext.XtextPackage;
import org.eclipse.xtext.junit4.InjectWith;
import org.eclipse.xtext.junit4.XtextRunner;
import org.eclipse.xtext.junit4.parameterized.XtextInjectorProvider;
import org.eclipse.xtext.validation.CompositeEValidator;
import org.eclipse.xtext.xtext.XtextValidator;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
@RunWith(XtextRunner.class)
@InjectWith(XtextInjectorProvider.class)
public class Bug367679Test {
	
	@Test 
	public void testValidatorExists_0() {
		assertValidatorExists();
	}

	@Test 
	public void testValidatorExists_1() {
		assertValidatorExists();
	}

	protected void assertValidatorExists() {
		EValidator eValidator = EValidator.Registry.INSTANCE.getEValidator(XtextPackage.eINSTANCE);
		Assert.assertNotNull(eValidator);
		Assert.assertTrue(eValidator instanceof CompositeEValidator);
	}

}
