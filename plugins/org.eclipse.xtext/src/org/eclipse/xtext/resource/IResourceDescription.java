/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.resource;

import java.util.Collection;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.resource.impl.DefaultResourceDescriptionManager;

import com.google.common.collect.ImmutableList;
import com.google.inject.ImplementedBy;

/**
 * A representation of a resource's contents as an {@link ISelectable}.
 * The exported objects of a {@link Resource} describe its public interface.
 * A {@link IResourceDescription description} holds information about the 
 * {@link #getImportedNames() imported names} which can be used to compute the
 * transitive closure when a resource is modified. Information about the actually
 * established {@link #getReferenceDescriptions() cross references} is available, too.
 * 
 * @author Sebastian Zarnekow - Initial contribution and API
 * @author Sven Efftinge
 * @author Jan Koehnlein
 */
public interface IResourceDescription extends ISelectable {

	/**
	 * @return descriptions of all EObjects provided by the given Resource. The result is expected to return any
	 *         combination of <code>name</code> and <code>eObjectOrProxy</code> only once as an
	 *         {@link IEObjectDescription}. The order of the exported objects matters.
	 */
	Iterable<IEObjectDescription> getExportedObjects();

	/**
	 * @return the list of names the described resource depends depends on.
	 */
	Iterable<QualifiedName> getImportedNames();
	
	/**
	 * @return the list of all references contained in the underlying resource.
	 */
	Iterable<IReferenceDescription> getReferenceDescriptions();

	/**
	 * @return the uri of the described resource. Will not return <code>null</code>.
	 */
	URI getURI();

	@ImplementedBy(DefaultResourceDescriptionManager.class)
	interface Manager {

		/**
		 * @return a resource description for the given resource. The result represents the current state of the given
		 *         resource.
		 */
		IResourceDescription getResourceDescription(Resource resource);

		/**
		 * @return a delta for both given descriptions.
		 */
		IResourceDescription.Delta createDelta(IResourceDescription oldDescription, IResourceDescription newDescription);
		
		/**
		 * @return whether the candidate is affected by the change in the delta.
		 * @throws IllegalArgumentException
		 *             if this manager is not responsible for the given candidate.
		 */
		boolean isAffected(IResourceDescription.Delta delta, IResourceDescription candidate)
				throws IllegalArgumentException;

		/**
		 * Batch operation to check whether a description is affected by any given delta in
		 * the given context. Implementations may perform any optimizations to return <code>false</code> whenever
		 * possible, e.g. check the deltas against the visible containers.
		 * @param deltas List of deltas to check. May not be <code>null</code>.
		 * @param candidate The description to check. May not be <code>null</code>.
		 * @param context The current context of the batch operation. May not be <code>null</code>.
		 * @return whether the candidate is affected by any of the given changes.
		 * @throws IllegalArgumentException
		 *             if this manager is not responsible for the given candidate.
		 */
		boolean isAffected(Collection<IResourceDescription.Delta> deltas,
				IResourceDescription candidate,
				IResourceDescriptions context)
				throws IllegalArgumentException;

	}

	/**
	 * @since 2.4
	 */
	interface ManagerExtension {

		  /**
		   * Batch operation to return all URIs of resources (managed by this manager) which are affected by the given set of deltas.
		   * 
		   * @param deltas
		   *          List of deltas to check. May not be <code>null</code>.
		   * @param candidates
		   *          The candidates to check. May also include resources not managed by this manager. May not be <code>null</code>.
		   * @param context
		   *          The current context of the batch operation. May not be <code>null</code>.
		   * @return collection of all resources affected by the given deltas
		   */
		  public Collection<URI> getAffectedResources(final Collection<Delta> deltas, final Collection<URI> candidates, final IResourceDescriptionsExtension context);

	 }

	/**
	 * A delta describing the differences between two versions of the same {@link IResourceDescription}. Instances have
	 * to follow the rule :
	 * <p>
	 * <code>getNew()==null || getOld()==null || getOld().getURI().equals(getNew().getURI())</code>
	 * </p>
	 * and
	 * <p>
	 * <code>getNew()!=getOld()</code>
	 * </p>
	 * 
	 */
	interface Delta {
		/**
		 *@return the uri for the resource description delta.
		 */
		URI getUri();
		/**
		 * @return the old resource description, or null if the change is an addition
		 */
		IResourceDescription getOld();

		/**
		 * @return the new resource description, or null if the change is a deletion
		 */
		IResourceDescription getNew();

		/**
		 * @return whether there are differences between the old and the new resource description.
		 */
		boolean haveEObjectDescriptionsChanged();

	}

	/**
	 * @since 2.4
	 */
	interface DeltaExtension {

		public Iterable<IEObjectDescription> getDeletedObjects();

		public Iterable<IEObjectDescription> getChangedObjects();

		public Iterable<IEObjectDescription> getAddedObjects();

	}

	interface Event {

		/**
		 * @return the list of changes. It is never <code>null</code> but may be empty.
		 */
		ImmutableList<Delta> getDeltas();

		/**
		 * @return the sender of this event. Is never <code>null</code>.
		 */
		Source getSender();

		interface Source {

			/**
			 * Add a listener to the event source. Listeners will not be added twice. Subsequent calls to
			 * {@link #addListener(Listener)} will not affect the number of events that the listener receives.
			 * {@link #removeListener(Listener)} will remove the listener immediately independently from the number of
			 * invocations of {@link #addListener(Listener)} for the given listener.
			 * 
			 * @param listener
			 *            the listener to be registered. May not be <code>null</code>.
			 */
			void addListener(Listener listener);

			/**
			 * Immediately removes a registered listener from the source. However if {@link #removeListener(Listener)}
			 * is called during a notification, the removed listener will still receive the event. If the listener has
			 * not been registered before, the {@link #removeListener(Listener)} does nothing.
			 * 
			 * @param listener
			 *            the listener to be removed. May not be <code>null</code>.
			 */
			void removeListener(Listener listener);
		}

		/**
		 * A listener for events raised by a {@link Event.Source}.
		 */
		interface Listener {

			/**
			 * <p>
			 * The source will invoce this method to announce changed resource. The event will never be
			 * <code>null</code>. However, it may contain an empty list of deltas.
			 * </p>
			 * <p>
			 * Listeners are free to remove themselves from the sender of the event or add other listeners. However
			 * added listeners will not be informed about the current change.
			 * </p>
			 * <p>
			 * This event may be fired asynchronously. It is ensured that the changed resources will provide the content
			 * as it was when the change has been announced to the sender of the event.
			 * </p>
			 * 
			 * @param event
			 *            the fired event. Will never be <code>null</code>.
			 */
			void descriptionsChanged(Event event);
		}
	}

}
