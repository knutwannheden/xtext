package org.eclipse.xtext.xbase.formatting;

import com.google.inject.Inject;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.AbstractElement;
import org.eclipse.xtext.AbstractRule;
import org.eclipse.xtext.CrossReference;
import org.eclipse.xtext.Keyword;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.common.types.JvmFormalParameter;
import org.eclipse.xtext.common.types.JvmGenericArrayTypeReference;
import org.eclipse.xtext.common.types.JvmParameterizedTypeReference;
import org.eclipse.xtext.common.types.JvmTypeConstraint;
import org.eclipse.xtext.common.types.JvmTypeParameter;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.common.types.JvmWildcardTypeReference;
import org.eclipse.xtext.common.types.TypesPackage.Literals;
import org.eclipse.xtext.nodemodel.ICompositeNode;
import org.eclipse.xtext.nodemodel.ILeafNode;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.xbase.XAbstractFeatureCall;
import org.eclipse.xtext.xbase.XAssignment;
import org.eclipse.xtext.xbase.XBinaryOperation;
import org.eclipse.xtext.xbase.XBlockExpression;
import org.eclipse.xtext.xbase.XCasePart;
import org.eclipse.xtext.xbase.XCatchClause;
import org.eclipse.xtext.xbase.XClosure;
import org.eclipse.xtext.xbase.XConstructorCall;
import org.eclipse.xtext.xbase.XDoWhileExpression;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.XFeatureCall;
import org.eclipse.xtext.xbase.XForLoopExpression;
import org.eclipse.xtext.xbase.XIfExpression;
import org.eclipse.xtext.xbase.XMemberFeatureCall;
import org.eclipse.xtext.xbase.XReturnExpression;
import org.eclipse.xtext.xbase.XSwitchExpression;
import org.eclipse.xtext.xbase.XThrowExpression;
import org.eclipse.xtext.xbase.XTryCatchFinallyExpression;
import org.eclipse.xtext.xbase.XTypeLiteral;
import org.eclipse.xtext.xbase.XVariableDeclaration;
import org.eclipse.xtext.xbase.XWhileExpression;
import org.eclipse.xtext.xbase.annotations.xAnnotations.XAnnotation;
import org.eclipse.xtext.xbase.annotations.xAnnotations.XAnnotationElementValuePair;
import org.eclipse.xtext.xbase.annotations.xAnnotations.XAnnotationValueArray;
import org.eclipse.xtext.xbase.configuration.IConfigurationValues;
import org.eclipse.xtext.xbase.formatting.AbstractFormatter;
import org.eclipse.xtext.xbase.formatting.FormattableDocument;
import org.eclipse.xtext.xbase.formatting.FormattingData;
import org.eclipse.xtext.xbase.formatting.FormattingDataFactory;
import org.eclipse.xtext.xbase.formatting.FormattingDataInit;
import org.eclipse.xtext.xbase.formatting.HiddenLeafAccess;
import org.eclipse.xtext.xbase.formatting.HiddenLeafs;
import org.eclipse.xtext.xbase.formatting.NodeModelAccess;
import org.eclipse.xtext.xbase.formatting.XbaseFormatterConfigKeys;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.eclipse.xtext.xbase.services.XbaseGrammarAccess;
import org.eclipse.xtext.xbase.services.XbaseGrammarAccess.XMemberFeatureCallElements;
import org.eclipse.xtext.xtype.XFunctionTypeRef;

@SuppressWarnings("all")
public class XbaseFormatter2 extends AbstractFormatter {
  @Inject
  private NodeModelAccess _nodeModelAccess;
  
  @Inject
  private HiddenLeafAccess _hiddenLeafAccess;
  
  @Inject
  private FormattingDataFactory _formattingDataFactory;
  
  @Inject
  private XbaseFormatterConfigKeys _xbaseFormatterConfigKeys;
  
  @Inject
  private XbaseGrammarAccess _xbaseGrammarAccess;
  
  protected void _format(final XAnnotationValueArray ann, final FormattableDocument document) {
    ILeafNode node = this._nodeModelAccess.nodeForKeyword(ann, "{");
    EList<XExpression> _values = ann.getValues();
    for (final XExpression value : _values) {
      {
        final Procedure1<FormattingDataInit> _function = new Procedure1<FormattingDataInit>() {
            public void apply(final FormattingDataInit it) {
              EList<XExpression> _values = ann.getValues();
              XExpression _head = IterableExtensions.<XExpression>head(_values);
              boolean _equals = ObjectExtensions.operator_equals(value, _head);
              if (_equals) {
                it.noSpace();
              } else {
                it.oneSpace();
              }
            }
          };
        Function1<? super FormattableDocument,? extends Iterable<FormattingData>> _append = this._formattingDataFactory.append(node, _function);
        document.operator_add(_append);
        this.format(value, document);
        INode _nodeForEObject = this._nodeModelAccess.nodeForEObject(value);
        ILeafNode _immediatelyFollowingKeyword = this._nodeModelAccess.immediatelyFollowingKeyword(_nodeForEObject, ",");
        node = _immediatelyFollowingKeyword;
        final Procedure1<FormattingDataInit> _function_1 = new Procedure1<FormattingDataInit>() {
            public void apply(final FormattingDataInit it) {
              it.noSpace();
            }
          };
        Function1<? super FormattableDocument,? extends Iterable<FormattingData>> _prepend = this._formattingDataFactory.prepend(node, _function_1);
        document.operator_add(_prepend);
      }
    }
    ILeafNode _nodeForKeyword = this._nodeModelAccess.nodeForKeyword(ann, "}");
    final Procedure1<FormattingDataInit> _function = new Procedure1<FormattingDataInit>() {
        public void apply(final FormattingDataInit it) {
          it.noSpace();
        }
      };
    Function1<? super FormattableDocument,? extends Iterable<FormattingData>> _prepend = this._formattingDataFactory.prepend(_nodeForKeyword, _function);
    document.operator_add(_prepend);
  }
  
  protected void _format(final XAnnotation ann, final FormattableDocument document) {
    ILeafNode _nodeForKeyword = this._nodeModelAccess.nodeForKeyword(ann, "@");
    final Procedure1<ILeafNode> _function = new Procedure1<ILeafNode>() {
        public void apply(final ILeafNode it) {
          final Procedure1<FormattingDataInit> _function = new Procedure1<FormattingDataInit>() {
              public void apply(final FormattingDataInit it) {
                it.noSpace();
              }
            };
          Function1<? super FormattableDocument,? extends Iterable<FormattingData>> _append = XbaseFormatter2.this._formattingDataFactory.append(it, _function);
          document.operator_add(_append);
        }
      };
    ObjectExtensions.<ILeafNode>operator_doubleArrow(_nodeForKeyword, _function);
    ILeafNode _nodeForKeyword_1 = this._nodeModelAccess.nodeForKeyword(ann, "(");
    final Procedure1<ILeafNode> _function_1 = new Procedure1<ILeafNode>() {
        public void apply(final ILeafNode it) {
          final Procedure1<FormattingDataInit> _function = new Procedure1<FormattingDataInit>() {
              public void apply(final FormattingDataInit it) {
                it.noSpace();
              }
            };
          Function1<? super FormattableDocument,? extends Iterable<FormattingData>> _prepend = XbaseFormatter2.this._formattingDataFactory.prepend(it, _function);
          document.operator_add(_prepend);
          final Procedure1<FormattingDataInit> _function_1 = new Procedure1<FormattingDataInit>() {
              public void apply(final FormattingDataInit it) {
                it.noSpace();
              }
            };
          Function1<? super FormattableDocument,? extends Iterable<FormattingData>> _append = XbaseFormatter2.this._formattingDataFactory.append(it, _function_1);
          document.operator_add(_append);
        }
      };
    ObjectExtensions.<ILeafNode>operator_doubleArrow(_nodeForKeyword_1, _function_1);
    XExpression _value = ann.getValue();
    boolean _notEquals = ObjectExtensions.operator_notEquals(_value, null);
    if (_notEquals) {
      XExpression _value_1 = ann.getValue();
      this.format(_value_1, document);
      ILeafNode _nodeForKeyword_2 = this._nodeModelAccess.nodeForKeyword(ann, ")");
      final Procedure1<ILeafNode> _function_2 = new Procedure1<ILeafNode>() {
          public void apply(final ILeafNode it) {
            final Procedure1<FormattingDataInit> _function = new Procedure1<FormattingDataInit>() {
                public void apply(final FormattingDataInit it) {
                  it.noSpace();
                }
              };
            Function1<? super FormattableDocument,? extends Iterable<FormattingData>> _prepend = XbaseFormatter2.this._formattingDataFactory.prepend(it, _function);
            document.operator_add(_prepend);
          }
        };
      ObjectExtensions.<ILeafNode>operator_doubleArrow(_nodeForKeyword_2, _function_2);
    } else {
      EList<XAnnotationElementValuePair> _elementValuePairs = ann.getElementValuePairs();
      boolean _isEmpty = _elementValuePairs.isEmpty();
      boolean _not = (!_isEmpty);
      if (_not) {
        EList<XAnnotationElementValuePair> _elementValuePairs_1 = ann.getElementValuePairs();
        for (final XAnnotationElementValuePair pair : _elementValuePairs_1) {
          {
            ILeafNode _nodeForKeyword_3 = this._nodeModelAccess.nodeForKeyword(pair, "=");
            final Procedure1<ILeafNode> _function_3 = new Procedure1<ILeafNode>() {
                public void apply(final ILeafNode it) {
                  final Procedure1<FormattingDataInit> _function = new Procedure1<FormattingDataInit>() {
                      public void apply(final FormattingDataInit it) {
                        it.noSpace();
                      }
                    };
                  Function1<? super FormattableDocument,? extends Iterable<FormattingData>> _prepend = XbaseFormatter2.this._formattingDataFactory.prepend(it, _function);
                  document.operator_add(_prepend);
                  final Procedure1<FormattingDataInit> _function_1 = new Procedure1<FormattingDataInit>() {
                      public void apply(final FormattingDataInit it) {
                        it.noSpace();
                      }
                    };
                  Function1<? super FormattableDocument,? extends Iterable<FormattingData>> _append = XbaseFormatter2.this._formattingDataFactory.append(it, _function_1);
                  document.operator_add(_append);
                }
              };
            ObjectExtensions.<ILeafNode>operator_doubleArrow(_nodeForKeyword_3, _function_3);
            XExpression _value_2 = pair.getValue();
            this.format(_value_2, document);
            INode _nodeForEObject = this._nodeModelAccess.nodeForEObject(pair);
            final ILeafNode separator = this._nodeModelAccess.immediatelyFollowingKeyword(_nodeForEObject, ",");
            final Procedure1<FormattingDataInit> _function_4 = new Procedure1<FormattingDataInit>() {
                public void apply(final FormattingDataInit it) {
                  it.noSpace();
                }
              };
            Function1<? super FormattableDocument,? extends Iterable<FormattingData>> _prepend = this._formattingDataFactory.prepend(separator, _function_4);
            document.operator_add(_prepend);
            final Procedure1<FormattingDataInit> _function_5 = new Procedure1<FormattingDataInit>() {
                public void apply(final FormattingDataInit it) {
                  it.oneSpace();
                }
              };
            Function1<? super FormattableDocument,? extends Iterable<FormattingData>> _append = this._formattingDataFactory.append(separator, _function_5);
            document.operator_add(_append);
          }
        }
        ILeafNode _nodeForKeyword_3 = this._nodeModelAccess.nodeForKeyword(ann, ")");
        final Procedure1<ILeafNode> _function_3 = new Procedure1<ILeafNode>() {
            public void apply(final ILeafNode it) {
              final Procedure1<FormattingDataInit> _function = new Procedure1<FormattingDataInit>() {
                  public void apply(final FormattingDataInit it) {
                    it.noSpace();
                  }
                };
              Function1<? super FormattableDocument,? extends Iterable<FormattingData>> _prepend = XbaseFormatter2.this._formattingDataFactory.prepend(it, _function);
              document.operator_add(_prepend);
            }
          };
        ObjectExtensions.<ILeafNode>operator_doubleArrow(_nodeForKeyword_3, _function_3);
      }
    }
  }
  
  protected void _format(final JvmGenericArrayTypeReference array, final FormattableDocument document) {
    ILeafNode _nodeForKeyword = this._nodeModelAccess.nodeForKeyword(array, "[");
    final Procedure1<FormattingDataInit> _function = new Procedure1<FormattingDataInit>() {
        public void apply(final FormattingDataInit it) {
          it.noSpace();
        }
      };
    Function1<? super FormattableDocument,? extends Iterable<FormattingData>> _prepend = this._formattingDataFactory.prepend(_nodeForKeyword, _function);
    document.operator_add(_prepend);
    ILeafNode _nodeForKeyword_1 = this._nodeModelAccess.nodeForKeyword(array, "]");
    final Procedure1<FormattingDataInit> _function_1 = new Procedure1<FormattingDataInit>() {
        public void apply(final FormattingDataInit it) {
          it.noSpace();
        }
      };
    Function1<? super FormattableDocument,? extends Iterable<FormattingData>> _prepend_1 = this._formattingDataFactory.prepend(_nodeForKeyword_1, _function_1);
    document.operator_add(_prepend_1);
    JvmTypeReference _componentType = array.getComponentType();
    this.format(_componentType, document);
  }
  
  protected void _format(final XFunctionTypeRef func, final FormattableDocument document) {
    ILeafNode _nodeForKeyword = this._nodeModelAccess.nodeForKeyword(func, "(");
    final Procedure1<FormattingDataInit> _function = new Procedure1<FormattingDataInit>() {
        public void apply(final FormattingDataInit it) {
          it.noSpace();
        }
      };
    Function1<? super FormattableDocument,? extends Iterable<FormattingData>> _append = this._formattingDataFactory.append(_nodeForKeyword, _function);
    document.operator_add(_append);
    EList<JvmTypeReference> _paramTypes = func.getParamTypes();
    for (final JvmTypeReference param : _paramTypes) {
      {
        this.format(param, document);
        INode _nodeForEObject = this._nodeModelAccess.nodeForEObject(param);
        ILeafNode _immediatelyFollowingKeyword = this._nodeModelAccess.immediatelyFollowingKeyword(_nodeForEObject, ",");
        final Procedure1<FormattingDataInit> _function_1 = new Procedure1<FormattingDataInit>() {
            public void apply(final FormattingDataInit it) {
              it.noSpace();
            }
          };
        final Procedure1<FormattingDataInit> _function_2 = new Procedure1<FormattingDataInit>() {
            public void apply(final FormattingDataInit it) {
              it.oneSpace();
            }
          };
        Function1<? super FormattableDocument,? extends Iterable<FormattingData>> _surround = this._formattingDataFactory.surround(_immediatelyFollowingKeyword, _function_1, _function_2);
        document.operator_add(_surround);
      }
    }
    ILeafNode _nodeForKeyword_1 = this._nodeModelAccess.nodeForKeyword(func, ")");
    final Procedure1<FormattingDataInit> _function_1 = new Procedure1<FormattingDataInit>() {
        public void apply(final FormattingDataInit it) {
          EList<JvmTypeReference> _paramTypes = func.getParamTypes();
          boolean _isEmpty = _paramTypes.isEmpty();
          boolean _not = (!_isEmpty);
          if (_not) {
            it.noSpace();
          }
        }
      };
    final Procedure1<FormattingDataInit> _function_2 = new Procedure1<FormattingDataInit>() {
        public void apply(final FormattingDataInit it) {
          it.noSpace();
        }
      };
    Function1<? super FormattableDocument,? extends Iterable<FormattingData>> _surround = this._formattingDataFactory.surround(_nodeForKeyword_1, _function_1, _function_2);
    document.operator_add(_surround);
    ILeafNode _nodeForKeyword_2 = this._nodeModelAccess.nodeForKeyword(func, "=>");
    final Procedure1<FormattingDataInit> _function_3 = new Procedure1<FormattingDataInit>() {
        public void apply(final FormattingDataInit it) {
          it.noSpace();
        }
      };
    Function1<? super FormattableDocument,? extends Iterable<FormattingData>> _append_1 = this._formattingDataFactory.append(_nodeForKeyword_2, _function_3);
    document.operator_add(_append_1);
    JvmTypeReference _returnType = func.getReturnType();
    this.format(_returnType, document);
  }
  
  protected void _format(final JvmTypeParameter ref, final FormattableDocument document) {
    EList<JvmTypeConstraint> _constraints = ref.getConstraints();
    for (final JvmTypeConstraint c : _constraints) {
      {
        INode _nodeForEObject = this._nodeModelAccess.nodeForEObject(c);
        final Procedure1<FormattingDataInit> _function = new Procedure1<FormattingDataInit>() {
            public void apply(final FormattingDataInit it) {
              it.oneSpace();
            }
          };
        Function1<? super FormattableDocument,? extends Iterable<FormattingData>> _prepend = this._formattingDataFactory.prepend(_nodeForEObject, _function);
        document.operator_add(_prepend);
        this.format(c, document);
      }
    }
  }
  
