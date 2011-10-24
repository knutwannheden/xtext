/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.builder.builderState.db;

/**
 * @author Knut Wannheden - Initial contribution and API
 */
public class DBException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public DBException() {
		super();
	}

	public DBException(final String message) {
		super(message);
	}

	public DBException(final Throwable cause) {
		super(cause);
	}

	public DBException(final String message, final Throwable cause) {
		super(message, cause);
	}
}
