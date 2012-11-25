package org.eclipse.xtext.xbase.formatting;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.SortedMap;
import java.util.TreeMap;
import org.apache.log4j.Logger;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.configuration.IConfigurationKeys;
import org.eclipse.xtext.xbase.configuration.IConfigurationValues;
import org.eclipse.xtext.xbase.formatting.AbstractFormatterConfigurationKeys;
import org.eclipse.xtext.xbase.formatting.FormattingData;
import org.eclipse.xtext.xbase.formatting.NewLineData;
import org.eclipse.xtext.xbase.formatting.TextReplacement;
import org.eclipse.xtext.xbase.formatting.WhitespaceData;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Functions.Function0;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.Functions.Function2;
import org.eclipse.xtext.xbase.lib.IntegerRange;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Pair;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

@SuppressWarnings("all")
public class FormattableDocument {
  private final static Logger log = new Function0<Logger>() {
    public Logger apply() {
      Logger _logger = Logger.getLogger(FormattableDocument.class);
      return _logger;
    }
  }.apply();
  
  private final IConfigurationValues _cfg;
  
  public IConfigurationValues getCfg() {
    return this._cfg;
  }
  
  private final String _document;
  
  public String getDocument() {
    return this._document;
  }
  
  private final TreeMap<Integer,FormattingData> _formattings;
  
  public TreeMap<Integer,FormattingData> getFormattings() {
    return this._formattings;
  }
  
  private Throwable _rootTrace = null;
  
  public Throwable getRootTrace() {
    return this._rootTrace;
  }
  
  public void setRootTrace(final Throwable rootTrace) {
    this._rootTrace = rootTrace;
  }
  
  private boolean _conflictOccurred = false;
  
  public boolean isConflictOccurred() {
    return this._conflictOccurred;
  }
  
  public void setConflictOccurred(final boolean conflictOccurred) {
    this._conflictOccurred = conflictOccurred;
  }
  
  public FormattableDocument(final IConfigurationValues cfg, final String document) {
    this._cfg = cfg;
    this._document = document;
    TreeMap<Integer,FormattingData> _treeMap = new TreeMap<Integer,FormattingData>();
    this._formattings = _treeMap;
  }
  
  public FormattableDocument(final FormattableDocument fmt) {
    IConfigurationValues _cfg = fmt.getCfg();
    this._cfg = _cfg;
    String _document = fmt.getDocument();
    this._document = _document;
    TreeMap<Integer,FormattingData> _formattings = fmt.getFormattings();
    TreeMap<Integer,FormattingData> _treeMap = new TreeMap<Integer,FormattingData>(_formattings);
    this._formattings = _treeMap;
  }
  
  public boolean isDebugConflicts() {
    Throwable _rootTrace = this.getRootTrace();
    boolean _notEquals = ObjectExtensions.operator_notEquals(_rootTrace, null);
    return _notEquals;
  }
  
  protected AbstractFormatterConfigurationKeys getKeys() {
    IConfigurationValues _cfg = this.getCfg();
    IConfigurationKeys _keys = _cfg.getKeys();
    return ((AbstractFormatterConfigurationKeys) _keys);
  }
  