  protected void _format(final JvmParameterizedTypeReference ref, final FormattableDocument document) {
    ILeafNode _nodeForKeyword = this._nodeModelAccess.nodeForKeyword(ref, "<");
    final Procedure1<FormattingDataInit> _function = new Procedure1<FormattingDataInit>() {
        public void apply(final FormattingDataInit it) {
          it.noSpace();
        }
      };
    Function1<? super FormattableDocument,? extends Iterable<FormattingData>> _surround = this._formattingDataFactory.surround(_nodeForKeyword, _function);
    document.operator_add(_surround);
    EList<JvmTypeReference> _arguments = ref.getArguments();
    for (final JvmTypeReference arg : _arguments) {
      {
        this.format(arg, document);
        INode _nodeForEObject = this._nodeModelAccess.nodeForEObject(arg);
        ILeafNode _immediatelyFollowingKeyword = this._nodeModelAccess.immediatelyFollowingKeyword(_nodeForEObject, ",");
        final Procedure1<FormattingDataInit> _function_1 = new Procedure1<FormattingDataInit>() {
            public void apply(final FormattingDataInit it) {
              it.noSpace();
            }
          };
        final Procedure1<FormattingDataInit> _function_2 = new Procedure1<FormattingDataInit>() {
            public void apply(final FormattingDataInit it) {
              it.oneSpace();
            }
          };
        Function1<? super FormattableDocument,? extends Iterable<FormattingData>> _surround_1 = this._formattingDataFactory.surround(_immediatelyFollowingKeyword, _function_1, _function_2);
        document.operator_add(_surround_1);
      }
    }
    EList<JvmTypeReference> _arguments_1 = ref.getArguments();
    boolean _isEmpty = _arguments_1.isEmpty();
    boolean _not = (!_isEmpty);
    if (_not) {
      ILeafNode _nodeForKeyword_1 = this._nodeModelAccess.nodeForKeyword(ref, ">");
      final Procedure1<FormattingDataInit> _function_1 = new Procedure1<FormattingDataInit>() {
          public void apply(final FormattingDataInit it) {
            it.noSpace();
          }
        };
      Function1<? super FormattableDocument,? extends Iterable<FormattingData>> _prepend = this._formattingDataFactory.prepend(_nodeForKeyword_1, _function_1);
      document.operator_add(_prepend);
    }
  }
  
  protected void _format(final JvmWildcardTypeReference ref, final FormattableDocument document) {
    EList<JvmTypeConstraint> _constraints = ref.getConstraints();
    boolean _isEmpty = _constraints.isEmpty();
    boolean _not = (!_isEmpty);
    if (_not) {
      ILeafNode _nodeForKeyword = this._nodeModelAccess.nodeForKeyword(ref, "?");
      final Procedure1<FormattingDataInit> _function = new Procedure1<FormattingDataInit>() {
          public void apply(final FormattingDataInit it) {
            it.oneSpace();
          }
        };
      Function1<? super FormattableDocument,? extends Iterable<FormattingData>> _append = this._formattingDataFactory.append(_nodeForKeyword, _function);
      document.operator_add(_append);
    }
    EList<JvmTypeConstraint> _constraints_1 = ref.getConstraints();
    for (final JvmTypeConstraint c : _constraints_1) {
      this.format(c, document);
    }
  }
  
  protected void _format(final JvmTypeConstraint constraint, final FormattableDocument document) {
    INode _nodeForFeature = this._nodeModelAccess.nodeForFeature(constraint, Literals.JVM_TYPE_CONSTRAINT__TYPE_REFERENCE);
    final Procedure1<FormattingDataInit> _function = new Procedure1<FormattingDataInit>() {
        public void apply(final FormattingDataInit it) {
          it.oneSpace();
        }
      };
    Function1<? super FormattableDocument,? extends Iterable<FormattingData>> _prepend = this._formattingDataFactory.prepend(_nodeForFeature, _function);
    document.operator_add(_prepend);
    JvmTypeReference _typeReference = constraint.getTypeReference();
    this.format(_typeReference, document);
  }
  
  protected void _format(final XVariableDeclaration expr, final FormattableDocument format) {
    ILeafNode _nodeForKeyword = this._nodeModelAccess.nodeForKeyword(expr, "val");
    final Procedure1<FormattingDataInit> _function = new Procedure1<FormattingDataInit>() {
        public void apply(final FormattingDataInit it) {
          it.oneSpace();
        }
      };
    Function1<? super FormattableDocument,? extends Iterable<FormattingData>> _append = this._formattingDataFactory.append(_nodeForKeyword, _function);
    format.operator_add(_append);
    ILeafNode _nodeForKeyword_1 = this._nodeModelAccess.nodeForKeyword(expr, "var");
    final Procedure1<FormattingDataInit> _function_1 = new Procedure1<FormattingDataInit>() {
        public void apply(final FormattingDataInit it) {
          it.oneSpace();
        }
      };
    Function1<? super FormattableDocument,? extends Iterable<FormattingData>> _append_1 = this._formattingDataFactory.append(_nodeForKeyword_1, _function_1);
    format.operator_add(_append_1);
    INode _nodeForFeature = this._nodeModelAccess.nodeForFeature(expr, org.eclipse.xtext.xbase.XbasePackage.Literals.XVARIABLE_DECLARATION__TYPE);
    final Procedure1<FormattingDataInit> _function_2 = new Procedure1<FormattingDataInit>() {
        public void apply(final FormattingDataInit it) {
          it.oneSpace();
        }
      };
    Function1<? super FormattableDocument,? extends Iterable<FormattingData>> _append_2 = this._formattingDataFactory.append(_nodeForFeature, _function_2);
    format.operator_add(_append_2);
    ILeafNode _nodeForKeyword_2 = this._nodeModelAccess.nodeForKeyword(expr, "=");
    final Procedure1<FormattingDataInit> _function_3 = new Procedure1<FormattingDataInit>() {
        public void apply(final FormattingDataInit it) {
          it.oneSpace();
        }
      };
    Function1<? super FormattableDocument,? extends Iterable<FormattingData>> _surround = this._formattingDataFactory.surround(_nodeForKeyword_2, _function_3);
    format.operator_add(_surround);
    JvmTypeReference _type = expr.getType();
    this.format(_type, format);
    XExpression _right = expr.getRight();
    this.format(_right, format);
  }
  
  protected void _format(final XAssignment expr, final FormattableDocument format) {
    ILeafNode _nodeForKeyword = this._nodeModelAccess.nodeForKeyword(expr, "=");
    final Procedure1<FormattingDataInit> _function = new Procedure1<FormattingDataInit>() {
        public void apply(final FormattingDataInit it) {
          it.oneSpace();
        }
      };
    Function1<? super FormattableDocument,? extends Iterable<FormattingData>> _surround = this._formattingDataFactory.surround(_nodeForKeyword, _function);
    format.operator_add(_surround);
    XExpression _assignable = expr.getAssignable();
    this.format(_assignable, format);
    XExpression _value = expr.getValue();
    this.format(_value, format);
  }
  
  protected void formatStaticQualifier(final INode node, final FormattableDocument document) {
    if ((node instanceof ICompositeNode)) {
      final Iterable<ILeafNode> leafs = ((ICompositeNode) node).getLeafNodes();
      for (final ILeafNode n : leafs) {
        boolean _and = false;
        EObject _grammarElement = n.getGrammarElement();
        if (!(_grammarElement instanceof Keyword)) {
          _and = false;
        } else {
          String _text = n.getText();
          boolean _equals = ObjectExtensions.operator_equals(_text, "::");
          _and = ((_grammarElement instanceof Keyword) && _equals);
        }
        if (_and) {
          final Procedure1<FormattingDataInit> _function = new Procedure1<FormattingDataInit>() {
              public void apply(final FormattingDataInit it) {
                it.noSpace();
              }
            };
          Function1<? super FormattableDocument,? extends Iterable<FormattingData>> _prepend = this._formattingDataFactory.prepend(n, _function);
          document.operator_add(_prepend);
          ILeafNode _last = IterableExtensions.<ILeafNode>last(leafs);
          boolean _notEquals = ObjectExtensions.operator_notEquals(n, _last);
          if (_notEquals) {
            final Procedure1<FormattingDataInit> _function_1 = new Procedure1<FormattingDataInit>() {
                public void apply(final FormattingDataInit it) {
                  it.noSpace();
                }
              };
            Function1<? super FormattableDocument,? extends Iterable<FormattingData>> _append = this._formattingDataFactory.append(n, _function_1);
            document.operator_add(_append);
          }
        }
      }
    }
  }
  
  protected boolean fitsIntoLine(final FormattableDocument fmt, final EObject expression) {
    final INode node = this._nodeModelAccess.nodeForEObject(expression);
    final String lookahead = this.lookahead(fmt, expression);
    boolean _or = false;
    boolean _equals = ObjectExtensions.operator_equals(node, null);
    if (_equals) {
      _or = true;
    } else {
      boolean _contains = lookahead.contains("\n");
      _or = (_equals || _contains);
    }
    if (_or) {
      return false;
    } else {
      int _offset = node.getOffset();
      int _lineLengthBefore = fmt.lineLengthBefore(_offset);
      int _length = lookahead.length();
      final int length = (_lineLengthBefore + _length);
      IConfigurationValues _cfg = fmt.getCfg();
      Integer _get = _cfg.<Integer>get(this._xbaseFormatterConfigKeys.maxLineWidth);
      return (length <= (_get).intValue());
    }
  }
  
  protected String lookahead(final FormattableDocument fmt, final EObject expression) {
    String _xblockexpression = null;
    {
      FormattableDocument _formattableDocument = new FormattableDocument(fmt);
      final FormattableDocument lookahead = _formattableDocument;
      this.format(expression, lookahead);
      final INode node = this._nodeModelAccess.nodeForEObject(expression);
      String _xifexpression = null;
      boolean _notEquals = ObjectExtensions.operator_notEquals(node, null);
      if (_notEquals) {
        int _offset = node.getOffset();
        int _length = node.getLength();
        String _renderToString = lookahead.renderToString(_offset, _length);
        _xifexpression = _renderToString;
      } else {
        _xifexpression = "";
      }
      _xblockexpression = (_xifexpression);
    }
    return _xblockexpression;
  }
  
  protected void formatFeatureCallParamsWrapIfNeeded(final INode open, final List<XExpression> params, final FormattableDocument format) {
    final XClosure builder = this.builder(params);
    final Iterable<XExpression> explicitParams = this.explicitParams(params);
    INode node = null;
    boolean indented = false;
    boolean _isEmpty = IterableExtensions.isEmpty(explicitParams);
    if (_isEmpty) {
      final Procedure1<FormattingDataInit> _function = new Procedure1<FormattingDataInit>() {
          public void apply(final FormattingDataInit it) {
            it.noSpace();
          }
        };
      Function1<? super FormattableDocument,? extends Iterable<FormattingData>> _append = this._formattingDataFactory.append(open, _function);
      format.operator_add(_append);
    } else {
      for (final XExpression arg : explicitParams) {
        {
          XExpression _head = IterableExtensions.<XExpression>head(explicitParams);
          boolean _equals = ObjectExtensions.operator_equals(arg, _head);
          if (_equals) {
            final INode head = this._nodeModelAccess.nodeForEObject(arg);
            boolean _fitsIntoLine = this.fitsIntoLine(format, arg);
            if (_fitsIntoLine) {
              final Procedure1<FormattingDataInit> _function_1 = new Procedure1<FormattingDataInit>() {
                  public void apply(final FormattingDataInit it) {
                    it.noSpace();
                  }
                };
              Function1<? super FormattableDocument,? extends Iterable<FormattingData>> _prepend = this._formattingDataFactory.prepend(head, _function_1);
              format.operator_add(_prepend);
            } else {
              final Procedure1<FormattingDataInit> _function_2 = new Procedure1<FormattingDataInit>() {
                  public void apply(final FormattingDataInit it) {
                    it.newLine();
                  }
                };
              Function1<? super FormattableDocument,? extends Iterable<FormattingData>> _prepend_1 = this._formattingDataFactory.prepend(head, _function_2);
              format.operator_add(_prepend_1);
              boolean _not = (!indented);
              if (_not) {
                final Procedure1<FormattingDataInit> _function_3 = new Procedure1<FormattingDataInit>() {
                    public void apply(final FormattingDataInit it) {
                      it.increaseIndentation();
                    }
                  };
                Function1<? super FormattableDocument,? extends Iterable<FormattingData>> _prepend_2 = this._formattingDataFactory.prepend(head, _function_3);
                format.operator_add(_prepend_2);
              }
              indented = true;
            }
          } else {
            boolean _notEquals = ObjectExtensions.operator_notEquals(node, null);
            if (_notEquals) {
              boolean _fitsIntoLine_1 = this.fitsIntoLine(format, arg);
              if (_fitsIntoLine_1) {
                final Procedure1<FormattingDataInit> _function_4 = new Procedure1<FormattingDataInit>() {
                    public void apply(final FormattingDataInit it) {
                      it.oneSpace();
                    }
                  };
                Function1<? super FormattableDocument,? extends Iterable<FormattingData>> _append_1 = this._formattingDataFactory.append(node, _function_4);
                format.operator_add(_append_1);
              } else {
                final Procedure1<FormattingDataInit> _function_5 = new Procedure1<FormattingDataInit>() {
                    public void apply(final FormattingDataInit it) {
                      it.newLine();
                    }
                  };
                Function1<? super FormattableDocument,? extends Iterable<FormattingData>> _append_2 = this._formattingDataFactory.append(node, _function_5);
                format.operator_add(_append_2);
                boolean _not_1 = (!indented);
                if (_not_1) {
                  final Procedure1<FormattingDataInit> _function_6 = new Procedure1<FormattingDataInit>() {
                      public void apply(final FormattingDataInit it) {
                        it.increaseIndentation();
                      }
                    };
                  Function1<? super FormattableDocument,? extends Iterable<FormattingData>> _append_3 = this._formattingDataFactory.append(node, _function_6);
                  format.operator_add(_append_3);
                }
                indented = true;
              }
            }
          }
          XExpression _last = IterableExtensions.<XExpression>last(explicitParams);
          boolean _equals_1 = ObjectExtensions.operator_equals(arg, _last);
          if (_equals_1) {
            INode _nodeForEObject = this._nodeModelAccess.nodeForEObject(arg);
            final Procedure1<FormattingDataInit> _function_7 = new Procedure1<FormattingDataInit>() {
                public void apply(final FormattingDataInit it) {
                  it.noSpace();
                }
              };
            Function1<? super FormattableDocument,? extends Iterable<FormattingData>> _append_4 = this._formattingDataFactory.append(_nodeForEObject, _function_7);
            format.operator_add(_append_4);
          }
          this.format(arg, format);
          INode _nodeForEObject_1 = this._nodeModelAccess.nodeForEObject(arg);
          ILeafNode _immediatelyFollowingKeyword = this._nodeModelAccess.immediatelyFollowingKeyword(_nodeForEObject_1, ",");
          node = _immediatelyFollowingKeyword;
          final Procedure1<FormattingDataInit> _function_8 = new Procedure1<FormattingDataInit>() {
              public void apply(final FormattingDataInit it) {
                it.noSpace();
              }
            };
          Function1<? super FormattableDocument,? extends Iterable<FormattingData>> _prepend_3 = this._formattingDataFactory.prepend(node, _function_8);
          format.operator_add(_prepend_3);
        }
      }
    }
    if (indented) {
      XExpression _last = IterableExtensions.<XExpression>last(explicitParams);
      INode _nodeForEObject = this._nodeModelAccess.nodeForEObject(_last);
      final Procedure1<FormattingDataInit> _function_1 = new Procedure1<FormattingDataInit>() {
          public void apply(final FormattingDataInit it) {
            it.decreaseIndentation();
          }
        };
      Function1<? super FormattableDocument,? extends Iterable<FormattingData>> _append_1 = this._formattingDataFactory.append(_nodeForEObject, _function_1);
      format.operator_add(_append_1);
    }
    boolean _notEquals = ObjectExtensions.operator_notEquals(builder, null);
    if (_notEquals) {
      INode _nodeForEObject_1 = this._nodeModelAccess.nodeForEObject(builder);
      final Procedure1<FormattingDataInit> _function_2 = new Procedure1<FormattingDataInit>() {
          public void apply(final FormattingDataInit it) {
            boolean _isMultilineLambda = XbaseFormatter2.this.isMultilineLambda(builder);
            if (_isMultilineLambda) {
              it.oneSpace();
            } else {
              it.noSpace();
            }
          }
        };
      Function1<? super FormattableDocument,? extends Iterable<FormattingData>> _prepend = this._formattingDataFactory.prepend(_nodeForEObject_1, _function_2);
      format.operator_add(_prepend);
      this.format(builder, format);
    }
  }
  
  protected XClosure builder(final List<XExpression> params) {
    XClosure _xifexpression = null;
    boolean _and = false;
    XExpression _last = IterableExtensions.<XExpression>last(params);
    boolean _notEquals = ObjectExtensions.operator_notEquals(_last, null);
    if (!_notEquals) {
      _and = false;
    } else {
      XExpression _last_1 = IterableExtensions.<XExpression>last(params);
      INode _nodeForEObject = this._nodeModelAccess.nodeForEObject(_last_1);
      INode _firstChild = ((ICompositeNode) _nodeForEObject).getFirstChild();
      EObject _grammarElement = _firstChild.getGrammarElement();
      XMemberFeatureCallElements _xMemberFeatureCallAccess = this._xbaseGrammarAccess.getXMemberFeatureCallAccess();
      RuleCall _memberCallArgumentsXClosureParserRuleCall_1_1_4_0 = _xMemberFeatureCallAccess.getMemberCallArgumentsXClosureParserRuleCall_1_1_4_0();
      boolean _equals = ObjectExtensions.operator_equals(_grammarElement, _memberCallArgumentsXClosureParserRuleCall_1_1_4_0);
      _and = (_notEquals && _equals);
    }
    if (_and) {
      XExpression _last_2 = IterableExtensions.<XExpression>last(params);
      _xifexpression = ((XClosure) _last_2);
    }
    return _xifexpression;
  }
  
  protected Iterable<XExpression> explicitParams(final List<XExpression> params) {
    Iterable<XExpression> _xblockexpression = null;
    {
      final XClosure builder = this.builder(params);
      Iterable<XExpression> _xifexpression = null;
      boolean _notEquals = ObjectExtensions.operator_notEquals(builder, null);
      if (_notEquals) {
        int _size = params.size();
        int _minus = (_size - 1);
        Iterable<XExpression> _take = IterableExtensions.<XExpression>take(params, _minus);
        _xifexpression = _take;
      } else {
        _xifexpression = params;
      }
      _xblockexpression = (_xifexpression);
    }
    return _xblockexpression;
  }
  
