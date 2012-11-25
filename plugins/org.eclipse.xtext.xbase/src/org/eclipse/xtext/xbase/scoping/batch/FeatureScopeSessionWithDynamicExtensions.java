/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.scoping.batch;

import java.util.List;

import org.eclipse.xtext.xbase.XExpression;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class FeatureScopeSessionWithDynamicExtensions extends AbstractNestedFeatureScopeSession {

	private final List<XExpression> extensionProviders;

	public FeatureScopeSessionWithDynamicExtensions(AbstractFeatureScopeSession parent,
			List<XExpression> extensionProviders) {
		super(parent);
		this.extensionProviders = extensionProviders;
	}

}
