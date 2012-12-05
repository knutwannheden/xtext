/**
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.xbase.tests.typesystem;

import java.util.Collection;
import java.util.List;
import org.eclipse.xtext.common.types.JvmIdentifiableElement;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.eclipse.xtext.xbase.tests.typesystem.ValidatingExpressionAwareResolvedTypes;
import org.eclipse.xtext.xbase.tests.typesystem.ValidatingReassigningResolvedTypes;
import org.eclipse.xtext.xbase.tests.typesystem.ValidatingStackedResolvedTypes;
import org.eclipse.xtext.xbase.typesystem.conformance.ConformanceHint;
import org.eclipse.xtext.xbase.typesystem.internal.AbstractTypeExpectation;
import org.eclipse.xtext.xbase.typesystem.internal.DefaultReentrantTypeResolver;
import org.eclipse.xtext.xbase.typesystem.internal.ExpressionAwareStackedResolvedTypes;
import org.eclipse.xtext.xbase.typesystem.internal.RootResolvedTypes;
import org.eclipse.xtext.xbase.typesystem.internal.StackedResolvedTypes;
import org.eclipse.xtext.xbase.typesystem.internal.TypeData;
import org.eclipse.xtext.xbase.typesystem.references.ITypeReferenceOwner;
import org.eclipse.xtext.xbase.typesystem.references.LightweightBoundTypeArgument;
import org.eclipse.xtext.xbase.typesystem.references.LightweightTypeReference;
import org.eclipse.xtext.xbase.typesystem.references.UnboundTypeReference;

/**
 * @author Sebastian Zarnekow
 */
@SuppressWarnings("all")
public class ValidatingRootResolvedTypes extends RootResolvedTypes {
  public ValidatingRootResolvedTypes(final DefaultReentrantTypeResolver resolver) {
    super(resolver);
  }
  
  public StackedResolvedTypes pushReassigningTypes() {
    ValidatingReassigningResolvedTypes _validatingReassigningResolvedTypes = new ValidatingReassigningResolvedTypes(this);
    return _validatingReassigningResolvedTypes;
  }
  
  public StackedResolvedTypes pushTypes() {
    ValidatingStackedResolvedTypes _validatingStackedResolvedTypes = new ValidatingStackedResolvedTypes(this);
    return _validatingStackedResolvedTypes;
  }
  
  public ExpressionAwareStackedResolvedTypes pushTypes(final XExpression context) {
    ValidatingExpressionAwareResolvedTypes _validatingExpressionAwareResolvedTypes = new ValidatingExpressionAwareResolvedTypes(this, context);
    return _validatingExpressionAwareResolvedTypes;
  }
  
  public void setType(final JvmIdentifiableElement identifiable, final LightweightTypeReference reference) {
    ITypeReferenceOwner _referenceOwner = this.getReferenceOwner();
    boolean _isOwnedBy = reference.isOwnedBy(_referenceOwner);
    boolean _not = (!_isOwnedBy);
    if (_not) {
      IllegalArgumentException _illegalArgumentException = new IllegalArgumentException("reference is not owned by this resolved types");
      throw _illegalArgumentException;
    }
    super.setType(identifiable, reference);
  }
  
  public void reassignType(final JvmIdentifiableElement identifiable, final LightweightTypeReference reference) {
    ITypeReferenceOwner _referenceOwner = this.getReferenceOwner();
    boolean _isOwnedBy = reference.isOwnedBy(_referenceOwner);
    boolean _not = (!_isOwnedBy);
    if (_not) {
      IllegalArgumentException _illegalArgumentException = new IllegalArgumentException("reference is not owned by this resolved types");
      throw _illegalArgumentException;
    }
    super.reassignType(identifiable, reference);
  }
  
  public void acceptHint(final Object handle, final LightweightBoundTypeArgument boundTypeArgument) {
    boolean _and = false;
    LightweightTypeReference _typeReference = boundTypeArgument.getTypeReference();
    boolean _notEquals = ObjectExtensions.operator_notEquals(_typeReference, null);
    if (!_notEquals) {
      _and = false;
    } else {
      LightweightTypeReference _typeReference_1 = boundTypeArgument.getTypeReference();
      ITypeReferenceOwner _referenceOwner = this.getReferenceOwner();
      boolean _isOwnedBy = _typeReference_1.isOwnedBy(_referenceOwner);
      boolean _not = (!_isOwnedBy);
      _and = (_notEquals && _not);
    }
    if (_and) {
      IllegalArgumentException _illegalArgumentException = new IllegalArgumentException("reference is not owned by this resolved types");
      throw _illegalArgumentException;
    }
    super.acceptHint(handle, boundTypeArgument);
  }
  
