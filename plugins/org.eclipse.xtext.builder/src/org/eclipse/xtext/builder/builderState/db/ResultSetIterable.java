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
import java.util.Iterator;

import org.apache.log4j.Logger;
import org.eclipse.emf.common.util.WrappedException;
import org.h2.tools.SimpleResultSet;

import com.google.common.collect.AbstractIterator;

/**
 * @author Knut Wannheden - Initial contribution and API
 */
public abstract class ResultSetIterable<T> implements Iterable<T> {

	/** Class-wide logger. */
	private static final Logger LOGGER = Logger.getLogger(ResultSetIterable.class);

	private static final ResultSet EMPTY_RESULT_SET = new SimpleResultSet();

	public Iterator<T> iterator() {
		return new AbstractIterator<T>() {

			private PreparedStatement statement;
			private ResultSet resultSet;

			@Override
			protected T computeNext() {
				try {
					ResultSet rs = getResultSet();
					if (rs.next()) {
						T res = ResultSetIterable.this.computeNext(rs);
						// skip null results
						return res != null ? res : computeNext();
					} else {
						close();
						return endOfData();
					}
				} catch (SQLException e) {
					close();
					throw new WrappedException(e);
				}
			}

			private ResultSet getResultSet() throws SQLException {
				if (resultSet == null) {
					try {
						PreparedStatement stmt = getPreparedStatement();
						if (stmt != null) {
							stmt.execute();
							resultSet = stmt.getResultSet();
						} else {
							resultSet = EMPTY_RESULT_SET;
						}
					} catch (SQLException e) {
						throw new WrappedException(e);
					}
				}
				return resultSet;
			}

			/**
			 * {@link #createPreparedStatement() Creates} and returns the prepared statement.
			 * 
			 * @return statement
			 * @throws SQLException
			 *             if statement couldn't be created
			 */
			private PreparedStatement getPreparedStatement() throws SQLException {
				if (statement == null) {
					statement = createPreparedStatement();
				}
				return statement;
			}

			private void close() {
				closeStatement(statement);
				resultSet = null;
				statement = null;
			}

			@Override
			public String toString() {
				return "ResultSetIterable$1(" + statement + ')';
			}

		};
	}

	/**
	 * Return a {@link PreparedStatement} that will produces the {@link ResultSet}.
	 * 
	 * @return Valid statement representing valid SQL
	 * @throws SQLException
	 *             e
	 */
	protected abstract PreparedStatement createPreparedStatement() throws SQLException;

	/**
	 * Closes the prepared statement after all results have been iterated over or the object is finalized.
	 * 
	 * @param stmt
	 *            statement to close
	 */
	protected void closeStatement(final PreparedStatement stmt) {
		if (stmt != null) {
			try {
				stmt.close();
			} catch (SQLException e) {
				LOGGER.warn("Cannot close statement", e);
			}
		}
	}

	/**
	 * Create an object of type T from next result in result set.
	 * 
	 * @param resultSet
	 *            all results
	 * @return an object or null (will be skipped)
	 * @throws SQLException
	 *             e
	 */
	protected abstract T computeNext(ResultSet resultSet) throws SQLException;
}