  protected FormattingData addFormatting(final FormattingData data) {
    FormattingData _xifexpression = null;
    boolean _notEquals = ObjectExtensions.operator_notEquals(data, null);
    if (_notEquals) {
      FormattingData _xblockexpression = null;
      {
        int _length = data.getLength();
        boolean _lessThan = (_length < 0);
        if (_lessThan) {
          final Pair<String,String> text = this.getTextAround(data);
          StringConcatenation _builder = new StringConcatenation();
          _builder.append("lenght of text-edit can not be negative:");
          _builder.newLine();
          _builder.append("--------------------------------- document snippet ------------------------------");
          _builder.newLine();
          String _key = text.getKey();
          _builder.append(_key, "");
          _builder.append("[[[!!]]]");
          String _value = text.getValue();
          _builder.append(_value, "");
          _builder.newLineIfNotEmpty();
          _builder.append("---------------------------------------------------------------------------------");
          _builder.newLine();
          FormattableDocument.log.error(_builder);
          IllegalStateException _illegalStateException = new IllegalStateException("Length of text edit can not be negative");
          throw _illegalStateException;
        }
        int _length_1 = data.getLength();
        boolean _greaterThan = (_length_1 > 0);
        if (_greaterThan) {
          String _document = this.getDocument();
          int _offset = data.getOffset();
          int _offset_1 = data.getOffset();
          int _length_2 = data.getLength();
          int _plus = (_offset_1 + _length_2);
          final String oldText = _document.substring(_offset, _plus);
          boolean _isWhitespace = this.isWhitespace(oldText);
          boolean _not = (!_isWhitespace);
          if (_not) {
            final Pair<String,String> text_1 = this.getTextAround(data);
            StringConcatenation _builder_1 = new StringConcatenation();
            _builder_1.append("Can not edit non-whitespace:");
            _builder_1.newLine();
            _builder_1.append("------------------------------- document snippet --------------------------------");
            _builder_1.newLine();
            String _key_1 = text_1.getKey();
            _builder_1.append(_key_1, "");
            _builder_1.append("[[[");
            _builder_1.append(oldText, "");
            _builder_1.append("]]]");
            String _value_1 = text_1.getValue();
            _builder_1.append(_value_1, "");
            _builder_1.newLineIfNotEmpty();
            _builder_1.append("---------------------------------------------------------------------------------");
            _builder_1.newLine();
            FormattableDocument.log.error(_builder_1);
            String _plus_1 = ("Can non format non-whitespace: " + oldText);
            IllegalStateException _illegalStateException_1 = new IllegalStateException(_plus_1);
            throw _illegalStateException_1;
          }
        }
        TreeMap<Integer,FormattingData> _formattings = this.getFormattings();
        int _offset_2 = data.getOffset();
        final FormattingData old = _formattings.get(Integer.valueOf(_offset_2));
        FormattingData _xifexpression_1 = null;
        boolean _equals = ObjectExtensions.operator_equals(old, null);
        if (_equals) {
          _xifexpression_1 = data;
        } else {
          FormattingData _merge = this.merge(old, data);
          _xifexpression_1 = _merge;
        }
        final FormattingData newData = _xifexpression_1;
        FormattingData _xifexpression_2 = null;
        boolean _notEquals_1 = ObjectExtensions.operator_notEquals(newData, null);
        if (_notEquals_1) {
          TreeMap<Integer,FormattingData> _formattings_1 = this.getFormattings();
          int _offset_3 = data.getOffset();
          FormattingData _put = _formattings_1.put(Integer.valueOf(_offset_3), newData);
          _xifexpression_2 = _put;
        }
        _xblockexpression = (_xifexpression_2);
      }
      _xifexpression = _xblockexpression;
    }
    return _xifexpression;
  }
  
  protected FormattingData merge(final FormattingData data1, final FormattingData data2) {
    FormattingData _xblockexpression = null;
    {
      FormattingData old = null;
      int indentationChange = 0;
      boolean _isEmpty = data2.isEmpty();
      if (_isEmpty) {
        int _indentationChange = data1.getIndentationChange();
        int _indentationChange_1 = data2.getIndentationChange();
        int _plus = (_indentationChange + _indentationChange_1);
        indentationChange = _plus;
        old = data1;
      } else {
        boolean _isEmpty_1 = data1.isEmpty();
        if (_isEmpty_1) {
          int _indentationChange_2 = data2.getIndentationChange();
          int _indentationChange_3 = data1.getIndentationChange();
          int _plus_1 = (_indentationChange_2 + _indentationChange_3);
          indentationChange = _plus_1;
          old = data2;
        }
      }
      FormattingData _xifexpression = null;
      boolean _notEquals = ObjectExtensions.operator_notEquals(old, null);
      if (_notEquals) {
        FormattingData _switchResult = null;
        boolean _matched = false;
        if (!_matched) {
          if (old instanceof NewLineData) {
            final NewLineData _newLineData = (NewLineData)old;
            _matched=true;
            int _offset = _newLineData.getOffset();
            int _length = _newLineData.getLength();
            Throwable _trace = _newLineData.getTrace();
            int _newLines = _newLineData.getNewLines();
            NewLineData _newLineData_1 = new NewLineData(_offset, _length, indentationChange, _trace, _newLines);
            _switchResult = _newLineData_1;
          }
        }
        if (!_matched) {
          if (old instanceof WhitespaceData) {
            final WhitespaceData _whitespaceData = (WhitespaceData)old;
            _matched=true;
            int _offset = _whitespaceData.getOffset();
            int _length = _whitespaceData.getLength();
            Throwable _trace = _whitespaceData.getTrace();
            String _space = _whitespaceData.getSpace();
            WhitespaceData _whitespaceData_1 = new WhitespaceData(_offset, _length, indentationChange, _trace, _space);
            _switchResult = _whitespaceData_1;
          }
        }
        _xifexpression = _switchResult;
      } else {
        FormattingData _xblockexpression_1 = null;
        {
          this.setConflictOccurred(true);
          boolean _isDebugConflicts = this.isDebugConflicts();
          if (_isDebugConflicts) {
            this.reportConflict(data1, data2);
          }
          _xblockexpression_1 = (null);
        }
        _xifexpression = _xblockexpression_1;
      }
      _xblockexpression = (_xifexpression);
    }
    return _xblockexpression;
  }
  
