import java.util.ArrayList;
import java.util.List;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.ListExtensions;

@SuppressWarnings("all")
public class Xbase08_Loops {
  public static void main(final String[] args) {
    try {
        final ArrayList<String> list = CollectionLiterals.<String>newArrayList("foo", "bar", "baz");
        ArrayList<String> _arrayList = new ArrayList<String>();
        final ArrayList<String> result = _arrayList;
        List<String> _reverse = ListExtensions.<String>reverse(list);
        for (final String x : _reverse) {
          String _upperCase = x.toUpperCase();
          result.add(_upperCase);
        }
        /*result;*/
        int i = 0;
        int _size = list.size();
        boolean _lessThan = (i < _size);
        boolean _while = _lessThan;
        while (_while) {
          {
            String _get = list.get(i);
            String _plus = ("whiled-" + _get);
            result.add(_plus);
            int _plus_1 = (i + 1);
            i = _plus_1;
          }
          int _size_1 = list.size();
          boolean _lessThan_1 = (i < _size_1);
          _while = _lessThan_1;
        }
        /*result;*/
    } catch (Throwable t) {}
  }
}
