@SuppressWarnings("all")
public class Xbase09_Exceptions {
  public static void main(final String[] args) {
    try {
    	try {
    		((Object) null).toString();
    	} catch (final NullPointerException e) {
    		RuntimeException _runtimeException = new RuntimeException(e);
    		throw _runtimeException;
    	} finally {
    	}/*null*/;
    } catch (Throwable t) {}
  }
}