  protected Pair<String,String> getTextAround(final FormattingData data1) {
    Pair<String,String> _xblockexpression = null;
    {
      IntegerRange _upTo = new IntegerRange(0, 5);
      int _offset = data1.getOffset();
      final Function2<Integer,Integer,Integer> _function = new Function2<Integer,Integer,Integer>() {
          public Integer apply(final Integer last, final Integer i) {
            int _xifexpression = (int) 0;
            boolean _greaterThan = ((last).intValue() > 0);
            if (_greaterThan) {
              String _document = FormattableDocument.this.getDocument();
              int _minus = ((last).intValue() - 1);
              int _lastIndexOf = _document.lastIndexOf("\n", _minus);
              _xifexpression = _lastIndexOf;
            } else {
              int _minus_1 = (-1);
              _xifexpression = _minus_1;
            }
            return Integer.valueOf(_xifexpression);
          }
        };
      final Integer back = IterableExtensions.<Integer, Integer>fold(_upTo, Integer.valueOf(_offset), _function);
      IntegerRange _upTo_1 = new IntegerRange(0, 5);
      int _offset_1 = data1.getOffset();
      final Function2<Integer,Integer,Integer> _function_1 = new Function2<Integer,Integer,Integer>() {
          public Integer apply(final Integer last, final Integer i) {
            int _xifexpression = (int) 0;
            boolean _greaterThan = ((last).intValue() > 0);
            if (_greaterThan) {
              String _document = FormattableDocument.this.getDocument();
              int _plus = ((last).intValue() + 1);
              int _indexOf = _document.indexOf("\n", _plus);
              _xifexpression = _indexOf;
            } else {
              int _minus = (-1);
              _xifexpression = _minus;
            }
            return Integer.valueOf(_xifexpression);
          }
        };
      final Integer forward = IterableExtensions.<Integer, Integer>fold(_upTo_1, Integer.valueOf(_offset_1), _function_1);
      Integer _xifexpression = null;
      boolean _greaterEqualsThan = ((back).intValue() >= 0);
      if (_greaterEqualsThan) {
        _xifexpression = back;
      } else {
        _xifexpression = 0;
      }
      final Integer fiveLinesBackOffset = _xifexpression;
      Integer _xifexpression_1 = null;
      boolean _greaterEqualsThan_1 = ((forward).intValue() >= 0);
      if (_greaterEqualsThan_1) {
        _xifexpression_1 = forward;
      } else {
        String _document = this.getDocument();
        int _length = _document.length();
        _xifexpression_1 = _length;
      }
      final Integer fiveLinesForwardOffset = _xifexpression_1;
      String _document_1 = this.getDocument();
      int _offset_2 = data1.getOffset();
      final String prefix = _document_1.substring((fiveLinesBackOffset).intValue(), _offset_2);
      String _document_2 = this.getDocument();
      int _offset_3 = data1.getOffset();
      int _length_1 = data1.getLength();
      int _plus = (_offset_3 + _length_1);
      final String postfix = _document_2.substring(_plus, (fiveLinesForwardOffset).intValue());
      Pair<String,String> _mappedTo = Pair.<String, String>of(prefix, postfix);
      _xblockexpression = (_mappedTo);
    }
    return _xblockexpression;
  }
  
