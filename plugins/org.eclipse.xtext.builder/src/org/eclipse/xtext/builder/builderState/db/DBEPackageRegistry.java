/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.builder.builderState.db;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Set;

import org.apache.log4j.Logger;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.util.EcoreUtil;

import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Sets;

/**
 * @author Knut Wannheden - Initial contribution and API
 */
public class DBEPackageRegistry {

	private static final Logger LOGGER = Logger.getLogger(DBEPackageRegistry.class);

	private static final Integer UNKNOWN_ECLASS = -1;

	private ConnectionWrapper conn;

	private final BiMap<EClass, Integer> classIdMap = HashBiMap.create();
	private final BiMap<EReference, Integer> referenceIdMap = HashBiMap.create();

	public DBEPackageRegistry(ConnectionWrapper conn) {
		this.conn = conn;
	}

	public void registerEClasses(final Iterable<EClass> eClasses) throws SQLException {
		Set<EClass> allMissingEClasses = Sets.newHashSet();
		for (EClass eClass : eClasses) {
			if (!isRegistered(eClass))
				allMissingEClasses.add(eClass);
			for (EClass superEClass : eClass.getEAllSuperTypes()) {
				if (!isRegistered(superEClass))
					allMissingEClasses.add(superEClass);
			}
		}

		if (allMissingEClasses.isEmpty())
			return;

		PreparedStatement eclassStmt = null;
		PreparedStatement eclassSupertypesStmt = null;
		PreparedStatement erefStmt = null;
		try {
			eclassStmt = conn.prepare("INSERT INTO ECLASS (ID, URI) VALUES (NEXTVAL('ECLASS_SEQ'), ?)");

			for (EClass eClass : allMissingEClasses) {
				String uri = EcoreUtil.getURI(eClass).toString();
				eclassStmt.setString(1, uri);
				eclassStmt.addBatch();
			}
			eclassStmt.executeBatch();

			eclassSupertypesStmt = conn
					.prepare("INSERT INTO ECLASS_SUPERTYPES (ECLASS_ID, SUPERTYPE_ECLASS_ID) VALUES (?, ?)");
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

			erefStmt = conn.prepare("INSERT INTO EREF (ID, URI) VALUES (NEXTVAL('EREF_SEQ'), ?)");
			for (EClass eClass : allMissingEClasses) {
				for (EReference ref : eClass.getEReferences()) {
					if (!(ref.isContainment() || ref.isContainer())) {
						erefStmt.setString(1, EcoreUtil.getURI(ref).toString());
						erefStmt.addBatch();
					}
				}
			}
			erefStmt.executeBatch();
		} finally {
			conn.close(eclassStmt);
			conn.close(eclassSupertypesStmt);
			conn.close(erefStmt);
		}
	}

	public boolean isRegistered(EClass eClass) throws SQLException {
		return !UNKNOWN_ECLASS.equals(getEClassId(eClass));
	}

	public void registerEReference(final EReference ref) throws SQLException {
		PreparedStatement erefStmt = null;
		try {
			erefStmt = conn.prepare("INSERT INTO EREF (ID, URI) VALUES (NEXTVAL('EREF_SEQ'), ?)"); //$NON-NLS-1$
			erefStmt.setString(1, EcoreUtil.getURI(ref).toString());
			erefStmt.execute();
		} finally {
			conn.close(erefStmt);
		}
	}

	public void reload() {
		clear();

		PreparedStatement eclassStmt = null;
		PreparedStatement erefStmt = null;
		try {
			eclassStmt = conn.prepare("SELECT ID, URI FROM ECLASS");
			eclassStmt.execute();
			ResultSet rs = eclassStmt.getResultSet();
			while (rs.next()) {
				EClass eClass = getEClass(URI.createURI(rs.getString(2)));
				if (eClass != null) {
					addEClassMapping(eClass, rs.getInt(1));
				}
			}
			eclassStmt = conn.prepare("SELECT ID, URI FROM EREF");
			eclassStmt.execute();
			rs = eclassStmt.getResultSet();
			while (rs.next()) {
				EReference ref = getEReference(URI.createURI(rs.getString(2)));
				if (ref != null) {
					addEReferenceMapping(ref, rs.getInt(1));
				}
			}
		} catch (SQLException e) {
			throw new DBException(e);
		} finally {
			conn.close(eclassStmt);
			conn.close(erefStmt);
		}
	}

