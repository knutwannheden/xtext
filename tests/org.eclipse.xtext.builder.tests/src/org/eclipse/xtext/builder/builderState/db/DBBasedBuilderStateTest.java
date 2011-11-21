/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.builder.builderState.db;

import java.io.File;
import java.util.List;

import junit.framework.TestCase;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.resource.AbstractEObjectDescription;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.resource.IReferenceDescription;
import org.eclipse.xtext.resource.IResourceDescription;
import org.eclipse.xtext.resource.impl.AbstractResourceDescription;
import org.eclipse.xtext.util.Files;

import com.google.common.base.Function;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;

/**
 * @author Knut Wannheden - Initial contribution and API
 */
public class DBBasedBuilderStateTest extends TestCase {

	private static final File DIR = new File("test-data");

	private DBBasedBuilderState state;

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		DBBasedBuilderStateProvider provider = new DBBasedBuilderStateProvider() {
			@Override
			protected File getBuilderStateLocation() {
				return new File(DIR, "state");
			}
		};
		state = provider.get();
		state.clear();
	}

	@Override
	protected void tearDown() throws Exception {
		if (state != null) {
			state.close(false);
			Files.cleanFolder(DIR, null, true, true);
		}
		super.tearDown();
	}

	public void testTransactionInterface() {
		state.beginChanges();
		state.commitChanges();

		state.beginChanges();
		state.rollbackChanges();

		try {
			state.commitChanges();
			fail();
		} catch (IllegalStateException e) {
		}

		try {
			state.rollbackChanges();
			fail();
		} catch (IllegalStateException e) {
		}
	}

	public void testSimpleTransactionCommit() {
		List<IResourceDescription> resources = ImmutableList.of(createDescription("foo.bar"));

		state.beginChanges();
		assertEmpty(state);
		state.updateResources(resources);
		assertOnlyContains(resources, state);
		state.commitChanges();
		assertOnlyContains(resources, state);
	}

	public void testSimpleTransactionRollback() {
		List<IResourceDescription> resources = ImmutableList.of(createDescription("foo.bar"));

		state.beginChanges();
		assertEmpty(state);
		state.updateResources(resources);
		assertOnlyContains(resources, state);
		state.rollbackChanges();
		assertEmpty(state);
	}

	public void assertEmpty(DBBasedBuilderState state) {
		assertEquals(0, state.getAllURIs().size());
		assertEquals(0, Iterables.size(state.getAllResourceDescriptions()));
	}

	public void assertOnlyContains(Iterable<IResourceDescription> expectedResources, DBBasedBuilderState state) {
		assertContains(expectedResources, state);
		assertEquals(Iterables.size(expectedResources), Iterables.size(state.getAllURIs()));
		assertEquals(Iterables.size(expectedResources), Iterables.size(state.getAllResourceDescriptions()));
	}

	public void assertContains(Iterable<IResourceDescription> expectedResources, DBBasedBuilderState state) {
		for (IResourceDescription expected : expectedResources) {
			IResourceDescription actual = state.getResourceDescription(expected.getURI());
			assertEquals(expected, actual);
		}
	}

	public void assertEquals(IResourceDescription expected, IResourceDescription actual) {
		if (expected == null) {
			assertNull(actual);
		} else {
			assertEquals(expected.getURI(), actual.getURI());
			assertEquals(Iterables.size(expected.getExportedObjects()), Iterables.size(actual.getExportedObjects()));
			assertEquals(Iterables.size(expected.getImportedNames()), Iterables.size(actual.getImportedNames()));
			assertEquals(Iterables.size(expected.getReferenceDescriptions()),
					Iterables.size(actual.getReferenceDescriptions()));
		}
	}

	private IResourceDescription createDescription(final String uri, final String... fragments) {
		final URI resourceURI = URI.createURI("foo:/" + uri);
		return new AbstractResourceDescription() {

			public Iterable<QualifiedName> getImportedNames() {
				return ImmutableSet.of();
			}

			public Iterable<IReferenceDescription> getReferenceDescriptions() {
				return ImmutableSet.of();
			}

			public URI getURI() {
				return resourceURI;
			}

			@Override
			protected List<IEObjectDescription> computeExportedObjects() {
				return Lists.transform(Lists.newArrayList(fragments), new Function<String, IEObjectDescription>() {
					public IEObjectDescription apply(final String from) {
						return new AbstractEObjectDescription() {

							public QualifiedName getQualifiedName() {
								return QualifiedName.create(from);
							}

							public QualifiedName getName() {
								return getQualifiedName();
							}

							public URI getEObjectURI() {
								return resourceURI.appendFragment(from);
							}

							public EObject getEObjectOrProxy() {
								return null;
							}

							public EClass getEClass() {
								return null;
							}

							@Override
							public String[] getUserDataKeys() {
								return new String[0];
							}

							@Override
							public String getUserData(final String name) {
								return null;
							}
						};
					}
				});
			}
		};
	}

}