  protected void reportConflict(final FormattingData data1, final FormattingData data2) {
    final Pair<String,String> text = this.getTextAround(data1);
    Throwable _rootTrace = this.getRootTrace();
    StackTraceElement[] _stackTrace = _rootTrace.getStackTrace();
    int _size = ((List<StackTraceElement>)Conversions.doWrapArray(_stackTrace)).size();
    final int traceStart = (_size - 1);
    Throwable _trace = data1.getTrace();
    final StackTraceElement[] fullTrace1 = _trace.getStackTrace();
    int _size_1 = ((List<StackTraceElement>)Conversions.doWrapArray(fullTrace1)).size();
    int _minus = (_size_1 - traceStart);
    List<StackTraceElement> _subList = ((List<StackTraceElement>)Conversions.doWrapArray(fullTrace1)).subList(0, _minus);
    final String shortTrace1 = IterableExtensions.join(_subList, "\n");
    Throwable _trace_1 = data2.getTrace();
    final StackTraceElement[] fullTrace2 = _trace_1.getStackTrace();
    int _size_2 = ((List<StackTraceElement>)Conversions.doWrapArray(fullTrace2)).size();
    int _minus_1 = (_size_2 - traceStart);
    List<StackTraceElement> _subList_1 = ((List<StackTraceElement>)Conversions.doWrapArray(fullTrace2)).subList(0, _minus_1);
    final String shortTrace2 = IterableExtensions.join(_subList_1, "\n");
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("Conflicting TextEdits during formatting:");
    _builder.newLine();
    _builder.append("------------------------------- document snippet --------------------------------");
    _builder.newLine();
    String _key = text.getKey();
    _builder.append(_key, "");
    _builder.append("[!!!]");
    String _value = text.getValue();
    _builder.append(_value, "");
    _builder.newLineIfNotEmpty();
    _builder.append("---------------------------------------------------------------------------------");
    _builder.newLine();
    _builder.append("TextEdit1: ");
    String _string = data1.toString();
    String _replaceAll = _string.replaceAll("\\n\\s*", " ");
    _builder.append(_replaceAll, "");
    _builder.newLineIfNotEmpty();
    _builder.append("TextEdit2: ");
    String _string_1 = data2.toString();
    String _replaceAll_1 = _string_1.replaceAll("\\n\\s*", " ");
    _builder.append(_replaceAll_1, "");
    _builder.newLineIfNotEmpty();
    _builder.append("---------------------------------- Trace 1 --------------------------------------");
    _builder.newLine();
    _builder.append(shortTrace1, "");
    _builder.newLineIfNotEmpty();
    _builder.append("---------------------------------- Trace 2 --------------------------------------");
    _builder.newLine();
    _builder.append(shortTrace2, "");
    _builder.newLineIfNotEmpty();
    _builder.append("---------------------------------------------------------------------------------");
    _builder.newLine();
    FormattableDocument.log.error(_builder);
  }
  
  public FormattingData operator_add(final FormattingData data) {
    FormattingData _addFormatting = this.addFormatting(data);
    return _addFormatting;
  }
  
  public void operator_add(final Iterable<FormattingData> data) {
    boolean _notEquals = ObjectExtensions.operator_notEquals(data, null);
    if (_notEquals) {
      final Procedure1<FormattingData> _function = new Procedure1<FormattingData>() {
          public void apply(final FormattingData it) {
            FormattableDocument.this.addFormatting(it);
          }
        };
      IterableExtensions.<FormattingData>forEach(data, _function);
    }
  }
  
  public void operator_add(final Function1<? super FormattableDocument,? extends Iterable<FormattingData>> data) {
    boolean _notEquals = ObjectExtensions.operator_notEquals(data, null);
    if (_notEquals) {
      Iterable<FormattingData> _apply = data.apply(this);
      this.operator_add(_apply);
    }
  }
  
  public List<TextReplacement> renderToEdits() {
    String _document = this.getDocument();
    int _length = _document.length();
    List<TextReplacement> _renderToEdits = this.renderToEdits(0, _length);
    return _renderToEdits;
  }
  
