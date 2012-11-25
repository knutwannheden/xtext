package generator;

import generator.Community;
import generator.Documentation;
import generator.Download;
import generator.Index;
import generator.News;
import generator.Resource;
import generator.SevenLanguages;
import generator.SevenLanguagesDocumentation;
import java.io.File;
import org.eclipse.xtend.core.XtendStandaloneSetup;
import org.eclipse.xtext.xbase.lib.InputOutput;

@SuppressWarnings("all")
public class Generator {
  public static void main(final String[] args) {
    System.setProperty("java.awt.headless", "true");
    XtendStandaloneSetup.doSetup();
    File _file = new File("website");
    final File out = _file;
    Index _index = new Index();
    News _news = new News();
    Download _download = new Download();
    SevenLanguages _sevenLanguages = new SevenLanguages();
    SevenLanguagesDocumentation _sevenLanguagesDocumentation = new SevenLanguagesDocumentation();
    Documentation _documentation = new Documentation();
    Community _community = new Community();
    Generator.generateFiles(out, _index, _news, _download, _sevenLanguages, _sevenLanguagesDocumentation, _documentation, _community);
    InputOutput.<String>println("Done.");
  }
  
  public static void generateFiles(final File targetDir, final Resource... sites) {
    for (final Resource site : sites) {
      site.generateTo(targetDir);
    }
  }
}
