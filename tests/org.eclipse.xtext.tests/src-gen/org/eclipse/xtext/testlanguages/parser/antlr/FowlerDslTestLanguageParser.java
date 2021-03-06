/*
* generated by Xtext
*/
package org.eclipse.xtext.testlanguages.parser.antlr;

import com.google.inject.Inject;

import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.testlanguages.services.FowlerDslTestLanguageGrammarAccess;

public class FowlerDslTestLanguageParser extends org.eclipse.xtext.parser.antlr.AbstractAntlrParser {
	
	@Inject
	private FowlerDslTestLanguageGrammarAccess grammarAccess;
	
	@Override
	protected void setInitialHiddenTokens(XtextTokenStream tokenStream) {
		tokenStream.setInitialHiddenTokens("RULE_WS", "RULE_ML_COMMENT", "RULE_SL_COMMENT");
	}
	
	@Override
	protected org.eclipse.xtext.testlanguages.parser.antlr.internal.InternalFowlerDslTestLanguageParser createParser(XtextTokenStream stream) {
		return new org.eclipse.xtext.testlanguages.parser.antlr.internal.InternalFowlerDslTestLanguageParser(stream, getGrammarAccess());
	}
	
	@Override 
	protected String getDefaultRuleName() {
		return "Statemachine";
	}
	
	public FowlerDslTestLanguageGrammarAccess getGrammarAccess() {
		return this.grammarAccess;
	}
	
	public void setGrammarAccess(FowlerDslTestLanguageGrammarAccess grammarAccess) {
		this.grammarAccess = grammarAccess;
	}
	
}
