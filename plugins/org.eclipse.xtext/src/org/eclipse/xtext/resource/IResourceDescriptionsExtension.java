/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.resource;

import org.eclipse.emf.common.util.URI;
import org.eclipse.xtext.util.Arrays;

/**
 * @author Knut Wannheden - Initial contribution and API
 * @since 2.1
 */
public interface IResourceDescriptionsExtension {

	/**
	 * Policy to determine how references are to be matched.
	 */
	public static class ReferenceMatchPolicy {

		public static enum MatchType {
			/** Matches up a resource's reference descriptions against the target objects. */
			REFERENCES,
	
			/** Matches a resource's imported names (ignoring case) against the target object names. */
			IMPORTED_NAMES;
		}

		private MatchType[] matchTypes;

		protected ReferenceMatchPolicy(MatchType... matchTypes) {
			this.matchTypes = matchTypes;
		}

		public static ReferenceMatchPolicy create(MatchType... matchTypes) {
			return new ReferenceMatchPolicy(matchTypes);
		}

		public static ReferenceMatchPolicy referencesOnly() {
			return new ReferenceMatchPolicy(MatchType.REFERENCES);
		}

		public static ReferenceMatchPolicy importedNamesOnly() {
			return new ReferenceMatchPolicy(MatchType.IMPORTED_NAMES);
		}

		/**
		 * Checks whether this policy includes the given other policy.
		 * 
		 * @param policy
		 *            other policy
		 * @return true if this match policy includes the given policy
		 */
		public boolean includes(final MatchType type) {
			return Arrays.contains(matchTypes, type);
		}
	}

	/**
	 * Find all {@link IResourceDescription}s containing cross-references to any object (whether exported or not) of the
	 * target resources. The result may also include any of the target resources themselves as they could reference each
	 * other.
	 * 
	 * @param targetResources
	 *            target resources to find references for
	 * @param matchPolicy
	 *            match policy applied to find matches
	 * @return An {@link Iterable} of all {@link IResourceDescription}s that reference any of the given resources
	 */
	Iterable<IResourceDescription> findAllReferencingResources(final Iterable<IResourceDescription> targetResources,
			ReferenceMatchPolicy matchPolicy);

	/**
	 * Find all {@link IResourceDescription}s containing cross-references to any of the given target objects.
	 * 
	 * @param targetObjects
	 *            target objects to find references for
	 * @param matchPolicy
	 *            match policy applied to find matches
	 * @return An {@link Iterable} of all {@link IResourceDescription}s that reference any of the given objects
	 */
	Iterable<IResourceDescription> findObjectReferencingResources(final Iterable<IEObjectDescription> targetObjects,
			ReferenceMatchPolicy matchPolicy);

	/**
	 * Find all {@link IReferenceDescription}s of cross-references to a set of {@link org.eclipse.emf.ecore.EObject
	 * EObjects} identified by {@link URI}.
	 * 
	 * @param targetObjects
	 *            {@link URI} of the target objects
	 * @return An {@link Iterable} of all {@link IReferenceDescription}s of all cross-references that reference the
	 *         given objects.
	 * @throws {@link IllegalArgumentException} if the given {@link URI} does not contain a fragment.
	 */
	Iterable<IReferenceDescription> findReferencesToObjects(final Iterable<URI> targetObjects);

}
