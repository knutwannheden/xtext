/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.builder.builderState.db;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.log4j.Logger;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.naming.IQualifiedNameConverter;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.resource.IReferenceDescription;
import org.eclipse.xtext.resource.IResourceDescription;
import org.eclipse.xtext.resource.IResourceDescriptions;
import org.eclipse.xtext.resource.IResourceDescriptionsExtension;
import org.eclipse.xtext.resource.IResourceDescriptionsExtension.ReferenceMatchPolicy.MatchType;

import com.google.common.base.Function;
import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;

/**
 * @author Knut Wannheden - Initial contribution and API
 */
public class DBBasedBuilderState implements IResourceDescriptions, IResourceDescriptionsExtension {

	/** Class-wide logger. */
	private static final Logger LOGGER = Logger.getLogger(DBBasedBuilderState.class);

	private static final String SCHEMA = "org/eclipse/xtext/builder/builderState/db/default-schema.sql";
	private static final QualifiedName EMPTY_NAME = QualifiedName.create();

	private final ConnectionWrapper conn;
	private boolean initialized;
	private boolean inTransaction;

	// TODO factor out into separate ResourceMap object
	private String resMapTable = "RES_MAP";
	private final BiMap<URI, Integer> resourceIdMap;
	private Set<URI> stashedResources = Sets.newHashSet();
	private final DBEPackageRegistry packageRegistry;

	// TODO should be injected
	private final IQualifiedNameConverter nameConverter = new IQualifiedNameConverter.DefaultImpl();

	public DBBasedBuilderState(final Connection conn) {
		this(new ConnectionWrapper(conn));
	}

	public DBBasedBuilderState(final ConnectionWrapper conn) {
		this(conn, Maps.synchronizedBiMap(HashBiMap.<URI, Integer> create()), new DBEPackageRegistry(conn));
	}

	protected DBBasedBuilderState(final ConnectionWrapper conn, BiMap<URI, Integer> resourceIdMap,
			DBEPackageRegistry packageRegistry) {
		this.conn = conn;
		this.resourceIdMap = resourceIdMap;
		this.packageRegistry = packageRegistry;
	}

	public DBBasedBuilderState copy() {
		BiMap<URI, Integer> resourceIdMapCopy = Maps.synchronizedBiMap(HashBiMap.<URI, Integer> create(resourceIdMap));
		resetOldResourceMap();
		resMapTable = "OLD_RES_MAP";
		return new DBBasedBuilderState(conn, resourceIdMapCopy, packageRegistry);
	}

	private synchronized void ensureInitialized() {
		if (!initialized) {
			PreparedStatement stmt = null;
			try {
				Connection c = conn.getConnection();
				stmt = c.prepareStatement("SELECT TABLE_NAME FROM INFORMATION_SCHEMA.TABLES WHERE TABLE_NAME = 'RES'");
				stmt.execute();
				ResultSet rs = stmt.getResultSet();
				if (!rs.next()) {
					initializeSchema(c);
				}
				reloadCaches();
			} catch (SQLException e) {
				throw new DBException(e);
			} finally {
				conn.close(stmt);
			}

			initialized = true;
		}
	}

	private void initializeSchema(final Connection connection) throws SQLException {
		clearCaches();
		connection.prepareStatement("DROP ALL OBJECTS").execute();
		CallableStatement initCall = connection.prepareCall("RUNSCRIPT FROM '"
				+ DBBasedBuilderState.class.getClassLoader().getResource(SCHEMA).toString() + "'");
		initCall.execute();
		packageRegistry.registerEPackages(Collections.<EPackage> singleton(EcorePackage.eINSTANCE));
		connection.commit();
		reloadCaches();
	}

	private void reloadCaches() {
		synchronized (resourceIdMap) {
			clearCaches();
			packageRegistry.reloadCaches();

			PreparedStatement resStmt = null;
			try {
				resStmt = conn.prepare("SELECT R.ID, R.URI FROM RES R JOIN " + resMapTable + " M ON M.RES_ID = R.ID");
				resStmt.execute();
				ResultSet rs = resStmt.getResultSet();
				while (rs.next()) {
					resourceIdMap.put(URI.createURI(rs.getString(2)), rs.getInt(1));
				}
			} catch (SQLException e) {
				throw new DBException(e);
			} finally {
				conn.close(resStmt);
			}
		}
	}

	private void clearCaches() {
		conn.clearCaches();
		resourceIdMap.clear();
		packageRegistry.clearCaches();
	}

	public void open() {
		ensureInitialized();
	}

	public synchronized void close(final boolean compact) {
		try {
			if (initialized && conn != null) {
				resetOldResourceMap();
				Connection c = conn.getConnection();
				Statement stmt = null;
				try {
					stmt = c.createStatement();
					stmt.execute(compact ? "SHUTDOWN COMPACT" : "SHUTDOWN");
				} finally {
					if (stmt != null) {
						stmt.close();
					}
					c.close();
				}
			}
		} catch (SQLException e) {
			throw new DBException(e);
		} finally {
			clearCaches();
			initialized = false;
		}
	}

	public void clear() {
		try {
			initializeSchema(conn.getConnection());
		} catch (SQLException e) {
			throw new DBException(e);
		}
	}

