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
import java.sql.Statement;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.eclipse.emf.common.util.URI;

import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;

/**
 * @author Knut Wannheden - Initial contribution and API
 */
public class DBResourceMap {

	private final ConnectionWrapper conn;

	private boolean isOldMap;
	private final BiMap<URI, Integer> idMap;
	private final Map<Integer, URI> uriMap;
	private Set<URI> stashedResources = Sets.newHashSet();

	private DBResourceMap oldMap;

	public DBResourceMap(ConnectionWrapper conn) {
		this.conn = conn;
		this.idMap = Maps.synchronizedBiMap(HashBiMap.<URI, Integer> create());
		this.uriMap = idMap.inverse();
	}

	protected DBResourceMap(DBResourceMap oldMap, boolean keepOldState) {
		this.oldMap = oldMap;
		this.conn = oldMap.conn;
		this.idMap = Maps.synchronizedBiMap(HashBiMap.<URI, Integer> create(oldMap.idMap));
		this.uriMap = idMap.inverse();
		if (!keepOldState) {
			stashedResources = Sets.newHashSet(idMap.keySet());
		}
	}

	public DBResourceMap copy(boolean keepOldState) {
		resetOldResourceMap();
		isOldMap = true;
		oldMap = null;
		return new DBResourceMap(this, keepOldState);
	}

	// TODO add method to return only non-external URIs
	public Iterable<URI> getAllURIs() {
		return idMap.keySet();
	}

	public URI getURI(int id) {
		// it is possible that the WriteBehindBuffer has replaced the resource...
		if (isOldMap && uriMap.containsKey(-id))
			return uriMap.get(-id);
		return uriMap.get(id);
	}

	public boolean contains(URI uri) {
		return idMap.containsKey(uri);
	}

	public Integer getId(URI uri) {
		return idMap.get(uri);
	}

	public void register(URI uri, Integer resId) {
		idMap.put(uri, resId);
	}

	public void resetOldResourceMap() {
		PreparedStatement insStmt = null;
		try {
			Statement stmt = conn.getConnection().createStatement();
			stmt.addBatch("TRUNCATE TABLE OLD_RES_MAP");
			stmt.addBatch("DELETE FROM RES WHERE ID < 0");
			stmt.addBatch("DELETE FROM RES_NAMES WHERE RES_ID < 0");
			stmt.addBatch("DELETE FROM OBJ WHERE RES_ID < 0");
			stmt.addBatch("DELETE FROM REF WHERE RES_ID < 0");
			stmt.executeBatch();
			stmt.close();

			insStmt = conn.prepare("INSERT INTO OLD_RES_MAP DIRECT SORTED SELECT RES_ID FROM RES_MAP");
			insStmt.execute();
		} catch (SQLException e) {
			throw new DBException(e);
		} finally {
			conn.close(insStmt);
		}
	}

	public void commitChanges() {
		oldMap = null;
	}

	public void rollbackChanges() {
		if (oldMap != null) {
			oldMap.revert();
			oldMap = null;
		}
	}

	private void revert() {
		if (!isOldMap)
			throw new IllegalStateException("only old state can be reverted");

		for (Entry<URI, Integer> entry : idMap.entrySet()) {
			entry.setValue(Math.abs(entry.getValue()));
		}
		isOldMap = false;
	}

	public synchronized void reload() {
		PreparedStatement resStmt = null;
		try {
			clear();
			isOldMap = false;
			resStmt = conn.prepare("SELECT R.ID, R.URI FROM RES R JOIN " + getTable() + " M ON M.RES_ID = R.ID");
			resStmt.execute();
			ResultSet rs = resStmt.getResultSet();
			while (rs.next()) {
				register(URI.createURI(rs.getString(2)), rs.getInt(1));
			}
		} catch (SQLException e) {
			throw new DBException(e);
		} finally {
			conn.close(resStmt);
		}
	}

	public void clear() {
		idMap.clear();
		stashedResources.clear();
	}

	public String getTable() {
		return isOldMap ? "OLD_RES_MAP" : "RES_MAP";
	}

	public Integer stash(URI uri) {
		Integer id = idMap.get(uri);
		if (stashedResources.add(uri) && id != null) {
			PreparedStatement insStmt = null;
			try {
				insStmt = conn.prepare("INSERT INTO OLD_RES_MAP(RES_ID) VALUES(?)");
				insStmt.setInt(1, -id);
				insStmt.execute();
				if (oldMap != null)
					oldMap.register(uri, -id);
				return id;
			} catch (SQLException e) {
				throw new DBException(e);
			} finally {
				conn.close(insStmt);
			}
		}
		return null;
	}

	public Set<Integer> stashAll(Iterable<URI> uris) {
		Set<Integer> result = Sets.newHashSet();
		PreparedStatement insStmt = null;
		try {
			insStmt = conn.prepare("INSERT INTO OLD_RES_MAP(RES_ID) VALUES(?)");
			for (URI uri : uris) {
				Integer id = idMap.get(uri);
				if (stashedResources.add(uri) && id != null) {
					insStmt.setInt(1, -id);
					insStmt.addBatch();
					result.add(id);
					if (oldMap != null)
						oldMap.register(uri, -id);
				}
			}
			insStmt.executeBatch();
		} catch (SQLException e) {
			throw new DBException(e);
		} finally {
			conn.close(insStmt);
		}
		return result;
	}

}