  public LightweightTypeReference acceptType(final XExpression expression, final AbstractTypeExpectation expectation, final LightweightTypeReference type, final boolean returnType, final ConformanceHint... hints) {
    LightweightTypeReference _xblockexpression = null;
    {
      ITypeReferenceOwner _referenceOwner = this.getReferenceOwner();
      boolean _isOwnedBy = expectation.isOwnedBy(_referenceOwner);
      boolean _not = (!_isOwnedBy);
      if (_not) {
        IllegalArgumentException _illegalArgumentException = new IllegalArgumentException("expectation is not owned by this resolved types");
        throw _illegalArgumentException;
      }
      ITypeReferenceOwner _referenceOwner_1 = this.getReferenceOwner();
      boolean _isOwnedBy_1 = type.isOwnedBy(_referenceOwner_1);
      boolean _not_1 = (!_isOwnedBy_1);
      if (_not_1) {
        IllegalArgumentException _illegalArgumentException_1 = new IllegalArgumentException("type is not owned by this resolved types");
        throw _illegalArgumentException_1;
      }
      LightweightTypeReference _acceptType = super.acceptType(expression, expectation, type, returnType, hints);
      _xblockexpression = (_acceptType);
    }
    return _xblockexpression;
  }
  
  public List<LightweightBoundTypeArgument> getAllHints(final Object handle) {
    final List<LightweightBoundTypeArgument> result = super.getAllHints(handle);
    final Procedure1<LightweightBoundTypeArgument> _function = new Procedure1<LightweightBoundTypeArgument>() {
        public void apply(final LightweightBoundTypeArgument it) {
          boolean _and = false;
          LightweightTypeReference _typeReference = it.getTypeReference();
          boolean _notEquals = ObjectExtensions.operator_notEquals(_typeReference, null);
          if (!_notEquals) {
            _and = false;
          } else {
            LightweightTypeReference _typeReference_1 = it.getTypeReference();
            ITypeReferenceOwner _referenceOwner = ValidatingRootResolvedTypes.this.getReferenceOwner();
            boolean _isOwnedBy = _typeReference_1.isOwnedBy(_referenceOwner);
            boolean _not = (!_isOwnedBy);
            _and = (_notEquals && _not);
          }
          if (_and) {
            IllegalArgumentException _illegalArgumentException = new IllegalArgumentException("hint is not owned by this resolved types");
            throw _illegalArgumentException;
          }
        }
      };
    IterableExtensions.<LightweightBoundTypeArgument>forEach(result, _function);
    return result;
  }
  
  public UnboundTypeReference getUnboundTypeReference(final Object handle) {
    final UnboundTypeReference result = super.getUnboundTypeReference(handle);
    ITypeReferenceOwner _referenceOwner = this.getReferenceOwner();
    boolean _isOwnedBy = result.isOwnedBy(_referenceOwner);
    boolean _not = (!_isOwnedBy);
    if (_not) {
      IllegalArgumentException _illegalArgumentException = new IllegalArgumentException("result is not owned by this resolved types");
      throw _illegalArgumentException;
    }
    return result;
  }
  
  public LightweightTypeReference getActualType(final JvmIdentifiableElement identifiable) {
    final LightweightTypeReference result = super.getActualType(identifiable);
    ITypeReferenceOwner _referenceOwner = this.getReferenceOwner();
    boolean _isOwnedBy = result.isOwnedBy(_referenceOwner);
    boolean _not = (!_isOwnedBy);
    if (_not) {
      IllegalArgumentException _illegalArgumentException = new IllegalArgumentException("result is not owned by this resolved types");
      throw _illegalArgumentException;
    }
    return result;
  }
  
  public LightweightTypeReference getActualType(final XExpression expression) {
    final LightweightTypeReference result = super.getActualType(expression);
    boolean _and = false;
    boolean _notEquals = ObjectExtensions.operator_notEquals(result, null);
    if (!_notEquals) {
      _and = false;
    } else {
      ITypeReferenceOwner _referenceOwner = this.getReferenceOwner();
      boolean _isOwnedBy = result.isOwnedBy(_referenceOwner);
      boolean _not = (!_isOwnedBy);
      _and = (_notEquals && _not);
    }
    if (_and) {
      IllegalArgumentException _illegalArgumentException = new IllegalArgumentException("result is not owned by this resolved types");
      throw _illegalArgumentException;
    }
    return result;
  }
  
  public LightweightTypeReference getExpectedType(final XExpression expression) {
    final LightweightTypeReference result = super.getExpectedType(expression);
    boolean _and = false;
    boolean _notEquals = ObjectExtensions.operator_notEquals(result, null);
    if (!_notEquals) {
      _and = false;
    } else {
      ITypeReferenceOwner _referenceOwner = this.getReferenceOwner();
      boolean _isOwnedBy = result.isOwnedBy(_referenceOwner);
      boolean _not = (!_isOwnedBy);
      _and = (_notEquals && _not);
    }
    if (_and) {
      IllegalArgumentException _illegalArgumentException = new IllegalArgumentException("result is not owned by this resolved types");
      throw _illegalArgumentException;
    }
    return result;
  }
  
