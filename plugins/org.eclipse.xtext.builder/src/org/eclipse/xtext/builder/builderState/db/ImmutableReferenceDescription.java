/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.builder.builderState.db;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.xtext.resource.IReferenceDescription;

/**
 * @author Knut Wannheden - Initial contribution and API
 */
public class ImmutableReferenceDescription implements IReferenceDescription {

	private final URI sourceUri;
	private final URI containerUri;
	private final URI targetUri;
	private final EReference eReference;
	private final int indexInList;

	public ImmutableReferenceDescription(final URI sourceUri, final URI containerUri, final URI targetUri,
			final EReference eReference, final int indexInList) {
		this.sourceUri = sourceUri;
		this.containerUri = containerUri;
		this.targetUri = targetUri;
		this.eReference = eReference;
		this.indexInList = indexInList;
	}

	public static IReferenceDescription copyOf(IReferenceDescription from) {
		return new ImmutableReferenceDescription(from.getSourceEObjectUri(), from.getContainerEObjectURI(),
				from.getTargetEObjectUri(), from.getEReference(), from.getIndexInList());
	}

	public URI getSourceEObjectUri() {
		return sourceUri;
	}

	public URI getContainerEObjectURI() {
		return containerUri;
	}

	public URI getTargetEObjectUri() {
		return targetUri;
	}

	public int getIndexInList() {
		return indexInList;
	}

	public EReference getEReference() {
		return eReference;
	}

}
