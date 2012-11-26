/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.builder.impl.javasupport;

import java.util.Collections;
import java.util.Map;
import java.util.Set;

import org.apache.log4j.Logger;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IStorage;
import org.eclipse.core.resources.IWorkspace.ProjectOrder;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.SubMonitor;
import org.eclipse.emf.common.util.URI;
import org.eclipse.jdt.core.IJarEntryResource;
import org.eclipse.jdt.core.IJavaElement;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.IPackageFragment;
import org.eclipse.jdt.core.IPackageFragmentRoot;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.jdt.core.JavaModelException;
import org.eclipse.jdt.launching.JavaRuntime;
import org.eclipse.xtext.builder.impl.QueuedBuildData;
import org.eclipse.xtext.builder.impl.ToBeBuilt;
import org.eclipse.xtext.builder.impl.ToBeBuiltComputer;
import org.eclipse.xtext.common.types.access.jdt.TypeURIHelper;
import org.eclipse.xtext.common.types.ui.notification.TypeResourceDescription;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.resource.IResourceDescription.Delta;
import org.eclipse.xtext.resource.impl.ChangedResourceDescriptionDelta;
import org.eclipse.xtext.ui.XtextProjectHelper;
import org.eclipse.xtext.ui.resource.JarEntryLocator;
import org.eclipse.xtext.ui.resource.PackageFragmentRootWalker;
import org.eclipse.xtext.ui.resource.SourceAttachmentPackageFragmentRootWalker;
import org.eclipse.xtext.ui.util.IJdtHelper;
import org.eclipse.xtext.util.Pair;

import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import com.google.inject.Inject;
import com.google.inject.Singleton;

public class JdtToBeBuiltComputer extends ToBeBuiltComputer {
	
	private final static Logger log = Logger.getLogger(JdtToBeBuiltComputer.class);

	@Inject
	private TypeURIHelper typeURIHelper;
	
	@Inject
	private QueuedBuildData queuedBuildData;
	
	@Inject
	private ModificationStampCache modificationStampCache;
	
	@Inject
	private IJdtHelper jdtHelper;
	
	@Singleton
	public static class ModificationStampCache {
		protected Map<String, Long> projectToModificationStamp = Maps.newHashMap();
	}
	
	@Override
	public ToBeBuilt removeProject(IProject project, IProgressMonitor monitor) {
		ToBeBuilt toBeBuilt = super.removeProject(project, monitor);
		if (toBeBuilt.getToBeDeleted().isEmpty() && toBeBuilt.getToBeUpdated().isEmpty())
			return toBeBuilt;
		modificationStampCache.projectToModificationStamp.clear();
		return toBeBuilt;
	}
	
