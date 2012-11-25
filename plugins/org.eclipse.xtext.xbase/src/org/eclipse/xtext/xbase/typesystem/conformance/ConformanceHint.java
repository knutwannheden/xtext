/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.typesystem.conformance;

import java.util.EnumSet;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 * TODO document the available conformance hints
 * TODO JavaDoc, toString
 */
public enum ConformanceHint {
	SUCCESS, // is conformant
	INCOMPATIBLE, // is not conformant
	EXCEPTION, // TODO is that one necessary?
	
	SUBTYPE, // specialized data - is subtype
	PRIMITIVE_WIDENING, // 
	BOXING, //
	UNBOXING, // 
	RAWTYPE_CONVERSION, // compared to raw type
	DEMAND_CONVERSION, // function type conversion,
	SYNONYM, // array to list, stringConcat to string
	VAR_ARG, // argument will be wrapped in array
	
	CHECKED, // conformance computed
	UNCHECKED, // nothing computed
	
//	UNDECIDED, // more than one type computed, results should not be merged but the better one should be used
	
	RAW, // only raw conformance computed
	MERGED, // merged from different conformance sets
	EXPECTATION_INDEPENDENT; // does not depend on the expectation
	
	private static ConformanceHint[] shallowCheckedHints = { ConformanceHint.DEMAND_CONVERSION, ConformanceHint.SYNONYM, ConformanceHint.VAR_ARG };
	
	public static int compareHints(EnumSet<ConformanceHint> leftConformance, EnumSet<ConformanceHint> rightConformance) {
		if (leftConformance.contains(ConformanceHint.SUCCESS) != rightConformance.contains(ConformanceHint.SUCCESS)) {
			if (leftConformance.contains(ConformanceHint.SUCCESS))
				return -1;
			return 1;
		}
		if (leftConformance.contains(ConformanceHint.EXCEPTION) != rightConformance.contains(ConformanceHint.EXCEPTION)) {
			if (leftConformance.contains(ConformanceHint.EXCEPTION))
				return 1;
			return -1;
		}
		for(ConformanceHint hint: shallowCheckedHints) {
			boolean leftContains = leftConformance.contains(hint);
			boolean rightContains = rightConformance.contains(hint);
			if (leftContains != rightContains) {
				if (leftContains)
					return 1;
				return -1;
			}
		}
		return 0;
	}
	
	protected int compareByConformanceHint(EnumSet<ConformanceHint> leftConformance, EnumSet<ConformanceHint> rightConformance, ConformanceHint unexpectedHint) {
		boolean leftContains = leftConformance.contains(unexpectedHint);
		boolean rightContains = rightConformance.contains(unexpectedHint);
		if (leftContains != rightContains) {
			if (leftContains)
				return 1;
			return -1;
		}
		return 0;
	}
	
}