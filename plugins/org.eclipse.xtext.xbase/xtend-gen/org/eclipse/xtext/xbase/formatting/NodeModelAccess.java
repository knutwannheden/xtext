package org.eclipse.xtext.xbase.formatting;

import com.google.common.collect.Iterables;
import java.util.List;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.xtext.Keyword;
import org.eclipse.xtext.nodemodel.BidiTreeIterable;
import org.eclipse.xtext.nodemodel.ICompositeNode;
import org.eclipse.xtext.nodemodel.ILeafNode;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;
import org.eclipse.xtext.parsetree.reconstr.impl.NodeIterator;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;

@SuppressWarnings("all")
public class NodeModelAccess {
  public INode nodeForEObject(final EObject obj) {
    ICompositeNode _findActualNodeFor = NodeModelUtils.findActualNodeFor(obj);
    return _findActualNodeFor;
  }
  
  public ILeafNode nodeForKeyword(final EObject obj, final String kw) {
    ILeafNode _xblockexpression = null;
    {
      final ICompositeNode node = NodeModelUtils.findActualNodeFor(obj);
      BidiTreeIterable<INode> _asTreeIterable = node.getAsTreeIterable();
      final Function1<INode,Boolean> _function = new Function1<INode,Boolean>() {
          public Boolean apply(final INode it) {
            boolean _and = false;
            boolean _and_1 = false;
            EObject _semanticElement = it.getSemanticElement();
            boolean _equals = ObjectExtensions.operator_equals(_semanticElement, obj);
            if (!_equals) {
              _and_1 = false;
            } else {
              EObject _grammarElement = it.getGrammarElement();
              _and_1 = (_equals && (_grammarElement instanceof Keyword));
            }
            if (!_and_1) {
              _and = false;
            } else {
              String _text = it.getText();
              boolean _equals_1 = ObjectExtensions.operator_equals(_text, kw);
              _and = (_and_1 && _equals_1);
            }
            return Boolean.valueOf(_and);
          }
        };
      INode _findFirst = IterableExtensions.<INode>findFirst(_asTreeIterable, _function);
      _xblockexpression = (((ILeafNode) _findFirst));
    }
    return _xblockexpression;
  }
  
  public Iterable<ILeafNode> nodesForKeyword(final EObject obj, final String kw) {
    Iterable<ILeafNode> _xblockexpression = null;
    {
      final ICompositeNode node = NodeModelUtils.findActualNodeFor(obj);
      BidiTreeIterable<INode> _asTreeIterable = node.getAsTreeIterable();
      Iterable<ILeafNode> _filter = Iterables.<ILeafNode>filter(_asTreeIterable, ILeafNode.class);
      final Function1<ILeafNode,Boolean> _function = new Function1<ILeafNode,Boolean>() {
          public Boolean apply(final ILeafNode it) {
            boolean _and = false;
            boolean _and_1 = false;
            EObject _semanticElement = it.getSemanticElement();
            boolean _equals = ObjectExtensions.operator_equals(_semanticElement, obj);
            if (!_equals) {
              _and_1 = false;
            } else {
              EObject _grammarElement = it.getGrammarElement();
              _and_1 = (_equals && (_grammarElement instanceof Keyword));
            }
            if (!_and_1) {
              _and = false;
            } else {
              String _text = it.getText();
              boolean _equals_1 = ObjectExtensions.operator_equals(_text, kw);
              _and = (_and_1 && _equals_1);
            }
            return Boolean.valueOf(_and);
          }
        };
      Iterable<ILeafNode> _filter_1 = IterableExtensions.<ILeafNode>filter(_filter, _function);
      _xblockexpression = (_filter_1);
    }
    return _xblockexpression;
  }
  
  public INode nodeForFeature(final EObject obj, final EStructuralFeature feature) {
    List<INode> _findNodesForFeature = NodeModelUtils.findNodesForFeature(obj, feature);
    INode _head = IterableExtensions.<INode>head(_findNodesForFeature);
    return _head;
  }
  
  public Iterable<INode> nodesForFeature(final EObject obj, final EStructuralFeature feature) {
    List<INode> _findNodesForFeature = NodeModelUtils.findNodesForFeature(obj, feature);
    return _findNodesForFeature;
  }
  
  public ILeafNode immediatelyFollowingKeyword(final EObject obj, final String kw) {
    INode _nodeForEObject = this.nodeForEObject(obj);
    ILeafNode _immediatelyFollowingKeyword = this.immediatelyFollowingKeyword(_nodeForEObject, kw);
    return _immediatelyFollowingKeyword;
  }
  
  public ILeafNode immediatelyFollowingKeyword(final INode node, final String kw) {
    ILeafNode _xblockexpression = null;
    {
      INode current = node;
      boolean _while = (current instanceof ICompositeNode);
      while (_while) {
        INode _lastChild = ((ICompositeNode) current).getLastChild();
        current = _lastChild;
        _while = (current instanceof ICompositeNode);
      }
      final INode current1 = current;
      final Function1<ILeafNode,Boolean> _function = new Function1<ILeafNode,Boolean>() {
          public Boolean apply(final ILeafNode it) {
            boolean _and = false;
            boolean _notEquals = ObjectExtensions.operator_notEquals(current1, it);
            if (!_notEquals) {
              _and = false;
            } else {
              EObject _grammarElement = it.getGrammarElement();
              _and = (_notEquals && (_grammarElement instanceof Keyword));
            }
            return Boolean.valueOf(_and);
          }
        };
      final ILeafNode result = this.findNextLeaf(current1, _function);
      ILeafNode _xifexpression = null;
      boolean _and = false;
      boolean _notEquals = ObjectExtensions.operator_notEquals(result, null);
      if (!_notEquals) {
        _and = false;
      } else {
        String _text = result.getText();
        boolean _equals = ObjectExtensions.operator_equals(_text, kw);
        _and = (_notEquals && _equals);
      }
      if (_and) {
        _xifexpression = result;
      }
      _xblockexpression = (_xifexpression);
    }
    return _xblockexpression;
  }
  
  public ILeafNode findNextLeaf(final INode node, final Function1<? super ILeafNode,? extends Boolean> matches) {
    boolean _notEquals = ObjectExtensions.operator_notEquals(node, null);
    if (_notEquals) {
      boolean _and = false;
      if (!(node instanceof ILeafNode)) {
        _and = false;
      } else {
        Boolean _apply = matches.apply(((ILeafNode) node));
        _and = ((node instanceof ILeafNode) && (_apply).booleanValue());
      }
      if (_and) {
        return ((ILeafNode) node);
      }
      NodeIterator _nodeIterator = new NodeIterator(node);
      final NodeIterator ni = _nodeIterator;
      boolean _hasNext = ni.hasNext();
      boolean _while = _hasNext;
      while (_while) {
        {
          final INode next = ni.next();
          boolean _and_1 = false;
          if (!(next instanceof ILeafNode)) {
            _and_1 = false;
          } else {
            Boolean _apply_1 = matches.apply(((ILeafNode) next));
            _and_1 = ((next instanceof ILeafNode) && (_apply_1).booleanValue());
          }
          if (_and_1) {
            return ((ILeafNode) next);
          }
        }
        boolean _hasNext_1 = ni.hasNext();
        _while = _hasNext_1;
      }
    }
    return null;
  }
}
