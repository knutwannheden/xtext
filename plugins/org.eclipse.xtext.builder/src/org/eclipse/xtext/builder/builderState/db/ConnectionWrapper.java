/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.builder.builderState.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * @author Knut Wannheden - Initial contribution and API
 */
public class ConnectionWrapper {

	private Connection conn;
	private StatementPool statementPool;

	public ConnectionWrapper(Connection conn) {
		this.conn = conn;
		this.statementPool = new StatementPool();
	}

	public Connection getConnection() {
		return conn;
	}

	public PreparedStatement prepare(CharSequence sql) throws SQLException {
		return statementPool.getPooledStatement(conn, sql);
	}

	public void close(PreparedStatement stmt) {
		try {
			statementPool.returnToPool(stmt);
		} catch (SQLException e) {
			throw new DBException(e);
		}
	}

	public void clearCaches() {
		statementPool.clear();
	}

}
