package org.eclipse.xtext.xbase.tests.compiler;

import com.google.inject.Inject;
import com.google.inject.Injector;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;
import junit.framework.Assert;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.common.types.JvmDeclaredType;
import org.eclipse.xtext.common.types.JvmField;
import org.eclipse.xtext.common.types.JvmFormalParameter;
import org.eclipse.xtext.common.types.JvmGenericType;
import org.eclipse.xtext.common.types.JvmMember;
import org.eclipse.xtext.common.types.JvmOperation;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.common.types.util.TypeReferences;
import org.eclipse.xtext.generator.IFileSystemAccess;
import org.eclipse.xtext.generator.InMemoryFileSystemAccess;
import org.eclipse.xtext.junit.validation.ValidationTestHelper;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.compiler.JvmModelGenerator;
import org.eclipse.xtext.xbase.compiler.OnTheFlyJavaCompiler.EclipseRuntimeDependentJavaCompiler;
import org.eclipse.xtext.xbase.jvmmodel.JvmTypesBuilder;
import org.eclipse.xtext.xbase.lib.CollectionExtensions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.InputOutput;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.StringExtensions;
import org.eclipse.xtext.xbase.tests.AbstractXbaseTestCase;

@SuppressWarnings("all")
public class JvmModelGeneratorTest extends AbstractXbaseTestCase {
  
  @Inject
  private JvmTypesBuilder builder;
  
  @Inject
  private TypeReferences references;
  
  @Inject
  private ValidationTestHelper helper;
  
  @Inject
  private JvmModelGenerator generator;
  
  @Inject
  private EclipseRuntimeDependentJavaCompiler javaCompiler;
  
  @Inject
  private TypeReferences typeReferences;
  
  public void setUp() throws Exception {
    {
      super.setUp();
      Injector _injector = this.getInjector();
      _injector.injectMembers(this);
      this.javaCompiler.clearClassPath();
      Class<? extends Object> _class = this.getClass();
      this.javaCompiler.addClassPathOfClass(_class);
      this.javaCompiler.addClassPathOfClass(org.eclipse.xtext.xbase.junit.evaluation.AbstractXbaseEvaluationTest.class);
      this.javaCompiler.addClassPathOfClass(org.eclipse.xtext.xbase.lib.Functions.class);
      this.javaCompiler.addClassPathOfClass(com.google.inject.Provider.class);
      this.javaCompiler.addClassPathOfClass(com.google.common.base.Supplier.class);
    }
  }
  
  public void testSimple() throws Exception, IllegalAccessException, IllegalArgumentException, InstantiationException, NoSuchMethodException, SecurityException, UnsupportedOperationException, InvocationTargetException {
    {
      XExpression _expression = this.expression("return s.toUpperCase", false);
      final XExpression expression = _expression;
      final Function1<JvmGenericType,Void> _function = new Function1<JvmGenericType,Void>() {
          public Void apply(final JvmGenericType it) {
            Void _xblockexpression = null;
            {
              EList<JvmMember> _members = it.getMembers();
              JvmTypeReference _typeForName = JvmModelGeneratorTest.this.references.getTypeForName(java.lang.String.class, expression);
              final Function1<JvmOperation,Void> _function_1 = new Function1<JvmOperation,Void>() {
                  public Void apply(final JvmOperation it_1) {
                    {
                      EList<JvmFormalParameter> _parameters = it_1.getParameters();
                      JvmTypeReference _typeForName_1 = JvmModelGeneratorTest.this.references.getTypeForName(java.lang.String.class, expression);
                      JvmFormalParameter _parameter = JvmModelGeneratorTest.this.builder.toParameter(expression, "s", _typeForName_1);
                      CollectionExtensions.<JvmFormalParameter>operator_add(_parameters, _parameter);
                      JvmModelGeneratorTest.this.builder.associate(expression, it_1);
                    }
                    return null;
                  }
                };
              JvmOperation _method = JvmModelGeneratorTest.this.builder.toMethod(expression, "doStuff", _typeForName, _function_1);
              CollectionExtensions.<JvmMember>operator_add(_members, _method);
              _xblockexpression = (null);
            }
            return _xblockexpression;
          }
        };
      JvmGenericType _clazz = this.builder.toClazz(expression, "my.test.Foo", _function);
      final JvmGenericType clazz = _clazz;
      Resource _eResource = expression.eResource();
      Class<?> _compile = this.compile(_eResource, clazz);
      final Class<?> compiledClass = _compile;
      Object _newInstance = compiledClass.newInstance();
      final Object instance = _newInstance;
      Method _method_1 = compiledClass.getMethod("doStuff", java.lang.String.class);
      Object _invoke = _method_1.invoke(instance, "foo");
      Assert.assertEquals("FOO", _invoke);
    }
  }
  
