package org.eclipse.xtext.xbase.compiler;

/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileFilter;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLClassLoader;
import java.net.URLDecoder;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.URIUtil;
import org.eclipse.emf.common.util.WrappedException;
import org.eclipse.jdt.core.compiler.CompilationProgress;
import org.eclipse.jdt.internal.compiler.batch.FileSystem;
import org.eclipse.jdt.internal.compiler.batch.Main;
import org.eclipse.jdt.internal.compiler.env.NameEnvironmentAnswer;
import org.eclipse.xtext.util.Files;
import org.eclipse.xtext.util.Pair;
import org.eclipse.xtext.util.Tuples;
import org.eclipse.xtext.xbase.lib.Functions;
import org.eclipse.xtext.xbase.lib.Functions.Function0;

import com.google.inject.Inject;
import com.google.inject.internal.MoreTypes;

import static java.util.Collections.*;

import static com.google.common.collect.Lists.*;

import static com.google.common.collect.Maps.*;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
@SuppressWarnings("restriction")
public class OnTheFlyJavaCompiler {

	static class DelegateOutStream extends OutputStream {

		private OutputStream delegate;

		@Override
		public void close() throws IOException {
			delegate.close();
		}

		@Override
		public boolean equals(Object obj) {
			return delegate.equals(obj);
		}

		@Override
		public void flush() throws IOException {
			delegate.flush();
		}

		@Override
		public int hashCode() {
			return delegate.hashCode();
		}

		public void setDelegate(OutputStream delegate) {
			this.delegate = delegate;
		}

		@Override
		public String toString() {
			return delegate.toString();
		}

		@Override
		public void write(byte[] b) throws IOException {
			delegate.write(b);
		}

		@Override
		public void write(byte[] b, int off, int len) throws IOException {
			delegate.write(b, off, len);
		}

		@Override
		public void write(int b) throws IOException {
			delegate.write(b);
		}

	}

	public static class EclipseRuntimeDependentJavaCompiler extends
			OnTheFlyJavaCompiler {
		@Override
		protected URL resolveBundleResourceURL(URL url) throws IOException {
			return FileLocator.resolve(url);
		}
	}

	public static class PatchedFileSystem extends FileSystem {

		private FileSystem delegate;

		public PatchedFileSystem(FileSystem delegate) {
			super(new String[0], new String[0], "ISO-8859-1");
			this.delegate = delegate;
		}

		@Override
		public void cleanup() {
			// DO nothing. the original implmentaion closes zips and sets the
			// references to null
		}

		@Override
		public boolean equals(Object obj) {
			return delegate.equals(obj);
		}

		@Override
		public NameEnvironmentAnswer findType(char[] typeName,
				char[][] packageName) {
			return delegate.findType(typeName, packageName);
		}

		@Override
		public NameEnvironmentAnswer findType(char[][] compoundName) {
			return delegate.findType(compoundName);
		}

		@Override
		public NameEnvironmentAnswer findType(char[][] compoundName,
				boolean asBinaryOnly) {
			return delegate.findType(compoundName, asBinaryOnly);
		}

		@Override
		public char[][][] findTypeNames(char[][] packageName) {
			return delegate.findTypeNames(packageName);
		}

		public FileSystem getDelegate() {
			return delegate;
		}

		@Override
		public int hashCode() {
			return delegate.hashCode();
		}

		@Override
		public boolean isPackage(char[][] compoundName, char[] packageName) {
			return delegate.isPackage(compoundName, packageName);
		}

		@Override
		public String toString() {
			return delegate.toString();
		}

	}

	/**
	 * HACK - reuse the classpath, since it is super expensive to reopen and
	 * scan the zips.
	 * 
	 * @author Sven Efftinge - Initial contribution and API
	 */
	static class PatchedMain extends Main {

		@SuppressWarnings("rawtypes")
		public PatchedMain(PrintWriter outWriter, PrintWriter errWriter,
				boolean systemExitWhenFinished, Map customDefaultOptions,
				CompilationProgress compilationProgress) {
			super(outWriter, errWriter, systemExitWhenFinished,
					customDefaultOptions, compilationProgress);
		}

		@Override
		public FileSystem getLibraryAccess() {
			if (fileSystem == null) {
				fileSystem = new PatchedFileSystem(super.getLibraryAccess());
			}
			return fileSystem;
		}

	}
	
	public static class ClassPathAssembler {
		
		@Inject
		private ClassLoader parentClassLoader;
		