  protected void formatFeatureCallParamsMultiline(final INode open, final List<XExpression> params, final FormattableDocument format) {
    final XClosure builder = this.builder(params);
    final Iterable<XExpression> explicitParams = this.explicitParams(params);
    INode node = null;
    boolean _isEmpty = IterableExtensions.isEmpty(explicitParams);
    if (_isEmpty) {
      final Procedure1<FormattingDataInit> _function = new Procedure1<FormattingDataInit>() {
          public void apply(final FormattingDataInit it) {
            it.noSpace();
          }
        };
      Function1<? super FormattableDocument,? extends Iterable<FormattingData>> _append = this._formattingDataFactory.append(open, _function);
      format.operator_add(_append);
    } else {
      for (final XExpression arg : explicitParams) {
        {
          XExpression _head = IterableExtensions.<XExpression>head(explicitParams);
          boolean _equals = ObjectExtensions.operator_equals(arg, _head);
          if (_equals) {
            final INode head = this._nodeModelAccess.nodeForEObject(arg);
            final Procedure1<FormattingDataInit> _function_1 = new Procedure1<FormattingDataInit>() {
                public void apply(final FormattingDataInit it) {
                  it.newLine();
                  it.increaseIndentation();
                }
              };
            Function1<? super FormattableDocument,? extends Iterable<FormattingData>> _prepend = this._formattingDataFactory.prepend(head, _function_1);
            format.operator_add(_prepend);
          } else {
            boolean _notEquals = ObjectExtensions.operator_notEquals(node, null);
            if (_notEquals) {
              final Procedure1<FormattingDataInit> _function_2 = new Procedure1<FormattingDataInit>() {
                  public void apply(final FormattingDataInit it) {
                    it.newLine();
                  }
                };
              Function1<? super FormattableDocument,? extends Iterable<FormattingData>> _append_1 = this._formattingDataFactory.append(node, _function_2);
              format.operator_add(_append_1);
            }
          }
          XExpression _last = IterableExtensions.<XExpression>last(explicitParams);
          boolean _equals_1 = ObjectExtensions.operator_equals(arg, _last);
          if (_equals_1) {
            INode _nodeForEObject = this._nodeModelAccess.nodeForEObject(arg);
            final Procedure1<FormattingDataInit> _function_3 = new Procedure1<FormattingDataInit>() {
                public void apply(final FormattingDataInit it) {
                  it.newLine();
                  it.decreaseIndentation();
                }
              };
            Function1<? super FormattableDocument,? extends Iterable<FormattingData>> _append_2 = this._formattingDataFactory.append(_nodeForEObject, _function_3);
            format.operator_add(_append_2);
          }
          this.format(arg, format);
          INode _nodeForEObject_1 = this._nodeModelAccess.nodeForEObject(arg);
          ILeafNode _immediatelyFollowingKeyword = this._nodeModelAccess.immediatelyFollowingKeyword(_nodeForEObject_1, ",");
          node = _immediatelyFollowingKeyword;
          final Procedure1<FormattingDataInit> _function_4 = new Procedure1<FormattingDataInit>() {
              public void apply(final FormattingDataInit it) {
                it.noSpace();
              }
            };
          Function1<? super FormattableDocument,? extends Iterable<FormattingData>> _prepend_1 = this._formattingDataFactory.prepend(node, _function_4);
          format.operator_add(_prepend_1);
        }
      }
    }
    boolean _notEquals = ObjectExtensions.operator_notEquals(builder, null);
    if (_notEquals) {
      INode _nodeForEObject = this._nodeModelAccess.nodeForEObject(builder);
      final Procedure1<FormattingDataInit> _function_1 = new Procedure1<FormattingDataInit>() {
          public void apply(final FormattingDataInit it) {
            boolean _isMultilineLambda = XbaseFormatter2.this.isMultilineLambda(builder);
            if (_isMultilineLambda) {
              it.oneSpace();
            } else {
              it.noSpace();
            }
          }
        };
      Function1<? super FormattableDocument,? extends Iterable<FormattingData>> _prepend = this._formattingDataFactory.prepend(_nodeForEObject, _function_1);
      format.operator_add(_prepend);
      this.format(builder, format);
    }
  }
  
  /**
   * checks whether the given lambda should be formatted as a block.
   * That includes newlines after and before the brackets, and a fresh line for each expression.
   */
  protected boolean isMultilineLambda(final XClosure closure) {
    final ILeafNode closingBracket = this._nodeModelAccess.nodeForKeyword(closure, "]");
    HiddenLeafs _hiddenLeafsBefore = closingBracket==null?(HiddenLeafs)null:this._hiddenLeafAccess.getHiddenLeafsBefore(closingBracket);
    boolean _notEquals = ObjectExtensions.operator_notEquals(_hiddenLeafsBefore, null);
    if (_notEquals) {
      HiddenLeafs _hiddenLeafsBefore_1 = this._hiddenLeafAccess.getHiddenLeafsBefore(closingBracket);
      int _newLines = _hiddenLeafsBefore_1.getNewLines();
      return (_newLines > 0);
    }
    boolean _switchResult = false;
    XExpression _expression = closure.getExpression();
    final XExpression block = _expression;
    boolean _matched = false;
    if (!_matched) {
      if (block instanceof XBlockExpression) {
        final XBlockExpression _xBlockExpression = (XBlockExpression)block;
        _matched=true;
        boolean _and = false;
        EList<XExpression> _expressions = _xBlockExpression.getExpressions();
        int _size = _expressions.size();
        boolean _greaterThan = (_size > 1);
        if (!_greaterThan) {
          _and = false;
        } else {
          EList<XExpression> _expressions_1 = _xBlockExpression.getExpressions();
          boolean _isEachExpressionInOwnLine = this.isEachExpressionInOwnLine(_expressions_1);
          _and = (_greaterThan && _isEachExpressionInOwnLine);
        }
        _switchResult = _and;
      }
    }
    if (!_matched) {
      _switchResult = false;
    }
    return _switchResult;
  }
  
  protected boolean isEachExpressionInOwnLine(final Iterable<? extends XExpression> expressions) {
    int lastLine = (-1);
    for (final XExpression e : expressions) {
      {
        final INode node = this._nodeModelAccess.nodeForEObject(e);
        int _startLine = node.getStartLine();
        boolean _equals = (lastLine == _startLine);
        if (_equals) {
          return false;
        }
        int _endLine = node.getEndLine();
        lastLine = _endLine;
      }
    }
    return true;
  }
  
  protected void _format(final XConstructorCall expr, final FormattableDocument format) {
    INode _nodeForFeature = this._nodeModelAccess.nodeForFeature(expr, org.eclipse.xtext.xbase.XbasePackage.Literals.XCONSTRUCTOR_CALL__CONSTRUCTOR);
    final Procedure1<FormattingDataInit> _function = new Procedure1<FormattingDataInit>() {
        public void apply(final FormattingDataInit it) {
          it.oneSpace();
        }
      };
    Function1<? super FormattableDocument,? extends Iterable<FormattingData>> _prepend = this._formattingDataFactory.prepend(_nodeForFeature, _function);
    format.operator_add(_prepend);
    EList<JvmTypeReference> _typeArguments = expr.getTypeArguments();
    boolean _isEmpty = _typeArguments.isEmpty();
    boolean _not = (!_isEmpty);
    if (_not) {
      ILeafNode _nodeForKeyword = this._nodeModelAccess.nodeForKeyword(expr, "<");
      final Procedure1<FormattingDataInit> _function_1 = new Procedure1<FormattingDataInit>() {
          public void apply(final FormattingDataInit it) {
            it.noSpace();
          }
        };
      Function1<? super FormattableDocument,? extends Iterable<FormattingData>> _surround = this._formattingDataFactory.surround(_nodeForKeyword, _function_1);
      format.operator_add(_surround);
      EList<JvmTypeReference> _typeArguments_1 = expr.getTypeArguments();
      for (final JvmTypeReference arg : _typeArguments_1) {
        {
          this.format(arg, format);
          ILeafNode _immediatelyFollowingKeyword = this._nodeModelAccess.immediatelyFollowingKeyword(arg, ",");
          final Procedure1<FormattingDataInit> _function_2 = new Procedure1<FormattingDataInit>() {
              public void apply(final FormattingDataInit it) {
                it.noSpace();
              }
            };
          final Procedure1<FormattingDataInit> _function_3 = new Procedure1<FormattingDataInit>() {
              public void apply(final FormattingDataInit it) {
                it.oneSpace();
              }
            };
          Function1<? super FormattableDocument,? extends Iterable<FormattingData>> _surround_1 = this._formattingDataFactory.surround(_immediatelyFollowingKeyword, _function_2, _function_3);
          format.operator_add(_surround_1);
        }
      }
      ILeafNode _nodeForKeyword_1 = this._nodeModelAccess.nodeForKeyword(expr, ">");
      final Procedure1<FormattingDataInit> _function_2 = new Procedure1<FormattingDataInit>() {
          public void apply(final FormattingDataInit it) {
            it.noSpace();
          }
        };
      Function1<? super FormattableDocument,? extends Iterable<FormattingData>> _prepend_1 = this._formattingDataFactory.prepend(_nodeForKeyword_1, _function_2);
      format.operator_add(_prepend_1);
    }
    final ILeafNode open = this._nodeModelAccess.nodeForKeyword(expr, "(");
    final Procedure1<FormattingDataInit> _function_3 = new Procedure1<FormattingDataInit>() {
        public void apply(final FormattingDataInit it) {
          it.noSpace();
        }
      };
    Function1<? super FormattableDocument,? extends Iterable<FormattingData>> _prepend_2 = this._formattingDataFactory.prepend(open, _function_3);
    format.operator_add(_prepend_2);
    boolean _isMultiParamInOwnLine = this.isMultiParamInOwnLine(expr, format);
    if (_isMultiParamInOwnLine) {
      EList<XExpression> _arguments = expr.getArguments();
      this.formatFeatureCallParamsMultiline(open, _arguments, format);
    } else {
      EList<XExpression> _arguments_1 = expr.getArguments();
      this.formatFeatureCallParamsWrapIfNeeded(open, _arguments_1, format);
    }
  }
  
  protected void formatFeatureCallTypeParameters(final XAbstractFeatureCall expr, final FormattableDocument format) {
    EList<JvmTypeReference> _typeArguments = expr.getTypeArguments();
    boolean _isEmpty = _typeArguments.isEmpty();
    boolean _not = (!_isEmpty);
    if (_not) {
      ILeafNode _nodeForKeyword = this._nodeModelAccess.nodeForKeyword(expr, "<");
      final Procedure1<FormattingDataInit> _function = new Procedure1<FormattingDataInit>() {
          public void apply(final FormattingDataInit it) {
            it.noSpace();
          }
        };
      Function1<? super FormattableDocument,? extends Iterable<FormattingData>> _append = this._formattingDataFactory.append(_nodeForKeyword, _function);
      format.operator_add(_append);
      EList<JvmTypeReference> _typeArguments_1 = expr.getTypeArguments();
      for (final JvmTypeReference arg : _typeArguments_1) {
        {
          this.format(arg, format);
          ILeafNode _immediatelyFollowingKeyword = this._nodeModelAccess.immediatelyFollowingKeyword(arg, ",");
          final Procedure1<FormattingDataInit> _function_1 = new Procedure1<FormattingDataInit>() {
              public void apply(final FormattingDataInit it) {
                it.noSpace();
              }
            };
          final Procedure1<FormattingDataInit> _function_2 = new Procedure1<FormattingDataInit>() {
              public void apply(final FormattingDataInit it) {
                it.oneSpace();
              }
            };
          Function1<? super FormattableDocument,? extends Iterable<FormattingData>> _surround = this._formattingDataFactory.surround(_immediatelyFollowingKeyword, _function_1, _function_2);
          format.operator_add(_surround);
        }
      }
      ILeafNode _nodeForKeyword_1 = this._nodeModelAccess.nodeForKeyword(expr, ">");
      final Procedure1<FormattingDataInit> _function_1 = new Procedure1<FormattingDataInit>() {
          public void apply(final FormattingDataInit it) {
            it.noSpace();
          }
        };
      Function1<? super FormattableDocument,? extends Iterable<FormattingData>> _surround = this._formattingDataFactory.surround(_nodeForKeyword_1, _function_1);
      format.operator_add(_surround);
    }
  }
  
  protected void _format(final XFeatureCall expr, final FormattableDocument format) {
    final INode declaringType = this._nodeModelAccess.nodeForFeature(expr, org.eclipse.xtext.xbase.XbasePackage.Literals.XFEATURE_CALL__DECLARING_TYPE);
    this.formatStaticQualifier(declaringType, format);
    final Procedure1<FormattingDataInit> _function = new Procedure1<FormattingDataInit>() {
        public void apply(final FormattingDataInit it) {
          it.noSpace();
        }
      };
    Function1<? super FormattableDocument,? extends Iterable<FormattingData>> _append = this._formattingDataFactory.append(declaringType, _function);
    format.operator_add(_append);
    this.formatFeatureCallTypeParameters(expr, format);
    boolean _isExplicitOperationCall = expr.isExplicitOperationCall();
    if (_isExplicitOperationCall) {
      final ILeafNode open = this._nodeModelAccess.nodeForKeyword(expr, "(");
      final Procedure1<FormattingDataInit> _function_1 = new Procedure1<FormattingDataInit>() {
          public void apply(final FormattingDataInit it) {
            it.noSpace();
          }
        };
      Function1<? super FormattableDocument,? extends Iterable<FormattingData>> _prepend = this._formattingDataFactory.prepend(open, _function_1);
      format.operator_add(_prepend);
      boolean _isMultiParamInOwnLine = this.isMultiParamInOwnLine(expr, format);
      if (_isMultiParamInOwnLine) {
        EList<XExpression> _featureCallArguments = expr.getFeatureCallArguments();
        this.formatFeatureCallParamsMultiline(open, _featureCallArguments, format);
      } else {
        EList<XExpression> _featureCallArguments_1 = expr.getFeatureCallArguments();
        this.formatFeatureCallParamsWrapIfNeeded(open, _featureCallArguments_1, format);
      }
    } else {
      EList<XExpression> _featureCallArguments_2 = expr.getFeatureCallArguments();
      for (final XExpression arg : _featureCallArguments_2) {
        this.format(arg, format);
      }
    }
  }
  
  protected boolean _isMultiParamInOwnLine(final XMemberFeatureCall fc, final FormattableDocument doc) {
    final ILeafNode closingBracket = this._nodeModelAccess.nodeForKeyword(fc, ")");
    HiddenLeafs _hiddenLeafsBefore = closingBracket==null?(HiddenLeafs)null:this._hiddenLeafAccess.getHiddenLeafsBefore(closingBracket);
    boolean _notEquals = ObjectExtensions.operator_notEquals(_hiddenLeafsBefore, null);
    if (_notEquals) {
      HiddenLeafs _hiddenLeafsBefore_1 = this._hiddenLeafAccess.getHiddenLeafsBefore(closingBracket);
      int _newLines = _hiddenLeafsBefore_1.getNewLines();
      return (_newLines > 0);
    }
    EList<XExpression> _memberCallArguments = fc.getMemberCallArguments();
    final Iterable<XExpression> params = this.explicitParams(_memberCallArguments);
    boolean _and = false;
    int _size = IterableExtensions.size(params);
    boolean _greaterThan = (_size > 1);
    if (!_greaterThan) {
      _and = false;
    } else {
      boolean _isEachExpressionInOwnLine = this.isEachExpressionInOwnLine(params);
      _and = (_greaterThan && _isEachExpressionInOwnLine);
    }
    return _and;
  }
  
  protected boolean _isMultiParamInOwnLine(final XFeatureCall fc, final FormattableDocument doc) {
    final ILeafNode closingBracket = this._nodeModelAccess.nodeForKeyword(fc, ")");
    HiddenLeafs _hiddenLeafsBefore = closingBracket==null?(HiddenLeafs)null:this._hiddenLeafAccess.getHiddenLeafsBefore(closingBracket);
    boolean _notEquals = ObjectExtensions.operator_notEquals(_hiddenLeafsBefore, null);
    if (_notEquals) {
      HiddenLeafs _hiddenLeafsBefore_1 = this._hiddenLeafAccess.getHiddenLeafsBefore(closingBracket);
      int _newLines = _hiddenLeafsBefore_1.getNewLines();
      return (_newLines > 0);
    }
    EList<XExpression> _featureCallArguments = fc.getFeatureCallArguments();
    final Iterable<XExpression> params = this.explicitParams(_featureCallArguments);
    boolean _and = false;
    int _size = IterableExtensions.size(params);
    boolean _greaterThan = (_size > 1);
    if (!_greaterThan) {
      _and = false;
    } else {
      boolean _isEachExpressionInOwnLine = this.isEachExpressionInOwnLine(params);
      _and = (_greaterThan && _isEachExpressionInOwnLine);
    }
    return _and;
  }
  
  protected boolean _isMultiParamInOwnLine(final XConstructorCall fc, final FormattableDocument doc) {
    final ILeafNode closingBracket = this._nodeModelAccess.nodeForKeyword(fc, ")");
    HiddenLeafs _hiddenLeafsBefore = closingBracket==null?(HiddenLeafs)null:this._hiddenLeafAccess.getHiddenLeafsBefore(closingBracket);
    boolean _notEquals = ObjectExtensions.operator_notEquals(_hiddenLeafsBefore, null);
    if (_notEquals) {
      HiddenLeafs _hiddenLeafsBefore_1 = this._hiddenLeafAccess.getHiddenLeafsBefore(closingBracket);
      int _newLines = _hiddenLeafsBefore_1.getNewLines();
      return (_newLines > 0);
    }
    EList<XExpression> _arguments = fc.getArguments();
    final Iterable<XExpression> params = this.explicitParams(_arguments);
    boolean _and = false;
    int _size = IterableExtensions.size(params);
    boolean _greaterThan = (_size > 1);
    if (!_greaterThan) {
      _and = false;
    } else {
      boolean _isEachExpressionInOwnLine = this.isEachExpressionInOwnLine(params);
      _and = (_greaterThan && _isEachExpressionInOwnLine);
    }
    return _and;
  }
  
