/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.builder.builderState.db;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.apache.log4j.Logger;
import org.eclipse.core.resources.ISaveContext;
import org.eclipse.core.resources.ISaveParticipant;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.emf.common.util.WrappedException;
import org.eclipse.xtext.builder.internal.Activator;

import com.google.inject.Inject;
import com.google.inject.Provider;

/**
 * @author Knut Wannheden - Initial contribution and API
 */
public class DBBasedBuilderStateProvider implements Provider<DBBasedBuilderState> {

	protected static final String H2_SCHEMA = "jdbc:h2";
	protected static final String DEFAULT_H2_CONFIGURATION = "CACHE_SIZE=65536;LOG=1;WRITE_DELAY=1000";
	protected static final String DEBUG_H2_CONFIGURATION = DEFAULT_H2_CONFIGURATION + ";AUTO_SERVER=TRUE";

	private static final Logger LOG = Logger.getLogger(DBBasedBuilderStateProvider.class);

	// useful for debugging as it allows to connect to H2 from other process
	private static boolean DEBUG = false;

	@Inject
	private IWorkspace workspace;

	private IPath cachedPath;

	public DBBasedBuilderState get() {
		final DBBasedBuilderState result = new DBBasedBuilderState(getConnection(getDbUrl()));
		try {
			if (workspace != null) {
				workspace.addSaveParticipant(Activator.getDefault(), new ISaveParticipant() {

					public void saving(ISaveContext context) throws CoreException {
						if (context.getKind() == ISaveContext.FULL_SAVE)
							result.close(true);
					}

					public void rollback(ISaveContext context) {
					}

					public void prepareToSave(ISaveContext context) throws CoreException {
					}

					public void doneSaving(ISaveContext context) {
					}
				});
			}
		} catch (CoreException e) {
			LOG.error("Error adding builder state save participant", e);
		}
		return result;
	}

	protected String getDbUrl() {
		return H2_SCHEMA + ":" + getBuilderStateLocation().getAbsolutePath() + ";"
				+ (DEBUG ? DEBUG_H2_CONFIGURATION : DEFAULT_H2_CONFIGURATION);
	}

	protected Connection getConnection(String dbUrl) {
		try {
			Class.forName("org.h2.Driver");
			Connection conn = DriverManager.getConnection(dbUrl, "sa", "");
			conn.setAutoCommit(false);
			return conn;
		} catch (ClassNotFoundException e) {
			throw new WrappedException(e);
		} catch (SQLException e) {
			throw new DBException(e);
		}
	}

	protected File getBuilderStateLocation() {
		Activator activator = Activator.getDefault();
		if (activator == null) {
			if (cachedPath != null)
				return cachedPath.toFile();
			return null;
		}
		IPath path = activator.getStateLocation().append("state");
		cachedPath = path;
		return path.toFile();
	}

}
