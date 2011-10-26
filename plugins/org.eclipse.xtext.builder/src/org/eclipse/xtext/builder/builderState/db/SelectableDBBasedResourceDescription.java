/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.builder.builderState.db;

import java.util.List;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.resource.ISelectable;
import org.eclipse.xtext.resource.impl.EObjectDescriptionLookUp;

import com.google.common.base.Function;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;

/**
 * @author Knut Wannheden - Initial contribution and API
 */
public class SelectableDBBasedResourceDescription extends DBBasedResourceDescription {

	private List<IEObjectDescription> exportedObjects;
	private EObjectDescriptionLookUp lookUp;

	public SelectableDBBasedResourceDescription(final DBBasedBuilderState index, final URI uri) {
		super(index, uri);
	}

	public SelectableDBBasedResourceDescription(final DBBasedBuilderState index, final URI uri,
			final ISelectable selectable) {
		super(index, uri);
		this.exportedObjects = ImmutableList.copyOf(Iterables.transform(selectable.getExportedObjects(),
				new Function<IEObjectDescription, IEObjectDescription>() {
					public IEObjectDescription apply(IEObjectDescription from) {
						return ImmutableEObjectDescription.copyOf(from);
					}
				}));
	}

	@Override
	public boolean isEmpty() {
		return getLookUp().isEmpty();
	}

	@Override
	public Iterable<IEObjectDescription> getExportedObjects(final EClass type, final QualifiedName name,
			final boolean ignoreCase) {
		return getLookUp().getExportedObjects(type, name, ignoreCase);
	}

	@Override
	public Iterable<IEObjectDescription> getExportedObjectsByType(final EClass type) {
		return getLookUp().getExportedObjectsByType(type);
	}

	@Override
	public Iterable<IEObjectDescription> getExportedObjectsByObject(final EObject object) {
		return getLookUp().getExportedObjectsByObject(object);
	}

	@Override
	public List<IEObjectDescription> getExportedObjects() {
		if (exportedObjects == null) {
			exportedObjects = Lists.newArrayList();
		}
		return exportedObjects;
	}

	private EObjectDescriptionLookUp getLookUp() {
		if (lookUp == null) {
			lookUp = new EObjectDescriptionLookUp(getExportedObjects());
		}
		return lookUp;
	}

}