  public LightweightTypeReference getDeclaredType(final JvmIdentifiableElement identifiable) {
    final LightweightTypeReference result = super.getDeclaredType(identifiable);
    boolean _and = false;
    boolean _notEquals = ObjectExtensions.operator_notEquals(result, null);
    if (!_notEquals) {
      _and = false;
    } else {
      ITypeReferenceOwner _referenceOwner = this.getReferenceOwner();
      boolean _isOwnedBy = result.isOwnedBy(_referenceOwner);
      boolean _not = (!_isOwnedBy);
      _and = (_notEquals && _not);
    }
    if (_and) {
      IllegalArgumentException _illegalArgumentException = new IllegalArgumentException("result is not owned by this resolved types");
      throw _illegalArgumentException;
    }
    return result;
  }
  
  public LightweightTypeReference getMergedType(final List<LightweightTypeReference> types) {
    final Procedure1<LightweightTypeReference> _function = new Procedure1<LightweightTypeReference>() {
        public void apply(final LightweightTypeReference it) {
          ITypeReferenceOwner _owner = it.getOwner();
          boolean _isOwnedBy = it.isOwnedBy(_owner);
          boolean _not = (!_isOwnedBy);
          if (_not) {
            IllegalArgumentException _illegalArgumentException = new IllegalArgumentException("result is not owned by this resolved types");
            throw _illegalArgumentException;
          }
        }
      };
    IterableExtensions.<LightweightTypeReference>forEach(types, _function);
    final LightweightTypeReference result = super.getMergedType(types);
    ITypeReferenceOwner _referenceOwner = this.getReferenceOwner();
    boolean _isOwnedBy = result.isOwnedBy(_referenceOwner);
    boolean _not = (!_isOwnedBy);
    if (_not) {
      IllegalArgumentException _illegalArgumentException = new IllegalArgumentException("result is not owned by this resolved types");
      throw _illegalArgumentException;
    }
    return result;
  }
  
  public TypeData mergeTypeData(final XExpression expression, final Collection<TypeData> allValues, final boolean returnType, final boolean nullIfEmpty) {
    final Procedure1<TypeData> _function = new Procedure1<TypeData>() {
        public void apply(final TypeData it) {
          ITypeReferenceOwner _referenceOwner = ValidatingRootResolvedTypes.this.getReferenceOwner();
          boolean _isOwnedBy = it.isOwnedBy(_referenceOwner);
          boolean _not = (!_isOwnedBy);
          if (_not) {
            IllegalArgumentException _illegalArgumentException = new IllegalArgumentException("result is not owned by this resolved types");
            throw _illegalArgumentException;
          }
        }
      };
    IterableExtensions.<TypeData>forEach(allValues, _function);
    final TypeData result = super.mergeTypeData(expression, allValues, returnType, nullIfEmpty);
    ITypeReferenceOwner _referenceOwner = this.getReferenceOwner();
    boolean _isOwnedBy = result.isOwnedBy(_referenceOwner);
    boolean _not = (!_isOwnedBy);
    if (_not) {
      IllegalArgumentException _illegalArgumentException = new IllegalArgumentException("result is not owned by this resolved types");
      throw _illegalArgumentException;
    }
    return result;
  }
  
  public void acceptType(final XExpression expression, final TypeData typeData) {
    ITypeReferenceOwner _referenceOwner = this.getReferenceOwner();
    boolean _isOwnedBy = typeData.isOwnedBy(_referenceOwner);
    boolean _not = (!_isOwnedBy);
    if (_not) {
      IllegalArgumentException _illegalArgumentException = new IllegalArgumentException("typeData is not owned by this resolved types");
      throw _illegalArgumentException;
    }
    super.acceptType(expression, typeData);
  }
  
  public void acceptUnboundTypeReference(final Object handle, final UnboundTypeReference reference) {
    ITypeReferenceOwner _referenceOwner = this.getReferenceOwner();
    boolean _isOwnedBy = reference.isOwnedBy(_referenceOwner);
    boolean _not = (!_isOwnedBy);
    if (_not) {
      IllegalArgumentException _illegalArgumentException = new IllegalArgumentException("reference is not owned by this resolved types");
      throw _illegalArgumentException;
    }
    super.acceptUnboundTypeReference(handle, reference);
  }
  
  public Collection<TypeData> doGetTypeData(final XExpression expression) {
    final Collection<TypeData> result = super.doGetTypeData(expression);
    final Procedure1<TypeData> _function = new Procedure1<TypeData>() {
        public void apply(final TypeData it) {
          ITypeReferenceOwner _referenceOwner = ValidatingRootResolvedTypes.this.getReferenceOwner();
          boolean _isOwnedBy = it.isOwnedBy(_referenceOwner);
          boolean _not = (!_isOwnedBy);
          if (_not) {
            IllegalArgumentException _illegalArgumentException = new IllegalArgumentException("result is not owned by this resolved types");
            throw _illegalArgumentException;
          }
        }
      };
    if (result!=null) IterableExtensions.<TypeData>forEach(result, _function);
    return result;
  }
}