  protected void _format(final XMemberFeatureCall expr, final FormattableDocument format) {
    EObject top = expr;
    ArrayList<XMemberFeatureCall> calls = CollectionLiterals.<XMemberFeatureCall>newArrayList();
    boolean _while = (top instanceof XMemberFeatureCall);
    while (_while) {
      {
        calls.add(((XMemberFeatureCall) top));
        XExpression _memberCallTarget = ((XMemberFeatureCall) top).getMemberCallTarget();
        top = _memberCallTarget;
      }
      _while = (top instanceof XMemberFeatureCall);
    }
    this.format(top, format);
    boolean indented = false;
    List<XMemberFeatureCall> _reverse = ListExtensions.<XMemberFeatureCall>reverse(calls);
    for (final XMemberFeatureCall call : _reverse) {
      {
        this.formatFeatureCallTypeParameters(call, format);
        final INode featureNode = this._nodeModelAccess.nodeForFeature(call, org.eclipse.xtext.xbase.XbasePackage.Literals.XABSTRACT_FEATURE_CALL__FEATURE);
        XExpression _memberCallTarget = call.getMemberCallTarget();
        final INode targetNode = this._nodeModelAccess.nodeForEObject(_memberCallTarget);
        boolean _notEquals = ObjectExtensions.operator_notEquals(targetNode, null);
        if (_notEquals) {
          int _offset = targetNode.getOffset();
          int _length = targetNode.getLength();
          final int callOffset = (_offset + _length);
          String _xifexpression = null;
          boolean _isNullSafe = call.isNullSafe();
          if (_isNullSafe) {
            _xifexpression = "?.";
          } else {
            _xifexpression = ".";
          }
          final ILeafNode op = this._nodeModelAccess.nodeForKeyword(call, _xifexpression);
          final Procedure1<FormattingDataInit> _function = new Procedure1<FormattingDataInit>() {
              public void apply(final FormattingDataInit it) {
                it.noSpace();
              }
            };
          Function1<? super FormattableDocument,? extends Iterable<FormattingData>> _prepend = this._formattingDataFactory.prepend(op, _function);
          format.operator_add(_prepend);
          boolean _isExplicitOperationCall = call.isExplicitOperationCall();
          if (_isExplicitOperationCall) {
            final INode callNode = this._nodeModelAccess.nodeForEObject(call);
            int _offset_1 = callNode.getOffset();
            int _length_1 = callNode.getLength();
            int _plus = (_offset_1 + _length_1);
            final int callLength = (_plus - callOffset);
            final ILeafNode open = this._nodeModelAccess.nodeForKeyword(call, "(");
            final Procedure1<FormattingDataInit> _function_1 = new Procedure1<FormattingDataInit>() {
                public void apply(final FormattingDataInit it) {
                  it.noSpace();
                }
              };
            Function1<? super FormattableDocument,? extends Iterable<FormattingData>> _append = this._formattingDataFactory.append(featureNode, _function_1);
            format.operator_add(_append);
            final int lineLength = format.lineLengthBefore(callOffset);
            boolean _isMultiParamInOwnLine = this.isMultiParamInOwnLine(call, format);
            if (_isMultiParamInOwnLine) {
              int _length_2 = featureNode.getLength();
              int _plus_1 = (lineLength + _length_2);
              IConfigurationValues _cfg = format.getCfg();
              Integer _get = _cfg.<Integer>get(this._xbaseFormatterConfigKeys.maxLineWidth);
              boolean _lessThan = (_plus_1 < (_get).intValue());
              if (_lessThan) {
                final Procedure1<FormattingDataInit> _function_2 = new Procedure1<FormattingDataInit>() {
                    public void apply(final FormattingDataInit it) {
                      it.noSpace();
                    }
                  };
                Function1<? super FormattableDocument,? extends Iterable<FormattingData>> _append_1 = this._formattingDataFactory.append(op, _function_2);
                format.operator_add(_append_1);
              } else {
                final Procedure1<FormattingDataInit> _function_3 = new Procedure1<FormattingDataInit>() {
                    public void apply(final FormattingDataInit it) {
                      it.newLine();
                    }
                  };
                Function1<? super FormattableDocument,? extends Iterable<FormattingData>> _append_2 = this._formattingDataFactory.append(op, _function_3);
                format.operator_add(_append_2);
              }
              EList<XExpression> _memberCallArguments = call.getMemberCallArguments();
              this.formatFeatureCallParamsMultiline(open, _memberCallArguments, format);
            } else {
              boolean _or = false;
              int _length_3 = featureNode.getLength();
              int _multiply = (_length_3 * 2);
              int _plus_2 = (lineLength + _multiply);
              IConfigurationValues _cfg_1 = format.getCfg();
              Integer _get_1 = _cfg_1.<Integer>get(this._xbaseFormatterConfigKeys.maxLineWidth);
              boolean _lessThan_1 = (_plus_2 < (_get_1).intValue());
              if (_lessThan_1) {
                _or = true;
              } else {
                final Procedure1<FormattableDocument> _function_4 = new Procedure1<FormattableDocument>() {
                    public void apply(final FormattableDocument f) {
                      final Procedure1<FormattingDataInit> _function = new Procedure1<FormattingDataInit>() {
                          public void apply(final FormattingDataInit it) {
                            it.noSpace();
                          }
                        };
                      Function1<? super FormattableDocument,? extends Iterable<FormattingData>> _append = XbaseFormatter2.this._formattingDataFactory.append(op, _function);
                      f.operator_add(_append);
                      EList<XExpression> _memberCallArguments = call.getMemberCallArguments();
                      XbaseFormatter2.this.formatFeatureCallParamsWrapIfNeeded(open, _memberCallArguments, f);
                    }
                  };
                boolean _fitsIntoLine = format.fitsIntoLine(callOffset, callLength, _function_4);
                _or = (_lessThan_1 || _fitsIntoLine);
              }
              if (_or) {
                final Procedure1<FormattingDataInit> _function_5 = new Procedure1<FormattingDataInit>() {
                    public void apply(final FormattingDataInit it) {
                      it.noSpace();
                    }
                  };
                Function1<? super FormattableDocument,? extends Iterable<FormattingData>> _append_3 = this._formattingDataFactory.append(op, _function_5);
                format.operator_add(_append_3);
              } else {
                final Procedure1<FormattingDataInit> _function_6 = new Procedure1<FormattingDataInit>() {
                    public void apply(final FormattingDataInit it) {
                      it.newLine();
                    }
                  };
                Function1<? super FormattableDocument,? extends Iterable<FormattingData>> _append_4 = this._formattingDataFactory.append(op, _function_6);
                format.operator_add(_append_4);
                boolean _not = (!indented);
                if (_not) {
                  indented = true;
                  final Procedure1<FormattingDataInit> _function_7 = new Procedure1<FormattingDataInit>() {
                      public void apply(final FormattingDataInit it) {
                        it.increaseIndentation();
                      }
                    };
                  Function1<? super FormattableDocument,? extends Iterable<FormattingData>> _append_5 = this._formattingDataFactory.append(op, _function_7);
                  format.operator_add(_append_5);
                }
              }
              EList<XExpression> _memberCallArguments_1 = call.getMemberCallArguments();
              this.formatFeatureCallParamsWrapIfNeeded(open, _memberCallArguments_1, format);
            }
          } else {
            int _lineLengthBefore = format.lineLengthBefore(callOffset);
            int _length_4 = featureNode.getLength();
            final int shortLenght = (_lineLengthBefore + _length_4);
            IConfigurationValues _cfg_2 = format.getCfg();
            Integer _get_2 = _cfg_2.<Integer>get(this._xbaseFormatterConfigKeys.maxLineWidth);
            boolean _lessThan_2 = (shortLenght < (_get_2).intValue());
            if (_lessThan_2) {
              final Procedure1<FormattingDataInit> _function_8 = new Procedure1<FormattingDataInit>() {
                  public void apply(final FormattingDataInit it) {
                    it.noSpace();
                  }
                };
              Function1<? super FormattableDocument,? extends Iterable<FormattingData>> _append_6 = this._formattingDataFactory.append(op, _function_8);
              format.operator_add(_append_6);
            } else {
              final Procedure1<FormattingDataInit> _function_9 = new Procedure1<FormattingDataInit>() {
                  public void apply(final FormattingDataInit it) {
                    it.newLine();
                  }
                };
              Function1<? super FormattableDocument,? extends Iterable<FormattingData>> _append_7 = this._formattingDataFactory.append(op, _function_9);
              format.operator_add(_append_7);
              boolean _not_1 = (!indented);
              if (_not_1) {
                indented = true;
                final Procedure1<FormattingDataInit> _function_10 = new Procedure1<FormattingDataInit>() {
                    public void apply(final FormattingDataInit it) {
                      it.increaseIndentation();
                    }
                  };
                Function1<? super FormattableDocument,? extends Iterable<FormattingData>> _append_8 = this._formattingDataFactory.append(op, _function_10);
                format.operator_add(_append_8);
              }
            }
            EList<XExpression> _memberCallArguments_2 = call.getMemberCallArguments();
            boolean _isEmpty = _memberCallArguments_2.isEmpty();
            boolean _not_2 = (!_isEmpty);
            if (_not_2) {
              EList<XExpression> _memberCallArguments_3 = call.getMemberCallArguments();
              final XClosure builder = this.builder(_memberCallArguments_3);
              INode _nodeForEObject = this._nodeModelAccess.nodeForEObject(builder);
              final Procedure1<FormattingDataInit> _function_11 = new Procedure1<FormattingDataInit>() {
                  public void apply(final FormattingDataInit it) {
                    boolean _isMultilineLambda = XbaseFormatter2.this.isMultilineLambda(builder);
                    if (_isMultilineLambda) {
                      it.oneSpace();
                    } else {
                      it.noSpace();
                    }
                  }
                };
              Function1<? super FormattableDocument,? extends Iterable<FormattingData>> _prepend_1 = this._formattingDataFactory.prepend(_nodeForEObject, _function_11);
              format.operator_add(_prepend_1);
              this.format(builder, format);
            }
          }
        }
      }
    }
    if (indented) {
      XMemberFeatureCall _last = IterableExtensions.<XMemberFeatureCall>last(calls);
      INode _nodeForEObject = this._nodeModelAccess.nodeForEObject(_last);
      final Procedure1<FormattingDataInit> _function = new Procedure1<FormattingDataInit>() {
          public void apply(final FormattingDataInit it) {
            it.decreaseIndentation();
          }
        };
      Function1<? super FormattableDocument,? extends Iterable<FormattingData>> _append = this._formattingDataFactory.append(_nodeForEObject, _function);
      format.operator_add(_append);
    }
  }
  
  protected AbstractRule binaryOperationPrecedence(final EObject op) {
    final INode node = this._nodeModelAccess.nodeForFeature(op, org.eclipse.xtext.xbase.XbasePackage.Literals.XABSTRACT_FEATURE_CALL__FEATURE);
    boolean _and = false;
    boolean _notEquals = ObjectExtensions.operator_notEquals(node, null);
    if (!_notEquals) {
      _and = false;
    } else {
      EObject _grammarElement = node.getGrammarElement();
      _and = (_notEquals && (_grammarElement instanceof CrossReference));
    }
    if (_and) {
      EObject _grammarElement_1 = node.getGrammarElement();
      final AbstractElement terminal = ((CrossReference) _grammarElement_1).getTerminal();
      if ((terminal instanceof RuleCall)) {
        return ((RuleCall) terminal).getRule();
      }
    }
    return null;
  }
  
  protected boolean isMultiline(final XExpression expression, final FormattableDocument doc) {
    final INode node = this._nodeModelAccess.nodeForEObject(expression);
    boolean _and = false;
    boolean _notEquals = ObjectExtensions.operator_notEquals(node, null);
    if (!_notEquals) {
      _and = false;
    } else {
      int _startLine = node.getStartLine();
      int _endLine = node.getEndLine();
      boolean _notEquals_1 = (_startLine != _endLine);
      _and = (_notEquals && _notEquals_1);
    }
    return _and;
  }
  
  protected void _format(final XBinaryOperation expr, final FormattableDocument format) {
    AbstractRule precendece = this.binaryOperationPrecedence(expr);
    EObject top = expr;
    ArrayList<XBinaryOperation> calls = CollectionLiterals.<XBinaryOperation>newArrayList();
    AbstractRule _binaryOperationPrecedence = this.binaryOperationPrecedence(top);
    boolean _equals = ObjectExtensions.operator_equals(_binaryOperationPrecedence, precendece);
    boolean _while = _equals;
    while (_while) {
      {
        calls.add(((XBinaryOperation) top));
        XExpression _leftOperand = ((XBinaryOperation) top).getLeftOperand();
        top = _leftOperand;
      }
      AbstractRule _binaryOperationPrecedence_1 = this.binaryOperationPrecedence(top);
      boolean _equals_1 = ObjectExtensions.operator_equals(_binaryOperationPrecedence_1, precendece);
      _while = _equals_1;
    }
    this.format(top, format);
    boolean indented = false;
    List<XBinaryOperation> _reverse = ListExtensions.<XBinaryOperation>reverse(calls);
    for (final XBinaryOperation call : _reverse) {
      {
        final INode op = this._nodeModelAccess.nodeForFeature(call, org.eclipse.xtext.xbase.XbasePackage.Literals.XABSTRACT_FEATURE_CALL__FEATURE);
        final Procedure1<FormattingDataInit> _function = new Procedure1<FormattingDataInit>() {
            public void apply(final FormattingDataInit it) {
              it.oneSpace();
            }
          };
        Function1<? super FormattableDocument,? extends Iterable<FormattingData>> _prepend = this._formattingDataFactory.prepend(op, _function);
        format.operator_add(_prepend);
        boolean _or = false;
        XExpression _rightOperand = call.getRightOperand();
        boolean _isMultiline = this.isMultiline(_rightOperand, format);
        if (_isMultiline) {
          _or = true;
        } else {
          XExpression _rightOperand_1 = call.getRightOperand();
          boolean _fitsIntoLine = this.fitsIntoLine(format, _rightOperand_1);
          _or = (_isMultiline || _fitsIntoLine);
        }
        if (_or) {
          final Procedure1<FormattingDataInit> _function_1 = new Procedure1<FormattingDataInit>() {
              public void apply(final FormattingDataInit it) {
                it.oneSpace();
              }
            };
          Function1<? super FormattableDocument,? extends Iterable<FormattingData>> _append = this._formattingDataFactory.append(op, _function_1);
          format.operator_add(_append);
        } else {
          final Procedure1<FormattingDataInit> _function_2 = new Procedure1<FormattingDataInit>() {
              public void apply(final FormattingDataInit it) {
                it.newLine();
              }
            };
          Function1<? super FormattableDocument,? extends Iterable<FormattingData>> _append_1 = this._formattingDataFactory.append(op, _function_2);
          format.operator_add(_append_1);
          boolean _not = (!indented);
          if (_not) {
            indented = true;
            final Procedure1<FormattingDataInit> _function_3 = new Procedure1<FormattingDataInit>() {
                public void apply(final FormattingDataInit it) {
                  it.increaseIndentation();
                }
              };
            Function1<? super FormattableDocument,? extends Iterable<FormattingData>> _append_2 = this._formattingDataFactory.append(op, _function_3);
            format.operator_add(_append_2);
          }
        }
        XExpression _rightOperand_2 = call.getRightOperand();
        this.format(_rightOperand_2, format);
      }
    }
    if (indented) {
      XBinaryOperation _last = IterableExtensions.<XBinaryOperation>last(calls);
      INode _nodeForEObject = this._nodeModelAccess.nodeForEObject(_last);
      final Procedure1<FormattingDataInit> _function = new Procedure1<FormattingDataInit>() {
          public void apply(final FormattingDataInit it) {
            it.decreaseIndentation();
          }
        };
      Function1<? super FormattableDocument,? extends Iterable<FormattingData>> _append = this._formattingDataFactory.append(_nodeForEObject, _function);
      format.operator_add(_append);
    }
  }
  