		public void assembleCompilerClassPath(OnTheFlyJavaCompiler compiler) {
			if (parentClassLoader instanceof URLClassLoader) {
				URL[] urLs = ((URLClassLoader) parentClassLoader).getURLs();
				for (URL url : urLs) {
					final String urlAsString = url.getFile();
					compiler.addClassPath(urlAsString);
				}
			}
		}
		
		public ClassLoader getClassLoader() {
			return parentClassLoader;
		}
	}

	private static PatchedFileSystem fileSystem;

	private List<String> classpath = newArrayList();

	private DelegateOutStream errorStream = new DelegateOutStream();

	@Inject
	private ClassPathAssembler classPathAssembler = new ClassPathAssembler();
	
	public void addClassPath(String classpath) {
		this.classpath.add(classpath);
	}

	public void addClassPathOfClass(Class<?> clazz) {
		final String classNameAsPath = "/"
				+ clazz.getName().replace('.', '/');
		String resourceName = classNameAsPath + ".class";
		URL url = clazz.getResource(resourceName);
		if (url == null)
			throw new IllegalArgumentException(resourceName + " not found");
		String pathToFolderOrJar = null;
		if (url.getProtocol().startsWith("bundleresource")) {
			try {
				url = resolveBundleResourceURL(url);
			} catch (IOException e) {
				throw new WrappedException(e);
			}
		}
		if (url.getProtocol().startsWith("jar")) {
			try {
				final String path = url.getPath().substring(0,
						url.getPath().indexOf('!'));
				String encodedPath = path.replace(" ","%20");
				pathToFolderOrJar = new URL(encodedPath).toURI().getRawPath();
			} catch (Exception e) {
				throw new WrappedException(e);
			}
		} else {
			String resolvedRawPath;
			try {
				resolvedRawPath = URIUtil.toURI(url).getRawPath();
			} catch (URISyntaxException e) {
				throw new WrappedException(e);
			}
			pathToFolderOrJar = resolvedRawPath.substring(0,
					resolvedRawPath.indexOf(classNameAsPath));
		}
		this.classpath.add(pathToFolderOrJar);
	}

	public void clearClassPath() {
		if (fileSystem != null && fileSystem.getDelegate() != null)
			fileSystem.getDelegate().cleanup();
		classpath.clear();
		fileSystem = null;
	}

	protected boolean compile(String arguments) {
		// return BatchCompiler.compile(sb.toString(), new PrintWriter(new
		// OutputStreamWriter(System.out)), new PrintWriter(
		// new OutputStreamWriter(errorStream)), null);
		return getMain().compile(Main.tokenize(arguments));
	}

	public Class<?> compileToClass(String classname, String code) {
		return compileToClasses(singletonMap(classname, code)).get(classname);
	}
	
	public Map<String,Class<?>> compileToClasses(Map<String,String> sources) {
		File tempDir = createTempDir();
		try {
			for (Entry<String, String> entry : sources.entrySet()) {
				String classname = entry.getKey();
				String code = entry.getValue();
				final String classNameAsPath = classname.replace('.', File.separatorChar);
				final File srcFile = new File(tempDir, classNameAsPath + ".java");
				createFolderStructure(srcFile.getParentFile());
				srcFile.createNewFile();
				Files.writeStringIntoFile(srcFile.getCanonicalPath(), code);
			}
			errorStream.setDelegate(new ByteArrayOutputStream());
			StringBuilder sb = new StringBuilder(getComplianceLevelArg());
			sb.append(" ");
			sb.append(getClasspathArgs());
			sb.append(" ");
			sb.append('\"');
			sb.append(tempDir.getCanonicalPath());
			sb.append('\"');
			boolean compile = compile(sb.toString());
			if (!compile)
				throw new IllegalArgumentException("Couldn't compile : "
						+ errorStream.toString() + "\n" + sources.keySet());
			final URL url = tempDir.toURI().toURL();
			final URLClassLoader loader = new URLClassLoader(new URL[] { url },
					classPathAssembler.getClassLoader());
			Map<String,Class<?>> result = newHashMap();
			for (String name : sources.keySet()) {
				Class<?> clazz = loader.loadClass(name.replace('/','.'));
				result.put(name, clazz);
			}
			return result;
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			cleanUpTmpFolder(tempDir);
		}
	}

	private File createTempDir() {
		File rootTempDir = null;
		String defTmpPath = System.getProperty("java.io.tmpdir");
		if (defTmpPath != null) {
			rootTempDir = new File(defTmpPath);
		} else {
			// use current directory, should be writable
			rootTempDir = new File("./");
		}
		// VM unique temp dir
		File tempDir = new File(rootTempDir, "otfjc"
				+ OnTheFlyJavaCompiler.class.hashCode());
		if (tempDir.exists()) {
			tempDir.delete();
		}
		tempDir.mkdir();
		return tempDir;
	}