  public List<TextReplacement> renderToEdits(final int offset, final int length) {
    ArrayList<TextReplacement> _xblockexpression = null;
    {
      final ArrayList<TextReplacement> replacements = CollectionLiterals.<TextReplacement>newArrayList();
      int oldOffset = offset;
      int indentation = 0;
      TreeMap<Integer,FormattingData> _formattings = this.getFormattings();
      Collection<FormattingData> _values = _formattings.values();
      for (final FormattingData f : _values) {
        {
          int _indentationChange = f.getIndentationChange();
          int _plus = (indentation + _indentationChange);
          indentation = _plus;
          boolean _and = false;
          int _offset = f.getOffset();
          boolean _greaterEqualsThan = (_offset >= offset);
          if (!_greaterEqualsThan) {
            _and = false;
          } else {
            int _offset_1 = f.getOffset();
            int _length = f.getLength();
            int _plus_1 = (_offset_1 + _length);
            int _plus_2 = (offset + length);
            boolean _lessEqualsThan = (_plus_1 <= _plus_2);
            _and = (_greaterEqualsThan && _lessEqualsThan);
          }
          if (_and) {
            int _offset_2 = f.getOffset();
            final int textlength = (_offset_2 - oldOffset);
            boolean _matched = false;
            if (!_matched) {
              if (f instanceof WhitespaceData) {
                final WhitespaceData _whitespaceData = (WhitespaceData)f;
                _matched=true;
                String _space = _whitespaceData.getSpace();
                boolean _notEquals = ObjectExtensions.operator_notEquals(_space, null);
                if (_notEquals) {
                  final String replacement = _whitespaceData.getSpace();
                  int _offset_3 = _whitespaceData.getOffset();
                  int _length_1 = _whitespaceData.getLength();
                  TextReplacement _textReplacement = new TextReplacement(_offset_3, _length_1, replacement);
                  replacements.add(_textReplacement);
                }
              }
            }
            if (!_matched) {
              if (f instanceof NewLineData) {
                final NewLineData _newLineData = (NewLineData)f;
                _matched=true;
                int _newLines = _newLineData.getNewLines();
                String _wrap = this.getWrap(_newLines);
                String _indentation = this.getIndentation(indentation);
                final String replacement = (_wrap + _indentation);
                int _offset_3 = _newLineData.getOffset();
                int _length_1 = _newLineData.getLength();
                TextReplacement _textReplacement = new TextReplacement(_offset_3, _length_1, replacement);
                replacements.add(_textReplacement);
              }
            }
            int _length_1 = f.getLength();
            int _plus_3 = (textlength + _length_1);
            oldOffset = _plus_3;
          }
        }
      }
      _xblockexpression = (replacements);
    }
    return _xblockexpression;
  }
  
  public String renderToString() {
    String _document = this.getDocument();
    int _length = _document.length();
    String _renderToString = this.renderToString(0, _length);
    return _renderToString;
  }
  
  public String renderToString(final int offset, final int length) {
    String _xblockexpression = null;
    {
      final List<TextReplacement> edits = this.renderToEdits(offset, length);
      int lastOffset = offset;
      StringBuilder _stringBuilder = new StringBuilder();
      final StringBuilder newDocument = _stringBuilder;
      final Function1<TextReplacement,Integer> _function = new Function1<TextReplacement,Integer>() {
          public Integer apply(final TextReplacement it) {
            return Integer.valueOf(offset);
          }
        };
      List<TextReplacement> _sortBy = IterableExtensions.<TextReplacement, Integer>sortBy(edits, _function);
      for (final TextReplacement edit : _sortBy) {
        {
          String _document = this.getDocument();
          int _offset = edit.getOffset();
          final String text = _document.substring(lastOffset, _offset);
          newDocument.append(text);
          String _text = edit.getText();
          newDocument.append(_text);
          int _offset_1 = edit.getOffset();
          int _length = edit.getLength();
          int _plus = (_offset_1 + _length);
          lastOffset = _plus;
        }
      }
      String _document = this.getDocument();
      int _plus = (offset + length);
      final String text = _document.substring(lastOffset, _plus);
      newDocument.append(text);
      String _string = newDocument.toString();
      _xblockexpression = (_string);
    }
    return _xblockexpression;
  }
  