  protected void _format(final XIfExpression expr, final FormattableDocument format) {
    EObject _eContainer = expr.eContainer();
    if ((_eContainer instanceof XVariableDeclaration)) {
      ILeafNode _nodeForKeyword = this._nodeModelAccess.nodeForKeyword(expr, "if");
      final Procedure1<FormattingDataInit> _function = new Procedure1<FormattingDataInit>() {
          public void apply(final FormattingDataInit it) {
            it.increaseIndentation();
          }
        };
      Function1<? super FormattableDocument,? extends Iterable<FormattingData>> _append = this._formattingDataFactory.append(_nodeForKeyword, _function);
      format.operator_add(_append);
      INode _nodeForEObject = this._nodeModelAccess.nodeForEObject(expr);
      final Procedure1<FormattingDataInit> _function_1 = new Procedure1<FormattingDataInit>() {
          public void apply(final FormattingDataInit it) {
            it.decreaseIndentation();
          }
        };
      Function1<? super FormattableDocument,? extends Iterable<FormattingData>> _append_1 = this._formattingDataFactory.append(_nodeForEObject, _function_1);
      format.operator_add(_append_1);
    }
    XExpression _then = expr.getThen();
    final INode thennode = this._nodeModelAccess.nodeForEObject(_then);
    XExpression _else = expr.getElse();
    final INode elsenode = _else==null?(INode)null:this._nodeModelAccess.nodeForEObject(_else);
    boolean _or = false;
    boolean _or_1 = false;
    String _text = thennode==null?(String)null:thennode.getText();
    String _trim = _text==null?(String)null:_text.trim();
    boolean _contains = _trim==null?false:_trim.contains("\n");
    if (_contains) {
      _or_1 = true;
    } else {
      HiddenLeafs _hiddenLeafsBefore = thennode==null?(HiddenLeafs)null:this._hiddenLeafAccess.getHiddenLeafsBefore(thennode);
      int _newLines = _hiddenLeafsBefore==null?0:_hiddenLeafsBefore.getNewLines();
      boolean _greaterThan = (_newLines > 0);
      _or_1 = (_contains || _greaterThan);
    }
    if (_or_1) {
      _or = true;
    } else {
      String _text_1 = elsenode==null?(String)null:elsenode.getText();
      String _trim_1 = _text_1==null?(String)null:_text_1.trim();
      boolean _contains_1 = _trim_1==null?false:_trim_1.contains("\n");
      _or = (_or_1 || _contains_1);
    }
    final boolean multiline = _or;
    INode _nodeForFeature = this._nodeModelAccess.nodeForFeature(expr, org.eclipse.xtext.xbase.XbasePackage.Literals.XIF_EXPRESSION__IF);
    final Procedure1<FormattingDataInit> _function_2 = new Procedure1<FormattingDataInit>() {
        public void apply(final FormattingDataInit it) {
          it.noSpace();
        }
      };
    Function1<? super FormattableDocument,? extends Iterable<FormattingData>> _surround = this._formattingDataFactory.surround(_nodeForFeature, _function_2);
    format.operator_add(_surround);
    boolean _or_2 = false;
    XExpression _then_1 = expr.getThen();
    if ((_then_1 instanceof XBlockExpression)) {
      _or_2 = true;
    } else {
      _or_2 = ((_then_1 instanceof XBlockExpression) || multiline);
    }
    if (_or_2) {
      ILeafNode _nodeForKeyword_1 = this._nodeModelAccess.nodeForKeyword(expr, "if");
      final Procedure1<FormattingDataInit> _function_3 = new Procedure1<FormattingDataInit>() {
          public void apply(final FormattingDataInit it) {
            it.cfg(XbaseFormatter2.this._xbaseFormatterConfigKeys.whitespaceBetweenKeywordAndParenthesisML);
          }
        };
      Function1<? super FormattableDocument,? extends Iterable<FormattingData>> _append_2 = this._formattingDataFactory.append(_nodeForKeyword_1, _function_3);
      format.operator_add(_append_2);
    } else {
      ILeafNode _nodeForKeyword_2 = this._nodeModelAccess.nodeForKeyword(expr, "if");
      final Procedure1<FormattingDataInit> _function_4 = new Procedure1<FormattingDataInit>() {
          public void apply(final FormattingDataInit it) {
            it.cfg(XbaseFormatter2.this._xbaseFormatterConfigKeys.whitespaceBetweenKeywordAndParenthesisSL);
          }
        };
      Function1<? super FormattableDocument,? extends Iterable<FormattingData>> _append_3 = this._formattingDataFactory.append(_nodeForKeyword_2, _function_4);
      format.operator_add(_append_3);
    }
    XExpression _then_2 = expr.getThen();
    if ((_then_2 instanceof XBlockExpression)) {
      final Procedure1<FormattingDataInit> _function_5 = new Procedure1<FormattingDataInit>() {
          public void apply(final FormattingDataInit it) {
            it.cfg(XbaseFormatter2.this._xbaseFormatterConfigKeys.bracesInNewLine);
          }
        };
      Function1<? super FormattableDocument,? extends Iterable<FormattingData>> _prepend = this._formattingDataFactory.prepend(thennode, _function_5);
      format.operator_add(_prepend);
      XExpression _else_1 = expr.getElse();
      boolean _notEquals = ObjectExtensions.operator_notEquals(_else_1, null);
      if (_notEquals) {
        final Procedure1<FormattingDataInit> _function_6 = new Procedure1<FormattingDataInit>() {
            public void apply(final FormattingDataInit it) {
              it.cfg(XbaseFormatter2.this._xbaseFormatterConfigKeys.bracesInNewLine);
            }
          };
        Function1<? super FormattableDocument,? extends Iterable<FormattingData>> _append_4 = this._formattingDataFactory.append(thennode, _function_6);
        format.operator_add(_append_4);
      }
    } else {
      boolean _not = (!multiline);
      if (_not) {
        final Procedure1<FormattingDataInit> _function_7 = new Procedure1<FormattingDataInit>() {
            public void apply(final FormattingDataInit it) {
              it.oneSpace();
            }
          };
        Function1<? super FormattableDocument,? extends Iterable<FormattingData>> _prepend_1 = this._formattingDataFactory.prepend(thennode, _function_7);
        format.operator_add(_prepend_1);
        XExpression _else_2 = expr.getElse();
        boolean _notEquals_1 = ObjectExtensions.operator_notEquals(_else_2, null);
        if (_notEquals_1) {
          final Procedure1<FormattingDataInit> _function_8 = new Procedure1<FormattingDataInit>() {
              public void apply(final FormattingDataInit it) {
                it.oneSpace();
              }
            };
          Function1<? super FormattableDocument,? extends Iterable<FormattingData>> _append_5 = this._formattingDataFactory.append(thennode, _function_8);
          format.operator_add(_append_5);
        }
      } else {
        final Procedure1<FormattingDataInit> _function_9 = new Procedure1<FormattingDataInit>() {
            public void apply(final FormattingDataInit it) {
              it.newLine();
              it.increaseIndentation();
            }
          };
        Function1<? super FormattableDocument,? extends Iterable<FormattingData>> _prepend_2 = this._formattingDataFactory.prepend(thennode, _function_9);
        format.operator_add(_prepend_2);
        XExpression _else_3 = expr.getElse();
        boolean _notEquals_2 = ObjectExtensions.operator_notEquals(_else_3, null);
        if (_notEquals_2) {
          final Procedure1<FormattingDataInit> _function_10 = new Procedure1<FormattingDataInit>() {
              public void apply(final FormattingDataInit it) {
                it.newLine();
                it.decreaseIndentation();
              }
            };
          Function1<? super FormattableDocument,? extends Iterable<FormattingData>> _append_6 = this._formattingDataFactory.append(thennode, _function_10);
          format.operator_add(_append_6);
        } else {
          final Procedure1<FormattingDataInit> _function_11 = new Procedure1<FormattingDataInit>() {
              public void apply(final FormattingDataInit it) {
                it.decreaseIndentation();
              }
            };
          Function1<? super FormattableDocument,? extends Iterable<FormattingData>> _append_7 = this._formattingDataFactory.append(thennode, _function_11);
          format.operator_add(_append_7);
        }
      }
    }
    XExpression _else_4 = expr.getElse();
    if ((_else_4 instanceof XBlockExpression)) {
      final Procedure1<FormattingDataInit> _function_12 = new Procedure1<FormattingDataInit>() {
          public void apply(final FormattingDataInit it) {
            it.cfg(XbaseFormatter2.this._xbaseFormatterConfigKeys.bracesInNewLine);
          }
        };
      Function1<? super FormattableDocument,? extends Iterable<FormattingData>> _prepend_3 = this._formattingDataFactory.prepend(elsenode, _function_12);
      format.operator_add(_prepend_3);
    } else {
      boolean _or_3 = false;
      XExpression _else_5 = expr.getElse();
      if ((_else_5 instanceof XIfExpression)) {
        _or_3 = true;
      } else {
        boolean _not_1 = (!multiline);
        _or_3 = ((_else_5 instanceof XIfExpression) || _not_1);
      }
      if (_or_3) {
        final Procedure1<FormattingDataInit> _function_13 = new Procedure1<FormattingDataInit>() {
            public void apply(final FormattingDataInit it) {
              it.oneSpace();
            }
          };
        Function1<? super FormattableDocument,? extends Iterable<FormattingData>> _prepend_4 = this._formattingDataFactory.prepend(elsenode, _function_13);
        format.operator_add(_prepend_4);
      } else {
        final Procedure1<FormattingDataInit> _function_14 = new Procedure1<FormattingDataInit>() {
            public void apply(final FormattingDataInit it) {
              it.newLine();
              it.increaseIndentation();
            }
          };
        Function1<? super FormattableDocument,? extends Iterable<FormattingData>> _prepend_5 = this._formattingDataFactory.prepend(elsenode, _function_14);
        format.operator_add(_prepend_5);
        final Procedure1<FormattingDataInit> _function_15 = new Procedure1<FormattingDataInit>() {
            public void apply(final FormattingDataInit it) {
              it.decreaseIndentation();
            }
          };
        Function1<? super FormattableDocument,? extends Iterable<FormattingData>> _append_8 = this._formattingDataFactory.append(elsenode, _function_15);
        format.operator_add(_append_8);
      }
    }
    XExpression _if = expr.getIf();
    this.format(_if, format);
    XExpression _then_3 = expr.getThen();
    this.format(_then_3, format);
    XExpression _else_6 = expr.getElse();
    boolean _notEquals_3 = ObjectExtensions.operator_notEquals(_else_6, null);
    if (_notEquals_3) {
      XExpression _else_7 = expr.getElse();
      this.format(_else_7, format);
    }
  }
  
  protected void _format(final XForLoopExpression expr, final FormattableDocument format) {
    ILeafNode _nodeForKeyword = this._nodeModelAccess.nodeForKeyword(expr, "for");
    final Procedure1<ILeafNode> _function = new Procedure1<ILeafNode>() {
        public void apply(final ILeafNode it) {
          final Procedure1<FormattingDataInit> _function = new Procedure1<FormattingDataInit>() {
              public void apply(final FormattingDataInit it) {
                it.oneSpace();
              }
            };
          Function1<? super FormattableDocument,? extends Iterable<FormattingData>> _append = XbaseFormatter2.this._formattingDataFactory.append(it, _function);
          format.operator_add(_append);
        }
      };
    ObjectExtensions.<ILeafNode>operator_doubleArrow(_nodeForKeyword, _function);
    JvmFormalParameter _declaredParam = expr.getDeclaredParam();
    INode _nodeForEObject = this._nodeModelAccess.nodeForEObject(_declaredParam);
    final Procedure1<INode> _function_1 = new Procedure1<INode>() {
        public void apply(final INode it) {
          final Procedure1<FormattingDataInit> _function = new Procedure1<FormattingDataInit>() {
              public void apply(final FormattingDataInit it) {
                it.noSpace();
              }
            };
          Function1<? super FormattableDocument,? extends Iterable<FormattingData>> _prepend = XbaseFormatter2.this._formattingDataFactory.prepend(it, _function);
          format.operator_add(_prepend);
          final Procedure1<FormattingDataInit> _function_1 = new Procedure1<FormattingDataInit>() {
              public void apply(final FormattingDataInit it) {
                it.oneSpace();
              }
            };
          Function1<? super FormattableDocument,? extends Iterable<FormattingData>> _append = XbaseFormatter2.this._formattingDataFactory.append(it, _function_1);
          format.operator_add(_append);
        }
      };
    ObjectExtensions.<INode>operator_doubleArrow(_nodeForEObject, _function_1);
    XExpression _forExpression = expr.getForExpression();
    INode _nodeForEObject_1 = this._nodeModelAccess.nodeForEObject(_forExpression);
    final Procedure1<INode> _function_2 = new Procedure1<INode>() {
        public void apply(final INode it) {
          final Procedure1<FormattingDataInit> _function = new Procedure1<FormattingDataInit>() {
              public void apply(final FormattingDataInit it) {
                it.oneSpace();
              }
            };
          Function1<? super FormattableDocument,? extends Iterable<FormattingData>> _prepend = XbaseFormatter2.this._formattingDataFactory.prepend(it, _function);
          format.operator_add(_prepend);
          final Procedure1<FormattingDataInit> _function_1 = new Procedure1<FormattingDataInit>() {
              public void apply(final FormattingDataInit it) {
                it.noSpace();
              }
            };
          Function1<? super FormattableDocument,? extends Iterable<FormattingData>> _append = XbaseFormatter2.this._formattingDataFactory.append(it, _function_1);
          format.operator_add(_append);
        }
      };
    ObjectExtensions.<INode>operator_doubleArrow(_nodeForEObject_1, _function_2);
    XExpression _eachExpression = expr.getEachExpression();
    final INode each = this._nodeModelAccess.nodeForEObject(_eachExpression);
    XExpression _eachExpression_1 = expr.getEachExpression();
    if ((_eachExpression_1 instanceof XBlockExpression)) {
      final Procedure1<FormattingDataInit> _function_3 = new Procedure1<FormattingDataInit>() {
          public void apply(final FormattingDataInit it) {
            it.cfg(XbaseFormatter2.this._xbaseFormatterConfigKeys.bracesInNewLine);
          }
        };
      Function1<? super FormattableDocument,? extends Iterable<FormattingData>> _prepend = this._formattingDataFactory.prepend(each, _function_3);
      format.operator_add(_prepend);
    } else {
      final Procedure1<FormattingDataInit> _function_4 = new Procedure1<FormattingDataInit>() {
          public void apply(final FormattingDataInit it) {
            it.newLine();
            it.increaseIndentation();
          }
        };
      Function1<? super FormattableDocument,? extends Iterable<FormattingData>> _prepend_1 = this._formattingDataFactory.prepend(each, _function_4);
      format.operator_add(_prepend_1);
      final Procedure1<FormattingDataInit> _function_5 = new Procedure1<FormattingDataInit>() {
          public void apply(final FormattingDataInit it) {
            it.decreaseIndentation();
          }
        };
      Function1<? super FormattableDocument,? extends Iterable<FormattingData>> _append = this._formattingDataFactory.append(each, _function_5);
      format.operator_add(_append);
    }
    XExpression _forExpression_1 = expr.getForExpression();
    this.format(_forExpression_1, format);
    XExpression _eachExpression_2 = expr.getEachExpression();
    this.format(_eachExpression_2, format);
  }
  
  protected void _format(final XWhileExpression expr, final FormattableDocument format) {
    ILeafNode _nodeForKeyword = this._nodeModelAccess.nodeForKeyword(expr, "while");
    final Procedure1<FormattingDataInit> _function = new Procedure1<FormattingDataInit>() {
        public void apply(final FormattingDataInit it) {
          it.cfg(XbaseFormatter2.this._xbaseFormatterConfigKeys.whitespaceBetweenKeywordAndParenthesisML);
        }
      };
    Function1<? super FormattableDocument,? extends Iterable<FormattingData>> _append = this._formattingDataFactory.append(_nodeForKeyword, _function);
    format.operator_add(_append);
    XExpression _predicate = expr.getPredicate();
    INode _nodeForEObject = this._nodeModelAccess.nodeForEObject(_predicate);
    final Procedure1<FormattingDataInit> _function_1 = new Procedure1<FormattingDataInit>() {
        public void apply(final FormattingDataInit it) {
          it.noSpace();
        }
      };
    final Procedure1<FormattingDataInit> _function_2 = new Procedure1<FormattingDataInit>() {
        public void apply(final FormattingDataInit it) {
          it.noSpace();
        }
      };
    Function1<? super FormattableDocument,? extends Iterable<FormattingData>> _surround = this._formattingDataFactory.surround(_nodeForEObject, _function_1, _function_2);
    format.operator_add(_surround);
    XExpression _body = expr.getBody();
    final INode body = this._nodeModelAccess.nodeForEObject(_body);
    XExpression _body_1 = expr.getBody();
    if ((_body_1 instanceof XBlockExpression)) {
      final Procedure1<FormattingDataInit> _function_3 = new Procedure1<FormattingDataInit>() {
          public void apply(final FormattingDataInit it) {
            it.cfg(XbaseFormatter2.this._xbaseFormatterConfigKeys.bracesInNewLine);
          }
        };
      Function1<? super FormattableDocument,? extends Iterable<FormattingData>> _prepend = this._formattingDataFactory.prepend(body, _function_3);
      format.operator_add(_prepend);
    } else {
      final Procedure1<FormattingDataInit> _function_4 = new Procedure1<FormattingDataInit>() {
          public void apply(final FormattingDataInit it) {
            it.newLine();
            it.increaseIndentation();
          }
        };
      Function1<? super FormattableDocument,? extends Iterable<FormattingData>> _prepend_1 = this._formattingDataFactory.prepend(body, _function_4);
      format.operator_add(_prepend_1);
      final Procedure1<FormattingDataInit> _function_5 = new Procedure1<FormattingDataInit>() {
          public void apply(final FormattingDataInit it) {
            it.decreaseIndentation();
          }
        };
      Function1<? super FormattableDocument,? extends Iterable<FormattingData>> _append_1 = this._formattingDataFactory.append(body, _function_5);
      format.operator_add(_append_1);
    }
    XExpression _predicate_1 = expr.getPredicate();
    this.format(_predicate_1, format);
    XExpression _body_2 = expr.getBody();
    this.format(_body_2, format);
  }
  
