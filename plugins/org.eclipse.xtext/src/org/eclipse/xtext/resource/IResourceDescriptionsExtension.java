/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.resource;

import java.util.Arrays;
import java.util.EnumSet;

import org.eclipse.emf.common.util.URI;

/**
 * @author Knut Wannheden - Initial contribution and API
 * @since 2.4
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

		private EnumSet<MatchType> matchTypes;

		protected ReferenceMatchPolicy(MatchType matchType) {
			this.matchTypes = EnumSet.of(matchType);
		}

		protected ReferenceMatchPolicy(MatchType matchType1, MatchType matchType2) {
			this.matchTypes = EnumSet.of(matchType1, matchType2);
		}

		protected ReferenceMatchPolicy(MatchType... matchTypes) {
			this.matchTypes = EnumSet.of(matchTypes[0], Arrays.copyOfRange(matchTypes, 1, matchTypes.length));
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

		public static ReferenceMatchPolicy all() {
			return new ReferenceMatchPolicy(MatchType.REFERENCES, MatchType.IMPORTED_NAMES);
		}

		/**
		 * Checks whether this policy includes the given match type.
		 * 
		 * @param type
		 *            other type
		 * @return true if this match policy includes the given match type
		 */
		public boolean includes(final MatchType type) {
			return matchTypes.contains(type);
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
	 * @throws IllegalArgumentException if the given {@link URI} does not contain a fragment.
	 */
	Iterable<IReferenceDescription> findReferencesToObjects(final Iterable<URI> targetObjects);

}