	public void importData(final Iterable<IResourceDescription> resourceDescriptions) {
		ensureInitialized();
		try {
			beginChanges();
			Statement stmt = null;
			try {
				stmt = conn.getConnection().createStatement();
				stmt.execute("SET UNDO_LOG=0");
				stmt.execute("SET LOG=0");
				insertResources(resourceDescriptions, false);
				commitChanges();
			} finally {
				if (stmt != null)
					stmt.close();
				stmt = conn.getConnection().createStatement();
				stmt.execute("SET UNDO_LOG=1");
				stmt.execute("SET LOG=1");
				stmt.close();
			}
		} catch (SQLException e) {
			throw new DBException(e);
		}
	}

	private void resetOldResourceMap() {
		PreparedStatement insStmt = null;
		try {
			Statement stmt = conn.getConnection().createStatement();
			stmt.execute("TRUNCATE TABLE OLD_RES_MAP");
			stmt.execute("DELETE FROM RES WHERE ID < 0");
			stmt.execute("DELETE FROM RES_NAMES WHERE RES_ID < 0");
			stmt.execute("DELETE FROM OBJ WHERE RES_ID < 0");
			stmt.execute("DELETE FROM REF WHERE RES_ID < 0");
			stmt.close();

			insStmt = conn.prepare("INSERT INTO OLD_RES_MAP DIRECT SELECT RES_ID FROM RES_MAP");
			insStmt.execute();
		} catch (SQLException e) {
			throw new DBException(e);
		} finally {
			conn.close(insStmt);
		}
	}

	private void insertResources(final Iterable<IResourceDescription> resourceDescriptions, final boolean external) {
		PreparedStatement resIdStmt = null;
		PreparedStatement resMapStmt = null;
		PreparedStatement resInsStmt = null;
		PreparedStatement resNamesStmt = null;
		PreparedStatement objStmt = null;
		PreparedStatement refStmt = null;

		try {
			Set<EPackage> ePackages = Sets.newHashSet();

			// reserve potentially required resource ids
			resIdStmt = conn.getConnection().prepareStatement("SELECT NEXT VALUE FOR RES_SEQ FROM SYSTEM_RANGE(1, ?)");
			resIdStmt.setInt(1, Iterables.size(resourceDescriptions));
			ResultSet rs = resIdStmt.executeQuery();

			resMapStmt = conn.prepare("INSERT INTO RES_MAP (RES_ID) VALUES (?)");
			resInsStmt = conn.prepare("INSERT INTO RES (ID, URI, EXTERNAL) VALUES (?, ?, ?)");

			for (IResourceDescription res : resourceDescriptions) {
				URI uri = res.getURI();
				Integer resId = resourceIdMap.get(uri);
				if (resId == null) {
					rs.next();
					resId = rs.getInt(1);
				}

				resMapStmt.setInt(1, resId);
				resMapStmt.addBatch();
				resourceIdMap.put(uri, resId);

				resInsStmt.setInt(1, resId);
				resInsStmt.setString(2, uri.toString());
				resInsStmt.setBoolean(3, external);
				resInsStmt.addBatch();

				for (IEObjectDescription obj : res.getExportedObjects()) {
					EPackage ePackage = obj.getEClass().getEPackage();
					if (ePackage != null) {
						ePackages.add(ePackage);
					}
				}
			}
			resMapStmt.executeBatch();
			resInsStmt.executeBatch();

			packageRegistry.registerEPackages(ePackages);

			resNamesStmt = conn.prepare("INSERT INTO RES_NAMES (RES_ID, IMPORTED_NAME)" + " VALUES (?, ?)");

			for (IResourceDescription res : resourceDescriptions) {
				Integer resUri = resourceIdMap.get(res.getURI());
				for (QualifiedName name : res.getImportedNames()) {
					resNamesStmt.setInt(1, resUri);
					resNamesStmt.setString(2, convertQualifiedNameToString(name));
					resNamesStmt.addBatch();
				}
			}
			resNamesStmt.executeBatch();

			objStmt = conn.prepare("INSERT INTO OBJ (RES_ID, FRAG, NAME, ECLASS_ID, USER_DATA) VALUES (?, ?, ?, ?, ?)");
			refStmt = conn
					.prepare("INSERT INTO REF (RES_ID, SRC_FRAG, CONT_FRAG, TGT_RES_ID, TGT_FRAG, EREF_ID, IDX) VALUES (?, ?, ?, ?, ?, ?, ?)");

			for (IResourceDescription res : resourceDescriptions) {
				Integer resId = resourceIdMap.get(res.getURI());
				for (IEObjectDescription obj : res.getExportedObjects()) {
					objStmt.setInt(1, resId);
					objStmt.setString(2, obj.getEObjectURI().fragment());
					objStmt.setString(3, convertQualifiedNameToString(obj.getName()));
					objStmt.setInt(4, packageRegistry.getEClassId(obj.getEClass()));
					objStmt.setObject(5, ImmutableEObjectDescription.getUserDataArray(obj));
					objStmt.addBatch();
				}
				for (IReferenceDescription ref : res.getReferenceDescriptions()) {
					URI srcUri = ref.getSourceEObjectUri();
					URI contUri = ref.getContainerEObjectURI();
					URI tgtUri = ref.getTargetEObjectUri();
					Integer tgtResId = resourceIdMap.get(tgtUri.trimFragment());
					if (srcUri == null) {
						continue;
					} else if (tgtResId == null) {
						tgtResId = insertExternalResource(tgtUri.trimFragment());
					}

					refStmt.setInt(1, resId);
					refStmt.setString(2, srcUri.fragment());
					if (contUri != null) {
						refStmt.setString(3, contUri.fragment());
					} else {
						refStmt.setNull(3, Types.VARCHAR);
					}
					refStmt.setInt(4, tgtResId);
					refStmt.setString(5, tgtUri.fragment());
					EReference eReference = ref.getEReference();
					if (eReference != null) {
						refStmt.setInt(6, packageRegistry.getEReferenceId(eReference));
					} else {
						refStmt.setNull(6, Types.INTEGER);
					}
					refStmt.setInt(7, ref.getIndexInList());
					refStmt.addBatch();
				}
			}
			objStmt.executeBatch();
			refStmt.executeBatch();
		} catch (SQLException e) {
			throw new DBException(e);
		} finally {
			conn.close(resIdStmt);
			conn.close(resMapStmt);
			conn.close(resInsStmt);
			conn.close(resNamesStmt);
			conn.close(objStmt);
			conn.close(refStmt);
		}
	}

