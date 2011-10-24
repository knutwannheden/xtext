/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.builder.builderState.db;

import com.google.inject.Provider;

/**
 * @author Knut Wannheden - Initial contribution and API
 */
public class DBBasedBuilderStateProvider implements Provider<DBBasedBuilderState> {

	public DBBasedBuilderState get() {
		return new DBBasedBuilderState(System.getProperty("user.dir") + "/h2",
				DBBasedBuilderState.DEFAULT_H2_CONFIGURATION);
	}

}
