/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.builder.builderState.db;

import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.xtext.builder.builderState.ResourceDescriptionsData;
import org.eclipse.xtext.builder.clustering.CopiedResourceDescription;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.resource.IReferenceDescription;
import org.eclipse.xtext.resource.IResourceDescription;
import org.eclipse.xtext.resource.ISelectable;
import org.eclipse.xtext.util.IAcceptor;

import com.google.common.base.Function;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import com.google.common.collect.MapMaker;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;

/**
 * @author Knut Wannheden - Initial contribution and API
 */
public class DBBasedResourceDescriptionsData extends ResourceDescriptionsData {

	private final DBBasedBuilderState index;
	private boolean initialized;
	private volatile boolean inTransaction;

	// caching
	private Set<URI> allURIs = Sets.newHashSet();
	private Map<QualifiedName, Collection<URI>> lookupMap = Maps.newHashMap();
	private Map<URI, IResourceDescription> cache = new MapMaker().concurrencyLevel(1).softValues().makeMap();

	// buffering
	private WriteBehindBuffer buffer;

	public DBBasedResourceDescriptionsData(final DBBasedBuilderState index) {
		super(null, null);
		this.index = index;
	}

	protected DBBasedResourceDescriptionsData(final DBBasedBuilderState index, Set<URI> allURIs, Map<QualifiedName, Collection<URI>> lookupMap, Map<URI, IResourceDescription> cache) {
		super(null, null);
		this.index = index;
		this.allURIs = allURIs;
		this.lookupMap = lookupMap;
		this.cache = cache;
	}

	private synchronized void ensureInitialized() {
		if (!initialized) {
			index.loadAllQualifiedNames(lookupMap);
			allURIs.addAll(index.getAllURIs());
			initialized = true;
		}
	}

	private void assertInTransaction() {
		if (!inTransaction) {
			throw new IllegalStateException("Transaction required"); //$NON-NLS-1$
		}
	}

	@Override
	public Iterable<IResourceDescription> getAllResourceDescriptions() {
		ensureInitialized();
		return index.getAllResourceDescriptions();
	}

	@Override
	public IResourceDescription getResourceDescription(final URI normalizedURI) {
		ensureInitialized();
		IResourceDescription res = cache.get(normalizedURI);
		if (res != null) {
			return res;
		}
		return index.getResourceDescription(normalizedURI);
	}

	@Override
	public boolean isEmpty() {
		ensureInitialized();
		return allURIs.isEmpty();
	}

	@Override
	public Iterable<IEObjectDescription> getExportedObjects() {
		ensureInitialized();
		return index.getExportedObjects();
	}

	@Override
	public Iterable<IEObjectDescription> getExportedObjects(final EClass type, final QualifiedName name,
			final boolean ignoreCase) {
		ensureInitialized();
		QualifiedName lowerCase = name.toLowerCase();
		Iterable<URI> uris = null;
		if (lookupMap.containsKey(lowerCase)) {
			uris = lookupMap.get(lowerCase);
		}

		if (uris == null || Iterables.isEmpty(uris)) {
			return ImmutableList.of();
		}

		Iterable<IResourceDescription> candidates = getOrLoadCachedResources(Sets.newHashSet(uris));
		return Iterables.concat(Iterables.transform(candidates,
				new Function<ISelectable, Iterable<IEObjectDescription>>() {
					public Iterable<IEObjectDescription> apply(final ISelectable from) {
						if (from != null) {
							return from.getExportedObjects(type, name, ignoreCase);
						}
						return Collections.emptyList();
					}
				}));
	}

	@Override
	public Iterable<IEObjectDescription> getExportedObjectsByType(final EClass type) {
		ensureInitialized();
		return index.getExportedObjectsByType(type);
	}

	@Override
	public Iterable<IEObjectDescription> getExportedObjectsByObject(final EObject object) {
		ensureInitialized();
		IResourceDescription res = cache.get(object.eIsProxy() ? ((InternalEObject) object).eProxyURI().trimFragment()
				: object.eResource().getURI());
		if (res != null) {
			return res.getExportedObjectsByObject(object);
		}
		return index.getExportedObjectsByObject(object);
	}

	@Override
	public Set<URI> getAllURIs() {
		ensureInitialized();
		return allURIs;
	}

	@Override
	public Iterable<IResourceDescription> findAllReferencingResources(
			final Iterable<IResourceDescription> targetResources, final ReferenceMatchPolicy matchPolicy) {
		ensureInitialized();
		return index.findAllReferencingResources(targetResources, matchPolicy);
	}

	@Override
	public Iterable<IResourceDescription> findObjectReferencingResources(
			final Iterable<IEObjectDescription> targetObjects, final ReferenceMatchPolicy matchPolicy) {
		ensureInitialized();
		return index.findObjectReferencingResources(targetObjects, matchPolicy);
	}

	@Override
	public Iterable<IReferenceDescription> findReferencesToObjects(final Iterable<URI> targetObjects) {
		ensureInitialized();
		return index.findReferencesToObjects(targetObjects);
	}