  public void testImplements() throws Exception, UnsupportedOperationException {
    {
      XExpression _expression = this.expression("null", false);
      final XExpression expression = _expression;
      final Function1<JvmGenericType,Void> _function = new Function1<JvmGenericType,Void>() {
          public Void apply(final JvmGenericType it) {
            Void _xblockexpression = null;
            {
              it.setAbstract(true);
              EList<JvmTypeReference> _superTypes = it.getSuperTypes();
              JvmTypeReference _typeRef = JvmModelGeneratorTest.this.typeRef(expression, java.lang.Iterable.class, java.lang.String.class);
              CollectionExtensions.<JvmTypeReference>operator_add(_superTypes, _typeRef);
              _xblockexpression = (null);
            }
            return _xblockexpression;
          }
        };
      JvmGenericType _clazz = this.builder.toClazz(expression, "my.test.Foo", _function);
      final JvmGenericType clazz = _clazz;
      Resource _eResource = expression.eResource();
      Class<?> _compile = this.compile(_eResource, clazz);
      final Class<?> compiled = _compile;
      boolean _isAssignableFrom = java.lang.Iterable.class.isAssignableFrom(compiled);
      Assert.assertTrue(_isAssignableFrom);
    }
  }
  
  public void testExtends() throws Exception, UnsupportedOperationException {
    {
      XExpression _expression = this.expression("null", false);
      final XExpression expression = _expression;
      final Function1<JvmGenericType,Void> _function = new Function1<JvmGenericType,Void>() {
          public Void apply(final JvmGenericType it) {
            Void _xblockexpression = null;
            {
              it.setAbstract(true);
              EList<JvmTypeReference> _superTypes = it.getSuperTypes();
              JvmTypeReference _typeRef = JvmModelGeneratorTest.this.typeRef(expression, java.util.AbstractList.class, java.lang.String.class);
              CollectionExtensions.<JvmTypeReference>operator_add(_superTypes, _typeRef);
              _xblockexpression = (null);
            }
            return _xblockexpression;
          }
        };
      JvmGenericType _clazz = this.builder.toClazz(expression, "my.test.Foo", _function);
      final JvmGenericType clazz = _clazz;
      Resource _eResource = expression.eResource();
      Class<?> _compile = this.compile(_eResource, clazz);
      final Class<?> compiled = _compile;
      boolean _isAssignableFrom = java.lang.Iterable.class.isAssignableFrom(compiled);
      Assert.assertTrue(_isAssignableFrom);
      boolean _isAssignableFrom_1 = java.util.AbstractList.class.isAssignableFrom(compiled);
      Assert.assertTrue(_isAssignableFrom_1);
    }
  }
  
