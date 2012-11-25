package org.eclipse.xtext.xbase.formatting;

import org.eclipse.xtend.lib.Data;
import org.eclipse.xtext.xbase.formatting.FormattingData;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.util.ToStringHelper;

@Data
@SuppressWarnings("all")
public class WhitespaceData extends FormattingData {
  private final String _space;
  
  public String getSpace() {
    return this._space;
  }
  
  public boolean isEmpty() {
    String _space = this.getSpace();
    boolean _equals = ObjectExtensions.operator_equals(_space, null);
    return _equals;
  }
  
  public WhitespaceData(final int offset, final int length, final int indentationChange, final Throwable trace, final String space) {
    super(offset, length, indentationChange, trace);
    this._space = space;
  }
  
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = super.hashCode();
    result = prime * result + ((_space== null) ? 0 : _space.hashCode());
    return result;
  }
  
  @Override
  public boolean equals(final Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    if (!super.equals(obj))
      return false;
    WhitespaceData other = (WhitespaceData) obj;
    if (_space == null) {
      if (other._space != null)
        return false;
    } else if (!_space.equals(other._space))
      return false;
    return true;
  }
  
  @Override
  public String toString() {
    String result = new ToStringHelper().toString(this);
    return result;
  }
}
