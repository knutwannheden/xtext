/**
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.xbase.tests.typesystem;

import com.google.common.collect.Iterators;
import com.google.inject.Inject;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Callable;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.junit4.InjectWith;
import org.eclipse.xtext.junit4.XtextRunner;
import org.eclipse.xtext.nodemodel.ICompositeNode;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;
import org.eclipse.xtext.xbase.XClosure;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Functions.Function0;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.IteratorExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure2;
import org.eclipse.xtext.xbase.tests.AbstractXbaseTestCase;
import org.eclipse.xtext.xbase.tests.typesystem.XbaseNewTypeSystemInjectorProvider;
import org.eclipse.xtext.xbase.typesystem.IBatchTypeResolver;
import org.eclipse.xtext.xbase.typesystem.IResolvedTypes;
import org.eclipse.xtext.xbase.typesystem.references.FunctionTypeReference;
import org.eclipse.xtext.xbase.typesystem.references.LightweightTypeReference;
import org.eclipse.xtext.xbase.typesystem.references.ParameterizedTypeReference;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.rules.ErrorCollector;
import org.junit.runner.RunWith;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@RunWith(value = XtextRunner.class)
@InjectWith(value = XbaseNewTypeSystemInjectorProvider.class)
@SuppressWarnings("all")
public abstract class AbstractClosureTypeTest2 extends AbstractXbaseTestCase {
  @Inject
  private IBatchTypeResolver typeResolver;
  
  @Rule
  public ErrorCollector collector = new Function0<ErrorCollector>() {
    public ErrorCollector apply() {
      ErrorCollector _errorCollector = new ErrorCollector();
      return _errorCollector;
    }
  }.apply();
  
  public List<Object> resolvesClosuresTo(final CharSequence expression, final String... types) {
    final List<XClosure> closures = this.findClosures(expression);
    boolean _isEmpty = closures.isEmpty();
    Assert.assertFalse(_isEmpty);
    int _size = ((List<String>)Conversions.doWrapArray(types)).size();
    int _size_1 = closures.size();
    Assert.assertEquals(_size, _size_1);
    XClosure _head = IterableExtensions.<XClosure>head(closures);
    final IResolvedTypes resolvedTypes = this.typeResolver.resolveTypes(_head);
    final ArrayList<Object> result = CollectionLiterals.<Object>newArrayList();
    final Procedure2<XClosure,Integer> _function = new Procedure2<XClosure,Integer>() {
        public void apply(final XClosure closure, final Integer index) {
          final LightweightTypeReference closureType = resolvedTypes.getActualType(closure);
          final Function0<Object> _function = new Function0<Object>() {
              public Object apply() {
                StringConcatenation _builder = new StringConcatenation();
                _builder.append("failed for closure at ");
                _builder.append(index, "");
                _builder.append(": ");
                _builder.append(closureType, "");
                Assert.assertTrue(_builder.toString(), (closureType instanceof FunctionTypeReference));
                return null;
              }
            };
          AbstractClosureTypeTest2.this.collector.checkSucceeds(new Callable<Object>() {
              public Object call() {
                return _function.apply();
              }
          });
          final Function0<Object> _function_1 = new Function0<Object>() {
              public Object apply() {
                StringConcatenation _builder = new StringConcatenation();
                _builder.append("failed for closure at ");
                _builder.append(index, "");
                String _get = ((List<String>)Conversions.doWrapArray(types)).get((index).intValue());
                String _simpleName = closureType.getSimpleName();
                Assert.assertEquals(_builder.toString(), _get, _simpleName);
                return null;
              }
            };
          AbstractClosureTypeTest2.this.collector.checkSucceeds(new Callable<Object>() {
              public Object call() {
                return _function_1.apply();
              }
          });
          result.add(closureType);
        }
      };
    IterableExtensions.<XClosure>forEach(closures, _function);
    return result;
  }
  
  public void withEquivalents(final List<Object> references, final String... types) {
    final Procedure2<Object,Integer> _function = new Procedure2<Object,Integer>() {
        public void apply(final Object reference, final Integer index) {
          final Function0<Object> _function = new Function0<Object>() {
              public Object apply() {
                Assert.assertTrue((reference instanceof FunctionTypeReference));
                return null;
              }
            };
          AbstractClosureTypeTest2.this.collector.checkSucceeds(new Callable<Object>() {
              public Object call() {
                return _function.apply();
              }
          });
          final Function0<Object> _function_1 = new Function0<Object>() {
              public Object apply() {
                String _get = ((List<String>)Conversions.doWrapArray(types)).get((index).intValue());
                String _equivalent = AbstractClosureTypeTest2.this.getEquivalent(((FunctionTypeReference) reference));
                Assert.assertEquals(_get, _equivalent);
                return null;
              }
            };
          AbstractClosureTypeTest2.this.collector.checkSucceeds(new Callable<Object>() {
              public Object call() {
                return _function_1.apply();
              }
          });
        }
      };
    IterableExtensions.<Object>forEach(references, _function);
  }
  
  public String getEquivalent(final ParameterizedTypeReference type) {
    List<LightweightTypeReference> _typeArguments = type.getTypeArguments();
    boolean _isEmpty = _typeArguments.isEmpty();
    if (_isEmpty) {
      JvmType _type = type.getType();
      return _type.getSimpleName();
    }
    StringConcatenation _builder = new StringConcatenation();
    JvmType _type_1 = type.getType();
    String _simpleName = _type_1.getSimpleName();
    _builder.append(_simpleName, "");
    _builder.append("<");
    List<LightweightTypeReference> _typeArguments_1 = type.getTypeArguments();
    final Function1<LightweightTypeReference,String> _function = new Function1<LightweightTypeReference,String>() {
        public String apply(final LightweightTypeReference it) {
          String _simpleName = it.getSimpleName();
          return _simpleName;
        }
      };
    String _join = IterableExtensions.<LightweightTypeReference>join(_typeArguments_1, ", ", _function);
    _builder.append(_join, "");
    _builder.append(">");
    return _builder.toString();
  }
  
  private static Set<String> seenExpressions;
  
  @BeforeClass
  public static void createSeenExpressionsSet() {
    HashSet<String> _newHashSet = CollectionLiterals.<String>newHashSet();
    AbstractClosureTypeTest2.seenExpressions = _newHashSet;
  }
  
  @AfterClass
  public static void discardSeenExpressions() {
    AbstractClosureTypeTest2.seenExpressions = null;
  }
  
  protected List<XClosure> findClosures(final CharSequence expression) {
    try {
      String _string = expression.toString();
      String _replace = _string.replace("ClosureTypeResolutionTestData", "org.eclipse.xtext.xbase.tests.typesystem.ClosureTypeResolutionTestData");
      final String expressionAsString = _replace.replace("$$", "org::eclipse::xtext::xbase::lib::");
      final XExpression xExpression = this.expression(expressionAsString, false);
      TreeIterator<EObject> _eAll = EcoreUtil2.eAll(xExpression);
      Iterator<XClosure> _filter = Iterators.<XClosure>filter(_eAll, XClosure.class);
      final List<XClosure> Closures = IteratorExtensions.<XClosure>toList(_filter);
      final Function1<XClosure,Integer> _function = new Function1<XClosure,Integer>() {
          public Integer apply(final XClosure it) {
            ICompositeNode _findActualNodeFor = NodeModelUtils.findActualNodeFor(it);
            int _offset = _findActualNodeFor.getOffset();
            return Integer.valueOf(_offset);
          }
        };
      return IterableExtensions.<XClosure, Integer>sortBy(Closures, _function);
    } catch (Exception _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  protected XExpression expression(final CharSequence expression, final boolean resolve) throws Exception {
    XExpression _xblockexpression = null;
    {
      final String string = expression.toString();
      boolean _add = AbstractClosureTypeTest2.seenExpressions.add(string);
      boolean _not = (!_add);
      if (_not) {
        String _plus = ("Duplicate expression under test: " + expression);
        Assert.fail(_plus);
      }
      XExpression _expression = super.expression(expression, resolve);
      _xblockexpression = (_expression);
    }
    return _xblockexpression;
  }
}