	private Integer insertExternalResource(final URI uri) {
		insertResources(ImmutableSet.<IResourceDescription> of(new LoadedResourceDescription(uri)), true);
		return resourceIdMap.get(uri);
	}

	public Iterable<SelectableDBBasedResourceDescription> loadResources(final Set<URI> uris) {
		final List<Integer> ids = Lists.newArrayListWithCapacity(uris.size());
		for (URI uri : uris) {
			ids.add(resourceIdMap.get(uri));
		}
		final Object[] idArray = ids.toArray(new Object[ids.size()]);

		final Map<Integer, SelectableDBBasedResourceDescription> result = Maps.newLinkedHashMap();

		PreparedStatement resStmt = null;
		PreparedStatement objStmt = null;
		try {
			resStmt = conn.prepare("SELECT M.RES_ID FROM " + resMapTable
					+ " M INNER JOIN TABLE(ID INT=?) I ON M.RES_ID = I.ID");
			resStmt.setObject(1, idArray);
			resStmt.execute();
			ResultSet rs = resStmt.getResultSet();
			while (rs.next()) {
				int resId = rs.getInt(1);
				result.put(resId, new SelectableDBBasedResourceDescription(this, getResourceURI(resId)));
			}

			IEObjectDescriptionIterable objects = new IEObjectDescriptionIterable() {
				@Override
				protected PreparedStatement createPreparedStatement() throws SQLException {
					PreparedStatement stmt = conn
							.prepare("SELECT O.RES_ID, O.FRAG, O.NAME, O.ECLASS_ID, O.USER_DATA FROM OBJ O INNER JOIN TABLE(ID INT=?) I ON O.RES_ID = I.ID");
					stmt.setObject(1, idArray);
					return stmt;
				}
			};
			objStmt = objects.createPreparedStatement();
			objStmt.execute();
			rs = objStmt.getResultSet();
			while (rs.next()) {
				IEObjectDescription obj = objects.computeNext(rs);
				result.get(rs.getInt(1)).getExportedObjects().add(obj);
			}
		} catch (SQLException e) {
			throw new DBException(e);
		} finally {
			conn.close(resStmt);
			conn.close(objStmt);
		}

		return result.values();
	}

	/**
	 * Loads all object names present in the database associated with the URIs in which they occur.
	 * <p>
	 * TODO: consider using URI[] arrays (or even Object => URI, URI[]) to save more memory
	 * 
	 * @param destination
	 *            map to which to add all names to the respective resources mappings
	 */
	public void loadAllQualifiedNames(final Map<QualifiedName, Collection<URI>> destination) {
		ensureInitialized();
		PreparedStatement stmt = null;
		try {
			stmt = conn.prepare("SELECT O.NAME, O.RES_ID FROM OBJ O JOIN " + resMapTable + " M ON M.RES_ID = O.RES_ID");
			stmt.execute();
			ResultSet rs = stmt.getResultSet();
			while (rs.next()) {
				QualifiedName name = createQualifiedNameFromString(rs.getString(1).toLowerCase());
				Collection<URI> resources = destination.get(name);
				URI resource = getResourceURI(rs.getInt(2));
				if (resource == null)
					continue;
				if (resources == null) {
					resources = Lists.newArrayListWithCapacity(1);
					resources.add(resource);
					destination.put(name, resources);
				} else {
					if (!resources.contains(resource)) {
						resources.add(resource);
					}
				}
			}
		} catch (SQLException e) {
			throw new DBException(e);
		} finally {
			conn.close(stmt);
		}
	}

	public void updateResources(final Iterable<IResourceDescription> resourceDescriptions) {
		ensureInitialized();

		deleteResourceDescriptions(Iterables.transform(resourceDescriptions, new Function<IResourceDescription, URI>() {
			public URI apply(final IResourceDescription from) {
				return from.getURI();
			}
		}));
		insertResources(resourceDescriptions, false);
	}

