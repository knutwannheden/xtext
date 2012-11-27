/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.builder.builderState.db;

import java.util.List;

import org.eclipse.xtext.naming.IQualifiedNameConverter;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.util.Strings;

import com.google.common.base.CharMatcher;
import com.google.common.collect.Lists;

/**
 * @author Knut Wannheden - Initial contribution and API
 */
public class DBQualifiedNameConverter implements IQualifiedNameConverter {

	private static final char DOT = '.';
	private static final char ENCODED_DOT = 0xb7; // (middle dot)

	private final CharMatcher segmentEncoder = CharMatcher.is(DOT);
	private final CharMatcher segmentDecoder = CharMatcher.is(ENCODED_DOT);

	public String toString(QualifiedName name) {
		if (name == null)
			throw new IllegalArgumentException("Qualified name cannot be null");

		if (name.getSegmentCount() == 1)
			return name.getFirstSegment();

		StringBuilder builder = new StringBuilder();
		boolean isFirst = true;
		for (String segment : name.getSegments()) {
			if (!isFirst)
				builder.append(DOT);
			isFirst = false;
			builder.append(segmentEncoder.replaceFrom(segment, ENCODED_DOT));
		}
		return builder.toString();
	}

	public QualifiedName toQualifiedName(String qualifiedNameAsText) {
		if (qualifiedNameAsText == null)
			throw new IllegalArgumentException("Qualified name cannot be null");

		List<String> encodedSegments = Strings.split(qualifiedNameAsText, DOT);
		List<String> segments = Lists.newArrayListWithCapacity(encodedSegments.size());
		for (String seg : encodedSegments) {
			segments.add(segmentDecoder.replaceFrom(seg, DOT));
		}
		return QualifiedName.create(segments.toArray(new String[segments.size()]));
	}

}
