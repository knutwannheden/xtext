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
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

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
import org.h2.jdbc.JdbcPreparedStatement;

import com.google.common.base.Function;
import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import com.google.common.collect.MapMaker;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;

/**
 * @author Knut Wannheden - Initial contribution and API
 */
public class DBBasedBuilderState implements IResourceDescriptions, IResourceDescriptionsExtension {

	/** Class-wide logger. */
	private static final Logger LOGGER = Logger.getLogger(DBBasedBuilderState.class);

	private static final QualifiedName EMPTY_NAME = QualifiedName.create();

	private static final String SCHEMA = "org/eclipse/xtext/builder/builderState/db/default-schema.sql";

	private static final Integer UNKNOWN_ECLASS = -1;
	private static final int MAX_REF_SRC_FRAG_LENGTH = 2500;

	private final Connection conn;
	private boolean initialized;

	private final ConcurrentMap<String, PreparedStatement> statementPool = new ConcurrentHashMap<String, PreparedStatement>();
	private final Map<PreparedStatement, String> statementsInUse = new MapMaker().concurrencyLevel(1).softKeys()
			.softValues().makeMap();

	private final BiMap<URI, Integer> resourceIdMap = Maps.synchronizedBiMap(HashBiMap.<URI, Integer> create());

	private final BiMap<EClass, Integer> classIdMap = HashBiMap.create();
	private final BiMap<EReference, Integer> referenceIdMap = HashBiMap.create();

	private boolean begin;

	// TODO should be injected
	private final IQualifiedNameConverter nameConverter = new IQualifiedNameConverter.DefaultImpl();

	public DBBasedBuilderState(final Connection conn) {
		this.conn = conn;
	}

	protected Connection getConnection() {
		return conn;
	}