	public void deleteResources(final Iterable<URI> uris) {
		ensureInitialized();

		deleteResourceDescriptions(uris);
	}

	// TODO create method to delete single resource
	private void deleteResourceDescriptions(final Iterable<URI> uris) {
		PreparedStatement workSetStmt = null;

		PreparedStatement refUpdStmt = null;
		PreparedStatement objUpdStmt = null;
		PreparedStatement resNamesUpdStmt = null;
		PreparedStatement resUpdStmt = null;

		PreparedStatement refDelStmt = null;
		PreparedStatement objDelStmt = null;
		PreparedStatement resNamesDelStmt = null;
		PreparedStatement resDelStmt = null;

		PreparedStatement resMapStmt = null;
		PreparedStatement oldResMapStmt = null;

		try {

			List<Integer> resourcesToStash = Lists.newArrayListWithCapacity(Iterables.size(uris));
			List<Integer> resourcesToDelete = Lists.newArrayListWithCapacity(Iterables.size(uris));
			for (URI uri : uris) {
				Integer id = resourceIdMap.get(uri);
				if (stashedResources.add(uri) && id != null) {
					resourcesToStash.add(id);
				} else if (id != null) {
					resourcesToDelete.add(id);
				}
			}

			workSetStmt = conn.prepare("INSERT INTO WORK_SET DIRECT SELECT ID FROM TABLE(ID INT=?)");

			if (!resourcesToStash.isEmpty()) {
				Statement stmt = conn.getConnection().createStatement();
				stmt.execute("DELETE FROM WORK_SET");
				stmt.close();

				oldResMapStmt = conn.prepare("INSERT INTO OLD_RES_MAP DIRECT SELECT -ID FROM WORK_SET");
				refUpdStmt = conn
						.prepare("UPDATE REF R SET RES_ID = -RES_ID WHERE EXISTS (SELECT NULL FROM WORK_SET X WHERE X.ID = R.RES_ID)");
				objUpdStmt = conn
						.prepare("UPDATE OBJ O SET RES_ID = -RES_ID WHERE EXISTS (SELECT NULL FROM WORK_SET X WHERE X.ID = O.RES_ID)");
				resNamesUpdStmt = conn
						.prepare("UPDATE RES_NAMES N SET RES_ID = -RES_ID WHERE EXISTS (SELECT NULL FROM WORK_SET X WHERE X.ID = N.RES_ID)");
				resUpdStmt = conn
						.prepare("UPDATE RES R SET ID = -ID WHERE EXISTS (SELECT NULL FROM WORK_SET X WHERE X.ID = R.ID)");
				resMapStmt = conn
						.prepare("DELETE FROM RES_MAP M WHERE EXISTS (SELECT NULL FROM WORK_SET X WHERE X.ID = M.RES_ID)");

				final Object[] idArray = resourcesToStash.toArray(new Object[resourcesToStash.size()]);
				workSetStmt.setObject(1, idArray);

				workSetStmt.execute();
				oldResMapStmt.execute();
				refUpdStmt.execute();
				objUpdStmt.execute();
				resNamesUpdStmt.execute();
				resUpdStmt.execute();
				resMapStmt.execute();
			}

			if (!resourcesToDelete.isEmpty()) {
				Statement stmt = conn.getConnection().createStatement();
				stmt.execute("DELETE FROM WORK_SET");
				stmt.close();

				refDelStmt = conn
						.prepare("DELETE FROM REF R WHERE EXISTS (SELECT NULL FROM WORK_SET X WHERE X.ID = R.RES_ID)");
				objDelStmt = conn
						.prepare("DELETE FROM OBJ O WHERE EXISTS (SELECT NULL FROM WORK_SET X WHERE X.ID = O.RES_ID)");
				resNamesDelStmt = conn
						.prepare("DELETE FROM RES_NAMES N WHERE EXISTS (SELECT NULL FROM WORK_SET X WHERE X.ID = N.RES_ID)");
				resDelStmt = conn
						.prepare("DELETE FROM RES R WHERE EXISTS (SELECT NULL FROM WORK_SET X WHERE X.ID = R.ID)");
				resMapStmt = conn
						.prepare("DELETE FROM RES_MAP M WHERE EXISTS (SELECT NULL FROM WORK_SET X WHERE X.ID = M.RES_ID)");

				final Object[] idArray = resourcesToDelete.toArray(new Object[resourcesToDelete.size()]);
				workSetStmt.setObject(1, idArray);

				workSetStmt.execute();
				refDelStmt.execute();
				objDelStmt.execute();
				resNamesDelStmt.execute();
				resDelStmt.execute();
				resMapStmt.execute();
			}

		} catch (SQLException e) {
			throw new DBException(e);
		} finally {
			conn.close(refUpdStmt);
			conn.close(objUpdStmt);
			conn.close(resNamesUpdStmt);
			conn.close(resUpdStmt);
			conn.close(refDelStmt);
			conn.close(objDelStmt);
			conn.close(resNamesDelStmt);
			conn.close(resDelStmt);
			conn.close(resMapStmt);
			conn.close(oldResMapStmt);
			conn.close(workSetStmt);
		}
	}