  protected boolean isWhitespace(final String doc) {
    int _length = doc.length();
    int _minus = (_length - 1);
    IntegerRange _upTo = new IntegerRange(0, _minus);
    final Function1<Integer,Boolean> _function = new Function1<Integer,Boolean>() {
        public Boolean apply(final Integer it) {
          char _charAt = doc.charAt((it).intValue());
          boolean _isWhitespace = Character.isWhitespace(_charAt);
          return Boolean.valueOf(_isWhitespace);
        }
      };
    boolean _forall = IterableExtensions.<Integer>forall(_upTo, _function);
    return _forall;
  }
  
  public int lineLengthBefore(final int offset) {
    int _xblockexpression = (int) 0;
    {
      int currentIndentation = 0;
      NewLineData lastWrap = null;
      int lastIndentation = 0;
      TreeMap<Integer,FormattingData> _formattings = this.getFormattings();
      Collection<FormattingData> _values = _formattings.values();
      for (final FormattingData f : _values) {
        int _offset = f.getOffset();
        boolean _lessThan = (_offset < offset);
        if (_lessThan) {
          int _indentationChange = f.getIndentationChange();
          int _plus = (currentIndentation + _indentationChange);
          currentIndentation = _plus;
          if ((f instanceof NewLineData)) {
            lastWrap = ((NewLineData) f);
            lastIndentation = currentIndentation;
          }
        }
      }
      int _offset_1 = lastWrap.getOffset();
      int _length = lastWrap.getLength();
      int lastOffset = (_offset_1 + _length);
      int lineStart = lastOffset;
      TreeMap<Integer,FormattingData> _formattings_1 = this.getFormattings();
      int _offset_2 = lastWrap.getOffset();
      int _plus_1 = (_offset_2 + 1);
      SortedMap<Integer,FormattingData> _subMap = _formattings_1.subMap(Integer.valueOf(_plus_1), Integer.valueOf(offset));
      Collection<FormattingData> _values_1 = _subMap.values();
      for (final FormattingData f_1 : _values_1) {
        {
          String _document = this.getDocument();
          int _offset_3 = f_1.getOffset();
          final String text = _document.substring(lastOffset, _offset_3);
          final int index = text.lastIndexOf("\n");
          boolean _greaterEqualsThan = (index >= 0);
          if (_greaterEqualsThan) {
            int _plus_2 = (index + lastOffset);
            lineStart = _plus_2;
            currentIndentation = 0;
          }
          int _offset_4 = f_1.getOffset();
          int _length_1 = f_1.getLength();
          int _plus_3 = (_offset_4 + _length_1);
          lastOffset = _plus_3;
        }
      }
      int lengthDiff = 0;
      TreeMap<Integer,FormattingData> _formattings_2 = this.getFormattings();
      int _offset_3 = lastWrap.getOffset();
      int _plus_2 = (_offset_3 + 1);
      SortedMap<Integer,FormattingData> _subMap_1 = _formattings_2.subMap(Integer.valueOf(_plus_2), Integer.valueOf(offset));
      Collection<FormattingData> _values_2 = _subMap_1.values();
      for (final FormattingData f_2 : _values_2) {
        if ((f_2 instanceof WhitespaceData)) {
          String _space = ((WhitespaceData) f_2).getSpace();
          int _length_1 = _space==null?0:_space.length();
          Integer _elvis = ObjectExtensions.<Integer>operator_elvis(Integer.valueOf(_length_1), Integer.valueOf(0));
          int _length_2 = f_2.getLength();
          int _minus = ((_elvis).intValue() - _length_2);
          int _plus_3 = (lengthDiff + _minus);
          lengthDiff = _plus_3;
        }
      }
      int _minus_1 = (offset - lineStart);
      int _indentationLenght = this.getIndentationLenght(currentIndentation);
      int _plus_4 = (_minus_1 + _indentationLenght);
      int _plus_5 = (_plus_4 + lengthDiff);
      _xblockexpression = (_plus_5);
    }
    return _xblockexpression;
  }
  
  public String lookahead(final int offset, final int length, final Procedure1<? super FormattableDocument> format) {
    String _xblockexpression = null;
    {
      FormattableDocument _formattableDocument = new FormattableDocument(this);
      final FormattableDocument lookahead = _formattableDocument;
      format.apply(lookahead);
      String _renderToString = lookahead.renderToString(offset, length);
      _xblockexpression = (_renderToString);
    }
    return _xblockexpression;
  }
  
