/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.builder.clustering;

import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.builder.builderState.IResourceDescriptionsData;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.resource.IReferenceDescription;
import org.eclipse.xtext.resource.IResourceDescription;
import org.eclipse.xtext.resource.IResourceDescriptions;
import org.eclipse.xtext.resource.IResourceDescriptionsExtension;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 * @author Thomas Wolf <thomas.wolf@paranor.ch> - Performance optimization and JavaDoc
 */
public class CurrentDescriptions extends AdapterImpl implements IResourceDescriptions, IResourceDescriptionsExtension {

	/**
	 * New index.
	 */
	private final IResourceDescriptionsData newData;

	/**
	 * Create a new index based on an old one.
	 * 
	 * @param resourceSet
	 *            The resource set
	 * @param oldState
	 *            The old index
	 * @param initiallyDeleted
	 *            URIs of resources physically deleted
	 */
	public CurrentDescriptions(ResourceSet resourceSet, IResourceDescriptionsData newData) {
		this.newData = newData;
		resourceSet.eAdapters().add(this);
	}

	/**
	 * Put a new resource description into the index, or remove one if the delta has no new description. A delta for a
	 * particular URI may be registered more than once; overwriting any earlier registration.
	 * 
	 * @param delta
	 *            The resource change.
	 */
	public void register(IResourceDescription.Delta delta) {
		final IResourceDescription newDesc = delta.getNew();
		if (newDesc == null) {
			newData.removeDescription(delta.getUri());
		} else {
			newData.addDescription(delta.getUri(), newDesc);
		}
	}

	/**
	 * Return the full contents of the index.
	 * 
	 * @return The index' contents.
	 */
	public Iterable<IResourceDescription> getAllResourceDescriptions() {
		return newData.getAllResourceDescriptions();
	}

	/**
	 * Return the resource description for a URI.
	 * 
	 * @param uri
	 *            The URI
	 * @return The resource description, or null if there is none.
	 */
	public IResourceDescription getResourceDescription(URI uri) {
		return newData.getResourceDescription(uri);
	}

	public boolean isEmpty() {
		return newData.isEmpty();
	}

	public Iterable<IEObjectDescription> getExportedObjects() {
		return newData.getExportedObjects();
	}

	public Iterable<IEObjectDescription> getExportedObjects(EClass type, QualifiedName name, boolean ignoreCase) {
		return newData.getExportedObjects(type, name, ignoreCase);
	}

	public Iterable<IEObjectDescription> getExportedObjectsByType(EClass type) {
		return newData.getExportedObjectsByType(type);
	}

	public Iterable<IEObjectDescription> getExportedObjectsByObject(EObject object) {
		return newData.getExportedObjectsByObject(object);
	}

	public Iterable<IResourceDescription> findAllReferencingResources(Iterable<IResourceDescription> targetResources,
			ReferenceMatchPolicy matchPolicy) {
		return newData.findAllReferencingResources(targetResources, matchPolicy);
	}

	public Iterable<IResourceDescription> findObjectReferencingResources(
			Iterable<IEObjectDescription> targetObjects, ReferenceMatchPolicy matchPolicy) {
		return newData.findObjectReferencingResources(targetObjects, matchPolicy);
	}

	public Iterable<IReferenceDescription> findReferencesToObjects(Iterable<URI> targetObjects) {
		return newData.findReferencesToObjects(targetObjects);
	}

	/**
	 * @return <code>true</code> if the given type is class {@link CurrentDescriptions}. 
	 */
	@Override
	public boolean isAdapterForType(Object type) {
		return CurrentDescriptions.class.equals(type);
	}

	/**
	 * Context-aware instance of our index.
	 */
	public static class ResourceSetAware implements IResourceDescriptions.IContextAware {

		/** Base index. */
		private IResourceDescriptions delegate;

		/**
		 * Set the context.
		 * 
		 * @param ctx
		 *            The context
		 */
		public void setContext(Notifier ctx) {
			final ResourceSet resourceSet = EcoreUtil2.getResourceSet(ctx);
			delegate = (IResourceDescriptions) EcoreUtil.getAdapter(resourceSet.eAdapters(), CurrentDescriptions.class);
		}

		/**
		 * Return the full contents of the index.
		 * 
		 * @return The index' contents.
		 */
		public Iterable<IResourceDescription> getAllResourceDescriptions() {
			return delegate.getAllResourceDescriptions();
		}

		/**
		 * Return the resource description for a URI.
		 * 
		 * @param uri
		 *            The URI
		 * @return The resource description, or null if there is none.
		 */
		public IResourceDescription getResourceDescription(URI uri) {
			return delegate.getResourceDescription(uri);
		}

		public boolean isEmpty() {
			return delegate.isEmpty();
		}

		public Iterable<IEObjectDescription> getExportedObjects() {
			return delegate.getExportedObjects();
		}

		public Iterable<IEObjectDescription> getExportedObjects(EClass type, QualifiedName name, boolean ignoreCase) {
			return delegate.getExportedObjects(type, name, ignoreCase);
		}

		public Iterable<IEObjectDescription> getExportedObjectsByType(EClass type) {
			return delegate.getExportedObjectsByType(type);
		}

		public Iterable<IEObjectDescription> getExportedObjectsByObject(EObject object) {
			return delegate.getExportedObjectsByObject(object);
		}

	}

}