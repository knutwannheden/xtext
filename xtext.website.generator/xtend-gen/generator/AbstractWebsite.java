package generator;

import com.google.common.base.Charsets;
import com.google.common.base.Objects;
import com.google.common.io.CharStreams;
import com.google.common.io.Files;
import com.google.common.io.OutputSupplier;
import com.google.inject.Injector;
import generator.Resource;
import java.io.File;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.InputOutput;
import org.eclipse.xtext.xbase.lib.Pair;
import org.eclipse.xtext.xbase.lib.StringExtensions;
import org.eclipse.xtext.xdoc.XdocStandaloneSetup;

@SuppressWarnings("all")
public abstract class AbstractWebsite implements Resource {
  protected AbstractWebsite() {
    XdocStandaloneSetup _standaloneSetup = this.getStandaloneSetup();
    final Injector injector = _standaloneSetup.createInjectorAndDoEMFRegistration();
    injector.injectMembers(this);
  }
  
  public XdocStandaloneSetup getStandaloneSetup() {
    XdocStandaloneSetup _xdocStandaloneSetup = new XdocStandaloneSetup();
    return _xdocStandaloneSetup;
  }
  
  public void generateTo(final File targetDir) {
    try {
      String _path = this.path();
      File _file = new File(targetDir, _path);
      final File file = _file;
      boolean _exists = file.exists();
      if (_exists) {
        InputOutput.<String>print("overwriting ");
      }
      CharSequence _website = this.website();
      OutputSupplier<OutputStreamWriter> _newWriterSupplier = Files.newWriterSupplier(file, Charsets.UTF_8);
      CharStreams.<OutputStreamWriter>write(_website, _newWriterSupplier);
      String _plus = ("generated \'" + file);
      String _plus_1 = (_plus + "\'");
      InputOutput.<String>println(_plus_1);
    } catch (Exception _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  /**
   * the path relative the website root
   */
  public abstract String path();
  
  public abstract CharSequence contents();
  
  public CharSequence website() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("<!DOCTYPE html>");
    _builder.newLine();
    _builder.append("<html lang=\"en\">");
    _builder.newLine();
    _builder.append("<head>");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("<meta charset=\"utf-8\">");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("<title>");
    String _websiteTitle = this.websiteTitle();
    _builder.append(_websiteTitle, "	");
    _builder.append("</title>");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("<meta name=\"description\"");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("content=\"");
    String _websiteDescription = this.websiteDescription();
    _builder.append(_websiteDescription, "		");
    _builder.append("\">");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("<meta name=\"author\" content=\"Sven Efftinge\">");
    _builder.newLine();
    _builder.append("\t");
    CharSequence _stylesheets = this.stylesheets();
    _builder.append(_stylesheets, "	");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    CharSequence _javaScriptDocumentStart = this.javaScriptDocumentStart();
    _builder.append(_javaScriptDocumentStart, "	");
    _builder.newLineIfNotEmpty();
    _builder.append("</head>");
    _builder.newLine();
    _builder.append("<body>");
    _builder.newLine();
    _builder.append("\t");
    CharSequence _navBar = this.navBar();
    _builder.append(_navBar, "	");
    _builder.newLineIfNotEmpty();
    CharSequence _contents = this.contents();
    _builder.append(_contents, "");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    CharSequence _quickLinksAndTweets = this.quickLinksAndTweets();
    _builder.append(_quickLinksAndTweets, "	");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    CharSequence _javaScriptAtTheEnd = this.javaScriptAtTheEnd();
    _builder.append(_javaScriptAtTheEnd, "	");
    _builder.newLineIfNotEmpty();
    _builder.append("</body>");
    _builder.newLine();
    _builder.append("</html>");
    _builder.newLine();
    return _builder;
  }
  
  public String websiteDescription() {
    return "The website of Eclipse Xtext, an open-source framework for development of programming langauges and domain-specific languages";
  }
  
  public String websiteTitle() {
    return "Xtext - Language Development Made Easy!";
  }
  
  public CharSequence javaScriptDocumentStart() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("<script src=\"js/twitter.js\" type=\"text/javascript\"></script>");
    _builder.newLine();
    _builder.append("<script src=\"js/jquery-1.7.1.min.js\"></script>");
    _builder.newLine();
    _builder.append("<script src=\"js/jquery.prettyPhoto.js\" type=\"text/javascript\"></script>");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("<script type=\"text/javascript\">");
    _builder.newLine();
    _builder.append("     ");
    _builder.append("$(document).ready(function() {");
    _builder.newLine();
    _builder.append("\t\t");
    CharSequence _jsOnLoad = this.jsOnLoad();
    _builder.append(_jsOnLoad, "		");
    _builder.newLineIfNotEmpty();
    _builder.append("     ");
    _builder.append("});");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("</script>");
    _builder.newLine();
    _builder.append("<script type=\"text/javascript\">");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("var _gaq = _gaq || [];\t");
    _builder.newLine();
    _builder.append("  \t");
    _builder.append("_gaq.push([ \'_setAccount\', \'");
    String _analyticsAccount = this.analyticsAccount();
    _builder.append(_analyticsAccount, "  	");
    _builder.append("\' ]);");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("_gaq.push([ \'_trackPageview\' ]);");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("(function() {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("var ga = document.createElement(\'script\');");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("ga.type = \'text/javascript\';");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("ga.async = true;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("ga.src = (\'https:\' == document.location.protocol ? \'https://ssl\'");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append(": \'http://www\')");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("+ \'.google-analytics.com/ga.js\';");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("var s = document.getElementsByTagName(\'script\')[0];");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("s.parentNode.insertBefore(ga, s);");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("})();");
    _builder.newLine();
    _builder.append("</script>");
    _builder.newLine();
    return _builder;
  }
  
  public String analyticsAccount() {
    return "UA-2429174-3";
  }
  
  public CharSequence jsOnLoad() {
    StringConcatenation _builder = new StringConcatenation();
    {
      boolean _isPrettyPrint = this.isPrettyPrint();
      if (_isPrettyPrint) {
        _builder.append("prettyPrint();");
        _builder.newLine();
      }
    }
    _builder.append("$(\'a[data-rel]\').each(function() {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("$(this).attr(\'rel\', $(this).data(\'rel\'));");
    _builder.newLine();
    _builder.append("});");
    _builder.newLine();
    _builder.newLine();
    _builder.append("$(\"a[rel^=\'prettyPhoto\']\").prettyPhoto({");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("animation_speed: \'fast\',");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("slideshow: 5000,");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("autoplay_slideshow: false,");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("opacity: 0.80,");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("show_title: true,");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("theme: \'ligh_square\',");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("overlay_gallery: false,");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("social_tools: false");
    _builder.newLine();
    _builder.append("});");
    _builder.newLine();
    {
      boolean _isOutline = this.isOutline();
      if (_isOutline) {
        _builder.append("$(\'#nav-outline > li > a\').live(\'click\', function() {        ");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("$(this).parent().find(\'ul\').slideToggle();      ");
        _builder.newLine();
        _builder.append("});");
        _builder.newLine();
      }
    }
    {
      boolean _isPopover = this.isPopover();
      if (_isPopover) {
        _builder.append("$(\'.has-popover\').popover();");
        _builder.newLine();
      }
    }
    _builder.append("getTwitters(\'tweet\', { ");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("id: \'");
    String _twitterID = this.twitterID();
    _builder.append(_twitterID, "	");
    _builder.append("\', ");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("count: 5,");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("includeRT: true,");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("enableLinks: true, ");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("clearContents: true,");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("template : \'\"%text%\" - %time% by <a href=\"http://twitter.com/%user_screen_name%/statuses/%id_str%/\">@%user_screen_name%</a><br/><br/>\'");
    _builder.newLine();
    _builder.append("});");
    _builder.newLine();
    _builder.append("var po = document.createElement(\'script\'); po.type = \'text/javascript\'; po.async = true;");
    _builder.newLine();
    _builder.append("po.src = \'https://apis.google.com/js/plusone.js\';");
    _builder.newLine();
    _builder.append("var s = document.getElementsByTagName(\'script\')[0]; s.parentNode.insertBefore(po, s);");
    _builder.newLine();
    return _builder;
  }
  
  public String twitterID() {
    return "xtext";
  }
  
  protected boolean isPrettyPrint() {
    return false;
  }
  
  protected boolean isOutline() {
    return true;
  }
  
  protected boolean isPopover() {
    return true;
  }
  
  public Iterable<Pair<String,String>> topLevelMenu() {
    Pair<String,String> _mappedTo = Pair.<String, String>of("news.html", "News");
    Pair<String,String> _mappedTo_1 = Pair.<String, String>of("download.html", "Download");
    Pair<String,String> _mappedTo_2 = Pair.<String, String>of("7languages.html", "7 Languages");
    Pair<String,String> _mappedTo_3 = Pair.<String, String>of("documentation.html", "Documentation");
    Pair<String,String> _mappedTo_4 = Pair.<String, String>of("community.html", "Community");
    Pair<String,String> _mappedTo_5 = Pair.<String, String>of("http://xtend-lang.org", "Xtend");
    Pair<String,String> _mappedTo_6 = Pair.<String, String>of("http://www.eclipse.org", "Eclipse.org");
    ArrayList<Pair<String,String>> _newArrayList = CollectionLiterals.<Pair<String,String>>newArrayList(_mappedTo, _mappedTo_1, _mappedTo_2, _mappedTo_3, _mappedTo_4, _mappedTo_5, _mappedTo_6);
    return _newArrayList;
  }
  
  public CharSequence navBar() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("<!-- Navbar -->");
    _builder.newLine();
    _builder.append("<div class=\"navbar navbar-fixed-top\"");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("style=\"border-bottom: 1px solid #000;\">");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("<div class=\"navbar-inner\">");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("<div class=\"container\">");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("<a class=\"btn btn-navbar\" data-toggle=\"collapse\"");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("data-target=\".nav-collapse\"> <span class=\"icon-bar\"></span> <span");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("class=\"icon-bar\"></span> <span class=\"icon-bar\"></span>");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("</a> <a class=\"brand\" href=\"index.html\"></a>");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("<div class=\"nav-collapse collapse\" style=\"height: 0px;\">");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("<ul class=\"nav\">");
    _builder.newLine();
    {
      Iterable<Pair<String,String>> _pLevelMenu = this.topLevelMenu();
      for(final Pair<String,String> it : _pLevelMenu) {
        _builder.append("\t\t\t\t\t");
        _builder.append("<li ");
        {
          String _path = this.path();
          String _key = it.getKey();
          boolean _equals = Objects.equal(_path, _key);
          if (_equals) {
            _builder.append("class=\"active\"");
          }
        }
        _builder.append("><a href=\"");
        String _key_1 = it.getKey();
        _builder.append(_key_1, "					");
        _builder.append("\">");
        String _value = it.getValue();
        _builder.append(_value, "					");
        _builder.append("</a></li>");
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.append("\t\t\t\t");
    _builder.append("</ul>");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("</div>");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("<!--/.nav-collapse -->");
    _builder.newLine();
    _builder.append("\t        ");
    _builder.append("<div class=\"btn-group pull-right\">");
    _builder.newLine();
    _builder.append("\t          ");
    _builder.append("<g:plusone href=\"");
    String _plusoneURL = this.plusoneURL();
    _builder.append(_plusoneURL, "	          ");
    _builder.append("\"></g:plusone>");
    _builder.newLineIfNotEmpty();
    _builder.append("\t        ");
    _builder.append("</div>");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("</div>");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("</div>");
    _builder.newLine();
    _builder.append("</div>");
    _builder.newLine();
    _builder.append("<!-- Navbar End -->");
    _builder.newLine();
    return _builder;
  }
  
  public String plusoneURL() {
    return "http://www.xtext.org";
  }
  
  public CharSequence quickLinksAndTweets() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("<div id=\"extra\">");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("<div class=\"inner\">");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("<div class=\"container\">");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("<div class=\"row\">");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("<div class=\"span6\">");
    _builder.newLine();
    _builder.append("\t\t\t\t\t");
    _builder.append("<h3>Quick Links</h3>");
    _builder.newLine();
    _builder.append("\t\t\t\t\t");
    _builder.append("<ul class=\"footer-links clearfix\">");
    _builder.newLine();
    _builder.append("\t\t\t\t\t\t");
    _builder.append("<li><a href=\"http://www.eclipse.org/legal/privacy.php\">Privacy Policy</a></li>");
    _builder.newLine();
    _builder.append("\t\t\t\t\t\t");
    _builder.append("<li><a href=\"http://www.eclipse.org/legal/termsofuse.php\">Terms of Use</a></li>");
    _builder.newLine();
    _builder.append("\t\t\t\t\t\t");
    _builder.append("<li><a href=\"http://www.eclipse.org/legal/copyright.php\">Copyright Agent</a></li>");
    _builder.newLine();
    _builder.append("\t\t\t\t\t\t");
    _builder.append("<li><a href=\"http://www.eclipse.org/legal/\">Legal</a></li>");
    _builder.newLine();
    _builder.append("\t\t\t\t\t");
    _builder.append("</ul>");
    _builder.newLine();
    _builder.append("\t\t\t\t\t");
    _builder.append("<ul class=\"footer-links clearfix\">");
    _builder.newLine();
    _builder.append("      \t\t\t");
    _builder.append("<li><a href=\"http://www.eclipse.org\">Eclipse Home</a></li>");
    _builder.newLine();
    _builder.append("\t\t\t\t\t\t");
    _builder.append("<li><a href=\"http://marketplace.eclipse.org/\">Market Place</a></li>");
    _builder.newLine();
    _builder.append("\t\t\t\t\t\t");
    _builder.append("<li><a href=\"http://live.eclipse.org/\">Eclipse Live</a></li>");
    _builder.newLine();
    _builder.append("\t\t\t\t\t\t");
    _builder.append("<li><a href=\"http://www.planeteclipse.org/\">Eclipse Planet</a></li>");
    _builder.newLine();
    _builder.append("\t\t\t\t\t");
    _builder.append("</ul>");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("</div>");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("<div class=\"span6\">");
    _builder.newLine();
    _builder.append("\t\t\t\t\t");
    _builder.append("<h3><a href=\"https://twitter.com/#!/");
    String _twitterID = this.twitterID();
    _builder.append(_twitterID, "					");
    _builder.append("\" style=\"color: white;\">");
    String _twitterID_1 = this.twitterID();
    String _firstUpper = StringExtensions.toFirstUpper(_twitterID_1);
    _builder.append(_firstUpper, "					");
    _builder.append("</a> on Twitter</h3>");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t\t\t\t");
    _builder.append("<br />");
    _builder.newLine();
    _builder.append("\t\t\t\t\t");
    _builder.append("<div id=\"tweet\">");
    _builder.newLine();
    _builder.append("\t\t\t\t\t\t");
    _builder.append("<p>Please wait while my tweets load</p>");
    _builder.newLine();
    _builder.append("\t\t\t\t\t\t");
    _builder.append("<p>");
    _builder.newLine();
    _builder.append("\t\t\t\t\t\t\t");
    _builder.append("<a href=\"http://twitter.com/rem\">If you can\'t wait - check");
    _builder.newLine();
    _builder.append("\t\t\t\t\t\t\t\t");
    _builder.append("out what I\'ve been twittering</a>");
    _builder.newLine();
    _builder.append("\t\t\t\t\t\t");
    _builder.append("</p>");
    _builder.newLine();
    _builder.append("\t\t\t\t\t");
    _builder.append("</div>");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("</div>");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("</div>");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("</div>");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("</div>");
    _builder.newLine();
    _builder.append("</div>");
    _builder.newLine();
    return _builder;
  }
  
  public CharSequence javaScriptAtTheEnd() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("<!-- Le javascript");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("================================================== -->");
    _builder.newLine();
    _builder.append("<!-- Placed at the end of the document so the pages load faster -->");
    _builder.newLine();
    _builder.newLine();
    _builder.append("<script src=\"js/bootstrap-transition.js\"></script>");
    _builder.newLine();
    _builder.append("<script src=\"js/bootstrap-alert.js\"></script>");
    _builder.newLine();
    _builder.append("<script src=\"js/bootstrap-modal.js\"></script>");
    _builder.newLine();
    _builder.append("<script src=\"js/bootstrap-dropdown.js\"></script>");
    _builder.newLine();
    _builder.append("<script src=\"js/bootstrap-scrollspy.js\"></script>");
    _builder.newLine();
    _builder.append("<script src=\"js/bootstrap-tab.js\"></script>");
    _builder.newLine();
    _builder.append("<script src=\"js/bootstrap-tooltip.js\"></script>");
    _builder.newLine();
    _builder.append("<script src=\"js/bootstrap-popover.js\"></script>");
    _builder.newLine();
    _builder.append("<script src=\"js/bootstrap-button.js\"></script>");
    _builder.newLine();
    _builder.append("<script src=\"js/bootstrap-collapse.js\"></script>");
    _builder.newLine();
    _builder.append("<script src=\"js/bootstrap-carousel.js\"></script>");
    _builder.newLine();
    _builder.append("<script src=\"js/bootstrap-typeahead.js\"></script>");
    _builder.newLine();
    _builder.newLine();
    {
      boolean _isPrettyPrint = this.isPrettyPrint();
      if (_isPrettyPrint) {
        _builder.append("<!-- include pretty-print files -->");
        _builder.newLine();
        _builder.append("<script type=\"text/javascript\" src=\"google-code-prettify/prettify.js\"></script>");
        _builder.newLine();
        _builder.append("<script type=\"text/javascript\" src=\"google-code-prettify/lang-xtend.js\"></script>");
        _builder.newLine();
      }
    }
    _builder.newLine();
    _builder.append("<!-- Include the plug-in -->");
    _builder.newLine();
    _builder.append("<script src=\"js/jquery.easing.1.3.js\" type=\"text/javascript\"></script>");
    _builder.newLine();
    _builder.append("<script src=\"js/custom.js\" type=\"text/javascript\"></script>");
    _builder.newLine();
    return _builder;
  }
  
  public CharSequence stylesheets() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("<!--  styles -->");
    _builder.newLine();
    _builder.append("<!-- Le HTML5 shim, for IE6-8 support of HTML5 elements -->");
    _builder.newLine();
    _builder.append("<!--[if lt IE 9]>");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("<script src=\"http://html5shim.googlecode.com/svn/trunk/html5.js\"></script>");
    _builder.newLine();
    _builder.append("<![endif]-->");
    _builder.newLine();
    _builder.newLine();
    _builder.append("<!-- Le fav and touch icons -->");
    _builder.newLine();
    _builder.newLine();
    _builder.append("<link rel=\"shortcut icon\" href=\"images/favicon.png\">");
    _builder.newLine();
    _builder.newLine();
    _builder.append("<link href=\"css/bootstrap.css\" rel=\"stylesheet\" type=\'text/css\'>");
    _builder.newLine();
    _builder.append("<link href=\"css/bootstrap-responsive.css\" rel=\"stylesheet\" type=\'text/css\'>");
    _builder.newLine();
    _builder.append("<link href=\"css/style.css\" rel=\"stylesheet\" type=\'text/css\'>");
    _builder.newLine();
    _builder.append("<link href=\"css/shield-responsive.css\" rel=\"stylesheet\" type=\'text/css\'>");
    _builder.newLine();
    _builder.append("<link href=\'css/fonts.css\' rel=\'stylesheet\' type=\'text/css\'>");
    _builder.newLine();
    _builder.append("<link href=\"css/prettyPhoto.css\" rel=\"stylesheet\" media=\"screen\" type=\'text/css\'>");
    _builder.newLine();
    _builder.append("<link href=\"google-code-prettify/prettify.css\" type=\"text/css\" rel=\"stylesheet\"/>");
    _builder.newLine();
    _builder.append("<!--[if lt IE 9]>");
    _builder.newLine();
    _builder.append("<link href=\"css/iebugs.css\" rel=\"stylesheet\" type=\'text/css\'>");
    _builder.newLine();
    _builder.append("<![endif]-->");
    _builder.newLine();
    return _builder;
  }
  
  public CharSequence headline(final String title) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("<div id=\"header_wrapper\" class=\"container\" >");
    _builder.newLine();
    _builder.append("</div>");
    _builder.newLine();
    return _builder;
  }
}