  public boolean fitsIntoLine(final int offset, final int length, final Procedure1<? super FormattableDocument> format) {
    final String lookahead = this.lookahead(offset, length, format);
    boolean _contains = lookahead.contains("\n");
    if (_contains) {
      return false;
    } else {
      int _lineLengthBefore = this.lineLengthBefore(offset);
      int _length = lookahead.length();
      final int line = (_lineLengthBefore + _length);
      IConfigurationValues _cfg = this.getCfg();
      AbstractFormatterConfigurationKeys _keys = this.getKeys();
      Integer _get = _cfg.<Integer>get(_keys.maxLineWidth);
      return (line <= (_get).intValue());
    }
  }
  
  public String toString() {
    String _xblockexpression = null;
    {
      int lastOffset = 0;
      StringBuilder _stringBuilder = new StringBuilder();
      final StringBuilder debugTrace = _stringBuilder;
      List<TextReplacement> _renderToEdits = this.renderToEdits();
      for (final TextReplacement edit : _renderToEdits) {
        {
          String _document = this.getDocument();
          int _offset = edit.getOffset();
          final String text = _document.substring(lastOffset, _offset);
          debugTrace.append(text);
          StringConcatenation _builder = new StringConcatenation();
          _builder.append("[");
          String _document_1 = this.getDocument();
          int _offset_1 = edit.getOffset();
          int _offset_2 = edit.getOffset();
          int _length = edit.getLength();
          int _plus = (_offset_2 + _length);
          String _substring = _document_1.substring(_offset_1, _plus);
          _builder.append(_substring, "");
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
      String _document = this.getDocument();
      String _document_1 = this.getDocument();
      int _length = _document_1.length();
      final String text = _document.substring(lastOffset, _length);
      debugTrace.append(text);
      String _string = debugTrace.toString();
      _xblockexpression = (_string);
    }
    return _xblockexpression;
  }
  
  public String getIndentation(final int levels) {
    String _xifexpression = null;
    boolean _greaterThan = (levels > 0);
    if (_greaterThan) {
      String _xblockexpression = null;
      {
        IConfigurationValues _cfg = this.getCfg();
        AbstractFormatterConfigurationKeys _keys = this.getKeys();
        final String indent = _cfg.<String>get(_keys.indentation);
        int _minus = (levels - 1);
        IntegerRange _upTo = new IntegerRange(0, _minus);
        final Function1<Integer,String> _function = new Function1<Integer,String>() {
            public String apply(final Integer it) {
              return indent;
            }
          };
        Iterable<String> _map = IterableExtensions.<Integer, String>map(_upTo, _function);
        String _join = IterableExtensions.join(_map);
        _xblockexpression = (_join);
      }
      _xifexpression = _xblockexpression;
    } else {
      _xifexpression = "";
    }
    return _xifexpression;
  }
  
  public int getIndentationLenght(final int levels) {
    IConfigurationValues _cfg = this.getCfg();
    AbstractFormatterConfigurationKeys _keys = this.getKeys();
    Integer _get = _cfg.<Integer>get(_keys.indentationLength);
    int _multiply = (levels * (_get).intValue());
    return _multiply;
  }
  
  public String getWrap(final int levels) {
    String _xifexpression = null;
    boolean _greaterThan = (levels > 0);
    if (_greaterThan) {
      String _xblockexpression = null;
      {
        IConfigurationValues _cfg = this.getCfg();
        AbstractFormatterConfigurationKeys _keys = this.getKeys();
        final String sep = _cfg.<String>get(_keys.lineSeparator);
        int _minus = (levels - 1);
        IntegerRange _upTo = new IntegerRange(0, _minus);
        final Function1<Integer,String> _function = new Function1<Integer,String>() {
            public String apply(final Integer it) {
              return sep;
            }
          };
        Iterable<String> _map = IterableExtensions.<Integer, String>map(_upTo, _function);
        String _join = IterableExtensions.join(_map);
        _xblockexpression = (_join);
      }
      _xifexpression = _xblockexpression;
    } else {
      _xifexpression = "";
    }
    return _xifexpression;
  }
}
