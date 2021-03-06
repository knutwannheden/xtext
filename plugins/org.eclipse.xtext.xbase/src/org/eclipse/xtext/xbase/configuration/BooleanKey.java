/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.configuration;

import org.apache.log4j.Logger;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
public class BooleanKey extends SingleValueConfigurationKey<Boolean> {

	private static Logger log = Logger.getLogger(BooleanKey.class);

	public BooleanKey(String name, Boolean defaultValue) {
		super(name, defaultValue);
	}

	@Override
	protected Boolean load(String storedValue) {
		try {
			if (storedValue != null && !"".equals(storedValue))
				return Boolean.parseBoolean(storedValue);
		} catch (NumberFormatException e) {
			log.error("error parsing configuration as Boolean. Key:" + getName() + " Value:" + storedValue, e);
		}
		return getDefaultValue();
	}

	@Override
	protected String store(Boolean value) {
		return String.valueOf(value);
	}

}
