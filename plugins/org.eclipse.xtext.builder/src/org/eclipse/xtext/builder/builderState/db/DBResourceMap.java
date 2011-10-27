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

	private String resMapTable = "RES_MAP";
	private final BiMap<URI, Integer> idMap;
	private Set<URI> stashedResources = Sets.newHashSet();

	private DBResourceMap oldMap;

	public DBResourceMap(ConnectionWrapper conn) {
		this.conn = conn;
		this.idMap = Maps.synchronizedBiMap(HashBiMap.<URI, Integer> create());
	}

	protected DBResourceMap(DBResourceMap oldMap) {
		this.oldMap = oldMap;
		this.conn = oldMap.conn;
		this.idMap = Maps.synchronizedBiMap(HashBiMap.<URI, Integer> create(oldMap.idMap));
	}

	public DBResourceMap copy() {
		resetOldResourceMap();
		resMapTable = "OLD_RES_MAP";
		return new DBResourceMap(this);
	}

	public Iterable<URI> getAllURIs() {
		return idMap.keySet();
	}

	public URI getURI(int id) {
		return idMap.inverse().get(id);
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
		PreparedStatement refStmt = null;
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

			refStmt = conn.prepare("DELETE FROM REF R WHERE NOT EXISTS (SELECT NULL FROM RES WHERE ID = R.TGT_RES_ID)");
			refStmt.execute();
		} catch (SQLException e) {
			throw new DBException(e);
		} finally {
			conn.close(insStmt);
			conn.close(refStmt);
		}
	}

	public synchronized void reload() {
		PreparedStatement resStmt = null;
		try {
			resStmt = conn.prepare("SELECT R.ID, R.URI FROM RES R JOIN " + resMapTable + " M ON M.RES_ID = R.ID");
			resStmt.execute();
			ResultSet rs = resStmt.getResultSet();
			while (rs.next()) {
				idMap.put(URI.createURI(rs.getString(2)), rs.getInt(1));
			}
		} catch (SQLException e) {
			throw new DBException(e);
		} finally {
			conn.close(resStmt);
		}
	}

	public void clear() {
		idMap.clear();
	}

	public String getTable() {
		return resMapTable;
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
