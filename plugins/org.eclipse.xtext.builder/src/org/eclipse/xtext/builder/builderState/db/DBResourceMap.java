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

import org.eclipse.emf.common.util.URI;

import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;
import com.google.common.collect.Maps;

/**
 * @author Knut Wannheden - Initial contribution and API
 */
public class DBResourceMap {

	private final ConnectionWrapper conn;

	private String resMapTable = "RES_MAP";
	private final BiMap<URI, Integer> resourceIdMap;

	public DBResourceMap(ConnectionWrapper conn) {
		this.conn = conn;
		this.resourceIdMap = Maps.synchronizedBiMap(HashBiMap.<URI, Integer> create());
	}

	protected DBResourceMap(ConnectionWrapper conn, BiMap<URI, Integer> resourceIdMap) {
		this.conn = conn;
		this.resourceIdMap = resourceIdMap;
	}

	public DBResourceMap copy() {
		resetOldResourceMap();
		return new DBResourceMap(conn, Maps.synchronizedBiMap(HashBiMap.<URI, Integer> create(resourceIdMap)));
	}

	public Iterable<URI> getAllURIs() {
		return resourceIdMap.keySet();
	}

	public URI getURI(int id) {
		return resourceIdMap.inverse().get(id);
	}

	public boolean contains(URI uri) {
		return resourceIdMap.containsKey(uri);
	}

	public Integer getId(URI uri) {
		return resourceIdMap.get(uri);
	}

	public void register(URI uri, Integer resId) {
		resourceIdMap.put(uri, resId);
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
				resourceIdMap.put(URI.createURI(rs.getString(2)), rs.getInt(1));
			}
		} catch (SQLException e) {
			throw new DBException(e);
		} finally {
			conn.close(resStmt);
		}
	}

	public void clear() {
		resourceIdMap.clear();
	}

	public String getTable() {
		return resMapTable;
	}

	public void setTable(String string) {
		resMapTable = "OLD_RES_MAP";
	}

}