	private void cleanUpTmpFolder(File tempDir) {
		try {
			Files.cleanFolder(tempDir, new FileFilter() {
				public boolean accept(File pathname) {
					return !pathname.getName().endsWith(".class");
				}
			}, true, true);
		} catch (FileNotFoundException e) {
			// ignore
		}
	}

	protected void createFolderStructure(File parent) {
		if (parent.exists())
			return;
		parent.mkdirs();
	}

	protected Pair<String, String> createFullCode(String statementCode,
			Type returnType, Pair<Type, String>... params) {
		String className = "_$GeneratedClass";
		StringBuilder sb = new StringBuilder("public class ").append(className)
				.append(" implements ")
				.append("org.eclipse.xtext.xbase.lib.Functions.Function")
				.append(params.length).append("<");
		for (Pair<Type, String> type : params) {
			sb.append(toString(type.getFirst())).append(",");
		}
		sb.append(toString(returnType));
		sb.append("> {\n");
		sb.append("public ").append(toString(returnType));
		sb.append(" apply(");

		for (int i = 0; i < params.length; i++) {
			Pair<Type, String> pair = params[i];
			sb.append(toString(pair.getFirst())).append(" ")
					.append(pair.getSecond());
			if (i + 1 < params.length)
				sb.append(",");
		}
		sb.append(") {\n");
		sb.append(statementCode);
		sb.append("\n}}");
		return Tuples.pair(className, sb.toString());
	}

	@SuppressWarnings("unchecked")
	public <RT> Functions.Function0<RT> createFunction(String expression,
			Class<RT> returnType) {
		return (Function0<RT>) internalCreateFunction(expression, returnType);
	}

	@SuppressWarnings("unchecked")
	public <RT, T> Functions.Function1<T, RT> createFunction(String body,
			Class<RT> returnType, Class<T> paramType) {
		return (Functions.Function1<T, RT>) internalCreateFunction(body,
				returnType, Tuples.pair((Type) paramType, "p"));
	}

	@SuppressWarnings("unchecked")
	public <RT, T1, T2> Functions.Function2<T1, T2, RT> createFunction(
			String body, Class<RT> returnType, Class<T1> paramType1,
			Class<T2> paramType2) {
		return (Functions.Function2<T1, T2, RT>) internalCreateFunction(body,
				returnType, Tuples.pair((Type) paramType1, "p1"),
				Tuples.pair((Type) paramType2, "p2"));
	}

	@SuppressWarnings("deprecation")
	public String getClasspathArgs() {
		StringBuilder sb = new StringBuilder();
		sb.append("-classpath ");
		if (classpath.isEmpty()) {
			initializeClassPath();
		}
		// no classpath
		if (classpath.isEmpty())
			return "";
		sb.append('"');
		for (int i = 0; i < classpath.size(); i++) {
			sb.append(URLDecoder.decode(classpath.get(i)));
			if (i + 1 < classpath.size())
				sb.append(File.pathSeparator);
		}
		sb.append('"');
		return sb.toString();
	}

	public void initializeClassPath() {
		clearClassPath();
		classPathAssembler.assembleCompilerClassPath(this);
	}

	protected String getComplianceLevelArg() {
		return "-1.5";
	}

	protected Main getMain() {
		return new PatchedMain(new PrintWriter(new OutputStreamWriter(
				System.out)), new PrintWriter(new OutputStreamWriter(
				errorStream)), false /* systemExit */, null /* options */, null);
	}

	protected Object internalCreateFunction(String code, Type returnType,
			Pair<Type, String>... params) {
		Pair<String, String> fullCode = createFullCode(code, returnType, params);
		Class<?> class1 = compileToClass(fullCode.getFirst(),
				fullCode.getSecond());
		try {
			return class1.newInstance();
		} catch (RuntimeException e) {
			throw e;
		} catch (Exception e) {
			throw new WrappedException(e);
		}
	}

	protected URL resolveBundleResourceURL(URL url) throws IOException {
		throw new UnsupportedOperationException();
	}

	public void setParentClassLoader(ClassLoader parentClassLoader) {
		this.classPathAssembler.parentClassLoader = parentClassLoader;
	}

	protected String toString(Type returnType) {
		Class<MoreTypes> clazz = MoreTypes.class;
		Method method = null;
		try {
			try {
				// Guice 3
				method = clazz.getDeclaredMethod("typeToString", Type.class);
			} catch (NoSuchMethodException e) {
				// Guice <3
				method = clazz.getDeclaredMethod("toString", Type.class);
			}
			return (String) method.invoke(null, returnType);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

}
