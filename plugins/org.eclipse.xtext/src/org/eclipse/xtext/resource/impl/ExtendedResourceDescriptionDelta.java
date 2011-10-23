/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.resource.impl;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.common.util.URI;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.resource.IResourceDescription;
import org.eclipse.xtext.util.Pair;
import org.eclipse.xtext.util.Triple;
import org.eclipse.xtext.util.Tuples;

import com.google.common.base.Function;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import com.google.common.collect.Ordering;
import com.google.common.collect.Sets;

/**
 * @author Sven Efftinge - Initial contribution and API
 * @since 2.1
 */
public class ExtendedResourceDescriptionDelta implements IResourceDescription.Delta, IResourceDescription.DeltaExtension {

	protected static final Ordering<IEObjectDescription> URI_ORDERING = Ordering.natural().onResultOf(
			new Function<IEObjectDescription, String>() {
				public String apply(final IEObjectDescription from) {
					return from.getEObjectURI().fragment();
				}
			});

	protected static final Ordering<IEObjectDescription> NAME_ORDERING = Ordering.natural().onResultOf(
			new Function<IEObjectDescription, QualifiedName>() {
				public QualifiedName apply(final IEObjectDescription from) {
					return from.getName();
				}
			});

	private IResourceDescription _new;
	private IResourceDescription old;

	public ExtendedResourceDescriptionDelta(IResourceDescription old, IResourceDescription _new) {
		super();
		if (old == _new) {
			throw new AssertionError("'old!=_new' constraint violated");
		}
		if (_new != null && old != null && !old.getURI().equals(_new.getURI())) {
			URI oldURI = old.getURI();
			URI newURI = _new.getURI();
			throw new AssertionError(
					"'_new!=null && old!=null && !old.getURI().equals(_new.getURI())' constraint violated, old was "
							+ oldURI + " new was: " + newURI);
		}
		this.old = old;
		this._new = _new;
	}

	public URI getUri() {
		return old == null ? _new.getURI() : old.getURI();
	}

	public IResourceDescription getNew() {
		return _new;
	}

	public IResourceDescription getOld() {
		return old;
	}

	private Boolean hasChanges;
	private Triple<Collection<IEObjectDescription>, Collection<Pair<IEObjectDescription, IEObjectDescription>>, Collection<IEObjectDescription>> diff;

	public boolean haveEObjectDescriptionsChanged() {
		if (hasChanges == null) {
			hasChanges = internalHasChanges();
		}
		return hasChanges.booleanValue();
	}

	protected boolean internalHasChanges() {
		if (_new == null || old == null)
			return true;

		Iterable<IEObjectDescription> oldEObjects = old.getExportedObjects();
		Iterable<IEObjectDescription> newEObjects = _new.getExportedObjects();
		if (Iterables.size(oldEObjects) != Iterables.size(newEObjects))
			return true;

		Iterator<IEObjectDescription> iterator1 = oldEObjects.iterator();
		Iterator<IEObjectDescription> iterator2 = newEObjects.iterator();
		while (iterator1.hasNext()) {
			if (!equals(iterator1.next(), iterator2.next()))
				return true;
		}
		return false;
	}

	protected boolean equals(IEObjectDescription oldObj, IEObjectDescription newObj) {
		if (oldObj == newObj)
			return true;
		if (oldObj.getEClass() != newObj.getEClass())
			return false;
		if (oldObj.getName() != null && !oldObj.getName().equals(newObj.getName()))
			return false;
		if (!oldObj.getEObjectURI().equals(newObj.getEObjectURI()))
			return false;
		String[] oldKeys = oldObj.getUserDataKeys();
		String[] newKeys = newObj.getUserDataKeys();
		if (oldKeys.length != newKeys.length)
			return false;
		Set<String> newKeySet = ImmutableSet.of(newKeys);
		for (String key : oldKeys) {
			if (!newKeySet.contains(key))
				return false;
			String oldValue = oldObj.getUserData(key);
			String newValue = newObj.getUserData(key);
			if (oldValue == null) {
				if (newValue != null)
					return false;
			} else if (!oldValue.equals(newValue)) {
				return false;
			}
		}
		return true;
	}

	public Iterable<IEObjectDescription> getDeletedObjects() {
	    return computeDetailedDiff().getFirst();
	}

	public Iterable<IEObjectDescription> getChangedObjects() {
	    Collection<Pair<IEObjectDescription, IEObjectDescription>> changes = computeDetailedDiff().getSecond();
	    List<IEObjectDescription> changedObjects = Lists.newArrayListWithCapacity(changes.size());
	    for (Pair<IEObjectDescription, IEObjectDescription> change : changes) {
	      changedObjects.add(change.getSecond());
	    }
	    return changedObjects;
	}

	public Iterable<IEObjectDescription> getAddedObjects() {
	    return computeDetailedDiff().getThird();
	}

	protected Triple<Collection<IEObjectDescription>, Collection<Pair<IEObjectDescription, IEObjectDescription>>, Collection<IEObjectDescription>> computeDetailedDiff() {
		return computeDetailedDiff(old, getNew(), NAME_ORDERING);
	}

	protected Triple<Collection<IEObjectDescription>, Collection<Pair<IEObjectDescription, IEObjectDescription>>, Collection<IEObjectDescription>> computeDetailedDiff(
			final IResourceDescription oldRes, final IResourceDescription newRes, Ordering<IEObjectDescription> ordering) {
		if (diff == null) {
			Collection<IEObjectDescription> deletedObjects = Sets.newHashSet();
			Collection<Pair<IEObjectDescription, IEObjectDescription>> changedObjects = Sets.newHashSet();
			Collection<IEObjectDescription> newObjects = Sets.newHashSet();

			if (oldRes == null) {
				Iterables.addAll(newObjects, newRes.getExportedObjects());
			} else if (newRes == null) {
				Iterables.addAll(deletedObjects, oldRes.getExportedObjects());
			} else {
				final List<IEObjectDescription> oldEObjects = ordering.sortedCopy(oldRes.getExportedObjects());
				final List<IEObjectDescription> newEObjects = ordering.sortedCopy(newRes.getExportedObjects());
				int oldIdx = 0;
				int newIdx = 0;
				for (;;) {
					IEObjectDescription oldObj = oldIdx >= oldEObjects.size() ? null : oldEObjects.get(oldIdx);
					IEObjectDescription newObj = newIdx >= newEObjects.size() ? null : newEObjects.get(newIdx);
					if (oldObj == null && newObj == null) {
						break;
					} else if (oldObj == null) {
						newObjects.add(newObj);
						newIdx++;
					} else if (newObj == null) {
						deletedObjects.add(oldObj);
						oldIdx++;
					} else {
						int compare = ordering.compare(oldObj, newObj);
						if (compare == 0) {
							if (!equals(oldObj, newObj)) {
								changedObjects.add(Tuples.create(oldObj, newObj));
							}
							oldIdx++;
							newIdx++;
						} else if (compare < 0) {
							deletedObjects.add(oldObj);
							oldIdx++;
						} else {
							newObjects.add(newObj);
							newIdx++;
						}
					}
				}
			}
			if (deletedObjects.isEmpty() && changedObjects.isEmpty() && newObjects.isEmpty()) {
				hasChanges = false;
			}
			diff = Tuples.create(deletedObjects, changedObjects, newObjects);
		}

		return diff;
	}

	@Override
	public String toString() {
		return getClass().getSimpleName() + " for " + getUri() + " old :" + (getOld() != null) + ",new :"
				+ (getNew() != null);
	}

}
