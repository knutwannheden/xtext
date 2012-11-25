package org.eclipse.xtext.xbase.junit.formatter;

import com.google.common.collect.Iterables;
import com.google.inject.Inject;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.Resource.Diagnostic;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.junit4.util.ParseHelper;
import org.eclipse.xtext.nodemodel.ICompositeNode;
import org.eclipse.xtext.nodemodel.ILeafNode;
import org.eclipse.xtext.parser.IParseResult;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.xbase.configuration.MapBasedConfigurationValues;
import org.eclipse.xtext.xbase.formatting.AbstractFormatter;
import org.eclipse.xtext.xbase.formatting.IFormatter;
import org.eclipse.xtext.xbase.formatting.IFormatterConfigKeys;
import org.eclipse.xtext.xbase.formatting.TextReplacement;
import org.eclipse.xtext.xbase.junit.formatter.AssertingFormatterData;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.InputOutput;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.eclipse.xtext.xbase.lib.StringExtensions;
import org.junit.Assert;

@SuppressWarnings(value = "restriction")
public class FormatterTester {
  @Inject
  private ParseHelper<EObject> _parseHelper;
  
  @Inject
  private IFormatter formatter;
  
  @Inject
  private IFormatterConfigKeys keys;
  
  public void assertFormatted(final Procedure1<? super AssertingFormatterData> init) {
    AssertingFormatterData _assertingFormatterData = new AssertingFormatterData();
    final AssertingFormatterData data = _assertingFormatterData;
    MapBasedConfigurationValues _mapBasedConfigurationValues = new MapBasedConfigurationValues(this.keys);
    data.setCfg(_mapBasedConfigurationValues);
    init.apply(data);
    this.assertFormatted(data);
  }
  