  public void testCompilationStrategy() throws Exception, IllegalAccessException, IllegalArgumentException, InstantiationException, NoSuchMethodException, SecurityException, UnsupportedOperationException, InvocationTargetException {
    {
      XExpression _expression = this.expression("null", false);
      final XExpression expression = _expression;
      final Function1<JvmGenericType,Void> _function = new Function1<JvmGenericType,Void>() {
          public Void apply(final JvmGenericType it) {
            Void _xblockexpression = null;
            {
              EList<JvmMember> _members = it.getMembers();
              JvmTypeReference _typeRef = JvmModelGeneratorTest.this.typeRef(expression, java.lang.String.class);
              JvmField _field = JvmModelGeneratorTest.this.builder.toField(expression, "x", _typeRef);
              CollectionExtensions.<JvmMember>operator_add(_members, _field);
              EList<JvmMember> _members_1 = it.getMembers();
              JvmTypeReference _typeRef_1 = JvmModelGeneratorTest.this.typeRef(expression, java.lang.String.class);
              JvmOperation _getter = JvmModelGeneratorTest.this.builder.toGetter(expression, "x", _typeRef_1);
              CollectionExtensions.<JvmMember>operator_add(_members_1, _getter);
              EList<JvmMember> _members_2 = it.getMembers();
              JvmTypeReference _typeRef_2 = JvmModelGeneratorTest.this.typeRef(expression, java.lang.String.class);
              JvmOperation _setter = JvmModelGeneratorTest.this.builder.toSetter(expression, "x", _typeRef_2);
              CollectionExtensions.<JvmMember>operator_add(_members_2, _setter);
              _xblockexpression = (null);
            }
            return _xblockexpression;
          }
        };
      JvmGenericType _clazz = this.builder.toClazz(expression, "my.test.Foo", _function);
      final JvmGenericType clazz = _clazz;
      Resource _eResource = expression.eResource();
      Class<?> _compile = this.compile(_eResource, clazz);
      final Class<?> compiled = _compile;
      Object _newInstance = compiled.newInstance();
      final Object inst = _newInstance;
      Method _method = compiled.getMethod("getX");
      final Method getter = _method;
      Method _method_1 = compiled.getMethod("setX", java.lang.String.class);
      final Method setter = _method_1;
      setter.invoke(inst, "FOO");
      Object _invoke = getter.invoke(inst);
      Assert.assertEquals("FOO", _invoke);
    }
  }
  
  public JvmTypeReference typeRef(final EObject ctx, final Class<?> clazz) {
    JvmTypeReference _typeForName = this.references.getTypeForName(clazz, ctx);
    return _typeForName;
  }
  
  public JvmTypeReference typeRef(final EObject ctx, final Class<?> clazz, final Class<?> param) {
    JvmTypeReference _typeRef = this.typeRef(ctx, param);
    JvmTypeReference _typeForName = this.references.getTypeForName(clazz, ctx, _typeRef);
    return _typeForName;
  }
  
  public Class<?> compile(final Resource res, final JvmDeclaredType type) throws UnsupportedOperationException {
    {
      res.eSetDeliver(false);
      EList<EObject> _contents = res.getContents();
      CollectionExtensions.<EObject>operator_add(_contents, type);
      res.eSetDeliver(true);
      InMemoryFileSystemAccess _inMemoryFileSystemAccess = new InMemoryFileSystemAccess();
      final InMemoryFileSystemAccess fsa = _inMemoryFileSystemAccess;
      this.generator.doGenerate(res, fsa);
      Map<String,CharSequence> _files = fsa.getFiles();
      String _identifier = type.getIdentifier();
      String _replace = _identifier.replace(".", "/");
      String _operator_plus = StringExtensions.operator_plus(IFileSystemAccess.DEFAULT_OUTPUT, _replace);
      String _operator_plus_1 = StringExtensions.operator_plus(_operator_plus, ".java");
      CharSequence _get = _files.get(_operator_plus_1);
      String _string = _get.toString();
      final String code = _string;
      InputOutput.<String>println(code);
      String _identifier_1 = type.getIdentifier();
      Class<? extends Object> _compileToClass = this.javaCompiler.compileToClass(_identifier_1, code);
      final Class<? extends Object> compiledClass = _compileToClass;
      EList<EObject> _contents_1 = res.getContents();
      EObject _head = IterableExtensions.<EObject>head(_contents_1);
      this.helper.assertNoErrors(_head);
      return compiledClass;
    }
  }
}