	/**
	 * Notify caches that resources (and/or their contents) have changed or were deleted and that, therefore, all cached
	 * information is to be discarded.
	 */
	private void clearCaches() {
		cache.clear();
	}

	public void beginChanges() {
		ensureInitialized();
		index.beginChanges();
		inTransaction = true;
		buffer = new WriteBehindBuffer(index, new IAcceptor<Collection<IResourceDescription>>() {
			public void accept(final Collection<IResourceDescription> t) {
				// replace full blown originals in cache
				for (IResourceDescription res : t) {
					addToCache(res.getURI(), res);
				}
			}
		});
		buffer.start();
	}

	public void flushChanges() {
		if (!inTransaction) {
			return;
		}

		buffer.flush();
	}

	public void commitChanges() {
		if (inTransaction) {
			flushChanges();
			buffer.stop();
			buffer = null;
			index.commitChanges();
			inTransaction = false;
		}
	}

	public void rollbackChanges() {
		if (inTransaction) {
			try {
				buffer.stop();
				buffer = null;
				index.rollbackChanges();
			} finally {
				inTransaction = false;
				reset();
			}
		}
	}

	public void clear() {
		index.clear();
		reset();
	}

	public void close() {
		reset();
		index.close(false);
	}

	/**
	 * Resets the data in the uninitialized state.
	 */
	private void reset() {
		clearCaches();
		if (buffer != null) {
			buffer.stop();
			buffer = null;
		}
		allURIs.clear();
		lookupMap.clear();
		initialized = false;
	}

	@Override
	public void addDescription(final URI uri, final IResourceDescription newDescription) {
		assertInTransaction();
		buffer.put(uri, newDescription);
		allURIs.add(uri);
		for (IEObjectDescription object : newDescription.getExportedObjects()) {
			QualifiedName lowerCase = object.getName().toLowerCase();
			Collection<URI> uris = lookupMap.get(lowerCase);
			if (uris != null) {
				if (!uris.contains(uri)) {
					uris.add(uri);
				}
			} else {
				uris = Lists.newArrayListWithCapacity(1);
				uris.add(uri);
				lookupMap.put(lowerCase, uris);
			}
		}

		// don't call addCache() here as resource must strictly remain in cache until flushed
		cache.put(uri, newDescription);
	}

	@Override
	public void removeDescription(final URI uri) {
		assertInTransaction();
		allURIs.remove(uri);
		// TODO check if we can make this faster
		for (Iterator<Map.Entry<QualifiedName, Collection<URI>>> it = lookupMap.entrySet().iterator(); it.hasNext();) {
			Map.Entry<QualifiedName, Collection<URI>> entry = it.next();
			Collection<URI> uris = entry.getValue();
			if (uris.remove(uri)) {
				if (uris.isEmpty()) {
					it.remove();
				}
			}
		}
		cache.remove(uri);
		index.deleteResources(ImmutableSet.of(uri));
	}

	@Override
	public DBBasedResourceDescriptionsData copy() {
		if (inTransaction)
			throw new IllegalStateException("cannot copy a DBBasedResourceDescriptionsData still in transaction");
		ensureInitialized();
		DBBasedBuilderState indexCopy = index.copy();
		Map<URI, IResourceDescription> cacheCopy = new MapMaker().concurrencyLevel(1).softValues().makeMap();
		cacheCopy.putAll(cache);
		DBBasedResourceDescriptionsData copy = new DBBasedResourceDescriptionsData(indexCopy, Sets.newHashSet(allURIs), Maps.newHashMap(lookupMap), cacheCopy);
		return copy;
	}

	@Override
	protected Iterable<IResourceDescription> getSelectables() {
		throw new UnsupportedOperationException();
	}

	/**
	 * Retrieves the given resources from the cache. Any URIs missing resources are first automatically demand loaded
	 * from the DB into the cache.
	 */
	private Iterable<IResourceDescription> getOrLoadCachedResources(final Collection<URI> uris) {
		List<IResourceDescription> candidates = Lists.newArrayListWithCapacity(uris.size());
		Set<URI> missing = Sets.newHashSet();
		for (URI uri : uris) {
			IResourceDescription res = cache.get(uri);
			if (res == null) {
				missing.add(uri);
			} else {
				candidates.add(res);
			}
		}
		if (!missing.isEmpty()) {
			for (IResourceDescription loaded : index.loadResources(missing)) {
				cache.put(loaded.getURI(), loaded);
				candidates.add(loaded);
			}
		}
		return candidates;
	}

	/**
	 * Adds a resource description to the cache and overwrites the existing entry (if any). Note that the resource will
	 * be added without reference descriptions.
	 */
	private void addToCache(final URI uri, final IResourceDescription res) {
		if (Iterables.isEmpty(res.getReferenceDescriptions())) {
			cache.put(uri, res);
		} else {
			// don't cache any reference descriptions or imported names
			cache.put(uri, new CopiedResourceDescription(res));
		}
	}

}