  protected void _format(final XDoWhileExpression expr, final FormattableDocument format) {
    ILeafNode _nodeForKeyword = this._nodeModelAccess.nodeForKeyword(expr, "while");
    final Procedure1<FormattingDataInit> _function = new Procedure1<FormattingDataInit>() {
        public void apply(final FormattingDataInit it) {
          it.cfg(XbaseFormatter2.this._xbaseFormatterConfigKeys.whitespaceBetweenKeywordAndParenthesisML);
        }
      };
    Function1<? super FormattableDocument,? extends Iterable<FormattingData>> _append = this._formattingDataFactory.append(_nodeForKeyword, _function);
    format.operator_add(_append);
    XExpression _predicate = expr.getPredicate();
    INode _nodeForEObject = this._nodeModelAccess.nodeForEObject(_predicate);
    final Procedure1<FormattingDataInit> _function_1 = new Procedure1<FormattingDataInit>() {
        public void apply(final FormattingDataInit it) {
          it.noSpace();
        }
      };
    final Procedure1<FormattingDataInit> _function_2 = new Procedure1<FormattingDataInit>() {
        public void apply(final FormattingDataInit it) {
          it.noSpace();
        }
      };
    Function1<? super FormattableDocument,? extends Iterable<FormattingData>> _surround = this._formattingDataFactory.surround(_nodeForEObject, _function_1, _function_2);
    format.operator_add(_surround);
    XExpression _body = expr.getBody();
    final INode body = this._nodeModelAccess.nodeForEObject(_body);
    XExpression _body_1 = expr.getBody();
    if ((_body_1 instanceof XBlockExpression)) {
      final Procedure1<FormattingDataInit> _function_3 = new Procedure1<FormattingDataInit>() {
          public void apply(final FormattingDataInit it) {
            it.cfg(XbaseFormatter2.this._xbaseFormatterConfigKeys.bracesInNewLine);
          }
        };
      Function1<? super FormattableDocument,? extends Iterable<FormattingData>> _prepend = this._formattingDataFactory.prepend(body, _function_3);
      format.operator_add(_prepend);
      final Procedure1<FormattingDataInit> _function_4 = new Procedure1<FormattingDataInit>() {
          public void apply(final FormattingDataInit it) {
            it.cfg(XbaseFormatter2.this._xbaseFormatterConfigKeys.bracesInNewLine);
          }
        };
      Function1<? super FormattableDocument,? extends Iterable<FormattingData>> _append_1 = this._formattingDataFactory.append(body, _function_4);
      format.operator_add(_append_1);
    } else {
      final Procedure1<FormattingDataInit> _function_5 = new Procedure1<FormattingDataInit>() {
          public void apply(final FormattingDataInit it) {
            it.newLine();
            it.increaseIndentation();
          }
        };
      Function1<? super FormattableDocument,? extends Iterable<FormattingData>> _prepend_1 = this._formattingDataFactory.prepend(body, _function_5);
      format.operator_add(_prepend_1);
      final Procedure1<FormattingDataInit> _function_6 = new Procedure1<FormattingDataInit>() {
          public void apply(final FormattingDataInit it) {
            it.newLine();
            it.decreaseIndentation();
          }
        };
      Function1<? super FormattableDocument,? extends Iterable<FormattingData>> _append_2 = this._formattingDataFactory.append(body, _function_6);
      format.operator_add(_append_2);
    }
    XExpression _predicate_1 = expr.getPredicate();
    this.format(_predicate_1, format);
    XExpression _body_2 = expr.getBody();
    this.format(_body_2, format);
  }
  
  protected void _format(final XBlockExpression expr, final FormattableDocument format) {
    final ILeafNode open = this._nodeModelAccess.nodeForKeyword(expr, "{");
    EObject _eContainer = expr.eContainer();
    boolean _equals = ObjectExtensions.operator_equals(_eContainer, null);
    if (_equals) {
      final Procedure1<FormattingDataInit> _function = new Procedure1<FormattingDataInit>() {
          public void apply(final FormattingDataInit it) {
            it.noSpace();
          }
        };
      Function1<? super FormattableDocument,? extends Iterable<FormattingData>> _prepend = this._formattingDataFactory.prepend(open, _function);
      format.operator_add(_prepend);
    }
    final ILeafNode close = this._nodeModelAccess.nodeForKeyword(expr, "}");
    boolean _and = false;
    boolean _notEquals = ObjectExtensions.operator_notEquals(open, null);
    if (!_notEquals) {
      _and = false;
    } else {
      boolean _notEquals_1 = ObjectExtensions.operator_notEquals(close, null);
      _and = (_notEquals && _notEquals_1);
    }
    if (_and) {
      EList<XExpression> _expressions = expr.getExpressions();
      boolean _isEmpty = _expressions.isEmpty();
      if (_isEmpty) {
        final Procedure1<FormattingDataInit> _function_1 = new Procedure1<FormattingDataInit>() {
            public void apply(final FormattingDataInit it) {
              it.newLine();
            }
          };
        Function1<? super FormattableDocument,? extends Iterable<FormattingData>> _append = this._formattingDataFactory.append(open, _function_1);
        format.operator_add(_append);
      } else {
        final Procedure1<FormattingDataInit> _function_2 = new Procedure1<FormattingDataInit>() {
            public void apply(final FormattingDataInit it) {
              it.cfg(XbaseFormatter2.this._xbaseFormatterConfigKeys.blankLinesAroundExpression);
              it.increaseIndentation();
            }
          };
        Function1<? super FormattableDocument,? extends Iterable<FormattingData>> _append_1 = this._formattingDataFactory.append(open, _function_2);
        format.operator_add(_append_1);
        EList<XExpression> _expressions_1 = expr.getExpressions();
        for (final XExpression child : _expressions_1) {
          {
            this.format(child, format);
            boolean _or = false;
            EList<XExpression> _expressions_2 = expr.getExpressions();
            XExpression _last = IterableExtensions.<XExpression>last(_expressions_2);
            boolean _notEquals_2 = ObjectExtensions.operator_notEquals(child, _last);
            if (_notEquals_2) {
              _or = true;
            } else {
              boolean _notEquals_3 = ObjectExtensions.operator_notEquals(close, null);
              _or = (_notEquals_2 || _notEquals_3);
            }
            if (_or) {
              final INode childNode = this._nodeModelAccess.nodeForEObject(child);
              final ILeafNode sem = this._nodeModelAccess.immediatelyFollowingKeyword(childNode, ";");
              boolean _notEquals_4 = ObjectExtensions.operator_notEquals(sem, null);
              if (_notEquals_4) {
                final Procedure1<FormattingDataInit> _function_3 = new Procedure1<FormattingDataInit>() {
                    public void apply(final FormattingDataInit it) {
                      it.noSpace();
                    }
                  };
                Function1<? super FormattableDocument,? extends Iterable<FormattingData>> _prepend_1 = this._formattingDataFactory.prepend(sem, _function_3);
                format.operator_add(_prepend_1);
                final Procedure1<FormattingDataInit> _function_4 = new Procedure1<FormattingDataInit>() {
                    public void apply(final FormattingDataInit it) {
                      it.cfg(XbaseFormatter2.this._xbaseFormatterConfigKeys.blankLinesAroundExpression);
                    }
                  };
                Function1<? super FormattableDocument,? extends Iterable<FormattingData>> _append_2 = this._formattingDataFactory.append(sem, _function_4);
                format.operator_add(_append_2);
              } else {
                final Procedure1<FormattingDataInit> _function_5 = new Procedure1<FormattingDataInit>() {
                    public void apply(final FormattingDataInit it) {
                      it.cfg(XbaseFormatter2.this._xbaseFormatterConfigKeys.blankLinesAroundExpression);
                    }
                  };
                Function1<? super FormattableDocument,? extends Iterable<FormattingData>> _append_3 = this._formattingDataFactory.append(childNode, _function_5);
                format.operator_add(_append_3);
              }
            }
          }
        }
        final Procedure1<FormattingDataInit> _function_3 = new Procedure1<FormattingDataInit>() {
            public void apply(final FormattingDataInit it) {
              it.decreaseIndentation();
            }
          };
        Function1<? super FormattableDocument,? extends Iterable<FormattingData>> _prepend_1 = this._formattingDataFactory.prepend(close, _function_3);
        format.operator_add(_prepend_1);
      }
    }
  }
  
  protected void _format(final XTypeLiteral expr, final FormattableDocument format) {
    final INode typeNode = this._nodeModelAccess.nodeForFeature(expr, org.eclipse.xtext.xbase.XbasePackage.Literals.XTYPE_LITERAL__TYPE);
    ILeafNode _nodeForKeyword = this._nodeModelAccess.nodeForKeyword(expr, "typeof");
    final Procedure1<FormattingDataInit> _function = new Procedure1<FormattingDataInit>() {
        public void apply(final FormattingDataInit it) {
          it.noSpace();
        }
      };
    Function1<? super FormattableDocument,? extends Iterable<FormattingData>> _append = this._formattingDataFactory.append(_nodeForKeyword, _function);
    format.operator_add(_append);
    final Procedure1<FormattingDataInit> _function_1 = new Procedure1<FormattingDataInit>() {
        public void apply(final FormattingDataInit it) {
          it.noSpace();
        }
      };
    Function1<? super FormattableDocument,? extends Iterable<FormattingData>> _prepend = this._formattingDataFactory.prepend(typeNode, _function_1);
    format.operator_add(_prepend);
    final Procedure1<FormattingDataInit> _function_2 = new Procedure1<FormattingDataInit>() {
        public void apply(final FormattingDataInit it) {
          it.noSpace();
        }
      };
    Function1<? super FormattableDocument,? extends Iterable<FormattingData>> _append_1 = this._formattingDataFactory.append(typeNode, _function_2);
    format.operator_add(_append_1);
    INode node = typeNode;
    boolean _notEquals = ObjectExtensions.operator_notEquals(node, null);
    boolean _while = _notEquals;
    while (_while) {
      {
        ILeafNode _immediatelyFollowingKeyword = this._nodeModelAccess.immediatelyFollowingKeyword(node, "[");
        node = _immediatelyFollowingKeyword;
        boolean _notEquals_1 = ObjectExtensions.operator_notEquals(node, null);
        if (_notEquals_1) {
          final Procedure1<FormattingDataInit> _function_3 = new Procedure1<FormattingDataInit>() {
              public void apply(final FormattingDataInit it) {
                it.noSpace();
              }
            };
          Function1<? super FormattableDocument,? extends Iterable<FormattingData>> _append_2 = this._formattingDataFactory.append(node, _function_3);
          format.operator_add(_append_2);
          ILeafNode _immediatelyFollowingKeyword_1 = this._nodeModelAccess.immediatelyFollowingKeyword(node, "]");
          node = _immediatelyFollowingKeyword_1;
          boolean _notEquals_2 = ObjectExtensions.operator_notEquals(node, null);
          if (_notEquals_2) {
            final Procedure1<FormattingDataInit> _function_4 = new Procedure1<FormattingDataInit>() {
                public void apply(final FormattingDataInit it) {
                  it.noSpace();
                }
              };
            Function1<? super FormattableDocument,? extends Iterable<FormattingData>> _append_3 = this._formattingDataFactory.append(node, _function_4);
            format.operator_add(_append_3);
          }
        }
      }
      boolean _notEquals_1 = ObjectExtensions.operator_notEquals(node, null);
      _while = _notEquals_1;
    }
  }
  
  protected void _format(final XThrowExpression expr, final FormattableDocument format) {
    XExpression _expression = expr.getExpression();
    INode _nodeForEObject = this._nodeModelAccess.nodeForEObject(_expression);
    final Procedure1<FormattingDataInit> _function = new Procedure1<FormattingDataInit>() {
        public void apply(final FormattingDataInit it) {
          it.oneSpace();
        }
      };
    Function1<? super FormattableDocument,? extends Iterable<FormattingData>> _prepend = this._formattingDataFactory.prepend(_nodeForEObject, _function);
    format.operator_add(_prepend);
    XExpression _expression_1 = expr.getExpression();
    this.format(_expression_1, format);
  }
  
  protected void _format(final XReturnExpression expr, final FormattableDocument format) {
    XExpression _expression = expr.getExpression();
    INode _nodeForEObject = this._nodeModelAccess.nodeForEObject(_expression);
    final Procedure1<FormattingDataInit> _function = new Procedure1<FormattingDataInit>() {
        public void apply(final FormattingDataInit it) {
          it.oneSpace();
        }
      };
    Function1<? super FormattableDocument,? extends Iterable<FormattingData>> _prepend = this._formattingDataFactory.prepend(_nodeForEObject, _function);
    format.operator_add(_prepend);
    XExpression _expression_1 = expr.getExpression();
    this.format(_expression_1, format);
  }
  
  protected void _format(final XTryCatchFinallyExpression expr, final FormattableDocument format) {
    XExpression _expression = expr.getExpression();
    final INode body = this._nodeModelAccess.nodeForEObject(_expression);
    XExpression _expression_1 = expr.getExpression();
    if ((_expression_1 instanceof XBlockExpression)) {
      final Procedure1<FormattingDataInit> _function = new Procedure1<FormattingDataInit>() {
          public void apply(final FormattingDataInit it) {
            it.cfg(XbaseFormatter2.this._xbaseFormatterConfigKeys.bracesInNewLine);
          }
        };
      Function1<? super FormattableDocument,? extends Iterable<FormattingData>> _prepend = this._formattingDataFactory.prepend(body, _function);
      format.operator_add(_prepend);
      final Procedure1<FormattingDataInit> _function_1 = new Procedure1<FormattingDataInit>() {
          public void apply(final FormattingDataInit it) {
            it.cfg(XbaseFormatter2.this._xbaseFormatterConfigKeys.bracesInNewLine);
          }
        };
      Function1<? super FormattableDocument,? extends Iterable<FormattingData>> _append = this._formattingDataFactory.append(body, _function_1);
      format.operator_add(_append);
    } else {
      final Procedure1<FormattingDataInit> _function_2 = new Procedure1<FormattingDataInit>() {
          public void apply(final FormattingDataInit it) {
            it.newLine();
            it.increaseIndentation();
          }
        };
      Function1<? super FormattableDocument,? extends Iterable<FormattingData>> _prepend_1 = this._formattingDataFactory.prepend(body, _function_2);
      format.operator_add(_prepend_1);
      final Procedure1<FormattingDataInit> _function_3 = new Procedure1<FormattingDataInit>() {
          public void apply(final FormattingDataInit it) {
            it.newLine();
            it.decreaseIndentation();
          }
        };
      Function1<? super FormattableDocument,? extends Iterable<FormattingData>> _append_1 = this._formattingDataFactory.append(body, _function_3);
      format.operator_add(_append_1);
    }
    XExpression _expression_2 = expr.getExpression();
    this.format(_expression_2, format);
    EList<XCatchClause> _catchClauses = expr.getCatchClauses();
    for (final XCatchClause cc : _catchClauses) {
      {
        this.format(cc, format);
        boolean _or = false;
        EList<XCatchClause> _catchClauses_1 = expr.getCatchClauses();
        XCatchClause _last = IterableExtensions.<XCatchClause>last(_catchClauses_1);
        boolean _notEquals = ObjectExtensions.operator_notEquals(cc, _last);
        if (_notEquals) {
          _or = true;
        } else {
          XExpression _finallyExpression = expr.getFinallyExpression();
          boolean _notEquals_1 = ObjectExtensions.operator_notEquals(_finallyExpression, null);
          _or = (_notEquals || _notEquals_1);
        }
        if (_or) {
          XExpression _expression_3 = cc.getExpression();
          if ((_expression_3 instanceof XBlockExpression)) {
            INode _nodeForEObject = this._nodeModelAccess.nodeForEObject(cc);
            final Procedure1<FormattingDataInit> _function_4 = new Procedure1<FormattingDataInit>() {
                public void apply(final FormattingDataInit it) {
                  it.cfg(XbaseFormatter2.this._xbaseFormatterConfigKeys.bracesInNewLine);
                }
              };
            Function1<? super FormattableDocument,? extends Iterable<FormattingData>> _append_2 = this._formattingDataFactory.append(_nodeForEObject, _function_4);
            format.operator_add(_append_2);
          } else {
            INode _nodeForEObject_1 = this._nodeModelAccess.nodeForEObject(cc);
            final Procedure1<FormattingDataInit> _function_5 = new Procedure1<FormattingDataInit>() {
                public void apply(final FormattingDataInit it) {
                  it.newLine();
                }
              };
            Function1<? super FormattableDocument,? extends Iterable<FormattingData>> _append_3 = this._formattingDataFactory.append(_nodeForEObject_1, _function_5);
            format.operator_add(_append_3);
          }
        }
      }
    }
    XExpression _finallyExpression = expr.getFinallyExpression();
    boolean _notEquals = ObjectExtensions.operator_notEquals(_finallyExpression, null);
    if (_notEquals) {
      XExpression _finallyExpression_1 = expr.getFinallyExpression();
      final INode fin = this._nodeModelAccess.nodeForEObject(_finallyExpression_1);
      XExpression _finallyExpression_2 = expr.getFinallyExpression();
      if ((_finallyExpression_2 instanceof XBlockExpression)) {
        final Procedure1<FormattingDataInit> _function_4 = new Procedure1<FormattingDataInit>() {
            public void apply(final FormattingDataInit it) {
              it.cfg(XbaseFormatter2.this._xbaseFormatterConfigKeys.bracesInNewLine);
            }
          };
        Function1<? super FormattableDocument,? extends Iterable<FormattingData>> _prepend_2 = this._formattingDataFactory.prepend(fin, _function_4);
        format.operator_add(_prepend_2);
      } else {
        final Procedure1<FormattingDataInit> _function_5 = new Procedure1<FormattingDataInit>() {
            public void apply(final FormattingDataInit it) {
              it.newLine();
              it.increaseIndentation();
            }
          };
        Function1<? super FormattableDocument,? extends Iterable<FormattingData>> _prepend_3 = this._formattingDataFactory.prepend(fin, _function_5);
        format.operator_add(_prepend_3);
        final Procedure1<FormattingDataInit> _function_6 = new Procedure1<FormattingDataInit>() {
            public void apply(final FormattingDataInit it) {
              it.decreaseIndentation();
            }
          };
        Function1<? super FormattableDocument,? extends Iterable<FormattingData>> _append_2 = this._formattingDataFactory.append(fin, _function_6);
        format.operator_add(_append_2);
      }
      XExpression _finallyExpression_3 = expr.getFinallyExpression();
      this.format(_finallyExpression_3, format);
    }
  }
  