	private synchronized void ensureInitialized() {
		if (!initialized) {
			PreparedStatement stmt = null;
			try {
				Connection c = getConnection();
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
				closeStatement(stmt);
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
		registerEPackages(Collections.<EPackage> singleton(EcorePackage.eINSTANCE));
		connection.commit();
		reloadCaches();
	}

	private void reloadCaches() {
		synchronized (resourceIdMap) {
			clearCaches();

			PreparedStatement resStmt = null;
			PreparedStatement eclassStmt = null;
			PreparedStatement erefStmt = null;
			try {
				resStmt = prepare("SELECT ID, URI FROM RES");
				resStmt.execute();
				ResultSet rs = resStmt.getResultSet();
				while (rs.next()) {
					resourceIdMap.put(URI.createURI(rs.getString(2)), rs.getInt(1));
				}
				eclassStmt = prepare("SELECT ID, URI FROM ECLASS");
				eclassStmt.execute();
				rs = eclassStmt.getResultSet();
				while (rs.next()) {
					EClass eClass = EClasses.getEClass(URI.createURI(rs.getString(2)));
					if (eClass != null) {
						classIdMap.put(eClass, rs.getInt(1));
					}
				}
				eclassStmt = prepare("SELECT ID, URI FROM EREF");
				eclassStmt.execute();
				rs = eclassStmt.getResultSet();
				while (rs.next()) {
					EReference ref = EClasses.getEReference(URI.createURI(rs.getString(2)));
					if (ref != null) {
						referenceIdMap.put(ref, rs.getInt(1));
					}
				}
			} catch (SQLException e) {
				throw new DBException(e);
			} finally {
				closeStatement(resStmt);
				closeStatement(eclassStmt);
				closeStatement(erefStmt);
			}
		}
	}

	private void clearCaches() {
		statementPool.clear();
		statementsInUse.clear();
		resourceIdMap.clear();
		classIdMap.clear();
		referenceIdMap.clear();
	}

	public void open() {
		ensureInitialized();
	}

	public synchronized void close(final boolean compact) {
		try {
			if (initialized && conn != null) {
				Connection c = getConnection();
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
			initializeSchema(getConnection());
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
				stmt = getConnection().createStatement();
				stmt.execute("SET UNDO_LOG=0");
				stmt.execute("SET LOG=0");
				insertResources(resourceDescriptions, false);
				commitChanges();
			} finally {
				if (stmt != null)
					stmt.close();
				stmt = getConnection().createStatement();
				stmt.execute("SET UNDO_LOG=1");
				stmt.execute("SET LOG=1");
				stmt.close();
			}
		} catch (SQLException e) {
			throw new DBException(e);
		}
	}

	private PreparedStatement prepare(final CharSequence sql) throws SQLException {
		String str = sql.toString();
		PreparedStatement stmt = null;
		synchronized (statementPool) {
			stmt = statementPool.remove(str);
			if (stmt == null) {
				stmt = getConnection().prepareStatement(str);
			} else if (((JdbcPreparedStatement) stmt).isClosed()) {
				LOGGER.error("Closed statement found in pool: " + str);
				stmt = getConnection().prepareStatement(str);
			}
			statementsInUse.put(stmt, str);
		}
		return stmt;
	}

	private void insertResources(final Iterable<IResourceDescription> resourceDescriptions, final boolean external) {
		PreparedStatement resIdStmt = null;
		PreparedStatement resInsStmt = null;
		PreparedStatement resUpdStmt = null;
		PreparedStatement resNamesStmt = null;
		PreparedStatement objStmt = null;
		PreparedStatement refStmt = null;

		try {
			Set<EPackage> ePackages = Sets.newHashSet();

			// reserve potentially required resource ids
			resIdStmt = getConnection().prepareStatement("SELECT NEXT VALUE FOR RES_SEQ FROM SYSTEM_RANGE(1, ?)");
			resIdStmt.setInt(1, Iterables.size(resourceDescriptions));
			ResultSet rs = resIdStmt.executeQuery();

			resInsStmt = prepare("INSERT INTO RES (ID, URI, OBSOLETE, EXTERNAL)" + " VALUES (?, ?, FALSE, ?)");
			resUpdStmt = prepare("UPDATE RES SET OBSOLETE = FALSE, EXTERNAL = ? WHERE ID = ?");

			for (IResourceDescription res : resourceDescriptions) {
				URI uri = res.getURI();
				Integer resId = resourceIdMap.get(uri);
				if (resId != null) {
					resUpdStmt.setBoolean(1, external);
					resUpdStmt.setInt(2, resId);
					resUpdStmt.addBatch();
				} else {
					rs.next();
					resId = rs.getInt(1);
					resInsStmt.setInt(1, resId);
					resInsStmt.setString(2, uri.toString());
					resInsStmt.setBoolean(3, external);
					resInsStmt.addBatch();
					resourceIdMap.put(uri, resId);
				}

				for (IEObjectDescription obj : res.getExportedObjects()) {
					EPackage ePackage = obj.getEClass().getEPackage();
					if (ePackage != null) {
						ePackages.add(ePackage);
					}
				}
			}
			resInsStmt.executeBatch();
			resUpdStmt.executeBatch();

			registerEPackages(ePackages);

			resNamesStmt = prepare("INSERT INTO RES_NAMES (RES_ID, IMPORTED_NAME)" + " VALUES (?, ?)");

			for (IResourceDescription res : resourceDescriptions) {
				Integer resUri = resourceIdMap.get(res.getURI());
				for (QualifiedName name : res.getImportedNames()) {
					resNamesStmt.setInt(1, resUri);
					resNamesStmt.setString(2, convertQualifiedNameToString(name));
					resNamesStmt.addBatch();
				}
			}
			resNamesStmt.executeBatch();

			objStmt = prepare("INSERT INTO OBJ (RES_ID, FRAG, NAME, ECLASS_ID, USER_DATA) VALUES (?, ?, ?, ?, ?)");
			refStmt = prepare("INSERT INTO REF (RES_ID, SRC_FRAG, CONT_FRAG, TGT_RES_ID, TGT_FRAG, EREF_ID, IDX) VALUES (?, ?, ?, ?, ?, ?, ?)");

			for (IResourceDescription res : resourceDescriptions) {
				Integer resId = resourceIdMap.get(res.getURI());
				for (IEObjectDescription obj : res.getExportedObjects()) {
					objStmt.setInt(1, resId);
					objStmt.setString(2, obj.getEObjectURI().fragment());
					objStmt.setString(3, convertQualifiedNameToString(obj.getName()));
					objStmt.setInt(4, getEClassId(obj.getEClass()));
					objStmt.setObject(5, getUserDataArray(obj));
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
					String srcFrag = srcUri.fragment();
					if (srcFrag.length() > MAX_REF_SRC_FRAG_LENGTH) {
						LOGGER.error("Reference source fragment too long: " + srcUri + ". Skipping.");
						continue;
					}
					refStmt.setString(2, srcFrag);
					if (contUri != null) {
						refStmt.setString(3, contUri.fragment());
					} else {
						refStmt.setNull(3, Types.VARCHAR);
					}
					refStmt.setInt(4, tgtResId);
					refStmt.setString(5, tgtUri.fragment());
					EReference eReference = ref.getEReference();
					if (eReference != null) {
						refStmt.setInt(6, getEReferenceId(eReference));
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
			closeStatement(resIdStmt);
			closeStatement(resInsStmt);
			closeStatement(resUpdStmt);
			closeStatement(resNamesStmt);
			closeStatement(objStmt);
			closeStatement(refStmt);
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
			resStmt = prepare("SELECT R.ID, R.URI FROM RES R INNER JOIN TABLE(ID INT=?) I ON R.ID = I.ID");
			resStmt.setObject(1, idArray);
			resStmt.execute();
			ResultSet rs = resStmt.getResultSet();
			while (rs.next()) {
				result.put(rs.getInt(1), new SelectableDBBasedResourceDescription(this, URI.createURI(rs.getString(2))));
			}

			IEObjectDescriptionIterable objects = new IEObjectDescriptionIterable() {
				@Override
				protected PreparedStatement createPreparedStatement() throws SQLException {
					PreparedStatement stmt = prepare("SELECT O.RES_ID, O.FRAG, O.NAME, O.ECLASS_ID, O.USER_DATA FROM OBJ O INNER JOIN TABLE(ID INT=?) I ON O.RES_ID = I.ID");
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
			closeStatement(resStmt);
			closeStatement(objStmt);
		}

		return result.values();
	}

	/**
	 * Loads all object names present in the database associated with the URIs in which they occur. TODO: consider using
	 * URI[] arrays (or even Object => URI, URI[]) to save more memory
	 * 
	 * @param destination
	 *            map to which to add all names to the respective resources mappings
	 */
	public void loadAllQualifiedNames(final Map<QualifiedName, Collection<URI>> destination) {
		ensureInitialized();
		PreparedStatement stmt = null;
		try {
			stmt = prepare("SELECT NAME, RES_ID FROM OBJ");
			stmt.execute();
			ResultSet rs = stmt.getResultSet();
			while (rs.next()) {
				QualifiedName name = createQualifiedNameFromString(rs.getString(1).toLowerCase());
				Collection<URI> resources = destination.get(name);
				URI resource = getResourceURI(rs.getInt(2));
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
			closeStatement(stmt);
		}
	}

	private void registerEPackages(final Set<EPackage> ePackages) throws SQLException {
		Set<EClass> allMissingEClasses = Sets.newHashSet();
		for (EPackage ePackage : ePackages) {
			for (EClass eClass : Iterables.filter(ePackage.getEClassifiers(), EClass.class)) {
				allMissingEClasses.add(eClass);
				for (EClass superEClass : eClass.getEAllSuperTypes()) {
					allMissingEClasses.add(superEClass);
				}
			}
		}
		for (Iterator<EClass> it = allMissingEClasses.iterator(); it.hasNext();) {
			EClass eClass = it.next();
			if (!UNKNOWN_ECLASS.equals(getEClassId(eClass))) {
				it.remove();
			}
		}

		PreparedStatement eclassStmt = null;
		PreparedStatement eclassSupertypesStmt = null;
		PreparedStatement erefStmt = null;
		try {
			eclassStmt = prepare("INSERT INTO ECLASS (ID, URI) VALUES (NEXTVAL('ECLASS_SEQ'), ?)");

			for (EClass eClass : allMissingEClasses) {
				String uri = EcoreUtil.getURI(eClass).toString();
				eclassStmt.setString(1, uri);
				eclassStmt.addBatch();
			}
			eclassStmt.executeBatch();

			eclassSupertypesStmt = prepare("INSERT INTO ECLASS_SUPERTYPES (ECLASS_ID, SUPERTYPE_ECLASS_ID)"
					+ " VALUES (?, ?)");
			for (EClass eClass : allMissingEClasses) {
				Integer eClassId = getEClassId(eClass);
				for (EClass superType : eClass.getEAllSuperTypes()) {
					eclassSupertypesStmt.setInt(1, eClassId);
					eclassSupertypesStmt.setInt(2, getEClassId(superType));
					eclassSupertypesStmt.addBatch();
				}
				// add classes as their own supertypes:
				eclassSupertypesStmt.setInt(1, eClassId);
				eclassSupertypesStmt.setInt(2, eClassId);
				eclassSupertypesStmt.addBatch();
			}
			eclassSupertypesStmt.executeBatch();

			erefStmt = prepare("INSERT INTO EREF (ID, URI) VALUES (NEXTVAL('EREF_SEQ'), ?)");
			for (EClass eClass : allMissingEClasses) {
				for (EReference feature : eClass.getEReferences()) {
					erefStmt.setString(1, EcoreUtil.getURI(feature).toString());
					erefStmt.addBatch();
				}
			}
			erefStmt.executeBatch();
		} finally {
			closeStatement(eclassStmt);
			closeStatement(eclassSupertypesStmt);
			closeStatement(erefStmt);
		}
	}

	public Iterable<EClass> getSupertypes(final EClass type) {
		return new ClosingResultSetIterable<EClass>() {
			@Override
			protected PreparedStatement createPreparedStatement() throws SQLException {
				ensureInitialized();
				PreparedStatement stmt = prepare("SELECT SUPER.URI FROM ECLASS SUB, ECLASS SUPER, ECLASS_SUPERTYPES S WHERE SUB.ID = S.ECLASS_ID AND SUPER.ID = S.SUPERTYPE_ECLASS_ID AND SUB.URI = ?"); //$NON-NLS-1$
				stmt.setString(1, EcoreUtil.getURI(type).toString());
				return stmt;
			}

			@Override
			protected EClass computeNext(final ResultSet resultSet) throws SQLException {
				return EClasses.getEClass(URI.createURI(resultSet.getString(1)));
			}
		};
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

	private void deleteResourceDescriptions(final Iterable<URI> uris) {
		PreparedStatement refStmt = null;
		PreparedStatement objStmt = null;
		PreparedStatement resNamesStmt = null;
		PreparedStatement resStmt = null;
		try {
			refStmt = prepare("DELETE FROM REF WHERE RES_ID = ?");
			objStmt = prepare("DELETE FROM OBJ WHERE RES_ID = ?");
			resNamesStmt = prepare("DELETE FROM RES_NAMES WHERE RES_ID = ?");
			resStmt = prepare("UPDATE RES SET OBSOLETE = TRUE WHERE ID = ?");
			for (URI uri : uris) {
				Integer resId = resourceIdMap.get(uri);
				if (resId != null) {
					refStmt.setInt(1, resId);
					refStmt.addBatch();
					objStmt.setInt(1, resId);
					objStmt.addBatch();
					resNamesStmt.setInt(1, resId);
					resNamesStmt.addBatch();
					resStmt.setInt(1, resId);
					resStmt.addBatch();
				}
			}
			refStmt.executeBatch();
			objStmt.executeBatch();
			resNamesStmt.executeBatch();
			resStmt.executeBatch();
		} catch (SQLException e) {
			throw new DBException(e);
		} finally {
			closeStatement(refStmt);
			closeStatement(objStmt);
			closeStatement(resNamesStmt);
			closeStatement(resStmt);
		}
	}

	private Object[] getUserDataArray(final IEObjectDescription obj) {
		String[] keys = obj.getUserDataKeys();
		Object[] result = new String[keys.length * 2];
		for (int i = 0; i < keys.length; i++) {
			result[i] = keys[i];
			result[keys.length + i] = obj.getUserData(keys[i]);
		}
		return result;
	}

	public boolean isEmpty() {
		ensureInitialized();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			stmt = prepare("SELECT COUNT(*) FROM RES WHERE OBSOLETE = FALSE AND EXTERNAL = FALSE");
			stmt.execute();
			rs = stmt.getResultSet();
			rs.next();
			return rs.getInt(1) == 0;
		} catch (SQLException e) {
			throw new DBException(e);
		} finally {
			closeStatement(stmt);
		}
	}

	public Iterable<IResourceDescription> getAllResourceDescriptions() {
		return new ClosingResultSetIterable<IResourceDescription>() {
			@Override
			protected PreparedStatement createPreparedStatement() throws SQLException {
				ensureInitialized();
				return prepare("SELECT ID FROM RES WHERE OBSOLETE = FALSE AND EXTERNAL = FALSE");
			}

			@Override
			protected IResourceDescription computeNext(final ResultSet resultSet) throws SQLException {
				return new DBBasedResourceDescription(DBBasedBuilderState.this, getResourceURI(resultSet.getInt(1)));
			}
		};
	}

	public IResourceDescription getResourceDescription(final URI normalizedURI) {
		ensureInitialized();
		PreparedStatement stmt = null;
		try {
			stmt = prepare("SELECT ID FROM RES WHERE URI = ? AND OBSOLETE = FALSE AND EXTERNAL = FALSE");
			stmt.setString(1, normalizedURI.toString());
			stmt.execute();
			ResultSet rs = stmt.getResultSet();
			if (rs.next()) {
				return new DBBasedResourceDescription(this, normalizedURI);
			}
		} catch (SQLException e) {
			throw new DBException(e);
		} finally {
			closeStatement(stmt);
		}
		return null;
	}

	public Iterable<IEObjectDescription> getExportedObjects() {
		return new IEObjectDescriptionIterable() {
			@Override
			protected PreparedStatement createPreparedStatement() throws SQLException {
				ensureInitialized();
				// No need to restrict to "R.OBSOLETE = FALSE": there are no exported objects for deleted resources, hence join returns empty set
				return prepare("SELECT O.RES_ID, O.FRAG, O.NAME, O.ECLASS_ID, O.USER_DATA FROM OBJ O");
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

				// No need to restrict to "R.OBSOLETE = FALSE": there are no exported objects for deleted resources, hence join returns empty set
				PreparedStatement stmt = prepare("SELECT O.RES_ID, O.FRAG, O.NAME, O.ECLASS_ID, O.USER_DATA FROM OBJ O WHERE O.RES_ID = ?");
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
				// FIXME should probably be removed
				boolean patternMatch = match.indexOf('*') != -1 || match.indexOf('?') != -1;
				if (patternMatch) {
					match = toSqlPattern(match);
				}

				String operator = patternMatch ? "LIKE" : "=";

				// No need to restrict to "R.OBSOLETE = FALSE": there are no exported objects for deleted resources, hence join returns empty set
				StringBuilder query = new StringBuilder(
						"SELECT O.RES_ID, O.FRAG, O.NAME, O.ECLASS_ID, O.USER_DATA FROM OBJ O");
				if (matchAllObjects) {
					query.append(" WHERE 1=1");
				} else {
					query.append(" JOIN ECLASS_SUPERTYPES E ON O.ECLASS_ID = E.ECLASS_ID WHERE E.SUPERTYPE_ECLASS_ID = ?2");
				}

				if (!ignoreCase) {
					query.append(" AND O.NAME ").append(operator).append(" ?1");
				} else {
					query.append(" AND LOWER(O.NAME) ").append(operator).append(" LOWER(?1)");
				}

				PreparedStatement stmt = prepare(query);
				stmt.setString(1, match);
				if (!matchAllObjects) {
					stmt.setInt(2, getEClassId(type));
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
				// FIXME should probably be removed
				boolean patternMatch = match.indexOf('*') != -1 || match.indexOf('?') != -1;
				if (patternMatch) {
					match = toSqlPattern(match);
				}

				String operator = patternMatch ? "LIKE" : "=";

				// No need to restrict to "R.OBSOLETE = FALSE": there are no exported objects for deleted resources, hence join returns empty set
				StringBuilder query = new StringBuilder(
						"SELECT O.RES_ID, O.FRAG, O.NAME, O.ECLASS_ID, O.USER_DATA FROM OBJ O ");
				if (matchAllObjects) {
					query.append(" WHERE O.RES_ID = ?1");
				} else {
					query.append(" JOIN ECLASS_SUPERTYPES E ON O.ECLASS_ID = E.ECLASS_ID WHERE O.RES_ID = ?1 AND E.SUPERTYPE_ECLASS_ID = ?3");
				}

				if (!ignoreCase) {
					query.append(" AND O.NAME ").append(operator).append(" ?2");
				} else {
					query.append(" AND LOWER(O.NAME) ").append(operator).append(" LOWER(?2)");
				}

				PreparedStatement stmt = prepare(query);
				stmt.setInt(1, resId);
				stmt.setString(2, match);
				if (!matchAllObjects) {
					stmt.setInt(3, getEClassId(type));
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
				// No need to restrict to "R.OBSOLETE = FALSE": there are no exported objects for deleted resources, hence join returns empty set
				PreparedStatement stmt = null;
				if (type == EcorePackage.Literals.EOBJECT) {
					stmt = prepare("SELECT O.RES_ID, O.FRAG, O.NAME, O.ECLASS_ID, O.USER_DATA FROM OBJ O");
				} else {
					stmt = prepare("SELECT O.RES_ID, O.FRAG, O.NAME, O.ECLASS_ID, O.USER_DATA FROM OBJ O JOIN ECLASS_SUPERTYPES E ON O.ECLASS_ID = E.ECLASS_ID WHERE E.SUPERTYPE_ECLASS_ID = ?");
					stmt.setInt(1, getEClassId(type));
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

				// No need to restrict to "R.OBSOLETE = FALSE": there are no exported objects for deleted resources, hence join returns empty set
				PreparedStatement stmt = null;
				if (type == EcorePackage.Literals.EOBJECT) {
					stmt = prepare("SELECT O.RES_ID, O.FRAG, O.NAME, O.ECLASS_ID, O.USER_DATA FROM OBJ O WHERE O.RES_ID = ?");
					stmt.setInt(1, resId);
				} else {
					stmt = prepare("SELECT O.RES_ID, O.FRAG, O.NAME, O.ECLASS_ID, O.USER_DATA FROM OBJ O JOIN ECLASS_SUPERTYPES E ON O.ECLASS_ID = E.ECLASS_ID WHERE O.RES_ID = ? AND E.SUPERTYPE_ECLASS_ID = ?");
					stmt.setInt(1, resId);
					stmt.setInt(2, getEClassId(type));
				}
				return stmt;
			}
		};
	}

	private Integer getEClassId(final EClass type) throws SQLException {
		Integer result = classIdMap.get(type);
		if (result != null) {
			return result;
		}

		PreparedStatement stmt = null;
		try {
			stmt = prepare("SELECT ID FROM ECLASS WHERE URI = ?");
			stmt.setString(1, EcoreUtil.getURI(type).toString());
			stmt.execute();
			ResultSet rs = stmt.getResultSet();
			if (rs.next()) {
				result = rs.getInt(1);
			} else {
				result = UNKNOWN_ECLASS;
			}
		} finally {
			closeStatement(stmt);
		}
		if (!UNKNOWN_ECLASS.equals(result)) {
			classIdMap.put(type, result);
		}
		return result;
	}

	private EClass getEClass(final int id) throws SQLException {
		EClass result = classIdMap.inverse().get(id);
		if (result != null) {
			return result;
		}

		PreparedStatement stmt = null;
		URI uri = null;
		try {
			stmt = prepare("SELECT URI FROM ECLASS WHERE ID = ?");
			stmt.setInt(1, id);
			stmt.execute();
			ResultSet rs = stmt.getResultSet();
			if (rs.next()) {
				uri = URI.createURI(rs.getString(1));
				result = EClasses.getEClass(uri);
			}
		} finally {
			closeStatement(stmt);
		}
		if (result != null) {
			classIdMap.put(result, id);
		} else {
			LOGGER.warn("No type found in registry for URI \"" + uri + '\"');
		}
		return result;
	}

	private Integer getEReferenceId(final EReference ref) throws SQLException {
		Integer result = referenceIdMap.get(ref);
		if (result != null) {
			return result;
		}

		PreparedStatement stmt = null;
		try {
			stmt = prepare("SELECT ID FROM EREF WHERE URI = ?");
			stmt.setString(1, EcoreUtil.getURI(ref).toString());
			stmt.execute();
			ResultSet rs = stmt.getResultSet();
			if (rs.next()) {
				result = rs.getInt(1);
			} else {
				closeStatement(stmt);
				stmt = prepare("SELECT 1 FROM ECLASS WHERE URI = ?");
				stmt.setString(1, EcoreUtil.getURI(ref.getEContainingClass()).toString());
				stmt.execute();
				rs = stmt.getResultSet();
				if (rs.next()) {
					LOGGER.error("Index metadata out of sync for EClass " + EcoreUtil.getURI(ref.getEContainingClass()));
					return 0;
				} else {
					registerEPackages(ImmutableSet.of(ref.getEContainingClass().getEPackage()));
					result = getEReferenceId(ref);
				}
			}
		} finally {
			closeStatement(stmt);
		}
		referenceIdMap.put(ref, result);
		return result;
	}

	private EReference getEReference(final int id) throws SQLException {
		if (id == 0) {
			// implies SQL NULL
			return null;
		}
		EReference result = referenceIdMap.inverse().get(id);
		if (result != null) {
			return result;
		}

		PreparedStatement stmt = null;
		try {
			stmt = prepare("SELECT URI FROM EREF WHERE ID = ?");
			stmt.setInt(1, id);
			stmt.execute();
			ResultSet rs = stmt.getResultSet();
			if (rs.next()) {
				result = EClasses.getEReference(URI.createURI(rs.getString(1)));
			}
		} finally {
			closeStatement(stmt);
		}
		if (result != null) {
			referenceIdMap.put(result, id);
			// } else {
			// throw new IllegalArgumentException("Unknown reference " + id);
		}
		return result;
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

				// No need to restrict to "R.OBSOLETE = FALSE": there are no exported objects for deleted resources, hence join returns empty set
				PreparedStatement stmt = prepare("SELECT O.RES_ID, O.FRAG, O.NAME, O.ECLASS_ID, O.USER_DATA FROM OBJ O WHERE O.RES_ID = ? AND O.FRAG = ?");
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

				PreparedStatement stmt = prepare("SELECT N.IMPORTED_NAME FROM RES_NAMES N WHERE N.RES_ID = ?");
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
				// No need to restrict to "R.OBSOLETE = FALSE": there are no references for deleted resources, hence join returns empty set
				PreparedStatement stmt = prepare("SELECT R.URI, D.SRC_FRAG, D.CONT_FRAG, D.TGT_RES_ID, D.TGT_FRAG, D.EREF_ID, D.IDX FROM REF D JOIN RES R ON D.RES_ID = R.ID WHERE R.URI = ?");
				stmt.setString(1, resource.toString());
				return stmt;
			}

			@Override
			protected IReferenceDescription computeNext(final ResultSet resultSet) throws SQLException {
				URI sourceUri = URI.createURI(resultSet.getString(1));
				return new ImmutableReferenceDescription(sourceUri.appendFragment(resultSet.getString(2)),
						sourceUri.appendFragment(resultSet.getString(3)), getResourceURI(resultSet.getInt(4))
								.appendFragment(resultSet.getString(5)), getEReference(resultSet.getInt(6)),
						resultSet.getInt(7));
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

				// No need to restrict to "R.OBSOLETE = FALSE": there are no references for deleted resources, hence join returns empty set
				StringBuilder sql = new StringBuilder();
				if (matchReferences) {
					sql.append("SELECT DISTINCT D.RES_ID FROM REF D INNER JOIN RES S ON D.RES_ID = S.ID INNER JOIN TABLE(ID INT=?) T ON D.TGT_RES_ID = T.ID");
					if (matchNames)
						sql.append(" UNION");
				}
				if (matchNames) {
					sql.append(" SELECT DISTINCT N.RES_ID FROM RES_NAMES N INNER JOIN TABLE(NAME VARCHAR=?) X ON N.LOWER_IMPORTED_NAME = X.NAME");
				}
				PreparedStatement stmt = prepare(sql);

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
				return new DBBasedResourceDescription(DBBasedBuilderState.this, getResourceURI(resultSet.getInt(1)));
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

				// No need to restrict to "R.OBSOLETE = FALSE": there are no references for deleted resources, hence join returns empty set
				StringBuilder sql = new StringBuilder();
				if (matchReferences) {
					sql.append("SELECT DISTINCT D.RES_ID FROM REF D INNER JOIN TABLE(ID INT=?, FRAG VARCHAR=?) T ON (D.TGT_RES_ID = T.ID AND D.TGT_FRAG = T.FRAG)");
					if (matchNames)
						sql.append(" UNION");
				}
				if (matchNames) {
					sql.append(" SELECT DISTINCT N.RES_ID FROM RES_NAMES N INNER JOIN TABLE(NAME VARCHAR=?) X ON N.LOWER_IMPORTED_NAME = X.NAME");
				}
				PreparedStatement stmt = prepare(sql);

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
				return new DBBasedResourceDescription(DBBasedBuilderState.this, getResourceURI(resultSet.getInt(1)));
			}
		};
	}

	public Iterable<IReferenceDescription> findReferencesToObjects(final Iterable<URI> targetObjects) {
		return new ClosingResultSetIterable<IReferenceDescription>() {
			@Override
			protected PreparedStatement createPreparedStatement() throws SQLException {
				ensureInitialized();
				// No need to restrict to "R.OBSOLETE = FALSE": there are no references for deleted resources, hence join returns empty set
				PreparedStatement stmt = prepare("SELECT S.URI, D.SRC_FRAG, D.CONT_FRAG, D.EREF_ID, D.TGT_RES_ID, D.TGT_FRAG, D.IDX FROM RES S JOIN REF D ON (D.RES_ID = S.ID) JOIN TABLE(ID INT=?, FRAG VARCHAR=?) T ON (D.TGT_RES_ID = T.ID AND D.TGT_FRAG = T.FRAG)");
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
				URI sourceUri = URI.createURI(resultSet.getString(1));
				String contFrag = resultSet.getString(3);
				return new ImmutableReferenceDescription(sourceUri.appendFragment(resultSet.getString(2)),
						contFrag != null ? sourceUri.appendFragment(contFrag) : null, getResourceURI(
								resultSet.getInt(5)).appendFragment(resultSet.getString(6)),
						getEReference(resultSet.getInt(4)), resultSet.getInt(7));
			}
		};
	}

	private void closeStatement(final PreparedStatement stmt) {
		try {
			if (stmt != null) {
				synchronized (statementPool) {
					String sql = statementsInUse.remove(stmt);
					if (sql != null) {
						if (statementPool.putIfAbsent(sql, stmt) != null) {
							stmt.close();
						}
					} else {
						stmt.close();
					}
				}
			}
		} catch (SQLException e) {
			throw new DBException(e);
		}
	}

	private QualifiedName createQualifiedNameFromString(final String dotted) {
		return dotted.length() == 0 ? EMPTY_NAME : nameConverter.toQualifiedName(dotted);
	}

	private String convertQualifiedNameToString(final QualifiedName qn) {
		// FIXME use different delimiter; '.' is not allowed inside a name segment!
		return nameConverter.toString(qn);
	}

	public DBBasedBuilderState copy(Set<URI> toBeUpdated, Set<URI> toBeDeleted) {
		// FIXME return copy and set this to access old copied entries (where appropriate)
		return this;
	}

	public void beginChanges() {
		begin = true;
	}

	public void commitChanges() {
		if (!begin) {
			throw new IllegalStateException("Trying to commit changes before invocation of beginChanges()");
		}
		PreparedStatement refStmt = null;
		PreparedStatement resStmt = null;
		Connection c = getConnection();
		try {
			refStmt = prepare("DELETE FROM REF WHERE TGT_RES_ID IN (SELECT ID FROM RES WHERE OBSOLETE = TRUE)");
			refStmt.execute();
			resStmt = prepare("DELETE FROM RES WHERE OBSOLETE = TRUE");
			resStmt.execute();

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
			closeStatement(refStmt);
			closeStatement(resStmt);
			begin = false;
			reloadCaches();
		}
	}

	public void rollbackChanges() {
		if (!begin) {
			throw new IllegalStateException("Trying to rollback changes before invocation of beginChanges()");
		}
		try {
			getConnection().rollback();
		} catch (SQLException e) {
			throw new DBException(e);
		} finally {
			begin = false;
			reloadCaches();
		}
	}

	public Set<URI> getAllURIs() {
		return Sets.newHashSet(new ClosingResultSetIterable<URI>() {
			@Override
			protected PreparedStatement createPreparedStatement() throws SQLException {
				ensureInitialized();
				return prepare("SELECT URI FROM RES WHERE EXTERNAL = FALSE");
			}

			@Override
			protected URI computeNext(final ResultSet resultSet) throws SQLException {
				return URI.createURI(resultSet.getString(1));
			}
		});
	}

	/**
	 * Returns the URI of the given resource.
	 * 
	 * @param id
	 *            ID of resource
	 * @return URI of resource
	 */
	private URI getResourceURI(final int id) {
		return resourceIdMap.inverse().get(id);
	}

	/**
	 * Converts a GLOB pattern to an SQL pattern: '*' -> '%', '?' -> '_', '%' -> '\%', and '_' -> '\_'.
	 * 
	 * @param globPattern
	 *            pattern to convert
	 * @return converted pattern
	 */
	private static String toSqlPattern(final String globPattern) {
		int len = globPattern.length();

		StringBuilder res = new StringBuilder(len + 2);
		for (int i = 0; i < len; i++) {
			char c = globPattern.charAt(i);
			switch (c) {
				case '*':
					res.append('%');
					break;
				case '?':
					res.append('_');
					break;
				case '%':
				case '_':
					res.append('\\');
				default:
					res.append(c);
					break;
			}
		}
		return res.toString();
	}

	/**
	 * Implementation which returns closed statements to the statement pool.
	 */
	private abstract class ClosingResultSetIterable<T> extends ResultSetIterable<T> {
		@Override
		protected void closeStatement(final PreparedStatement stmt) {
			DBBasedBuilderState.this.closeStatement(stmt);
		}
	}

	/**
	 * Create an {@link IEObjectDescription} object from a database {@link ResultSet}.
	 */
	private abstract class IEObjectDescriptionIterable extends ClosingResultSetIterable<IEObjectDescription> {

		@Override
		protected IEObjectDescription computeNext(final ResultSet resultSet) throws SQLException {
			final EClass type = getEClass(resultSet.getInt(4));
			return type != null ? new ImmutableEObjectDescription(
					createQualifiedNameFromString(resultSet.getString(3)), getResourceURI(resultSet.getInt(1))
							.appendFragment(resultSet.getString(2)), type, getUserData(resultSet.getObject(5))) : null;
		}
	}

}
