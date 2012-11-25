package org.eclipse.xtext.xbase.ui.tests.quickfix;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Module;
import java.io.InputStream;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.xtext.common.types.access.jdt.IJavaProjectProvider;
import org.eclipse.xtext.junit4.ui.util.JavaProjectSetupUtil;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.resource.XtextResourceSet;
import org.eclipse.xtext.ui.shared.SharedStateModule;
import org.eclipse.xtext.util.Modules2;
import org.eclipse.xtext.xbase.XbaseRuntimeModule;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Functions.Function0;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.ui.internal.XtypeActivator;
import org.eclipse.xtext.xbase.ui.tests.AbstractXbaseUITestCase;
import org.eclipse.xtext.xbase.ui.tests.quickfix.TestQuickfixXbaseUIModule;
import org.junit.Assert;

@SuppressWarnings("all")
public abstract class AbstractXbaseQuickfixTest extends AbstractXbaseUITestCase implements IJavaProjectProvider {
  private IProject demandCreateProject;
  
  private static Injector injector = new Function0<Injector>() {
    public Injector apply() {
      XbaseRuntimeModule _xbaseRuntimeModule = new XbaseRuntimeModule();
      SharedStateModule _sharedStateModule = new SharedStateModule();
      XtypeActivator _instance = XtypeActivator.getInstance();
      TestQuickfixXbaseUIModule _testQuickfixXbaseUIModule = new TestQuickfixXbaseUIModule(_instance);
      Module _mixin = Modules2.mixin(_xbaseRuntimeModule, _sharedStateModule, _testQuickfixXbaseUIModule);
      Injector _createInjector = Guice.createInjector(_mixin);
      return _createInjector;
    }
  }.apply();
  
  public void tearDown() throws Exception {
    boolean _notEquals = ObjectExtensions.operator_notEquals(this.demandCreateProject, null);
    if (_notEquals) {
      JavaProjectSetupUtil.deleteProject(this.demandCreateProject);
    }
    super.tearDown();
  }
  
  public IJavaProject getJavaProject(final ResourceSet resourceSet) {
    final String projectName = this.getProjectName();
    IJavaProject javaProject = JavaProjectSetupUtil.findJavaProject(projectName);
    boolean _or = false;
    boolean _equals = ObjectExtensions.operator_equals(javaProject, null);
    if (_equals) {
      _or = true;
    } else {
      boolean _exists = javaProject.exists();
      boolean _not = (!_exists);
      _or = (_equals || _not);
    }
    if (_or) {
      try {
        IProject _createPluginProject = AbstractXbaseUITestCase.createPluginProject(projectName);
        this.demandCreateProject = _createPluginProject;
        IJavaProject _findJavaProject = JavaProjectSetupUtil.findJavaProject(projectName);
        javaProject = _findJavaProject;
      } catch (final Throwable _t) {
        if (_t instanceof CoreException) {
          final CoreException e = (CoreException)_t;
          String _message = e.getMessage();
          String _plus = ("cannot create java project due to: " + _message);
          String _plus_1 = (_plus + " / ");
          String _plus_2 = (_plus_1 + e);
          Assert.fail(_plus_2);
        } else {
          throw Exceptions.sneakyThrow(_t);
        }
      }
    }
    return javaProject;
  }
  
  protected String getProjectName() {
    Class<? extends Object> _class = this.getClass();
    String _simpleName = _class.getSimpleName();
    return (_simpleName + "Project");
  }
  
  public XtextResource getResourceFor(final InputStream stream) {
    try {
      XtextResourceSet _resourceSet = this.getResourceSet();
      String _plus = ("Test." + this.fileExtension);
      URI _createURI = URI.createURI(_plus);
      Resource _createResource = _resourceSet.createResource(_createURI);
      final XtextResource result = ((XtextResource) _createResource);
      result.load(stream, null);
      return result;
    } catch (final Throwable _t) {
      if (_t instanceof Exception) {
        final Exception e = (Exception)_t;
        RuntimeException _runtimeException = new RuntimeException(e);
        throw _runtimeException;
      } else {
        throw Exceptions.sneakyThrow(_t);
      }
    }
  }
  
  public XtextResourceSet getResourceSet() {
    XtextResourceSet _xblockexpression = null;
    {
      final XtextResourceSet set = this.<XtextResourceSet>get(XtextResourceSet.class);
      IJavaProject _javaProject = this.getJavaProject(set);
      set.setClasspathURIContext(_javaProject);
      _xblockexpression = (set);
    }
    return _xblockexpression;
  }
  
  public Injector getInjector() {
    return AbstractXbaseQuickfixTest.injector;
  }
}