	public boolean isEmpty() {
		ensureInitialized();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			stmt = conn.prepare("SELECT COUNT(1) FROM " + resMapTable);
			stmt.execute();
			rs = stmt.getResultSet();
			return !rs.next() || rs.getInt(1) == 0;
		} catch (SQLException e) {
			throw new DBException(e);
		} finally {
			conn.close(stmt);
		}
	}

	public Iterable<IResourceDescription> getAllResourceDescriptions() {
		return Iterables.transform(resourceIdMap.keySet(), new Function<URI, IResourceDescription>() {
			public IResourceDescription apply(URI from) {
				return new DBBasedResourceDescription(DBBasedBuilderState.this, from);
			}
		});
	}

	public IResourceDescription getResourceDescription(final URI normalizedURI) {
		ensureInitialized();
		PreparedStatement stmt = null;
		try {
			if (!resourceIdMap.containsKey(normalizedURI))
				return null;
			stmt = conn.prepare("SELECT R.ID FROM RES R JOIN " + resMapTable
					+ " M ON M.RES_ID = R.ID WHERE R.ID = ? AND R.EXTERNAL = FALSE");
			Integer id = resourceIdMap.get(normalizedURI);
			stmt.setInt(1, id);
			stmt.execute();
			ResultSet rs = stmt.getResultSet();
			if (rs.next()) {
				return new DBBasedResourceDescription(this, normalizedURI);
			}
		} catch (SQLException e) {
			throw new DBException(e);
		} finally {
			conn.close(stmt);
		}
		return null;
	}

	public Iterable<IEObjectDescription> getExportedObjects() {
		return new IEObjectDescriptionIterable() {
			@Override
			protected PreparedStatement createPreparedStatement() throws SQLException {
				ensureInitialized();
				return conn.prepare("SELECT O.RES_ID, O.FRAG, O.NAME, O.ECLASS_ID, O.USER_DATA FROM OBJ O JOIN "
						+ resMapTable + " M ON M.RES_ID = O.RES_ID");
			}
		};
	}

	public Iterable<IEObjectDescription> getExportedObjects(final URI resource) {
		return new IEObjectDescriptionIterable() {
			@Override
			protected PreparedStatement createPreparedStatement() throws SQLException {
				ensureInitialized();

				Integer resId = resourceIdMap.get(resource.trimFragment());
				if (resId == null) {
					return null;
				}

				PreparedStatement stmt = conn
						.prepare("SELECT O.RES_ID, O.FRAG, O.NAME, O.ECLASS_ID, O.USER_DATA FROM OBJ O WHERE O.RES_ID = ?");
				stmt.setInt(1, resId);
				return stmt;
			}
		};
	}

	public Iterable<IEObjectDescription> getExportedObjects(final EClass type, final QualifiedName name,
			final boolean ignoreCase) {
		return new IEObjectDescriptionIterable() {
			@Override
			protected PreparedStatement createPreparedStatement() throws SQLException {
				ensureInitialized();

				boolean matchAllObjects = type == EcorePackage.Literals.EOBJECT;
				String match = convertQualifiedNameToString(name);

				StringBuilder query = new StringBuilder(
						"SELECT O.RES_ID, O.FRAG, O.NAME, O.ECLASS_ID, O.USER_DATA FROM OBJ O JOIN " + resMapTable
								+ " M ON M.RES_ID = O.RES_ID");
				if (matchAllObjects) {
					query.append(" WHERE 1=1");
				} else {
					query.append(" JOIN ECLASS_SUPERTYPES E ON O.ECLASS_ID = E.ECLASS_ID WHERE E.SUPERTYPE_ECLASS_ID = ?2");
				}

				if (!ignoreCase) {
					query.append(" AND O.NAME = ?1");
				} else {
					query.append(" AND LOWER(O.NAME) = LOWER(?1)");
				}

				PreparedStatement stmt = conn.prepare(query);
				stmt.setString(1, match);
				if (!matchAllObjects) {
					stmt.setInt(2, packageRegistry.getEClassId(type));
				}
				return stmt;
			}
		};
	}

	public Iterable<IEObjectDescription> getExportedObjects(final URI uri, final EClass type, final QualifiedName name,
			final boolean ignoreCase) {
		return new IEObjectDescriptionIterable() {
			@Override
			protected PreparedStatement createPreparedStatement() throws SQLException {
				ensureInitialized();

				Integer resId = resourceIdMap.get(uri.trimFragment());
				if (resId == null) {
					return null;
				}

				boolean matchAllObjects = type == EcorePackage.Literals.EOBJECT;
				String match = convertQualifiedNameToString(name);

				StringBuilder query = new StringBuilder(
						"SELECT O.RES_ID, O.FRAG, O.NAME, O.ECLASS_ID, O.USER_DATA FROM OBJ O JOIN " + resMapTable
								+ " M ON M.RES_ID = O.RES_ID");
				if (matchAllObjects) {
					query.append(" WHERE O.RES_ID = ?1");
				} else {
					query.append(" JOIN ECLASS_SUPERTYPES E ON O.ECLASS_ID = E.ECLASS_ID WHERE O.RES_ID = ?1 AND E.SUPERTYPE_ECLASS_ID = ?3");
				}

				if (!ignoreCase) {
					query.append(" AND O.NAME = ?2");
				} else {
					query.append(" AND LOWER(O.NAME) = LOWER(?2)");
				}

				PreparedStatement stmt = conn.prepare(query);
				stmt.setInt(1, resId);
				stmt.setString(2, match);
				if (!matchAllObjects) {
					stmt.setInt(3, packageRegistry.getEClassId(type));
				}
				return stmt;
			}
		};
	}

	public Iterable<IEObjectDescription> getExportedObjectsByType(final EClass type) {
		return new IEObjectDescriptionIterable() {
			@Override
			protected PreparedStatement createPreparedStatement() throws SQLException {
				ensureInitialized();
				PreparedStatement stmt = null;
				if (type == EcorePackage.Literals.EOBJECT) {
					stmt = conn.prepare("SELECT O.RES_ID, O.FRAG, O.NAME, O.ECLASS_ID, O.USER_DATA FROM OBJ O JOIN "
							+ resMapTable + " M ON M.RES_ID = O.RES_ID");
				} else {
					stmt = conn
							.prepare("SELECT O.RES_ID, O.FRAG, O.NAME, O.ECLASS_ID, O.USER_DATA FROM OBJ O JOIN "
									+ resMapTable
									+ " M ON M.RES_ID = O.RES_ID JOIN ECLASS_SUPERTYPES E ON O.ECLASS_ID = E.ECLASS_ID WHERE E.SUPERTYPE_ECLASS_ID = ?");
					stmt.setInt(1, packageRegistry.getEClassId(type));
				}
				return stmt;
			}
		};
	}

	public Iterable<IEObjectDescription> getExportedObjectsByType(final URI uri, final EClass type) {
		return new IEObjectDescriptionIterable() {
			@Override
			protected PreparedStatement createPreparedStatement() throws SQLException {
				ensureInitialized();
				Integer resId = resourceIdMap.get(uri.trimFragment());
				if (resId == null) {
					return null;
				}

				PreparedStatement stmt = null;
				if (type == EcorePackage.Literals.EOBJECT) {
					stmt = conn
							.prepare("SELECT O.RES_ID, O.FRAG, O.NAME, O.ECLASS_ID, O.USER_DATA FROM OBJ O WHERE O.RES_ID = ?");
					stmt.setInt(1, resId);
				} else {
					stmt = conn
							.prepare("SELECT O.RES_ID, O.FRAG, O.NAME, O.ECLASS_ID, O.USER_DATA FROM OBJ O JOIN ECLASS_SUPERTYPES E ON O.ECLASS_ID = E.ECLASS_ID WHERE O.RES_ID = ? AND E.SUPERTYPE_ECLASS_ID = ?");
					stmt.setInt(1, resId);
					stmt.setInt(2, packageRegistry.getEClassId(type));
				}
				return stmt;
			}
		};
	}

	private Object[] getUserData(final Object obj) {
		return (Object[]) obj;
	}

	public Iterable<IEObjectDescription> getExportedObjectsByObject(final EObject object) {
		return new IEObjectDescriptionIterable() {
			@Override
			protected PreparedStatement createPreparedStatement() throws SQLException {
				ensureInitialized();
				URI uri = EcoreUtil.getURI(object);
				Integer resId = resourceIdMap.get(uri.trimFragment());
				if (resId == null) {
					return null;
				}

				PreparedStatement stmt = conn
						.prepare("SELECT O.RES_ID, O.FRAG, O.NAME, O.ECLASS_ID, O.USER_DATA FROM OBJ O WHERE O.RES_ID = ? AND O.FRAG = ?");
				stmt.setInt(1, resId);
				stmt.setString(2, uri.fragment());
				return stmt;
			}
		};
	}

	public Iterable<QualifiedName> getImportedNames(final URI uri) {
		return new ClosingResultSetIterable<QualifiedName>() {
			@Override
			protected PreparedStatement createPreparedStatement() throws SQLException {
				ensureInitialized();
				Integer resId = resourceIdMap.get(uri.trimFragment());
				if (resId == null) {
					return null;
				}

				PreparedStatement stmt = conn.prepare("SELECT N.IMPORTED_NAME FROM RES_NAMES N WHERE N.RES_ID = ?");
				stmt.setInt(1, resId);
				return stmt;
			}

			@Override
			protected QualifiedName computeNext(final ResultSet resultSet) throws SQLException {
				return createQualifiedNameFromString(resultSet.getString(1));
			}
		};
	}

	public Iterable<IReferenceDescription> getReferenceDescriptions(final URI resource) {
		return new ClosingResultSetIterable<IReferenceDescription>() {
			@Override
			protected PreparedStatement createPreparedStatement() throws SQLException {
				ensureInitialized();
				Integer resId = resourceIdMap.get(resource);
				if (resId == null) {
					return null;
				}

				PreparedStatement stmt = conn
						.prepare("SELECT R.SRC_FRAG, R.CONT_FRAG, R.TGT_RES_ID, R.TGT_FRAG, R.EREF_ID, R.IDX FROM REF R WHERE R.RES_ID = ?");
				stmt.setInt(1, resId);
				return stmt;
			}

			@Override
			protected IReferenceDescription computeNext(final ResultSet resultSet) throws SQLException {
				// FIXME target resource ID may have wrong sign here...
				return new ImmutableReferenceDescription(resource.appendFragment(resultSet.getString(1)),
						resource.appendFragment(resultSet.getString(2)), getResourceURI(resultSet.getInt(3))
								.appendFragment(resultSet.getString(4)), packageRegistry.getEReference(resultSet
								.getInt(5)), resultSet.getInt(6));
			}
		};
	}

	public Iterable<IResourceDescription> findAllReferencingResources(
			final Iterable<IResourceDescription> targetResources, final ReferenceMatchPolicy matchPolicy) {
		if (Iterables.isEmpty(targetResources)) {
			return Collections.emptySet();
		}

		return new ClosingResultSetIterable<IResourceDescription>() {
			@Override
			protected PreparedStatement createPreparedStatement() throws SQLException {
				ensureInitialized();
				boolean matchReferences = matchPolicy.includes(MatchType.REFERENCES);
				boolean matchNames = matchPolicy.includes(MatchType.IMPORTED_NAMES);

				StringBuilder sql = new StringBuilder();
				if (matchReferences) {
					sql.append("SELECT DISTINCT R.RES_ID FROM REF R INNER JOIN TABLE(ID INT=?) T ON R.TGT_RES_ID = T.ID");
					if (matchNames)
						sql.append(" UNION");
				}
				if (matchNames) {
					sql.append(" SELECT DISTINCT N.RES_ID FROM RES_NAMES N INNER JOIN TABLE(NAME VARCHAR=?) X ON N.LOWER_IMPORTED_NAME = X.NAME");
				}
				PreparedStatement stmt = conn.prepare(sql);

				Set<String> allExportedNames = Sets.newHashSet();
				Object[] targetUris = new Object[Iterables.size(targetResources)];
				int i = 0;
				for (IResourceDescription target : targetResources) {
					if (matchReferences)
						targetUris[i++] = resourceIdMap.get(target.getURI());
					if (matchNames) {
						for (IEObjectDescription obj : target.getExportedObjects()) {
							allExportedNames.add(convertQualifiedNameToString(obj.getName().toLowerCase()));
						}
					}
				}

				int paramIdx = 1;
				if (matchReferences) {
					stmt.setObject(paramIdx++, targetUris);
				}
				if (matchNames) {
					stmt.setObject(paramIdx++, allExportedNames.toArray(new Object[allExportedNames.size()]));
				}

				return stmt;
			}

			@Override
			protected IResourceDescription computeNext(final ResultSet resultSet) throws SQLException {
				URI uri = getResourceURI(resultSet.getInt(1));
				return uri == null ? null : new DBBasedResourceDescription(DBBasedBuilderState.this, uri);
			}
		};
	}

	public Iterable<IResourceDescription> findObjectReferencingResources(
			final Iterable<IEObjectDescription> targetObjects, final ReferenceMatchPolicy matchPolicy) {
		if (Iterables.isEmpty(targetObjects)) {
			return Collections.emptySet();
		}

		return new ClosingResultSetIterable<IResourceDescription>() {
			@Override
			protected PreparedStatement createPreparedStatement() throws SQLException {
				ensureInitialized();
				boolean matchReferences = matchPolicy.includes(MatchType.REFERENCES);
				boolean matchNames = matchPolicy.includes(MatchType.IMPORTED_NAMES);

				StringBuilder sql = new StringBuilder();
				if (matchReferences) {
					sql.append("SELECT DISTINCT R.RES_ID FROM REF R INNER JOIN TABLE(ID INT=?, FRAG VARCHAR=?) T ON (R.TGT_RES_ID = T.ID AND R.TGT_FRAG = T.FRAG)");
					if (matchNames)
						sql.append(" UNION");
				}
				if (matchNames) {
					sql.append(" SELECT DISTINCT N.RES_ID FROM RES_NAMES N INNER JOIN TABLE(NAME VARCHAR=?) X ON N.LOWER_IMPORTED_NAME = X.NAME");
				}
				PreparedStatement stmt = conn.prepare(sql);

				Set<String> allExportedNames = Sets.newHashSet();
				Object[] targetResIds = new Object[Iterables.size(targetObjects)];
				Object[] targetFragments = new Object[targetResIds.length];
				int i = 0;
				for (IEObjectDescription obj : targetObjects) {
					if (matchReferences) {
						targetResIds[i] = resourceIdMap.get(obj.getEObjectURI().trimFragment());
						targetFragments[i] = obj.getEObjectURI().fragment();
						i++;
					}
					if (matchNames) {
						allExportedNames.add(convertQualifiedNameToString(obj.getName().toLowerCase()));
					}
				}

				int paramIdx = 1;
				if (matchReferences) {
					stmt.setObject(paramIdx++, targetResIds);
					stmt.setObject(paramIdx++, targetFragments);
				}
				if (matchNames) {
					stmt.setObject(paramIdx++, allExportedNames.toArray(new Object[allExportedNames.size()]));
				}

				return stmt;
			}

			@Override
			protected IResourceDescription computeNext(final ResultSet resultSet) throws SQLException {
				URI uri = getResourceURI(resultSet.getInt(1));
				return uri == null ? null : new DBBasedResourceDescription(DBBasedBuilderState.this, uri);
			}
		};
	}

	public Iterable<IReferenceDescription> findReferencesToObjects(final Iterable<URI> targetObjects) {
		return new ClosingResultSetIterable<IReferenceDescription>() {
			@Override
			protected PreparedStatement createPreparedStatement() throws SQLException {
				ensureInitialized();

				PreparedStatement stmt = conn
						.prepare("SELECT R.RES_ID, R.SRC_FRAG, R.CONT_FRAG, R.EREF_ID, R.TGT_RES_ID, R.TGT_FRAG, R.IDX REF R JOIN TABLE(ID INT=?, FRAG VARCHAR=?) T ON (R.TGT_RES_ID = T.ID AND R.TGT_FRAG = T.FRAG)");
				Object[] tgtResIdArray = new Object[Iterables.size(targetObjects)];
				Object[] tgtFragArray = new Object[tgtResIdArray.length];
				int idx = 0;
				for (URI uri : targetObjects) {
					tgtResIdArray[idx] = resourceIdMap.get(uri.trimFragment());
					tgtFragArray[idx] = uri.fragment();
					idx++;
				}
				stmt.setObject(1, tgtResIdArray);
				stmt.setObject(2, tgtFragArray);
				return stmt;
			}

			@Override
			protected IReferenceDescription computeNext(final ResultSet resultSet) throws SQLException {
				URI sourceUri = getResourceURI(resultSet.getInt(1));
				if (sourceUri == null)
					return null;
				String contFrag = resultSet.getString(3);
				return new ImmutableReferenceDescription(sourceUri.appendFragment(resultSet.getString(2)),
						contFrag != null ? sourceUri.appendFragment(contFrag) : null, getResourceURI(
								resultSet.getInt(5)).appendFragment(resultSet.getString(6)),
						packageRegistry.getEReference(resultSet.getInt(4)), resultSet.getInt(7));
			}
		};
	}

	private QualifiedName createQualifiedNameFromString(final String dotted) {
		return dotted.length() == 0 ? EMPTY_NAME : nameConverter.toQualifiedName(dotted);
	}

	private String convertQualifiedNameToString(final QualifiedName qn) {
		// FIXME use different delimiter; '.' is not allowed inside a name segment!
		return nameConverter.toString(qn);
	}

	public void beginChanges() {
		inTransaction = true;
	}

	public void commitChanges() {
		if (!inTransaction) {
			throw new IllegalStateException("Trying to commit changes before invocation of beginChanges()");
		}
		PreparedStatement refStmt = null;
		PreparedStatement resStmt = null;
		Connection c = conn.getConnection();
		try {
			refStmt = conn.prepare("DELETE FROM REF R WHERE NOT EXISTS (SELECT NULL FROM RES WHERE ID = R.TGT_RES_ID)");
			refStmt.execute();

			c.commit();
		} catch (SQLException e) {
			try {
				c.rollback();
			} catch (SQLException e1) {
				if (LOGGER.isDebugEnabled()) {
					LOGGER.debug("Cannot rollback transaction", e1);
				}
			}
			throw new DBException(e);
		} finally {
			conn.close(refStmt);
			conn.close(resStmt);
			inTransaction = false;
			reloadCaches();
		}
	}

	public void rollbackChanges() {
		if (!inTransaction) {
			throw new IllegalStateException("Trying to rollback changes before invocation of beginChanges()");
		}
		try {
			conn.getConnection().rollback();
		} catch (SQLException e) {
			throw new DBException(e);
		} finally {
			inTransaction = false;
			reloadCaches();
		}
	}

	public Set<URI> getAllURIs() {
		return Sets.newHashSet(new ClosingResultSetIterable<URI>() {
			@Override
			protected PreparedStatement createPreparedStatement() throws SQLException {
				ensureInitialized();
				return conn.prepare("SELECT R.URI FROM RES R JOIN " + resMapTable
						+ " M ON M.RES_ID = R.ID WHERE R.EXTERNAL = FALSE");
			}

			@Override
			protected URI computeNext(final ResultSet resultSet) throws SQLException {
				return URI.createURI(resultSet.getString(1));
			}
		});
	}

	private URI getResourceURI(final int id) {
		return resourceIdMap.inverse().get(id);
	}

	/**
	 * Implementation which returns closed statements to the statement pool.
	 */
	private abstract class ClosingResultSetIterable<T> extends ResultSetIterable<T> {
		@Override
		protected void closeStatement(final PreparedStatement stmt) {
			DBBasedBuilderState.this.conn.close(stmt);
		}
	}

	private abstract class IEObjectDescriptionIterable extends ClosingResultSetIterable<IEObjectDescription> {

		@Override
		protected IEObjectDescription computeNext(final ResultSet resultSet) throws SQLException {
			final EClass type = packageRegistry.getEClass(resultSet.getInt(4));
			return type != null ? new ImmutableEObjectDescription(
					createQualifiedNameFromString(resultSet.getString(3)), getResourceURI(resultSet.getInt(1))
							.appendFragment(resultSet.getString(2)), type, getUserData(resultSet.getObject(5))) : null;
		}
	}

}