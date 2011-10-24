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
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

import org.apache.log4j.Logger;
import org.h2.jdbc.JdbcPreparedStatement;

import com.google.common.collect.MapMaker;

/**
 * @author Knut Wannheden - Initial contribution and API
 */
public class StatementPool {

	/** Class-wide logger. */
	private static final Logger LOGGER = Logger.getLogger(StatementPool.class);

	private Connection conn;

	private final ConcurrentMap<String, PreparedStatement> statementPool = new ConcurrentHashMap<String, PreparedStatement>();
	private final Map<PreparedStatement, String> statementsInUse = new MapMaker().concurrencyLevel(1).softKeys()
			.softValues().makeMap();

	public StatementPool(Connection conn) {
		this.conn = conn;
	}

	public void clear() {
		statementPool.clear();
		statementsInUse.clear();
	}

	public PreparedStatement getPooledStatement(CharSequence sql) throws SQLException {
		String str = sql.toString();
		PreparedStatement stmt = null;
		synchronized (statementPool) {
			stmt = statementPool.remove(str);
			if (stmt == null) {
				stmt = conn.prepareStatement(str);
			} else if (((JdbcPreparedStatement) stmt).isClosed()) {
				LOGGER.warn("Closed statement found in pool: " + str);
				stmt = conn.prepareStatement(str);
			}
			statementsInUse.put(stmt, str);
		}
		return stmt;
	}

	public void returnToPool(PreparedStatement stmt) throws SQLException {
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
	}

}