  protected void _format(final XCatchClause expr, final FormattableDocument format) {
    ILeafNode _nodeForKeyword = this._nodeModelAccess.nodeForKeyword(expr, "catch");
    final Procedure1<FormattingDataInit> _function = new Procedure1<FormattingDataInit>() {
        public void apply(final FormattingDataInit it) {
          it.cfg(XbaseFormatter2.this._xbaseFormatterConfigKeys.whitespaceBetweenKeywordAndParenthesisML);
        }
      };
    Function1<? super FormattableDocument,? extends Iterable<FormattingData>> _append = this._formattingDataFactory.append(_nodeForKeyword, _function);
    format.operator_add(_append);
    JvmFormalParameter _declaredParam = expr.getDeclaredParam();
    INode _nodeForEObject = this._nodeModelAccess.nodeForEObject(_declaredParam);
    final Procedure1<INode> _function_1 = new Procedure1<INode>() {
        public void apply(final INode it) {
          final Procedure1<FormattingDataInit> _function = new Procedure1<FormattingDataInit>() {
              public void apply(final FormattingDataInit it) {
                it.noSpace();
              }
            };
          Function1<? super FormattableDocument,? extends Iterable<FormattingData>> _prepend = XbaseFormatter2.this._formattingDataFactory.prepend(it, _function);
          format.operator_add(_prepend);
          final Procedure1<FormattingDataInit> _function_1 = new Procedure1<FormattingDataInit>() {
              public void apply(final FormattingDataInit it) {
                it.noSpace();
              }
            };
          Function1<? super FormattableDocument,? extends Iterable<FormattingData>> _append = XbaseFormatter2.this._formattingDataFactory.append(it, _function_1);
          format.operator_add(_append);
        }
      };
    ObjectExtensions.<INode>operator_doubleArrow(_nodeForEObject, _function_1);
    XExpression _expression = expr.getExpression();
    final INode body = this._nodeModelAccess.nodeForEObject(_expression);
    XExpression _expression_1 = expr.getExpression();
    if ((_expression_1 instanceof XBlockExpression)) {
      final Procedure1<FormattingDataInit> _function_2 = new Procedure1<FormattingDataInit>() {
          public void apply(final FormattingDataInit it) {
            it.cfg(XbaseFormatter2.this._xbaseFormatterConfigKeys.bracesInNewLine);
          }
        };
      Function1<? super FormattableDocument,? extends Iterable<FormattingData>> _prepend = this._formattingDataFactory.prepend(body, _function_2);
      format.operator_add(_prepend);
    } else {
      final Procedure1<FormattingDataInit> _function_3 = new Procedure1<FormattingDataInit>() {
          public void apply(final FormattingDataInit it) {
            it.newLine();
            it.increaseIndentation();
          }
        };
      Function1<? super FormattableDocument,? extends Iterable<FormattingData>> _prepend_1 = this._formattingDataFactory.prepend(body, _function_3);
      format.operator_add(_prepend_1);
      final Procedure1<FormattingDataInit> _function_4 = new Procedure1<FormattingDataInit>() {
          public void apply(final FormattingDataInit it) {
            it.decreaseIndentation();
          }
        };
      Function1<? super FormattableDocument,? extends Iterable<FormattingData>> _append_1 = this._formattingDataFactory.append(body, _function_4);
      format.operator_add(_append_1);
    }
    JvmFormalParameter _declaredParam_1 = expr.getDeclaredParam();
    this.format(_declaredParam_1, format);
    XExpression _expression_2 = expr.getExpression();
    this.format(_expression_2, format);
  }
  
  protected void _format(final JvmFormalParameter expr, final FormattableDocument format) {
    JvmTypeReference _parameterType = expr.getParameterType();
    boolean _notEquals = ObjectExtensions.operator_notEquals(_parameterType, null);
    if (_notEquals) {
      JvmTypeReference _parameterType_1 = expr.getParameterType();
      INode _nodeForEObject = this._nodeModelAccess.nodeForEObject(_parameterType_1);
      final Procedure1<FormattingDataInit> _function = new Procedure1<FormattingDataInit>() {
          public void apply(final FormattingDataInit it) {
            it.oneSpace();
          }
        };
      Function1<? super FormattableDocument,? extends Iterable<FormattingData>> _append = this._formattingDataFactory.append(_nodeForEObject, _function);
      format.operator_add(_append);
    }
    JvmTypeReference _parameterType_2 = expr.getParameterType();
    this.format(_parameterType_2, format);
  }
  
  protected void _format(final XExpression expr, final FormattableDocument format) {
    EList<EObject> _eContents = expr.eContents();
    for (final EObject obj : _eContents) {
      boolean _matched = false;
      if (!_matched) {
        if (obj instanceof XExpression) {
          final XExpression _xExpression = (XExpression)obj;
          _matched=true;
          this.format(_xExpression, format);
        }
      }
    }
  }
  
  protected void _format(final XSwitchExpression expr, final FormattableDocument format) {
    EList<XCasePart> _cases = expr.getCases();
    final Function1<XCasePart,Boolean> _function = new Function1<XCasePart,Boolean>() {
        public Boolean apply(final XCasePart it) {
          XExpression _then = it.getThen();
          return Boolean.valueOf((_then instanceof XBlockExpression));
        }
      };
    final boolean containsBlockExpr = IterableExtensions.<XCasePart>exists(_cases, _function);
    boolean _and = false;
    boolean _not = (!containsBlockExpr);
    if (!_not) {
      _and = false;
    } else {
      INode _nodeForEObject = this._nodeModelAccess.nodeForEObject(expr);
      String _text = _nodeForEObject.getText();
      String _trim = _text.trim();
      boolean _contains = _trim.contains("\n");
      boolean _not_1 = (!_contains);
      _and = (_not && _not_1);
    }
    final boolean switchSL = _and;
    boolean _and_1 = false;
    boolean _not_2 = (!containsBlockExpr);
    if (!_not_2) {
      _and_1 = false;
    } else {
      EList<XCasePart> _cases_1 = expr.getCases();
      final Function1<XCasePart,Boolean> _function_1 = new Function1<XCasePart,Boolean>() {
          public Boolean apply(final XCasePart it) {
            INode _nodeForEObject = XbaseFormatter2.this._nodeModelAccess.nodeForEObject(it);
            String _text = _nodeForEObject.getText();
            String _trim = _text.trim();
            boolean _contains = _trim.contains("\n");
            return Boolean.valueOf(_contains);
          }
        };
      boolean _exists = IterableExtensions.<XCasePart>exists(_cases_1, _function_1);
      boolean _not_3 = (!_exists);
      _and_1 = (_not_2 && _not_3);
    }
    final boolean caseSL = _and_1;
    final ILeafNode open = this._nodeModelAccess.nodeForKeyword(expr, "{");
    final ILeafNode close = this._nodeModelAccess.nodeForKeyword(expr, "}");
    ILeafNode _nodeForKeyword = this._nodeModelAccess.nodeForKeyword(expr, "switch");
    final Procedure1<FormattingDataInit> _function_2 = new Procedure1<FormattingDataInit>() {
        public void apply(final FormattingDataInit it) {
          it.oneSpace();
        }
      };
    Function1<? super FormattableDocument,? extends Iterable<FormattingData>> _append = this._formattingDataFactory.append(_nodeForKeyword, _function_2);
    format.operator_add(_append);
    if (switchSL) {
      final Procedure1<FormattingDataInit> _function_3 = new Procedure1<FormattingDataInit>() {
          public void apply(final FormattingDataInit it) {
            it.space = " ";
          }
        };
      Function1<? super FormattableDocument,? extends Iterable<FormattingData>> _prepend = this._formattingDataFactory.prepend(open, _function_3);
      format.operator_add(_prepend);
      final Procedure1<FormattingDataInit> _function_4 = new Procedure1<FormattingDataInit>() {
          public void apply(final FormattingDataInit it) {
            it.space = " ";
          }
        };
      Function1<? super FormattableDocument,? extends Iterable<FormattingData>> _append_1 = this._formattingDataFactory.append(open, _function_4);
      format.operator_add(_append_1);
      EList<XCasePart> _cases_2 = expr.getCases();
      for (final XCasePart c : _cases_2) {
        {
          XExpression _then = c.getThen();
          final INode cnode = this._nodeModelAccess.nodeForEObject(_then);
          final Procedure1<FormattingDataInit> _function_5 = new Procedure1<FormattingDataInit>() {
              public void apply(final FormattingDataInit it) {
                it.space = " ";
              }
            };
          Function1<? super FormattableDocument,? extends Iterable<FormattingData>> _prepend_1 = this._formattingDataFactory.prepend(cnode, _function_5);
          format.operator_add(_prepend_1);
          final Procedure1<FormattingDataInit> _function_6 = new Procedure1<FormattingDataInit>() {
              public void apply(final FormattingDataInit it) {
                it.space = " ";
              }
            };
          Function1<? super FormattableDocument,? extends Iterable<FormattingData>> _append_2 = this._formattingDataFactory.append(cnode, _function_6);
          format.operator_add(_append_2);
        }
      }
    } else {
      if (caseSL) {
        final Procedure1<FormattingDataInit> _function_5 = new Procedure1<FormattingDataInit>() {
            public void apply(final FormattingDataInit it) {
              it.cfg(XbaseFormatter2.this._xbaseFormatterConfigKeys.bracesInNewLine);
            }
          };
        Function1<? super FormattableDocument,? extends Iterable<FormattingData>> _prepend_1 = this._formattingDataFactory.prepend(open, _function_5);
        format.operator_add(_prepend_1);
        final Procedure1<FormattingDataInit> _function_6 = new Procedure1<FormattingDataInit>() {
            public void apply(final FormattingDataInit it) {
              it.newLine();
              it.increaseIndentation();
            }
          };
        Function1<? super FormattableDocument,? extends Iterable<FormattingData>> _append_2 = this._formattingDataFactory.append(open, _function_6);
        format.operator_add(_append_2);
        EList<XCasePart> _cases_3 = expr.getCases();
        for (final XCasePart c_1 : _cases_3) {
          {
            XExpression _then = c_1.getThen();
            INode _nodeForEObject_1 = this._nodeModelAccess.nodeForEObject(_then);
            final Procedure1<FormattingDataInit> _function_7 = new Procedure1<FormattingDataInit>() {
                public void apply(final FormattingDataInit it) {
                  it.space = " ";
                }
              };
            Function1<? super FormattableDocument,? extends Iterable<FormattingData>> _prepend_2 = this._formattingDataFactory.prepend(_nodeForEObject_1, _function_7);
            format.operator_add(_prepend_2);
            EList<XCasePart> _cases_4 = expr.getCases();
            XCasePart _last = IterableExtensions.<XCasePart>last(_cases_4);
            boolean _notEquals = ObjectExtensions.operator_notEquals(c_1, _last);
            if (_notEquals) {
              INode _nodeForEObject_2 = this._nodeModelAccess.nodeForEObject(c_1);
              final Procedure1<FormattingDataInit> _function_8 = new Procedure1<FormattingDataInit>() {
                  public void apply(final FormattingDataInit it) {
                    it.newLine();
                  }
                };
              Function1<? super FormattableDocument,? extends Iterable<FormattingData>> _append_3 = this._formattingDataFactory.append(_nodeForEObject_2, _function_8);
              format.operator_add(_append_3);
            }
          }
        }
        final Procedure1<FormattingDataInit> _function_7 = new Procedure1<FormattingDataInit>() {
            public void apply(final FormattingDataInit it) {
              it.newLine();
              it.decreaseIndentation();
            }
          };
        Function1<? super FormattableDocument,? extends Iterable<FormattingData>> _prepend_2 = this._formattingDataFactory.prepend(close, _function_7);
        format.operator_add(_prepend_2);
      } else {
        final Procedure1<FormattingDataInit> _function_8 = new Procedure1<FormattingDataInit>() {
            public void apply(final FormattingDataInit it) {
              it.cfg(XbaseFormatter2.this._xbaseFormatterConfigKeys.bracesInNewLine);
            }
          };
        Function1<? super FormattableDocument,? extends Iterable<FormattingData>> _prepend_3 = this._formattingDataFactory.prepend(open, _function_8);
        format.operator_add(_prepend_3);
        final Procedure1<FormattingDataInit> _function_9 = new Procedure1<FormattingDataInit>() {
            public void apply(final FormattingDataInit it) {
              it.newLine();
              it.increaseIndentation();
            }
          };
        Function1<? super FormattableDocument,? extends Iterable<FormattingData>> _append_3 = this._formattingDataFactory.append(open, _function_9);
        format.operator_add(_append_3);
        EList<XCasePart> _cases_4 = expr.getCases();
        for (final XCasePart c_2 : _cases_4) {
          {
            XExpression _then = c_2.getThen();
            final INode cnode = this._nodeModelAccess.nodeForEObject(_then);
            XExpression _then_1 = c_2.getThen();
            if ((_then_1 instanceof XBlockExpression)) {
              final Procedure1<FormattingDataInit> _function_10 = new Procedure1<FormattingDataInit>() {
                  public void apply(final FormattingDataInit it) {
                    it.cfg(XbaseFormatter2.this._xbaseFormatterConfigKeys.bracesInNewLine);
                  }
                };
              Function1<? super FormattableDocument,? extends Iterable<FormattingData>> _prepend_4 = this._formattingDataFactory.prepend(cnode, _function_10);
              format.operator_add(_prepend_4);
              EList<XCasePart> _cases_5 = expr.getCases();
              XCasePart _last = IterableExtensions.<XCasePart>last(_cases_5);
              boolean _notEquals = ObjectExtensions.operator_notEquals(c_2, _last);
              if (_notEquals) {
                final Procedure1<FormattingDataInit> _function_11 = new Procedure1<FormattingDataInit>() {
                    public void apply(final FormattingDataInit it) {
                      it.newLine();
                    }
                  };
                Function1<? super FormattableDocument,? extends Iterable<FormattingData>> _append_4 = this._formattingDataFactory.append(cnode, _function_11);
                format.operator_add(_append_4);
              } else {
                final Procedure1<FormattingDataInit> _function_12 = new Procedure1<FormattingDataInit>() {
                    public void apply(final FormattingDataInit it) {
                      it.newLine();
                      it.decreaseIndentation();
                    }
                  };
                Function1<? super FormattableDocument,? extends Iterable<FormattingData>> _append_5 = this._formattingDataFactory.append(cnode, _function_12);
                format.operator_add(_append_5);
              }
            } else {
              final Procedure1<FormattingDataInit> _function_13 = new Procedure1<FormattingDataInit>() {
                  public void apply(final FormattingDataInit it) {
                    it.newLine();
                    it.increaseIndentation();
                  }
                };
              Function1<? super FormattableDocument,? extends Iterable<FormattingData>> _prepend_5 = this._formattingDataFactory.prepend(cnode, _function_13);
              format.operator_add(_prepend_5);
              EList<XCasePart> _cases_6 = expr.getCases();
              XCasePart _last_1 = IterableExtensions.<XCasePart>last(_cases_6);
              boolean _notEquals_1 = ObjectExtensions.operator_notEquals(c_2, _last_1);
              if (_notEquals_1) {
                final Procedure1<FormattingDataInit> _function_14 = new Procedure1<FormattingDataInit>() {
                    public void apply(final FormattingDataInit it) {
                      it.newLine();
                      it.decreaseIndentation();
                    }
                  };
                Function1<? super FormattableDocument,? extends Iterable<FormattingData>> _append_6 = this._formattingDataFactory.append(cnode, _function_14);
                format.operator_add(_append_6);
              } else {
                final Procedure1<FormattingDataInit> _function_15 = new Procedure1<FormattingDataInit>() {
                    public void apply(final FormattingDataInit it) {
                      it.newLine();
                      int _minus = (-2);
                      it.indentationChange = _minus;
                    }
                  };
                Function1<? super FormattableDocument,? extends Iterable<FormattingData>> _append_7 = this._formattingDataFactory.append(cnode, _function_15);
                format.operator_add(_append_7);
              }
            }
          }
        }
      }
    }
    EList<XCasePart> _cases_5 = expr.getCases();
    for (final XCasePart c_3 : _cases_5) {
      {
        boolean _and_2 = false;
        JvmTypeReference _typeGuard = c_3.getTypeGuard();
        boolean _notEquals = ObjectExtensions.operator_notEquals(_typeGuard, null);
        if (!_notEquals) {
          _and_2 = false;
        } else {
          XExpression _case = c_3.getCase();
          boolean _notEquals_1 = ObjectExtensions.operator_notEquals(_case, null);
          _and_2 = (_notEquals && _notEquals_1);
        }
        if (_and_2) {
          final INode typenode = this._nodeModelAccess.nodeForFeature(c_3, org.eclipse.xtext.xbase.XbasePackage.Literals.XCASE_PART__TYPE_GUARD);
          final INode casenode = this._nodeModelAccess.nodeForFeature(c_3, org.eclipse.xtext.xbase.XbasePackage.Literals.XCASE_PART__CASE);
          final Procedure1<FormattingDataInit> _function_10 = new Procedure1<FormattingDataInit>() {
              public void apply(final FormattingDataInit it) {
                it.space = " ";
              }
            };
          Function1<? super FormattableDocument,? extends Iterable<FormattingData>> _append_4 = this._formattingDataFactory.append(typenode, _function_10);
          format.operator_add(_append_4);
          final Procedure1<FormattingDataInit> _function_11 = new Procedure1<FormattingDataInit>() {
              public void apply(final FormattingDataInit it) {
                it.space = " ";
              }
            };
          Function1<? super FormattableDocument,? extends Iterable<FormattingData>> _prepend_4 = this._formattingDataFactory.prepend(casenode, _function_11);
          format.operator_add(_prepend_4);
          final Procedure1<FormattingDataInit> _function_12 = new Procedure1<FormattingDataInit>() {
              public void apply(final FormattingDataInit it) {
                it.noSpace();
              }
            };
          Function1<? super FormattableDocument,? extends Iterable<FormattingData>> _append_5 = this._formattingDataFactory.append(casenode, _function_12);
          format.operator_add(_append_5);
        } else {
          JvmTypeReference _typeGuard_1 = c_3.getTypeGuard();
          boolean _notEquals_2 = ObjectExtensions.operator_notEquals(_typeGuard_1, null);
          if (_notEquals_2) {
            final INode typenode_1 = this._nodeModelAccess.nodeForFeature(c_3, org.eclipse.xtext.xbase.XbasePackage.Literals.XCASE_PART__TYPE_GUARD);
            final Procedure1<FormattingDataInit> _function_13 = new Procedure1<FormattingDataInit>() {
                public void apply(final FormattingDataInit it) {
                  it.noSpace();
                }
              };
            Function1<? super FormattableDocument,? extends Iterable<FormattingData>> _append_6 = this._formattingDataFactory.append(typenode_1, _function_13);
            format.operator_add(_append_6);
          } else {
            XExpression _case_1 = c_3.getCase();
            boolean _notEquals_3 = ObjectExtensions.operator_notEquals(_case_1, null);
            if (_notEquals_3) {
              final INode casenode_1 = this._nodeModelAccess.nodeForFeature(c_3, org.eclipse.xtext.xbase.XbasePackage.Literals.XCASE_PART__CASE);
              final Procedure1<FormattingDataInit> _function_14 = new Procedure1<FormattingDataInit>() {
                  public void apply(final FormattingDataInit it) {
                    it.space = " ";
                  }
                };
              Function1<? super FormattableDocument,? extends Iterable<FormattingData>> _prepend_5 = this._formattingDataFactory.prepend(casenode_1, _function_14);
              format.operator_add(_prepend_5);
              final Procedure1<FormattingDataInit> _function_15 = new Procedure1<FormattingDataInit>() {
                  public void apply(final FormattingDataInit it) {
                    it.noSpace();
                  }
                };
              Function1<? super FormattableDocument,? extends Iterable<FormattingData>> _append_7 = this._formattingDataFactory.append(casenode_1, _function_15);
              format.operator_add(_append_7);
            }
          }
        }
        XExpression _case_2 = c_3.getCase();
        this.format(_case_2, format);
        XExpression _then = c_3.getThen();
        this.format(_then, format);
      }
    }
  }
  