  public void assertFormatted(final AssertingFormatterData it) {
    try {
      String _prefix = it.getPrefix();
      CharSequence _toBeFormatted = it.getToBeFormatted();
      String _plus = (_prefix + _toBeFormatted);
      String _postfix = it.getPostfix();
      final String fullToBeParsed = (_plus + _postfix);
      final EObject parsed = this._parseHelper.parse(fullToBeParsed);
      boolean _isAllowErrors = it.isAllowErrors();
      boolean _not = (!_isAllowErrors);
      if (_not) {
        Resource _eResource = parsed.eResource();
        EList<Diagnostic> _errors = _eResource.getErrors();
        String _join = IterableExtensions.join(_errors, "\n");
        Resource _eResource_1 = parsed.eResource();
        EList<Diagnostic> _errors_1 = _eResource_1.getErrors();
        int _size = _errors_1.size();
        Assert.assertEquals(_join, 0, _size);
      }
      Resource _eResource_2 = parsed.eResource();
      IParseResult _parseResult = ((XtextResource) _eResource_2).getParseResult();
      ICompositeNode _rootNode = _parseResult.getRootNode();
      final String oldDocument = _rootNode.getText();
      final IFormatter formatter = this.formatter;
      boolean _matched = false;
      if (!_matched) {
        if (formatter instanceof AbstractFormatter) {
          final AbstractFormatter _abstractFormatter = (AbstractFormatter)formatter;
          _matched=true;
          _abstractFormatter.setAllowIdentityEdits(true);
        }
      }
      String _prefix_1 = it.getPrefix();
      final int start = _prefix_1.length();
      CharSequence _toBeFormatted_1 = it.getToBeFormatted();
      final int length = _toBeFormatted_1.length();
      final LinkedHashSet<TextReplacement> edits = CollectionLiterals.<TextReplacement>newLinkedHashSet();
      Resource _eResource_3 = parsed.eResource();
      MapBasedConfigurationValues _cfg = it.getCfg();
      List<TextReplacement> _format = this.formatter.format(((XtextResource) _eResource_3), start, length, _cfg);
      Iterables.<TextReplacement>addAll(edits, _format);
      boolean _isAllowErrors_1 = it.isAllowErrors();
      boolean _not_1 = (!_isAllowErrors_1);
      if (_not_1) {
        Resource _eResource_4 = parsed.eResource();
        ArrayList<TextReplacement> _createMissingEditReplacements = this.createMissingEditReplacements(((XtextResource) _eResource_4), edits, start, length);
        Iterables.<TextReplacement>addAll(edits, _createMissingEditReplacements);
      }
      final String newDocument = this.applyEdits(oldDocument, edits);
      try {
        String _prefix_2 = it.getPrefix();
        CharSequence _expectation = it.getExpectation();
        String _plus_1 = (_prefix_2 + _expectation);
        String _postfix_1 = it.getPostfix();
        String _plus_2 = (_plus_1 + _postfix_1);
        String _string = _plus_2.toString();
        String _string_1 = newDocument.toString();
        Assert.assertEquals(_string, _string_1);
      } catch (final Throwable _t) {
        if (_t instanceof AssertionError) {
          final AssertionError e = (AssertionError)_t;
          String _applyDebugEdits = this.applyDebugEdits(oldDocument, edits);
          InputOutput.<String>println(_applyDebugEdits);
          InputOutput.println();
          throw e;
        } else {
          throw Exceptions.sneakyThrow(_t);
        }
      }
      Resource _eResource_5 = parsed.eResource();
      int _length = fullToBeParsed.length();
      MapBasedConfigurationValues _cfg_1 = it.getCfg();
      List<TextReplacement> _format_1 = this.formatter.format(((XtextResource) _eResource_5), 0, _length, _cfg_1);
      final String parsed2Doc = this.applyEdits(fullToBeParsed, _format_1);
      final EObject parsed2 = this._parseHelper.parse(parsed2Doc);
      boolean _isAllowErrors_2 = it.isAllowErrors();
      boolean _not_2 = (!_isAllowErrors_2);
      if (_not_2) {
        Resource _eResource_6 = parsed2.eResource();
        EList<Diagnostic> _errors_2 = _eResource_6.getErrors();
        int _size_1 = _errors_2.size();
        Assert.assertEquals(0, _size_1);
      }
      Resource _eResource_7 = parsed2.eResource();
      int _length_1 = parsed2Doc.length();
      MapBasedConfigurationValues _cfg_2 = it.getCfg();
      final List<TextReplacement> edits2 = this.formatter.format(((XtextResource) _eResource_7), 0, _length_1, _cfg_2);
      final String newDocument2 = this.applyEdits(parsed2Doc, edits2);
      try {
        String _string_2 = newDocument2.toString();
        Assert.assertEquals(parsed2Doc, _string_2);
      } catch (final Throwable _t_1) {
        if (_t_1 instanceof AssertionError) {
          final AssertionError e_1 = (AssertionError)_t_1;
          String _applyDebugEdits_1 = this.applyDebugEdits(newDocument, edits2);
          InputOutput.<String>println(_applyDebugEdits_1);
          InputOutput.println();
          throw e_1;
        } else {
          throw Exceptions.sneakyThrow(_t_1);
        }
      }
    } catch (Exception _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  protected String applyEdits(final String oldDocument, final Collection<TextReplacement> edits) {
    String _xblockexpression = null;
    {
      int lastOffset = 0;
      StringBuilder _stringBuilder = new StringBuilder();
      final StringBuilder newDocument = _stringBuilder;
      final Function1<TextReplacement,Integer> _function = new Function1<TextReplacement,Integer>() {
          public Integer apply(final TextReplacement it) {
            int _offset = it.getOffset();
            return Integer.valueOf(_offset);
          }
        };
      List<TextReplacement> _sortBy = IterableExtensions.<TextReplacement, Integer>sortBy(edits, _function);
      for (final TextReplacement edit : _sortBy) {
        {
          int _offset = edit.getOffset();
          String _substring = oldDocument.substring(lastOffset, _offset);
          newDocument.append(_substring);
          String _text = edit.getText();
          newDocument.append(_text);
          int _offset_1 = edit.getOffset();
          int _length = edit.getLength();
          int _plus = (_offset_1 + _length);
          lastOffset = _plus;
        }
      }
      int _length = oldDocument.length();
      String _substring = oldDocument.substring(lastOffset, _length);
      newDocument.append(_substring);
      String _string = newDocument.toString();
      _xblockexpression = (_string);
    }
    return _xblockexpression;
  }
  
  protected String applyDebugEdits(final String oldDocument, final Collection<TextReplacement> edits) {
    String _xblockexpression = null;
    {
      int lastOffset = 0;
      StringBuilder _stringBuilder = new StringBuilder();
      final StringBuilder debugTrace = _stringBuilder;
      final Function1<TextReplacement,Integer> _function = new Function1<TextReplacement,Integer>() {
          public Integer apply(final TextReplacement it) {
            int _offset = it.getOffset();
            return Integer.valueOf(_offset);
          }
        };
      List<TextReplacement> _sortBy = IterableExtensions.<TextReplacement, Integer>sortBy(edits, _function);
      for (final TextReplacement edit : _sortBy) {
        {
          int _offset = edit.getOffset();
          String _substring = oldDocument.substring(lastOffset, _offset);
          debugTrace.append(_substring);
          StringConcatenation _builder = new StringConcatenation();
          _builder.append("[");
          int _offset_1 = edit.getOffset();
          int _offset_2 = edit.getOffset();
          int _length = edit.getLength();
          int _plus = (_offset_2 + _length);
          String _substring_1 = oldDocument.substring(_offset_1, _plus);
          _builder.append(_substring_1, "");
          _builder.append("|");
          String _text = edit.getText();
          _builder.append(_text, "");
          _builder.append("]");
          debugTrace.append(_builder.toString());
          int _offset_3 = edit.getOffset();
          int _length_1 = edit.getLength();
          int _plus_1 = (_offset_3 + _length_1);
          lastOffset = _plus_1;
        }
      }
      int _length = oldDocument.length();
      String _substring = oldDocument.substring(lastOffset, _length);
      debugTrace.append(_substring);
      String _string = debugTrace.toString();
      _xblockexpression = (_string);
    }
    return _xblockexpression;
  }
  
  protected ArrayList<TextReplacement> createMissingEditReplacements(final XtextResource res, final Collection<TextReplacement> edits, final int offset, final int length) {
    ArrayList<TextReplacement> _xblockexpression = null;
    {
      final Function1<TextReplacement,Integer> _function = new Function1<TextReplacement,Integer>() {
          public Integer apply(final TextReplacement it) {
            int _offset = it.getOffset();
            return Integer.valueOf(_offset);
          }
        };
      Iterable<Integer> _map = IterableExtensions.<TextReplacement, Integer>map(edits, _function);
      final Set<Integer> offsets = IterableExtensions.<Integer>toSet(_map);
      final ArrayList<TextReplacement> result = CollectionLiterals.<TextReplacement>newArrayList();
      int lastOffset = 0;
      IParseResult _parseResult = res.getParseResult();
      ICompositeNode _rootNode = _parseResult.getRootNode();
      Iterable<ILeafNode> _leafNodes = _rootNode.getLeafNodes();
      for (final ILeafNode leaf : _leafNodes) {
        boolean _or = false;
        boolean _isHidden = leaf.isHidden();
        boolean _not = (!_isHidden);
        if (_not) {
          _or = true;
        } else {
          String _text = leaf.getText();
          String _trim = _text.trim();
          boolean _isNullOrEmpty = StringExtensions.isNullOrEmpty(_trim);
          boolean _not_1 = (!_isNullOrEmpty);
          _or = (_not || _not_1);
        }
        if (_or) {
          boolean _and = false;
          boolean _and_1 = false;
          boolean _greaterEqualsThan = (lastOffset >= offset);
          if (!_greaterEqualsThan) {
            _and_1 = false;
          } else {
            int _offset = leaf.getOffset();
            int _plus = (offset + length);
            boolean _lessEqualsThan = (_offset <= _plus);
            _and_1 = (_greaterEqualsThan && _lessEqualsThan);
          }
          if (!_and_1) {
            _and = false;
          } else {
            boolean _contains = offsets.contains(Integer.valueOf(lastOffset));
            boolean _not_2 = (!_contains);
            _and = (_and_1 && _not_2);
          }
          if (_and) {
            int _offset_1 = leaf.getOffset();
            int _minus = (_offset_1 - lastOffset);
            TextReplacement _textReplacement = new TextReplacement(lastOffset, _minus, "!!");
            result.add(_textReplacement);
          }
          int _offset_2 = leaf.getOffset();
          int _length = leaf.getLength();
          int _plus_1 = (_offset_2 + _length);
          lastOffset = _plus_1;
        }
      }
      _xblockexpression = (result);
    }
    return _xblockexpression;
  }
}