	protected void addEClassMapping(EClass eClass, int id) {
		classIdMap.put(eClass, id);
	}

	protected void addEReferenceMapping(EReference eReference, int id) {
		referenceIdMap.put(eReference, id);
	}

	public void clear() {
		classIdMap.clear();
		referenceIdMap.clear();
	}

	public Integer getEClassId(final EClass type) throws SQLException {
		Integer result = classIdMap.get(type);
		if (result != null) {
			return result;
		}

		PreparedStatement stmt = null;
		try {
			stmt = conn.prepare("SELECT ID FROM ECLASS WHERE URI = ?");
			stmt.setString(1, EcoreUtil.getURI(type).toString());
			stmt.execute();
			ResultSet rs = stmt.getResultSet();
			if (rs.next()) {
				result = rs.getInt(1);
			} else {
				result = UNKNOWN_ECLASS;
			}
		} finally {
			conn.close(stmt);
		}
		if (!UNKNOWN_ECLASS.equals(result)) {
			addEClassMapping(type, result);
		}
		return result;
	}

	public EClass getEClass(final int id) throws SQLException {
		EClass result = classIdMap.inverse().get(id);
		if (result != null) {
			return result;
		}

		PreparedStatement stmt = null;
		URI uri = null;
		try {
			stmt = conn.prepare("SELECT URI FROM ECLASS WHERE ID = ?");
			stmt.setInt(1, id);
			stmt.execute();
			ResultSet rs = stmt.getResultSet();
			if (rs.next()) {
				uri = URI.createURI(rs.getString(1));
				result = getEClass(uri);
			}
		} finally {
			conn.close(stmt);
		}
		if (result != null) {
			addEClassMapping(result, id);
		} else {
			LOGGER.warn("No type found in registry for URI \"" + uri + '\"');
		}
		return result;
	}

	public Integer getEReferenceId(final EReference ref) throws SQLException {
		Integer result = referenceIdMap.get(ref);
		if (result != null) {
			return result;
		}

		PreparedStatement stmt = null;
		try {
			stmt = conn.prepare("SELECT ID FROM EREF WHERE URI = ?");
			stmt.setString(1, EcoreUtil.getURI(ref).toString());
			stmt.execute();
			ResultSet rs = stmt.getResultSet();
			if (rs.next()) {
				result = rs.getInt(1);
			} else {
				registerEReference(ref);
				return getEReferenceId(ref);
			}
		} finally {
			conn.close(stmt);
		}
		addEReferenceMapping(ref, result);
		return result;
	}

	public EReference getEReference(final int id) throws SQLException {
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
			stmt = conn.prepare("SELECT URI FROM EREF WHERE ID = ?");
			stmt.setInt(1, id);
			stmt.execute();
			ResultSet rs = stmt.getResultSet();
			if (rs.next()) {
				result = getEReference(URI.createURI(rs.getString(1)));
			}
		} finally {
			conn.close(stmt);
		}
		if (result != null) {
			addEReferenceMapping(result, id);
		}
		return result;
	}

	private EReference getEReference(final URI uri) {
		EPackage ePackage = EPackage.Registry.INSTANCE.getEPackage(uri.trimFragment().toString());
		if (ePackage == null) {
			return null;
		}
		if (ePackage.eResource() != null) {
			EObject eObject = ePackage.eResource().getEObject(uri.fragment());
			return eObject instanceof EReference ? (EReference) eObject : null;
		}
		for (EClassifier eClassifier : ePackage.getEClassifiers()) {
			if (eClassifier instanceof EClass) {
				for (EReference ref : ((EClass) eClassifier).getEReferences()) {
					if (EcoreUtil.getURI(ref).equals(uri)) {
						return ref;
					}
				}
			}
		}
		return null;
	}

	private EClass getEClass(final URI uri) {
		EPackage ePackage = EPackage.Registry.INSTANCE.getEPackage(uri.trimFragment().toString());
		if (ePackage != null) {
			if (ePackage.eResource() != null) {
				return (EClass) ePackage.eResource().getEObject(uri.fragment());
			}
			for (EClassifier eClassifier : ePackage.getEClassifiers()) {
				if (EcoreUtil.getURI(eClassifier).equals(uri) && eClassifier instanceof EClass) {
					return (EClass) eClassifier;
				}
			}
		}
		return null;
	}

}