  protected void _format(final XClosure expr, final FormattableDocument format) {
    ILeafNode _nodeForKeyword = this._nodeModelAccess.nodeForKeyword(expr, "[");
    EObject _eContainer = expr.eContainer();
    ILeafNode _nodeForKeyword_1 = this._nodeModelAccess.nodeForKeyword(_eContainer, "(");
    final ILeafNode open = ObjectExtensions.<ILeafNode>operator_elvis(_nodeForKeyword, _nodeForKeyword_1);
    ILeafNode _nodeForKeyword_2 = this._nodeModelAccess.nodeForKeyword(expr, "]");
    EObject _eContainer_1 = expr.eContainer();
    ILeafNode _nodeForKeyword_3 = this._nodeModelAccess.nodeForKeyword(_eContainer_1, ")");
    final ILeafNode close = ObjectExtensions.<ILeafNode>operator_elvis(_nodeForKeyword_2, _nodeForKeyword_3);
    List<XExpression> _switchResult = null;
    XExpression _expression = expr.getExpression();
    final XExpression x = _expression;
    boolean _matched = false;
    if (!_matched) {
      if (x instanceof XBlockExpression) {
        final XBlockExpression _xBlockExpression = (XBlockExpression)x;
        _matched=true;
        EList<XExpression> _expressions = _xBlockExpression.getExpressions();
        _switchResult = _expressions;
      }
    }
    if (!_matched) {
      if (x instanceof XExpression) {
        final XExpression _xExpression = (XExpression)x;
        _matched=true;
        ArrayList<XExpression> _newArrayList = CollectionLiterals.<XExpression>newArrayList(_xExpression);
        _switchResult = _newArrayList;
      }
    }
    if (!_matched) {
      List<XExpression> _emptyList = CollectionLiterals.<XExpression>emptyList();
      _switchResult = _emptyList;
    }
    final List<XExpression> children = _switchResult;
    boolean _and = false;
    EList<JvmFormalParameter> _declaredFormalParameters = expr.getDeclaredFormalParameters();
    boolean _isEmpty = _declaredFormalParameters.isEmpty();
    if (!_isEmpty) {
      _and = false;
    } else {
      boolean _isEmpty_1 = children.isEmpty();
      _and = (_isEmpty && _isEmpty_1);
    }
    if (_and) {
      ILeafNode _nodeForKeyword_4 = this._nodeModelAccess.nodeForKeyword(expr, "[");
      final Procedure1<FormattingDataInit> _function = new Procedure1<FormattingDataInit>() {
          public void apply(final FormattingDataInit it) {
            it.noSpace();
          }
        };
      Function1<? super FormattableDocument,? extends Iterable<FormattingData>> _append = this._formattingDataFactory.append(_nodeForKeyword_4, _function);
      format.operator_add(_append);
    } else {
      boolean _isMultilineLambda = this.isMultilineLambda(expr);
      if (_isMultilineLambda) {
        this.formatClosureMultiLine(expr, open, children, close, format);
      } else {
        this.formatClosureWrapIfNeeded(expr, open, children, close, format);
      }
    }
  }
  
  protected void formatClosureMultiLine(final XClosure expr, final INode open, final Collection<XExpression> children, final INode close, final FormattableDocument format) {
    this.formatClosureParameters(expr, format);
    final INode explicit = this._nodeModelAccess.nodeForFeature(expr, org.eclipse.xtext.xbase.XbasePackage.Literals.XCLOSURE__EXPLICIT_SYNTAX);
    boolean _notEquals = ObjectExtensions.operator_notEquals(explicit, null);
    if (_notEquals) {
      final Procedure1<FormattingDataInit> _function = new Procedure1<FormattingDataInit>() {
          public void apply(final FormattingDataInit it) {
            it.oneSpace();
          }
        };
      Function1<? super FormattableDocument,? extends Iterable<FormattingData>> _append = this._formattingDataFactory.append(open, _function);
      format.operator_add(_append);
      final Procedure1<FormattingDataInit> _function_1 = new Procedure1<FormattingDataInit>() {
          public void apply(final FormattingDataInit it) {
            it.oneSpace();
          }
        };
      Function1<? super FormattableDocument,? extends Iterable<FormattingData>> _prepend = this._formattingDataFactory.prepend(explicit, _function_1);
      format.operator_add(_prepend);
      final Procedure1<FormattingDataInit> _function_2 = new Procedure1<FormattingDataInit>() {
          public void apply(final FormattingDataInit it) {
            it.newLine();
            it.increaseIndentation();
          }
        };
      Function1<? super FormattableDocument,? extends Iterable<FormattingData>> _append_1 = this._formattingDataFactory.append(explicit, _function_2);
      format.operator_add(_append_1);
    } else {
      final Procedure1<FormattingDataInit> _function_3 = new Procedure1<FormattingDataInit>() {
          public void apply(final FormattingDataInit it) {
            it.newLine();
            it.increaseIndentation();
          }
        };
      Function1<? super FormattableDocument,? extends Iterable<FormattingData>> _append_2 = this._formattingDataFactory.append(open, _function_3);
      format.operator_add(_append_2);
    }
    for (final XExpression c : children) {
      {
        this.format(c, format);
        final INode node = this._nodeModelAccess.nodeForEObject(c);
        final ILeafNode semicolon = this._nodeModelAccess.immediatelyFollowingKeyword(node, ";");
        final Procedure1<FormattingDataInit> _function_4 = new Procedure1<FormattingDataInit>() {
            public void apply(final FormattingDataInit it) {
              it.noSpace();
            }
          };
        Function1<? super FormattableDocument,? extends Iterable<FormattingData>> _prepend_1 = this._formattingDataFactory.prepend(semicolon, _function_4);
        format.operator_add(_prepend_1);
        XExpression _last = IterableExtensions.<XExpression>last(children);
        boolean _notEquals_1 = ObjectExtensions.operator_notEquals(c, _last);
        if (_notEquals_1) {
          INode _elvis = ObjectExtensions.<INode>operator_elvis(semicolon, node);
          final Procedure1<FormattingDataInit> _function_5 = new Procedure1<FormattingDataInit>() {
              public void apply(final FormattingDataInit it) {
                it.newLine();
              }
            };
          Function1<? super FormattableDocument,? extends Iterable<FormattingData>> _append_3 = this._formattingDataFactory.append(_elvis, _function_5);
          format.operator_add(_append_3);
        }
      }
    }
    final Procedure1<FormattingDataInit> _function_4 = new Procedure1<FormattingDataInit>() {
        public void apply(final FormattingDataInit it) {
          it.newLine();
          it.decreaseIndentation();
        }
      };
    Function1<? super FormattableDocument,? extends Iterable<FormattingData>> _prepend_1 = this._formattingDataFactory.prepend(close, _function_4);
    format.operator_add(_prepend_1);
  }
  
  protected void formatClosureParameters(final XClosure expr, final FormattableDocument format) {
    boolean _isExplicitSyntax = expr.isExplicitSyntax();
    if (_isExplicitSyntax) {
      EList<JvmFormalParameter> _declaredFormalParameters = expr.getDeclaredFormalParameters();
      for (final JvmFormalParameter param : _declaredFormalParameters) {
        {
          this.format(param, format);
          ILeafNode _immediatelyFollowingKeyword = this._nodeModelAccess.immediatelyFollowingKeyword(param, ",");
          final Procedure1<FormattingDataInit> _function = new Procedure1<FormattingDataInit>() {
              public void apply(final FormattingDataInit it) {
                it.noSpace();
              }
            };
          final Procedure1<FormattingDataInit> _function_1 = new Procedure1<FormattingDataInit>() {
              public void apply(final FormattingDataInit it) {
                it.oneSpace();
              }
            };
          Function1<? super FormattableDocument,? extends Iterable<FormattingData>> _surround = this._formattingDataFactory.surround(_immediatelyFollowingKeyword, _function, _function_1);
          format.operator_add(_surround);
        }
      }
    }
  }
  
  protected void formatClosureWrapIfNeeded(final XClosure expr, final INode open, final Collection<XExpression> children, final INode close, final FormattableDocument format) {
    this.formatClosureParameters(expr, format);
    INode last = open;
    boolean _isExplicitSyntax = expr.isExplicitSyntax();
    if (_isExplicitSyntax) {
      final Procedure1<FormattingDataInit> _function = new Procedure1<FormattingDataInit>() {
          public void apply(final FormattingDataInit it) {
            it.noSpace();
          }
        };
      Function1<? super FormattableDocument,? extends Iterable<FormattingData>> _append = this._formattingDataFactory.append(open, _function);
      format.operator_add(_append);
      INode _nodeForFeature = this._nodeModelAccess.nodeForFeature(expr, org.eclipse.xtext.xbase.XbasePackage.Literals.XCLOSURE__EXPLICIT_SYNTAX);
      last = _nodeForFeature;
      final Procedure1<FormattingDataInit> _function_1 = new Procedure1<FormattingDataInit>() {
          public void apply(final FormattingDataInit it) {
            it.noSpace();
          }
        };
      Function1<? super FormattableDocument,? extends Iterable<FormattingData>> _prepend = this._formattingDataFactory.prepend(last, _function_1);
      format.operator_add(_prepend);
    }
    boolean indented = false;
    for (final XExpression c : children) {
      {
        boolean _fitsIntoLine = this.fitsIntoLine(format, c);
        if (_fitsIntoLine) {
          final Procedure1<FormattingDataInit> _function_2 = new Procedure1<FormattingDataInit>() {
              public void apply(final FormattingDataInit it) {
                XExpression _head = IterableExtensions.<XExpression>head(children);
                boolean _equals = ObjectExtensions.operator_equals(_head, c);
                if (_equals) {
                  it.noSpace();
                } else {
                  it.oneSpace();
                }
              }
            };
          Function1<? super FormattableDocument,? extends Iterable<FormattingData>> _append_1 = this._formattingDataFactory.append(last, _function_2);
          format.operator_add(_append_1);
        } else {
          boolean _not = (!indented);
          if (_not) {
            indented = true;
            final Procedure1<FormattingDataInit> _function_3 = new Procedure1<FormattingDataInit>() {
                public void apply(final FormattingDataInit it) {
                  it.increaseIndentation();
                }
              };
            Function1<? super FormattableDocument,? extends Iterable<FormattingData>> _append_2 = this._formattingDataFactory.append(last, _function_3);
            format.operator_add(_append_2);
          }
          final Procedure1<FormattingDataInit> _function_4 = new Procedure1<FormattingDataInit>() {
              public void apply(final FormattingDataInit it) {
                it.newLine();
              }
            };
          Function1<? super FormattableDocument,? extends Iterable<FormattingData>> _append_3 = this._formattingDataFactory.append(last, _function_4);
          format.operator_add(_append_3);
        }
        this.format(c, format);
        INode _nodeForEObject = this._nodeModelAccess.nodeForEObject(c);
        last = _nodeForEObject;
        final ILeafNode semicolon = this._nodeModelAccess.immediatelyFollowingKeyword(last, ";");
        boolean _notEquals = ObjectExtensions.operator_notEquals(semicolon, null);
        if (_notEquals) {
          final Procedure1<FormattingDataInit> _function_5 = new Procedure1<FormattingDataInit>() {
              public void apply(final FormattingDataInit it) {
                it.noSpace();
              }
            };
          Function1<? super FormattableDocument,? extends Iterable<FormattingData>> _prepend_1 = this._formattingDataFactory.prepend(semicolon, _function_5);
          format.operator_add(_prepend_1);
          last = semicolon;
        }
      }
    }
    if (indented) {
      XExpression _last = IterableExtensions.<XExpression>last(children);
      INode _nodeForEObject = this._nodeModelAccess.nodeForEObject(_last);
      final Procedure1<FormattingDataInit> _function_2 = new Procedure1<FormattingDataInit>() {
          public void apply(final FormattingDataInit it) {
            it.decreaseIndentation();
          }
        };
      Function1<? super FormattableDocument,? extends Iterable<FormattingData>> _append_1 = this._formattingDataFactory.append(_nodeForEObject, _function_2);
      format.operator_add(_append_1);
    }
    final Procedure1<FormattingDataInit> _function_3 = new Procedure1<FormattingDataInit>() {
        public void apply(final FormattingDataInit it) {
          it.noSpace();
        }
      };
    Function1<? super FormattableDocument,? extends Iterable<FormattingData>> _prepend_1 = this._formattingDataFactory.prepend(close, _function_3);
    format.operator_add(_prepend_1);
  }
  
  protected void format(final EObject ref, final FormattableDocument document) {
    if (ref instanceof JvmTypeParameter) {
      _format((JvmTypeParameter)ref, document);
      return;
    } else if (ref instanceof XAssignment) {
      _format((XAssignment)ref, document);
      return;
    } else if (ref instanceof XBinaryOperation) {
      _format((XBinaryOperation)ref, document);
      return;
    } else if (ref instanceof XDoWhileExpression) {
      _format((XDoWhileExpression)ref, document);
      return;
    } else if (ref instanceof XFeatureCall) {
      _format((XFeatureCall)ref, document);
      return;
    } else if (ref instanceof XMemberFeatureCall) {
      _format((XMemberFeatureCall)ref, document);
      return;
    } else if (ref instanceof XWhileExpression) {
      _format((XWhileExpression)ref, document);
      return;
    } else if (ref instanceof XFunctionTypeRef) {
      _format((XFunctionTypeRef)ref, document);
      return;
    } else if (ref instanceof JvmFormalParameter) {
      _format((JvmFormalParameter)ref, document);
      return;
    } else if (ref instanceof JvmGenericArrayTypeReference) {
      _format((JvmGenericArrayTypeReference)ref, document);
      return;
    } else if (ref instanceof JvmParameterizedTypeReference) {
      _format((JvmParameterizedTypeReference)ref, document);
      return;
    } else if (ref instanceof JvmWildcardTypeReference) {
      _format((JvmWildcardTypeReference)ref, document);
      return;
    } else if (ref instanceof XBlockExpression) {
      _format((XBlockExpression)ref, document);
      return;
    } else if (ref instanceof XClosure) {
      _format((XClosure)ref, document);
      return;
    } else if (ref instanceof XConstructorCall) {
      _format((XConstructorCall)ref, document);
      return;
    } else if (ref instanceof XForLoopExpression) {
      _format((XForLoopExpression)ref, document);
      return;
    } else if (ref instanceof XIfExpression) {
      _format((XIfExpression)ref, document);
      return;
    } else if (ref instanceof XReturnExpression) {
      _format((XReturnExpression)ref, document);
      return;
    } else if (ref instanceof XSwitchExpression) {
      _format((XSwitchExpression)ref, document);
      return;
    } else if (ref instanceof XThrowExpression) {
      _format((XThrowExpression)ref, document);
      return;
    } else if (ref instanceof XTryCatchFinallyExpression) {
      _format((XTryCatchFinallyExpression)ref, document);
      return;
    } else if (ref instanceof XTypeLiteral) {
      _format((XTypeLiteral)ref, document);
      return;
    } else if (ref instanceof XVariableDeclaration) {
      _format((XVariableDeclaration)ref, document);
      return;
    } else if (ref instanceof XAnnotation) {
      _format((XAnnotation)ref, document);
      return;
    } else if (ref instanceof XAnnotationValueArray) {
      _format((XAnnotationValueArray)ref, document);
      return;
    } else if (ref instanceof JvmTypeConstraint) {
      _format((JvmTypeConstraint)ref, document);
      return;
    } else if (ref instanceof XCatchClause) {
      _format((XCatchClause)ref, document);
      return;
    } else if (ref instanceof XExpression) {
      _format((XExpression)ref, document);
      return;
    } else if (ref != null) {
      _format(ref, document);
      return;
    } else if (ref == null) {
      _format((Void)null, document);
      return;
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(ref, document).toString());
    }
  }
  
  protected boolean isMultiParamInOwnLine(final XExpression fc, final FormattableDocument doc) {
    if (fc instanceof XFeatureCall) {
      return _isMultiParamInOwnLine((XFeatureCall)fc, doc);
    } else if (fc instanceof XMemberFeatureCall) {
      return _isMultiParamInOwnLine((XMemberFeatureCall)fc, doc);
    } else if (fc instanceof XConstructorCall) {
      return _isMultiParamInOwnLine((XConstructorCall)fc, doc);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(fc, doc).toString());
    }
  }
}
