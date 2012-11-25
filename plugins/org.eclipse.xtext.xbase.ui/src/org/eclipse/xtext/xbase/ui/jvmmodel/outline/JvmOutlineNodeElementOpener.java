/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.ui.jvmmodel.outline;

import org.apache.log4j.Logger;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IStorage;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jdt.core.IJavaElement;
import org.eclipse.jdt.core.IMember;
import org.eclipse.jdt.core.ISourceRange;
import org.eclipse.xtext.common.types.JvmIdentifiableElement;
import org.eclipse.xtext.common.types.util.jdt.IJavaElementFinder;
import org.eclipse.xtext.generator.trace.ILocationInResource;
import org.eclipse.xtext.generator.trace.ITrace;
import org.eclipse.xtext.generator.trace.ITraceInformation;
import org.eclipse.xtext.ui.editor.GlobalURIEditorOpener;
import org.eclipse.xtext.ui.editor.outline.impl.OutlineNodeElementOpener;
import org.eclipse.xtext.util.TextRegion;

import com.google.inject.Inject;

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
public class JvmOutlineNodeElementOpener extends OutlineNodeElementOpener {

	private static Logger LOG = Logger.getLogger(JvmOutlineNodeElementOpener.class);

	@Inject
	private IJavaElementFinder javaElementFinder;

	@Inject
	private ITraceInformation traceInformation;

	@Inject
	private GlobalURIEditorOpener globalURIEditorOpener;

	@Override
	protected void openEObject(EObject state) {
		try {
			if (state instanceof JvmIdentifiableElement) {
				IJavaElement javaElement = javaElementFinder.findElementFor((JvmIdentifiableElement) state);
				if (javaElement instanceof IMember) {
					IResource resource = javaElement.getResource();
					if (resource instanceof IStorage) {
						ITrace traceToSource = traceInformation.getTraceToSource((IStorage) resource);
						if (traceToSource != null) {
							ISourceRange sourceRange = ((IMember) javaElement).getSourceRange();
							ILocationInResource sourceInformation = traceToSource.getBestAssociatedLocation(new TextRegion(sourceRange.getOffset(), sourceRange.getLength()));
							if (sourceInformation != null) {
								globalURIEditorOpener.open(sourceInformation.getResourceURI(), javaElement, true);
								return;
							}
						}
					}
					globalURIEditorOpener.open(null, javaElement, true);
					return;
				}
			}
		} catch (Exception exc) {
			LOG.error("Error opening java editor", exc);
		}
		super.openEObject(state);
	}

}
