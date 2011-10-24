/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.builder.builderState.db;

import org.eclipse.core.runtime.IPath;
import org.eclipse.xtext.builder.internal.Activator;

import com.google.inject.Provider;

/**
 * @author Knut Wannheden - Initial contribution and API
 */
public class DBBasedBuilderStateProvider implements Provider<DBBasedBuilderState> {

	private IPath cachedPath;

	public DBBasedBuilderState get() {
		return new DBBasedBuilderState(getBuilderStateLocation(), DBBasedBuilderState.DEFAULT_H2_CONFIGURATION);
	}

	protected String getBuilderStateLocation() {
		Activator activator = Activator.getDefault();
		if (activator == null) {
			if (cachedPath != null)
				return cachedPath.toFile().getAbsolutePath();
			return null;
		}
		IPath path = activator.getStateLocation().append("state");
		cachedPath = path;
		return path.toFile().getAbsolutePath();
	}

}
