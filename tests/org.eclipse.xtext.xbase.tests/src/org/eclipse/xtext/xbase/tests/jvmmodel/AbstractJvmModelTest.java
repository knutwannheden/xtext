/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.tests.jvmmodel;

import org.eclipse.xtext.junit4.InjectWith;
import org.eclipse.xtext.junit4.XtextRunner;
import org.eclipse.xtext.xbase.XbaseStandaloneSetup;
import org.eclipse.xtext.xbase.jvmmodel.IJvmModelInferrer;
import org.eclipse.xtext.xbase.tests.AbstractXbaseTestCase;
import org.eclipse.xtext.xbase.tests.XbaseInjectorProvider;
import org.junit.runner.RunWith;

import com.google.inject.Guice;
import com.google.inject.Injector;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
@InjectWith(AbstractJvmModelTest.SimpleJvmModelTestInjectorProvider.class)
@RunWith(XtextRunner.class)
public abstract class AbstractJvmModelTest extends AbstractXbaseTestCase {

	public static class SimpleJvmModelTestInjectorProvider extends XbaseInjectorProvider {
		@Override
		protected Injector internalCreateInjector() {
			return new SimpleJvmModelTestStandaloneSetup().createInjectorAndDoEMFRegistration();
		}

		public static class SimpleJvmModelTestStandaloneSetup extends XbaseStandaloneSetup {
			@Override
			public Injector createInjector() {
				return Guice.createInjector(new XbaseTestRuntimeModule() {
					@Override
					public void configure(com.google.inject.Binder binder) {
						super.configure(binder);
						binder.bind(IJvmModelInferrer.class).to(SimpleJvmModelInferrer.class);
					}
				});
			}
		}
		
	}
	
}