	@Override
	public ToBeBuilt updateProject(final IProject project, IProgressMonitor monitor) throws CoreException {
		SubMonitor progress = SubMonitor.convert(monitor, 2);
		final ToBeBuilt toBeBuilt = super.updateProject(project, progress.newChild(1));
		if (!project.isAccessible() || progress.isCanceled())
			return toBeBuilt;
		IJavaProject javaProject = JavaCore.create(project);
		if (javaProject.exists()) {
			IPackageFragmentRoot[] roots = javaProject.getPackageFragmentRoots();
			progress.setWorkRemaining(roots.length);
			final Set<String> previouslyBuilt = Sets.newHashSet();
			final Set<String> subsequentlyBuilt = Sets.newHashSet();
			final JarEntryLocator locator = new JarEntryLocator();
			final Map<String, Long> updated = Maps.newHashMap();
			for (final IPackageFragmentRoot root : roots) {
				if (progress.isCanceled())
					return toBeBuilt;
				if (shouldHandle(root)) {
					try {
						new SourceAttachmentPackageFragmentRootWalker<Boolean>() {
							@Override
							protected Boolean handle(URI uri, IStorage storage, TraversalState state) {
								if (wasFragmentRootAlreadyProcessed(uri))
									return Boolean.TRUE; // abort traversal
								if (log.isDebugEnabled())
									log.debug("Scheduling: " + project.getName() + " - " + uri);
								toBeBuilt.getToBeDeleted().add(uri);
								toBeBuilt.getToBeUpdated().add(uri);
								return null;
							}

							@Override
							protected URI getURI(IJarEntryResource jarEntry, PackageFragmentRootWalker.TraversalState state)
							{
								return locator.getURI(root, jarEntry, state);
							}

							@Override
							protected boolean isValid(URI uri, IStorage storage) {
								return JdtToBeBuiltComputer.this.isValid(uri, storage);
							}
							
							protected boolean wasFragmentRootAlreadyProcessed(URI uri) {
								Iterable<Pair<IStorage, IProject>> storages = getMapper().getStorages(uri);
								for (Pair<IStorage, IProject> pair : storages) {
									IProject otherProject = pair.getSecond();
									if (!pair.getSecond().equals(project)) {
										if (previouslyBuilt.contains(otherProject.getName()))
											return true;
										if (!subsequentlyBuilt.contains(otherProject.getName())) {
											boolean process = XtextProjectHelper.hasNature(otherProject);
											String otherName = otherProject.getName();
											if (!process) {
												process = otherProject.isAccessible() && otherProject.isHidden();
												if (process) {
													Long previousStamp = modificationStampCache.projectToModificationStamp.get(otherName);
													if (previousStamp == null || otherProject.getModificationStamp() > previousStamp.longValue()) {
														process = false;
														updated.put(otherName, otherProject.getModificationStamp());
													}
												}
											}
											if (process) {
												ProjectOrder projectOrder = project.getWorkspace().computeProjectOrder(new IProject[] { project, otherProject });
												if (!projectOrder.hasCycles) {
													if (otherProject.equals(projectOrder.projects[0])) {
														previouslyBuilt.add(otherName);
														return true;
													} else {
														subsequentlyBuilt.add(otherName);
													}
												} else {
													subsequentlyBuilt.add(otherName);
												}
											}
										}
									}
								}
								return false;
							}
						}.traverse(root,true);
					} catch (JavaModelException ex) {
						if (!ex.isDoesNotExist())
							log.error(ex.getMessage(), ex);
					}
				}
				progress.worked(1);
			}
			synchronized (modificationStampCache) {
				modificationStampCache.projectToModificationStamp.putAll(updated);
			}
		}
		return toBeBuilt;
	}

	/**
	 * Handle all fragment roots that are on the classpath and not a source folder.
	 */
	private boolean shouldHandle(IPackageFragmentRoot root) {
		try {
			boolean result = !JavaRuntime.newDefaultJREContainerPath().isPrefixOf(root.getRawClasspathEntry().getPath());
			result &= (root.isArchive() || root.isExternal()); 
			return result;
		} catch (JavaModelException ex) {
			if (!ex.isDoesNotExist())
				log.error(ex.getMessage(), ex);
			return false;
		}
	}

	@Override
	public boolean removeStorage(IProgressMonitor monitor, ToBeBuilt toBeBuilt, IStorage storage) {
		if (!isHandled(storage))
			return true;
		URI uri = getUri(storage);
		if (uri != null) {
			toBeBuilt.getToBeDeleted().add(uri);
		} else {
			if (storage instanceof IFile && JavaCore.isJavaLikeFileName(storage.getFullPath().lastSegment())) {
				IJavaElement element = JavaCore.create(((IFile)storage).getParent());
				String fileName = storage.getFullPath().lastSegment();
				String typeName = fileName.substring(0, fileName.lastIndexOf('.'));
				if (element instanceof IPackageFragmentRoot) {
					queueJavaChange(typeName);
				} else if (element instanceof IPackageFragment) {
					IPackageFragment packageFragment = (IPackageFragment) element;
					queueJavaChange(packageFragment.getElementName() + "." + typeName);
				}
			}
		}
		return true;
	}

	protected void queueJavaChange(String typeName) {
		URI typeURI = typeURIHelper.createResourceURIForFQN(typeName);
		TypeResourceDescription oldDescription = new TypeResourceDescription(typeURI, Collections.<IEObjectDescription>emptyList());
		Delta delta = new ChangedResourceDescriptionDelta(oldDescription, null);
		queuedBuildData.queueChanges(Collections.singleton(delta));
	}

	@Override
	protected boolean isHandled(IStorage resource) {
		return (resource instanceof IJarEntryResource) || super.isHandled(resource);
	}
	
	/**
	 * Ignores Java output folders when traversing a project.
	 * @return <code>false</code> if the folder is a java output folder. Otherwise <code>true</code>.
	 */
	@Override
	protected boolean isHandled(IFolder folder) {
		boolean result = super.isHandled(folder) && !jdtHelper.isFromOutputPath(folder);
		return result;
	}
}
