/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.validation;

/**
 * @author Dennis Huebner - Initial contribution and API
 * @since 2.4
 */
public class IssueCode {

	private final String code;

	public final static String SEVERITY_ERROR = "error";

	public IssueCode(String code) {
		this.code = code;
	}

	public String getCode() {
		return code;
	}

	public String getDefaultSeverity() {
		return SEVERITY_ERROR;
	}
	
	public boolean isDerived() {
		return false;
	}
}