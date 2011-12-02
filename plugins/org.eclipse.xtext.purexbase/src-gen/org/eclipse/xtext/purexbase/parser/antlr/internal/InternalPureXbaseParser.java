package org.eclipse.xtext.purexbase.parser.antlr.internal; 

import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.AbstractInternalAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.parser.antlr.AntlrDatatypeRuleToken;
import org.eclipse.xtext.purexbase.services.PureXbaseGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
@SuppressWarnings("all")
public class InternalPureXbaseParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_INT", "RULE_STRING", "RULE_ID", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "';'", "'import'", "'.*'", "'='", "'+='", "'||'", "'&&'", "'=='", "'!='", "'instanceof'", "'>='", "'<='", "'>'", "'<'", "'->'", "'..'", "'+'", "'-'", "'*'", "'**'", "'/'", "'%'", "'!'", "'as'", "'.'", "'?.'", "'*.'", "','", "'('", "')'", "'['", "'|'", "']'", "'if'", "'else'", "'switch'", "':'", "'{'", "'default'", "'}'", "'case'", "'for'", "'while'", "'do'", "'var'", "'val'", "'super'", "'::'", "'new'", "'false'", "'true'", "'null'", "'typeof'", "'throw'", "'return'", "'try'", "'finally'", "'catch'", "'=>'", "'?'", "'extends'", "'&'"
    };
    public static final int T__68=68;
    public static final int T__69=69;
    public static final int RULE_ID=6;
    public static final int T__66=66;
    public static final int T__67=67;
    public static final int T__64=64;
    public static final int T__29=29;
    public static final int T__65=65;
    public static final int T__28=28;
    public static final int T__62=62;
    public static final int T__27=27;
    public static final int T__63=63;
    public static final int T__26=26;
    public static final int T__25=25;
    public static final int T__24=24;
    public static final int T__23=23;
    public static final int T__22=22;
    public static final int RULE_ANY_OTHER=10;
    public static final int T__21=21;
    public static final int T__20=20;
    public static final int T__61=61;
    public static final int T__60=60;
    public static final int EOF=-1;
    public static final int T__55=55;
    public static final int T__56=56;
    public static final int T__19=19;
    public static final int T__57=57;
    public static final int T__58=58;
    public static final int T__51=51;
    public static final int T__16=16;
    public static final int T__52=52;
    public static final int T__15=15;
    public static final int T__53=53;
    public static final int T__18=18;
    public static final int T__54=54;
    public static final int T__17=17;
    public static final int T__12=12;
    public static final int T__11=11;
    public static final int T__14=14;
    public static final int T__13=13;
    public static final int T__59=59;
    public static final int RULE_INT=4;
    public static final int T__50=50;
    public static final int T__42=42;
    public static final int T__43=43;
    public static final int T__40=40;
    public static final int T__41=41;
    public static final int T__46=46;
    public static final int T__47=47;
    public static final int T__44=44;
    public static final int T__45=45;
    public static final int T__48=48;
    public static final int T__49=49;
    public static final int RULE_SL_COMMENT=8;
    public static final int RULE_ML_COMMENT=7;
    public static final int T__30=30;
    public static final int T__31=31;
    public static final int RULE_STRING=5;
    public static final int T__32=32;
    public static final int T__71=71;
    public static final int T__33=33;
    public static final int T__72=72;
    public static final int T__34=34;
    public static final int T__35=35;
    public static final int T__70=70;
    public static final int T__36=36;
    public static final int T__37=37;
    public static final int T__38=38;
    public static final int T__39=39;
    public static final int RULE_WS=9;

    // delegates
    // delegators


        public InternalPureXbaseParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalPureXbaseParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalPureXbaseParser.tokenNames; }
    public String getGrammarFileName() { return "../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g"; }



     	private PureXbaseGrammarAccess grammarAccess;
     	
        public InternalPureXbaseParser(TokenStream input, PureXbaseGrammarAccess grammarAccess) {
            this(input);
            this.grammarAccess = grammarAccess;
            registerRules(grammarAccess.getGrammar());
        }
        
        @Override
        protected String getFirstRuleName() {
        	return "Model";	
       	}
       	
       	@Override
       	protected PureXbaseGrammarAccess getGrammarAccess() {
       		return grammarAccess;
       	}



    // $ANTLR start "entryRuleModel"
    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:67:1: entryRuleModel returns [EObject current=null] : iv_ruleModel= ruleModel EOF ;
    public final EObject entryRuleModel() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleModel = null;


        try {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:68:2: (iv_ruleModel= ruleModel EOF )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:69:2: iv_ruleModel= ruleModel EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getModelRule()); 
            }
            pushFollow(FOLLOW_ruleModel_in_entryRuleModel75);
            iv_ruleModel=ruleModel();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleModel; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleModel85); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleModel"


    // $ANTLR start "ruleModel"
    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:76:1: ruleModel returns [EObject current=null] : ( (lv_block_0_0= ruleSpecialBlockExpression ) ) ;
    public final EObject ruleModel() throws RecognitionException {
        EObject current = null;

        EObject lv_block_0_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:79:28: ( ( (lv_block_0_0= ruleSpecialBlockExpression ) ) )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:80:1: ( (lv_block_0_0= ruleSpecialBlockExpression ) )
            {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:80:1: ( (lv_block_0_0= ruleSpecialBlockExpression ) )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:81:1: (lv_block_0_0= ruleSpecialBlockExpression )
            {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:81:1: (lv_block_0_0= ruleSpecialBlockExpression )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:82:3: lv_block_0_0= ruleSpecialBlockExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getModelAccess().getBlockSpecialBlockExpressionParserRuleCall_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleSpecialBlockExpression_in_ruleModel130);
            lv_block_0_0=ruleSpecialBlockExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getModelRule());
              	        }
                     		set(
                     			current, 
                     			"block",
                      		lv_block_0_0, 
                      		"SpecialBlockExpression");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleModel"


    // $ANTLR start "entryRuleSpecialBlockExpression"
    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:106:1: entryRuleSpecialBlockExpression returns [EObject current=null] : iv_ruleSpecialBlockExpression= ruleSpecialBlockExpression EOF ;
    public final EObject entryRuleSpecialBlockExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSpecialBlockExpression = null;


        try {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:107:2: (iv_ruleSpecialBlockExpression= ruleSpecialBlockExpression EOF )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:108:2: iv_ruleSpecialBlockExpression= ruleSpecialBlockExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getSpecialBlockExpressionRule()); 
            }
            pushFollow(FOLLOW_ruleSpecialBlockExpression_in_entryRuleSpecialBlockExpression165);
            iv_ruleSpecialBlockExpression=ruleSpecialBlockExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleSpecialBlockExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleSpecialBlockExpression175); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleSpecialBlockExpression"


    // $ANTLR start "ruleSpecialBlockExpression"
    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:115:1: ruleSpecialBlockExpression returns [EObject current=null] : ( () ( ( ( (lv_expressions_1_0= ruleXExpressionInsideBlock ) ) | ( (lv_imports_2_0= ruleImport ) ) ) (otherlv_3= ';' )? )* ) ;
    public final EObject ruleSpecialBlockExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_3=null;
        EObject lv_expressions_1_0 = null;

        EObject lv_imports_2_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:118:28: ( ( () ( ( ( (lv_expressions_1_0= ruleXExpressionInsideBlock ) ) | ( (lv_imports_2_0= ruleImport ) ) ) (otherlv_3= ';' )? )* ) )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:119:1: ( () ( ( ( (lv_expressions_1_0= ruleXExpressionInsideBlock ) ) | ( (lv_imports_2_0= ruleImport ) ) ) (otherlv_3= ';' )? )* )
            {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:119:1: ( () ( ( ( (lv_expressions_1_0= ruleXExpressionInsideBlock ) ) | ( (lv_imports_2_0= ruleImport ) ) ) (otherlv_3= ';' )? )* )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:119:2: () ( ( ( (lv_expressions_1_0= ruleXExpressionInsideBlock ) ) | ( (lv_imports_2_0= ruleImport ) ) ) (otherlv_3= ';' )? )*
            {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:119:2: ()
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:120:5: 
            {
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getSpecialBlockExpressionAccess().getSpecialBlockExpressionAction_0(),
                          current);
                  
            }

            }

            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:125:2: ( ( ( (lv_expressions_1_0= ruleXExpressionInsideBlock ) ) | ( (lv_imports_2_0= ruleImport ) ) ) (otherlv_3= ';' )? )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( ((LA3_0>=RULE_INT && LA3_0<=RULE_ID)||LA3_0==12||LA3_0==24||(LA3_0>=27 && LA3_0<=28)||LA3_0==33||LA3_0==39||LA3_0==41||LA3_0==44||LA3_0==46||LA3_0==48||(LA3_0>=52 && LA3_0<=57)||(LA3_0>=59 && LA3_0<=66)) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:125:3: ( ( (lv_expressions_1_0= ruleXExpressionInsideBlock ) ) | ( (lv_imports_2_0= ruleImport ) ) ) (otherlv_3= ';' )?
            	    {
            	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:125:3: ( ( (lv_expressions_1_0= ruleXExpressionInsideBlock ) ) | ( (lv_imports_2_0= ruleImport ) ) )
            	    int alt1=2;
            	    int LA1_0 = input.LA(1);

            	    if ( ((LA1_0>=RULE_INT && LA1_0<=RULE_ID)||LA1_0==24||(LA1_0>=27 && LA1_0<=28)||LA1_0==33||LA1_0==39||LA1_0==41||LA1_0==44||LA1_0==46||LA1_0==48||(LA1_0>=52 && LA1_0<=57)||(LA1_0>=59 && LA1_0<=66)) ) {
            	        alt1=1;
            	    }
            	    else if ( (LA1_0==12) ) {
            	        alt1=2;
            	    }
            	    else {
            	        if (state.backtracking>0) {state.failed=true; return current;}
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 1, 0, input);

            	        throw nvae;
            	    }
            	    switch (alt1) {
            	        case 1 :
            	            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:125:4: ( (lv_expressions_1_0= ruleXExpressionInsideBlock ) )
            	            {
            	            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:125:4: ( (lv_expressions_1_0= ruleXExpressionInsideBlock ) )
            	            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:126:1: (lv_expressions_1_0= ruleXExpressionInsideBlock )
            	            {
            	            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:126:1: (lv_expressions_1_0= ruleXExpressionInsideBlock )
            	            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:127:3: lv_expressions_1_0= ruleXExpressionInsideBlock
            	            {
            	            if ( state.backtracking==0 ) {
            	               
            	              	        newCompositeNode(grammarAccess.getSpecialBlockExpressionAccess().getExpressionsXExpressionInsideBlockParserRuleCall_1_0_0_0()); 
            	              	    
            	            }
            	            pushFollow(FOLLOW_ruleXExpressionInsideBlock_in_ruleSpecialBlockExpression232);
            	            lv_expressions_1_0=ruleXExpressionInsideBlock();

            	            state._fsp--;
            	            if (state.failed) return current;
            	            if ( state.backtracking==0 ) {

            	              	        if (current==null) {
            	              	            current = createModelElementForParent(grammarAccess.getSpecialBlockExpressionRule());
            	              	        }
            	                     		add(
            	                     			current, 
            	                     			"expressions",
            	                      		lv_expressions_1_0, 
            	                      		"XExpressionInsideBlock");
            	              	        afterParserOrEnumRuleCall();
            	              	    
            	            }

            	            }


            	            }


            	            }
            	            break;
            	        case 2 :
            	            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:144:6: ( (lv_imports_2_0= ruleImport ) )
            	            {
            	            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:144:6: ( (lv_imports_2_0= ruleImport ) )
            	            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:145:1: (lv_imports_2_0= ruleImport )
            	            {
            	            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:145:1: (lv_imports_2_0= ruleImport )
            	            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:146:3: lv_imports_2_0= ruleImport
            	            {
            	            if ( state.backtracking==0 ) {
            	               
            	              	        newCompositeNode(grammarAccess.getSpecialBlockExpressionAccess().getImportsImportParserRuleCall_1_0_1_0()); 
            	              	    
            	            }
            	            pushFollow(FOLLOW_ruleImport_in_ruleSpecialBlockExpression259);
            	            lv_imports_2_0=ruleImport();

            	            state._fsp--;
            	            if (state.failed) return current;
            	            if ( state.backtracking==0 ) {

            	              	        if (current==null) {
            	              	            current = createModelElementForParent(grammarAccess.getSpecialBlockExpressionRule());
            	              	        }
            	                     		add(
            	                     			current, 
            	                     			"imports",
            	                      		lv_imports_2_0, 
            	                      		"Import");
            	              	        afterParserOrEnumRuleCall();
            	              	    
            	            }

            	            }


            	            }


            	            }
            	            break;

            	    }

            	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:162:3: (otherlv_3= ';' )?
            	    int alt2=2;
            	    int LA2_0 = input.LA(1);

            	    if ( (LA2_0==11) ) {
            	        alt2=1;
            	    }
            	    switch (alt2) {
            	        case 1 :
            	            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:162:5: otherlv_3= ';'
            	            {
            	            otherlv_3=(Token)match(input,11,FOLLOW_11_in_ruleSpecialBlockExpression273); if (state.failed) return current;
            	            if ( state.backtracking==0 ) {

            	                  	newLeafNode(otherlv_3, grammarAccess.getSpecialBlockExpressionAccess().getSemicolonKeyword_1_1());
            	                  
            	            }

            	            }
            	            break;

            	    }


            	    }
            	    break;

            	default :
            	    break loop3;
                }
            } while (true);


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleSpecialBlockExpression"


    // $ANTLR start "entryRuleImport"
    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:174:1: entryRuleImport returns [EObject current=null] : iv_ruleImport= ruleImport EOF ;
    public final EObject entryRuleImport() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleImport = null;


        try {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:175:2: (iv_ruleImport= ruleImport EOF )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:176:2: iv_ruleImport= ruleImport EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getImportRule()); 
            }
            pushFollow(FOLLOW_ruleImport_in_entryRuleImport313);
            iv_ruleImport=ruleImport();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleImport; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleImport323); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleImport"


    // $ANTLR start "ruleImport"
    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:183:1: ruleImport returns [EObject current=null] : (otherlv_0= 'import' ( (lv_importedNamespace_1_0= ruleQualifiedNameWithWildCard ) ) ) ;
    public final EObject ruleImport() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        AntlrDatatypeRuleToken lv_importedNamespace_1_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:186:28: ( (otherlv_0= 'import' ( (lv_importedNamespace_1_0= ruleQualifiedNameWithWildCard ) ) ) )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:187:1: (otherlv_0= 'import' ( (lv_importedNamespace_1_0= ruleQualifiedNameWithWildCard ) ) )
            {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:187:1: (otherlv_0= 'import' ( (lv_importedNamespace_1_0= ruleQualifiedNameWithWildCard ) ) )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:187:3: otherlv_0= 'import' ( (lv_importedNamespace_1_0= ruleQualifiedNameWithWildCard ) )
            {
            otherlv_0=(Token)match(input,12,FOLLOW_12_in_ruleImport360); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getImportAccess().getImportKeyword_0());
                  
            }
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:191:1: ( (lv_importedNamespace_1_0= ruleQualifiedNameWithWildCard ) )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:192:1: (lv_importedNamespace_1_0= ruleQualifiedNameWithWildCard )
            {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:192:1: (lv_importedNamespace_1_0= ruleQualifiedNameWithWildCard )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:193:3: lv_importedNamespace_1_0= ruleQualifiedNameWithWildCard
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getImportAccess().getImportedNamespaceQualifiedNameWithWildCardParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleQualifiedNameWithWildCard_in_ruleImport381);
            lv_importedNamespace_1_0=ruleQualifiedNameWithWildCard();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getImportRule());
              	        }
                     		set(
                     			current, 
                     			"importedNamespace",
                      		lv_importedNamespace_1_0, 
                      		"QualifiedNameWithWildCard");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleImport"


    // $ANTLR start "entryRuleQualifiedNameWithWildCard"
    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:217:1: entryRuleQualifiedNameWithWildCard returns [String current=null] : iv_ruleQualifiedNameWithWildCard= ruleQualifiedNameWithWildCard EOF ;
    public final String entryRuleQualifiedNameWithWildCard() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleQualifiedNameWithWildCard = null;


        try {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:218:2: (iv_ruleQualifiedNameWithWildCard= ruleQualifiedNameWithWildCard EOF )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:219:2: iv_ruleQualifiedNameWithWildCard= ruleQualifiedNameWithWildCard EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getQualifiedNameWithWildCardRule()); 
            }
            pushFollow(FOLLOW_ruleQualifiedNameWithWildCard_in_entryRuleQualifiedNameWithWildCard418);
            iv_ruleQualifiedNameWithWildCard=ruleQualifiedNameWithWildCard();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleQualifiedNameWithWildCard.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleQualifiedNameWithWildCard429); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleQualifiedNameWithWildCard"


    // $ANTLR start "ruleQualifiedNameWithWildCard"
    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:226:1: ruleQualifiedNameWithWildCard returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_QualifiedName_0= ruleQualifiedName (kw= '.*' )? ) ;
    public final AntlrDatatypeRuleToken ruleQualifiedNameWithWildCard() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        AntlrDatatypeRuleToken this_QualifiedName_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:229:28: ( (this_QualifiedName_0= ruleQualifiedName (kw= '.*' )? ) )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:230:1: (this_QualifiedName_0= ruleQualifiedName (kw= '.*' )? )
            {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:230:1: (this_QualifiedName_0= ruleQualifiedName (kw= '.*' )? )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:231:5: this_QualifiedName_0= ruleQualifiedName (kw= '.*' )?
            {
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getQualifiedNameWithWildCardAccess().getQualifiedNameParserRuleCall_0()); 
                  
            }
            pushFollow(FOLLOW_ruleQualifiedName_in_ruleQualifiedNameWithWildCard476);
            this_QualifiedName_0=ruleQualifiedName();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              		current.merge(this_QualifiedName_0);
                  
            }
            if ( state.backtracking==0 ) {
               
                      afterParserOrEnumRuleCall();
                  
            }
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:241:1: (kw= '.*' )?
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==13) ) {
                alt4=1;
            }
            switch (alt4) {
                case 1 :
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:242:2: kw= '.*'
                    {
                    kw=(Token)match(input,13,FOLLOW_13_in_ruleQualifiedNameWithWildCard495); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getQualifiedNameWithWildCardAccess().getFullStopAsteriskKeyword_1()); 
                          
                    }

                    }
                    break;

            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleQualifiedNameWithWildCard"


    // $ANTLR start "entryRuleXExpression"
    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:255:1: entryRuleXExpression returns [EObject current=null] : iv_ruleXExpression= ruleXExpression EOF ;
    public final EObject entryRuleXExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXExpression = null;


        try {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:256:2: (iv_ruleXExpression= ruleXExpression EOF )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:257:2: iv_ruleXExpression= ruleXExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXExpressionRule()); 
            }
            pushFollow(FOLLOW_ruleXExpression_in_entryRuleXExpression537);
            iv_ruleXExpression=ruleXExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXExpression547); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleXExpression"


    // $ANTLR start "ruleXExpression"
    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:264:1: ruleXExpression returns [EObject current=null] : this_XAssignment_0= ruleXAssignment ;
    public final EObject ruleXExpression() throws RecognitionException {
        EObject current = null;

        EObject this_XAssignment_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:267:28: (this_XAssignment_0= ruleXAssignment )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:269:5: this_XAssignment_0= ruleXAssignment
            {
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getXExpressionAccess().getXAssignmentParserRuleCall()); 
                  
            }
            pushFollow(FOLLOW_ruleXAssignment_in_ruleXExpression593);
            this_XAssignment_0=ruleXAssignment();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                      current = this_XAssignment_0; 
                      afterParserOrEnumRuleCall();
                  
            }

            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleXExpression"


    // $ANTLR start "entryRuleXAssignment"
    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:285:1: entryRuleXAssignment returns [EObject current=null] : iv_ruleXAssignment= ruleXAssignment EOF ;
    public final EObject entryRuleXAssignment() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXAssignment = null;


        try {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:286:2: (iv_ruleXAssignment= ruleXAssignment EOF )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:287:2: iv_ruleXAssignment= ruleXAssignment EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXAssignmentRule()); 
            }
            pushFollow(FOLLOW_ruleXAssignment_in_entryRuleXAssignment627);
            iv_ruleXAssignment=ruleXAssignment();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXAssignment; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXAssignment637); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleXAssignment"


    // $ANTLR start "ruleXAssignment"
    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:294:1: ruleXAssignment returns [EObject current=null] : ( ( () ( ( ruleValidID ) ) ruleOpSingleAssign ( (lv_value_3_0= ruleXAssignment ) ) ) | (this_XOrExpression_4= ruleXOrExpression ( ( ( ( () ( ( ruleOpMultiAssign ) ) ) )=> ( () ( ( ruleOpMultiAssign ) ) ) ) ( (lv_rightOperand_7_0= ruleXAssignment ) ) )? ) ) ;
    public final EObject ruleXAssignment() throws RecognitionException {
        EObject current = null;

        EObject lv_value_3_0 = null;

        EObject this_XOrExpression_4 = null;

        EObject lv_rightOperand_7_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:297:28: ( ( ( () ( ( ruleValidID ) ) ruleOpSingleAssign ( (lv_value_3_0= ruleXAssignment ) ) ) | (this_XOrExpression_4= ruleXOrExpression ( ( ( ( () ( ( ruleOpMultiAssign ) ) ) )=> ( () ( ( ruleOpMultiAssign ) ) ) ) ( (lv_rightOperand_7_0= ruleXAssignment ) ) )? ) ) )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:298:1: ( ( () ( ( ruleValidID ) ) ruleOpSingleAssign ( (lv_value_3_0= ruleXAssignment ) ) ) | (this_XOrExpression_4= ruleXOrExpression ( ( ( ( () ( ( ruleOpMultiAssign ) ) ) )=> ( () ( ( ruleOpMultiAssign ) ) ) ) ( (lv_rightOperand_7_0= ruleXAssignment ) ) )? ) )
            {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:298:1: ( ( () ( ( ruleValidID ) ) ruleOpSingleAssign ( (lv_value_3_0= ruleXAssignment ) ) ) | (this_XOrExpression_4= ruleXOrExpression ( ( ( ( () ( ( ruleOpMultiAssign ) ) ) )=> ( () ( ( ruleOpMultiAssign ) ) ) ) ( (lv_rightOperand_7_0= ruleXAssignment ) ) )? ) )
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==RULE_ID) ) {
                int LA6_1 = input.LA(2);

                if ( (LA6_1==EOF||(LA6_1>=RULE_INT && LA6_1<=RULE_ID)||(LA6_1>=11 && LA6_1<=12)||(LA6_1>=15 && LA6_1<=41)||(LA6_1>=43 && LA6_1<=69)) ) {
                    alt6=2;
                }
                else if ( (LA6_1==14) ) {
                    alt6=1;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 6, 1, input);

                    throw nvae;
                }
            }
            else if ( ((LA6_0>=RULE_INT && LA6_0<=RULE_STRING)||LA6_0==24||(LA6_0>=27 && LA6_0<=28)||LA6_0==33||LA6_0==39||LA6_0==41||LA6_0==44||LA6_0==46||LA6_0==48||(LA6_0>=52 && LA6_0<=54)||LA6_0==57||(LA6_0>=59 && LA6_0<=66)) ) {
                alt6=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 6, 0, input);

                throw nvae;
            }
            switch (alt6) {
                case 1 :
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:298:2: ( () ( ( ruleValidID ) ) ruleOpSingleAssign ( (lv_value_3_0= ruleXAssignment ) ) )
                    {
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:298:2: ( () ( ( ruleValidID ) ) ruleOpSingleAssign ( (lv_value_3_0= ruleXAssignment ) ) )
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:298:3: () ( ( ruleValidID ) ) ruleOpSingleAssign ( (lv_value_3_0= ruleXAssignment ) )
                    {
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:298:3: ()
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:299:5: 
                    {
                    if ( state.backtracking==0 ) {

                              current = forceCreateModelElement(
                                  grammarAccess.getXAssignmentAccess().getXAssignmentAction_0_0(),
                                  current);
                          
                    }

                    }

                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:304:2: ( ( ruleValidID ) )
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:305:1: ( ruleValidID )
                    {
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:305:1: ( ruleValidID )
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:306:3: ruleValidID
                    {
                    if ( state.backtracking==0 ) {

                      			if (current==null) {
                      	            current = createModelElement(grammarAccess.getXAssignmentRule());
                      	        }
                              
                    }
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getXAssignmentAccess().getFeatureJvmIdentifiableElementCrossReference_0_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleValidID_in_ruleXAssignment695);
                    ruleValidID();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }

                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getXAssignmentAccess().getOpSingleAssignParserRuleCall_0_2()); 
                          
                    }
                    pushFollow(FOLLOW_ruleOpSingleAssign_in_ruleXAssignment711);
                    ruleOpSingleAssign();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              afterParserOrEnumRuleCall();
                          
                    }
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:327:1: ( (lv_value_3_0= ruleXAssignment ) )
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:328:1: (lv_value_3_0= ruleXAssignment )
                    {
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:328:1: (lv_value_3_0= ruleXAssignment )
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:329:3: lv_value_3_0= ruleXAssignment
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getXAssignmentAccess().getValueXAssignmentParserRuleCall_0_3_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleXAssignment_in_ruleXAssignment731);
                    lv_value_3_0=ruleXAssignment();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getXAssignmentRule());
                      	        }
                             		set(
                             			current, 
                             			"value",
                              		lv_value_3_0, 
                              		"XAssignment");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:346:6: (this_XOrExpression_4= ruleXOrExpression ( ( ( ( () ( ( ruleOpMultiAssign ) ) ) )=> ( () ( ( ruleOpMultiAssign ) ) ) ) ( (lv_rightOperand_7_0= ruleXAssignment ) ) )? )
                    {
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:346:6: (this_XOrExpression_4= ruleXOrExpression ( ( ( ( () ( ( ruleOpMultiAssign ) ) ) )=> ( () ( ( ruleOpMultiAssign ) ) ) ) ( (lv_rightOperand_7_0= ruleXAssignment ) ) )? )
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:347:5: this_XOrExpression_4= ruleXOrExpression ( ( ( ( () ( ( ruleOpMultiAssign ) ) ) )=> ( () ( ( ruleOpMultiAssign ) ) ) ) ( (lv_rightOperand_7_0= ruleXAssignment ) ) )?
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getXAssignmentAccess().getXOrExpressionParserRuleCall_1_0()); 
                          
                    }
                    pushFollow(FOLLOW_ruleXOrExpression_in_ruleXAssignment761);
                    this_XOrExpression_4=ruleXOrExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_XOrExpression_4; 
                              afterParserOrEnumRuleCall();
                          
                    }
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:355:1: ( ( ( ( () ( ( ruleOpMultiAssign ) ) ) )=> ( () ( ( ruleOpMultiAssign ) ) ) ) ( (lv_rightOperand_7_0= ruleXAssignment ) ) )?
                    int alt5=2;
                    int LA5_0 = input.LA(1);

                    if ( (LA5_0==15) ) {
                        int LA5_1 = input.LA(2);

                        if ( (synpred1_InternalPureXbase()) ) {
                            alt5=1;
                        }
                    }
                    switch (alt5) {
                        case 1 :
                            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:355:2: ( ( ( () ( ( ruleOpMultiAssign ) ) ) )=> ( () ( ( ruleOpMultiAssign ) ) ) ) ( (lv_rightOperand_7_0= ruleXAssignment ) )
                            {
                            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:355:2: ( ( ( () ( ( ruleOpMultiAssign ) ) ) )=> ( () ( ( ruleOpMultiAssign ) ) ) )
                            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:355:3: ( ( () ( ( ruleOpMultiAssign ) ) ) )=> ( () ( ( ruleOpMultiAssign ) ) )
                            {
                            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:360:6: ( () ( ( ruleOpMultiAssign ) ) )
                            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:360:7: () ( ( ruleOpMultiAssign ) )
                            {
                            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:360:7: ()
                            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:361:5: 
                            {
                            if ( state.backtracking==0 ) {

                                      current = forceCreateModelElementAndSet(
                                          grammarAccess.getXAssignmentAccess().getXBinaryOperationLeftOperandAction_1_1_0_0_0(),
                                          current);
                                  
                            }

                            }

                            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:366:2: ( ( ruleOpMultiAssign ) )
                            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:367:1: ( ruleOpMultiAssign )
                            {
                            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:367:1: ( ruleOpMultiAssign )
                            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:368:3: ruleOpMultiAssign
                            {
                            if ( state.backtracking==0 ) {

                              			if (current==null) {
                              	            current = createModelElement(grammarAccess.getXAssignmentRule());
                              	        }
                                      
                            }
                            if ( state.backtracking==0 ) {
                               
                              	        newCompositeNode(grammarAccess.getXAssignmentAccess().getFeatureJvmIdentifiableElementCrossReference_1_1_0_0_1_0()); 
                              	    
                            }
                            pushFollow(FOLLOW_ruleOpMultiAssign_in_ruleXAssignment814);
                            ruleOpMultiAssign();

                            state._fsp--;
                            if (state.failed) return current;
                            if ( state.backtracking==0 ) {
                               
                              	        afterParserOrEnumRuleCall();
                              	    
                            }

                            }


                            }


                            }


                            }

                            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:381:4: ( (lv_rightOperand_7_0= ruleXAssignment ) )
                            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:382:1: (lv_rightOperand_7_0= ruleXAssignment )
                            {
                            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:382:1: (lv_rightOperand_7_0= ruleXAssignment )
                            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:383:3: lv_rightOperand_7_0= ruleXAssignment
                            {
                            if ( state.backtracking==0 ) {
                               
                              	        newCompositeNode(grammarAccess.getXAssignmentAccess().getRightOperandXAssignmentParserRuleCall_1_1_1_0()); 
                              	    
                            }
                            pushFollow(FOLLOW_ruleXAssignment_in_ruleXAssignment837);
                            lv_rightOperand_7_0=ruleXAssignment();

                            state._fsp--;
                            if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              	        if (current==null) {
                              	            current = createModelElementForParent(grammarAccess.getXAssignmentRule());
                              	        }
                                     		set(
                                     			current, 
                                     			"rightOperand",
                                      		lv_rightOperand_7_0, 
                                      		"XAssignment");
                              	        afterParserOrEnumRuleCall();
                              	    
                            }

                            }


                            }


                            }
                            break;

                    }


                    }


                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleXAssignment"


    // $ANTLR start "entryRuleOpSingleAssign"
    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:407:1: entryRuleOpSingleAssign returns [String current=null] : iv_ruleOpSingleAssign= ruleOpSingleAssign EOF ;
    public final String entryRuleOpSingleAssign() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleOpSingleAssign = null;


        try {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:408:2: (iv_ruleOpSingleAssign= ruleOpSingleAssign EOF )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:409:2: iv_ruleOpSingleAssign= ruleOpSingleAssign EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getOpSingleAssignRule()); 
            }
            pushFollow(FOLLOW_ruleOpSingleAssign_in_entryRuleOpSingleAssign877);
            iv_ruleOpSingleAssign=ruleOpSingleAssign();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleOpSingleAssign.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleOpSingleAssign888); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleOpSingleAssign"


    // $ANTLR start "ruleOpSingleAssign"
    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:416:1: ruleOpSingleAssign returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : kw= '=' ;
    public final AntlrDatatypeRuleToken ruleOpSingleAssign() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:419:28: (kw= '=' )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:421:2: kw= '='
            {
            kw=(Token)match(input,14,FOLLOW_14_in_ruleOpSingleAssign925); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                      current.merge(kw);
                      newLeafNode(kw, grammarAccess.getOpSingleAssignAccess().getEqualsSignKeyword()); 
                  
            }

            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleOpSingleAssign"


    // $ANTLR start "entryRuleOpMultiAssign"
    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:434:1: entryRuleOpMultiAssign returns [String current=null] : iv_ruleOpMultiAssign= ruleOpMultiAssign EOF ;
    public final String entryRuleOpMultiAssign() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleOpMultiAssign = null;


        try {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:435:2: (iv_ruleOpMultiAssign= ruleOpMultiAssign EOF )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:436:2: iv_ruleOpMultiAssign= ruleOpMultiAssign EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getOpMultiAssignRule()); 
            }
            pushFollow(FOLLOW_ruleOpMultiAssign_in_entryRuleOpMultiAssign965);
            iv_ruleOpMultiAssign=ruleOpMultiAssign();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleOpMultiAssign.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleOpMultiAssign976); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleOpMultiAssign"


    // $ANTLR start "ruleOpMultiAssign"
    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:443:1: ruleOpMultiAssign returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : kw= '+=' ;
    public final AntlrDatatypeRuleToken ruleOpMultiAssign() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:446:28: (kw= '+=' )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:448:2: kw= '+='
            {
            kw=(Token)match(input,15,FOLLOW_15_in_ruleOpMultiAssign1013); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                      current.merge(kw);
                      newLeafNode(kw, grammarAccess.getOpMultiAssignAccess().getPlusSignEqualsSignKeyword()); 
                  
            }

            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleOpMultiAssign"


    // $ANTLR start "entryRuleXOrExpression"
    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:461:1: entryRuleXOrExpression returns [EObject current=null] : iv_ruleXOrExpression= ruleXOrExpression EOF ;
    public final EObject entryRuleXOrExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXOrExpression = null;


        try {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:462:2: (iv_ruleXOrExpression= ruleXOrExpression EOF )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:463:2: iv_ruleXOrExpression= ruleXOrExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXOrExpressionRule()); 
            }
            pushFollow(FOLLOW_ruleXOrExpression_in_entryRuleXOrExpression1052);
            iv_ruleXOrExpression=ruleXOrExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXOrExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXOrExpression1062); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleXOrExpression"


    // $ANTLR start "ruleXOrExpression"
    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:470:1: ruleXOrExpression returns [EObject current=null] : (this_XAndExpression_0= ruleXAndExpression ( ( ( ( () ( ( ruleOpOr ) ) ) )=> ( () ( ( ruleOpOr ) ) ) ) ( (lv_rightOperand_3_0= ruleXAndExpression ) ) )* ) ;
    public final EObject ruleXOrExpression() throws RecognitionException {
        EObject current = null;

        EObject this_XAndExpression_0 = null;

        EObject lv_rightOperand_3_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:473:28: ( (this_XAndExpression_0= ruleXAndExpression ( ( ( ( () ( ( ruleOpOr ) ) ) )=> ( () ( ( ruleOpOr ) ) ) ) ( (lv_rightOperand_3_0= ruleXAndExpression ) ) )* ) )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:474:1: (this_XAndExpression_0= ruleXAndExpression ( ( ( ( () ( ( ruleOpOr ) ) ) )=> ( () ( ( ruleOpOr ) ) ) ) ( (lv_rightOperand_3_0= ruleXAndExpression ) ) )* )
            {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:474:1: (this_XAndExpression_0= ruleXAndExpression ( ( ( ( () ( ( ruleOpOr ) ) ) )=> ( () ( ( ruleOpOr ) ) ) ) ( (lv_rightOperand_3_0= ruleXAndExpression ) ) )* )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:475:5: this_XAndExpression_0= ruleXAndExpression ( ( ( ( () ( ( ruleOpOr ) ) ) )=> ( () ( ( ruleOpOr ) ) ) ) ( (lv_rightOperand_3_0= ruleXAndExpression ) ) )*
            {
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getXOrExpressionAccess().getXAndExpressionParserRuleCall_0()); 
                  
            }
            pushFollow(FOLLOW_ruleXAndExpression_in_ruleXOrExpression1109);
            this_XAndExpression_0=ruleXAndExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                      current = this_XAndExpression_0; 
                      afterParserOrEnumRuleCall();
                  
            }
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:483:1: ( ( ( ( () ( ( ruleOpOr ) ) ) )=> ( () ( ( ruleOpOr ) ) ) ) ( (lv_rightOperand_3_0= ruleXAndExpression ) ) )*
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( (LA7_0==16) ) {
                    int LA7_2 = input.LA(2);

                    if ( (synpred2_InternalPureXbase()) ) {
                        alt7=1;
                    }


                }


                switch (alt7) {
            	case 1 :
            	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:483:2: ( ( ( () ( ( ruleOpOr ) ) ) )=> ( () ( ( ruleOpOr ) ) ) ) ( (lv_rightOperand_3_0= ruleXAndExpression ) )
            	    {
            	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:483:2: ( ( ( () ( ( ruleOpOr ) ) ) )=> ( () ( ( ruleOpOr ) ) ) )
            	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:483:3: ( ( () ( ( ruleOpOr ) ) ) )=> ( () ( ( ruleOpOr ) ) )
            	    {
            	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:488:6: ( () ( ( ruleOpOr ) ) )
            	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:488:7: () ( ( ruleOpOr ) )
            	    {
            	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:488:7: ()
            	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:489:5: 
            	    {
            	    if ( state.backtracking==0 ) {

            	              current = forceCreateModelElementAndSet(
            	                  grammarAccess.getXOrExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0(),
            	                  current);
            	          
            	    }

            	    }

            	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:494:2: ( ( ruleOpOr ) )
            	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:495:1: ( ruleOpOr )
            	    {
            	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:495:1: ( ruleOpOr )
            	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:496:3: ruleOpOr
            	    {
            	    if ( state.backtracking==0 ) {

            	      			if (current==null) {
            	      	            current = createModelElement(grammarAccess.getXOrExpressionRule());
            	      	        }
            	              
            	    }
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getXOrExpressionAccess().getFeatureJvmIdentifiableElementCrossReference_1_0_0_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleOpOr_in_ruleXOrExpression1162);
            	    ruleOpOr();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {
            	       
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }


            	    }


            	    }

            	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:509:4: ( (lv_rightOperand_3_0= ruleXAndExpression ) )
            	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:510:1: (lv_rightOperand_3_0= ruleXAndExpression )
            	    {
            	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:510:1: (lv_rightOperand_3_0= ruleXAndExpression )
            	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:511:3: lv_rightOperand_3_0= ruleXAndExpression
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getXOrExpressionAccess().getRightOperandXAndExpressionParserRuleCall_1_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleXAndExpression_in_ruleXOrExpression1185);
            	    lv_rightOperand_3_0=ruleXAndExpression();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getXOrExpressionRule());
            	      	        }
            	             		set(
            	             			current, 
            	             			"rightOperand",
            	              		lv_rightOperand_3_0, 
            	              		"XAndExpression");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop7;
                }
            } while (true);


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleXOrExpression"


    // $ANTLR start "entryRuleOpOr"
    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:535:1: entryRuleOpOr returns [String current=null] : iv_ruleOpOr= ruleOpOr EOF ;
    public final String entryRuleOpOr() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleOpOr = null;


        try {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:536:2: (iv_ruleOpOr= ruleOpOr EOF )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:537:2: iv_ruleOpOr= ruleOpOr EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getOpOrRule()); 
            }
            pushFollow(FOLLOW_ruleOpOr_in_entryRuleOpOr1224);
            iv_ruleOpOr=ruleOpOr();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleOpOr.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleOpOr1235); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleOpOr"


    // $ANTLR start "ruleOpOr"
    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:544:1: ruleOpOr returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : kw= '||' ;
    public final AntlrDatatypeRuleToken ruleOpOr() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:547:28: (kw= '||' )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:549:2: kw= '||'
            {
            kw=(Token)match(input,16,FOLLOW_16_in_ruleOpOr1272); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                      current.merge(kw);
                      newLeafNode(kw, grammarAccess.getOpOrAccess().getVerticalLineVerticalLineKeyword()); 
                  
            }

            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleOpOr"


    // $ANTLR start "entryRuleXAndExpression"
    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:562:1: entryRuleXAndExpression returns [EObject current=null] : iv_ruleXAndExpression= ruleXAndExpression EOF ;
    public final EObject entryRuleXAndExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXAndExpression = null;


        try {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:563:2: (iv_ruleXAndExpression= ruleXAndExpression EOF )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:564:2: iv_ruleXAndExpression= ruleXAndExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXAndExpressionRule()); 
            }
            pushFollow(FOLLOW_ruleXAndExpression_in_entryRuleXAndExpression1311);
            iv_ruleXAndExpression=ruleXAndExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXAndExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXAndExpression1321); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleXAndExpression"


    // $ANTLR start "ruleXAndExpression"
    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:571:1: ruleXAndExpression returns [EObject current=null] : (this_XEqualityExpression_0= ruleXEqualityExpression ( ( ( ( () ( ( ruleOpAnd ) ) ) )=> ( () ( ( ruleOpAnd ) ) ) ) ( (lv_rightOperand_3_0= ruleXEqualityExpression ) ) )* ) ;
    public final EObject ruleXAndExpression() throws RecognitionException {
        EObject current = null;

        EObject this_XEqualityExpression_0 = null;

        EObject lv_rightOperand_3_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:574:28: ( (this_XEqualityExpression_0= ruleXEqualityExpression ( ( ( ( () ( ( ruleOpAnd ) ) ) )=> ( () ( ( ruleOpAnd ) ) ) ) ( (lv_rightOperand_3_0= ruleXEqualityExpression ) ) )* ) )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:575:1: (this_XEqualityExpression_0= ruleXEqualityExpression ( ( ( ( () ( ( ruleOpAnd ) ) ) )=> ( () ( ( ruleOpAnd ) ) ) ) ( (lv_rightOperand_3_0= ruleXEqualityExpression ) ) )* )
            {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:575:1: (this_XEqualityExpression_0= ruleXEqualityExpression ( ( ( ( () ( ( ruleOpAnd ) ) ) )=> ( () ( ( ruleOpAnd ) ) ) ) ( (lv_rightOperand_3_0= ruleXEqualityExpression ) ) )* )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:576:5: this_XEqualityExpression_0= ruleXEqualityExpression ( ( ( ( () ( ( ruleOpAnd ) ) ) )=> ( () ( ( ruleOpAnd ) ) ) ) ( (lv_rightOperand_3_0= ruleXEqualityExpression ) ) )*
            {
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getXAndExpressionAccess().getXEqualityExpressionParserRuleCall_0()); 
                  
            }
            pushFollow(FOLLOW_ruleXEqualityExpression_in_ruleXAndExpression1368);
            this_XEqualityExpression_0=ruleXEqualityExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                      current = this_XEqualityExpression_0; 
                      afterParserOrEnumRuleCall();
                  
            }
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:584:1: ( ( ( ( () ( ( ruleOpAnd ) ) ) )=> ( () ( ( ruleOpAnd ) ) ) ) ( (lv_rightOperand_3_0= ruleXEqualityExpression ) ) )*
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( (LA8_0==17) ) {
                    int LA8_2 = input.LA(2);

                    if ( (synpred3_InternalPureXbase()) ) {
                        alt8=1;
                    }


                }


                switch (alt8) {
            	case 1 :
            	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:584:2: ( ( ( () ( ( ruleOpAnd ) ) ) )=> ( () ( ( ruleOpAnd ) ) ) ) ( (lv_rightOperand_3_0= ruleXEqualityExpression ) )
            	    {
            	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:584:2: ( ( ( () ( ( ruleOpAnd ) ) ) )=> ( () ( ( ruleOpAnd ) ) ) )
            	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:584:3: ( ( () ( ( ruleOpAnd ) ) ) )=> ( () ( ( ruleOpAnd ) ) )
            	    {
            	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:589:6: ( () ( ( ruleOpAnd ) ) )
            	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:589:7: () ( ( ruleOpAnd ) )
            	    {
            	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:589:7: ()
            	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:590:5: 
            	    {
            	    if ( state.backtracking==0 ) {

            	              current = forceCreateModelElementAndSet(
            	                  grammarAccess.getXAndExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0(),
            	                  current);
            	          
            	    }

            	    }

            	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:595:2: ( ( ruleOpAnd ) )
            	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:596:1: ( ruleOpAnd )
            	    {
            	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:596:1: ( ruleOpAnd )
            	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:597:3: ruleOpAnd
            	    {
            	    if ( state.backtracking==0 ) {

            	      			if (current==null) {
            	      	            current = createModelElement(grammarAccess.getXAndExpressionRule());
            	      	        }
            	              
            	    }
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getXAndExpressionAccess().getFeatureJvmIdentifiableElementCrossReference_1_0_0_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleOpAnd_in_ruleXAndExpression1421);
            	    ruleOpAnd();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {
            	       
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }


            	    }


            	    }

            	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:610:4: ( (lv_rightOperand_3_0= ruleXEqualityExpression ) )
            	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:611:1: (lv_rightOperand_3_0= ruleXEqualityExpression )
            	    {
            	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:611:1: (lv_rightOperand_3_0= ruleXEqualityExpression )
            	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:612:3: lv_rightOperand_3_0= ruleXEqualityExpression
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getXAndExpressionAccess().getRightOperandXEqualityExpressionParserRuleCall_1_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleXEqualityExpression_in_ruleXAndExpression1444);
            	    lv_rightOperand_3_0=ruleXEqualityExpression();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getXAndExpressionRule());
            	      	        }
            	             		set(
            	             			current, 
            	             			"rightOperand",
            	              		lv_rightOperand_3_0, 
            	              		"XEqualityExpression");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop8;
                }
            } while (true);


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleXAndExpression"


    // $ANTLR start "entryRuleOpAnd"
    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:636:1: entryRuleOpAnd returns [String current=null] : iv_ruleOpAnd= ruleOpAnd EOF ;
    public final String entryRuleOpAnd() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleOpAnd = null;


        try {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:637:2: (iv_ruleOpAnd= ruleOpAnd EOF )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:638:2: iv_ruleOpAnd= ruleOpAnd EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getOpAndRule()); 
            }
            pushFollow(FOLLOW_ruleOpAnd_in_entryRuleOpAnd1483);
            iv_ruleOpAnd=ruleOpAnd();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleOpAnd.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleOpAnd1494); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleOpAnd"


    // $ANTLR start "ruleOpAnd"
    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:645:1: ruleOpAnd returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : kw= '&&' ;
    public final AntlrDatatypeRuleToken ruleOpAnd() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:648:28: (kw= '&&' )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:650:2: kw= '&&'
            {
            kw=(Token)match(input,17,FOLLOW_17_in_ruleOpAnd1531); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                      current.merge(kw);
                      newLeafNode(kw, grammarAccess.getOpAndAccess().getAmpersandAmpersandKeyword()); 
                  
            }

            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleOpAnd"


    // $ANTLR start "entryRuleXEqualityExpression"
    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:663:1: entryRuleXEqualityExpression returns [EObject current=null] : iv_ruleXEqualityExpression= ruleXEqualityExpression EOF ;
    public final EObject entryRuleXEqualityExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXEqualityExpression = null;


        try {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:664:2: (iv_ruleXEqualityExpression= ruleXEqualityExpression EOF )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:665:2: iv_ruleXEqualityExpression= ruleXEqualityExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXEqualityExpressionRule()); 
            }
            pushFollow(FOLLOW_ruleXEqualityExpression_in_entryRuleXEqualityExpression1570);
            iv_ruleXEqualityExpression=ruleXEqualityExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXEqualityExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXEqualityExpression1580); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleXEqualityExpression"


    // $ANTLR start "ruleXEqualityExpression"
    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:672:1: ruleXEqualityExpression returns [EObject current=null] : (this_XRelationalExpression_0= ruleXRelationalExpression ( ( ( ( () ( ( ruleOpEquality ) ) ) )=> ( () ( ( ruleOpEquality ) ) ) ) ( (lv_rightOperand_3_0= ruleXRelationalExpression ) ) )* ) ;
    public final EObject ruleXEqualityExpression() throws RecognitionException {
        EObject current = null;

        EObject this_XRelationalExpression_0 = null;

        EObject lv_rightOperand_3_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:675:28: ( (this_XRelationalExpression_0= ruleXRelationalExpression ( ( ( ( () ( ( ruleOpEquality ) ) ) )=> ( () ( ( ruleOpEquality ) ) ) ) ( (lv_rightOperand_3_0= ruleXRelationalExpression ) ) )* ) )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:676:1: (this_XRelationalExpression_0= ruleXRelationalExpression ( ( ( ( () ( ( ruleOpEquality ) ) ) )=> ( () ( ( ruleOpEquality ) ) ) ) ( (lv_rightOperand_3_0= ruleXRelationalExpression ) ) )* )
            {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:676:1: (this_XRelationalExpression_0= ruleXRelationalExpression ( ( ( ( () ( ( ruleOpEquality ) ) ) )=> ( () ( ( ruleOpEquality ) ) ) ) ( (lv_rightOperand_3_0= ruleXRelationalExpression ) ) )* )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:677:5: this_XRelationalExpression_0= ruleXRelationalExpression ( ( ( ( () ( ( ruleOpEquality ) ) ) )=> ( () ( ( ruleOpEquality ) ) ) ) ( (lv_rightOperand_3_0= ruleXRelationalExpression ) ) )*
            {
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getXEqualityExpressionAccess().getXRelationalExpressionParserRuleCall_0()); 
                  
            }
            pushFollow(FOLLOW_ruleXRelationalExpression_in_ruleXEqualityExpression1627);
            this_XRelationalExpression_0=ruleXRelationalExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                      current = this_XRelationalExpression_0; 
                      afterParserOrEnumRuleCall();
                  
            }
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:685:1: ( ( ( ( () ( ( ruleOpEquality ) ) ) )=> ( () ( ( ruleOpEquality ) ) ) ) ( (lv_rightOperand_3_0= ruleXRelationalExpression ) ) )*
            loop9:
            do {
                int alt9=2;
                int LA9_0 = input.LA(1);

                if ( (LA9_0==18) ) {
                    int LA9_2 = input.LA(2);

                    if ( (synpred4_InternalPureXbase()) ) {
                        alt9=1;
                    }


                }
                else if ( (LA9_0==19) ) {
                    int LA9_3 = input.LA(2);

                    if ( (synpred4_InternalPureXbase()) ) {
                        alt9=1;
                    }


                }


                switch (alt9) {
            	case 1 :
            	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:685:2: ( ( ( () ( ( ruleOpEquality ) ) ) )=> ( () ( ( ruleOpEquality ) ) ) ) ( (lv_rightOperand_3_0= ruleXRelationalExpression ) )
            	    {
            	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:685:2: ( ( ( () ( ( ruleOpEquality ) ) ) )=> ( () ( ( ruleOpEquality ) ) ) )
            	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:685:3: ( ( () ( ( ruleOpEquality ) ) ) )=> ( () ( ( ruleOpEquality ) ) )
            	    {
            	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:690:6: ( () ( ( ruleOpEquality ) ) )
            	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:690:7: () ( ( ruleOpEquality ) )
            	    {
            	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:690:7: ()
            	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:691:5: 
            	    {
            	    if ( state.backtracking==0 ) {

            	              current = forceCreateModelElementAndSet(
            	                  grammarAccess.getXEqualityExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0(),
            	                  current);
            	          
            	    }

            	    }

            	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:696:2: ( ( ruleOpEquality ) )
            	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:697:1: ( ruleOpEquality )
            	    {
            	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:697:1: ( ruleOpEquality )
            	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:698:3: ruleOpEquality
            	    {
            	    if ( state.backtracking==0 ) {

            	      			if (current==null) {
            	      	            current = createModelElement(grammarAccess.getXEqualityExpressionRule());
            	      	        }
            	              
            	    }
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getXEqualityExpressionAccess().getFeatureJvmIdentifiableElementCrossReference_1_0_0_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleOpEquality_in_ruleXEqualityExpression1680);
            	    ruleOpEquality();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {
            	       
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }


            	    }


            	    }

            	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:711:4: ( (lv_rightOperand_3_0= ruleXRelationalExpression ) )
            	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:712:1: (lv_rightOperand_3_0= ruleXRelationalExpression )
            	    {
            	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:712:1: (lv_rightOperand_3_0= ruleXRelationalExpression )
            	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:713:3: lv_rightOperand_3_0= ruleXRelationalExpression
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getXEqualityExpressionAccess().getRightOperandXRelationalExpressionParserRuleCall_1_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleXRelationalExpression_in_ruleXEqualityExpression1703);
            	    lv_rightOperand_3_0=ruleXRelationalExpression();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getXEqualityExpressionRule());
            	      	        }
            	             		set(
            	             			current, 
            	             			"rightOperand",
            	              		lv_rightOperand_3_0, 
            	              		"XRelationalExpression");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop9;
                }
            } while (true);


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleXEqualityExpression"


    // $ANTLR start "entryRuleOpEquality"
    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:737:1: entryRuleOpEquality returns [String current=null] : iv_ruleOpEquality= ruleOpEquality EOF ;
    public final String entryRuleOpEquality() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleOpEquality = null;


        try {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:738:2: (iv_ruleOpEquality= ruleOpEquality EOF )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:739:2: iv_ruleOpEquality= ruleOpEquality EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getOpEqualityRule()); 
            }
            pushFollow(FOLLOW_ruleOpEquality_in_entryRuleOpEquality1742);
            iv_ruleOpEquality=ruleOpEquality();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleOpEquality.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleOpEquality1753); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleOpEquality"


    // $ANTLR start "ruleOpEquality"
    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:746:1: ruleOpEquality returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= '==' | kw= '!=' ) ;
    public final AntlrDatatypeRuleToken ruleOpEquality() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:749:28: ( (kw= '==' | kw= '!=' ) )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:750:1: (kw= '==' | kw= '!=' )
            {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:750:1: (kw= '==' | kw= '!=' )
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==18) ) {
                alt10=1;
            }
            else if ( (LA10_0==19) ) {
                alt10=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 10, 0, input);

                throw nvae;
            }
            switch (alt10) {
                case 1 :
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:751:2: kw= '=='
                    {
                    kw=(Token)match(input,18,FOLLOW_18_in_ruleOpEquality1791); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getOpEqualityAccess().getEqualsSignEqualsSignKeyword_0()); 
                          
                    }

                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:758:2: kw= '!='
                    {
                    kw=(Token)match(input,19,FOLLOW_19_in_ruleOpEquality1810); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getOpEqualityAccess().getExclamationMarkEqualsSignKeyword_1()); 
                          
                    }

                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleOpEquality"


    // $ANTLR start "entryRuleXRelationalExpression"
    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:771:1: entryRuleXRelationalExpression returns [EObject current=null] : iv_ruleXRelationalExpression= ruleXRelationalExpression EOF ;
    public final EObject entryRuleXRelationalExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXRelationalExpression = null;


        try {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:772:2: (iv_ruleXRelationalExpression= ruleXRelationalExpression EOF )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:773:2: iv_ruleXRelationalExpression= ruleXRelationalExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXRelationalExpressionRule()); 
            }
            pushFollow(FOLLOW_ruleXRelationalExpression_in_entryRuleXRelationalExpression1850);
            iv_ruleXRelationalExpression=ruleXRelationalExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXRelationalExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXRelationalExpression1860); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleXRelationalExpression"


    // $ANTLR start "ruleXRelationalExpression"
    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:780:1: ruleXRelationalExpression returns [EObject current=null] : (this_XOtherOperatorExpression_0= ruleXOtherOperatorExpression ( ( ( ( ( () 'instanceof' ) )=> ( () otherlv_2= 'instanceof' ) ) ( ( ruleQualifiedName ) ) ) | ( ( ( ( () ( ( ruleOpCompare ) ) ) )=> ( () ( ( ruleOpCompare ) ) ) ) ( (lv_rightOperand_6_0= ruleXOtherOperatorExpression ) ) ) )* ) ;
    public final EObject ruleXRelationalExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        EObject this_XOtherOperatorExpression_0 = null;

        EObject lv_rightOperand_6_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:783:28: ( (this_XOtherOperatorExpression_0= ruleXOtherOperatorExpression ( ( ( ( ( () 'instanceof' ) )=> ( () otherlv_2= 'instanceof' ) ) ( ( ruleQualifiedName ) ) ) | ( ( ( ( () ( ( ruleOpCompare ) ) ) )=> ( () ( ( ruleOpCompare ) ) ) ) ( (lv_rightOperand_6_0= ruleXOtherOperatorExpression ) ) ) )* ) )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:784:1: (this_XOtherOperatorExpression_0= ruleXOtherOperatorExpression ( ( ( ( ( () 'instanceof' ) )=> ( () otherlv_2= 'instanceof' ) ) ( ( ruleQualifiedName ) ) ) | ( ( ( ( () ( ( ruleOpCompare ) ) ) )=> ( () ( ( ruleOpCompare ) ) ) ) ( (lv_rightOperand_6_0= ruleXOtherOperatorExpression ) ) ) )* )
            {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:784:1: (this_XOtherOperatorExpression_0= ruleXOtherOperatorExpression ( ( ( ( ( () 'instanceof' ) )=> ( () otherlv_2= 'instanceof' ) ) ( ( ruleQualifiedName ) ) ) | ( ( ( ( () ( ( ruleOpCompare ) ) ) )=> ( () ( ( ruleOpCompare ) ) ) ) ( (lv_rightOperand_6_0= ruleXOtherOperatorExpression ) ) ) )* )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:785:5: this_XOtherOperatorExpression_0= ruleXOtherOperatorExpression ( ( ( ( ( () 'instanceof' ) )=> ( () otherlv_2= 'instanceof' ) ) ( ( ruleQualifiedName ) ) ) | ( ( ( ( () ( ( ruleOpCompare ) ) ) )=> ( () ( ( ruleOpCompare ) ) ) ) ( (lv_rightOperand_6_0= ruleXOtherOperatorExpression ) ) ) )*
            {
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getXRelationalExpressionAccess().getXOtherOperatorExpressionParserRuleCall_0()); 
                  
            }
            pushFollow(FOLLOW_ruleXOtherOperatorExpression_in_ruleXRelationalExpression1907);
            this_XOtherOperatorExpression_0=ruleXOtherOperatorExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                      current = this_XOtherOperatorExpression_0; 
                      afterParserOrEnumRuleCall();
                  
            }
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:793:1: ( ( ( ( ( () 'instanceof' ) )=> ( () otherlv_2= 'instanceof' ) ) ( ( ruleQualifiedName ) ) ) | ( ( ( ( () ( ( ruleOpCompare ) ) ) )=> ( () ( ( ruleOpCompare ) ) ) ) ( (lv_rightOperand_6_0= ruleXOtherOperatorExpression ) ) ) )*
            loop11:
            do {
                int alt11=3;
                switch ( input.LA(1) ) {
                case 20:
                    {
                    int LA11_2 = input.LA(2);

                    if ( (synpred5_InternalPureXbase()) ) {
                        alt11=1;
                    }


                    }
                    break;
                case 21:
                    {
                    int LA11_3 = input.LA(2);

                    if ( (synpred6_InternalPureXbase()) ) {
                        alt11=2;
                    }


                    }
                    break;
                case 22:
                    {
                    int LA11_4 = input.LA(2);

                    if ( (synpred6_InternalPureXbase()) ) {
                        alt11=2;
                    }


                    }
                    break;
                case 23:
                    {
                    int LA11_5 = input.LA(2);

                    if ( (synpred6_InternalPureXbase()) ) {
                        alt11=2;
                    }


                    }
                    break;
                case 24:
                    {
                    int LA11_6 = input.LA(2);

                    if ( (synpred6_InternalPureXbase()) ) {
                        alt11=2;
                    }


                    }
                    break;

                }

                switch (alt11) {
            	case 1 :
            	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:793:2: ( ( ( ( () 'instanceof' ) )=> ( () otherlv_2= 'instanceof' ) ) ( ( ruleQualifiedName ) ) )
            	    {
            	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:793:2: ( ( ( ( () 'instanceof' ) )=> ( () otherlv_2= 'instanceof' ) ) ( ( ruleQualifiedName ) ) )
            	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:793:3: ( ( ( () 'instanceof' ) )=> ( () otherlv_2= 'instanceof' ) ) ( ( ruleQualifiedName ) )
            	    {
            	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:793:3: ( ( ( () 'instanceof' ) )=> ( () otherlv_2= 'instanceof' ) )
            	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:793:4: ( ( () 'instanceof' ) )=> ( () otherlv_2= 'instanceof' )
            	    {
            	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:795:5: ( () otherlv_2= 'instanceof' )
            	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:795:6: () otherlv_2= 'instanceof'
            	    {
            	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:795:6: ()
            	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:796:5: 
            	    {
            	    if ( state.backtracking==0 ) {

            	              current = forceCreateModelElementAndSet(
            	                  grammarAccess.getXRelationalExpressionAccess().getXInstanceOfExpressionExpressionAction_1_0_0_0_0(),
            	                  current);
            	          
            	    }

            	    }

            	    otherlv_2=(Token)match(input,20,FOLLOW_20_in_ruleXRelationalExpression1943); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	          	newLeafNode(otherlv_2, grammarAccess.getXRelationalExpressionAccess().getInstanceofKeyword_1_0_0_0_1());
            	          
            	    }

            	    }


            	    }

            	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:805:3: ( ( ruleQualifiedName ) )
            	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:806:1: ( ruleQualifiedName )
            	    {
            	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:806:1: ( ruleQualifiedName )
            	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:807:3: ruleQualifiedName
            	    {
            	    if ( state.backtracking==0 ) {

            	      			if (current==null) {
            	      	            current = createModelElement(grammarAccess.getXRelationalExpressionRule());
            	      	        }
            	              
            	    }
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getXRelationalExpressionAccess().getTypeJvmTypeCrossReference_1_0_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleQualifiedName_in_ruleXRelationalExpression1968);
            	    ruleQualifiedName();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {
            	       
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }


            	    }


            	    }
            	    break;
            	case 2 :
            	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:821:6: ( ( ( ( () ( ( ruleOpCompare ) ) ) )=> ( () ( ( ruleOpCompare ) ) ) ) ( (lv_rightOperand_6_0= ruleXOtherOperatorExpression ) ) )
            	    {
            	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:821:6: ( ( ( ( () ( ( ruleOpCompare ) ) ) )=> ( () ( ( ruleOpCompare ) ) ) ) ( (lv_rightOperand_6_0= ruleXOtherOperatorExpression ) ) )
            	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:821:7: ( ( ( () ( ( ruleOpCompare ) ) ) )=> ( () ( ( ruleOpCompare ) ) ) ) ( (lv_rightOperand_6_0= ruleXOtherOperatorExpression ) )
            	    {
            	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:821:7: ( ( ( () ( ( ruleOpCompare ) ) ) )=> ( () ( ( ruleOpCompare ) ) ) )
            	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:821:8: ( ( () ( ( ruleOpCompare ) ) ) )=> ( () ( ( ruleOpCompare ) ) )
            	    {
            	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:826:6: ( () ( ( ruleOpCompare ) ) )
            	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:826:7: () ( ( ruleOpCompare ) )
            	    {
            	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:826:7: ()
            	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:827:5: 
            	    {
            	    if ( state.backtracking==0 ) {

            	              current = forceCreateModelElementAndSet(
            	                  grammarAccess.getXRelationalExpressionAccess().getXBinaryOperationLeftOperandAction_1_1_0_0_0(),
            	                  current);
            	          
            	    }

            	    }

            	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:832:2: ( ( ruleOpCompare ) )
            	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:833:1: ( ruleOpCompare )
            	    {
            	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:833:1: ( ruleOpCompare )
            	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:834:3: ruleOpCompare
            	    {
            	    if ( state.backtracking==0 ) {

            	      			if (current==null) {
            	      	            current = createModelElement(grammarAccess.getXRelationalExpressionRule());
            	      	        }
            	              
            	    }
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getXRelationalExpressionAccess().getFeatureJvmIdentifiableElementCrossReference_1_1_0_0_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleOpCompare_in_ruleXRelationalExpression2029);
            	    ruleOpCompare();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {
            	       
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }


            	    }


            	    }

            	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:847:4: ( (lv_rightOperand_6_0= ruleXOtherOperatorExpression ) )
            	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:848:1: (lv_rightOperand_6_0= ruleXOtherOperatorExpression )
            	    {
            	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:848:1: (lv_rightOperand_6_0= ruleXOtherOperatorExpression )
            	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:849:3: lv_rightOperand_6_0= ruleXOtherOperatorExpression
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getXRelationalExpressionAccess().getRightOperandXOtherOperatorExpressionParserRuleCall_1_1_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleXOtherOperatorExpression_in_ruleXRelationalExpression2052);
            	    lv_rightOperand_6_0=ruleXOtherOperatorExpression();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getXRelationalExpressionRule());
            	      	        }
            	             		set(
            	             			current, 
            	             			"rightOperand",
            	              		lv_rightOperand_6_0, 
            	              		"XOtherOperatorExpression");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop11;
                }
            } while (true);


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleXRelationalExpression"


    // $ANTLR start "entryRuleOpCompare"
    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:873:1: entryRuleOpCompare returns [String current=null] : iv_ruleOpCompare= ruleOpCompare EOF ;
    public final String entryRuleOpCompare() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleOpCompare = null;


        try {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:874:2: (iv_ruleOpCompare= ruleOpCompare EOF )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:875:2: iv_ruleOpCompare= ruleOpCompare EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getOpCompareRule()); 
            }
            pushFollow(FOLLOW_ruleOpCompare_in_entryRuleOpCompare2092);
            iv_ruleOpCompare=ruleOpCompare();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleOpCompare.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleOpCompare2103); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleOpCompare"


    // $ANTLR start "ruleOpCompare"
    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:882:1: ruleOpCompare returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= '>=' | kw= '<=' | kw= '>' | kw= '<' ) ;
    public final AntlrDatatypeRuleToken ruleOpCompare() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:885:28: ( (kw= '>=' | kw= '<=' | kw= '>' | kw= '<' ) )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:886:1: (kw= '>=' | kw= '<=' | kw= '>' | kw= '<' )
            {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:886:1: (kw= '>=' | kw= '<=' | kw= '>' | kw= '<' )
            int alt12=4;
            switch ( input.LA(1) ) {
            case 21:
                {
                alt12=1;
                }
                break;
            case 22:
                {
                alt12=2;
                }
                break;
            case 23:
                {
                alt12=3;
                }
                break;
            case 24:
                {
                alt12=4;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 12, 0, input);

                throw nvae;
            }

            switch (alt12) {
                case 1 :
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:887:2: kw= '>='
                    {
                    kw=(Token)match(input,21,FOLLOW_21_in_ruleOpCompare2141); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getOpCompareAccess().getGreaterThanSignEqualsSignKeyword_0()); 
                          
                    }

                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:894:2: kw= '<='
                    {
                    kw=(Token)match(input,22,FOLLOW_22_in_ruleOpCompare2160); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getOpCompareAccess().getLessThanSignEqualsSignKeyword_1()); 
                          
                    }

                    }
                    break;
                case 3 :
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:901:2: kw= '>'
                    {
                    kw=(Token)match(input,23,FOLLOW_23_in_ruleOpCompare2179); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getOpCompareAccess().getGreaterThanSignKeyword_2()); 
                          
                    }

                    }
                    break;
                case 4 :
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:908:2: kw= '<'
                    {
                    kw=(Token)match(input,24,FOLLOW_24_in_ruleOpCompare2198); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getOpCompareAccess().getLessThanSignKeyword_3()); 
                          
                    }

                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleOpCompare"


    // $ANTLR start "entryRuleXOtherOperatorExpression"
    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:921:1: entryRuleXOtherOperatorExpression returns [EObject current=null] : iv_ruleXOtherOperatorExpression= ruleXOtherOperatorExpression EOF ;
    public final EObject entryRuleXOtherOperatorExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXOtherOperatorExpression = null;


        try {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:922:2: (iv_ruleXOtherOperatorExpression= ruleXOtherOperatorExpression EOF )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:923:2: iv_ruleXOtherOperatorExpression= ruleXOtherOperatorExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXOtherOperatorExpressionRule()); 
            }
            pushFollow(FOLLOW_ruleXOtherOperatorExpression_in_entryRuleXOtherOperatorExpression2238);
            iv_ruleXOtherOperatorExpression=ruleXOtherOperatorExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXOtherOperatorExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXOtherOperatorExpression2248); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleXOtherOperatorExpression"


    // $ANTLR start "ruleXOtherOperatorExpression"
    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:930:1: ruleXOtherOperatorExpression returns [EObject current=null] : (this_XAdditiveExpression_0= ruleXAdditiveExpression ( ( ( ( () ( ( ruleOpOther ) ) ) )=> ( () ( ( ruleOpOther ) ) ) ) ( (lv_rightOperand_3_0= ruleXAdditiveExpression ) ) )* ) ;
    public final EObject ruleXOtherOperatorExpression() throws RecognitionException {
        EObject current = null;

        EObject this_XAdditiveExpression_0 = null;

        EObject lv_rightOperand_3_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:933:28: ( (this_XAdditiveExpression_0= ruleXAdditiveExpression ( ( ( ( () ( ( ruleOpOther ) ) ) )=> ( () ( ( ruleOpOther ) ) ) ) ( (lv_rightOperand_3_0= ruleXAdditiveExpression ) ) )* ) )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:934:1: (this_XAdditiveExpression_0= ruleXAdditiveExpression ( ( ( ( () ( ( ruleOpOther ) ) ) )=> ( () ( ( ruleOpOther ) ) ) ) ( (lv_rightOperand_3_0= ruleXAdditiveExpression ) ) )* )
            {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:934:1: (this_XAdditiveExpression_0= ruleXAdditiveExpression ( ( ( ( () ( ( ruleOpOther ) ) ) )=> ( () ( ( ruleOpOther ) ) ) ) ( (lv_rightOperand_3_0= ruleXAdditiveExpression ) ) )* )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:935:5: this_XAdditiveExpression_0= ruleXAdditiveExpression ( ( ( ( () ( ( ruleOpOther ) ) ) )=> ( () ( ( ruleOpOther ) ) ) ) ( (lv_rightOperand_3_0= ruleXAdditiveExpression ) ) )*
            {
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getXOtherOperatorExpressionAccess().getXAdditiveExpressionParserRuleCall_0()); 
                  
            }
            pushFollow(FOLLOW_ruleXAdditiveExpression_in_ruleXOtherOperatorExpression2295);
            this_XAdditiveExpression_0=ruleXAdditiveExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                      current = this_XAdditiveExpression_0; 
                      afterParserOrEnumRuleCall();
                  
            }
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:943:1: ( ( ( ( () ( ( ruleOpOther ) ) ) )=> ( () ( ( ruleOpOther ) ) ) ) ( (lv_rightOperand_3_0= ruleXAdditiveExpression ) ) )*
            loop13:
            do {
                int alt13=2;
                int LA13_0 = input.LA(1);

                if ( (LA13_0==25) ) {
                    int LA13_2 = input.LA(2);

                    if ( (synpred7_InternalPureXbase()) ) {
                        alt13=1;
                    }


                }
                else if ( (LA13_0==26) ) {
                    int LA13_3 = input.LA(2);

                    if ( (synpred7_InternalPureXbase()) ) {
                        alt13=1;
                    }


                }


                switch (alt13) {
            	case 1 :
            	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:943:2: ( ( ( () ( ( ruleOpOther ) ) ) )=> ( () ( ( ruleOpOther ) ) ) ) ( (lv_rightOperand_3_0= ruleXAdditiveExpression ) )
            	    {
            	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:943:2: ( ( ( () ( ( ruleOpOther ) ) ) )=> ( () ( ( ruleOpOther ) ) ) )
            	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:943:3: ( ( () ( ( ruleOpOther ) ) ) )=> ( () ( ( ruleOpOther ) ) )
            	    {
            	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:948:6: ( () ( ( ruleOpOther ) ) )
            	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:948:7: () ( ( ruleOpOther ) )
            	    {
            	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:948:7: ()
            	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:949:5: 
            	    {
            	    if ( state.backtracking==0 ) {

            	              current = forceCreateModelElementAndSet(
            	                  grammarAccess.getXOtherOperatorExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0(),
            	                  current);
            	          
            	    }

            	    }

            	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:954:2: ( ( ruleOpOther ) )
            	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:955:1: ( ruleOpOther )
            	    {
            	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:955:1: ( ruleOpOther )
            	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:956:3: ruleOpOther
            	    {
            	    if ( state.backtracking==0 ) {

            	      			if (current==null) {
            	      	            current = createModelElement(grammarAccess.getXOtherOperatorExpressionRule());
            	      	        }
            	              
            	    }
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getXOtherOperatorExpressionAccess().getFeatureJvmIdentifiableElementCrossReference_1_0_0_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleOpOther_in_ruleXOtherOperatorExpression2348);
            	    ruleOpOther();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {
            	       
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }


            	    }


            	    }

            	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:969:4: ( (lv_rightOperand_3_0= ruleXAdditiveExpression ) )
            	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:970:1: (lv_rightOperand_3_0= ruleXAdditiveExpression )
            	    {
            	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:970:1: (lv_rightOperand_3_0= ruleXAdditiveExpression )
            	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:971:3: lv_rightOperand_3_0= ruleXAdditiveExpression
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getXOtherOperatorExpressionAccess().getRightOperandXAdditiveExpressionParserRuleCall_1_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleXAdditiveExpression_in_ruleXOtherOperatorExpression2371);
            	    lv_rightOperand_3_0=ruleXAdditiveExpression();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getXOtherOperatorExpressionRule());
            	      	        }
            	             		set(
            	             			current, 
            	             			"rightOperand",
            	              		lv_rightOperand_3_0, 
            	              		"XAdditiveExpression");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop13;
                }
            } while (true);


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleXOtherOperatorExpression"


    // $ANTLR start "entryRuleOpOther"
    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:995:1: entryRuleOpOther returns [String current=null] : iv_ruleOpOther= ruleOpOther EOF ;
    public final String entryRuleOpOther() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleOpOther = null;


        try {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:996:2: (iv_ruleOpOther= ruleOpOther EOF )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:997:2: iv_ruleOpOther= ruleOpOther EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getOpOtherRule()); 
            }
            pushFollow(FOLLOW_ruleOpOther_in_entryRuleOpOther2410);
            iv_ruleOpOther=ruleOpOther();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleOpOther.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleOpOther2421); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleOpOther"


    // $ANTLR start "ruleOpOther"
    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1004:1: ruleOpOther returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= '->' | kw= '..' ) ;
    public final AntlrDatatypeRuleToken ruleOpOther() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1007:28: ( (kw= '->' | kw= '..' ) )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1008:1: (kw= '->' | kw= '..' )
            {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1008:1: (kw= '->' | kw= '..' )
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( (LA14_0==25) ) {
                alt14=1;
            }
            else if ( (LA14_0==26) ) {
                alt14=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 14, 0, input);

                throw nvae;
            }
            switch (alt14) {
                case 1 :
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1009:2: kw= '->'
                    {
                    kw=(Token)match(input,25,FOLLOW_25_in_ruleOpOther2459); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getOpOtherAccess().getHyphenMinusGreaterThanSignKeyword_0()); 
                          
                    }

                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1016:2: kw= '..'
                    {
                    kw=(Token)match(input,26,FOLLOW_26_in_ruleOpOther2478); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getOpOtherAccess().getFullStopFullStopKeyword_1()); 
                          
                    }

                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleOpOther"


    // $ANTLR start "entryRuleXAdditiveExpression"
    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1029:1: entryRuleXAdditiveExpression returns [EObject current=null] : iv_ruleXAdditiveExpression= ruleXAdditiveExpression EOF ;
    public final EObject entryRuleXAdditiveExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXAdditiveExpression = null;


        try {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1030:2: (iv_ruleXAdditiveExpression= ruleXAdditiveExpression EOF )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1031:2: iv_ruleXAdditiveExpression= ruleXAdditiveExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXAdditiveExpressionRule()); 
            }
            pushFollow(FOLLOW_ruleXAdditiveExpression_in_entryRuleXAdditiveExpression2518);
            iv_ruleXAdditiveExpression=ruleXAdditiveExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXAdditiveExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXAdditiveExpression2528); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleXAdditiveExpression"


    // $ANTLR start "ruleXAdditiveExpression"
    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1038:1: ruleXAdditiveExpression returns [EObject current=null] : (this_XMultiplicativeExpression_0= ruleXMultiplicativeExpression ( ( ( ( () ( ( ruleOpAdd ) ) ) )=> ( () ( ( ruleOpAdd ) ) ) ) ( (lv_rightOperand_3_0= ruleXMultiplicativeExpression ) ) )* ) ;
    public final EObject ruleXAdditiveExpression() throws RecognitionException {
        EObject current = null;

        EObject this_XMultiplicativeExpression_0 = null;

        EObject lv_rightOperand_3_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1041:28: ( (this_XMultiplicativeExpression_0= ruleXMultiplicativeExpression ( ( ( ( () ( ( ruleOpAdd ) ) ) )=> ( () ( ( ruleOpAdd ) ) ) ) ( (lv_rightOperand_3_0= ruleXMultiplicativeExpression ) ) )* ) )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1042:1: (this_XMultiplicativeExpression_0= ruleXMultiplicativeExpression ( ( ( ( () ( ( ruleOpAdd ) ) ) )=> ( () ( ( ruleOpAdd ) ) ) ) ( (lv_rightOperand_3_0= ruleXMultiplicativeExpression ) ) )* )
            {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1042:1: (this_XMultiplicativeExpression_0= ruleXMultiplicativeExpression ( ( ( ( () ( ( ruleOpAdd ) ) ) )=> ( () ( ( ruleOpAdd ) ) ) ) ( (lv_rightOperand_3_0= ruleXMultiplicativeExpression ) ) )* )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1043:5: this_XMultiplicativeExpression_0= ruleXMultiplicativeExpression ( ( ( ( () ( ( ruleOpAdd ) ) ) )=> ( () ( ( ruleOpAdd ) ) ) ) ( (lv_rightOperand_3_0= ruleXMultiplicativeExpression ) ) )*
            {
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getXAdditiveExpressionAccess().getXMultiplicativeExpressionParserRuleCall_0()); 
                  
            }
            pushFollow(FOLLOW_ruleXMultiplicativeExpression_in_ruleXAdditiveExpression2575);
            this_XMultiplicativeExpression_0=ruleXMultiplicativeExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                      current = this_XMultiplicativeExpression_0; 
                      afterParserOrEnumRuleCall();
                  
            }
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1051:1: ( ( ( ( () ( ( ruleOpAdd ) ) ) )=> ( () ( ( ruleOpAdd ) ) ) ) ( (lv_rightOperand_3_0= ruleXMultiplicativeExpression ) ) )*
            loop15:
            do {
                int alt15=2;
                int LA15_0 = input.LA(1);

                if ( (LA15_0==27) ) {
                    int LA15_2 = input.LA(2);

                    if ( (synpred8_InternalPureXbase()) ) {
                        alt15=1;
                    }


                }
                else if ( (LA15_0==28) ) {
                    int LA15_3 = input.LA(2);

                    if ( (synpred8_InternalPureXbase()) ) {
                        alt15=1;
                    }


                }


                switch (alt15) {
            	case 1 :
            	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1051:2: ( ( ( () ( ( ruleOpAdd ) ) ) )=> ( () ( ( ruleOpAdd ) ) ) ) ( (lv_rightOperand_3_0= ruleXMultiplicativeExpression ) )
            	    {
            	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1051:2: ( ( ( () ( ( ruleOpAdd ) ) ) )=> ( () ( ( ruleOpAdd ) ) ) )
            	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1051:3: ( ( () ( ( ruleOpAdd ) ) ) )=> ( () ( ( ruleOpAdd ) ) )
            	    {
            	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1056:6: ( () ( ( ruleOpAdd ) ) )
            	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1056:7: () ( ( ruleOpAdd ) )
            	    {
            	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1056:7: ()
            	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1057:5: 
            	    {
            	    if ( state.backtracking==0 ) {

            	              current = forceCreateModelElementAndSet(
            	                  grammarAccess.getXAdditiveExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0(),
            	                  current);
            	          
            	    }

            	    }

            	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1062:2: ( ( ruleOpAdd ) )
            	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1063:1: ( ruleOpAdd )
            	    {
            	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1063:1: ( ruleOpAdd )
            	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1064:3: ruleOpAdd
            	    {
            	    if ( state.backtracking==0 ) {

            	      			if (current==null) {
            	      	            current = createModelElement(grammarAccess.getXAdditiveExpressionRule());
            	      	        }
            	              
            	    }
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getXAdditiveExpressionAccess().getFeatureJvmIdentifiableElementCrossReference_1_0_0_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleOpAdd_in_ruleXAdditiveExpression2628);
            	    ruleOpAdd();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {
            	       
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }


            	    }


            	    }

            	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1077:4: ( (lv_rightOperand_3_0= ruleXMultiplicativeExpression ) )
            	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1078:1: (lv_rightOperand_3_0= ruleXMultiplicativeExpression )
            	    {
            	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1078:1: (lv_rightOperand_3_0= ruleXMultiplicativeExpression )
            	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1079:3: lv_rightOperand_3_0= ruleXMultiplicativeExpression
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getXAdditiveExpressionAccess().getRightOperandXMultiplicativeExpressionParserRuleCall_1_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleXMultiplicativeExpression_in_ruleXAdditiveExpression2651);
            	    lv_rightOperand_3_0=ruleXMultiplicativeExpression();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getXAdditiveExpressionRule());
            	      	        }
            	             		set(
            	             			current, 
            	             			"rightOperand",
            	              		lv_rightOperand_3_0, 
            	              		"XMultiplicativeExpression");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop15;
                }
            } while (true);


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleXAdditiveExpression"


    // $ANTLR start "entryRuleOpAdd"
    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1103:1: entryRuleOpAdd returns [String current=null] : iv_ruleOpAdd= ruleOpAdd EOF ;
    public final String entryRuleOpAdd() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleOpAdd = null;


        try {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1104:2: (iv_ruleOpAdd= ruleOpAdd EOF )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1105:2: iv_ruleOpAdd= ruleOpAdd EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getOpAddRule()); 
            }
            pushFollow(FOLLOW_ruleOpAdd_in_entryRuleOpAdd2690);
            iv_ruleOpAdd=ruleOpAdd();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleOpAdd.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleOpAdd2701); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleOpAdd"


    // $ANTLR start "ruleOpAdd"
    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1112:1: ruleOpAdd returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= '+' | kw= '-' ) ;
    public final AntlrDatatypeRuleToken ruleOpAdd() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1115:28: ( (kw= '+' | kw= '-' ) )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1116:1: (kw= '+' | kw= '-' )
            {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1116:1: (kw= '+' | kw= '-' )
            int alt16=2;
            int LA16_0 = input.LA(1);

            if ( (LA16_0==27) ) {
                alt16=1;
            }
            else if ( (LA16_0==28) ) {
                alt16=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 16, 0, input);

                throw nvae;
            }
            switch (alt16) {
                case 1 :
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1117:2: kw= '+'
                    {
                    kw=(Token)match(input,27,FOLLOW_27_in_ruleOpAdd2739); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getOpAddAccess().getPlusSignKeyword_0()); 
                          
                    }

                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1124:2: kw= '-'
                    {
                    kw=(Token)match(input,28,FOLLOW_28_in_ruleOpAdd2758); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getOpAddAccess().getHyphenMinusKeyword_1()); 
                          
                    }

                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleOpAdd"


    // $ANTLR start "entryRuleXMultiplicativeExpression"
    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1137:1: entryRuleXMultiplicativeExpression returns [EObject current=null] : iv_ruleXMultiplicativeExpression= ruleXMultiplicativeExpression EOF ;
    public final EObject entryRuleXMultiplicativeExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXMultiplicativeExpression = null;


        try {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1138:2: (iv_ruleXMultiplicativeExpression= ruleXMultiplicativeExpression EOF )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1139:2: iv_ruleXMultiplicativeExpression= ruleXMultiplicativeExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXMultiplicativeExpressionRule()); 
            }
            pushFollow(FOLLOW_ruleXMultiplicativeExpression_in_entryRuleXMultiplicativeExpression2798);
            iv_ruleXMultiplicativeExpression=ruleXMultiplicativeExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXMultiplicativeExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXMultiplicativeExpression2808); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleXMultiplicativeExpression"


    // $ANTLR start "ruleXMultiplicativeExpression"
    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1146:1: ruleXMultiplicativeExpression returns [EObject current=null] : (this_XUnaryOperation_0= ruleXUnaryOperation ( ( ( ( () ( ( ruleOpMulti ) ) ) )=> ( () ( ( ruleOpMulti ) ) ) ) ( (lv_rightOperand_3_0= ruleXUnaryOperation ) ) )* ) ;
    public final EObject ruleXMultiplicativeExpression() throws RecognitionException {
        EObject current = null;

        EObject this_XUnaryOperation_0 = null;

        EObject lv_rightOperand_3_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1149:28: ( (this_XUnaryOperation_0= ruleXUnaryOperation ( ( ( ( () ( ( ruleOpMulti ) ) ) )=> ( () ( ( ruleOpMulti ) ) ) ) ( (lv_rightOperand_3_0= ruleXUnaryOperation ) ) )* ) )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1150:1: (this_XUnaryOperation_0= ruleXUnaryOperation ( ( ( ( () ( ( ruleOpMulti ) ) ) )=> ( () ( ( ruleOpMulti ) ) ) ) ( (lv_rightOperand_3_0= ruleXUnaryOperation ) ) )* )
            {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1150:1: (this_XUnaryOperation_0= ruleXUnaryOperation ( ( ( ( () ( ( ruleOpMulti ) ) ) )=> ( () ( ( ruleOpMulti ) ) ) ) ( (lv_rightOperand_3_0= ruleXUnaryOperation ) ) )* )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1151:5: this_XUnaryOperation_0= ruleXUnaryOperation ( ( ( ( () ( ( ruleOpMulti ) ) ) )=> ( () ( ( ruleOpMulti ) ) ) ) ( (lv_rightOperand_3_0= ruleXUnaryOperation ) ) )*
            {
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getXMultiplicativeExpressionAccess().getXUnaryOperationParserRuleCall_0()); 
                  
            }
            pushFollow(FOLLOW_ruleXUnaryOperation_in_ruleXMultiplicativeExpression2855);
            this_XUnaryOperation_0=ruleXUnaryOperation();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                      current = this_XUnaryOperation_0; 
                      afterParserOrEnumRuleCall();
                  
            }
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1159:1: ( ( ( ( () ( ( ruleOpMulti ) ) ) )=> ( () ( ( ruleOpMulti ) ) ) ) ( (lv_rightOperand_3_0= ruleXUnaryOperation ) ) )*
            loop17:
            do {
                int alt17=2;
                switch ( input.LA(1) ) {
                case 29:
                    {
                    int LA17_2 = input.LA(2);

                    if ( (synpred9_InternalPureXbase()) ) {
                        alt17=1;
                    }


                    }
                    break;
                case 30:
                    {
                    int LA17_3 = input.LA(2);

                    if ( (synpred9_InternalPureXbase()) ) {
                        alt17=1;
                    }


                    }
                    break;
                case 31:
                    {
                    int LA17_4 = input.LA(2);

                    if ( (synpred9_InternalPureXbase()) ) {
                        alt17=1;
                    }


                    }
                    break;
                case 32:
                    {
                    int LA17_5 = input.LA(2);

                    if ( (synpred9_InternalPureXbase()) ) {
                        alt17=1;
                    }


                    }
                    break;

                }

                switch (alt17) {
            	case 1 :
            	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1159:2: ( ( ( () ( ( ruleOpMulti ) ) ) )=> ( () ( ( ruleOpMulti ) ) ) ) ( (lv_rightOperand_3_0= ruleXUnaryOperation ) )
            	    {
            	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1159:2: ( ( ( () ( ( ruleOpMulti ) ) ) )=> ( () ( ( ruleOpMulti ) ) ) )
            	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1159:3: ( ( () ( ( ruleOpMulti ) ) ) )=> ( () ( ( ruleOpMulti ) ) )
            	    {
            	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1164:6: ( () ( ( ruleOpMulti ) ) )
            	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1164:7: () ( ( ruleOpMulti ) )
            	    {
            	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1164:7: ()
            	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1165:5: 
            	    {
            	    if ( state.backtracking==0 ) {

            	              current = forceCreateModelElementAndSet(
            	                  grammarAccess.getXMultiplicativeExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0(),
            	                  current);
            	          
            	    }

            	    }

            	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1170:2: ( ( ruleOpMulti ) )
            	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1171:1: ( ruleOpMulti )
            	    {
            	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1171:1: ( ruleOpMulti )
            	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1172:3: ruleOpMulti
            	    {
            	    if ( state.backtracking==0 ) {

            	      			if (current==null) {
            	      	            current = createModelElement(grammarAccess.getXMultiplicativeExpressionRule());
            	      	        }
            	              
            	    }
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getXMultiplicativeExpressionAccess().getFeatureJvmIdentifiableElementCrossReference_1_0_0_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleOpMulti_in_ruleXMultiplicativeExpression2908);
            	    ruleOpMulti();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {
            	       
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }


            	    }


            	    }

            	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1185:4: ( (lv_rightOperand_3_0= ruleXUnaryOperation ) )
            	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1186:1: (lv_rightOperand_3_0= ruleXUnaryOperation )
            	    {
            	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1186:1: (lv_rightOperand_3_0= ruleXUnaryOperation )
            	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1187:3: lv_rightOperand_3_0= ruleXUnaryOperation
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getXMultiplicativeExpressionAccess().getRightOperandXUnaryOperationParserRuleCall_1_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleXUnaryOperation_in_ruleXMultiplicativeExpression2931);
            	    lv_rightOperand_3_0=ruleXUnaryOperation();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getXMultiplicativeExpressionRule());
            	      	        }
            	             		set(
            	             			current, 
            	             			"rightOperand",
            	              		lv_rightOperand_3_0, 
            	              		"XUnaryOperation");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop17;
                }
            } while (true);


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleXMultiplicativeExpression"


    // $ANTLR start "entryRuleOpMulti"
    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1211:1: entryRuleOpMulti returns [String current=null] : iv_ruleOpMulti= ruleOpMulti EOF ;
    public final String entryRuleOpMulti() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleOpMulti = null;


        try {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1212:2: (iv_ruleOpMulti= ruleOpMulti EOF )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1213:2: iv_ruleOpMulti= ruleOpMulti EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getOpMultiRule()); 
            }
            pushFollow(FOLLOW_ruleOpMulti_in_entryRuleOpMulti2970);
            iv_ruleOpMulti=ruleOpMulti();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleOpMulti.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleOpMulti2981); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleOpMulti"


    // $ANTLR start "ruleOpMulti"
    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1220:1: ruleOpMulti returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= '*' | kw= '**' | kw= '/' | kw= '%' ) ;
    public final AntlrDatatypeRuleToken ruleOpMulti() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1223:28: ( (kw= '*' | kw= '**' | kw= '/' | kw= '%' ) )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1224:1: (kw= '*' | kw= '**' | kw= '/' | kw= '%' )
            {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1224:1: (kw= '*' | kw= '**' | kw= '/' | kw= '%' )
            int alt18=4;
            switch ( input.LA(1) ) {
            case 29:
                {
                alt18=1;
                }
                break;
            case 30:
                {
                alt18=2;
                }
                break;
            case 31:
                {
                alt18=3;
                }
                break;
            case 32:
                {
                alt18=4;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 18, 0, input);

                throw nvae;
            }

            switch (alt18) {
                case 1 :
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1225:2: kw= '*'
                    {
                    kw=(Token)match(input,29,FOLLOW_29_in_ruleOpMulti3019); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getOpMultiAccess().getAsteriskKeyword_0()); 
                          
                    }

                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1232:2: kw= '**'
                    {
                    kw=(Token)match(input,30,FOLLOW_30_in_ruleOpMulti3038); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getOpMultiAccess().getAsteriskAsteriskKeyword_1()); 
                          
                    }

                    }
                    break;
                case 3 :
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1239:2: kw= '/'
                    {
                    kw=(Token)match(input,31,FOLLOW_31_in_ruleOpMulti3057); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getOpMultiAccess().getSolidusKeyword_2()); 
                          
                    }

                    }
                    break;
                case 4 :
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1246:2: kw= '%'
                    {
                    kw=(Token)match(input,32,FOLLOW_32_in_ruleOpMulti3076); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getOpMultiAccess().getPercentSignKeyword_3()); 
                          
                    }

                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleOpMulti"


    // $ANTLR start "entryRuleXUnaryOperation"
    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1259:1: entryRuleXUnaryOperation returns [EObject current=null] : iv_ruleXUnaryOperation= ruleXUnaryOperation EOF ;
    public final EObject entryRuleXUnaryOperation() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXUnaryOperation = null;


        try {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1260:2: (iv_ruleXUnaryOperation= ruleXUnaryOperation EOF )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1261:2: iv_ruleXUnaryOperation= ruleXUnaryOperation EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXUnaryOperationRule()); 
            }
            pushFollow(FOLLOW_ruleXUnaryOperation_in_entryRuleXUnaryOperation3116);
            iv_ruleXUnaryOperation=ruleXUnaryOperation();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXUnaryOperation; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXUnaryOperation3126); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleXUnaryOperation"


    // $ANTLR start "ruleXUnaryOperation"
    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1268:1: ruleXUnaryOperation returns [EObject current=null] : ( ( () ( ( ruleOpUnary ) ) ( (lv_operand_2_0= ruleXCastedExpression ) ) ) | this_XCastedExpression_3= ruleXCastedExpression ) ;
    public final EObject ruleXUnaryOperation() throws RecognitionException {
        EObject current = null;

        EObject lv_operand_2_0 = null;

        EObject this_XCastedExpression_3 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1271:28: ( ( ( () ( ( ruleOpUnary ) ) ( (lv_operand_2_0= ruleXCastedExpression ) ) ) | this_XCastedExpression_3= ruleXCastedExpression ) )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1272:1: ( ( () ( ( ruleOpUnary ) ) ( (lv_operand_2_0= ruleXCastedExpression ) ) ) | this_XCastedExpression_3= ruleXCastedExpression )
            {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1272:1: ( ( () ( ( ruleOpUnary ) ) ( (lv_operand_2_0= ruleXCastedExpression ) ) ) | this_XCastedExpression_3= ruleXCastedExpression )
            int alt19=2;
            int LA19_0 = input.LA(1);

            if ( ((LA19_0>=27 && LA19_0<=28)||LA19_0==33) ) {
                alt19=1;
            }
            else if ( ((LA19_0>=RULE_INT && LA19_0<=RULE_ID)||LA19_0==24||LA19_0==39||LA19_0==41||LA19_0==44||LA19_0==46||LA19_0==48||(LA19_0>=52 && LA19_0<=54)||LA19_0==57||(LA19_0>=59 && LA19_0<=66)) ) {
                alt19=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 19, 0, input);

                throw nvae;
            }
            switch (alt19) {
                case 1 :
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1272:2: ( () ( ( ruleOpUnary ) ) ( (lv_operand_2_0= ruleXCastedExpression ) ) )
                    {
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1272:2: ( () ( ( ruleOpUnary ) ) ( (lv_operand_2_0= ruleXCastedExpression ) ) )
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1272:3: () ( ( ruleOpUnary ) ) ( (lv_operand_2_0= ruleXCastedExpression ) )
                    {
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1272:3: ()
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1273:5: 
                    {
                    if ( state.backtracking==0 ) {

                              current = forceCreateModelElement(
                                  grammarAccess.getXUnaryOperationAccess().getXUnaryOperationAction_0_0(),
                                  current);
                          
                    }

                    }

                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1278:2: ( ( ruleOpUnary ) )
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1279:1: ( ruleOpUnary )
                    {
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1279:1: ( ruleOpUnary )
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1280:3: ruleOpUnary
                    {
                    if ( state.backtracking==0 ) {

                      			if (current==null) {
                      	            current = createModelElement(grammarAccess.getXUnaryOperationRule());
                      	        }
                              
                    }
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getXUnaryOperationAccess().getFeatureJvmIdentifiableElementCrossReference_0_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleOpUnary_in_ruleXUnaryOperation3184);
                    ruleOpUnary();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }

                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1293:2: ( (lv_operand_2_0= ruleXCastedExpression ) )
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1294:1: (lv_operand_2_0= ruleXCastedExpression )
                    {
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1294:1: (lv_operand_2_0= ruleXCastedExpression )
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1295:3: lv_operand_2_0= ruleXCastedExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getXUnaryOperationAccess().getOperandXCastedExpressionParserRuleCall_0_2_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleXCastedExpression_in_ruleXUnaryOperation3205);
                    lv_operand_2_0=ruleXCastedExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getXUnaryOperationRule());
                      	        }
                             		set(
                             			current, 
                             			"operand",
                              		lv_operand_2_0, 
                              		"XCastedExpression");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1313:5: this_XCastedExpression_3= ruleXCastedExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getXUnaryOperationAccess().getXCastedExpressionParserRuleCall_1()); 
                          
                    }
                    pushFollow(FOLLOW_ruleXCastedExpression_in_ruleXUnaryOperation3234);
                    this_XCastedExpression_3=ruleXCastedExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_XCastedExpression_3; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleXUnaryOperation"


    // $ANTLR start "entryRuleOpUnary"
    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1329:1: entryRuleOpUnary returns [String current=null] : iv_ruleOpUnary= ruleOpUnary EOF ;
    public final String entryRuleOpUnary() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleOpUnary = null;


        try {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1330:2: (iv_ruleOpUnary= ruleOpUnary EOF )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1331:2: iv_ruleOpUnary= ruleOpUnary EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getOpUnaryRule()); 
            }
            pushFollow(FOLLOW_ruleOpUnary_in_entryRuleOpUnary3270);
            iv_ruleOpUnary=ruleOpUnary();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleOpUnary.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleOpUnary3281); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleOpUnary"


    // $ANTLR start "ruleOpUnary"
    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1338:1: ruleOpUnary returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= '!' | kw= '-' | kw= '+' ) ;
    public final AntlrDatatypeRuleToken ruleOpUnary() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1341:28: ( (kw= '!' | kw= '-' | kw= '+' ) )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1342:1: (kw= '!' | kw= '-' | kw= '+' )
            {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1342:1: (kw= '!' | kw= '-' | kw= '+' )
            int alt20=3;
            switch ( input.LA(1) ) {
            case 33:
                {
                alt20=1;
                }
                break;
            case 28:
                {
                alt20=2;
                }
                break;
            case 27:
                {
                alt20=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 20, 0, input);

                throw nvae;
            }

            switch (alt20) {
                case 1 :
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1343:2: kw= '!'
                    {
                    kw=(Token)match(input,33,FOLLOW_33_in_ruleOpUnary3319); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getOpUnaryAccess().getExclamationMarkKeyword_0()); 
                          
                    }

                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1350:2: kw= '-'
                    {
                    kw=(Token)match(input,28,FOLLOW_28_in_ruleOpUnary3338); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getOpUnaryAccess().getHyphenMinusKeyword_1()); 
                          
                    }

                    }
                    break;
                case 3 :
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1357:2: kw= '+'
                    {
                    kw=(Token)match(input,27,FOLLOW_27_in_ruleOpUnary3357); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getOpUnaryAccess().getPlusSignKeyword_2()); 
                          
                    }

                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleOpUnary"


    // $ANTLR start "entryRuleXCastedExpression"
    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1370:1: entryRuleXCastedExpression returns [EObject current=null] : iv_ruleXCastedExpression= ruleXCastedExpression EOF ;
    public final EObject entryRuleXCastedExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXCastedExpression = null;


        try {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1371:2: (iv_ruleXCastedExpression= ruleXCastedExpression EOF )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1372:2: iv_ruleXCastedExpression= ruleXCastedExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXCastedExpressionRule()); 
            }
            pushFollow(FOLLOW_ruleXCastedExpression_in_entryRuleXCastedExpression3397);
            iv_ruleXCastedExpression=ruleXCastedExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXCastedExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXCastedExpression3407); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleXCastedExpression"


    // $ANTLR start "ruleXCastedExpression"
    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1379:1: ruleXCastedExpression returns [EObject current=null] : (this_XMemberFeatureCall_0= ruleXMemberFeatureCall ( ( ( ( () 'as' ) )=> ( () otherlv_2= 'as' ) ) ( (lv_type_3_0= ruleJvmTypeReference ) ) )* ) ;
    public final EObject ruleXCastedExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        EObject this_XMemberFeatureCall_0 = null;

        EObject lv_type_3_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1382:28: ( (this_XMemberFeatureCall_0= ruleXMemberFeatureCall ( ( ( ( () 'as' ) )=> ( () otherlv_2= 'as' ) ) ( (lv_type_3_0= ruleJvmTypeReference ) ) )* ) )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1383:1: (this_XMemberFeatureCall_0= ruleXMemberFeatureCall ( ( ( ( () 'as' ) )=> ( () otherlv_2= 'as' ) ) ( (lv_type_3_0= ruleJvmTypeReference ) ) )* )
            {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1383:1: (this_XMemberFeatureCall_0= ruleXMemberFeatureCall ( ( ( ( () 'as' ) )=> ( () otherlv_2= 'as' ) ) ( (lv_type_3_0= ruleJvmTypeReference ) ) )* )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1384:5: this_XMemberFeatureCall_0= ruleXMemberFeatureCall ( ( ( ( () 'as' ) )=> ( () otherlv_2= 'as' ) ) ( (lv_type_3_0= ruleJvmTypeReference ) ) )*
            {
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getXCastedExpressionAccess().getXMemberFeatureCallParserRuleCall_0()); 
                  
            }
            pushFollow(FOLLOW_ruleXMemberFeatureCall_in_ruleXCastedExpression3454);
            this_XMemberFeatureCall_0=ruleXMemberFeatureCall();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                      current = this_XMemberFeatureCall_0; 
                      afterParserOrEnumRuleCall();
                  
            }
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1392:1: ( ( ( ( () 'as' ) )=> ( () otherlv_2= 'as' ) ) ( (lv_type_3_0= ruleJvmTypeReference ) ) )*
            loop21:
            do {
                int alt21=2;
                int LA21_0 = input.LA(1);

                if ( (LA21_0==34) ) {
                    int LA21_2 = input.LA(2);

                    if ( (synpred10_InternalPureXbase()) ) {
                        alt21=1;
                    }


                }


                switch (alt21) {
            	case 1 :
            	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1392:2: ( ( ( () 'as' ) )=> ( () otherlv_2= 'as' ) ) ( (lv_type_3_0= ruleJvmTypeReference ) )
            	    {
            	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1392:2: ( ( ( () 'as' ) )=> ( () otherlv_2= 'as' ) )
            	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1392:3: ( ( () 'as' ) )=> ( () otherlv_2= 'as' )
            	    {
            	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1394:5: ( () otherlv_2= 'as' )
            	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1394:6: () otherlv_2= 'as'
            	    {
            	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1394:6: ()
            	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1395:5: 
            	    {
            	    if ( state.backtracking==0 ) {

            	              current = forceCreateModelElementAndSet(
            	                  grammarAccess.getXCastedExpressionAccess().getXCastedExpressionTargetAction_1_0_0_0(),
            	                  current);
            	          
            	    }

            	    }

            	    otherlv_2=(Token)match(input,34,FOLLOW_34_in_ruleXCastedExpression3489); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	          	newLeafNode(otherlv_2, grammarAccess.getXCastedExpressionAccess().getAsKeyword_1_0_0_1());
            	          
            	    }

            	    }


            	    }

            	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1404:3: ( (lv_type_3_0= ruleJvmTypeReference ) )
            	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1405:1: (lv_type_3_0= ruleJvmTypeReference )
            	    {
            	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1405:1: (lv_type_3_0= ruleJvmTypeReference )
            	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1406:3: lv_type_3_0= ruleJvmTypeReference
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getXCastedExpressionAccess().getTypeJvmTypeReferenceParserRuleCall_1_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleJvmTypeReference_in_ruleXCastedExpression3512);
            	    lv_type_3_0=ruleJvmTypeReference();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getXCastedExpressionRule());
            	      	        }
            	             		set(
            	             			current, 
            	             			"type",
            	              		lv_type_3_0, 
            	              		"JvmTypeReference");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop21;
                }
            } while (true);


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleXCastedExpression"


    // $ANTLR start "entryRuleXMemberFeatureCall"
    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1430:1: entryRuleXMemberFeatureCall returns [EObject current=null] : iv_ruleXMemberFeatureCall= ruleXMemberFeatureCall EOF ;
    public final EObject entryRuleXMemberFeatureCall() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXMemberFeatureCall = null;


        try {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1431:2: (iv_ruleXMemberFeatureCall= ruleXMemberFeatureCall EOF )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1432:2: iv_ruleXMemberFeatureCall= ruleXMemberFeatureCall EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXMemberFeatureCallRule()); 
            }
            pushFollow(FOLLOW_ruleXMemberFeatureCall_in_entryRuleXMemberFeatureCall3550);
            iv_ruleXMemberFeatureCall=ruleXMemberFeatureCall();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXMemberFeatureCall; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXMemberFeatureCall3560); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleXMemberFeatureCall"


    // $ANTLR start "ruleXMemberFeatureCall"
    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1439:1: ruleXMemberFeatureCall returns [EObject current=null] : (this_XPrimaryExpression_0= ruleXPrimaryExpression ( ( ( ( ( () '.' ( ( ruleValidID ) ) ruleOpSingleAssign ) )=> ( () otherlv_2= '.' ( ( ruleValidID ) ) ruleOpSingleAssign ) ) ( (lv_value_5_0= ruleXAssignment ) ) ) | ( ( ( ( () ( '.' | ( ( '?.' ) ) | ( ( '*.' ) ) ) ) )=> ( () (otherlv_7= '.' | ( (lv_nullSafe_8_0= '?.' ) ) | ( (lv_spreading_9_0= '*.' ) ) ) ) ) (otherlv_10= '<' ( (lv_typeArguments_11_0= ruleJvmArgumentTypeReference ) ) (otherlv_12= ',' ( (lv_typeArguments_13_0= ruleJvmArgumentTypeReference ) ) )* otherlv_14= '>' )? ( ( ruleValidID ) ) ( ( ( ( '(' ) )=> (lv_explicitOperationCall_16_0= '(' ) ) ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> (lv_memberCallArguments_17_0= ruleXShortClosure ) ) | ( ( (lv_memberCallArguments_18_0= ruleXExpression ) ) (otherlv_19= ',' ( (lv_memberCallArguments_20_0= ruleXExpression ) ) )* ) )? otherlv_21= ')' )? ( ( ( ruleXClosure ) )=> (lv_memberCallArguments_22_0= ruleXClosure ) )? ) )* ) ;
    public final EObject ruleXMemberFeatureCall() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        Token otherlv_7=null;
        Token lv_nullSafe_8_0=null;
        Token lv_spreading_9_0=null;
        Token otherlv_10=null;
        Token otherlv_12=null;
        Token otherlv_14=null;
        Token lv_explicitOperationCall_16_0=null;
        Token otherlv_19=null;
        Token otherlv_21=null;
        EObject this_XPrimaryExpression_0 = null;

        EObject lv_value_5_0 = null;

        EObject lv_typeArguments_11_0 = null;

        EObject lv_typeArguments_13_0 = null;

        EObject lv_memberCallArguments_17_0 = null;

        EObject lv_memberCallArguments_18_0 = null;

        EObject lv_memberCallArguments_20_0 = null;

        EObject lv_memberCallArguments_22_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1442:28: ( (this_XPrimaryExpression_0= ruleXPrimaryExpression ( ( ( ( ( () '.' ( ( ruleValidID ) ) ruleOpSingleAssign ) )=> ( () otherlv_2= '.' ( ( ruleValidID ) ) ruleOpSingleAssign ) ) ( (lv_value_5_0= ruleXAssignment ) ) ) | ( ( ( ( () ( '.' | ( ( '?.' ) ) | ( ( '*.' ) ) ) ) )=> ( () (otherlv_7= '.' | ( (lv_nullSafe_8_0= '?.' ) ) | ( (lv_spreading_9_0= '*.' ) ) ) ) ) (otherlv_10= '<' ( (lv_typeArguments_11_0= ruleJvmArgumentTypeReference ) ) (otherlv_12= ',' ( (lv_typeArguments_13_0= ruleJvmArgumentTypeReference ) ) )* otherlv_14= '>' )? ( ( ruleValidID ) ) ( ( ( ( '(' ) )=> (lv_explicitOperationCall_16_0= '(' ) ) ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> (lv_memberCallArguments_17_0= ruleXShortClosure ) ) | ( ( (lv_memberCallArguments_18_0= ruleXExpression ) ) (otherlv_19= ',' ( (lv_memberCallArguments_20_0= ruleXExpression ) ) )* ) )? otherlv_21= ')' )? ( ( ( ruleXClosure ) )=> (lv_memberCallArguments_22_0= ruleXClosure ) )? ) )* ) )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1443:1: (this_XPrimaryExpression_0= ruleXPrimaryExpression ( ( ( ( ( () '.' ( ( ruleValidID ) ) ruleOpSingleAssign ) )=> ( () otherlv_2= '.' ( ( ruleValidID ) ) ruleOpSingleAssign ) ) ( (lv_value_5_0= ruleXAssignment ) ) ) | ( ( ( ( () ( '.' | ( ( '?.' ) ) | ( ( '*.' ) ) ) ) )=> ( () (otherlv_7= '.' | ( (lv_nullSafe_8_0= '?.' ) ) | ( (lv_spreading_9_0= '*.' ) ) ) ) ) (otherlv_10= '<' ( (lv_typeArguments_11_0= ruleJvmArgumentTypeReference ) ) (otherlv_12= ',' ( (lv_typeArguments_13_0= ruleJvmArgumentTypeReference ) ) )* otherlv_14= '>' )? ( ( ruleValidID ) ) ( ( ( ( '(' ) )=> (lv_explicitOperationCall_16_0= '(' ) ) ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> (lv_memberCallArguments_17_0= ruleXShortClosure ) ) | ( ( (lv_memberCallArguments_18_0= ruleXExpression ) ) (otherlv_19= ',' ( (lv_memberCallArguments_20_0= ruleXExpression ) ) )* ) )? otherlv_21= ')' )? ( ( ( ruleXClosure ) )=> (lv_memberCallArguments_22_0= ruleXClosure ) )? ) )* )
            {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1443:1: (this_XPrimaryExpression_0= ruleXPrimaryExpression ( ( ( ( ( () '.' ( ( ruleValidID ) ) ruleOpSingleAssign ) )=> ( () otherlv_2= '.' ( ( ruleValidID ) ) ruleOpSingleAssign ) ) ( (lv_value_5_0= ruleXAssignment ) ) ) | ( ( ( ( () ( '.' | ( ( '?.' ) ) | ( ( '*.' ) ) ) ) )=> ( () (otherlv_7= '.' | ( (lv_nullSafe_8_0= '?.' ) ) | ( (lv_spreading_9_0= '*.' ) ) ) ) ) (otherlv_10= '<' ( (lv_typeArguments_11_0= ruleJvmArgumentTypeReference ) ) (otherlv_12= ',' ( (lv_typeArguments_13_0= ruleJvmArgumentTypeReference ) ) )* otherlv_14= '>' )? ( ( ruleValidID ) ) ( ( ( ( '(' ) )=> (lv_explicitOperationCall_16_0= '(' ) ) ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> (lv_memberCallArguments_17_0= ruleXShortClosure ) ) | ( ( (lv_memberCallArguments_18_0= ruleXExpression ) ) (otherlv_19= ',' ( (lv_memberCallArguments_20_0= ruleXExpression ) ) )* ) )? otherlv_21= ')' )? ( ( ( ruleXClosure ) )=> (lv_memberCallArguments_22_0= ruleXClosure ) )? ) )* )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1444:5: this_XPrimaryExpression_0= ruleXPrimaryExpression ( ( ( ( ( () '.' ( ( ruleValidID ) ) ruleOpSingleAssign ) )=> ( () otherlv_2= '.' ( ( ruleValidID ) ) ruleOpSingleAssign ) ) ( (lv_value_5_0= ruleXAssignment ) ) ) | ( ( ( ( () ( '.' | ( ( '?.' ) ) | ( ( '*.' ) ) ) ) )=> ( () (otherlv_7= '.' | ( (lv_nullSafe_8_0= '?.' ) ) | ( (lv_spreading_9_0= '*.' ) ) ) ) ) (otherlv_10= '<' ( (lv_typeArguments_11_0= ruleJvmArgumentTypeReference ) ) (otherlv_12= ',' ( (lv_typeArguments_13_0= ruleJvmArgumentTypeReference ) ) )* otherlv_14= '>' )? ( ( ruleValidID ) ) ( ( ( ( '(' ) )=> (lv_explicitOperationCall_16_0= '(' ) ) ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> (lv_memberCallArguments_17_0= ruleXShortClosure ) ) | ( ( (lv_memberCallArguments_18_0= ruleXExpression ) ) (otherlv_19= ',' ( (lv_memberCallArguments_20_0= ruleXExpression ) ) )* ) )? otherlv_21= ')' )? ( ( ( ruleXClosure ) )=> (lv_memberCallArguments_22_0= ruleXClosure ) )? ) )*
            {
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getXMemberFeatureCallAccess().getXPrimaryExpressionParserRuleCall_0()); 
                  
            }
            pushFollow(FOLLOW_ruleXPrimaryExpression_in_ruleXMemberFeatureCall3607);
            this_XPrimaryExpression_0=ruleXPrimaryExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                      current = this_XPrimaryExpression_0; 
                      afterParserOrEnumRuleCall();
                  
            }
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1452:1: ( ( ( ( ( () '.' ( ( ruleValidID ) ) ruleOpSingleAssign ) )=> ( () otherlv_2= '.' ( ( ruleValidID ) ) ruleOpSingleAssign ) ) ( (lv_value_5_0= ruleXAssignment ) ) ) | ( ( ( ( () ( '.' | ( ( '?.' ) ) | ( ( '*.' ) ) ) ) )=> ( () (otherlv_7= '.' | ( (lv_nullSafe_8_0= '?.' ) ) | ( (lv_spreading_9_0= '*.' ) ) ) ) ) (otherlv_10= '<' ( (lv_typeArguments_11_0= ruleJvmArgumentTypeReference ) ) (otherlv_12= ',' ( (lv_typeArguments_13_0= ruleJvmArgumentTypeReference ) ) )* otherlv_14= '>' )? ( ( ruleValidID ) ) ( ( ( ( '(' ) )=> (lv_explicitOperationCall_16_0= '(' ) ) ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> (lv_memberCallArguments_17_0= ruleXShortClosure ) ) | ( ( (lv_memberCallArguments_18_0= ruleXExpression ) ) (otherlv_19= ',' ( (lv_memberCallArguments_20_0= ruleXExpression ) ) )* ) )? otherlv_21= ')' )? ( ( ( ruleXClosure ) )=> (lv_memberCallArguments_22_0= ruleXClosure ) )? ) )*
            loop29:
            do {
                int alt29=3;
                switch ( input.LA(1) ) {
                case 35:
                    {
                    int LA29_2 = input.LA(2);

                    if ( (synpred11_InternalPureXbase()) ) {
                        alt29=1;
                    }
                    else if ( (synpred12_InternalPureXbase()) ) {
                        alt29=2;
                    }


                    }
                    break;
                case 36:
                    {
                    int LA29_3 = input.LA(2);

                    if ( (synpred12_InternalPureXbase()) ) {
                        alt29=2;
                    }


                    }
                    break;
                case 37:
                    {
                    int LA29_4 = input.LA(2);

                    if ( (synpred12_InternalPureXbase()) ) {
                        alt29=2;
                    }


                    }
                    break;

                }

                switch (alt29) {
            	case 1 :
            	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1452:2: ( ( ( ( () '.' ( ( ruleValidID ) ) ruleOpSingleAssign ) )=> ( () otherlv_2= '.' ( ( ruleValidID ) ) ruleOpSingleAssign ) ) ( (lv_value_5_0= ruleXAssignment ) ) )
            	    {
            	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1452:2: ( ( ( ( () '.' ( ( ruleValidID ) ) ruleOpSingleAssign ) )=> ( () otherlv_2= '.' ( ( ruleValidID ) ) ruleOpSingleAssign ) ) ( (lv_value_5_0= ruleXAssignment ) ) )
            	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1452:3: ( ( ( () '.' ( ( ruleValidID ) ) ruleOpSingleAssign ) )=> ( () otherlv_2= '.' ( ( ruleValidID ) ) ruleOpSingleAssign ) ) ( (lv_value_5_0= ruleXAssignment ) )
            	    {
            	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1452:3: ( ( ( () '.' ( ( ruleValidID ) ) ruleOpSingleAssign ) )=> ( () otherlv_2= '.' ( ( ruleValidID ) ) ruleOpSingleAssign ) )
            	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1452:4: ( ( () '.' ( ( ruleValidID ) ) ruleOpSingleAssign ) )=> ( () otherlv_2= '.' ( ( ruleValidID ) ) ruleOpSingleAssign )
            	    {
            	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1458:25: ( () otherlv_2= '.' ( ( ruleValidID ) ) ruleOpSingleAssign )
            	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1458:26: () otherlv_2= '.' ( ( ruleValidID ) ) ruleOpSingleAssign
            	    {
            	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1458:26: ()
            	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1459:5: 
            	    {
            	    if ( state.backtracking==0 ) {

            	              current = forceCreateModelElementAndSet(
            	                  grammarAccess.getXMemberFeatureCallAccess().getXAssignmentAssignableAction_1_0_0_0_0(),
            	                  current);
            	          
            	    }

            	    }

            	    otherlv_2=(Token)match(input,35,FOLLOW_35_in_ruleXMemberFeatureCall3656); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	          	newLeafNode(otherlv_2, grammarAccess.getXMemberFeatureCallAccess().getFullStopKeyword_1_0_0_0_1());
            	          
            	    }
            	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1468:1: ( ( ruleValidID ) )
            	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1469:1: ( ruleValidID )
            	    {
            	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1469:1: ( ruleValidID )
            	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1470:3: ruleValidID
            	    {
            	    if ( state.backtracking==0 ) {

            	      			if (current==null) {
            	      	            current = createModelElement(grammarAccess.getXMemberFeatureCallRule());
            	      	        }
            	              
            	    }
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getXMemberFeatureCallAccess().getFeatureJvmIdentifiableElementCrossReference_1_0_0_0_2_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleValidID_in_ruleXMemberFeatureCall3679);
            	    ruleValidID();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {
            	       
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }

            	    if ( state.backtracking==0 ) {
            	       
            	              newCompositeNode(grammarAccess.getXMemberFeatureCallAccess().getOpSingleAssignParserRuleCall_1_0_0_0_3()); 
            	          
            	    }
            	    pushFollow(FOLLOW_ruleOpSingleAssign_in_ruleXMemberFeatureCall3695);
            	    ruleOpSingleAssign();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {
            	       
            	              afterParserOrEnumRuleCall();
            	          
            	    }

            	    }


            	    }

            	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1491:3: ( (lv_value_5_0= ruleXAssignment ) )
            	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1492:1: (lv_value_5_0= ruleXAssignment )
            	    {
            	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1492:1: (lv_value_5_0= ruleXAssignment )
            	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1493:3: lv_value_5_0= ruleXAssignment
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getXMemberFeatureCallAccess().getValueXAssignmentParserRuleCall_1_0_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleXAssignment_in_ruleXMemberFeatureCall3717);
            	    lv_value_5_0=ruleXAssignment();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getXMemberFeatureCallRule());
            	      	        }
            	             		set(
            	             			current, 
            	             			"value",
            	              		lv_value_5_0, 
            	              		"XAssignment");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }


            	    }


            	    }
            	    break;
            	case 2 :
            	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1510:6: ( ( ( ( () ( '.' | ( ( '?.' ) ) | ( ( '*.' ) ) ) ) )=> ( () (otherlv_7= '.' | ( (lv_nullSafe_8_0= '?.' ) ) | ( (lv_spreading_9_0= '*.' ) ) ) ) ) (otherlv_10= '<' ( (lv_typeArguments_11_0= ruleJvmArgumentTypeReference ) ) (otherlv_12= ',' ( (lv_typeArguments_13_0= ruleJvmArgumentTypeReference ) ) )* otherlv_14= '>' )? ( ( ruleValidID ) ) ( ( ( ( '(' ) )=> (lv_explicitOperationCall_16_0= '(' ) ) ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> (lv_memberCallArguments_17_0= ruleXShortClosure ) ) | ( ( (lv_memberCallArguments_18_0= ruleXExpression ) ) (otherlv_19= ',' ( (lv_memberCallArguments_20_0= ruleXExpression ) ) )* ) )? otherlv_21= ')' )? ( ( ( ruleXClosure ) )=> (lv_memberCallArguments_22_0= ruleXClosure ) )? )
            	    {
            	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1510:6: ( ( ( ( () ( '.' | ( ( '?.' ) ) | ( ( '*.' ) ) ) ) )=> ( () (otherlv_7= '.' | ( (lv_nullSafe_8_0= '?.' ) ) | ( (lv_spreading_9_0= '*.' ) ) ) ) ) (otherlv_10= '<' ( (lv_typeArguments_11_0= ruleJvmArgumentTypeReference ) ) (otherlv_12= ',' ( (lv_typeArguments_13_0= ruleJvmArgumentTypeReference ) ) )* otherlv_14= '>' )? ( ( ruleValidID ) ) ( ( ( ( '(' ) )=> (lv_explicitOperationCall_16_0= '(' ) ) ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> (lv_memberCallArguments_17_0= ruleXShortClosure ) ) | ( ( (lv_memberCallArguments_18_0= ruleXExpression ) ) (otherlv_19= ',' ( (lv_memberCallArguments_20_0= ruleXExpression ) ) )* ) )? otherlv_21= ')' )? ( ( ( ruleXClosure ) )=> (lv_memberCallArguments_22_0= ruleXClosure ) )? )
            	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1510:7: ( ( ( () ( '.' | ( ( '?.' ) ) | ( ( '*.' ) ) ) ) )=> ( () (otherlv_7= '.' | ( (lv_nullSafe_8_0= '?.' ) ) | ( (lv_spreading_9_0= '*.' ) ) ) ) ) (otherlv_10= '<' ( (lv_typeArguments_11_0= ruleJvmArgumentTypeReference ) ) (otherlv_12= ',' ( (lv_typeArguments_13_0= ruleJvmArgumentTypeReference ) ) )* otherlv_14= '>' )? ( ( ruleValidID ) ) ( ( ( ( '(' ) )=> (lv_explicitOperationCall_16_0= '(' ) ) ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> (lv_memberCallArguments_17_0= ruleXShortClosure ) ) | ( ( (lv_memberCallArguments_18_0= ruleXExpression ) ) (otherlv_19= ',' ( (lv_memberCallArguments_20_0= ruleXExpression ) ) )* ) )? otherlv_21= ')' )? ( ( ( ruleXClosure ) )=> (lv_memberCallArguments_22_0= ruleXClosure ) )?
            	    {
            	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1510:7: ( ( ( () ( '.' | ( ( '?.' ) ) | ( ( '*.' ) ) ) ) )=> ( () (otherlv_7= '.' | ( (lv_nullSafe_8_0= '?.' ) ) | ( (lv_spreading_9_0= '*.' ) ) ) ) )
            	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1510:8: ( ( () ( '.' | ( ( '?.' ) ) | ( ( '*.' ) ) ) ) )=> ( () (otherlv_7= '.' | ( (lv_nullSafe_8_0= '?.' ) ) | ( (lv_spreading_9_0= '*.' ) ) ) )
            	    {
            	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1526:7: ( () (otherlv_7= '.' | ( (lv_nullSafe_8_0= '?.' ) ) | ( (lv_spreading_9_0= '*.' ) ) ) )
            	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1526:8: () (otherlv_7= '.' | ( (lv_nullSafe_8_0= '?.' ) ) | ( (lv_spreading_9_0= '*.' ) ) )
            	    {
            	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1526:8: ()
            	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1527:5: 
            	    {
            	    if ( state.backtracking==0 ) {

            	              current = forceCreateModelElementAndSet(
            	                  grammarAccess.getXMemberFeatureCallAccess().getXMemberFeatureCallMemberCallTargetAction_1_1_0_0_0(),
            	                  current);
            	          
            	    }

            	    }

            	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1532:2: (otherlv_7= '.' | ( (lv_nullSafe_8_0= '?.' ) ) | ( (lv_spreading_9_0= '*.' ) ) )
            	    int alt22=3;
            	    switch ( input.LA(1) ) {
            	    case 35:
            	        {
            	        alt22=1;
            	        }
            	        break;
            	    case 36:
            	        {
            	        alt22=2;
            	        }
            	        break;
            	    case 37:
            	        {
            	        alt22=3;
            	        }
            	        break;
            	    default:
            	        if (state.backtracking>0) {state.failed=true; return current;}
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 22, 0, input);

            	        throw nvae;
            	    }

            	    switch (alt22) {
            	        case 1 :
            	            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1532:4: otherlv_7= '.'
            	            {
            	            otherlv_7=(Token)match(input,35,FOLLOW_35_in_ruleXMemberFeatureCall3803); if (state.failed) return current;
            	            if ( state.backtracking==0 ) {

            	                  	newLeafNode(otherlv_7, grammarAccess.getXMemberFeatureCallAccess().getFullStopKeyword_1_1_0_0_1_0());
            	                  
            	            }

            	            }
            	            break;
            	        case 2 :
            	            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1537:6: ( (lv_nullSafe_8_0= '?.' ) )
            	            {
            	            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1537:6: ( (lv_nullSafe_8_0= '?.' ) )
            	            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1538:1: (lv_nullSafe_8_0= '?.' )
            	            {
            	            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1538:1: (lv_nullSafe_8_0= '?.' )
            	            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1539:3: lv_nullSafe_8_0= '?.'
            	            {
            	            lv_nullSafe_8_0=(Token)match(input,36,FOLLOW_36_in_ruleXMemberFeatureCall3827); if (state.failed) return current;
            	            if ( state.backtracking==0 ) {

            	                      newLeafNode(lv_nullSafe_8_0, grammarAccess.getXMemberFeatureCallAccess().getNullSafeQuestionMarkFullStopKeyword_1_1_0_0_1_1_0());
            	                  
            	            }
            	            if ( state.backtracking==0 ) {

            	              	        if (current==null) {
            	              	            current = createModelElement(grammarAccess.getXMemberFeatureCallRule());
            	              	        }
            	                     		setWithLastConsumed(current, "nullSafe", true, "?.");
            	              	    
            	            }

            	            }


            	            }


            	            }
            	            break;
            	        case 3 :
            	            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1553:6: ( (lv_spreading_9_0= '*.' ) )
            	            {
            	            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1553:6: ( (lv_spreading_9_0= '*.' ) )
            	            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1554:1: (lv_spreading_9_0= '*.' )
            	            {
            	            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1554:1: (lv_spreading_9_0= '*.' )
            	            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1555:3: lv_spreading_9_0= '*.'
            	            {
            	            lv_spreading_9_0=(Token)match(input,37,FOLLOW_37_in_ruleXMemberFeatureCall3864); if (state.failed) return current;
            	            if ( state.backtracking==0 ) {

            	                      newLeafNode(lv_spreading_9_0, grammarAccess.getXMemberFeatureCallAccess().getSpreadingAsteriskFullStopKeyword_1_1_0_0_1_2_0());
            	                  
            	            }
            	            if ( state.backtracking==0 ) {

            	              	        if (current==null) {
            	              	            current = createModelElement(grammarAccess.getXMemberFeatureCallRule());
            	              	        }
            	                     		setWithLastConsumed(current, "spreading", true, "*.");
            	              	    
            	            }

            	            }


            	            }


            	            }
            	            break;

            	    }


            	    }


            	    }

            	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1568:5: (otherlv_10= '<' ( (lv_typeArguments_11_0= ruleJvmArgumentTypeReference ) ) (otherlv_12= ',' ( (lv_typeArguments_13_0= ruleJvmArgumentTypeReference ) ) )* otherlv_14= '>' )?
            	    int alt24=2;
            	    int LA24_0 = input.LA(1);

            	    if ( (LA24_0==24) ) {
            	        alt24=1;
            	    }
            	    switch (alt24) {
            	        case 1 :
            	            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1568:7: otherlv_10= '<' ( (lv_typeArguments_11_0= ruleJvmArgumentTypeReference ) ) (otherlv_12= ',' ( (lv_typeArguments_13_0= ruleJvmArgumentTypeReference ) ) )* otherlv_14= '>'
            	            {
            	            otherlv_10=(Token)match(input,24,FOLLOW_24_in_ruleXMemberFeatureCall3893); if (state.failed) return current;
            	            if ( state.backtracking==0 ) {

            	                  	newLeafNode(otherlv_10, grammarAccess.getXMemberFeatureCallAccess().getLessThanSignKeyword_1_1_1_0());
            	                  
            	            }
            	            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1572:1: ( (lv_typeArguments_11_0= ruleJvmArgumentTypeReference ) )
            	            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1573:1: (lv_typeArguments_11_0= ruleJvmArgumentTypeReference )
            	            {
            	            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1573:1: (lv_typeArguments_11_0= ruleJvmArgumentTypeReference )
            	            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1574:3: lv_typeArguments_11_0= ruleJvmArgumentTypeReference
            	            {
            	            if ( state.backtracking==0 ) {
            	               
            	              	        newCompositeNode(grammarAccess.getXMemberFeatureCallAccess().getTypeArgumentsJvmArgumentTypeReferenceParserRuleCall_1_1_1_1_0()); 
            	              	    
            	            }
            	            pushFollow(FOLLOW_ruleJvmArgumentTypeReference_in_ruleXMemberFeatureCall3914);
            	            lv_typeArguments_11_0=ruleJvmArgumentTypeReference();

            	            state._fsp--;
            	            if (state.failed) return current;
            	            if ( state.backtracking==0 ) {

            	              	        if (current==null) {
            	              	            current = createModelElementForParent(grammarAccess.getXMemberFeatureCallRule());
            	              	        }
            	                     		add(
            	                     			current, 
            	                     			"typeArguments",
            	                      		lv_typeArguments_11_0, 
            	                      		"JvmArgumentTypeReference");
            	              	        afterParserOrEnumRuleCall();
            	              	    
            	            }

            	            }


            	            }

            	            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1590:2: (otherlv_12= ',' ( (lv_typeArguments_13_0= ruleJvmArgumentTypeReference ) ) )*
            	            loop23:
            	            do {
            	                int alt23=2;
            	                int LA23_0 = input.LA(1);

            	                if ( (LA23_0==38) ) {
            	                    alt23=1;
            	                }


            	                switch (alt23) {
            	            	case 1 :
            	            	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1590:4: otherlv_12= ',' ( (lv_typeArguments_13_0= ruleJvmArgumentTypeReference ) )
            	            	    {
            	            	    otherlv_12=(Token)match(input,38,FOLLOW_38_in_ruleXMemberFeatureCall3927); if (state.failed) return current;
            	            	    if ( state.backtracking==0 ) {

            	            	          	newLeafNode(otherlv_12, grammarAccess.getXMemberFeatureCallAccess().getCommaKeyword_1_1_1_2_0());
            	            	          
            	            	    }
            	            	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1594:1: ( (lv_typeArguments_13_0= ruleJvmArgumentTypeReference ) )
            	            	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1595:1: (lv_typeArguments_13_0= ruleJvmArgumentTypeReference )
            	            	    {
            	            	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1595:1: (lv_typeArguments_13_0= ruleJvmArgumentTypeReference )
            	            	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1596:3: lv_typeArguments_13_0= ruleJvmArgumentTypeReference
            	            	    {
            	            	    if ( state.backtracking==0 ) {
            	            	       
            	            	      	        newCompositeNode(grammarAccess.getXMemberFeatureCallAccess().getTypeArgumentsJvmArgumentTypeReferenceParserRuleCall_1_1_1_2_1_0()); 
            	            	      	    
            	            	    }
            	            	    pushFollow(FOLLOW_ruleJvmArgumentTypeReference_in_ruleXMemberFeatureCall3948);
            	            	    lv_typeArguments_13_0=ruleJvmArgumentTypeReference();

            	            	    state._fsp--;
            	            	    if (state.failed) return current;
            	            	    if ( state.backtracking==0 ) {

            	            	      	        if (current==null) {
            	            	      	            current = createModelElementForParent(grammarAccess.getXMemberFeatureCallRule());
            	            	      	        }
            	            	             		add(
            	            	             			current, 
            	            	             			"typeArguments",
            	            	              		lv_typeArguments_13_0, 
            	            	              		"JvmArgumentTypeReference");
            	            	      	        afterParserOrEnumRuleCall();
            	            	      	    
            	            	    }

            	            	    }


            	            	    }


            	            	    }
            	            	    break;

            	            	default :
            	            	    break loop23;
            	                }
            	            } while (true);

            	            otherlv_14=(Token)match(input,23,FOLLOW_23_in_ruleXMemberFeatureCall3962); if (state.failed) return current;
            	            if ( state.backtracking==0 ) {

            	                  	newLeafNode(otherlv_14, grammarAccess.getXMemberFeatureCallAccess().getGreaterThanSignKeyword_1_1_1_3());
            	                  
            	            }

            	            }
            	            break;

            	    }

            	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1616:3: ( ( ruleValidID ) )
            	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1617:1: ( ruleValidID )
            	    {
            	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1617:1: ( ruleValidID )
            	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1618:3: ruleValidID
            	    {
            	    if ( state.backtracking==0 ) {

            	      			if (current==null) {
            	      	            current = createModelElement(grammarAccess.getXMemberFeatureCallRule());
            	      	        }
            	              
            	    }
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getXMemberFeatureCallAccess().getFeatureJvmIdentifiableElementCrossReference_1_1_2_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleValidID_in_ruleXMemberFeatureCall3987);
            	    ruleValidID();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {
            	       
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }

            	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1631:2: ( ( ( ( '(' ) )=> (lv_explicitOperationCall_16_0= '(' ) ) ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> (lv_memberCallArguments_17_0= ruleXShortClosure ) ) | ( ( (lv_memberCallArguments_18_0= ruleXExpression ) ) (otherlv_19= ',' ( (lv_memberCallArguments_20_0= ruleXExpression ) ) )* ) )? otherlv_21= ')' )?
            	    int alt27=2;
            	    alt27 = dfa27.predict(input);
            	    switch (alt27) {
            	        case 1 :
            	            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1631:3: ( ( ( '(' ) )=> (lv_explicitOperationCall_16_0= '(' ) ) ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> (lv_memberCallArguments_17_0= ruleXShortClosure ) ) | ( ( (lv_memberCallArguments_18_0= ruleXExpression ) ) (otherlv_19= ',' ( (lv_memberCallArguments_20_0= ruleXExpression ) ) )* ) )? otherlv_21= ')'
            	            {
            	            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1631:3: ( ( ( '(' ) )=> (lv_explicitOperationCall_16_0= '(' ) )
            	            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1631:4: ( ( '(' ) )=> (lv_explicitOperationCall_16_0= '(' )
            	            {
            	            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1638:1: (lv_explicitOperationCall_16_0= '(' )
            	            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1639:3: lv_explicitOperationCall_16_0= '('
            	            {
            	            lv_explicitOperationCall_16_0=(Token)match(input,39,FOLLOW_39_in_ruleXMemberFeatureCall4021); if (state.failed) return current;
            	            if ( state.backtracking==0 ) {

            	                      newLeafNode(lv_explicitOperationCall_16_0, grammarAccess.getXMemberFeatureCallAccess().getExplicitOperationCallLeftParenthesisKeyword_1_1_3_0_0());
            	                  
            	            }
            	            if ( state.backtracking==0 ) {

            	              	        if (current==null) {
            	              	            current = createModelElement(grammarAccess.getXMemberFeatureCallRule());
            	              	        }
            	                     		setWithLastConsumed(current, "explicitOperationCall", true, "(");
            	              	    
            	            }

            	            }


            	            }

            	            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1652:2: ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> (lv_memberCallArguments_17_0= ruleXShortClosure ) ) | ( ( (lv_memberCallArguments_18_0= ruleXExpression ) ) (otherlv_19= ',' ( (lv_memberCallArguments_20_0= ruleXExpression ) ) )* ) )?
            	            int alt26=3;
            	            alt26 = dfa26.predict(input);
            	            switch (alt26) {
            	                case 1 :
            	                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1652:3: ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> (lv_memberCallArguments_17_0= ruleXShortClosure ) )
            	                    {
            	                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1652:3: ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> (lv_memberCallArguments_17_0= ruleXShortClosure ) )
            	                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1652:4: ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> (lv_memberCallArguments_17_0= ruleXShortClosure )
            	                    {
            	                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1669:1: (lv_memberCallArguments_17_0= ruleXShortClosure )
            	                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1670:3: lv_memberCallArguments_17_0= ruleXShortClosure
            	                    {
            	                    if ( state.backtracking==0 ) {
            	                       
            	                      	        newCompositeNode(grammarAccess.getXMemberFeatureCallAccess().getMemberCallArgumentsXShortClosureParserRuleCall_1_1_3_1_0_0()); 
            	                      	    
            	                    }
            	                    pushFollow(FOLLOW_ruleXShortClosure_in_ruleXMemberFeatureCall4106);
            	                    lv_memberCallArguments_17_0=ruleXShortClosure();

            	                    state._fsp--;
            	                    if (state.failed) return current;
            	                    if ( state.backtracking==0 ) {

            	                      	        if (current==null) {
            	                      	            current = createModelElementForParent(grammarAccess.getXMemberFeatureCallRule());
            	                      	        }
            	                             		add(
            	                             			current, 
            	                             			"memberCallArguments",
            	                              		lv_memberCallArguments_17_0, 
            	                              		"XShortClosure");
            	                      	        afterParserOrEnumRuleCall();
            	                      	    
            	                    }

            	                    }


            	                    }


            	                    }
            	                    break;
            	                case 2 :
            	                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1687:6: ( ( (lv_memberCallArguments_18_0= ruleXExpression ) ) (otherlv_19= ',' ( (lv_memberCallArguments_20_0= ruleXExpression ) ) )* )
            	                    {
            	                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1687:6: ( ( (lv_memberCallArguments_18_0= ruleXExpression ) ) (otherlv_19= ',' ( (lv_memberCallArguments_20_0= ruleXExpression ) ) )* )
            	                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1687:7: ( (lv_memberCallArguments_18_0= ruleXExpression ) ) (otherlv_19= ',' ( (lv_memberCallArguments_20_0= ruleXExpression ) ) )*
            	                    {
            	                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1687:7: ( (lv_memberCallArguments_18_0= ruleXExpression ) )
            	                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1688:1: (lv_memberCallArguments_18_0= ruleXExpression )
            	                    {
            	                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1688:1: (lv_memberCallArguments_18_0= ruleXExpression )
            	                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1689:3: lv_memberCallArguments_18_0= ruleXExpression
            	                    {
            	                    if ( state.backtracking==0 ) {
            	                       
            	                      	        newCompositeNode(grammarAccess.getXMemberFeatureCallAccess().getMemberCallArgumentsXExpressionParserRuleCall_1_1_3_1_1_0_0()); 
            	                      	    
            	                    }
            	                    pushFollow(FOLLOW_ruleXExpression_in_ruleXMemberFeatureCall4134);
            	                    lv_memberCallArguments_18_0=ruleXExpression();

            	                    state._fsp--;
            	                    if (state.failed) return current;
            	                    if ( state.backtracking==0 ) {

            	                      	        if (current==null) {
            	                      	            current = createModelElementForParent(grammarAccess.getXMemberFeatureCallRule());
            	                      	        }
            	                             		add(
            	                             			current, 
            	                             			"memberCallArguments",
            	                              		lv_memberCallArguments_18_0, 
            	                              		"XExpression");
            	                      	        afterParserOrEnumRuleCall();
            	                      	    
            	                    }

            	                    }


            	                    }

            	                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1705:2: (otherlv_19= ',' ( (lv_memberCallArguments_20_0= ruleXExpression ) ) )*
            	                    loop25:
            	                    do {
            	                        int alt25=2;
            	                        int LA25_0 = input.LA(1);

            	                        if ( (LA25_0==38) ) {
            	                            alt25=1;
            	                        }


            	                        switch (alt25) {
            	                    	case 1 :
            	                    	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1705:4: otherlv_19= ',' ( (lv_memberCallArguments_20_0= ruleXExpression ) )
            	                    	    {
            	                    	    otherlv_19=(Token)match(input,38,FOLLOW_38_in_ruleXMemberFeatureCall4147); if (state.failed) return current;
            	                    	    if ( state.backtracking==0 ) {

            	                    	          	newLeafNode(otherlv_19, grammarAccess.getXMemberFeatureCallAccess().getCommaKeyword_1_1_3_1_1_1_0());
            	                    	          
            	                    	    }
            	                    	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1709:1: ( (lv_memberCallArguments_20_0= ruleXExpression ) )
            	                    	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1710:1: (lv_memberCallArguments_20_0= ruleXExpression )
            	                    	    {
            	                    	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1710:1: (lv_memberCallArguments_20_0= ruleXExpression )
            	                    	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1711:3: lv_memberCallArguments_20_0= ruleXExpression
            	                    	    {
            	                    	    if ( state.backtracking==0 ) {
            	                    	       
            	                    	      	        newCompositeNode(grammarAccess.getXMemberFeatureCallAccess().getMemberCallArgumentsXExpressionParserRuleCall_1_1_3_1_1_1_1_0()); 
            	                    	      	    
            	                    	    }
            	                    	    pushFollow(FOLLOW_ruleXExpression_in_ruleXMemberFeatureCall4168);
            	                    	    lv_memberCallArguments_20_0=ruleXExpression();

            	                    	    state._fsp--;
            	                    	    if (state.failed) return current;
            	                    	    if ( state.backtracking==0 ) {

            	                    	      	        if (current==null) {
            	                    	      	            current = createModelElementForParent(grammarAccess.getXMemberFeatureCallRule());
            	                    	      	        }
            	                    	             		add(
            	                    	             			current, 
            	                    	             			"memberCallArguments",
            	                    	              		lv_memberCallArguments_20_0, 
            	                    	              		"XExpression");
            	                    	      	        afterParserOrEnumRuleCall();
            	                    	      	    
            	                    	    }

            	                    	    }


            	                    	    }


            	                    	    }
            	                    	    break;

            	                    	default :
            	                    	    break loop25;
            	                        }
            	                    } while (true);


            	                    }


            	                    }
            	                    break;

            	            }

            	            otherlv_21=(Token)match(input,40,FOLLOW_40_in_ruleXMemberFeatureCall4185); if (state.failed) return current;
            	            if ( state.backtracking==0 ) {

            	                  	newLeafNode(otherlv_21, grammarAccess.getXMemberFeatureCallAccess().getRightParenthesisKeyword_1_1_3_2());
            	                  
            	            }

            	            }
            	            break;

            	    }

            	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1731:3: ( ( ( ruleXClosure ) )=> (lv_memberCallArguments_22_0= ruleXClosure ) )?
            	    int alt28=2;
            	    alt28 = dfa28.predict(input);
            	    switch (alt28) {
            	        case 1 :
            	            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1731:4: ( ( ruleXClosure ) )=> (lv_memberCallArguments_22_0= ruleXClosure )
            	            {
            	            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1736:1: (lv_memberCallArguments_22_0= ruleXClosure )
            	            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1737:3: lv_memberCallArguments_22_0= ruleXClosure
            	            {
            	            if ( state.backtracking==0 ) {
            	               
            	              	        newCompositeNode(grammarAccess.getXMemberFeatureCallAccess().getMemberCallArgumentsXClosureParserRuleCall_1_1_4_0()); 
            	              	    
            	            }
            	            pushFollow(FOLLOW_ruleXClosure_in_ruleXMemberFeatureCall4218);
            	            lv_memberCallArguments_22_0=ruleXClosure();

            	            state._fsp--;
            	            if (state.failed) return current;
            	            if ( state.backtracking==0 ) {

            	              	        if (current==null) {
            	              	            current = createModelElementForParent(grammarAccess.getXMemberFeatureCallRule());
            	              	        }
            	                     		add(
            	                     			current, 
            	                     			"memberCallArguments",
            	                      		lv_memberCallArguments_22_0, 
            	                      		"XClosure");
            	              	        afterParserOrEnumRuleCall();
            	              	    
            	            }

            	            }


            	            }
            	            break;

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop29;
                }
            } while (true);


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleXMemberFeatureCall"


    // $ANTLR start "entryRuleXPrimaryExpression"
    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1761:1: entryRuleXPrimaryExpression returns [EObject current=null] : iv_ruleXPrimaryExpression= ruleXPrimaryExpression EOF ;
    public final EObject entryRuleXPrimaryExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXPrimaryExpression = null;


        try {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1762:2: (iv_ruleXPrimaryExpression= ruleXPrimaryExpression EOF )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1763:2: iv_ruleXPrimaryExpression= ruleXPrimaryExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXPrimaryExpressionRule()); 
            }
            pushFollow(FOLLOW_ruleXPrimaryExpression_in_entryRuleXPrimaryExpression4258);
            iv_ruleXPrimaryExpression=ruleXPrimaryExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXPrimaryExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXPrimaryExpression4268); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleXPrimaryExpression"


    // $ANTLR start "ruleXPrimaryExpression"
    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1770:1: ruleXPrimaryExpression returns [EObject current=null] : (this_XConstructorCall_0= ruleXConstructorCall | this_XBlockExpression_1= ruleXBlockExpression | this_XSwitchExpression_2= ruleXSwitchExpression | this_XFeatureCall_3= ruleXFeatureCall | this_XLiteral_4= ruleXLiteral | this_XIfExpression_5= ruleXIfExpression | this_XForLoopExpression_6= ruleXForLoopExpression | this_XWhileExpression_7= ruleXWhileExpression | this_XDoWhileExpression_8= ruleXDoWhileExpression | this_XThrowExpression_9= ruleXThrowExpression | this_XReturnExpression_10= ruleXReturnExpression | this_XTryCatchFinallyExpression_11= ruleXTryCatchFinallyExpression | this_XParenthesizedExpression_12= ruleXParenthesizedExpression ) ;
    public final EObject ruleXPrimaryExpression() throws RecognitionException {
        EObject current = null;

        EObject this_XConstructorCall_0 = null;

        EObject this_XBlockExpression_1 = null;

        EObject this_XSwitchExpression_2 = null;

        EObject this_XFeatureCall_3 = null;

        EObject this_XLiteral_4 = null;

        EObject this_XIfExpression_5 = null;

        EObject this_XForLoopExpression_6 = null;

        EObject this_XWhileExpression_7 = null;

        EObject this_XDoWhileExpression_8 = null;

        EObject this_XThrowExpression_9 = null;

        EObject this_XReturnExpression_10 = null;

        EObject this_XTryCatchFinallyExpression_11 = null;

        EObject this_XParenthesizedExpression_12 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1773:28: ( (this_XConstructorCall_0= ruleXConstructorCall | this_XBlockExpression_1= ruleXBlockExpression | this_XSwitchExpression_2= ruleXSwitchExpression | this_XFeatureCall_3= ruleXFeatureCall | this_XLiteral_4= ruleXLiteral | this_XIfExpression_5= ruleXIfExpression | this_XForLoopExpression_6= ruleXForLoopExpression | this_XWhileExpression_7= ruleXWhileExpression | this_XDoWhileExpression_8= ruleXDoWhileExpression | this_XThrowExpression_9= ruleXThrowExpression | this_XReturnExpression_10= ruleXReturnExpression | this_XTryCatchFinallyExpression_11= ruleXTryCatchFinallyExpression | this_XParenthesizedExpression_12= ruleXParenthesizedExpression ) )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1774:1: (this_XConstructorCall_0= ruleXConstructorCall | this_XBlockExpression_1= ruleXBlockExpression | this_XSwitchExpression_2= ruleXSwitchExpression | this_XFeatureCall_3= ruleXFeatureCall | this_XLiteral_4= ruleXLiteral | this_XIfExpression_5= ruleXIfExpression | this_XForLoopExpression_6= ruleXForLoopExpression | this_XWhileExpression_7= ruleXWhileExpression | this_XDoWhileExpression_8= ruleXDoWhileExpression | this_XThrowExpression_9= ruleXThrowExpression | this_XReturnExpression_10= ruleXReturnExpression | this_XTryCatchFinallyExpression_11= ruleXTryCatchFinallyExpression | this_XParenthesizedExpression_12= ruleXParenthesizedExpression )
            {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1774:1: (this_XConstructorCall_0= ruleXConstructorCall | this_XBlockExpression_1= ruleXBlockExpression | this_XSwitchExpression_2= ruleXSwitchExpression | this_XFeatureCall_3= ruleXFeatureCall | this_XLiteral_4= ruleXLiteral | this_XIfExpression_5= ruleXIfExpression | this_XForLoopExpression_6= ruleXForLoopExpression | this_XWhileExpression_7= ruleXWhileExpression | this_XDoWhileExpression_8= ruleXDoWhileExpression | this_XThrowExpression_9= ruleXThrowExpression | this_XReturnExpression_10= ruleXReturnExpression | this_XTryCatchFinallyExpression_11= ruleXTryCatchFinallyExpression | this_XParenthesizedExpression_12= ruleXParenthesizedExpression )
            int alt30=13;
            switch ( input.LA(1) ) {
            case 59:
                {
                alt30=1;
                }
                break;
            case 48:
                {
                alt30=2;
                }
                break;
            case 46:
                {
                alt30=3;
                }
                break;
            case RULE_ID:
            case 24:
            case 57:
                {
                alt30=4;
                }
                break;
            case RULE_INT:
            case RULE_STRING:
            case 41:
            case 60:
            case 61:
            case 62:
            case 63:
                {
                alt30=5;
                }
                break;
            case 44:
                {
                alt30=6;
                }
                break;
            case 52:
                {
                alt30=7;
                }
                break;
            case 53:
                {
                alt30=8;
                }
                break;
            case 54:
                {
                alt30=9;
                }
                break;
            case 64:
                {
                alt30=10;
                }
                break;
            case 65:
                {
                alt30=11;
                }
                break;
            case 66:
                {
                alt30=12;
                }
                break;
            case 39:
                {
                alt30=13;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 30, 0, input);

                throw nvae;
            }

            switch (alt30) {
                case 1 :
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1775:5: this_XConstructorCall_0= ruleXConstructorCall
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getXPrimaryExpressionAccess().getXConstructorCallParserRuleCall_0()); 
                          
                    }
                    pushFollow(FOLLOW_ruleXConstructorCall_in_ruleXPrimaryExpression4315);
                    this_XConstructorCall_0=ruleXConstructorCall();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_XConstructorCall_0; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1785:5: this_XBlockExpression_1= ruleXBlockExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getXPrimaryExpressionAccess().getXBlockExpressionParserRuleCall_1()); 
                          
                    }
                    pushFollow(FOLLOW_ruleXBlockExpression_in_ruleXPrimaryExpression4342);
                    this_XBlockExpression_1=ruleXBlockExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_XBlockExpression_1; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 3 :
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1795:5: this_XSwitchExpression_2= ruleXSwitchExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getXPrimaryExpressionAccess().getXSwitchExpressionParserRuleCall_2()); 
                          
                    }
                    pushFollow(FOLLOW_ruleXSwitchExpression_in_ruleXPrimaryExpression4369);
                    this_XSwitchExpression_2=ruleXSwitchExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_XSwitchExpression_2; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 4 :
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1805:5: this_XFeatureCall_3= ruleXFeatureCall
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getXPrimaryExpressionAccess().getXFeatureCallParserRuleCall_3()); 
                          
                    }
                    pushFollow(FOLLOW_ruleXFeatureCall_in_ruleXPrimaryExpression4396);
                    this_XFeatureCall_3=ruleXFeatureCall();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_XFeatureCall_3; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 5 :
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1815:5: this_XLiteral_4= ruleXLiteral
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getXPrimaryExpressionAccess().getXLiteralParserRuleCall_4()); 
                          
                    }
                    pushFollow(FOLLOW_ruleXLiteral_in_ruleXPrimaryExpression4423);
                    this_XLiteral_4=ruleXLiteral();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_XLiteral_4; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 6 :
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1825:5: this_XIfExpression_5= ruleXIfExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getXPrimaryExpressionAccess().getXIfExpressionParserRuleCall_5()); 
                          
                    }
                    pushFollow(FOLLOW_ruleXIfExpression_in_ruleXPrimaryExpression4450);
                    this_XIfExpression_5=ruleXIfExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_XIfExpression_5; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 7 :
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1835:5: this_XForLoopExpression_6= ruleXForLoopExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getXPrimaryExpressionAccess().getXForLoopExpressionParserRuleCall_6()); 
                          
                    }
                    pushFollow(FOLLOW_ruleXForLoopExpression_in_ruleXPrimaryExpression4477);
                    this_XForLoopExpression_6=ruleXForLoopExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_XForLoopExpression_6; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 8 :
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1845:5: this_XWhileExpression_7= ruleXWhileExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getXPrimaryExpressionAccess().getXWhileExpressionParserRuleCall_7()); 
                          
                    }
                    pushFollow(FOLLOW_ruleXWhileExpression_in_ruleXPrimaryExpression4504);
                    this_XWhileExpression_7=ruleXWhileExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_XWhileExpression_7; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 9 :
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1855:5: this_XDoWhileExpression_8= ruleXDoWhileExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getXPrimaryExpressionAccess().getXDoWhileExpressionParserRuleCall_8()); 
                          
                    }
                    pushFollow(FOLLOW_ruleXDoWhileExpression_in_ruleXPrimaryExpression4531);
                    this_XDoWhileExpression_8=ruleXDoWhileExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_XDoWhileExpression_8; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 10 :
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1865:5: this_XThrowExpression_9= ruleXThrowExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getXPrimaryExpressionAccess().getXThrowExpressionParserRuleCall_9()); 
                          
                    }
                    pushFollow(FOLLOW_ruleXThrowExpression_in_ruleXPrimaryExpression4558);
                    this_XThrowExpression_9=ruleXThrowExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_XThrowExpression_9; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 11 :
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1875:5: this_XReturnExpression_10= ruleXReturnExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getXPrimaryExpressionAccess().getXReturnExpressionParserRuleCall_10()); 
                          
                    }
                    pushFollow(FOLLOW_ruleXReturnExpression_in_ruleXPrimaryExpression4585);
                    this_XReturnExpression_10=ruleXReturnExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_XReturnExpression_10; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 12 :
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1885:5: this_XTryCatchFinallyExpression_11= ruleXTryCatchFinallyExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getXPrimaryExpressionAccess().getXTryCatchFinallyExpressionParserRuleCall_11()); 
                          
                    }
                    pushFollow(FOLLOW_ruleXTryCatchFinallyExpression_in_ruleXPrimaryExpression4612);
                    this_XTryCatchFinallyExpression_11=ruleXTryCatchFinallyExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_XTryCatchFinallyExpression_11; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 13 :
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1895:5: this_XParenthesizedExpression_12= ruleXParenthesizedExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getXPrimaryExpressionAccess().getXParenthesizedExpressionParserRuleCall_12()); 
                          
                    }
                    pushFollow(FOLLOW_ruleXParenthesizedExpression_in_ruleXPrimaryExpression4639);
                    this_XParenthesizedExpression_12=ruleXParenthesizedExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_XParenthesizedExpression_12; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleXPrimaryExpression"


    // $ANTLR start "entryRuleXLiteral"
    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1911:1: entryRuleXLiteral returns [EObject current=null] : iv_ruleXLiteral= ruleXLiteral EOF ;
    public final EObject entryRuleXLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXLiteral = null;


        try {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1912:2: (iv_ruleXLiteral= ruleXLiteral EOF )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1913:2: iv_ruleXLiteral= ruleXLiteral EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXLiteralRule()); 
            }
            pushFollow(FOLLOW_ruleXLiteral_in_entryRuleXLiteral4674);
            iv_ruleXLiteral=ruleXLiteral();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXLiteral; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXLiteral4684); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleXLiteral"


    // $ANTLR start "ruleXLiteral"
    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1920:1: ruleXLiteral returns [EObject current=null] : (this_XClosure_0= ruleXClosure | this_XBooleanLiteral_1= ruleXBooleanLiteral | this_XIntLiteral_2= ruleXIntLiteral | this_XNullLiteral_3= ruleXNullLiteral | this_XStringLiteral_4= ruleXStringLiteral | this_XTypeLiteral_5= ruleXTypeLiteral ) ;
    public final EObject ruleXLiteral() throws RecognitionException {
        EObject current = null;

        EObject this_XClosure_0 = null;

        EObject this_XBooleanLiteral_1 = null;

        EObject this_XIntLiteral_2 = null;

        EObject this_XNullLiteral_3 = null;

        EObject this_XStringLiteral_4 = null;

        EObject this_XTypeLiteral_5 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1923:28: ( (this_XClosure_0= ruleXClosure | this_XBooleanLiteral_1= ruleXBooleanLiteral | this_XIntLiteral_2= ruleXIntLiteral | this_XNullLiteral_3= ruleXNullLiteral | this_XStringLiteral_4= ruleXStringLiteral | this_XTypeLiteral_5= ruleXTypeLiteral ) )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1924:1: (this_XClosure_0= ruleXClosure | this_XBooleanLiteral_1= ruleXBooleanLiteral | this_XIntLiteral_2= ruleXIntLiteral | this_XNullLiteral_3= ruleXNullLiteral | this_XStringLiteral_4= ruleXStringLiteral | this_XTypeLiteral_5= ruleXTypeLiteral )
            {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1924:1: (this_XClosure_0= ruleXClosure | this_XBooleanLiteral_1= ruleXBooleanLiteral | this_XIntLiteral_2= ruleXIntLiteral | this_XNullLiteral_3= ruleXNullLiteral | this_XStringLiteral_4= ruleXStringLiteral | this_XTypeLiteral_5= ruleXTypeLiteral )
            int alt31=6;
            switch ( input.LA(1) ) {
            case 41:
                {
                alt31=1;
                }
                break;
            case 60:
            case 61:
                {
                alt31=2;
                }
                break;
            case RULE_INT:
                {
                alt31=3;
                }
                break;
            case 62:
                {
                alt31=4;
                }
                break;
            case RULE_STRING:
                {
                alt31=5;
                }
                break;
            case 63:
                {
                alt31=6;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 31, 0, input);

                throw nvae;
            }

            switch (alt31) {
                case 1 :
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1925:5: this_XClosure_0= ruleXClosure
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getXLiteralAccess().getXClosureParserRuleCall_0()); 
                          
                    }
                    pushFollow(FOLLOW_ruleXClosure_in_ruleXLiteral4731);
                    this_XClosure_0=ruleXClosure();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_XClosure_0; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1935:5: this_XBooleanLiteral_1= ruleXBooleanLiteral
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getXLiteralAccess().getXBooleanLiteralParserRuleCall_1()); 
                          
                    }
                    pushFollow(FOLLOW_ruleXBooleanLiteral_in_ruleXLiteral4758);
                    this_XBooleanLiteral_1=ruleXBooleanLiteral();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_XBooleanLiteral_1; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 3 :
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1945:5: this_XIntLiteral_2= ruleXIntLiteral
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getXLiteralAccess().getXIntLiteralParserRuleCall_2()); 
                          
                    }
                    pushFollow(FOLLOW_ruleXIntLiteral_in_ruleXLiteral4785);
                    this_XIntLiteral_2=ruleXIntLiteral();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_XIntLiteral_2; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 4 :
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1955:5: this_XNullLiteral_3= ruleXNullLiteral
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getXLiteralAccess().getXNullLiteralParserRuleCall_3()); 
                          
                    }
                    pushFollow(FOLLOW_ruleXNullLiteral_in_ruleXLiteral4812);
                    this_XNullLiteral_3=ruleXNullLiteral();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_XNullLiteral_3; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 5 :
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1965:5: this_XStringLiteral_4= ruleXStringLiteral
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getXLiteralAccess().getXStringLiteralParserRuleCall_4()); 
                          
                    }
                    pushFollow(FOLLOW_ruleXStringLiteral_in_ruleXLiteral4839);
                    this_XStringLiteral_4=ruleXStringLiteral();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_XStringLiteral_4; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 6 :
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1975:5: this_XTypeLiteral_5= ruleXTypeLiteral
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getXLiteralAccess().getXTypeLiteralParserRuleCall_5()); 
                          
                    }
                    pushFollow(FOLLOW_ruleXTypeLiteral_in_ruleXLiteral4866);
                    this_XTypeLiteral_5=ruleXTypeLiteral();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_XTypeLiteral_5; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleXLiteral"


    // $ANTLR start "entryRuleXClosure"
    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1991:1: entryRuleXClosure returns [EObject current=null] : iv_ruleXClosure= ruleXClosure EOF ;
    public final EObject entryRuleXClosure() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXClosure = null;


        try {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1992:2: (iv_ruleXClosure= ruleXClosure EOF )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1993:2: iv_ruleXClosure= ruleXClosure EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXClosureRule()); 
            }
            pushFollow(FOLLOW_ruleXClosure_in_entryRuleXClosure4901);
            iv_ruleXClosure=ruleXClosure();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXClosure; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXClosure4911); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleXClosure"


    // $ANTLR start "ruleXClosure"
    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2000:1: ruleXClosure returns [EObject current=null] : ( () otherlv_1= '[' ( ( ( ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> ( ( ( (lv_declaredFormalParameters_2_0= ruleJvmFormalParameter ) ) (otherlv_3= ',' ( (lv_declaredFormalParameters_4_0= ruleJvmFormalParameter ) ) )* )? ( (lv_explicitSyntax_5_0= '|' ) ) ) )? ( (lv_expression_6_0= ruleXExpressionInClosure ) ) otherlv_7= ']' ) ;
    public final EObject ruleXClosure() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        Token lv_explicitSyntax_5_0=null;
        Token otherlv_7=null;
        EObject lv_declaredFormalParameters_2_0 = null;

        EObject lv_declaredFormalParameters_4_0 = null;

        EObject lv_expression_6_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2003:28: ( ( () otherlv_1= '[' ( ( ( ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> ( ( ( (lv_declaredFormalParameters_2_0= ruleJvmFormalParameter ) ) (otherlv_3= ',' ( (lv_declaredFormalParameters_4_0= ruleJvmFormalParameter ) ) )* )? ( (lv_explicitSyntax_5_0= '|' ) ) ) )? ( (lv_expression_6_0= ruleXExpressionInClosure ) ) otherlv_7= ']' ) )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2004:1: ( () otherlv_1= '[' ( ( ( ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> ( ( ( (lv_declaredFormalParameters_2_0= ruleJvmFormalParameter ) ) (otherlv_3= ',' ( (lv_declaredFormalParameters_4_0= ruleJvmFormalParameter ) ) )* )? ( (lv_explicitSyntax_5_0= '|' ) ) ) )? ( (lv_expression_6_0= ruleXExpressionInClosure ) ) otherlv_7= ']' )
            {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2004:1: ( () otherlv_1= '[' ( ( ( ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> ( ( ( (lv_declaredFormalParameters_2_0= ruleJvmFormalParameter ) ) (otherlv_3= ',' ( (lv_declaredFormalParameters_4_0= ruleJvmFormalParameter ) ) )* )? ( (lv_explicitSyntax_5_0= '|' ) ) ) )? ( (lv_expression_6_0= ruleXExpressionInClosure ) ) otherlv_7= ']' )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2004:2: () otherlv_1= '[' ( ( ( ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> ( ( ( (lv_declaredFormalParameters_2_0= ruleJvmFormalParameter ) ) (otherlv_3= ',' ( (lv_declaredFormalParameters_4_0= ruleJvmFormalParameter ) ) )* )? ( (lv_explicitSyntax_5_0= '|' ) ) ) )? ( (lv_expression_6_0= ruleXExpressionInClosure ) ) otherlv_7= ']'
            {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2004:2: ()
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2005:5: 
            {
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getXClosureAccess().getXClosureAction_0(),
                          current);
                  
            }

            }

            otherlv_1=(Token)match(input,41,FOLLOW_41_in_ruleXClosure4957); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getXClosureAccess().getLeftSquareBracketKeyword_1());
                  
            }
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2014:1: ( ( ( ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> ( ( ( (lv_declaredFormalParameters_2_0= ruleJvmFormalParameter ) ) (otherlv_3= ',' ( (lv_declaredFormalParameters_4_0= ruleJvmFormalParameter ) ) )* )? ( (lv_explicitSyntax_5_0= '|' ) ) ) )?
            int alt34=2;
            alt34 = dfa34.predict(input);
            switch (alt34) {
                case 1 :
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2014:2: ( ( ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> ( ( ( (lv_declaredFormalParameters_2_0= ruleJvmFormalParameter ) ) (otherlv_3= ',' ( (lv_declaredFormalParameters_4_0= ruleJvmFormalParameter ) ) )* )? ( (lv_explicitSyntax_5_0= '|' ) ) )
                    {
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2029:6: ( ( ( (lv_declaredFormalParameters_2_0= ruleJvmFormalParameter ) ) (otherlv_3= ',' ( (lv_declaredFormalParameters_4_0= ruleJvmFormalParameter ) ) )* )? ( (lv_explicitSyntax_5_0= '|' ) ) )
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2029:7: ( ( (lv_declaredFormalParameters_2_0= ruleJvmFormalParameter ) ) (otherlv_3= ',' ( (lv_declaredFormalParameters_4_0= ruleJvmFormalParameter ) ) )* )? ( (lv_explicitSyntax_5_0= '|' ) )
                    {
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2029:7: ( ( (lv_declaredFormalParameters_2_0= ruleJvmFormalParameter ) ) (otherlv_3= ',' ( (lv_declaredFormalParameters_4_0= ruleJvmFormalParameter ) ) )* )?
                    int alt33=2;
                    int LA33_0 = input.LA(1);

                    if ( (LA33_0==RULE_ID||LA33_0==39||LA33_0==69) ) {
                        alt33=1;
                    }
                    switch (alt33) {
                        case 1 :
                            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2029:8: ( (lv_declaredFormalParameters_2_0= ruleJvmFormalParameter ) ) (otherlv_3= ',' ( (lv_declaredFormalParameters_4_0= ruleJvmFormalParameter ) ) )*
                            {
                            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2029:8: ( (lv_declaredFormalParameters_2_0= ruleJvmFormalParameter ) )
                            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2030:1: (lv_declaredFormalParameters_2_0= ruleJvmFormalParameter )
                            {
                            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2030:1: (lv_declaredFormalParameters_2_0= ruleJvmFormalParameter )
                            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2031:3: lv_declaredFormalParameters_2_0= ruleJvmFormalParameter
                            {
                            if ( state.backtracking==0 ) {
                               
                              	        newCompositeNode(grammarAccess.getXClosureAccess().getDeclaredFormalParametersJvmFormalParameterParserRuleCall_2_0_0_0_0()); 
                              	    
                            }
                            pushFollow(FOLLOW_ruleJvmFormalParameter_in_ruleXClosure5028);
                            lv_declaredFormalParameters_2_0=ruleJvmFormalParameter();

                            state._fsp--;
                            if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              	        if (current==null) {
                              	            current = createModelElementForParent(grammarAccess.getXClosureRule());
                              	        }
                                     		add(
                                     			current, 
                                     			"declaredFormalParameters",
                                      		lv_declaredFormalParameters_2_0, 
                                      		"JvmFormalParameter");
                              	        afterParserOrEnumRuleCall();
                              	    
                            }

                            }


                            }

                            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2047:2: (otherlv_3= ',' ( (lv_declaredFormalParameters_4_0= ruleJvmFormalParameter ) ) )*
                            loop32:
                            do {
                                int alt32=2;
                                int LA32_0 = input.LA(1);

                                if ( (LA32_0==38) ) {
                                    alt32=1;
                                }


                                switch (alt32) {
                            	case 1 :
                            	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2047:4: otherlv_3= ',' ( (lv_declaredFormalParameters_4_0= ruleJvmFormalParameter ) )
                            	    {
                            	    otherlv_3=(Token)match(input,38,FOLLOW_38_in_ruleXClosure5041); if (state.failed) return current;
                            	    if ( state.backtracking==0 ) {

                            	          	newLeafNode(otherlv_3, grammarAccess.getXClosureAccess().getCommaKeyword_2_0_0_1_0());
                            	          
                            	    }
                            	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2051:1: ( (lv_declaredFormalParameters_4_0= ruleJvmFormalParameter ) )
                            	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2052:1: (lv_declaredFormalParameters_4_0= ruleJvmFormalParameter )
                            	    {
                            	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2052:1: (lv_declaredFormalParameters_4_0= ruleJvmFormalParameter )
                            	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2053:3: lv_declaredFormalParameters_4_0= ruleJvmFormalParameter
                            	    {
                            	    if ( state.backtracking==0 ) {
                            	       
                            	      	        newCompositeNode(grammarAccess.getXClosureAccess().getDeclaredFormalParametersJvmFormalParameterParserRuleCall_2_0_0_1_1_0()); 
                            	      	    
                            	    }
                            	    pushFollow(FOLLOW_ruleJvmFormalParameter_in_ruleXClosure5062);
                            	    lv_declaredFormalParameters_4_0=ruleJvmFormalParameter();

                            	    state._fsp--;
                            	    if (state.failed) return current;
                            	    if ( state.backtracking==0 ) {

                            	      	        if (current==null) {
                            	      	            current = createModelElementForParent(grammarAccess.getXClosureRule());
                            	      	        }
                            	             		add(
                            	             			current, 
                            	             			"declaredFormalParameters",
                            	              		lv_declaredFormalParameters_4_0, 
                            	              		"JvmFormalParameter");
                            	      	        afterParserOrEnumRuleCall();
                            	      	    
                            	    }

                            	    }


                            	    }


                            	    }
                            	    break;

                            	default :
                            	    break loop32;
                                }
                            } while (true);


                            }
                            break;

                    }

                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2069:6: ( (lv_explicitSyntax_5_0= '|' ) )
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2070:1: (lv_explicitSyntax_5_0= '|' )
                    {
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2070:1: (lv_explicitSyntax_5_0= '|' )
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2071:3: lv_explicitSyntax_5_0= '|'
                    {
                    lv_explicitSyntax_5_0=(Token)match(input,42,FOLLOW_42_in_ruleXClosure5084); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              newLeafNode(lv_explicitSyntax_5_0, grammarAccess.getXClosureAccess().getExplicitSyntaxVerticalLineKeyword_2_0_1_0());
                          
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getXClosureRule());
                      	        }
                             		setWithLastConsumed(current, "explicitSyntax", true, "|");
                      	    
                    }

                    }


                    }


                    }


                    }
                    break;

            }

            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2084:5: ( (lv_expression_6_0= ruleXExpressionInClosure ) )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2085:1: (lv_expression_6_0= ruleXExpressionInClosure )
            {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2085:1: (lv_expression_6_0= ruleXExpressionInClosure )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2086:3: lv_expression_6_0= ruleXExpressionInClosure
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getXClosureAccess().getExpressionXExpressionInClosureParserRuleCall_3_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleXExpressionInClosure_in_ruleXClosure5121);
            lv_expression_6_0=ruleXExpressionInClosure();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getXClosureRule());
              	        }
                     		set(
                     			current, 
                     			"expression",
                      		lv_expression_6_0, 
                      		"XExpressionInClosure");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            otherlv_7=(Token)match(input,43,FOLLOW_43_in_ruleXClosure5133); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_7, grammarAccess.getXClosureAccess().getRightSquareBracketKeyword_4());
                  
            }

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleXClosure"


    // $ANTLR start "entryRuleXExpressionInClosure"
    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2114:1: entryRuleXExpressionInClosure returns [EObject current=null] : iv_ruleXExpressionInClosure= ruleXExpressionInClosure EOF ;
    public final EObject entryRuleXExpressionInClosure() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXExpressionInClosure = null;


        try {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2115:2: (iv_ruleXExpressionInClosure= ruleXExpressionInClosure EOF )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2116:2: iv_ruleXExpressionInClosure= ruleXExpressionInClosure EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXExpressionInClosureRule()); 
            }
            pushFollow(FOLLOW_ruleXExpressionInClosure_in_entryRuleXExpressionInClosure5169);
            iv_ruleXExpressionInClosure=ruleXExpressionInClosure();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXExpressionInClosure; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXExpressionInClosure5179); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleXExpressionInClosure"


    // $ANTLR start "ruleXExpressionInClosure"
    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2123:1: ruleXExpressionInClosure returns [EObject current=null] : ( () ( ( (lv_expressions_1_0= ruleXExpressionInsideBlock ) ) (otherlv_2= ';' )? )* ) ;
    public final EObject ruleXExpressionInClosure() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        EObject lv_expressions_1_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2126:28: ( ( () ( ( (lv_expressions_1_0= ruleXExpressionInsideBlock ) ) (otherlv_2= ';' )? )* ) )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2127:1: ( () ( ( (lv_expressions_1_0= ruleXExpressionInsideBlock ) ) (otherlv_2= ';' )? )* )
            {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2127:1: ( () ( ( (lv_expressions_1_0= ruleXExpressionInsideBlock ) ) (otherlv_2= ';' )? )* )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2127:2: () ( ( (lv_expressions_1_0= ruleXExpressionInsideBlock ) ) (otherlv_2= ';' )? )*
            {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2127:2: ()
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2128:5: 
            {
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getXExpressionInClosureAccess().getXBlockExpressionAction_0(),
                          current);
                  
            }

            }

            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2133:2: ( ( (lv_expressions_1_0= ruleXExpressionInsideBlock ) ) (otherlv_2= ';' )? )*
            loop36:
            do {
                int alt36=2;
                int LA36_0 = input.LA(1);

                if ( ((LA36_0>=RULE_INT && LA36_0<=RULE_ID)||LA36_0==24||(LA36_0>=27 && LA36_0<=28)||LA36_0==33||LA36_0==39||LA36_0==41||LA36_0==44||LA36_0==46||LA36_0==48||(LA36_0>=52 && LA36_0<=57)||(LA36_0>=59 && LA36_0<=66)) ) {
                    alt36=1;
                }


                switch (alt36) {
            	case 1 :
            	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2133:3: ( (lv_expressions_1_0= ruleXExpressionInsideBlock ) ) (otherlv_2= ';' )?
            	    {
            	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2133:3: ( (lv_expressions_1_0= ruleXExpressionInsideBlock ) )
            	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2134:1: (lv_expressions_1_0= ruleXExpressionInsideBlock )
            	    {
            	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2134:1: (lv_expressions_1_0= ruleXExpressionInsideBlock )
            	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2135:3: lv_expressions_1_0= ruleXExpressionInsideBlock
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getXExpressionInClosureAccess().getExpressionsXExpressionInsideBlockParserRuleCall_1_0_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleXExpressionInsideBlock_in_ruleXExpressionInClosure5235);
            	    lv_expressions_1_0=ruleXExpressionInsideBlock();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getXExpressionInClosureRule());
            	      	        }
            	             		add(
            	             			current, 
            	             			"expressions",
            	              		lv_expressions_1_0, 
            	              		"XExpressionInsideBlock");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }

            	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2151:2: (otherlv_2= ';' )?
            	    int alt35=2;
            	    int LA35_0 = input.LA(1);

            	    if ( (LA35_0==11) ) {
            	        alt35=1;
            	    }
            	    switch (alt35) {
            	        case 1 :
            	            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2151:4: otherlv_2= ';'
            	            {
            	            otherlv_2=(Token)match(input,11,FOLLOW_11_in_ruleXExpressionInClosure5248); if (state.failed) return current;
            	            if ( state.backtracking==0 ) {

            	                  	newLeafNode(otherlv_2, grammarAccess.getXExpressionInClosureAccess().getSemicolonKeyword_1_1());
            	                  
            	            }

            	            }
            	            break;

            	    }


            	    }
            	    break;

            	default :
            	    break loop36;
                }
            } while (true);


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleXExpressionInClosure"


    // $ANTLR start "entryRuleXShortClosure"
    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2163:1: entryRuleXShortClosure returns [EObject current=null] : iv_ruleXShortClosure= ruleXShortClosure EOF ;
    public final EObject entryRuleXShortClosure() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXShortClosure = null;


        try {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2164:2: (iv_ruleXShortClosure= ruleXShortClosure EOF )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2165:2: iv_ruleXShortClosure= ruleXShortClosure EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXShortClosureRule()); 
            }
            pushFollow(FOLLOW_ruleXShortClosure_in_entryRuleXShortClosure5288);
            iv_ruleXShortClosure=ruleXShortClosure();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXShortClosure; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXShortClosure5298); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleXShortClosure"


    // $ANTLR start "ruleXShortClosure"
    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2172:1: ruleXShortClosure returns [EObject current=null] : ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> ( () ( ( (lv_declaredFormalParameters_1_0= ruleJvmFormalParameter ) ) (otherlv_2= ',' ( (lv_declaredFormalParameters_3_0= ruleJvmFormalParameter ) ) )* )? ( (lv_explicitSyntax_4_0= '|' ) ) ) ) ( (lv_expression_5_0= ruleXExpression ) ) ) ;
    public final EObject ruleXShortClosure() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        Token lv_explicitSyntax_4_0=null;
        EObject lv_declaredFormalParameters_1_0 = null;

        EObject lv_declaredFormalParameters_3_0 = null;

        EObject lv_expression_5_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2175:28: ( ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> ( () ( ( (lv_declaredFormalParameters_1_0= ruleJvmFormalParameter ) ) (otherlv_2= ',' ( (lv_declaredFormalParameters_3_0= ruleJvmFormalParameter ) ) )* )? ( (lv_explicitSyntax_4_0= '|' ) ) ) ) ( (lv_expression_5_0= ruleXExpression ) ) ) )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2176:1: ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> ( () ( ( (lv_declaredFormalParameters_1_0= ruleJvmFormalParameter ) ) (otherlv_2= ',' ( (lv_declaredFormalParameters_3_0= ruleJvmFormalParameter ) ) )* )? ( (lv_explicitSyntax_4_0= '|' ) ) ) ) ( (lv_expression_5_0= ruleXExpression ) ) )
            {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2176:1: ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> ( () ( ( (lv_declaredFormalParameters_1_0= ruleJvmFormalParameter ) ) (otherlv_2= ',' ( (lv_declaredFormalParameters_3_0= ruleJvmFormalParameter ) ) )* )? ( (lv_explicitSyntax_4_0= '|' ) ) ) ) ( (lv_expression_5_0= ruleXExpression ) ) )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2176:2: ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> ( () ( ( (lv_declaredFormalParameters_1_0= ruleJvmFormalParameter ) ) (otherlv_2= ',' ( (lv_declaredFormalParameters_3_0= ruleJvmFormalParameter ) ) )* )? ( (lv_explicitSyntax_4_0= '|' ) ) ) ) ( (lv_expression_5_0= ruleXExpression ) )
            {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2176:2: ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> ( () ( ( (lv_declaredFormalParameters_1_0= ruleJvmFormalParameter ) ) (otherlv_2= ',' ( (lv_declaredFormalParameters_3_0= ruleJvmFormalParameter ) ) )* )? ( (lv_explicitSyntax_4_0= '|' ) ) ) )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2176:3: ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> ( () ( ( (lv_declaredFormalParameters_1_0= ruleJvmFormalParameter ) ) (otherlv_2= ',' ( (lv_declaredFormalParameters_3_0= ruleJvmFormalParameter ) ) )* )? ( (lv_explicitSyntax_4_0= '|' ) ) )
            {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2192:6: ( () ( ( (lv_declaredFormalParameters_1_0= ruleJvmFormalParameter ) ) (otherlv_2= ',' ( (lv_declaredFormalParameters_3_0= ruleJvmFormalParameter ) ) )* )? ( (lv_explicitSyntax_4_0= '|' ) ) )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2192:7: () ( ( (lv_declaredFormalParameters_1_0= ruleJvmFormalParameter ) ) (otherlv_2= ',' ( (lv_declaredFormalParameters_3_0= ruleJvmFormalParameter ) ) )* )? ( (lv_explicitSyntax_4_0= '|' ) )
            {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2192:7: ()
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2193:5: 
            {
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getXShortClosureAccess().getXClosureAction_0_0_0(),
                          current);
                  
            }

            }

            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2198:2: ( ( (lv_declaredFormalParameters_1_0= ruleJvmFormalParameter ) ) (otherlv_2= ',' ( (lv_declaredFormalParameters_3_0= ruleJvmFormalParameter ) ) )* )?
            int alt38=2;
            int LA38_0 = input.LA(1);

            if ( (LA38_0==RULE_ID||LA38_0==39||LA38_0==69) ) {
                alt38=1;
            }
            switch (alt38) {
                case 1 :
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2198:3: ( (lv_declaredFormalParameters_1_0= ruleJvmFormalParameter ) ) (otherlv_2= ',' ( (lv_declaredFormalParameters_3_0= ruleJvmFormalParameter ) ) )*
                    {
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2198:3: ( (lv_declaredFormalParameters_1_0= ruleJvmFormalParameter ) )
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2199:1: (lv_declaredFormalParameters_1_0= ruleJvmFormalParameter )
                    {
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2199:1: (lv_declaredFormalParameters_1_0= ruleJvmFormalParameter )
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2200:3: lv_declaredFormalParameters_1_0= ruleJvmFormalParameter
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getXShortClosureAccess().getDeclaredFormalParametersJvmFormalParameterParserRuleCall_0_0_1_0_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleJvmFormalParameter_in_ruleXShortClosure5406);
                    lv_declaredFormalParameters_1_0=ruleJvmFormalParameter();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getXShortClosureRule());
                      	        }
                             		add(
                             			current, 
                             			"declaredFormalParameters",
                              		lv_declaredFormalParameters_1_0, 
                              		"JvmFormalParameter");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }

                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2216:2: (otherlv_2= ',' ( (lv_declaredFormalParameters_3_0= ruleJvmFormalParameter ) ) )*
                    loop37:
                    do {
                        int alt37=2;
                        int LA37_0 = input.LA(1);

                        if ( (LA37_0==38) ) {
                            alt37=1;
                        }


                        switch (alt37) {
                    	case 1 :
                    	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2216:4: otherlv_2= ',' ( (lv_declaredFormalParameters_3_0= ruleJvmFormalParameter ) )
                    	    {
                    	    otherlv_2=(Token)match(input,38,FOLLOW_38_in_ruleXShortClosure5419); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	          	newLeafNode(otherlv_2, grammarAccess.getXShortClosureAccess().getCommaKeyword_0_0_1_1_0());
                    	          
                    	    }
                    	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2220:1: ( (lv_declaredFormalParameters_3_0= ruleJvmFormalParameter ) )
                    	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2221:1: (lv_declaredFormalParameters_3_0= ruleJvmFormalParameter )
                    	    {
                    	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2221:1: (lv_declaredFormalParameters_3_0= ruleJvmFormalParameter )
                    	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2222:3: lv_declaredFormalParameters_3_0= ruleJvmFormalParameter
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getXShortClosureAccess().getDeclaredFormalParametersJvmFormalParameterParserRuleCall_0_0_1_1_1_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FOLLOW_ruleJvmFormalParameter_in_ruleXShortClosure5440);
                    	    lv_declaredFormalParameters_3_0=ruleJvmFormalParameter();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      	        if (current==null) {
                    	      	            current = createModelElementForParent(grammarAccess.getXShortClosureRule());
                    	      	        }
                    	             		add(
                    	             			current, 
                    	             			"declaredFormalParameters",
                    	              		lv_declaredFormalParameters_3_0, 
                    	              		"JvmFormalParameter");
                    	      	        afterParserOrEnumRuleCall();
                    	      	    
                    	    }

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop37;
                        }
                    } while (true);


                    }
                    break;

            }

            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2238:6: ( (lv_explicitSyntax_4_0= '|' ) )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2239:1: (lv_explicitSyntax_4_0= '|' )
            {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2239:1: (lv_explicitSyntax_4_0= '|' )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2240:3: lv_explicitSyntax_4_0= '|'
            {
            lv_explicitSyntax_4_0=(Token)match(input,42,FOLLOW_42_in_ruleXShortClosure5462); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                      newLeafNode(lv_explicitSyntax_4_0, grammarAccess.getXShortClosureAccess().getExplicitSyntaxVerticalLineKeyword_0_0_2_0());
                  
            }
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElement(grammarAccess.getXShortClosureRule());
              	        }
                     		setWithLastConsumed(current, "explicitSyntax", true, "|");
              	    
            }

            }


            }


            }


            }

            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2253:4: ( (lv_expression_5_0= ruleXExpression ) )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2254:1: (lv_expression_5_0= ruleXExpression )
            {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2254:1: (lv_expression_5_0= ruleXExpression )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2255:3: lv_expression_5_0= ruleXExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getXShortClosureAccess().getExpressionXExpressionParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleXExpression_in_ruleXShortClosure5498);
            lv_expression_5_0=ruleXExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getXShortClosureRule());
              	        }
                     		set(
                     			current, 
                     			"expression",
                      		lv_expression_5_0, 
                      		"XExpression");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleXShortClosure"


    // $ANTLR start "entryRuleXParenthesizedExpression"
    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2279:1: entryRuleXParenthesizedExpression returns [EObject current=null] : iv_ruleXParenthesizedExpression= ruleXParenthesizedExpression EOF ;
    public final EObject entryRuleXParenthesizedExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXParenthesizedExpression = null;


        try {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2280:2: (iv_ruleXParenthesizedExpression= ruleXParenthesizedExpression EOF )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2281:2: iv_ruleXParenthesizedExpression= ruleXParenthesizedExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXParenthesizedExpressionRule()); 
            }
            pushFollow(FOLLOW_ruleXParenthesizedExpression_in_entryRuleXParenthesizedExpression5534);
            iv_ruleXParenthesizedExpression=ruleXParenthesizedExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXParenthesizedExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXParenthesizedExpression5544); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleXParenthesizedExpression"


    // $ANTLR start "ruleXParenthesizedExpression"
    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2288:1: ruleXParenthesizedExpression returns [EObject current=null] : (otherlv_0= '(' this_XExpression_1= ruleXExpression otherlv_2= ')' ) ;
    public final EObject ruleXParenthesizedExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        EObject this_XExpression_1 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2291:28: ( (otherlv_0= '(' this_XExpression_1= ruleXExpression otherlv_2= ')' ) )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2292:1: (otherlv_0= '(' this_XExpression_1= ruleXExpression otherlv_2= ')' )
            {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2292:1: (otherlv_0= '(' this_XExpression_1= ruleXExpression otherlv_2= ')' )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2292:3: otherlv_0= '(' this_XExpression_1= ruleXExpression otherlv_2= ')'
            {
            otherlv_0=(Token)match(input,39,FOLLOW_39_in_ruleXParenthesizedExpression5581); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getXParenthesizedExpressionAccess().getLeftParenthesisKeyword_0());
                  
            }
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getXParenthesizedExpressionAccess().getXExpressionParserRuleCall_1()); 
                  
            }
            pushFollow(FOLLOW_ruleXExpression_in_ruleXParenthesizedExpression5603);
            this_XExpression_1=ruleXExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                      current = this_XExpression_1; 
                      afterParserOrEnumRuleCall();
                  
            }
            otherlv_2=(Token)match(input,40,FOLLOW_40_in_ruleXParenthesizedExpression5614); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_2, grammarAccess.getXParenthesizedExpressionAccess().getRightParenthesisKeyword_2());
                  
            }

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleXParenthesizedExpression"


    // $ANTLR start "entryRuleXIfExpression"
    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2317:1: entryRuleXIfExpression returns [EObject current=null] : iv_ruleXIfExpression= ruleXIfExpression EOF ;
    public final EObject entryRuleXIfExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXIfExpression = null;


        try {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2318:2: (iv_ruleXIfExpression= ruleXIfExpression EOF )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2319:2: iv_ruleXIfExpression= ruleXIfExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXIfExpressionRule()); 
            }
            pushFollow(FOLLOW_ruleXIfExpression_in_entryRuleXIfExpression5650);
            iv_ruleXIfExpression=ruleXIfExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXIfExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXIfExpression5660); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleXIfExpression"


    // $ANTLR start "ruleXIfExpression"
    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2326:1: ruleXIfExpression returns [EObject current=null] : ( () otherlv_1= 'if' otherlv_2= '(' ( (lv_if_3_0= ruleXExpression ) ) otherlv_4= ')' ( (lv_then_5_0= ruleXExpression ) ) ( ( ( 'else' )=>otherlv_6= 'else' ) ( (lv_else_7_0= ruleXExpression ) ) )? ) ;
    public final EObject ruleXIfExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        EObject lv_if_3_0 = null;

        EObject lv_then_5_0 = null;

        EObject lv_else_7_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2329:28: ( ( () otherlv_1= 'if' otherlv_2= '(' ( (lv_if_3_0= ruleXExpression ) ) otherlv_4= ')' ( (lv_then_5_0= ruleXExpression ) ) ( ( ( 'else' )=>otherlv_6= 'else' ) ( (lv_else_7_0= ruleXExpression ) ) )? ) )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2330:1: ( () otherlv_1= 'if' otherlv_2= '(' ( (lv_if_3_0= ruleXExpression ) ) otherlv_4= ')' ( (lv_then_5_0= ruleXExpression ) ) ( ( ( 'else' )=>otherlv_6= 'else' ) ( (lv_else_7_0= ruleXExpression ) ) )? )
            {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2330:1: ( () otherlv_1= 'if' otherlv_2= '(' ( (lv_if_3_0= ruleXExpression ) ) otherlv_4= ')' ( (lv_then_5_0= ruleXExpression ) ) ( ( ( 'else' )=>otherlv_6= 'else' ) ( (lv_else_7_0= ruleXExpression ) ) )? )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2330:2: () otherlv_1= 'if' otherlv_2= '(' ( (lv_if_3_0= ruleXExpression ) ) otherlv_4= ')' ( (lv_then_5_0= ruleXExpression ) ) ( ( ( 'else' )=>otherlv_6= 'else' ) ( (lv_else_7_0= ruleXExpression ) ) )?
            {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2330:2: ()
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2331:5: 
            {
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getXIfExpressionAccess().getXIfExpressionAction_0(),
                          current);
                  
            }

            }

            otherlv_1=(Token)match(input,44,FOLLOW_44_in_ruleXIfExpression5706); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getXIfExpressionAccess().getIfKeyword_1());
                  
            }
            otherlv_2=(Token)match(input,39,FOLLOW_39_in_ruleXIfExpression5718); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_2, grammarAccess.getXIfExpressionAccess().getLeftParenthesisKeyword_2());
                  
            }
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2344:1: ( (lv_if_3_0= ruleXExpression ) )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2345:1: (lv_if_3_0= ruleXExpression )
            {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2345:1: (lv_if_3_0= ruleXExpression )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2346:3: lv_if_3_0= ruleXExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getXIfExpressionAccess().getIfXExpressionParserRuleCall_3_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleXExpression_in_ruleXIfExpression5739);
            lv_if_3_0=ruleXExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getXIfExpressionRule());
              	        }
                     		set(
                     			current, 
                     			"if",
                      		lv_if_3_0, 
                      		"XExpression");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            otherlv_4=(Token)match(input,40,FOLLOW_40_in_ruleXIfExpression5751); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_4, grammarAccess.getXIfExpressionAccess().getRightParenthesisKeyword_4());
                  
            }
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2366:1: ( (lv_then_5_0= ruleXExpression ) )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2367:1: (lv_then_5_0= ruleXExpression )
            {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2367:1: (lv_then_5_0= ruleXExpression )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2368:3: lv_then_5_0= ruleXExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getXIfExpressionAccess().getThenXExpressionParserRuleCall_5_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleXExpression_in_ruleXIfExpression5772);
            lv_then_5_0=ruleXExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getXIfExpressionRule());
              	        }
                     		set(
                     			current, 
                     			"then",
                      		lv_then_5_0, 
                      		"XExpression");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2384:2: ( ( ( 'else' )=>otherlv_6= 'else' ) ( (lv_else_7_0= ruleXExpression ) ) )?
            int alt39=2;
            int LA39_0 = input.LA(1);

            if ( (LA39_0==45) ) {
                int LA39_1 = input.LA(2);

                if ( (synpred18_InternalPureXbase()) ) {
                    alt39=1;
                }
            }
            switch (alt39) {
                case 1 :
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2384:3: ( ( 'else' )=>otherlv_6= 'else' ) ( (lv_else_7_0= ruleXExpression ) )
                    {
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2384:3: ( ( 'else' )=>otherlv_6= 'else' )
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2384:4: ( 'else' )=>otherlv_6= 'else'
                    {
                    otherlv_6=(Token)match(input,45,FOLLOW_45_in_ruleXIfExpression5793); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_6, grammarAccess.getXIfExpressionAccess().getElseKeyword_6_0());
                          
                    }

                    }

                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2389:2: ( (lv_else_7_0= ruleXExpression ) )
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2390:1: (lv_else_7_0= ruleXExpression )
                    {
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2390:1: (lv_else_7_0= ruleXExpression )
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2391:3: lv_else_7_0= ruleXExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getXIfExpressionAccess().getElseXExpressionParserRuleCall_6_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleXExpression_in_ruleXIfExpression5815);
                    lv_else_7_0=ruleXExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getXIfExpressionRule());
                      	        }
                             		set(
                             			current, 
                             			"else",
                              		lv_else_7_0, 
                              		"XExpression");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }
                    break;

            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleXIfExpression"


    // $ANTLR start "entryRuleXSwitchExpression"
    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2415:1: entryRuleXSwitchExpression returns [EObject current=null] : iv_ruleXSwitchExpression= ruleXSwitchExpression EOF ;
    public final EObject entryRuleXSwitchExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXSwitchExpression = null;


        try {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2416:2: (iv_ruleXSwitchExpression= ruleXSwitchExpression EOF )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2417:2: iv_ruleXSwitchExpression= ruleXSwitchExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXSwitchExpressionRule()); 
            }
            pushFollow(FOLLOW_ruleXSwitchExpression_in_entryRuleXSwitchExpression5853);
            iv_ruleXSwitchExpression=ruleXSwitchExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXSwitchExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXSwitchExpression5863); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleXSwitchExpression"


    // $ANTLR start "ruleXSwitchExpression"
    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2424:1: ruleXSwitchExpression returns [EObject current=null] : ( () otherlv_1= 'switch' ( ( ( ( ( ruleValidID ) ) ':' ) )=> ( ( (lv_localVarName_2_0= ruleValidID ) ) otherlv_3= ':' ) )? ( (lv_switch_4_0= ruleXExpression ) ) otherlv_5= '{' ( (lv_cases_6_0= ruleXCasePart ) )+ (otherlv_7= 'default' otherlv_8= ':' ( (lv_default_9_0= ruleXExpression ) ) )? otherlv_10= '}' ) ;
    public final EObject ruleXSwitchExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        Token otherlv_8=null;
        Token otherlv_10=null;
        AntlrDatatypeRuleToken lv_localVarName_2_0 = null;

        EObject lv_switch_4_0 = null;

        EObject lv_cases_6_0 = null;

        EObject lv_default_9_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2427:28: ( ( () otherlv_1= 'switch' ( ( ( ( ( ruleValidID ) ) ':' ) )=> ( ( (lv_localVarName_2_0= ruleValidID ) ) otherlv_3= ':' ) )? ( (lv_switch_4_0= ruleXExpression ) ) otherlv_5= '{' ( (lv_cases_6_0= ruleXCasePart ) )+ (otherlv_7= 'default' otherlv_8= ':' ( (lv_default_9_0= ruleXExpression ) ) )? otherlv_10= '}' ) )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2428:1: ( () otherlv_1= 'switch' ( ( ( ( ( ruleValidID ) ) ':' ) )=> ( ( (lv_localVarName_2_0= ruleValidID ) ) otherlv_3= ':' ) )? ( (lv_switch_4_0= ruleXExpression ) ) otherlv_5= '{' ( (lv_cases_6_0= ruleXCasePart ) )+ (otherlv_7= 'default' otherlv_8= ':' ( (lv_default_9_0= ruleXExpression ) ) )? otherlv_10= '}' )
            {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2428:1: ( () otherlv_1= 'switch' ( ( ( ( ( ruleValidID ) ) ':' ) )=> ( ( (lv_localVarName_2_0= ruleValidID ) ) otherlv_3= ':' ) )? ( (lv_switch_4_0= ruleXExpression ) ) otherlv_5= '{' ( (lv_cases_6_0= ruleXCasePart ) )+ (otherlv_7= 'default' otherlv_8= ':' ( (lv_default_9_0= ruleXExpression ) ) )? otherlv_10= '}' )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2428:2: () otherlv_1= 'switch' ( ( ( ( ( ruleValidID ) ) ':' ) )=> ( ( (lv_localVarName_2_0= ruleValidID ) ) otherlv_3= ':' ) )? ( (lv_switch_4_0= ruleXExpression ) ) otherlv_5= '{' ( (lv_cases_6_0= ruleXCasePart ) )+ (otherlv_7= 'default' otherlv_8= ':' ( (lv_default_9_0= ruleXExpression ) ) )? otherlv_10= '}'
            {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2428:2: ()
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2429:5: 
            {
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getXSwitchExpressionAccess().getXSwitchExpressionAction_0(),
                          current);
                  
            }

            }

            otherlv_1=(Token)match(input,46,FOLLOW_46_in_ruleXSwitchExpression5909); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getXSwitchExpressionAccess().getSwitchKeyword_1());
                  
            }
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2438:1: ( ( ( ( ( ruleValidID ) ) ':' ) )=> ( ( (lv_localVarName_2_0= ruleValidID ) ) otherlv_3= ':' ) )?
            int alt40=2;
            int LA40_0 = input.LA(1);

            if ( (LA40_0==RULE_ID) ) {
                int LA40_1 = input.LA(2);

                if ( (LA40_1==47) && (synpred19_InternalPureXbase())) {
                    alt40=1;
                }
            }
            switch (alt40) {
                case 1 :
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2438:2: ( ( ( ( ruleValidID ) ) ':' ) )=> ( ( (lv_localVarName_2_0= ruleValidID ) ) otherlv_3= ':' )
                    {
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2443:5: ( ( (lv_localVarName_2_0= ruleValidID ) ) otherlv_3= ':' )
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2443:6: ( (lv_localVarName_2_0= ruleValidID ) ) otherlv_3= ':'
                    {
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2443:6: ( (lv_localVarName_2_0= ruleValidID ) )
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2444:1: (lv_localVarName_2_0= ruleValidID )
                    {
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2444:1: (lv_localVarName_2_0= ruleValidID )
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2445:3: lv_localVarName_2_0= ruleValidID
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getXSwitchExpressionAccess().getLocalVarNameValidIDParserRuleCall_2_0_0_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleValidID_in_ruleXSwitchExpression5950);
                    lv_localVarName_2_0=ruleValidID();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getXSwitchExpressionRule());
                      	        }
                             		set(
                             			current, 
                             			"localVarName",
                              		lv_localVarName_2_0, 
                              		"ValidID");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }

                    otherlv_3=(Token)match(input,47,FOLLOW_47_in_ruleXSwitchExpression5962); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_3, grammarAccess.getXSwitchExpressionAccess().getColonKeyword_2_0_1());
                          
                    }

                    }


                    }
                    break;

            }

            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2465:4: ( (lv_switch_4_0= ruleXExpression ) )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2466:1: (lv_switch_4_0= ruleXExpression )
            {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2466:1: (lv_switch_4_0= ruleXExpression )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2467:3: lv_switch_4_0= ruleXExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getXSwitchExpressionAccess().getSwitchXExpressionParserRuleCall_3_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleXExpression_in_ruleXSwitchExpression5986);
            lv_switch_4_0=ruleXExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getXSwitchExpressionRule());
              	        }
                     		set(
                     			current, 
                     			"switch",
                      		lv_switch_4_0, 
                      		"XExpression");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            otherlv_5=(Token)match(input,48,FOLLOW_48_in_ruleXSwitchExpression5998); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_5, grammarAccess.getXSwitchExpressionAccess().getLeftCurlyBracketKeyword_4());
                  
            }
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2487:1: ( (lv_cases_6_0= ruleXCasePart ) )+
            int cnt41=0;
            loop41:
            do {
                int alt41=2;
                int LA41_0 = input.LA(1);

                if ( (LA41_0==RULE_ID||LA41_0==39||LA41_0==47||LA41_0==51||LA41_0==69) ) {
                    alt41=1;
                }


                switch (alt41) {
            	case 1 :
            	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2488:1: (lv_cases_6_0= ruleXCasePart )
            	    {
            	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2488:1: (lv_cases_6_0= ruleXCasePart )
            	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2489:3: lv_cases_6_0= ruleXCasePart
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getXSwitchExpressionAccess().getCasesXCasePartParserRuleCall_5_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleXCasePart_in_ruleXSwitchExpression6019);
            	    lv_cases_6_0=ruleXCasePart();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getXSwitchExpressionRule());
            	      	        }
            	             		add(
            	             			current, 
            	             			"cases",
            	              		lv_cases_6_0, 
            	              		"XCasePart");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt41 >= 1 ) break loop41;
            	    if (state.backtracking>0) {state.failed=true; return current;}
                        EarlyExitException eee =
                            new EarlyExitException(41, input);
                        throw eee;
                }
                cnt41++;
            } while (true);

            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2505:3: (otherlv_7= 'default' otherlv_8= ':' ( (lv_default_9_0= ruleXExpression ) ) )?
            int alt42=2;
            int LA42_0 = input.LA(1);

            if ( (LA42_0==49) ) {
                alt42=1;
            }
            switch (alt42) {
                case 1 :
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2505:5: otherlv_7= 'default' otherlv_8= ':' ( (lv_default_9_0= ruleXExpression ) )
                    {
                    otherlv_7=(Token)match(input,49,FOLLOW_49_in_ruleXSwitchExpression6033); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_7, grammarAccess.getXSwitchExpressionAccess().getDefaultKeyword_6_0());
                          
                    }
                    otherlv_8=(Token)match(input,47,FOLLOW_47_in_ruleXSwitchExpression6045); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_8, grammarAccess.getXSwitchExpressionAccess().getColonKeyword_6_1());
                          
                    }
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2513:1: ( (lv_default_9_0= ruleXExpression ) )
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2514:1: (lv_default_9_0= ruleXExpression )
                    {
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2514:1: (lv_default_9_0= ruleXExpression )
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2515:3: lv_default_9_0= ruleXExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getXSwitchExpressionAccess().getDefaultXExpressionParserRuleCall_6_2_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleXExpression_in_ruleXSwitchExpression6066);
                    lv_default_9_0=ruleXExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getXSwitchExpressionRule());
                      	        }
                             		set(
                             			current, 
                             			"default",
                              		lv_default_9_0, 
                              		"XExpression");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }
                    break;

            }

            otherlv_10=(Token)match(input,50,FOLLOW_50_in_ruleXSwitchExpression6080); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_10, grammarAccess.getXSwitchExpressionAccess().getRightCurlyBracketKeyword_7());
                  
            }

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleXSwitchExpression"


    // $ANTLR start "entryRuleXCasePart"
    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2543:1: entryRuleXCasePart returns [EObject current=null] : iv_ruleXCasePart= ruleXCasePart EOF ;
    public final EObject entryRuleXCasePart() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXCasePart = null;


        try {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2544:2: (iv_ruleXCasePart= ruleXCasePart EOF )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2545:2: iv_ruleXCasePart= ruleXCasePart EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXCasePartRule()); 
            }
            pushFollow(FOLLOW_ruleXCasePart_in_entryRuleXCasePart6116);
            iv_ruleXCasePart=ruleXCasePart();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXCasePart; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXCasePart6126); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleXCasePart"


    // $ANTLR start "ruleXCasePart"
    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2552:1: ruleXCasePart returns [EObject current=null] : ( ( (lv_typeGuard_0_0= ruleJvmTypeReference ) )? (otherlv_1= 'case' ( (lv_case_2_0= ruleXExpression ) ) )? otherlv_3= ':' ( (lv_then_4_0= ruleXExpression ) ) ) ;
    public final EObject ruleXCasePart() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        EObject lv_typeGuard_0_0 = null;

        EObject lv_case_2_0 = null;

        EObject lv_then_4_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2555:28: ( ( ( (lv_typeGuard_0_0= ruleJvmTypeReference ) )? (otherlv_1= 'case' ( (lv_case_2_0= ruleXExpression ) ) )? otherlv_3= ':' ( (lv_then_4_0= ruleXExpression ) ) ) )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2556:1: ( ( (lv_typeGuard_0_0= ruleJvmTypeReference ) )? (otherlv_1= 'case' ( (lv_case_2_0= ruleXExpression ) ) )? otherlv_3= ':' ( (lv_then_4_0= ruleXExpression ) ) )
            {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2556:1: ( ( (lv_typeGuard_0_0= ruleJvmTypeReference ) )? (otherlv_1= 'case' ( (lv_case_2_0= ruleXExpression ) ) )? otherlv_3= ':' ( (lv_then_4_0= ruleXExpression ) ) )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2556:2: ( (lv_typeGuard_0_0= ruleJvmTypeReference ) )? (otherlv_1= 'case' ( (lv_case_2_0= ruleXExpression ) ) )? otherlv_3= ':' ( (lv_then_4_0= ruleXExpression ) )
            {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2556:2: ( (lv_typeGuard_0_0= ruleJvmTypeReference ) )?
            int alt43=2;
            int LA43_0 = input.LA(1);

            if ( (LA43_0==RULE_ID||LA43_0==39||LA43_0==69) ) {
                alt43=1;
            }
            switch (alt43) {
                case 1 :
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2557:1: (lv_typeGuard_0_0= ruleJvmTypeReference )
                    {
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2557:1: (lv_typeGuard_0_0= ruleJvmTypeReference )
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2558:3: lv_typeGuard_0_0= ruleJvmTypeReference
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getXCasePartAccess().getTypeGuardJvmTypeReferenceParserRuleCall_0_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleJvmTypeReference_in_ruleXCasePart6172);
                    lv_typeGuard_0_0=ruleJvmTypeReference();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getXCasePartRule());
                      	        }
                             		set(
                             			current, 
                             			"typeGuard",
                              		lv_typeGuard_0_0, 
                              		"JvmTypeReference");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }
                    break;

            }

            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2574:3: (otherlv_1= 'case' ( (lv_case_2_0= ruleXExpression ) ) )?
            int alt44=2;
            int LA44_0 = input.LA(1);

            if ( (LA44_0==51) ) {
                alt44=1;
            }
            switch (alt44) {
                case 1 :
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2574:5: otherlv_1= 'case' ( (lv_case_2_0= ruleXExpression ) )
                    {
                    otherlv_1=(Token)match(input,51,FOLLOW_51_in_ruleXCasePart6186); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_1, grammarAccess.getXCasePartAccess().getCaseKeyword_1_0());
                          
                    }
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2578:1: ( (lv_case_2_0= ruleXExpression ) )
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2579:1: (lv_case_2_0= ruleXExpression )
                    {
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2579:1: (lv_case_2_0= ruleXExpression )
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2580:3: lv_case_2_0= ruleXExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getXCasePartAccess().getCaseXExpressionParserRuleCall_1_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleXExpression_in_ruleXCasePart6207);
                    lv_case_2_0=ruleXExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getXCasePartRule());
                      	        }
                             		set(
                             			current, 
                             			"case",
                              		lv_case_2_0, 
                              		"XExpression");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }
                    break;

            }

            otherlv_3=(Token)match(input,47,FOLLOW_47_in_ruleXCasePart6221); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_3, grammarAccess.getXCasePartAccess().getColonKeyword_2());
                  
            }
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2600:1: ( (lv_then_4_0= ruleXExpression ) )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2601:1: (lv_then_4_0= ruleXExpression )
            {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2601:1: (lv_then_4_0= ruleXExpression )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2602:3: lv_then_4_0= ruleXExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getXCasePartAccess().getThenXExpressionParserRuleCall_3_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleXExpression_in_ruleXCasePart6242);
            lv_then_4_0=ruleXExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getXCasePartRule());
              	        }
                     		set(
                     			current, 
                     			"then",
                      		lv_then_4_0, 
                      		"XExpression");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleXCasePart"


    // $ANTLR start "entryRuleXForLoopExpression"
    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2626:1: entryRuleXForLoopExpression returns [EObject current=null] : iv_ruleXForLoopExpression= ruleXForLoopExpression EOF ;
    public final EObject entryRuleXForLoopExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXForLoopExpression = null;


        try {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2627:2: (iv_ruleXForLoopExpression= ruleXForLoopExpression EOF )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2628:2: iv_ruleXForLoopExpression= ruleXForLoopExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXForLoopExpressionRule()); 
            }
            pushFollow(FOLLOW_ruleXForLoopExpression_in_entryRuleXForLoopExpression6278);
            iv_ruleXForLoopExpression=ruleXForLoopExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXForLoopExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXForLoopExpression6288); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleXForLoopExpression"


    // $ANTLR start "ruleXForLoopExpression"
    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2635:1: ruleXForLoopExpression returns [EObject current=null] : ( () otherlv_1= 'for' otherlv_2= '(' ( (lv_declaredParam_3_0= ruleJvmFormalParameter ) ) otherlv_4= ':' ( (lv_forExpression_5_0= ruleXExpression ) ) otherlv_6= ')' ( (lv_eachExpression_7_0= ruleXExpression ) ) ) ;
    public final EObject ruleXForLoopExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        EObject lv_declaredParam_3_0 = null;

        EObject lv_forExpression_5_0 = null;

        EObject lv_eachExpression_7_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2638:28: ( ( () otherlv_1= 'for' otherlv_2= '(' ( (lv_declaredParam_3_0= ruleJvmFormalParameter ) ) otherlv_4= ':' ( (lv_forExpression_5_0= ruleXExpression ) ) otherlv_6= ')' ( (lv_eachExpression_7_0= ruleXExpression ) ) ) )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2639:1: ( () otherlv_1= 'for' otherlv_2= '(' ( (lv_declaredParam_3_0= ruleJvmFormalParameter ) ) otherlv_4= ':' ( (lv_forExpression_5_0= ruleXExpression ) ) otherlv_6= ')' ( (lv_eachExpression_7_0= ruleXExpression ) ) )
            {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2639:1: ( () otherlv_1= 'for' otherlv_2= '(' ( (lv_declaredParam_3_0= ruleJvmFormalParameter ) ) otherlv_4= ':' ( (lv_forExpression_5_0= ruleXExpression ) ) otherlv_6= ')' ( (lv_eachExpression_7_0= ruleXExpression ) ) )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2639:2: () otherlv_1= 'for' otherlv_2= '(' ( (lv_declaredParam_3_0= ruleJvmFormalParameter ) ) otherlv_4= ':' ( (lv_forExpression_5_0= ruleXExpression ) ) otherlv_6= ')' ( (lv_eachExpression_7_0= ruleXExpression ) )
            {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2639:2: ()
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2640:5: 
            {
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getXForLoopExpressionAccess().getXForLoopExpressionAction_0(),
                          current);
                  
            }

            }

            otherlv_1=(Token)match(input,52,FOLLOW_52_in_ruleXForLoopExpression6334); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getXForLoopExpressionAccess().getForKeyword_1());
                  
            }
            otherlv_2=(Token)match(input,39,FOLLOW_39_in_ruleXForLoopExpression6346); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_2, grammarAccess.getXForLoopExpressionAccess().getLeftParenthesisKeyword_2());
                  
            }
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2653:1: ( (lv_declaredParam_3_0= ruleJvmFormalParameter ) )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2654:1: (lv_declaredParam_3_0= ruleJvmFormalParameter )
            {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2654:1: (lv_declaredParam_3_0= ruleJvmFormalParameter )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2655:3: lv_declaredParam_3_0= ruleJvmFormalParameter
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getXForLoopExpressionAccess().getDeclaredParamJvmFormalParameterParserRuleCall_3_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleJvmFormalParameter_in_ruleXForLoopExpression6367);
            lv_declaredParam_3_0=ruleJvmFormalParameter();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getXForLoopExpressionRule());
              	        }
                     		set(
                     			current, 
                     			"declaredParam",
                      		lv_declaredParam_3_0, 
                      		"JvmFormalParameter");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            otherlv_4=(Token)match(input,47,FOLLOW_47_in_ruleXForLoopExpression6379); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_4, grammarAccess.getXForLoopExpressionAccess().getColonKeyword_4());
                  
            }
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2675:1: ( (lv_forExpression_5_0= ruleXExpression ) )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2676:1: (lv_forExpression_5_0= ruleXExpression )
            {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2676:1: (lv_forExpression_5_0= ruleXExpression )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2677:3: lv_forExpression_5_0= ruleXExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getXForLoopExpressionAccess().getForExpressionXExpressionParserRuleCall_5_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleXExpression_in_ruleXForLoopExpression6400);
            lv_forExpression_5_0=ruleXExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getXForLoopExpressionRule());
              	        }
                     		set(
                     			current, 
                     			"forExpression",
                      		lv_forExpression_5_0, 
                      		"XExpression");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            otherlv_6=(Token)match(input,40,FOLLOW_40_in_ruleXForLoopExpression6412); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_6, grammarAccess.getXForLoopExpressionAccess().getRightParenthesisKeyword_6());
                  
            }
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2697:1: ( (lv_eachExpression_7_0= ruleXExpression ) )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2698:1: (lv_eachExpression_7_0= ruleXExpression )
            {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2698:1: (lv_eachExpression_7_0= ruleXExpression )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2699:3: lv_eachExpression_7_0= ruleXExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getXForLoopExpressionAccess().getEachExpressionXExpressionParserRuleCall_7_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleXExpression_in_ruleXForLoopExpression6433);
            lv_eachExpression_7_0=ruleXExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getXForLoopExpressionRule());
              	        }
                     		set(
                     			current, 
                     			"eachExpression",
                      		lv_eachExpression_7_0, 
                      		"XExpression");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleXForLoopExpression"


    // $ANTLR start "entryRuleXWhileExpression"
    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2723:1: entryRuleXWhileExpression returns [EObject current=null] : iv_ruleXWhileExpression= ruleXWhileExpression EOF ;
    public final EObject entryRuleXWhileExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXWhileExpression = null;


        try {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2724:2: (iv_ruleXWhileExpression= ruleXWhileExpression EOF )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2725:2: iv_ruleXWhileExpression= ruleXWhileExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXWhileExpressionRule()); 
            }
            pushFollow(FOLLOW_ruleXWhileExpression_in_entryRuleXWhileExpression6469);
            iv_ruleXWhileExpression=ruleXWhileExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXWhileExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXWhileExpression6479); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleXWhileExpression"


    // $ANTLR start "ruleXWhileExpression"
    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2732:1: ruleXWhileExpression returns [EObject current=null] : ( () otherlv_1= 'while' otherlv_2= '(' ( (lv_predicate_3_0= ruleXExpression ) ) otherlv_4= ')' ( (lv_body_5_0= ruleXExpression ) ) ) ;
    public final EObject ruleXWhileExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject lv_predicate_3_0 = null;

        EObject lv_body_5_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2735:28: ( ( () otherlv_1= 'while' otherlv_2= '(' ( (lv_predicate_3_0= ruleXExpression ) ) otherlv_4= ')' ( (lv_body_5_0= ruleXExpression ) ) ) )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2736:1: ( () otherlv_1= 'while' otherlv_2= '(' ( (lv_predicate_3_0= ruleXExpression ) ) otherlv_4= ')' ( (lv_body_5_0= ruleXExpression ) ) )
            {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2736:1: ( () otherlv_1= 'while' otherlv_2= '(' ( (lv_predicate_3_0= ruleXExpression ) ) otherlv_4= ')' ( (lv_body_5_0= ruleXExpression ) ) )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2736:2: () otherlv_1= 'while' otherlv_2= '(' ( (lv_predicate_3_0= ruleXExpression ) ) otherlv_4= ')' ( (lv_body_5_0= ruleXExpression ) )
            {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2736:2: ()
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2737:5: 
            {
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getXWhileExpressionAccess().getXWhileExpressionAction_0(),
                          current);
                  
            }

            }

            otherlv_1=(Token)match(input,53,FOLLOW_53_in_ruleXWhileExpression6525); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getXWhileExpressionAccess().getWhileKeyword_1());
                  
            }
            otherlv_2=(Token)match(input,39,FOLLOW_39_in_ruleXWhileExpression6537); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_2, grammarAccess.getXWhileExpressionAccess().getLeftParenthesisKeyword_2());
                  
            }
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2750:1: ( (lv_predicate_3_0= ruleXExpression ) )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2751:1: (lv_predicate_3_0= ruleXExpression )
            {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2751:1: (lv_predicate_3_0= ruleXExpression )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2752:3: lv_predicate_3_0= ruleXExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getXWhileExpressionAccess().getPredicateXExpressionParserRuleCall_3_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleXExpression_in_ruleXWhileExpression6558);
            lv_predicate_3_0=ruleXExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getXWhileExpressionRule());
              	        }
                     		set(
                     			current, 
                     			"predicate",
                      		lv_predicate_3_0, 
                      		"XExpression");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            otherlv_4=(Token)match(input,40,FOLLOW_40_in_ruleXWhileExpression6570); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_4, grammarAccess.getXWhileExpressionAccess().getRightParenthesisKeyword_4());
                  
            }
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2772:1: ( (lv_body_5_0= ruleXExpression ) )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2773:1: (lv_body_5_0= ruleXExpression )
            {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2773:1: (lv_body_5_0= ruleXExpression )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2774:3: lv_body_5_0= ruleXExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getXWhileExpressionAccess().getBodyXExpressionParserRuleCall_5_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleXExpression_in_ruleXWhileExpression6591);
            lv_body_5_0=ruleXExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getXWhileExpressionRule());
              	        }
                     		set(
                     			current, 
                     			"body",
                      		lv_body_5_0, 
                      		"XExpression");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleXWhileExpression"


    // $ANTLR start "entryRuleXDoWhileExpression"
    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2798:1: entryRuleXDoWhileExpression returns [EObject current=null] : iv_ruleXDoWhileExpression= ruleXDoWhileExpression EOF ;
    public final EObject entryRuleXDoWhileExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXDoWhileExpression = null;


        try {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2799:2: (iv_ruleXDoWhileExpression= ruleXDoWhileExpression EOF )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2800:2: iv_ruleXDoWhileExpression= ruleXDoWhileExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXDoWhileExpressionRule()); 
            }
            pushFollow(FOLLOW_ruleXDoWhileExpression_in_entryRuleXDoWhileExpression6627);
            iv_ruleXDoWhileExpression=ruleXDoWhileExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXDoWhileExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXDoWhileExpression6637); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleXDoWhileExpression"


    // $ANTLR start "ruleXDoWhileExpression"
    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2807:1: ruleXDoWhileExpression returns [EObject current=null] : ( () otherlv_1= 'do' ( (lv_body_2_0= ruleXExpression ) ) otherlv_3= 'while' otherlv_4= '(' ( (lv_predicate_5_0= ruleXExpression ) ) otherlv_6= ')' ) ;
    public final EObject ruleXDoWhileExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        EObject lv_body_2_0 = null;

        EObject lv_predicate_5_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2810:28: ( ( () otherlv_1= 'do' ( (lv_body_2_0= ruleXExpression ) ) otherlv_3= 'while' otherlv_4= '(' ( (lv_predicate_5_0= ruleXExpression ) ) otherlv_6= ')' ) )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2811:1: ( () otherlv_1= 'do' ( (lv_body_2_0= ruleXExpression ) ) otherlv_3= 'while' otherlv_4= '(' ( (lv_predicate_5_0= ruleXExpression ) ) otherlv_6= ')' )
            {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2811:1: ( () otherlv_1= 'do' ( (lv_body_2_0= ruleXExpression ) ) otherlv_3= 'while' otherlv_4= '(' ( (lv_predicate_5_0= ruleXExpression ) ) otherlv_6= ')' )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2811:2: () otherlv_1= 'do' ( (lv_body_2_0= ruleXExpression ) ) otherlv_3= 'while' otherlv_4= '(' ( (lv_predicate_5_0= ruleXExpression ) ) otherlv_6= ')'
            {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2811:2: ()
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2812:5: 
            {
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getXDoWhileExpressionAccess().getXDoWhileExpressionAction_0(),
                          current);
                  
            }

            }

            otherlv_1=(Token)match(input,54,FOLLOW_54_in_ruleXDoWhileExpression6683); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getXDoWhileExpressionAccess().getDoKeyword_1());
                  
            }
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2821:1: ( (lv_body_2_0= ruleXExpression ) )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2822:1: (lv_body_2_0= ruleXExpression )
            {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2822:1: (lv_body_2_0= ruleXExpression )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2823:3: lv_body_2_0= ruleXExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getXDoWhileExpressionAccess().getBodyXExpressionParserRuleCall_2_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleXExpression_in_ruleXDoWhileExpression6704);
            lv_body_2_0=ruleXExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getXDoWhileExpressionRule());
              	        }
                     		set(
                     			current, 
                     			"body",
                      		lv_body_2_0, 
                      		"XExpression");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            otherlv_3=(Token)match(input,53,FOLLOW_53_in_ruleXDoWhileExpression6716); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_3, grammarAccess.getXDoWhileExpressionAccess().getWhileKeyword_3());
                  
            }
            otherlv_4=(Token)match(input,39,FOLLOW_39_in_ruleXDoWhileExpression6728); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_4, grammarAccess.getXDoWhileExpressionAccess().getLeftParenthesisKeyword_4());
                  
            }
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2847:1: ( (lv_predicate_5_0= ruleXExpression ) )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2848:1: (lv_predicate_5_0= ruleXExpression )
            {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2848:1: (lv_predicate_5_0= ruleXExpression )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2849:3: lv_predicate_5_0= ruleXExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getXDoWhileExpressionAccess().getPredicateXExpressionParserRuleCall_5_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleXExpression_in_ruleXDoWhileExpression6749);
            lv_predicate_5_0=ruleXExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getXDoWhileExpressionRule());
              	        }
                     		set(
                     			current, 
                     			"predicate",
                      		lv_predicate_5_0, 
                      		"XExpression");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            otherlv_6=(Token)match(input,40,FOLLOW_40_in_ruleXDoWhileExpression6761); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_6, grammarAccess.getXDoWhileExpressionAccess().getRightParenthesisKeyword_6());
                  
            }

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleXDoWhileExpression"


    // $ANTLR start "entryRuleXBlockExpression"
    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2877:1: entryRuleXBlockExpression returns [EObject current=null] : iv_ruleXBlockExpression= ruleXBlockExpression EOF ;
    public final EObject entryRuleXBlockExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXBlockExpression = null;


        try {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2878:2: (iv_ruleXBlockExpression= ruleXBlockExpression EOF )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2879:2: iv_ruleXBlockExpression= ruleXBlockExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXBlockExpressionRule()); 
            }
            pushFollow(FOLLOW_ruleXBlockExpression_in_entryRuleXBlockExpression6797);
            iv_ruleXBlockExpression=ruleXBlockExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXBlockExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXBlockExpression6807); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleXBlockExpression"


    // $ANTLR start "ruleXBlockExpression"
    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2886:1: ruleXBlockExpression returns [EObject current=null] : ( () otherlv_1= '{' ( ( (lv_expressions_2_0= ruleXExpressionInsideBlock ) ) (otherlv_3= ';' )? )* otherlv_4= '}' ) ;
    public final EObject ruleXBlockExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        EObject lv_expressions_2_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2889:28: ( ( () otherlv_1= '{' ( ( (lv_expressions_2_0= ruleXExpressionInsideBlock ) ) (otherlv_3= ';' )? )* otherlv_4= '}' ) )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2890:1: ( () otherlv_1= '{' ( ( (lv_expressions_2_0= ruleXExpressionInsideBlock ) ) (otherlv_3= ';' )? )* otherlv_4= '}' )
            {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2890:1: ( () otherlv_1= '{' ( ( (lv_expressions_2_0= ruleXExpressionInsideBlock ) ) (otherlv_3= ';' )? )* otherlv_4= '}' )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2890:2: () otherlv_1= '{' ( ( (lv_expressions_2_0= ruleXExpressionInsideBlock ) ) (otherlv_3= ';' )? )* otherlv_4= '}'
            {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2890:2: ()
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2891:5: 
            {
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getXBlockExpressionAccess().getXBlockExpressionAction_0(),
                          current);
                  
            }

            }

            otherlv_1=(Token)match(input,48,FOLLOW_48_in_ruleXBlockExpression6853); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getXBlockExpressionAccess().getLeftCurlyBracketKeyword_1());
                  
            }
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2900:1: ( ( (lv_expressions_2_0= ruleXExpressionInsideBlock ) ) (otherlv_3= ';' )? )*
            loop46:
            do {
                int alt46=2;
                int LA46_0 = input.LA(1);

                if ( ((LA46_0>=RULE_INT && LA46_0<=RULE_ID)||LA46_0==24||(LA46_0>=27 && LA46_0<=28)||LA46_0==33||LA46_0==39||LA46_0==41||LA46_0==44||LA46_0==46||LA46_0==48||(LA46_0>=52 && LA46_0<=57)||(LA46_0>=59 && LA46_0<=66)) ) {
                    alt46=1;
                }


                switch (alt46) {
            	case 1 :
            	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2900:2: ( (lv_expressions_2_0= ruleXExpressionInsideBlock ) ) (otherlv_3= ';' )?
            	    {
            	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2900:2: ( (lv_expressions_2_0= ruleXExpressionInsideBlock ) )
            	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2901:1: (lv_expressions_2_0= ruleXExpressionInsideBlock )
            	    {
            	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2901:1: (lv_expressions_2_0= ruleXExpressionInsideBlock )
            	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2902:3: lv_expressions_2_0= ruleXExpressionInsideBlock
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getXBlockExpressionAccess().getExpressionsXExpressionInsideBlockParserRuleCall_2_0_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleXExpressionInsideBlock_in_ruleXBlockExpression6875);
            	    lv_expressions_2_0=ruleXExpressionInsideBlock();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getXBlockExpressionRule());
            	      	        }
            	             		add(
            	             			current, 
            	             			"expressions",
            	              		lv_expressions_2_0, 
            	              		"XExpressionInsideBlock");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }

            	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2918:2: (otherlv_3= ';' )?
            	    int alt45=2;
            	    int LA45_0 = input.LA(1);

            	    if ( (LA45_0==11) ) {
            	        alt45=1;
            	    }
            	    switch (alt45) {
            	        case 1 :
            	            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2918:4: otherlv_3= ';'
            	            {
            	            otherlv_3=(Token)match(input,11,FOLLOW_11_in_ruleXBlockExpression6888); if (state.failed) return current;
            	            if ( state.backtracking==0 ) {

            	                  	newLeafNode(otherlv_3, grammarAccess.getXBlockExpressionAccess().getSemicolonKeyword_2_1());
            	                  
            	            }

            	            }
            	            break;

            	    }


            	    }
            	    break;

            	default :
            	    break loop46;
                }
            } while (true);

            otherlv_4=(Token)match(input,50,FOLLOW_50_in_ruleXBlockExpression6904); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_4, grammarAccess.getXBlockExpressionAccess().getRightCurlyBracketKeyword_3());
                  
            }

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleXBlockExpression"


    // $ANTLR start "entryRuleXExpressionInsideBlock"
    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2934:1: entryRuleXExpressionInsideBlock returns [EObject current=null] : iv_ruleXExpressionInsideBlock= ruleXExpressionInsideBlock EOF ;
    public final EObject entryRuleXExpressionInsideBlock() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXExpressionInsideBlock = null;


        try {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2935:2: (iv_ruleXExpressionInsideBlock= ruleXExpressionInsideBlock EOF )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2936:2: iv_ruleXExpressionInsideBlock= ruleXExpressionInsideBlock EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXExpressionInsideBlockRule()); 
            }
            pushFollow(FOLLOW_ruleXExpressionInsideBlock_in_entryRuleXExpressionInsideBlock6940);
            iv_ruleXExpressionInsideBlock=ruleXExpressionInsideBlock();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXExpressionInsideBlock; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXExpressionInsideBlock6950); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleXExpressionInsideBlock"


    // $ANTLR start "ruleXExpressionInsideBlock"
    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2943:1: ruleXExpressionInsideBlock returns [EObject current=null] : (this_XVariableDeclaration_0= ruleXVariableDeclaration | this_XExpression_1= ruleXExpression ) ;
    public final EObject ruleXExpressionInsideBlock() throws RecognitionException {
        EObject current = null;

        EObject this_XVariableDeclaration_0 = null;

        EObject this_XExpression_1 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2946:28: ( (this_XVariableDeclaration_0= ruleXVariableDeclaration | this_XExpression_1= ruleXExpression ) )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2947:1: (this_XVariableDeclaration_0= ruleXVariableDeclaration | this_XExpression_1= ruleXExpression )
            {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2947:1: (this_XVariableDeclaration_0= ruleXVariableDeclaration | this_XExpression_1= ruleXExpression )
            int alt47=2;
            int LA47_0 = input.LA(1);

            if ( ((LA47_0>=55 && LA47_0<=56)) ) {
                alt47=1;
            }
            else if ( ((LA47_0>=RULE_INT && LA47_0<=RULE_ID)||LA47_0==24||(LA47_0>=27 && LA47_0<=28)||LA47_0==33||LA47_0==39||LA47_0==41||LA47_0==44||LA47_0==46||LA47_0==48||(LA47_0>=52 && LA47_0<=54)||LA47_0==57||(LA47_0>=59 && LA47_0<=66)) ) {
                alt47=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 47, 0, input);

                throw nvae;
            }
            switch (alt47) {
                case 1 :
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2948:5: this_XVariableDeclaration_0= ruleXVariableDeclaration
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getXExpressionInsideBlockAccess().getXVariableDeclarationParserRuleCall_0()); 
                          
                    }
                    pushFollow(FOLLOW_ruleXVariableDeclaration_in_ruleXExpressionInsideBlock6997);
                    this_XVariableDeclaration_0=ruleXVariableDeclaration();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_XVariableDeclaration_0; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2958:5: this_XExpression_1= ruleXExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getXExpressionInsideBlockAccess().getXExpressionParserRuleCall_1()); 
                          
                    }
                    pushFollow(FOLLOW_ruleXExpression_in_ruleXExpressionInsideBlock7024);
                    this_XExpression_1=ruleXExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_XExpression_1; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleXExpressionInsideBlock"


    // $ANTLR start "entryRuleXVariableDeclaration"
    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2974:1: entryRuleXVariableDeclaration returns [EObject current=null] : iv_ruleXVariableDeclaration= ruleXVariableDeclaration EOF ;
    public final EObject entryRuleXVariableDeclaration() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXVariableDeclaration = null;


        try {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2975:2: (iv_ruleXVariableDeclaration= ruleXVariableDeclaration EOF )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2976:2: iv_ruleXVariableDeclaration= ruleXVariableDeclaration EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXVariableDeclarationRule()); 
            }
            pushFollow(FOLLOW_ruleXVariableDeclaration_in_entryRuleXVariableDeclaration7059);
            iv_ruleXVariableDeclaration=ruleXVariableDeclaration();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXVariableDeclaration; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXVariableDeclaration7069); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleXVariableDeclaration"


    // $ANTLR start "ruleXVariableDeclaration"
    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2983:1: ruleXVariableDeclaration returns [EObject current=null] : ( () ( ( (lv_writeable_1_0= 'var' ) ) | otherlv_2= 'val' ) ( ( ( ( ( ( ruleJvmTypeReference ) ) ( ( ruleValidID ) ) ) )=> ( ( (lv_type_3_0= ruleJvmTypeReference ) ) ( (lv_name_4_0= ruleValidID ) ) ) ) | ( (lv_name_5_0= ruleValidID ) ) ) (otherlv_6= '=' ( (lv_right_7_0= ruleXExpression ) ) )? ) ;
    public final EObject ruleXVariableDeclaration() throws RecognitionException {
        EObject current = null;

        Token lv_writeable_1_0=null;
        Token otherlv_2=null;
        Token otherlv_6=null;
        EObject lv_type_3_0 = null;

        AntlrDatatypeRuleToken lv_name_4_0 = null;

        AntlrDatatypeRuleToken lv_name_5_0 = null;

        EObject lv_right_7_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2986:28: ( ( () ( ( (lv_writeable_1_0= 'var' ) ) | otherlv_2= 'val' ) ( ( ( ( ( ( ruleJvmTypeReference ) ) ( ( ruleValidID ) ) ) )=> ( ( (lv_type_3_0= ruleJvmTypeReference ) ) ( (lv_name_4_0= ruleValidID ) ) ) ) | ( (lv_name_5_0= ruleValidID ) ) ) (otherlv_6= '=' ( (lv_right_7_0= ruleXExpression ) ) )? ) )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2987:1: ( () ( ( (lv_writeable_1_0= 'var' ) ) | otherlv_2= 'val' ) ( ( ( ( ( ( ruleJvmTypeReference ) ) ( ( ruleValidID ) ) ) )=> ( ( (lv_type_3_0= ruleJvmTypeReference ) ) ( (lv_name_4_0= ruleValidID ) ) ) ) | ( (lv_name_5_0= ruleValidID ) ) ) (otherlv_6= '=' ( (lv_right_7_0= ruleXExpression ) ) )? )
            {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2987:1: ( () ( ( (lv_writeable_1_0= 'var' ) ) | otherlv_2= 'val' ) ( ( ( ( ( ( ruleJvmTypeReference ) ) ( ( ruleValidID ) ) ) )=> ( ( (lv_type_3_0= ruleJvmTypeReference ) ) ( (lv_name_4_0= ruleValidID ) ) ) ) | ( (lv_name_5_0= ruleValidID ) ) ) (otherlv_6= '=' ( (lv_right_7_0= ruleXExpression ) ) )? )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2987:2: () ( ( (lv_writeable_1_0= 'var' ) ) | otherlv_2= 'val' ) ( ( ( ( ( ( ruleJvmTypeReference ) ) ( ( ruleValidID ) ) ) )=> ( ( (lv_type_3_0= ruleJvmTypeReference ) ) ( (lv_name_4_0= ruleValidID ) ) ) ) | ( (lv_name_5_0= ruleValidID ) ) ) (otherlv_6= '=' ( (lv_right_7_0= ruleXExpression ) ) )?
            {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2987:2: ()
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2988:5: 
            {
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getXVariableDeclarationAccess().getXVariableDeclarationAction_0(),
                          current);
                  
            }

            }

            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2993:2: ( ( (lv_writeable_1_0= 'var' ) ) | otherlv_2= 'val' )
            int alt48=2;
            int LA48_0 = input.LA(1);

            if ( (LA48_0==55) ) {
                alt48=1;
            }
            else if ( (LA48_0==56) ) {
                alt48=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 48, 0, input);

                throw nvae;
            }
            switch (alt48) {
                case 1 :
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2993:3: ( (lv_writeable_1_0= 'var' ) )
                    {
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2993:3: ( (lv_writeable_1_0= 'var' ) )
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2994:1: (lv_writeable_1_0= 'var' )
                    {
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2994:1: (lv_writeable_1_0= 'var' )
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2995:3: lv_writeable_1_0= 'var'
                    {
                    lv_writeable_1_0=(Token)match(input,55,FOLLOW_55_in_ruleXVariableDeclaration7122); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              newLeafNode(lv_writeable_1_0, grammarAccess.getXVariableDeclarationAccess().getWriteableVarKeyword_1_0_0());
                          
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getXVariableDeclarationRule());
                      	        }
                             		setWithLastConsumed(current, "writeable", true, "var");
                      	    
                    }

                    }


                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3009:7: otherlv_2= 'val'
                    {
                    otherlv_2=(Token)match(input,56,FOLLOW_56_in_ruleXVariableDeclaration7153); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_2, grammarAccess.getXVariableDeclarationAccess().getValKeyword_1_1());
                          
                    }

                    }
                    break;

            }

            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3013:2: ( ( ( ( ( ( ruleJvmTypeReference ) ) ( ( ruleValidID ) ) ) )=> ( ( (lv_type_3_0= ruleJvmTypeReference ) ) ( (lv_name_4_0= ruleValidID ) ) ) ) | ( (lv_name_5_0= ruleValidID ) ) )
            int alt49=2;
            int LA49_0 = input.LA(1);

            if ( (LA49_0==RULE_ID) ) {
                int LA49_1 = input.LA(2);

                if ( (synpred20_InternalPureXbase()) ) {
                    alt49=1;
                }
                else if ( (true) ) {
                    alt49=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 49, 1, input);

                    throw nvae;
                }
            }
            else if ( (LA49_0==39) && (synpred20_InternalPureXbase())) {
                alt49=1;
            }
            else if ( (LA49_0==69) && (synpred20_InternalPureXbase())) {
                alt49=1;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 49, 0, input);

                throw nvae;
            }
            switch (alt49) {
                case 1 :
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3013:3: ( ( ( ( ( ruleJvmTypeReference ) ) ( ( ruleValidID ) ) ) )=> ( ( (lv_type_3_0= ruleJvmTypeReference ) ) ( (lv_name_4_0= ruleValidID ) ) ) )
                    {
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3013:3: ( ( ( ( ( ruleJvmTypeReference ) ) ( ( ruleValidID ) ) ) )=> ( ( (lv_type_3_0= ruleJvmTypeReference ) ) ( (lv_name_4_0= ruleValidID ) ) ) )
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3013:4: ( ( ( ( ruleJvmTypeReference ) ) ( ( ruleValidID ) ) ) )=> ( ( (lv_type_3_0= ruleJvmTypeReference ) ) ( (lv_name_4_0= ruleValidID ) ) )
                    {
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3021:6: ( ( (lv_type_3_0= ruleJvmTypeReference ) ) ( (lv_name_4_0= ruleValidID ) ) )
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3021:7: ( (lv_type_3_0= ruleJvmTypeReference ) ) ( (lv_name_4_0= ruleValidID ) )
                    {
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3021:7: ( (lv_type_3_0= ruleJvmTypeReference ) )
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3022:1: (lv_type_3_0= ruleJvmTypeReference )
                    {
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3022:1: (lv_type_3_0= ruleJvmTypeReference )
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3023:3: lv_type_3_0= ruleJvmTypeReference
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getXVariableDeclarationAccess().getTypeJvmTypeReferenceParserRuleCall_2_0_0_0_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleJvmTypeReference_in_ruleXVariableDeclaration7201);
                    lv_type_3_0=ruleJvmTypeReference();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getXVariableDeclarationRule());
                      	        }
                             		set(
                             			current, 
                             			"type",
                              		lv_type_3_0, 
                              		"JvmTypeReference");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }

                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3039:2: ( (lv_name_4_0= ruleValidID ) )
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3040:1: (lv_name_4_0= ruleValidID )
                    {
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3040:1: (lv_name_4_0= ruleValidID )
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3041:3: lv_name_4_0= ruleValidID
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getXVariableDeclarationAccess().getNameValidIDParserRuleCall_2_0_0_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleValidID_in_ruleXVariableDeclaration7222);
                    lv_name_4_0=ruleValidID();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getXVariableDeclarationRule());
                      	        }
                             		set(
                             			current, 
                             			"name",
                              		lv_name_4_0, 
                              		"ValidID");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3058:6: ( (lv_name_5_0= ruleValidID ) )
                    {
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3058:6: ( (lv_name_5_0= ruleValidID ) )
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3059:1: (lv_name_5_0= ruleValidID )
                    {
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3059:1: (lv_name_5_0= ruleValidID )
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3060:3: lv_name_5_0= ruleValidID
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getXVariableDeclarationAccess().getNameValidIDParserRuleCall_2_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleValidID_in_ruleXVariableDeclaration7251);
                    lv_name_5_0=ruleValidID();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getXVariableDeclarationRule());
                      	        }
                             		set(
                             			current, 
                             			"name",
                              		lv_name_5_0, 
                              		"ValidID");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }
                    break;

            }

            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3076:3: (otherlv_6= '=' ( (lv_right_7_0= ruleXExpression ) ) )?
            int alt50=2;
            int LA50_0 = input.LA(1);

            if ( (LA50_0==14) ) {
                alt50=1;
            }
            switch (alt50) {
                case 1 :
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3076:5: otherlv_6= '=' ( (lv_right_7_0= ruleXExpression ) )
                    {
                    otherlv_6=(Token)match(input,14,FOLLOW_14_in_ruleXVariableDeclaration7265); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_6, grammarAccess.getXVariableDeclarationAccess().getEqualsSignKeyword_3_0());
                          
                    }
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3080:1: ( (lv_right_7_0= ruleXExpression ) )
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3081:1: (lv_right_7_0= ruleXExpression )
                    {
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3081:1: (lv_right_7_0= ruleXExpression )
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3082:3: lv_right_7_0= ruleXExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getXVariableDeclarationAccess().getRightXExpressionParserRuleCall_3_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleXExpression_in_ruleXVariableDeclaration7286);
                    lv_right_7_0=ruleXExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getXVariableDeclarationRule());
                      	        }
                             		set(
                             			current, 
                             			"right",
                              		lv_right_7_0, 
                              		"XExpression");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }
                    break;

            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleXVariableDeclaration"


    // $ANTLR start "entryRuleJvmFormalParameter"
    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3106:1: entryRuleJvmFormalParameter returns [EObject current=null] : iv_ruleJvmFormalParameter= ruleJvmFormalParameter EOF ;
    public final EObject entryRuleJvmFormalParameter() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleJvmFormalParameter = null;


        try {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3107:2: (iv_ruleJvmFormalParameter= ruleJvmFormalParameter EOF )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3108:2: iv_ruleJvmFormalParameter= ruleJvmFormalParameter EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getJvmFormalParameterRule()); 
            }
            pushFollow(FOLLOW_ruleJvmFormalParameter_in_entryRuleJvmFormalParameter7324);
            iv_ruleJvmFormalParameter=ruleJvmFormalParameter();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleJvmFormalParameter; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleJvmFormalParameter7334); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleJvmFormalParameter"


    // $ANTLR start "ruleJvmFormalParameter"
    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3115:1: ruleJvmFormalParameter returns [EObject current=null] : ( ( (lv_parameterType_0_0= ruleJvmTypeReference ) )? ( (lv_name_1_0= ruleValidID ) ) ) ;
    public final EObject ruleJvmFormalParameter() throws RecognitionException {
        EObject current = null;

        EObject lv_parameterType_0_0 = null;

        AntlrDatatypeRuleToken lv_name_1_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3118:28: ( ( ( (lv_parameterType_0_0= ruleJvmTypeReference ) )? ( (lv_name_1_0= ruleValidID ) ) ) )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3119:1: ( ( (lv_parameterType_0_0= ruleJvmTypeReference ) )? ( (lv_name_1_0= ruleValidID ) ) )
            {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3119:1: ( ( (lv_parameterType_0_0= ruleJvmTypeReference ) )? ( (lv_name_1_0= ruleValidID ) ) )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3119:2: ( (lv_parameterType_0_0= ruleJvmTypeReference ) )? ( (lv_name_1_0= ruleValidID ) )
            {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3119:2: ( (lv_parameterType_0_0= ruleJvmTypeReference ) )?
            int alt51=2;
            int LA51_0 = input.LA(1);

            if ( (LA51_0==RULE_ID) ) {
                int LA51_1 = input.LA(2);

                if ( (LA51_1==RULE_ID||LA51_1==24||LA51_1==35||LA51_1==41) ) {
                    alt51=1;
                }
            }
            else if ( (LA51_0==39||LA51_0==69) ) {
                alt51=1;
            }
            switch (alt51) {
                case 1 :
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3120:1: (lv_parameterType_0_0= ruleJvmTypeReference )
                    {
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3120:1: (lv_parameterType_0_0= ruleJvmTypeReference )
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3121:3: lv_parameterType_0_0= ruleJvmTypeReference
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getJvmFormalParameterAccess().getParameterTypeJvmTypeReferenceParserRuleCall_0_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleJvmTypeReference_in_ruleJvmFormalParameter7380);
                    lv_parameterType_0_0=ruleJvmTypeReference();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getJvmFormalParameterRule());
                      	        }
                             		set(
                             			current, 
                             			"parameterType",
                              		lv_parameterType_0_0, 
                              		"JvmTypeReference");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }
                    break;

            }

            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3137:3: ( (lv_name_1_0= ruleValidID ) )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3138:1: (lv_name_1_0= ruleValidID )
            {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3138:1: (lv_name_1_0= ruleValidID )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3139:3: lv_name_1_0= ruleValidID
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getJvmFormalParameterAccess().getNameValidIDParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleValidID_in_ruleJvmFormalParameter7402);
            lv_name_1_0=ruleValidID();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getJvmFormalParameterRule());
              	        }
                     		set(
                     			current, 
                     			"name",
                      		lv_name_1_0, 
                      		"ValidID");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleJvmFormalParameter"


    // $ANTLR start "entryRuleFullJvmFormalParameter"
    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3163:1: entryRuleFullJvmFormalParameter returns [EObject current=null] : iv_ruleFullJvmFormalParameter= ruleFullJvmFormalParameter EOF ;
    public final EObject entryRuleFullJvmFormalParameter() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFullJvmFormalParameter = null;


        try {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3164:2: (iv_ruleFullJvmFormalParameter= ruleFullJvmFormalParameter EOF )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3165:2: iv_ruleFullJvmFormalParameter= ruleFullJvmFormalParameter EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getFullJvmFormalParameterRule()); 
            }
            pushFollow(FOLLOW_ruleFullJvmFormalParameter_in_entryRuleFullJvmFormalParameter7438);
            iv_ruleFullJvmFormalParameter=ruleFullJvmFormalParameter();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleFullJvmFormalParameter; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleFullJvmFormalParameter7448); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleFullJvmFormalParameter"


    // $ANTLR start "ruleFullJvmFormalParameter"
    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3172:1: ruleFullJvmFormalParameter returns [EObject current=null] : ( ( (lv_parameterType_0_0= ruleJvmTypeReference ) ) ( (lv_name_1_0= ruleValidID ) ) ) ;
    public final EObject ruleFullJvmFormalParameter() throws RecognitionException {
        EObject current = null;

        EObject lv_parameterType_0_0 = null;

        AntlrDatatypeRuleToken lv_name_1_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3175:28: ( ( ( (lv_parameterType_0_0= ruleJvmTypeReference ) ) ( (lv_name_1_0= ruleValidID ) ) ) )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3176:1: ( ( (lv_parameterType_0_0= ruleJvmTypeReference ) ) ( (lv_name_1_0= ruleValidID ) ) )
            {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3176:1: ( ( (lv_parameterType_0_0= ruleJvmTypeReference ) ) ( (lv_name_1_0= ruleValidID ) ) )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3176:2: ( (lv_parameterType_0_0= ruleJvmTypeReference ) ) ( (lv_name_1_0= ruleValidID ) )
            {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3176:2: ( (lv_parameterType_0_0= ruleJvmTypeReference ) )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3177:1: (lv_parameterType_0_0= ruleJvmTypeReference )
            {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3177:1: (lv_parameterType_0_0= ruleJvmTypeReference )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3178:3: lv_parameterType_0_0= ruleJvmTypeReference
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getFullJvmFormalParameterAccess().getParameterTypeJvmTypeReferenceParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleJvmTypeReference_in_ruleFullJvmFormalParameter7494);
            lv_parameterType_0_0=ruleJvmTypeReference();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getFullJvmFormalParameterRule());
              	        }
                     		set(
                     			current, 
                     			"parameterType",
                      		lv_parameterType_0_0, 
                      		"JvmTypeReference");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3194:2: ( (lv_name_1_0= ruleValidID ) )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3195:1: (lv_name_1_0= ruleValidID )
            {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3195:1: (lv_name_1_0= ruleValidID )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3196:3: lv_name_1_0= ruleValidID
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getFullJvmFormalParameterAccess().getNameValidIDParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleValidID_in_ruleFullJvmFormalParameter7515);
            lv_name_1_0=ruleValidID();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getFullJvmFormalParameterRule());
              	        }
                     		set(
                     			current, 
                     			"name",
                      		lv_name_1_0, 
                      		"ValidID");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleFullJvmFormalParameter"


    // $ANTLR start "entryRuleXFeatureCall"
    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3220:1: entryRuleXFeatureCall returns [EObject current=null] : iv_ruleXFeatureCall= ruleXFeatureCall EOF ;
    public final EObject entryRuleXFeatureCall() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXFeatureCall = null;


        try {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3221:2: (iv_ruleXFeatureCall= ruleXFeatureCall EOF )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3222:2: iv_ruleXFeatureCall= ruleXFeatureCall EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXFeatureCallRule()); 
            }
            pushFollow(FOLLOW_ruleXFeatureCall_in_entryRuleXFeatureCall7551);
            iv_ruleXFeatureCall=ruleXFeatureCall();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXFeatureCall; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXFeatureCall7561); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleXFeatureCall"


    // $ANTLR start "ruleXFeatureCall"
    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3229:1: ruleXFeatureCall returns [EObject current=null] : ( () ( ( ruleStaticQualifier ) )? (otherlv_2= '<' ( (lv_typeArguments_3_0= ruleJvmArgumentTypeReference ) ) (otherlv_4= ',' ( (lv_typeArguments_5_0= ruleJvmArgumentTypeReference ) ) )* otherlv_6= '>' )? ( ( ruleIdOrSuper ) ) ( ( ( ( '(' ) )=> (lv_explicitOperationCall_8_0= '(' ) ) ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> (lv_featureCallArguments_9_0= ruleXShortClosure ) ) | ( ( (lv_featureCallArguments_10_0= ruleXExpression ) ) (otherlv_11= ',' ( (lv_featureCallArguments_12_0= ruleXExpression ) ) )* ) )? otherlv_13= ')' )? ( ( ( ruleXClosure ) )=> (lv_featureCallArguments_14_0= ruleXClosure ) )? ) ;
    public final EObject ruleXFeatureCall() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        Token lv_explicitOperationCall_8_0=null;
        Token otherlv_11=null;
        Token otherlv_13=null;
        EObject lv_typeArguments_3_0 = null;

        EObject lv_typeArguments_5_0 = null;

        EObject lv_featureCallArguments_9_0 = null;

        EObject lv_featureCallArguments_10_0 = null;

        EObject lv_featureCallArguments_12_0 = null;

        EObject lv_featureCallArguments_14_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3232:28: ( ( () ( ( ruleStaticQualifier ) )? (otherlv_2= '<' ( (lv_typeArguments_3_0= ruleJvmArgumentTypeReference ) ) (otherlv_4= ',' ( (lv_typeArguments_5_0= ruleJvmArgumentTypeReference ) ) )* otherlv_6= '>' )? ( ( ruleIdOrSuper ) ) ( ( ( ( '(' ) )=> (lv_explicitOperationCall_8_0= '(' ) ) ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> (lv_featureCallArguments_9_0= ruleXShortClosure ) ) | ( ( (lv_featureCallArguments_10_0= ruleXExpression ) ) (otherlv_11= ',' ( (lv_featureCallArguments_12_0= ruleXExpression ) ) )* ) )? otherlv_13= ')' )? ( ( ( ruleXClosure ) )=> (lv_featureCallArguments_14_0= ruleXClosure ) )? ) )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3233:1: ( () ( ( ruleStaticQualifier ) )? (otherlv_2= '<' ( (lv_typeArguments_3_0= ruleJvmArgumentTypeReference ) ) (otherlv_4= ',' ( (lv_typeArguments_5_0= ruleJvmArgumentTypeReference ) ) )* otherlv_6= '>' )? ( ( ruleIdOrSuper ) ) ( ( ( ( '(' ) )=> (lv_explicitOperationCall_8_0= '(' ) ) ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> (lv_featureCallArguments_9_0= ruleXShortClosure ) ) | ( ( (lv_featureCallArguments_10_0= ruleXExpression ) ) (otherlv_11= ',' ( (lv_featureCallArguments_12_0= ruleXExpression ) ) )* ) )? otherlv_13= ')' )? ( ( ( ruleXClosure ) )=> (lv_featureCallArguments_14_0= ruleXClosure ) )? )
            {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3233:1: ( () ( ( ruleStaticQualifier ) )? (otherlv_2= '<' ( (lv_typeArguments_3_0= ruleJvmArgumentTypeReference ) ) (otherlv_4= ',' ( (lv_typeArguments_5_0= ruleJvmArgumentTypeReference ) ) )* otherlv_6= '>' )? ( ( ruleIdOrSuper ) ) ( ( ( ( '(' ) )=> (lv_explicitOperationCall_8_0= '(' ) ) ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> (lv_featureCallArguments_9_0= ruleXShortClosure ) ) | ( ( (lv_featureCallArguments_10_0= ruleXExpression ) ) (otherlv_11= ',' ( (lv_featureCallArguments_12_0= ruleXExpression ) ) )* ) )? otherlv_13= ')' )? ( ( ( ruleXClosure ) )=> (lv_featureCallArguments_14_0= ruleXClosure ) )? )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3233:2: () ( ( ruleStaticQualifier ) )? (otherlv_2= '<' ( (lv_typeArguments_3_0= ruleJvmArgumentTypeReference ) ) (otherlv_4= ',' ( (lv_typeArguments_5_0= ruleJvmArgumentTypeReference ) ) )* otherlv_6= '>' )? ( ( ruleIdOrSuper ) ) ( ( ( ( '(' ) )=> (lv_explicitOperationCall_8_0= '(' ) ) ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> (lv_featureCallArguments_9_0= ruleXShortClosure ) ) | ( ( (lv_featureCallArguments_10_0= ruleXExpression ) ) (otherlv_11= ',' ( (lv_featureCallArguments_12_0= ruleXExpression ) ) )* ) )? otherlv_13= ')' )? ( ( ( ruleXClosure ) )=> (lv_featureCallArguments_14_0= ruleXClosure ) )?
            {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3233:2: ()
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3234:5: 
            {
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getXFeatureCallAccess().getXFeatureCallAction_0(),
                          current);
                  
            }

            }

            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3239:2: ( ( ruleStaticQualifier ) )?
            int alt52=2;
            int LA52_0 = input.LA(1);

            if ( (LA52_0==RULE_ID) ) {
                int LA52_1 = input.LA(2);

                if ( (LA52_1==58) ) {
                    alt52=1;
                }
            }
            switch (alt52) {
                case 1 :
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3240:1: ( ruleStaticQualifier )
                    {
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3240:1: ( ruleStaticQualifier )
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3241:3: ruleStaticQualifier
                    {
                    if ( state.backtracking==0 ) {

                      			if (current==null) {
                      	            current = createModelElement(grammarAccess.getXFeatureCallRule());
                      	        }
                              
                    }
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getXFeatureCallAccess().getDeclaringTypeJvmDeclaredTypeCrossReference_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleStaticQualifier_in_ruleXFeatureCall7618);
                    ruleStaticQualifier();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }
                    break;

            }

            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3254:3: (otherlv_2= '<' ( (lv_typeArguments_3_0= ruleJvmArgumentTypeReference ) ) (otherlv_4= ',' ( (lv_typeArguments_5_0= ruleJvmArgumentTypeReference ) ) )* otherlv_6= '>' )?
            int alt54=2;
            int LA54_0 = input.LA(1);

            if ( (LA54_0==24) ) {
                alt54=1;
            }
            switch (alt54) {
                case 1 :
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3254:5: otherlv_2= '<' ( (lv_typeArguments_3_0= ruleJvmArgumentTypeReference ) ) (otherlv_4= ',' ( (lv_typeArguments_5_0= ruleJvmArgumentTypeReference ) ) )* otherlv_6= '>'
                    {
                    otherlv_2=(Token)match(input,24,FOLLOW_24_in_ruleXFeatureCall7632); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_2, grammarAccess.getXFeatureCallAccess().getLessThanSignKeyword_2_0());
                          
                    }
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3258:1: ( (lv_typeArguments_3_0= ruleJvmArgumentTypeReference ) )
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3259:1: (lv_typeArguments_3_0= ruleJvmArgumentTypeReference )
                    {
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3259:1: (lv_typeArguments_3_0= ruleJvmArgumentTypeReference )
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3260:3: lv_typeArguments_3_0= ruleJvmArgumentTypeReference
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getXFeatureCallAccess().getTypeArgumentsJvmArgumentTypeReferenceParserRuleCall_2_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleJvmArgumentTypeReference_in_ruleXFeatureCall7653);
                    lv_typeArguments_3_0=ruleJvmArgumentTypeReference();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getXFeatureCallRule());
                      	        }
                             		add(
                             			current, 
                             			"typeArguments",
                              		lv_typeArguments_3_0, 
                              		"JvmArgumentTypeReference");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }

                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3276:2: (otherlv_4= ',' ( (lv_typeArguments_5_0= ruleJvmArgumentTypeReference ) ) )*
                    loop53:
                    do {
                        int alt53=2;
                        int LA53_0 = input.LA(1);

                        if ( (LA53_0==38) ) {
                            alt53=1;
                        }


                        switch (alt53) {
                    	case 1 :
                    	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3276:4: otherlv_4= ',' ( (lv_typeArguments_5_0= ruleJvmArgumentTypeReference ) )
                    	    {
                    	    otherlv_4=(Token)match(input,38,FOLLOW_38_in_ruleXFeatureCall7666); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	          	newLeafNode(otherlv_4, grammarAccess.getXFeatureCallAccess().getCommaKeyword_2_2_0());
                    	          
                    	    }
                    	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3280:1: ( (lv_typeArguments_5_0= ruleJvmArgumentTypeReference ) )
                    	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3281:1: (lv_typeArguments_5_0= ruleJvmArgumentTypeReference )
                    	    {
                    	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3281:1: (lv_typeArguments_5_0= ruleJvmArgumentTypeReference )
                    	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3282:3: lv_typeArguments_5_0= ruleJvmArgumentTypeReference
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getXFeatureCallAccess().getTypeArgumentsJvmArgumentTypeReferenceParserRuleCall_2_2_1_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FOLLOW_ruleJvmArgumentTypeReference_in_ruleXFeatureCall7687);
                    	    lv_typeArguments_5_0=ruleJvmArgumentTypeReference();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      	        if (current==null) {
                    	      	            current = createModelElementForParent(grammarAccess.getXFeatureCallRule());
                    	      	        }
                    	             		add(
                    	             			current, 
                    	             			"typeArguments",
                    	              		lv_typeArguments_5_0, 
                    	              		"JvmArgumentTypeReference");
                    	      	        afterParserOrEnumRuleCall();
                    	      	    
                    	    }

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop53;
                        }
                    } while (true);

                    otherlv_6=(Token)match(input,23,FOLLOW_23_in_ruleXFeatureCall7701); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_6, grammarAccess.getXFeatureCallAccess().getGreaterThanSignKeyword_2_3());
                          
                    }

                    }
                    break;

            }

            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3302:3: ( ( ruleIdOrSuper ) )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3303:1: ( ruleIdOrSuper )
            {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3303:1: ( ruleIdOrSuper )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3304:3: ruleIdOrSuper
            {
            if ( state.backtracking==0 ) {

              			if (current==null) {
              	            current = createModelElement(grammarAccess.getXFeatureCallRule());
              	        }
                      
            }
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getXFeatureCallAccess().getFeatureJvmIdentifiableElementCrossReference_3_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleIdOrSuper_in_ruleXFeatureCall7726);
            ruleIdOrSuper();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3317:2: ( ( ( ( '(' ) )=> (lv_explicitOperationCall_8_0= '(' ) ) ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> (lv_featureCallArguments_9_0= ruleXShortClosure ) ) | ( ( (lv_featureCallArguments_10_0= ruleXExpression ) ) (otherlv_11= ',' ( (lv_featureCallArguments_12_0= ruleXExpression ) ) )* ) )? otherlv_13= ')' )?
            int alt57=2;
            alt57 = dfa57.predict(input);
            switch (alt57) {
                case 1 :
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3317:3: ( ( ( '(' ) )=> (lv_explicitOperationCall_8_0= '(' ) ) ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> (lv_featureCallArguments_9_0= ruleXShortClosure ) ) | ( ( (lv_featureCallArguments_10_0= ruleXExpression ) ) (otherlv_11= ',' ( (lv_featureCallArguments_12_0= ruleXExpression ) ) )* ) )? otherlv_13= ')'
                    {
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3317:3: ( ( ( '(' ) )=> (lv_explicitOperationCall_8_0= '(' ) )
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3317:4: ( ( '(' ) )=> (lv_explicitOperationCall_8_0= '(' )
                    {
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3324:1: (lv_explicitOperationCall_8_0= '(' )
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3325:3: lv_explicitOperationCall_8_0= '('
                    {
                    lv_explicitOperationCall_8_0=(Token)match(input,39,FOLLOW_39_in_ruleXFeatureCall7760); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              newLeafNode(lv_explicitOperationCall_8_0, grammarAccess.getXFeatureCallAccess().getExplicitOperationCallLeftParenthesisKeyword_4_0_0());
                          
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getXFeatureCallRule());
                      	        }
                             		setWithLastConsumed(current, "explicitOperationCall", true, "(");
                      	    
                    }

                    }


                    }

                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3338:2: ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> (lv_featureCallArguments_9_0= ruleXShortClosure ) ) | ( ( (lv_featureCallArguments_10_0= ruleXExpression ) ) (otherlv_11= ',' ( (lv_featureCallArguments_12_0= ruleXExpression ) ) )* ) )?
                    int alt56=3;
                    alt56 = dfa56.predict(input);
                    switch (alt56) {
                        case 1 :
                            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3338:3: ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> (lv_featureCallArguments_9_0= ruleXShortClosure ) )
                            {
                            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3338:3: ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> (lv_featureCallArguments_9_0= ruleXShortClosure ) )
                            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3338:4: ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> (lv_featureCallArguments_9_0= ruleXShortClosure )
                            {
                            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3355:1: (lv_featureCallArguments_9_0= ruleXShortClosure )
                            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3356:3: lv_featureCallArguments_9_0= ruleXShortClosure
                            {
                            if ( state.backtracking==0 ) {
                               
                              	        newCompositeNode(grammarAccess.getXFeatureCallAccess().getFeatureCallArgumentsXShortClosureParserRuleCall_4_1_0_0()); 
                              	    
                            }
                            pushFollow(FOLLOW_ruleXShortClosure_in_ruleXFeatureCall7845);
                            lv_featureCallArguments_9_0=ruleXShortClosure();

                            state._fsp--;
                            if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              	        if (current==null) {
                              	            current = createModelElementForParent(grammarAccess.getXFeatureCallRule());
                              	        }
                                     		add(
                                     			current, 
                                     			"featureCallArguments",
                                      		lv_featureCallArguments_9_0, 
                                      		"XShortClosure");
                              	        afterParserOrEnumRuleCall();
                              	    
                            }

                            }


                            }


                            }
                            break;
                        case 2 :
                            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3373:6: ( ( (lv_featureCallArguments_10_0= ruleXExpression ) ) (otherlv_11= ',' ( (lv_featureCallArguments_12_0= ruleXExpression ) ) )* )
                            {
                            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3373:6: ( ( (lv_featureCallArguments_10_0= ruleXExpression ) ) (otherlv_11= ',' ( (lv_featureCallArguments_12_0= ruleXExpression ) ) )* )
                            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3373:7: ( (lv_featureCallArguments_10_0= ruleXExpression ) ) (otherlv_11= ',' ( (lv_featureCallArguments_12_0= ruleXExpression ) ) )*
                            {
                            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3373:7: ( (lv_featureCallArguments_10_0= ruleXExpression ) )
                            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3374:1: (lv_featureCallArguments_10_0= ruleXExpression )
                            {
                            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3374:1: (lv_featureCallArguments_10_0= ruleXExpression )
                            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3375:3: lv_featureCallArguments_10_0= ruleXExpression
                            {
                            if ( state.backtracking==0 ) {
                               
                              	        newCompositeNode(grammarAccess.getXFeatureCallAccess().getFeatureCallArgumentsXExpressionParserRuleCall_4_1_1_0_0()); 
                              	    
                            }
                            pushFollow(FOLLOW_ruleXExpression_in_ruleXFeatureCall7873);
                            lv_featureCallArguments_10_0=ruleXExpression();

                            state._fsp--;
                            if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              	        if (current==null) {
                              	            current = createModelElementForParent(grammarAccess.getXFeatureCallRule());
                              	        }
                                     		add(
                                     			current, 
                                     			"featureCallArguments",
                                      		lv_featureCallArguments_10_0, 
                                      		"XExpression");
                              	        afterParserOrEnumRuleCall();
                              	    
                            }

                            }


                            }

                            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3391:2: (otherlv_11= ',' ( (lv_featureCallArguments_12_0= ruleXExpression ) ) )*
                            loop55:
                            do {
                                int alt55=2;
                                int LA55_0 = input.LA(1);

                                if ( (LA55_0==38) ) {
                                    alt55=1;
                                }


                                switch (alt55) {
                            	case 1 :
                            	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3391:4: otherlv_11= ',' ( (lv_featureCallArguments_12_0= ruleXExpression ) )
                            	    {
                            	    otherlv_11=(Token)match(input,38,FOLLOW_38_in_ruleXFeatureCall7886); if (state.failed) return current;
                            	    if ( state.backtracking==0 ) {

                            	          	newLeafNode(otherlv_11, grammarAccess.getXFeatureCallAccess().getCommaKeyword_4_1_1_1_0());
                            	          
                            	    }
                            	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3395:1: ( (lv_featureCallArguments_12_0= ruleXExpression ) )
                            	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3396:1: (lv_featureCallArguments_12_0= ruleXExpression )
                            	    {
                            	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3396:1: (lv_featureCallArguments_12_0= ruleXExpression )
                            	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3397:3: lv_featureCallArguments_12_0= ruleXExpression
                            	    {
                            	    if ( state.backtracking==0 ) {
                            	       
                            	      	        newCompositeNode(grammarAccess.getXFeatureCallAccess().getFeatureCallArgumentsXExpressionParserRuleCall_4_1_1_1_1_0()); 
                            	      	    
                            	    }
                            	    pushFollow(FOLLOW_ruleXExpression_in_ruleXFeatureCall7907);
                            	    lv_featureCallArguments_12_0=ruleXExpression();

                            	    state._fsp--;
                            	    if (state.failed) return current;
                            	    if ( state.backtracking==0 ) {

                            	      	        if (current==null) {
                            	      	            current = createModelElementForParent(grammarAccess.getXFeatureCallRule());
                            	      	        }
                            	             		add(
                            	             			current, 
                            	             			"featureCallArguments",
                            	              		lv_featureCallArguments_12_0, 
                            	              		"XExpression");
                            	      	        afterParserOrEnumRuleCall();
                            	      	    
                            	    }

                            	    }


                            	    }


                            	    }
                            	    break;

                            	default :
                            	    break loop55;
                                }
                            } while (true);


                            }


                            }
                            break;

                    }

                    otherlv_13=(Token)match(input,40,FOLLOW_40_in_ruleXFeatureCall7924); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_13, grammarAccess.getXFeatureCallAccess().getRightParenthesisKeyword_4_2());
                          
                    }

                    }
                    break;

            }

            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3417:3: ( ( ( ruleXClosure ) )=> (lv_featureCallArguments_14_0= ruleXClosure ) )?
            int alt58=2;
            alt58 = dfa58.predict(input);
            switch (alt58) {
                case 1 :
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3417:4: ( ( ruleXClosure ) )=> (lv_featureCallArguments_14_0= ruleXClosure )
                    {
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3422:1: (lv_featureCallArguments_14_0= ruleXClosure )
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3423:3: lv_featureCallArguments_14_0= ruleXClosure
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getXFeatureCallAccess().getFeatureCallArgumentsXClosureParserRuleCall_5_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleXClosure_in_ruleXFeatureCall7957);
                    lv_featureCallArguments_14_0=ruleXClosure();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getXFeatureCallRule());
                      	        }
                             		add(
                             			current, 
                             			"featureCallArguments",
                              		lv_featureCallArguments_14_0, 
                              		"XClosure");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }
                    break;

            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleXFeatureCall"


    // $ANTLR start "entryRuleIdOrSuper"
    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3447:1: entryRuleIdOrSuper returns [String current=null] : iv_ruleIdOrSuper= ruleIdOrSuper EOF ;
    public final String entryRuleIdOrSuper() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleIdOrSuper = null;


        try {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3448:2: (iv_ruleIdOrSuper= ruleIdOrSuper EOF )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3449:2: iv_ruleIdOrSuper= ruleIdOrSuper EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getIdOrSuperRule()); 
            }
            pushFollow(FOLLOW_ruleIdOrSuper_in_entryRuleIdOrSuper7995);
            iv_ruleIdOrSuper=ruleIdOrSuper();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleIdOrSuper.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleIdOrSuper8006); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleIdOrSuper"


    // $ANTLR start "ruleIdOrSuper"
    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3456:1: ruleIdOrSuper returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_ValidID_0= ruleValidID | kw= 'super' ) ;
    public final AntlrDatatypeRuleToken ruleIdOrSuper() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        AntlrDatatypeRuleToken this_ValidID_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3459:28: ( (this_ValidID_0= ruleValidID | kw= 'super' ) )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3460:1: (this_ValidID_0= ruleValidID | kw= 'super' )
            {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3460:1: (this_ValidID_0= ruleValidID | kw= 'super' )
            int alt59=2;
            int LA59_0 = input.LA(1);

            if ( (LA59_0==RULE_ID) ) {
                alt59=1;
            }
            else if ( (LA59_0==57) ) {
                alt59=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 59, 0, input);

                throw nvae;
            }
            switch (alt59) {
                case 1 :
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3461:5: this_ValidID_0= ruleValidID
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getIdOrSuperAccess().getValidIDParserRuleCall_0()); 
                          
                    }
                    pushFollow(FOLLOW_ruleValidID_in_ruleIdOrSuper8053);
                    this_ValidID_0=ruleValidID();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      		current.merge(this_ValidID_0);
                          
                    }
                    if ( state.backtracking==0 ) {
                       
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3473:2: kw= 'super'
                    {
                    kw=(Token)match(input,57,FOLLOW_57_in_ruleIdOrSuper8077); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getIdOrSuperAccess().getSuperKeyword_1()); 
                          
                    }

                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleIdOrSuper"


    // $ANTLR start "entryRuleStaticQualifier"
    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3486:1: entryRuleStaticQualifier returns [String current=null] : iv_ruleStaticQualifier= ruleStaticQualifier EOF ;
    public final String entryRuleStaticQualifier() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleStaticQualifier = null;


        try {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3487:2: (iv_ruleStaticQualifier= ruleStaticQualifier EOF )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3488:2: iv_ruleStaticQualifier= ruleStaticQualifier EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getStaticQualifierRule()); 
            }
            pushFollow(FOLLOW_ruleStaticQualifier_in_entryRuleStaticQualifier8118);
            iv_ruleStaticQualifier=ruleStaticQualifier();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleStaticQualifier.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleStaticQualifier8129); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleStaticQualifier"


    // $ANTLR start "ruleStaticQualifier"
    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3495:1: ruleStaticQualifier returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_ValidID_0= ruleValidID kw= '::' )+ ;
    public final AntlrDatatypeRuleToken ruleStaticQualifier() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        AntlrDatatypeRuleToken this_ValidID_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3498:28: ( (this_ValidID_0= ruleValidID kw= '::' )+ )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3499:1: (this_ValidID_0= ruleValidID kw= '::' )+
            {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3499:1: (this_ValidID_0= ruleValidID kw= '::' )+
            int cnt60=0;
            loop60:
            do {
                int alt60=2;
                int LA60_0 = input.LA(1);

                if ( (LA60_0==RULE_ID) ) {
                    int LA60_2 = input.LA(2);

                    if ( (LA60_2==58) ) {
                        alt60=1;
                    }


                }


                switch (alt60) {
            	case 1 :
            	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3500:5: this_ValidID_0= ruleValidID kw= '::'
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	              newCompositeNode(grammarAccess.getStaticQualifierAccess().getValidIDParserRuleCall_0()); 
            	          
            	    }
            	    pushFollow(FOLLOW_ruleValidID_in_ruleStaticQualifier8176);
            	    this_ValidID_0=ruleValidID();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      		current.merge(this_ValidID_0);
            	          
            	    }
            	    if ( state.backtracking==0 ) {
            	       
            	              afterParserOrEnumRuleCall();
            	          
            	    }
            	    kw=(Token)match(input,58,FOLLOW_58_in_ruleStaticQualifier8194); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	              current.merge(kw);
            	              newLeafNode(kw, grammarAccess.getStaticQualifierAccess().getColonColonKeyword_1()); 
            	          
            	    }

            	    }
            	    break;

            	default :
            	    if ( cnt60 >= 1 ) break loop60;
            	    if (state.backtracking>0) {state.failed=true; return current;}
                        EarlyExitException eee =
                            new EarlyExitException(60, input);
                        throw eee;
                }
                cnt60++;
            } while (true);


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleStaticQualifier"


    // $ANTLR start "entryRuleXConstructorCall"
    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3524:1: entryRuleXConstructorCall returns [EObject current=null] : iv_ruleXConstructorCall= ruleXConstructorCall EOF ;
    public final EObject entryRuleXConstructorCall() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXConstructorCall = null;


        try {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3525:2: (iv_ruleXConstructorCall= ruleXConstructorCall EOF )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3526:2: iv_ruleXConstructorCall= ruleXConstructorCall EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXConstructorCallRule()); 
            }
            pushFollow(FOLLOW_ruleXConstructorCall_in_entryRuleXConstructorCall8235);
            iv_ruleXConstructorCall=ruleXConstructorCall();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXConstructorCall; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXConstructorCall8245); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleXConstructorCall"


    // $ANTLR start "ruleXConstructorCall"
    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3533:1: ruleXConstructorCall returns [EObject current=null] : ( () otherlv_1= 'new' ( ( ruleQualifiedName ) ) (otherlv_3= '<' ( (lv_typeArguments_4_0= ruleJvmArgumentTypeReference ) ) (otherlv_5= ',' ( (lv_typeArguments_6_0= ruleJvmArgumentTypeReference ) ) )* otherlv_7= '>' )? otherlv_8= '(' ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> (lv_arguments_9_0= ruleXShortClosure ) ) | ( ( (lv_arguments_10_0= ruleXExpression ) ) (otherlv_11= ',' ( (lv_arguments_12_0= ruleXExpression ) ) )* ) )? otherlv_13= ')' ( ( ( ruleXClosure ) )=> (lv_arguments_14_0= ruleXClosure ) )? ) ;
    public final EObject ruleXConstructorCall() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        Token otherlv_8=null;
        Token otherlv_11=null;
        Token otherlv_13=null;
        EObject lv_typeArguments_4_0 = null;

        EObject lv_typeArguments_6_0 = null;

        EObject lv_arguments_9_0 = null;

        EObject lv_arguments_10_0 = null;

        EObject lv_arguments_12_0 = null;

        EObject lv_arguments_14_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3536:28: ( ( () otherlv_1= 'new' ( ( ruleQualifiedName ) ) (otherlv_3= '<' ( (lv_typeArguments_4_0= ruleJvmArgumentTypeReference ) ) (otherlv_5= ',' ( (lv_typeArguments_6_0= ruleJvmArgumentTypeReference ) ) )* otherlv_7= '>' )? otherlv_8= '(' ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> (lv_arguments_9_0= ruleXShortClosure ) ) | ( ( (lv_arguments_10_0= ruleXExpression ) ) (otherlv_11= ',' ( (lv_arguments_12_0= ruleXExpression ) ) )* ) )? otherlv_13= ')' ( ( ( ruleXClosure ) )=> (lv_arguments_14_0= ruleXClosure ) )? ) )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3537:1: ( () otherlv_1= 'new' ( ( ruleQualifiedName ) ) (otherlv_3= '<' ( (lv_typeArguments_4_0= ruleJvmArgumentTypeReference ) ) (otherlv_5= ',' ( (lv_typeArguments_6_0= ruleJvmArgumentTypeReference ) ) )* otherlv_7= '>' )? otherlv_8= '(' ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> (lv_arguments_9_0= ruleXShortClosure ) ) | ( ( (lv_arguments_10_0= ruleXExpression ) ) (otherlv_11= ',' ( (lv_arguments_12_0= ruleXExpression ) ) )* ) )? otherlv_13= ')' ( ( ( ruleXClosure ) )=> (lv_arguments_14_0= ruleXClosure ) )? )
            {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3537:1: ( () otherlv_1= 'new' ( ( ruleQualifiedName ) ) (otherlv_3= '<' ( (lv_typeArguments_4_0= ruleJvmArgumentTypeReference ) ) (otherlv_5= ',' ( (lv_typeArguments_6_0= ruleJvmArgumentTypeReference ) ) )* otherlv_7= '>' )? otherlv_8= '(' ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> (lv_arguments_9_0= ruleXShortClosure ) ) | ( ( (lv_arguments_10_0= ruleXExpression ) ) (otherlv_11= ',' ( (lv_arguments_12_0= ruleXExpression ) ) )* ) )? otherlv_13= ')' ( ( ( ruleXClosure ) )=> (lv_arguments_14_0= ruleXClosure ) )? )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3537:2: () otherlv_1= 'new' ( ( ruleQualifiedName ) ) (otherlv_3= '<' ( (lv_typeArguments_4_0= ruleJvmArgumentTypeReference ) ) (otherlv_5= ',' ( (lv_typeArguments_6_0= ruleJvmArgumentTypeReference ) ) )* otherlv_7= '>' )? otherlv_8= '(' ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> (lv_arguments_9_0= ruleXShortClosure ) ) | ( ( (lv_arguments_10_0= ruleXExpression ) ) (otherlv_11= ',' ( (lv_arguments_12_0= ruleXExpression ) ) )* ) )? otherlv_13= ')' ( ( ( ruleXClosure ) )=> (lv_arguments_14_0= ruleXClosure ) )?
            {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3537:2: ()
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3538:5: 
            {
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getXConstructorCallAccess().getXConstructorCallAction_0(),
                          current);
                  
            }

            }

            otherlv_1=(Token)match(input,59,FOLLOW_59_in_ruleXConstructorCall8291); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getXConstructorCallAccess().getNewKeyword_1());
                  
            }
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3547:1: ( ( ruleQualifiedName ) )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3548:1: ( ruleQualifiedName )
            {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3548:1: ( ruleQualifiedName )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3549:3: ruleQualifiedName
            {
            if ( state.backtracking==0 ) {

              			if (current==null) {
              	            current = createModelElement(grammarAccess.getXConstructorCallRule());
              	        }
                      
            }
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getXConstructorCallAccess().getConstructorJvmConstructorCrossReference_2_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleQualifiedName_in_ruleXConstructorCall8314);
            ruleQualifiedName();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3562:2: (otherlv_3= '<' ( (lv_typeArguments_4_0= ruleJvmArgumentTypeReference ) ) (otherlv_5= ',' ( (lv_typeArguments_6_0= ruleJvmArgumentTypeReference ) ) )* otherlv_7= '>' )?
            int alt62=2;
            int LA62_0 = input.LA(1);

            if ( (LA62_0==24) ) {
                alt62=1;
            }
            switch (alt62) {
                case 1 :
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3562:4: otherlv_3= '<' ( (lv_typeArguments_4_0= ruleJvmArgumentTypeReference ) ) (otherlv_5= ',' ( (lv_typeArguments_6_0= ruleJvmArgumentTypeReference ) ) )* otherlv_7= '>'
                    {
                    otherlv_3=(Token)match(input,24,FOLLOW_24_in_ruleXConstructorCall8327); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_3, grammarAccess.getXConstructorCallAccess().getLessThanSignKeyword_3_0());
                          
                    }
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3566:1: ( (lv_typeArguments_4_0= ruleJvmArgumentTypeReference ) )
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3567:1: (lv_typeArguments_4_0= ruleJvmArgumentTypeReference )
                    {
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3567:1: (lv_typeArguments_4_0= ruleJvmArgumentTypeReference )
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3568:3: lv_typeArguments_4_0= ruleJvmArgumentTypeReference
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getXConstructorCallAccess().getTypeArgumentsJvmArgumentTypeReferenceParserRuleCall_3_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleJvmArgumentTypeReference_in_ruleXConstructorCall8348);
                    lv_typeArguments_4_0=ruleJvmArgumentTypeReference();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getXConstructorCallRule());
                      	        }
                             		add(
                             			current, 
                             			"typeArguments",
                              		lv_typeArguments_4_0, 
                              		"JvmArgumentTypeReference");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }

                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3584:2: (otherlv_5= ',' ( (lv_typeArguments_6_0= ruleJvmArgumentTypeReference ) ) )*
                    loop61:
                    do {
                        int alt61=2;
                        int LA61_0 = input.LA(1);

                        if ( (LA61_0==38) ) {
                            alt61=1;
                        }


                        switch (alt61) {
                    	case 1 :
                    	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3584:4: otherlv_5= ',' ( (lv_typeArguments_6_0= ruleJvmArgumentTypeReference ) )
                    	    {
                    	    otherlv_5=(Token)match(input,38,FOLLOW_38_in_ruleXConstructorCall8361); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	          	newLeafNode(otherlv_5, grammarAccess.getXConstructorCallAccess().getCommaKeyword_3_2_0());
                    	          
                    	    }
                    	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3588:1: ( (lv_typeArguments_6_0= ruleJvmArgumentTypeReference ) )
                    	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3589:1: (lv_typeArguments_6_0= ruleJvmArgumentTypeReference )
                    	    {
                    	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3589:1: (lv_typeArguments_6_0= ruleJvmArgumentTypeReference )
                    	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3590:3: lv_typeArguments_6_0= ruleJvmArgumentTypeReference
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getXConstructorCallAccess().getTypeArgumentsJvmArgumentTypeReferenceParserRuleCall_3_2_1_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FOLLOW_ruleJvmArgumentTypeReference_in_ruleXConstructorCall8382);
                    	    lv_typeArguments_6_0=ruleJvmArgumentTypeReference();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      	        if (current==null) {
                    	      	            current = createModelElementForParent(grammarAccess.getXConstructorCallRule());
                    	      	        }
                    	             		add(
                    	             			current, 
                    	             			"typeArguments",
                    	              		lv_typeArguments_6_0, 
                    	              		"JvmArgumentTypeReference");
                    	      	        afterParserOrEnumRuleCall();
                    	      	    
                    	    }

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop61;
                        }
                    } while (true);

                    otherlv_7=(Token)match(input,23,FOLLOW_23_in_ruleXConstructorCall8396); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_7, grammarAccess.getXConstructorCallAccess().getGreaterThanSignKeyword_3_3());
                          
                    }

                    }
                    break;

            }

            otherlv_8=(Token)match(input,39,FOLLOW_39_in_ruleXConstructorCall8410); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_8, grammarAccess.getXConstructorCallAccess().getLeftParenthesisKeyword_4());
                  
            }
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3614:1: ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> (lv_arguments_9_0= ruleXShortClosure ) ) | ( ( (lv_arguments_10_0= ruleXExpression ) ) (otherlv_11= ',' ( (lv_arguments_12_0= ruleXExpression ) ) )* ) )?
            int alt64=3;
            alt64 = dfa64.predict(input);
            switch (alt64) {
                case 1 :
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3614:2: ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> (lv_arguments_9_0= ruleXShortClosure ) )
                    {
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3614:2: ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> (lv_arguments_9_0= ruleXShortClosure ) )
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3614:3: ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> (lv_arguments_9_0= ruleXShortClosure )
                    {
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3631:1: (lv_arguments_9_0= ruleXShortClosure )
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3632:3: lv_arguments_9_0= ruleXShortClosure
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getXConstructorCallAccess().getArgumentsXShortClosureParserRuleCall_5_0_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleXShortClosure_in_ruleXConstructorCall8482);
                    lv_arguments_9_0=ruleXShortClosure();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getXConstructorCallRule());
                      	        }
                             		add(
                             			current, 
                             			"arguments",
                              		lv_arguments_9_0, 
                              		"XShortClosure");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3649:6: ( ( (lv_arguments_10_0= ruleXExpression ) ) (otherlv_11= ',' ( (lv_arguments_12_0= ruleXExpression ) ) )* )
                    {
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3649:6: ( ( (lv_arguments_10_0= ruleXExpression ) ) (otherlv_11= ',' ( (lv_arguments_12_0= ruleXExpression ) ) )* )
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3649:7: ( (lv_arguments_10_0= ruleXExpression ) ) (otherlv_11= ',' ( (lv_arguments_12_0= ruleXExpression ) ) )*
                    {
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3649:7: ( (lv_arguments_10_0= ruleXExpression ) )
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3650:1: (lv_arguments_10_0= ruleXExpression )
                    {
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3650:1: (lv_arguments_10_0= ruleXExpression )
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3651:3: lv_arguments_10_0= ruleXExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getXConstructorCallAccess().getArgumentsXExpressionParserRuleCall_5_1_0_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleXExpression_in_ruleXConstructorCall8510);
                    lv_arguments_10_0=ruleXExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getXConstructorCallRule());
                      	        }
                             		add(
                             			current, 
                             			"arguments",
                              		lv_arguments_10_0, 
                              		"XExpression");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }

                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3667:2: (otherlv_11= ',' ( (lv_arguments_12_0= ruleXExpression ) ) )*
                    loop63:
                    do {
                        int alt63=2;
                        int LA63_0 = input.LA(1);

                        if ( (LA63_0==38) ) {
                            alt63=1;
                        }


                        switch (alt63) {
                    	case 1 :
                    	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3667:4: otherlv_11= ',' ( (lv_arguments_12_0= ruleXExpression ) )
                    	    {
                    	    otherlv_11=(Token)match(input,38,FOLLOW_38_in_ruleXConstructorCall8523); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	          	newLeafNode(otherlv_11, grammarAccess.getXConstructorCallAccess().getCommaKeyword_5_1_1_0());
                    	          
                    	    }
                    	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3671:1: ( (lv_arguments_12_0= ruleXExpression ) )
                    	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3672:1: (lv_arguments_12_0= ruleXExpression )
                    	    {
                    	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3672:1: (lv_arguments_12_0= ruleXExpression )
                    	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3673:3: lv_arguments_12_0= ruleXExpression
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getXConstructorCallAccess().getArgumentsXExpressionParserRuleCall_5_1_1_1_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FOLLOW_ruleXExpression_in_ruleXConstructorCall8544);
                    	    lv_arguments_12_0=ruleXExpression();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      	        if (current==null) {
                    	      	            current = createModelElementForParent(grammarAccess.getXConstructorCallRule());
                    	      	        }
                    	             		add(
                    	             			current, 
                    	             			"arguments",
                    	              		lv_arguments_12_0, 
                    	              		"XExpression");
                    	      	        afterParserOrEnumRuleCall();
                    	      	    
                    	    }

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop63;
                        }
                    } while (true);


                    }


                    }
                    break;

            }

            otherlv_13=(Token)match(input,40,FOLLOW_40_in_ruleXConstructorCall8561); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_13, grammarAccess.getXConstructorCallAccess().getRightParenthesisKeyword_6());
                  
            }
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3693:1: ( ( ( ruleXClosure ) )=> (lv_arguments_14_0= ruleXClosure ) )?
            int alt65=2;
            alt65 = dfa65.predict(input);
            switch (alt65) {
                case 1 :
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3693:2: ( ( ruleXClosure ) )=> (lv_arguments_14_0= ruleXClosure )
                    {
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3698:1: (lv_arguments_14_0= ruleXClosure )
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3699:3: lv_arguments_14_0= ruleXClosure
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getXConstructorCallAccess().getArgumentsXClosureParserRuleCall_7_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleXClosure_in_ruleXConstructorCall8592);
                    lv_arguments_14_0=ruleXClosure();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getXConstructorCallRule());
                      	        }
                             		add(
                             			current, 
                             			"arguments",
                              		lv_arguments_14_0, 
                              		"XClosure");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }
                    break;

            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleXConstructorCall"


    // $ANTLR start "entryRuleXBooleanLiteral"
    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3723:1: entryRuleXBooleanLiteral returns [EObject current=null] : iv_ruleXBooleanLiteral= ruleXBooleanLiteral EOF ;
    public final EObject entryRuleXBooleanLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXBooleanLiteral = null;


        try {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3724:2: (iv_ruleXBooleanLiteral= ruleXBooleanLiteral EOF )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3725:2: iv_ruleXBooleanLiteral= ruleXBooleanLiteral EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXBooleanLiteralRule()); 
            }
            pushFollow(FOLLOW_ruleXBooleanLiteral_in_entryRuleXBooleanLiteral8629);
            iv_ruleXBooleanLiteral=ruleXBooleanLiteral();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXBooleanLiteral; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXBooleanLiteral8639); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleXBooleanLiteral"


    // $ANTLR start "ruleXBooleanLiteral"
    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3732:1: ruleXBooleanLiteral returns [EObject current=null] : ( () (otherlv_1= 'false' | ( (lv_isTrue_2_0= 'true' ) ) ) ) ;
    public final EObject ruleXBooleanLiteral() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token lv_isTrue_2_0=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3735:28: ( ( () (otherlv_1= 'false' | ( (lv_isTrue_2_0= 'true' ) ) ) ) )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3736:1: ( () (otherlv_1= 'false' | ( (lv_isTrue_2_0= 'true' ) ) ) )
            {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3736:1: ( () (otherlv_1= 'false' | ( (lv_isTrue_2_0= 'true' ) ) ) )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3736:2: () (otherlv_1= 'false' | ( (lv_isTrue_2_0= 'true' ) ) )
            {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3736:2: ()
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3737:5: 
            {
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getXBooleanLiteralAccess().getXBooleanLiteralAction_0(),
                          current);
                  
            }

            }

            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3742:2: (otherlv_1= 'false' | ( (lv_isTrue_2_0= 'true' ) ) )
            int alt66=2;
            int LA66_0 = input.LA(1);

            if ( (LA66_0==60) ) {
                alt66=1;
            }
            else if ( (LA66_0==61) ) {
                alt66=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 66, 0, input);

                throw nvae;
            }
            switch (alt66) {
                case 1 :
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3742:4: otherlv_1= 'false'
                    {
                    otherlv_1=(Token)match(input,60,FOLLOW_60_in_ruleXBooleanLiteral8686); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_1, grammarAccess.getXBooleanLiteralAccess().getFalseKeyword_1_0());
                          
                    }

                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3747:6: ( (lv_isTrue_2_0= 'true' ) )
                    {
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3747:6: ( (lv_isTrue_2_0= 'true' ) )
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3748:1: (lv_isTrue_2_0= 'true' )
                    {
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3748:1: (lv_isTrue_2_0= 'true' )
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3749:3: lv_isTrue_2_0= 'true'
                    {
                    lv_isTrue_2_0=(Token)match(input,61,FOLLOW_61_in_ruleXBooleanLiteral8710); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              newLeafNode(lv_isTrue_2_0, grammarAccess.getXBooleanLiteralAccess().getIsTrueTrueKeyword_1_1_0());
                          
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getXBooleanLiteralRule());
                      	        }
                             		setWithLastConsumed(current, "isTrue", true, "true");
                      	    
                    }

                    }


                    }


                    }
                    break;

            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleXBooleanLiteral"


    // $ANTLR start "entryRuleXNullLiteral"
    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3770:1: entryRuleXNullLiteral returns [EObject current=null] : iv_ruleXNullLiteral= ruleXNullLiteral EOF ;
    public final EObject entryRuleXNullLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXNullLiteral = null;


        try {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3771:2: (iv_ruleXNullLiteral= ruleXNullLiteral EOF )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3772:2: iv_ruleXNullLiteral= ruleXNullLiteral EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXNullLiteralRule()); 
            }
            pushFollow(FOLLOW_ruleXNullLiteral_in_entryRuleXNullLiteral8760);
            iv_ruleXNullLiteral=ruleXNullLiteral();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXNullLiteral; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXNullLiteral8770); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleXNullLiteral"


    // $ANTLR start "ruleXNullLiteral"
    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3779:1: ruleXNullLiteral returns [EObject current=null] : ( () otherlv_1= 'null' ) ;
    public final EObject ruleXNullLiteral() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3782:28: ( ( () otherlv_1= 'null' ) )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3783:1: ( () otherlv_1= 'null' )
            {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3783:1: ( () otherlv_1= 'null' )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3783:2: () otherlv_1= 'null'
            {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3783:2: ()
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3784:5: 
            {
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getXNullLiteralAccess().getXNullLiteralAction_0(),
                          current);
                  
            }

            }

            otherlv_1=(Token)match(input,62,FOLLOW_62_in_ruleXNullLiteral8816); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getXNullLiteralAccess().getNullKeyword_1());
                  
            }

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleXNullLiteral"


    // $ANTLR start "entryRuleXIntLiteral"
    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3801:1: entryRuleXIntLiteral returns [EObject current=null] : iv_ruleXIntLiteral= ruleXIntLiteral EOF ;
    public final EObject entryRuleXIntLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXIntLiteral = null;


        try {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3802:2: (iv_ruleXIntLiteral= ruleXIntLiteral EOF )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3803:2: iv_ruleXIntLiteral= ruleXIntLiteral EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXIntLiteralRule()); 
            }
            pushFollow(FOLLOW_ruleXIntLiteral_in_entryRuleXIntLiteral8852);
            iv_ruleXIntLiteral=ruleXIntLiteral();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXIntLiteral; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXIntLiteral8862); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleXIntLiteral"


    // $ANTLR start "ruleXIntLiteral"
    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3810:1: ruleXIntLiteral returns [EObject current=null] : ( () ( (lv_value_1_0= RULE_INT ) ) ) ;
    public final EObject ruleXIntLiteral() throws RecognitionException {
        EObject current = null;

        Token lv_value_1_0=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3813:28: ( ( () ( (lv_value_1_0= RULE_INT ) ) ) )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3814:1: ( () ( (lv_value_1_0= RULE_INT ) ) )
            {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3814:1: ( () ( (lv_value_1_0= RULE_INT ) ) )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3814:2: () ( (lv_value_1_0= RULE_INT ) )
            {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3814:2: ()
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3815:5: 
            {
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getXIntLiteralAccess().getXIntLiteralAction_0(),
                          current);
                  
            }

            }

            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3820:2: ( (lv_value_1_0= RULE_INT ) )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3821:1: (lv_value_1_0= RULE_INT )
            {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3821:1: (lv_value_1_0= RULE_INT )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3822:3: lv_value_1_0= RULE_INT
            {
            lv_value_1_0=(Token)match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleXIntLiteral8913); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(lv_value_1_0, grammarAccess.getXIntLiteralAccess().getValueINTTerminalRuleCall_1_0()); 
              		
            }
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElement(grammarAccess.getXIntLiteralRule());
              	        }
                     		setWithLastConsumed(
                     			current, 
                     			"value",
                      		lv_value_1_0, 
                      		"INT");
              	    
            }

            }


            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleXIntLiteral"


    // $ANTLR start "entryRuleXStringLiteral"
    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3846:1: entryRuleXStringLiteral returns [EObject current=null] : iv_ruleXStringLiteral= ruleXStringLiteral EOF ;
    public final EObject entryRuleXStringLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXStringLiteral = null;


        try {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3847:2: (iv_ruleXStringLiteral= ruleXStringLiteral EOF )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3848:2: iv_ruleXStringLiteral= ruleXStringLiteral EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXStringLiteralRule()); 
            }
            pushFollow(FOLLOW_ruleXStringLiteral_in_entryRuleXStringLiteral8954);
            iv_ruleXStringLiteral=ruleXStringLiteral();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXStringLiteral; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXStringLiteral8964); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleXStringLiteral"


    // $ANTLR start "ruleXStringLiteral"
    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3855:1: ruleXStringLiteral returns [EObject current=null] : ( () ( (lv_value_1_0= RULE_STRING ) ) ) ;
    public final EObject ruleXStringLiteral() throws RecognitionException {
        EObject current = null;

        Token lv_value_1_0=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3858:28: ( ( () ( (lv_value_1_0= RULE_STRING ) ) ) )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3859:1: ( () ( (lv_value_1_0= RULE_STRING ) ) )
            {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3859:1: ( () ( (lv_value_1_0= RULE_STRING ) ) )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3859:2: () ( (lv_value_1_0= RULE_STRING ) )
            {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3859:2: ()
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3860:5: 
            {
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getXStringLiteralAccess().getXStringLiteralAction_0(),
                          current);
                  
            }

            }

            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3865:2: ( (lv_value_1_0= RULE_STRING ) )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3866:1: (lv_value_1_0= RULE_STRING )
            {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3866:1: (lv_value_1_0= RULE_STRING )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3867:3: lv_value_1_0= RULE_STRING
            {
            lv_value_1_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleXStringLiteral9015); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(lv_value_1_0, grammarAccess.getXStringLiteralAccess().getValueSTRINGTerminalRuleCall_1_0()); 
              		
            }
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElement(grammarAccess.getXStringLiteralRule());
              	        }
                     		setWithLastConsumed(
                     			current, 
                     			"value",
                      		lv_value_1_0, 
                      		"STRING");
              	    
            }

            }


            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleXStringLiteral"


    // $ANTLR start "entryRuleXTypeLiteral"
    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3891:1: entryRuleXTypeLiteral returns [EObject current=null] : iv_ruleXTypeLiteral= ruleXTypeLiteral EOF ;
    public final EObject entryRuleXTypeLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXTypeLiteral = null;


        try {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3892:2: (iv_ruleXTypeLiteral= ruleXTypeLiteral EOF )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3893:2: iv_ruleXTypeLiteral= ruleXTypeLiteral EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXTypeLiteralRule()); 
            }
            pushFollow(FOLLOW_ruleXTypeLiteral_in_entryRuleXTypeLiteral9056);
            iv_ruleXTypeLiteral=ruleXTypeLiteral();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXTypeLiteral; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXTypeLiteral9066); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleXTypeLiteral"


    // $ANTLR start "ruleXTypeLiteral"
    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3900:1: ruleXTypeLiteral returns [EObject current=null] : ( () otherlv_1= 'typeof' otherlv_2= '(' ( ( ruleQualifiedName ) ) otherlv_4= ')' ) ;
    public final EObject ruleXTypeLiteral() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_4=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3903:28: ( ( () otherlv_1= 'typeof' otherlv_2= '(' ( ( ruleQualifiedName ) ) otherlv_4= ')' ) )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3904:1: ( () otherlv_1= 'typeof' otherlv_2= '(' ( ( ruleQualifiedName ) ) otherlv_4= ')' )
            {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3904:1: ( () otherlv_1= 'typeof' otherlv_2= '(' ( ( ruleQualifiedName ) ) otherlv_4= ')' )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3904:2: () otherlv_1= 'typeof' otherlv_2= '(' ( ( ruleQualifiedName ) ) otherlv_4= ')'
            {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3904:2: ()
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3905:5: 
            {
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getXTypeLiteralAccess().getXTypeLiteralAction_0(),
                          current);
                  
            }

            }

            otherlv_1=(Token)match(input,63,FOLLOW_63_in_ruleXTypeLiteral9112); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getXTypeLiteralAccess().getTypeofKeyword_1());
                  
            }
            otherlv_2=(Token)match(input,39,FOLLOW_39_in_ruleXTypeLiteral9124); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_2, grammarAccess.getXTypeLiteralAccess().getLeftParenthesisKeyword_2());
                  
            }
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3918:1: ( ( ruleQualifiedName ) )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3919:1: ( ruleQualifiedName )
            {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3919:1: ( ruleQualifiedName )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3920:3: ruleQualifiedName
            {
            if ( state.backtracking==0 ) {

              			if (current==null) {
              	            current = createModelElement(grammarAccess.getXTypeLiteralRule());
              	        }
                      
            }
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getXTypeLiteralAccess().getTypeJvmTypeCrossReference_3_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleQualifiedName_in_ruleXTypeLiteral9147);
            ruleQualifiedName();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            otherlv_4=(Token)match(input,40,FOLLOW_40_in_ruleXTypeLiteral9159); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_4, grammarAccess.getXTypeLiteralAccess().getRightParenthesisKeyword_4());
                  
            }

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleXTypeLiteral"


    // $ANTLR start "entryRuleXThrowExpression"
    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3945:1: entryRuleXThrowExpression returns [EObject current=null] : iv_ruleXThrowExpression= ruleXThrowExpression EOF ;
    public final EObject entryRuleXThrowExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXThrowExpression = null;


        try {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3946:2: (iv_ruleXThrowExpression= ruleXThrowExpression EOF )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3947:2: iv_ruleXThrowExpression= ruleXThrowExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXThrowExpressionRule()); 
            }
            pushFollow(FOLLOW_ruleXThrowExpression_in_entryRuleXThrowExpression9195);
            iv_ruleXThrowExpression=ruleXThrowExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXThrowExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXThrowExpression9205); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleXThrowExpression"


    // $ANTLR start "ruleXThrowExpression"
    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3954:1: ruleXThrowExpression returns [EObject current=null] : ( () otherlv_1= 'throw' ( (lv_expression_2_0= ruleXExpression ) ) ) ;
    public final EObject ruleXThrowExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_expression_2_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3957:28: ( ( () otherlv_1= 'throw' ( (lv_expression_2_0= ruleXExpression ) ) ) )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3958:1: ( () otherlv_1= 'throw' ( (lv_expression_2_0= ruleXExpression ) ) )
            {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3958:1: ( () otherlv_1= 'throw' ( (lv_expression_2_0= ruleXExpression ) ) )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3958:2: () otherlv_1= 'throw' ( (lv_expression_2_0= ruleXExpression ) )
            {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3958:2: ()
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3959:5: 
            {
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getXThrowExpressionAccess().getXThrowExpressionAction_0(),
                          current);
                  
            }

            }

            otherlv_1=(Token)match(input,64,FOLLOW_64_in_ruleXThrowExpression9251); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getXThrowExpressionAccess().getThrowKeyword_1());
                  
            }
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3968:1: ( (lv_expression_2_0= ruleXExpression ) )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3969:1: (lv_expression_2_0= ruleXExpression )
            {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3969:1: (lv_expression_2_0= ruleXExpression )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3970:3: lv_expression_2_0= ruleXExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getXThrowExpressionAccess().getExpressionXExpressionParserRuleCall_2_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleXExpression_in_ruleXThrowExpression9272);
            lv_expression_2_0=ruleXExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getXThrowExpressionRule());
              	        }
                     		set(
                     			current, 
                     			"expression",
                      		lv_expression_2_0, 
                      		"XExpression");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleXThrowExpression"


    // $ANTLR start "entryRuleXReturnExpression"
    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3994:1: entryRuleXReturnExpression returns [EObject current=null] : iv_ruleXReturnExpression= ruleXReturnExpression EOF ;
    public final EObject entryRuleXReturnExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXReturnExpression = null;


        try {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3995:2: (iv_ruleXReturnExpression= ruleXReturnExpression EOF )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3996:2: iv_ruleXReturnExpression= ruleXReturnExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXReturnExpressionRule()); 
            }
            pushFollow(FOLLOW_ruleXReturnExpression_in_entryRuleXReturnExpression9308);
            iv_ruleXReturnExpression=ruleXReturnExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXReturnExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXReturnExpression9318); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleXReturnExpression"


    // $ANTLR start "ruleXReturnExpression"
    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4003:1: ruleXReturnExpression returns [EObject current=null] : ( () otherlv_1= 'return' ( ( ( ruleXExpression ) )=> (lv_expression_2_0= ruleXExpression ) )? ) ;
    public final EObject ruleXReturnExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_expression_2_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4006:28: ( ( () otherlv_1= 'return' ( ( ( ruleXExpression ) )=> (lv_expression_2_0= ruleXExpression ) )? ) )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4007:1: ( () otherlv_1= 'return' ( ( ( ruleXExpression ) )=> (lv_expression_2_0= ruleXExpression ) )? )
            {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4007:1: ( () otherlv_1= 'return' ( ( ( ruleXExpression ) )=> (lv_expression_2_0= ruleXExpression ) )? )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4007:2: () otherlv_1= 'return' ( ( ( ruleXExpression ) )=> (lv_expression_2_0= ruleXExpression ) )?
            {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4007:2: ()
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4008:5: 
            {
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getXReturnExpressionAccess().getXReturnExpressionAction_0(),
                          current);
                  
            }

            }

            otherlv_1=(Token)match(input,65,FOLLOW_65_in_ruleXReturnExpression9364); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getXReturnExpressionAccess().getReturnKeyword_1());
                  
            }
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4017:1: ( ( ( ruleXExpression ) )=> (lv_expression_2_0= ruleXExpression ) )?
            int alt67=2;
            alt67 = dfa67.predict(input);
            switch (alt67) {
                case 1 :
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4017:2: ( ( ruleXExpression ) )=> (lv_expression_2_0= ruleXExpression )
                    {
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4022:1: (lv_expression_2_0= ruleXExpression )
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4023:3: lv_expression_2_0= ruleXExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getXReturnExpressionAccess().getExpressionXExpressionParserRuleCall_2_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleXExpression_in_ruleXReturnExpression9395);
                    lv_expression_2_0=ruleXExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getXReturnExpressionRule());
                      	        }
                             		set(
                             			current, 
                             			"expression",
                              		lv_expression_2_0, 
                              		"XExpression");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }
                    break;

            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleXReturnExpression"


    // $ANTLR start "entryRuleXTryCatchFinallyExpression"
    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4047:1: entryRuleXTryCatchFinallyExpression returns [EObject current=null] : iv_ruleXTryCatchFinallyExpression= ruleXTryCatchFinallyExpression EOF ;
    public final EObject entryRuleXTryCatchFinallyExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXTryCatchFinallyExpression = null;


        try {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4048:2: (iv_ruleXTryCatchFinallyExpression= ruleXTryCatchFinallyExpression EOF )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4049:2: iv_ruleXTryCatchFinallyExpression= ruleXTryCatchFinallyExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXTryCatchFinallyExpressionRule()); 
            }
            pushFollow(FOLLOW_ruleXTryCatchFinallyExpression_in_entryRuleXTryCatchFinallyExpression9432);
            iv_ruleXTryCatchFinallyExpression=ruleXTryCatchFinallyExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXTryCatchFinallyExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXTryCatchFinallyExpression9442); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleXTryCatchFinallyExpression"


    // $ANTLR start "ruleXTryCatchFinallyExpression"
    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4056:1: ruleXTryCatchFinallyExpression returns [EObject current=null] : ( () otherlv_1= 'try' ( (lv_expression_2_0= ruleXExpression ) ) ( ( ( ( 'catch' )=> (lv_catchClauses_3_0= ruleXCatchClause ) )+ ( ( ( 'finally' )=>otherlv_4= 'finally' ) ( (lv_finallyExpression_5_0= ruleXExpression ) ) )? ) | (otherlv_6= 'finally' ( (lv_finallyExpression_7_0= ruleXExpression ) ) ) ) ) ;
    public final EObject ruleXTryCatchFinallyExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        EObject lv_expression_2_0 = null;

        EObject lv_catchClauses_3_0 = null;

        EObject lv_finallyExpression_5_0 = null;

        EObject lv_finallyExpression_7_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4059:28: ( ( () otherlv_1= 'try' ( (lv_expression_2_0= ruleXExpression ) ) ( ( ( ( 'catch' )=> (lv_catchClauses_3_0= ruleXCatchClause ) )+ ( ( ( 'finally' )=>otherlv_4= 'finally' ) ( (lv_finallyExpression_5_0= ruleXExpression ) ) )? ) | (otherlv_6= 'finally' ( (lv_finallyExpression_7_0= ruleXExpression ) ) ) ) ) )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4060:1: ( () otherlv_1= 'try' ( (lv_expression_2_0= ruleXExpression ) ) ( ( ( ( 'catch' )=> (lv_catchClauses_3_0= ruleXCatchClause ) )+ ( ( ( 'finally' )=>otherlv_4= 'finally' ) ( (lv_finallyExpression_5_0= ruleXExpression ) ) )? ) | (otherlv_6= 'finally' ( (lv_finallyExpression_7_0= ruleXExpression ) ) ) ) )
            {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4060:1: ( () otherlv_1= 'try' ( (lv_expression_2_0= ruleXExpression ) ) ( ( ( ( 'catch' )=> (lv_catchClauses_3_0= ruleXCatchClause ) )+ ( ( ( 'finally' )=>otherlv_4= 'finally' ) ( (lv_finallyExpression_5_0= ruleXExpression ) ) )? ) | (otherlv_6= 'finally' ( (lv_finallyExpression_7_0= ruleXExpression ) ) ) ) )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4060:2: () otherlv_1= 'try' ( (lv_expression_2_0= ruleXExpression ) ) ( ( ( ( 'catch' )=> (lv_catchClauses_3_0= ruleXCatchClause ) )+ ( ( ( 'finally' )=>otherlv_4= 'finally' ) ( (lv_finallyExpression_5_0= ruleXExpression ) ) )? ) | (otherlv_6= 'finally' ( (lv_finallyExpression_7_0= ruleXExpression ) ) ) )
            {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4060:2: ()
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4061:5: 
            {
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getXTryCatchFinallyExpressionAccess().getXTryCatchFinallyExpressionAction_0(),
                          current);
                  
            }

            }

            otherlv_1=(Token)match(input,66,FOLLOW_66_in_ruleXTryCatchFinallyExpression9488); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getXTryCatchFinallyExpressionAccess().getTryKeyword_1());
                  
            }
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4070:1: ( (lv_expression_2_0= ruleXExpression ) )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4071:1: (lv_expression_2_0= ruleXExpression )
            {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4071:1: (lv_expression_2_0= ruleXExpression )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4072:3: lv_expression_2_0= ruleXExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getXTryCatchFinallyExpressionAccess().getExpressionXExpressionParserRuleCall_2_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleXExpression_in_ruleXTryCatchFinallyExpression9509);
            lv_expression_2_0=ruleXExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getXTryCatchFinallyExpressionRule());
              	        }
                     		set(
                     			current, 
                     			"expression",
                      		lv_expression_2_0, 
                      		"XExpression");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4088:2: ( ( ( ( 'catch' )=> (lv_catchClauses_3_0= ruleXCatchClause ) )+ ( ( ( 'finally' )=>otherlv_4= 'finally' ) ( (lv_finallyExpression_5_0= ruleXExpression ) ) )? ) | (otherlv_6= 'finally' ( (lv_finallyExpression_7_0= ruleXExpression ) ) ) )
            int alt70=2;
            int LA70_0 = input.LA(1);

            if ( (LA70_0==68) ) {
                alt70=1;
            }
            else if ( (LA70_0==67) ) {
                alt70=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 70, 0, input);

                throw nvae;
            }
            switch (alt70) {
                case 1 :
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4088:3: ( ( ( 'catch' )=> (lv_catchClauses_3_0= ruleXCatchClause ) )+ ( ( ( 'finally' )=>otherlv_4= 'finally' ) ( (lv_finallyExpression_5_0= ruleXExpression ) ) )? )
                    {
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4088:3: ( ( ( 'catch' )=> (lv_catchClauses_3_0= ruleXCatchClause ) )+ ( ( ( 'finally' )=>otherlv_4= 'finally' ) ( (lv_finallyExpression_5_0= ruleXExpression ) ) )? )
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4088:4: ( ( 'catch' )=> (lv_catchClauses_3_0= ruleXCatchClause ) )+ ( ( ( 'finally' )=>otherlv_4= 'finally' ) ( (lv_finallyExpression_5_0= ruleXExpression ) ) )?
                    {
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4088:4: ( ( 'catch' )=> (lv_catchClauses_3_0= ruleXCatchClause ) )+
                    int cnt68=0;
                    loop68:
                    do {
                        int alt68=2;
                        int LA68_0 = input.LA(1);

                        if ( (LA68_0==68) ) {
                            int LA68_2 = input.LA(2);

                            if ( (synpred27_InternalPureXbase()) ) {
                                alt68=1;
                            }


                        }


                        switch (alt68) {
                    	case 1 :
                    	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4088:5: ( 'catch' )=> (lv_catchClauses_3_0= ruleXCatchClause )
                    	    {
                    	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4090:1: (lv_catchClauses_3_0= ruleXCatchClause )
                    	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4091:3: lv_catchClauses_3_0= ruleXCatchClause
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getXTryCatchFinallyExpressionAccess().getCatchClausesXCatchClauseParserRuleCall_3_0_0_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FOLLOW_ruleXCatchClause_in_ruleXTryCatchFinallyExpression9539);
                    	    lv_catchClauses_3_0=ruleXCatchClause();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      	        if (current==null) {
                    	      	            current = createModelElementForParent(grammarAccess.getXTryCatchFinallyExpressionRule());
                    	      	        }
                    	             		add(
                    	             			current, 
                    	             			"catchClauses",
                    	              		lv_catchClauses_3_0, 
                    	              		"XCatchClause");
                    	      	        afterParserOrEnumRuleCall();
                    	      	    
                    	    }

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    if ( cnt68 >= 1 ) break loop68;
                    	    if (state.backtracking>0) {state.failed=true; return current;}
                                EarlyExitException eee =
                                    new EarlyExitException(68, input);
                                throw eee;
                        }
                        cnt68++;
                    } while (true);

                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4107:3: ( ( ( 'finally' )=>otherlv_4= 'finally' ) ( (lv_finallyExpression_5_0= ruleXExpression ) ) )?
                    int alt69=2;
                    int LA69_0 = input.LA(1);

                    if ( (LA69_0==67) ) {
                        int LA69_1 = input.LA(2);

                        if ( (synpred28_InternalPureXbase()) ) {
                            alt69=1;
                        }
                    }
                    switch (alt69) {
                        case 1 :
                            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4107:4: ( ( 'finally' )=>otherlv_4= 'finally' ) ( (lv_finallyExpression_5_0= ruleXExpression ) )
                            {
                            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4107:4: ( ( 'finally' )=>otherlv_4= 'finally' )
                            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4107:5: ( 'finally' )=>otherlv_4= 'finally'
                            {
                            otherlv_4=(Token)match(input,67,FOLLOW_67_in_ruleXTryCatchFinallyExpression9561); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                                  	newLeafNode(otherlv_4, grammarAccess.getXTryCatchFinallyExpressionAccess().getFinallyKeyword_3_0_1_0());
                                  
                            }

                            }

                            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4112:2: ( (lv_finallyExpression_5_0= ruleXExpression ) )
                            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4113:1: (lv_finallyExpression_5_0= ruleXExpression )
                            {
                            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4113:1: (lv_finallyExpression_5_0= ruleXExpression )
                            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4114:3: lv_finallyExpression_5_0= ruleXExpression
                            {
                            if ( state.backtracking==0 ) {
                               
                              	        newCompositeNode(grammarAccess.getXTryCatchFinallyExpressionAccess().getFinallyExpressionXExpressionParserRuleCall_3_0_1_1_0()); 
                              	    
                            }
                            pushFollow(FOLLOW_ruleXExpression_in_ruleXTryCatchFinallyExpression9583);
                            lv_finallyExpression_5_0=ruleXExpression();

                            state._fsp--;
                            if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              	        if (current==null) {
                              	            current = createModelElementForParent(grammarAccess.getXTryCatchFinallyExpressionRule());
                              	        }
                                     		set(
                                     			current, 
                                     			"finallyExpression",
                                      		lv_finallyExpression_5_0, 
                                      		"XExpression");
                              	        afterParserOrEnumRuleCall();
                              	    
                            }

                            }


                            }


                            }
                            break;

                    }


                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4131:6: (otherlv_6= 'finally' ( (lv_finallyExpression_7_0= ruleXExpression ) ) )
                    {
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4131:6: (otherlv_6= 'finally' ( (lv_finallyExpression_7_0= ruleXExpression ) ) )
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4131:8: otherlv_6= 'finally' ( (lv_finallyExpression_7_0= ruleXExpression ) )
                    {
                    otherlv_6=(Token)match(input,67,FOLLOW_67_in_ruleXTryCatchFinallyExpression9605); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_6, grammarAccess.getXTryCatchFinallyExpressionAccess().getFinallyKeyword_3_1_0());
                          
                    }
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4135:1: ( (lv_finallyExpression_7_0= ruleXExpression ) )
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4136:1: (lv_finallyExpression_7_0= ruleXExpression )
                    {
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4136:1: (lv_finallyExpression_7_0= ruleXExpression )
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4137:3: lv_finallyExpression_7_0= ruleXExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getXTryCatchFinallyExpressionAccess().getFinallyExpressionXExpressionParserRuleCall_3_1_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleXExpression_in_ruleXTryCatchFinallyExpression9626);
                    lv_finallyExpression_7_0=ruleXExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getXTryCatchFinallyExpressionRule());
                      	        }
                             		set(
                             			current, 
                             			"finallyExpression",
                              		lv_finallyExpression_7_0, 
                              		"XExpression");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }


                    }
                    break;

            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleXTryCatchFinallyExpression"


    // $ANTLR start "entryRuleXCatchClause"
    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4161:1: entryRuleXCatchClause returns [EObject current=null] : iv_ruleXCatchClause= ruleXCatchClause EOF ;
    public final EObject entryRuleXCatchClause() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXCatchClause = null;


        try {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4162:2: (iv_ruleXCatchClause= ruleXCatchClause EOF )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4163:2: iv_ruleXCatchClause= ruleXCatchClause EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXCatchClauseRule()); 
            }
            pushFollow(FOLLOW_ruleXCatchClause_in_entryRuleXCatchClause9664);
            iv_ruleXCatchClause=ruleXCatchClause();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXCatchClause; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXCatchClause9674); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleXCatchClause"


    // $ANTLR start "ruleXCatchClause"
    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4170:1: ruleXCatchClause returns [EObject current=null] : ( ( ( 'catch' )=>otherlv_0= 'catch' ) otherlv_1= '(' ( (lv_declaredParam_2_0= ruleFullJvmFormalParameter ) ) otherlv_3= ')' ( (lv_expression_4_0= ruleXExpression ) ) ) ;
    public final EObject ruleXCatchClause() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        EObject lv_declaredParam_2_0 = null;

        EObject lv_expression_4_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4173:28: ( ( ( ( 'catch' )=>otherlv_0= 'catch' ) otherlv_1= '(' ( (lv_declaredParam_2_0= ruleFullJvmFormalParameter ) ) otherlv_3= ')' ( (lv_expression_4_0= ruleXExpression ) ) ) )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4174:1: ( ( ( 'catch' )=>otherlv_0= 'catch' ) otherlv_1= '(' ( (lv_declaredParam_2_0= ruleFullJvmFormalParameter ) ) otherlv_3= ')' ( (lv_expression_4_0= ruleXExpression ) ) )
            {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4174:1: ( ( ( 'catch' )=>otherlv_0= 'catch' ) otherlv_1= '(' ( (lv_declaredParam_2_0= ruleFullJvmFormalParameter ) ) otherlv_3= ')' ( (lv_expression_4_0= ruleXExpression ) ) )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4174:2: ( ( 'catch' )=>otherlv_0= 'catch' ) otherlv_1= '(' ( (lv_declaredParam_2_0= ruleFullJvmFormalParameter ) ) otherlv_3= ')' ( (lv_expression_4_0= ruleXExpression ) )
            {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4174:2: ( ( 'catch' )=>otherlv_0= 'catch' )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4174:3: ( 'catch' )=>otherlv_0= 'catch'
            {
            otherlv_0=(Token)match(input,68,FOLLOW_68_in_ruleXCatchClause9719); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getXCatchClauseAccess().getCatchKeyword_0());
                  
            }

            }

            otherlv_1=(Token)match(input,39,FOLLOW_39_in_ruleXCatchClause9732); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getXCatchClauseAccess().getLeftParenthesisKeyword_1());
                  
            }
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4183:1: ( (lv_declaredParam_2_0= ruleFullJvmFormalParameter ) )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4184:1: (lv_declaredParam_2_0= ruleFullJvmFormalParameter )
            {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4184:1: (lv_declaredParam_2_0= ruleFullJvmFormalParameter )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4185:3: lv_declaredParam_2_0= ruleFullJvmFormalParameter
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getXCatchClauseAccess().getDeclaredParamFullJvmFormalParameterParserRuleCall_2_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleFullJvmFormalParameter_in_ruleXCatchClause9753);
            lv_declaredParam_2_0=ruleFullJvmFormalParameter();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getXCatchClauseRule());
              	        }
                     		set(
                     			current, 
                     			"declaredParam",
                      		lv_declaredParam_2_0, 
                      		"FullJvmFormalParameter");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            otherlv_3=(Token)match(input,40,FOLLOW_40_in_ruleXCatchClause9765); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_3, grammarAccess.getXCatchClauseAccess().getRightParenthesisKeyword_3());
                  
            }
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4205:1: ( (lv_expression_4_0= ruleXExpression ) )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4206:1: (lv_expression_4_0= ruleXExpression )
            {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4206:1: (lv_expression_4_0= ruleXExpression )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4207:3: lv_expression_4_0= ruleXExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getXCatchClauseAccess().getExpressionXExpressionParserRuleCall_4_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleXExpression_in_ruleXCatchClause9786);
            lv_expression_4_0=ruleXExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getXCatchClauseRule());
              	        }
                     		set(
                     			current, 
                     			"expression",
                      		lv_expression_4_0, 
                      		"XExpression");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleXCatchClause"


    // $ANTLR start "entryRuleQualifiedName"
    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4231:1: entryRuleQualifiedName returns [String current=null] : iv_ruleQualifiedName= ruleQualifiedName EOF ;
    public final String entryRuleQualifiedName() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleQualifiedName = null;


        try {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4232:2: (iv_ruleQualifiedName= ruleQualifiedName EOF )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4233:2: iv_ruleQualifiedName= ruleQualifiedName EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getQualifiedNameRule()); 
            }
            pushFollow(FOLLOW_ruleQualifiedName_in_entryRuleQualifiedName9823);
            iv_ruleQualifiedName=ruleQualifiedName();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleQualifiedName.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleQualifiedName9834); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleQualifiedName"


    // $ANTLR start "ruleQualifiedName"
    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4240:1: ruleQualifiedName returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_ValidID_0= ruleValidID ( ( ( '.' )=>kw= '.' ) this_ValidID_2= ruleValidID )* ) ;
    public final AntlrDatatypeRuleToken ruleQualifiedName() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        AntlrDatatypeRuleToken this_ValidID_0 = null;

        AntlrDatatypeRuleToken this_ValidID_2 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4243:28: ( (this_ValidID_0= ruleValidID ( ( ( '.' )=>kw= '.' ) this_ValidID_2= ruleValidID )* ) )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4244:1: (this_ValidID_0= ruleValidID ( ( ( '.' )=>kw= '.' ) this_ValidID_2= ruleValidID )* )
            {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4244:1: (this_ValidID_0= ruleValidID ( ( ( '.' )=>kw= '.' ) this_ValidID_2= ruleValidID )* )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4245:5: this_ValidID_0= ruleValidID ( ( ( '.' )=>kw= '.' ) this_ValidID_2= ruleValidID )*
            {
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getQualifiedNameAccess().getValidIDParserRuleCall_0()); 
                  
            }
            pushFollow(FOLLOW_ruleValidID_in_ruleQualifiedName9881);
            this_ValidID_0=ruleValidID();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              		current.merge(this_ValidID_0);
                  
            }
            if ( state.backtracking==0 ) {
               
                      afterParserOrEnumRuleCall();
                  
            }
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4255:1: ( ( ( '.' )=>kw= '.' ) this_ValidID_2= ruleValidID )*
            loop71:
            do {
                int alt71=2;
                int LA71_0 = input.LA(1);

                if ( (LA71_0==35) ) {
                    int LA71_2 = input.LA(2);

                    if ( (LA71_2==RULE_ID) ) {
                        int LA71_3 = input.LA(3);

                        if ( (synpred30_InternalPureXbase()) ) {
                            alt71=1;
                        }


                    }


                }


                switch (alt71) {
            	case 1 :
            	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4255:2: ( ( '.' )=>kw= '.' ) this_ValidID_2= ruleValidID
            	    {
            	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4255:2: ( ( '.' )=>kw= '.' )
            	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4255:3: ( '.' )=>kw= '.'
            	    {
            	    kw=(Token)match(input,35,FOLLOW_35_in_ruleQualifiedName9909); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	              current.merge(kw);
            	              newLeafNode(kw, grammarAccess.getQualifiedNameAccess().getFullStopKeyword_1_0()); 
            	          
            	    }

            	    }

            	    if ( state.backtracking==0 ) {
            	       
            	              newCompositeNode(grammarAccess.getQualifiedNameAccess().getValidIDParserRuleCall_1_1()); 
            	          
            	    }
            	    pushFollow(FOLLOW_ruleValidID_in_ruleQualifiedName9932);
            	    this_ValidID_2=ruleValidID();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      		current.merge(this_ValidID_2);
            	          
            	    }
            	    if ( state.backtracking==0 ) {
            	       
            	              afterParserOrEnumRuleCall();
            	          
            	    }

            	    }
            	    break;

            	default :
            	    break loop71;
                }
            } while (true);


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleQualifiedName"


    // $ANTLR start "entryRuleJvmTypeReference"
    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4282:1: entryRuleJvmTypeReference returns [EObject current=null] : iv_ruleJvmTypeReference= ruleJvmTypeReference EOF ;
    public final EObject entryRuleJvmTypeReference() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleJvmTypeReference = null;


        try {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4283:2: (iv_ruleJvmTypeReference= ruleJvmTypeReference EOF )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4284:2: iv_ruleJvmTypeReference= ruleJvmTypeReference EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getJvmTypeReferenceRule()); 
            }
            pushFollow(FOLLOW_ruleJvmTypeReference_in_entryRuleJvmTypeReference9979);
            iv_ruleJvmTypeReference=ruleJvmTypeReference();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleJvmTypeReference; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleJvmTypeReference9989); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleJvmTypeReference"


    // $ANTLR start "ruleJvmTypeReference"
    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4291:1: ruleJvmTypeReference returns [EObject current=null] : ( (this_JvmParameterizedTypeReference_0= ruleJvmParameterizedTypeReference ( ( ( () '[' ']' ) )=> ( () otherlv_2= '[' otherlv_3= ']' ) )* ) | this_XFunctionTypeRef_4= ruleXFunctionTypeRef ) ;
    public final EObject ruleJvmTypeReference() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        Token otherlv_3=null;
        EObject this_JvmParameterizedTypeReference_0 = null;

        EObject this_XFunctionTypeRef_4 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4294:28: ( ( (this_JvmParameterizedTypeReference_0= ruleJvmParameterizedTypeReference ( ( ( () '[' ']' ) )=> ( () otherlv_2= '[' otherlv_3= ']' ) )* ) | this_XFunctionTypeRef_4= ruleXFunctionTypeRef ) )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4295:1: ( (this_JvmParameterizedTypeReference_0= ruleJvmParameterizedTypeReference ( ( ( () '[' ']' ) )=> ( () otherlv_2= '[' otherlv_3= ']' ) )* ) | this_XFunctionTypeRef_4= ruleXFunctionTypeRef )
            {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4295:1: ( (this_JvmParameterizedTypeReference_0= ruleJvmParameterizedTypeReference ( ( ( () '[' ']' ) )=> ( () otherlv_2= '[' otherlv_3= ']' ) )* ) | this_XFunctionTypeRef_4= ruleXFunctionTypeRef )
            int alt73=2;
            int LA73_0 = input.LA(1);

            if ( (LA73_0==RULE_ID) ) {
                alt73=1;
            }
            else if ( (LA73_0==39||LA73_0==69) ) {
                alt73=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 73, 0, input);

                throw nvae;
            }
            switch (alt73) {
                case 1 :
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4295:2: (this_JvmParameterizedTypeReference_0= ruleJvmParameterizedTypeReference ( ( ( () '[' ']' ) )=> ( () otherlv_2= '[' otherlv_3= ']' ) )* )
                    {
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4295:2: (this_JvmParameterizedTypeReference_0= ruleJvmParameterizedTypeReference ( ( ( () '[' ']' ) )=> ( () otherlv_2= '[' otherlv_3= ']' ) )* )
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4296:5: this_JvmParameterizedTypeReference_0= ruleJvmParameterizedTypeReference ( ( ( () '[' ']' ) )=> ( () otherlv_2= '[' otherlv_3= ']' ) )*
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getJvmTypeReferenceAccess().getJvmParameterizedTypeReferenceParserRuleCall_0_0()); 
                          
                    }
                    pushFollow(FOLLOW_ruleJvmParameterizedTypeReference_in_ruleJvmTypeReference10037);
                    this_JvmParameterizedTypeReference_0=ruleJvmParameterizedTypeReference();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_JvmParameterizedTypeReference_0; 
                              afterParserOrEnumRuleCall();
                          
                    }
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4304:1: ( ( ( () '[' ']' ) )=> ( () otherlv_2= '[' otherlv_3= ']' ) )*
                    loop72:
                    do {
                        int alt72=2;
                        int LA72_0 = input.LA(1);

                        if ( (LA72_0==41) ) {
                            int LA72_2 = input.LA(2);

                            if ( (LA72_2==43) ) {
                                int LA72_3 = input.LA(3);

                                if ( (synpred31_InternalPureXbase()) ) {
                                    alt72=1;
                                }


                            }


                        }


                        switch (alt72) {
                    	case 1 :
                    	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4304:2: ( ( () '[' ']' ) )=> ( () otherlv_2= '[' otherlv_3= ']' )
                    	    {
                    	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4307:5: ( () otherlv_2= '[' otherlv_3= ']' )
                    	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4307:6: () otherlv_2= '[' otherlv_3= ']'
                    	    {
                    	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4307:6: ()
                    	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4308:5: 
                    	    {
                    	    if ( state.backtracking==0 ) {

                    	              current = forceCreateModelElementAndSet(
                    	                  grammarAccess.getJvmTypeReferenceAccess().getJvmGenericArrayTypeReferenceComponentTypeAction_0_1_0_0(),
                    	                  current);
                    	          
                    	    }

                    	    }

                    	    otherlv_2=(Token)match(input,41,FOLLOW_41_in_ruleJvmTypeReference10075); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	          	newLeafNode(otherlv_2, grammarAccess.getJvmTypeReferenceAccess().getLeftSquareBracketKeyword_0_1_0_1());
                    	          
                    	    }
                    	    otherlv_3=(Token)match(input,43,FOLLOW_43_in_ruleJvmTypeReference10087); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	          	newLeafNode(otherlv_3, grammarAccess.getJvmTypeReferenceAccess().getRightSquareBracketKeyword_0_1_0_2());
                    	          
                    	    }

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop72;
                        }
                    } while (true);


                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4323:5: this_XFunctionTypeRef_4= ruleXFunctionTypeRef
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getJvmTypeReferenceAccess().getXFunctionTypeRefParserRuleCall_1()); 
                          
                    }
                    pushFollow(FOLLOW_ruleXFunctionTypeRef_in_ruleJvmTypeReference10119);
                    this_XFunctionTypeRef_4=ruleXFunctionTypeRef();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_XFunctionTypeRef_4; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleJvmTypeReference"


    // $ANTLR start "entryRuleXFunctionTypeRef"
    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4339:1: entryRuleXFunctionTypeRef returns [EObject current=null] : iv_ruleXFunctionTypeRef= ruleXFunctionTypeRef EOF ;
    public final EObject entryRuleXFunctionTypeRef() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXFunctionTypeRef = null;


        try {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4340:2: (iv_ruleXFunctionTypeRef= ruleXFunctionTypeRef EOF )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4341:2: iv_ruleXFunctionTypeRef= ruleXFunctionTypeRef EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXFunctionTypeRefRule()); 
            }
            pushFollow(FOLLOW_ruleXFunctionTypeRef_in_entryRuleXFunctionTypeRef10154);
            iv_ruleXFunctionTypeRef=ruleXFunctionTypeRef();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXFunctionTypeRef; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXFunctionTypeRef10164); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleXFunctionTypeRef"


    // $ANTLR start "ruleXFunctionTypeRef"
    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4348:1: ruleXFunctionTypeRef returns [EObject current=null] : ( (otherlv_0= '(' ( ( (lv_paramTypes_1_0= ruleJvmTypeReference ) ) (otherlv_2= ',' ( (lv_paramTypes_3_0= ruleJvmTypeReference ) ) )* )? otherlv_4= ')' )? otherlv_5= '=>' ( (lv_returnType_6_0= ruleJvmTypeReference ) ) ) ;
    public final EObject ruleXFunctionTypeRef() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        EObject lv_paramTypes_1_0 = null;

        EObject lv_paramTypes_3_0 = null;

        EObject lv_returnType_6_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4351:28: ( ( (otherlv_0= '(' ( ( (lv_paramTypes_1_0= ruleJvmTypeReference ) ) (otherlv_2= ',' ( (lv_paramTypes_3_0= ruleJvmTypeReference ) ) )* )? otherlv_4= ')' )? otherlv_5= '=>' ( (lv_returnType_6_0= ruleJvmTypeReference ) ) ) )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4352:1: ( (otherlv_0= '(' ( ( (lv_paramTypes_1_0= ruleJvmTypeReference ) ) (otherlv_2= ',' ( (lv_paramTypes_3_0= ruleJvmTypeReference ) ) )* )? otherlv_4= ')' )? otherlv_5= '=>' ( (lv_returnType_6_0= ruleJvmTypeReference ) ) )
            {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4352:1: ( (otherlv_0= '(' ( ( (lv_paramTypes_1_0= ruleJvmTypeReference ) ) (otherlv_2= ',' ( (lv_paramTypes_3_0= ruleJvmTypeReference ) ) )* )? otherlv_4= ')' )? otherlv_5= '=>' ( (lv_returnType_6_0= ruleJvmTypeReference ) ) )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4352:2: (otherlv_0= '(' ( ( (lv_paramTypes_1_0= ruleJvmTypeReference ) ) (otherlv_2= ',' ( (lv_paramTypes_3_0= ruleJvmTypeReference ) ) )* )? otherlv_4= ')' )? otherlv_5= '=>' ( (lv_returnType_6_0= ruleJvmTypeReference ) )
            {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4352:2: (otherlv_0= '(' ( ( (lv_paramTypes_1_0= ruleJvmTypeReference ) ) (otherlv_2= ',' ( (lv_paramTypes_3_0= ruleJvmTypeReference ) ) )* )? otherlv_4= ')' )?
            int alt76=2;
            int LA76_0 = input.LA(1);

            if ( (LA76_0==39) ) {
                alt76=1;
            }
            switch (alt76) {
                case 1 :
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4352:4: otherlv_0= '(' ( ( (lv_paramTypes_1_0= ruleJvmTypeReference ) ) (otherlv_2= ',' ( (lv_paramTypes_3_0= ruleJvmTypeReference ) ) )* )? otherlv_4= ')'
                    {
                    otherlv_0=(Token)match(input,39,FOLLOW_39_in_ruleXFunctionTypeRef10202); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_0, grammarAccess.getXFunctionTypeRefAccess().getLeftParenthesisKeyword_0_0());
                          
                    }
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4356:1: ( ( (lv_paramTypes_1_0= ruleJvmTypeReference ) ) (otherlv_2= ',' ( (lv_paramTypes_3_0= ruleJvmTypeReference ) ) )* )?
                    int alt75=2;
                    int LA75_0 = input.LA(1);

                    if ( (LA75_0==RULE_ID||LA75_0==39||LA75_0==69) ) {
                        alt75=1;
                    }
                    switch (alt75) {
                        case 1 :
                            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4356:2: ( (lv_paramTypes_1_0= ruleJvmTypeReference ) ) (otherlv_2= ',' ( (lv_paramTypes_3_0= ruleJvmTypeReference ) ) )*
                            {
                            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4356:2: ( (lv_paramTypes_1_0= ruleJvmTypeReference ) )
                            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4357:1: (lv_paramTypes_1_0= ruleJvmTypeReference )
                            {
                            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4357:1: (lv_paramTypes_1_0= ruleJvmTypeReference )
                            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4358:3: lv_paramTypes_1_0= ruleJvmTypeReference
                            {
                            if ( state.backtracking==0 ) {
                               
                              	        newCompositeNode(grammarAccess.getXFunctionTypeRefAccess().getParamTypesJvmTypeReferenceParserRuleCall_0_1_0_0()); 
                              	    
                            }
                            pushFollow(FOLLOW_ruleJvmTypeReference_in_ruleXFunctionTypeRef10224);
                            lv_paramTypes_1_0=ruleJvmTypeReference();

                            state._fsp--;
                            if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              	        if (current==null) {
                              	            current = createModelElementForParent(grammarAccess.getXFunctionTypeRefRule());
                              	        }
                                     		add(
                                     			current, 
                                     			"paramTypes",
                                      		lv_paramTypes_1_0, 
                                      		"JvmTypeReference");
                              	        afterParserOrEnumRuleCall();
                              	    
                            }

                            }


                            }

                            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4374:2: (otherlv_2= ',' ( (lv_paramTypes_3_0= ruleJvmTypeReference ) ) )*
                            loop74:
                            do {
                                int alt74=2;
                                int LA74_0 = input.LA(1);

                                if ( (LA74_0==38) ) {
                                    alt74=1;
                                }


                                switch (alt74) {
                            	case 1 :
                            	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4374:4: otherlv_2= ',' ( (lv_paramTypes_3_0= ruleJvmTypeReference ) )
                            	    {
                            	    otherlv_2=(Token)match(input,38,FOLLOW_38_in_ruleXFunctionTypeRef10237); if (state.failed) return current;
                            	    if ( state.backtracking==0 ) {

                            	          	newLeafNode(otherlv_2, grammarAccess.getXFunctionTypeRefAccess().getCommaKeyword_0_1_1_0());
                            	          
                            	    }
                            	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4378:1: ( (lv_paramTypes_3_0= ruleJvmTypeReference ) )
                            	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4379:1: (lv_paramTypes_3_0= ruleJvmTypeReference )
                            	    {
                            	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4379:1: (lv_paramTypes_3_0= ruleJvmTypeReference )
                            	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4380:3: lv_paramTypes_3_0= ruleJvmTypeReference
                            	    {
                            	    if ( state.backtracking==0 ) {
                            	       
                            	      	        newCompositeNode(grammarAccess.getXFunctionTypeRefAccess().getParamTypesJvmTypeReferenceParserRuleCall_0_1_1_1_0()); 
                            	      	    
                            	    }
                            	    pushFollow(FOLLOW_ruleJvmTypeReference_in_ruleXFunctionTypeRef10258);
                            	    lv_paramTypes_3_0=ruleJvmTypeReference();

                            	    state._fsp--;
                            	    if (state.failed) return current;
                            	    if ( state.backtracking==0 ) {

                            	      	        if (current==null) {
                            	      	            current = createModelElementForParent(grammarAccess.getXFunctionTypeRefRule());
                            	      	        }
                            	             		add(
                            	             			current, 
                            	             			"paramTypes",
                            	              		lv_paramTypes_3_0, 
                            	              		"JvmTypeReference");
                            	      	        afterParserOrEnumRuleCall();
                            	      	    
                            	    }

                            	    }


                            	    }


                            	    }
                            	    break;

                            	default :
                            	    break loop74;
                                }
                            } while (true);


                            }
                            break;

                    }

                    otherlv_4=(Token)match(input,40,FOLLOW_40_in_ruleXFunctionTypeRef10274); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_4, grammarAccess.getXFunctionTypeRefAccess().getRightParenthesisKeyword_0_2());
                          
                    }

                    }
                    break;

            }

            otherlv_5=(Token)match(input,69,FOLLOW_69_in_ruleXFunctionTypeRef10288); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_5, grammarAccess.getXFunctionTypeRefAccess().getEqualsSignGreaterThanSignKeyword_1());
                  
            }
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4404:1: ( (lv_returnType_6_0= ruleJvmTypeReference ) )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4405:1: (lv_returnType_6_0= ruleJvmTypeReference )
            {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4405:1: (lv_returnType_6_0= ruleJvmTypeReference )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4406:3: lv_returnType_6_0= ruleJvmTypeReference
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getXFunctionTypeRefAccess().getReturnTypeJvmTypeReferenceParserRuleCall_2_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleJvmTypeReference_in_ruleXFunctionTypeRef10309);
            lv_returnType_6_0=ruleJvmTypeReference();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getXFunctionTypeRefRule());
              	        }
                     		set(
                     			current, 
                     			"returnType",
                      		lv_returnType_6_0, 
                      		"JvmTypeReference");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleXFunctionTypeRef"


    // $ANTLR start "entryRuleJvmParameterizedTypeReference"
    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4430:1: entryRuleJvmParameterizedTypeReference returns [EObject current=null] : iv_ruleJvmParameterizedTypeReference= ruleJvmParameterizedTypeReference EOF ;
    public final EObject entryRuleJvmParameterizedTypeReference() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleJvmParameterizedTypeReference = null;


        try {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4431:2: (iv_ruleJvmParameterizedTypeReference= ruleJvmParameterizedTypeReference EOF )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4432:2: iv_ruleJvmParameterizedTypeReference= ruleJvmParameterizedTypeReference EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getJvmParameterizedTypeReferenceRule()); 
            }
            pushFollow(FOLLOW_ruleJvmParameterizedTypeReference_in_entryRuleJvmParameterizedTypeReference10345);
            iv_ruleJvmParameterizedTypeReference=ruleJvmParameterizedTypeReference();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleJvmParameterizedTypeReference; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleJvmParameterizedTypeReference10355); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleJvmParameterizedTypeReference"


    // $ANTLR start "ruleJvmParameterizedTypeReference"
    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4439:1: ruleJvmParameterizedTypeReference returns [EObject current=null] : ( ( ( ruleQualifiedName ) ) ( ( ( '<' )=>otherlv_1= '<' ) ( (lv_arguments_2_0= ruleJvmArgumentTypeReference ) ) (otherlv_3= ',' ( (lv_arguments_4_0= ruleJvmArgumentTypeReference ) ) )* otherlv_5= '>' )? ) ;
    public final EObject ruleJvmParameterizedTypeReference() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        EObject lv_arguments_2_0 = null;

        EObject lv_arguments_4_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4442:28: ( ( ( ( ruleQualifiedName ) ) ( ( ( '<' )=>otherlv_1= '<' ) ( (lv_arguments_2_0= ruleJvmArgumentTypeReference ) ) (otherlv_3= ',' ( (lv_arguments_4_0= ruleJvmArgumentTypeReference ) ) )* otherlv_5= '>' )? ) )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4443:1: ( ( ( ruleQualifiedName ) ) ( ( ( '<' )=>otherlv_1= '<' ) ( (lv_arguments_2_0= ruleJvmArgumentTypeReference ) ) (otherlv_3= ',' ( (lv_arguments_4_0= ruleJvmArgumentTypeReference ) ) )* otherlv_5= '>' )? )
            {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4443:1: ( ( ( ruleQualifiedName ) ) ( ( ( '<' )=>otherlv_1= '<' ) ( (lv_arguments_2_0= ruleJvmArgumentTypeReference ) ) (otherlv_3= ',' ( (lv_arguments_4_0= ruleJvmArgumentTypeReference ) ) )* otherlv_5= '>' )? )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4443:2: ( ( ruleQualifiedName ) ) ( ( ( '<' )=>otherlv_1= '<' ) ( (lv_arguments_2_0= ruleJvmArgumentTypeReference ) ) (otherlv_3= ',' ( (lv_arguments_4_0= ruleJvmArgumentTypeReference ) ) )* otherlv_5= '>' )?
            {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4443:2: ( ( ruleQualifiedName ) )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4444:1: ( ruleQualifiedName )
            {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4444:1: ( ruleQualifiedName )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4445:3: ruleQualifiedName
            {
            if ( state.backtracking==0 ) {

              			if (current==null) {
              	            current = createModelElement(grammarAccess.getJvmParameterizedTypeReferenceRule());
              	        }
                      
            }
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getJvmParameterizedTypeReferenceAccess().getTypeJvmTypeCrossReference_0_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleQualifiedName_in_ruleJvmParameterizedTypeReference10403);
            ruleQualifiedName();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4458:2: ( ( ( '<' )=>otherlv_1= '<' ) ( (lv_arguments_2_0= ruleJvmArgumentTypeReference ) ) (otherlv_3= ',' ( (lv_arguments_4_0= ruleJvmArgumentTypeReference ) ) )* otherlv_5= '>' )?
            int alt78=2;
            alt78 = dfa78.predict(input);
            switch (alt78) {
                case 1 :
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4458:3: ( ( '<' )=>otherlv_1= '<' ) ( (lv_arguments_2_0= ruleJvmArgumentTypeReference ) ) (otherlv_3= ',' ( (lv_arguments_4_0= ruleJvmArgumentTypeReference ) ) )* otherlv_5= '>'
                    {
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4458:3: ( ( '<' )=>otherlv_1= '<' )
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4458:4: ( '<' )=>otherlv_1= '<'
                    {
                    otherlv_1=(Token)match(input,24,FOLLOW_24_in_ruleJvmParameterizedTypeReference10424); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_1, grammarAccess.getJvmParameterizedTypeReferenceAccess().getLessThanSignKeyword_1_0());
                          
                    }

                    }

                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4463:2: ( (lv_arguments_2_0= ruleJvmArgumentTypeReference ) )
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4464:1: (lv_arguments_2_0= ruleJvmArgumentTypeReference )
                    {
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4464:1: (lv_arguments_2_0= ruleJvmArgumentTypeReference )
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4465:3: lv_arguments_2_0= ruleJvmArgumentTypeReference
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getJvmParameterizedTypeReferenceAccess().getArgumentsJvmArgumentTypeReferenceParserRuleCall_1_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleJvmArgumentTypeReference_in_ruleJvmParameterizedTypeReference10446);
                    lv_arguments_2_0=ruleJvmArgumentTypeReference();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getJvmParameterizedTypeReferenceRule());
                      	        }
                             		add(
                             			current, 
                             			"arguments",
                              		lv_arguments_2_0, 
                              		"JvmArgumentTypeReference");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }

                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4481:2: (otherlv_3= ',' ( (lv_arguments_4_0= ruleJvmArgumentTypeReference ) ) )*
                    loop77:
                    do {
                        int alt77=2;
                        int LA77_0 = input.LA(1);

                        if ( (LA77_0==38) ) {
                            alt77=1;
                        }


                        switch (alt77) {
                    	case 1 :
                    	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4481:4: otherlv_3= ',' ( (lv_arguments_4_0= ruleJvmArgumentTypeReference ) )
                    	    {
                    	    otherlv_3=(Token)match(input,38,FOLLOW_38_in_ruleJvmParameterizedTypeReference10459); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	          	newLeafNode(otherlv_3, grammarAccess.getJvmParameterizedTypeReferenceAccess().getCommaKeyword_1_2_0());
                    	          
                    	    }
                    	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4485:1: ( (lv_arguments_4_0= ruleJvmArgumentTypeReference ) )
                    	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4486:1: (lv_arguments_4_0= ruleJvmArgumentTypeReference )
                    	    {
                    	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4486:1: (lv_arguments_4_0= ruleJvmArgumentTypeReference )
                    	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4487:3: lv_arguments_4_0= ruleJvmArgumentTypeReference
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getJvmParameterizedTypeReferenceAccess().getArgumentsJvmArgumentTypeReferenceParserRuleCall_1_2_1_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FOLLOW_ruleJvmArgumentTypeReference_in_ruleJvmParameterizedTypeReference10480);
                    	    lv_arguments_4_0=ruleJvmArgumentTypeReference();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      	        if (current==null) {
                    	      	            current = createModelElementForParent(grammarAccess.getJvmParameterizedTypeReferenceRule());
                    	      	        }
                    	             		add(
                    	             			current, 
                    	             			"arguments",
                    	              		lv_arguments_4_0, 
                    	              		"JvmArgumentTypeReference");
                    	      	        afterParserOrEnumRuleCall();
                    	      	    
                    	    }

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop77;
                        }
                    } while (true);

                    otherlv_5=(Token)match(input,23,FOLLOW_23_in_ruleJvmParameterizedTypeReference10494); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_5, grammarAccess.getJvmParameterizedTypeReferenceAccess().getGreaterThanSignKeyword_1_3());
                          
                    }

                    }
                    break;

            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleJvmParameterizedTypeReference"


    // $ANTLR start "entryRuleJvmArgumentTypeReference"
    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4515:1: entryRuleJvmArgumentTypeReference returns [EObject current=null] : iv_ruleJvmArgumentTypeReference= ruleJvmArgumentTypeReference EOF ;
    public final EObject entryRuleJvmArgumentTypeReference() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleJvmArgumentTypeReference = null;


        try {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4516:2: (iv_ruleJvmArgumentTypeReference= ruleJvmArgumentTypeReference EOF )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4517:2: iv_ruleJvmArgumentTypeReference= ruleJvmArgumentTypeReference EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getJvmArgumentTypeReferenceRule()); 
            }
            pushFollow(FOLLOW_ruleJvmArgumentTypeReference_in_entryRuleJvmArgumentTypeReference10532);
            iv_ruleJvmArgumentTypeReference=ruleJvmArgumentTypeReference();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleJvmArgumentTypeReference; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleJvmArgumentTypeReference10542); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleJvmArgumentTypeReference"


    // $ANTLR start "ruleJvmArgumentTypeReference"
    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4524:1: ruleJvmArgumentTypeReference returns [EObject current=null] : (this_JvmTypeReference_0= ruleJvmTypeReference | this_JvmWildcardTypeReference_1= ruleJvmWildcardTypeReference ) ;
    public final EObject ruleJvmArgumentTypeReference() throws RecognitionException {
        EObject current = null;

        EObject this_JvmTypeReference_0 = null;

        EObject this_JvmWildcardTypeReference_1 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4527:28: ( (this_JvmTypeReference_0= ruleJvmTypeReference | this_JvmWildcardTypeReference_1= ruleJvmWildcardTypeReference ) )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4528:1: (this_JvmTypeReference_0= ruleJvmTypeReference | this_JvmWildcardTypeReference_1= ruleJvmWildcardTypeReference )
            {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4528:1: (this_JvmTypeReference_0= ruleJvmTypeReference | this_JvmWildcardTypeReference_1= ruleJvmWildcardTypeReference )
            int alt79=2;
            int LA79_0 = input.LA(1);

            if ( (LA79_0==RULE_ID||LA79_0==39||LA79_0==69) ) {
                alt79=1;
            }
            else if ( (LA79_0==70) ) {
                alt79=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 79, 0, input);

                throw nvae;
            }
            switch (alt79) {
                case 1 :
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4529:5: this_JvmTypeReference_0= ruleJvmTypeReference
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getJvmArgumentTypeReferenceAccess().getJvmTypeReferenceParserRuleCall_0()); 
                          
                    }
                    pushFollow(FOLLOW_ruleJvmTypeReference_in_ruleJvmArgumentTypeReference10589);
                    this_JvmTypeReference_0=ruleJvmTypeReference();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_JvmTypeReference_0; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4539:5: this_JvmWildcardTypeReference_1= ruleJvmWildcardTypeReference
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getJvmArgumentTypeReferenceAccess().getJvmWildcardTypeReferenceParserRuleCall_1()); 
                          
                    }
                    pushFollow(FOLLOW_ruleJvmWildcardTypeReference_in_ruleJvmArgumentTypeReference10616);
                    this_JvmWildcardTypeReference_1=ruleJvmWildcardTypeReference();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_JvmWildcardTypeReference_1; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleJvmArgumentTypeReference"


    // $ANTLR start "entryRuleJvmWildcardTypeReference"
    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4555:1: entryRuleJvmWildcardTypeReference returns [EObject current=null] : iv_ruleJvmWildcardTypeReference= ruleJvmWildcardTypeReference EOF ;
    public final EObject entryRuleJvmWildcardTypeReference() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleJvmWildcardTypeReference = null;


        try {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4556:2: (iv_ruleJvmWildcardTypeReference= ruleJvmWildcardTypeReference EOF )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4557:2: iv_ruleJvmWildcardTypeReference= ruleJvmWildcardTypeReference EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getJvmWildcardTypeReferenceRule()); 
            }
            pushFollow(FOLLOW_ruleJvmWildcardTypeReference_in_entryRuleJvmWildcardTypeReference10651);
            iv_ruleJvmWildcardTypeReference=ruleJvmWildcardTypeReference();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleJvmWildcardTypeReference; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleJvmWildcardTypeReference10661); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleJvmWildcardTypeReference"


    // $ANTLR start "ruleJvmWildcardTypeReference"
    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4564:1: ruleJvmWildcardTypeReference returns [EObject current=null] : ( () otherlv_1= '?' ( ( (lv_constraints_2_0= ruleJvmUpperBound ) ) | ( (lv_constraints_3_0= ruleJvmLowerBound ) ) )? ) ;
    public final EObject ruleJvmWildcardTypeReference() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_constraints_2_0 = null;

        EObject lv_constraints_3_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4567:28: ( ( () otherlv_1= '?' ( ( (lv_constraints_2_0= ruleJvmUpperBound ) ) | ( (lv_constraints_3_0= ruleJvmLowerBound ) ) )? ) )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4568:1: ( () otherlv_1= '?' ( ( (lv_constraints_2_0= ruleJvmUpperBound ) ) | ( (lv_constraints_3_0= ruleJvmLowerBound ) ) )? )
            {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4568:1: ( () otherlv_1= '?' ( ( (lv_constraints_2_0= ruleJvmUpperBound ) ) | ( (lv_constraints_3_0= ruleJvmLowerBound ) ) )? )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4568:2: () otherlv_1= '?' ( ( (lv_constraints_2_0= ruleJvmUpperBound ) ) | ( (lv_constraints_3_0= ruleJvmLowerBound ) ) )?
            {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4568:2: ()
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4569:5: 
            {
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getJvmWildcardTypeReferenceAccess().getJvmWildcardTypeReferenceAction_0(),
                          current);
                  
            }

            }

            otherlv_1=(Token)match(input,70,FOLLOW_70_in_ruleJvmWildcardTypeReference10707); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getJvmWildcardTypeReferenceAccess().getQuestionMarkKeyword_1());
                  
            }
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4578:1: ( ( (lv_constraints_2_0= ruleJvmUpperBound ) ) | ( (lv_constraints_3_0= ruleJvmLowerBound ) ) )?
            int alt80=3;
            int LA80_0 = input.LA(1);

            if ( (LA80_0==71) ) {
                alt80=1;
            }
            else if ( (LA80_0==57) ) {
                alt80=2;
            }
            switch (alt80) {
                case 1 :
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4578:2: ( (lv_constraints_2_0= ruleJvmUpperBound ) )
                    {
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4578:2: ( (lv_constraints_2_0= ruleJvmUpperBound ) )
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4579:1: (lv_constraints_2_0= ruleJvmUpperBound )
                    {
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4579:1: (lv_constraints_2_0= ruleJvmUpperBound )
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4580:3: lv_constraints_2_0= ruleJvmUpperBound
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getJvmWildcardTypeReferenceAccess().getConstraintsJvmUpperBoundParserRuleCall_2_0_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleJvmUpperBound_in_ruleJvmWildcardTypeReference10729);
                    lv_constraints_2_0=ruleJvmUpperBound();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getJvmWildcardTypeReferenceRule());
                      	        }
                             		add(
                             			current, 
                             			"constraints",
                              		lv_constraints_2_0, 
                              		"JvmUpperBound");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4597:6: ( (lv_constraints_3_0= ruleJvmLowerBound ) )
                    {
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4597:6: ( (lv_constraints_3_0= ruleJvmLowerBound ) )
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4598:1: (lv_constraints_3_0= ruleJvmLowerBound )
                    {
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4598:1: (lv_constraints_3_0= ruleJvmLowerBound )
                    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4599:3: lv_constraints_3_0= ruleJvmLowerBound
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getJvmWildcardTypeReferenceAccess().getConstraintsJvmLowerBoundParserRuleCall_2_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleJvmLowerBound_in_ruleJvmWildcardTypeReference10756);
                    lv_constraints_3_0=ruleJvmLowerBound();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getJvmWildcardTypeReferenceRule());
                      	        }
                             		add(
                             			current, 
                             			"constraints",
                              		lv_constraints_3_0, 
                              		"JvmLowerBound");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }
                    break;

            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleJvmWildcardTypeReference"


    // $ANTLR start "entryRuleJvmUpperBound"
    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4623:1: entryRuleJvmUpperBound returns [EObject current=null] : iv_ruleJvmUpperBound= ruleJvmUpperBound EOF ;
    public final EObject entryRuleJvmUpperBound() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleJvmUpperBound = null;


        try {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4624:2: (iv_ruleJvmUpperBound= ruleJvmUpperBound EOF )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4625:2: iv_ruleJvmUpperBound= ruleJvmUpperBound EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getJvmUpperBoundRule()); 
            }
            pushFollow(FOLLOW_ruleJvmUpperBound_in_entryRuleJvmUpperBound10794);
            iv_ruleJvmUpperBound=ruleJvmUpperBound();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleJvmUpperBound; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleJvmUpperBound10804); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleJvmUpperBound"


    // $ANTLR start "ruleJvmUpperBound"
    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4632:1: ruleJvmUpperBound returns [EObject current=null] : (otherlv_0= 'extends' ( (lv_typeReference_1_0= ruleJvmTypeReference ) ) ) ;
    public final EObject ruleJvmUpperBound() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        EObject lv_typeReference_1_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4635:28: ( (otherlv_0= 'extends' ( (lv_typeReference_1_0= ruleJvmTypeReference ) ) ) )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4636:1: (otherlv_0= 'extends' ( (lv_typeReference_1_0= ruleJvmTypeReference ) ) )
            {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4636:1: (otherlv_0= 'extends' ( (lv_typeReference_1_0= ruleJvmTypeReference ) ) )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4636:3: otherlv_0= 'extends' ( (lv_typeReference_1_0= ruleJvmTypeReference ) )
            {
            otherlv_0=(Token)match(input,71,FOLLOW_71_in_ruleJvmUpperBound10841); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getJvmUpperBoundAccess().getExtendsKeyword_0());
                  
            }
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4640:1: ( (lv_typeReference_1_0= ruleJvmTypeReference ) )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4641:1: (lv_typeReference_1_0= ruleJvmTypeReference )
            {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4641:1: (lv_typeReference_1_0= ruleJvmTypeReference )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4642:3: lv_typeReference_1_0= ruleJvmTypeReference
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getJvmUpperBoundAccess().getTypeReferenceJvmTypeReferenceParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleJvmTypeReference_in_ruleJvmUpperBound10862);
            lv_typeReference_1_0=ruleJvmTypeReference();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getJvmUpperBoundRule());
              	        }
                     		set(
                     			current, 
                     			"typeReference",
                      		lv_typeReference_1_0, 
                      		"JvmTypeReference");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleJvmUpperBound"


    // $ANTLR start "entryRuleJvmUpperBoundAnded"
    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4666:1: entryRuleJvmUpperBoundAnded returns [EObject current=null] : iv_ruleJvmUpperBoundAnded= ruleJvmUpperBoundAnded EOF ;
    public final EObject entryRuleJvmUpperBoundAnded() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleJvmUpperBoundAnded = null;


        try {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4667:2: (iv_ruleJvmUpperBoundAnded= ruleJvmUpperBoundAnded EOF )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4668:2: iv_ruleJvmUpperBoundAnded= ruleJvmUpperBoundAnded EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getJvmUpperBoundAndedRule()); 
            }
            pushFollow(FOLLOW_ruleJvmUpperBoundAnded_in_entryRuleJvmUpperBoundAnded10898);
            iv_ruleJvmUpperBoundAnded=ruleJvmUpperBoundAnded();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleJvmUpperBoundAnded; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleJvmUpperBoundAnded10908); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleJvmUpperBoundAnded"


    // $ANTLR start "ruleJvmUpperBoundAnded"
    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4675:1: ruleJvmUpperBoundAnded returns [EObject current=null] : (otherlv_0= '&' ( (lv_typeReference_1_0= ruleJvmTypeReference ) ) ) ;
    public final EObject ruleJvmUpperBoundAnded() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        EObject lv_typeReference_1_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4678:28: ( (otherlv_0= '&' ( (lv_typeReference_1_0= ruleJvmTypeReference ) ) ) )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4679:1: (otherlv_0= '&' ( (lv_typeReference_1_0= ruleJvmTypeReference ) ) )
            {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4679:1: (otherlv_0= '&' ( (lv_typeReference_1_0= ruleJvmTypeReference ) ) )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4679:3: otherlv_0= '&' ( (lv_typeReference_1_0= ruleJvmTypeReference ) )
            {
            otherlv_0=(Token)match(input,72,FOLLOW_72_in_ruleJvmUpperBoundAnded10945); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getJvmUpperBoundAndedAccess().getAmpersandKeyword_0());
                  
            }
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4683:1: ( (lv_typeReference_1_0= ruleJvmTypeReference ) )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4684:1: (lv_typeReference_1_0= ruleJvmTypeReference )
            {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4684:1: (lv_typeReference_1_0= ruleJvmTypeReference )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4685:3: lv_typeReference_1_0= ruleJvmTypeReference
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getJvmUpperBoundAndedAccess().getTypeReferenceJvmTypeReferenceParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleJvmTypeReference_in_ruleJvmUpperBoundAnded10966);
            lv_typeReference_1_0=ruleJvmTypeReference();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getJvmUpperBoundAndedRule());
              	        }
                     		set(
                     			current, 
                     			"typeReference",
                      		lv_typeReference_1_0, 
                      		"JvmTypeReference");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleJvmUpperBoundAnded"


    // $ANTLR start "entryRuleJvmLowerBound"
    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4709:1: entryRuleJvmLowerBound returns [EObject current=null] : iv_ruleJvmLowerBound= ruleJvmLowerBound EOF ;
    public final EObject entryRuleJvmLowerBound() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleJvmLowerBound = null;


        try {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4710:2: (iv_ruleJvmLowerBound= ruleJvmLowerBound EOF )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4711:2: iv_ruleJvmLowerBound= ruleJvmLowerBound EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getJvmLowerBoundRule()); 
            }
            pushFollow(FOLLOW_ruleJvmLowerBound_in_entryRuleJvmLowerBound11002);
            iv_ruleJvmLowerBound=ruleJvmLowerBound();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleJvmLowerBound; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleJvmLowerBound11012); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleJvmLowerBound"


    // $ANTLR start "ruleJvmLowerBound"
    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4718:1: ruleJvmLowerBound returns [EObject current=null] : (otherlv_0= 'super' ( (lv_typeReference_1_0= ruleJvmTypeReference ) ) ) ;
    public final EObject ruleJvmLowerBound() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        EObject lv_typeReference_1_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4721:28: ( (otherlv_0= 'super' ( (lv_typeReference_1_0= ruleJvmTypeReference ) ) ) )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4722:1: (otherlv_0= 'super' ( (lv_typeReference_1_0= ruleJvmTypeReference ) ) )
            {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4722:1: (otherlv_0= 'super' ( (lv_typeReference_1_0= ruleJvmTypeReference ) ) )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4722:3: otherlv_0= 'super' ( (lv_typeReference_1_0= ruleJvmTypeReference ) )
            {
            otherlv_0=(Token)match(input,57,FOLLOW_57_in_ruleJvmLowerBound11049); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getJvmLowerBoundAccess().getSuperKeyword_0());
                  
            }
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4726:1: ( (lv_typeReference_1_0= ruleJvmTypeReference ) )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4727:1: (lv_typeReference_1_0= ruleJvmTypeReference )
            {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4727:1: (lv_typeReference_1_0= ruleJvmTypeReference )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4728:3: lv_typeReference_1_0= ruleJvmTypeReference
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getJvmLowerBoundAccess().getTypeReferenceJvmTypeReferenceParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleJvmTypeReference_in_ruleJvmLowerBound11070);
            lv_typeReference_1_0=ruleJvmTypeReference();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getJvmLowerBoundRule());
              	        }
                     		set(
                     			current, 
                     			"typeReference",
                      		lv_typeReference_1_0, 
                      		"JvmTypeReference");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleJvmLowerBound"


    // $ANTLR start "entryRuleValidID"
    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4754:1: entryRuleValidID returns [String current=null] : iv_ruleValidID= ruleValidID EOF ;
    public final String entryRuleValidID() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleValidID = null;


        try {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4755:2: (iv_ruleValidID= ruleValidID EOF )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4756:2: iv_ruleValidID= ruleValidID EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getValidIDRule()); 
            }
            pushFollow(FOLLOW_ruleValidID_in_entryRuleValidID11109);
            iv_ruleValidID=ruleValidID();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleValidID.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleValidID11120); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleValidID"


    // $ANTLR start "ruleValidID"
    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4763:1: ruleValidID returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : this_ID_0= RULE_ID ;
    public final AntlrDatatypeRuleToken ruleValidID() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4766:28: (this_ID_0= RULE_ID )
            // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4767:5: this_ID_0= RULE_ID
            {
            this_ID_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleValidID11159); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              		current.merge(this_ID_0);
                  
            }
            if ( state.backtracking==0 ) {
               
                  newLeafNode(this_ID_0, grammarAccess.getValidIDAccess().getIDTerminalRuleCall()); 
                  
            }

            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleValidID"

    // $ANTLR start synpred1_InternalPureXbase
    public final void synpred1_InternalPureXbase_fragment() throws RecognitionException {   
        // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:355:3: ( ( () ( ( ruleOpMultiAssign ) ) ) )
        // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:355:4: ( () ( ( ruleOpMultiAssign ) ) )
        {
        // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:355:4: ( () ( ( ruleOpMultiAssign ) ) )
        // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:355:5: () ( ( ruleOpMultiAssign ) )
        {
        // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:355:5: ()
        // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:356:1: 
        {
        }

        // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:356:2: ( ( ruleOpMultiAssign ) )
        // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:357:1: ( ruleOpMultiAssign )
        {
        // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:357:1: ( ruleOpMultiAssign )
        // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:358:3: ruleOpMultiAssign
        {
        pushFollow(FOLLOW_ruleOpMultiAssign_in_synpred1_InternalPureXbase782);
        ruleOpMultiAssign();

        state._fsp--;
        if (state.failed) return ;

        }


        }


        }


        }
    }
    // $ANTLR end synpred1_InternalPureXbase

    // $ANTLR start synpred2_InternalPureXbase
    public final void synpred2_InternalPureXbase_fragment() throws RecognitionException {   
        // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:483:3: ( ( () ( ( ruleOpOr ) ) ) )
        // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:483:4: ( () ( ( ruleOpOr ) ) )
        {
        // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:483:4: ( () ( ( ruleOpOr ) ) )
        // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:483:5: () ( ( ruleOpOr ) )
        {
        // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:483:5: ()
        // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:484:1: 
        {
        }

        // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:484:2: ( ( ruleOpOr ) )
        // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:485:1: ( ruleOpOr )
        {
        // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:485:1: ( ruleOpOr )
        // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:486:3: ruleOpOr
        {
        pushFollow(FOLLOW_ruleOpOr_in_synpred2_InternalPureXbase1130);
        ruleOpOr();

        state._fsp--;
        if (state.failed) return ;

        }


        }


        }


        }
    }
    // $ANTLR end synpred2_InternalPureXbase

    // $ANTLR start synpred3_InternalPureXbase
    public final void synpred3_InternalPureXbase_fragment() throws RecognitionException {   
        // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:584:3: ( ( () ( ( ruleOpAnd ) ) ) )
        // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:584:4: ( () ( ( ruleOpAnd ) ) )
        {
        // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:584:4: ( () ( ( ruleOpAnd ) ) )
        // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:584:5: () ( ( ruleOpAnd ) )
        {
        // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:584:5: ()
        // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:585:1: 
        {
        }

        // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:585:2: ( ( ruleOpAnd ) )
        // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:586:1: ( ruleOpAnd )
        {
        // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:586:1: ( ruleOpAnd )
        // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:587:3: ruleOpAnd
        {
        pushFollow(FOLLOW_ruleOpAnd_in_synpred3_InternalPureXbase1389);
        ruleOpAnd();

        state._fsp--;
        if (state.failed) return ;

        }


        }


        }


        }
    }
    // $ANTLR end synpred3_InternalPureXbase

    // $ANTLR start synpred4_InternalPureXbase
    public final void synpred4_InternalPureXbase_fragment() throws RecognitionException {   
        // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:685:3: ( ( () ( ( ruleOpEquality ) ) ) )
        // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:685:4: ( () ( ( ruleOpEquality ) ) )
        {
        // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:685:4: ( () ( ( ruleOpEquality ) ) )
        // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:685:5: () ( ( ruleOpEquality ) )
        {
        // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:685:5: ()
        // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:686:1: 
        {
        }

        // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:686:2: ( ( ruleOpEquality ) )
        // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:687:1: ( ruleOpEquality )
        {
        // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:687:1: ( ruleOpEquality )
        // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:688:3: ruleOpEquality
        {
        pushFollow(FOLLOW_ruleOpEquality_in_synpred4_InternalPureXbase1648);
        ruleOpEquality();

        state._fsp--;
        if (state.failed) return ;

        }


        }


        }


        }
    }
    // $ANTLR end synpred4_InternalPureXbase

    // $ANTLR start synpred5_InternalPureXbase
    public final void synpred5_InternalPureXbase_fragment() throws RecognitionException {   
        // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:793:4: ( ( () 'instanceof' ) )
        // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:793:5: ( () 'instanceof' )
        {
        // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:793:5: ( () 'instanceof' )
        // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:793:6: () 'instanceof'
        {
        // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:793:6: ()
        // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:794:1: 
        {
        }

        match(input,20,FOLLOW_20_in_synpred5_InternalPureXbase1924); if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred5_InternalPureXbase

    // $ANTLR start synpred6_InternalPureXbase
    public final void synpred6_InternalPureXbase_fragment() throws RecognitionException {   
        // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:821:8: ( ( () ( ( ruleOpCompare ) ) ) )
        // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:821:9: ( () ( ( ruleOpCompare ) ) )
        {
        // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:821:9: ( () ( ( ruleOpCompare ) ) )
        // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:821:10: () ( ( ruleOpCompare ) )
        {
        // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:821:10: ()
        // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:822:1: 
        {
        }

        // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:822:2: ( ( ruleOpCompare ) )
        // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:823:1: ( ruleOpCompare )
        {
        // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:823:1: ( ruleOpCompare )
        // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:824:3: ruleOpCompare
        {
        pushFollow(FOLLOW_ruleOpCompare_in_synpred6_InternalPureXbase1997);
        ruleOpCompare();

        state._fsp--;
        if (state.failed) return ;

        }


        }


        }


        }
    }
    // $ANTLR end synpred6_InternalPureXbase

    // $ANTLR start synpred7_InternalPureXbase
    public final void synpred7_InternalPureXbase_fragment() throws RecognitionException {   
        // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:943:3: ( ( () ( ( ruleOpOther ) ) ) )
        // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:943:4: ( () ( ( ruleOpOther ) ) )
        {
        // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:943:4: ( () ( ( ruleOpOther ) ) )
        // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:943:5: () ( ( ruleOpOther ) )
        {
        // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:943:5: ()
        // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:944:1: 
        {
        }

        // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:944:2: ( ( ruleOpOther ) )
        // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:945:1: ( ruleOpOther )
        {
        // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:945:1: ( ruleOpOther )
        // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:946:3: ruleOpOther
        {
        pushFollow(FOLLOW_ruleOpOther_in_synpred7_InternalPureXbase2316);
        ruleOpOther();

        state._fsp--;
        if (state.failed) return ;

        }


        }


        }


        }
    }
    // $ANTLR end synpred7_InternalPureXbase

    // $ANTLR start synpred8_InternalPureXbase
    public final void synpred8_InternalPureXbase_fragment() throws RecognitionException {   
        // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1051:3: ( ( () ( ( ruleOpAdd ) ) ) )
        // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1051:4: ( () ( ( ruleOpAdd ) ) )
        {
        // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1051:4: ( () ( ( ruleOpAdd ) ) )
        // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1051:5: () ( ( ruleOpAdd ) )
        {
        // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1051:5: ()
        // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1052:1: 
        {
        }

        // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1052:2: ( ( ruleOpAdd ) )
        // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1053:1: ( ruleOpAdd )
        {
        // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1053:1: ( ruleOpAdd )
        // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1054:3: ruleOpAdd
        {
        pushFollow(FOLLOW_ruleOpAdd_in_synpred8_InternalPureXbase2596);
        ruleOpAdd();

        state._fsp--;
        if (state.failed) return ;

        }


        }


        }


        }
    }
    // $ANTLR end synpred8_InternalPureXbase

    // $ANTLR start synpred9_InternalPureXbase
    public final void synpred9_InternalPureXbase_fragment() throws RecognitionException {   
        // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1159:3: ( ( () ( ( ruleOpMulti ) ) ) )
        // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1159:4: ( () ( ( ruleOpMulti ) ) )
        {
        // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1159:4: ( () ( ( ruleOpMulti ) ) )
        // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1159:5: () ( ( ruleOpMulti ) )
        {
        // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1159:5: ()
        // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1160:1: 
        {
        }

        // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1160:2: ( ( ruleOpMulti ) )
        // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1161:1: ( ruleOpMulti )
        {
        // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1161:1: ( ruleOpMulti )
        // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1162:3: ruleOpMulti
        {
        pushFollow(FOLLOW_ruleOpMulti_in_synpred9_InternalPureXbase2876);
        ruleOpMulti();

        state._fsp--;
        if (state.failed) return ;

        }


        }


        }


        }
    }
    // $ANTLR end synpred9_InternalPureXbase

    // $ANTLR start synpred10_InternalPureXbase
    public final void synpred10_InternalPureXbase_fragment() throws RecognitionException {   
        // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1392:3: ( ( () 'as' ) )
        // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1392:4: ( () 'as' )
        {
        // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1392:4: ( () 'as' )
        // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1392:5: () 'as'
        {
        // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1392:5: ()
        // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1393:1: 
        {
        }

        match(input,34,FOLLOW_34_in_synpred10_InternalPureXbase3470); if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred10_InternalPureXbase

    // $ANTLR start synpred11_InternalPureXbase
    public final void synpred11_InternalPureXbase_fragment() throws RecognitionException {   
        // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1452:4: ( ( () '.' ( ( ruleValidID ) ) ruleOpSingleAssign ) )
        // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1452:5: ( () '.' ( ( ruleValidID ) ) ruleOpSingleAssign )
        {
        // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1452:5: ( () '.' ( ( ruleValidID ) ) ruleOpSingleAssign )
        // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1452:6: () '.' ( ( ruleValidID ) ) ruleOpSingleAssign
        {
        // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1452:6: ()
        // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1453:1: 
        {
        }

        match(input,35,FOLLOW_35_in_synpred11_InternalPureXbase3624); if (state.failed) return ;
        // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1454:1: ( ( ruleValidID ) )
        // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1455:1: ( ruleValidID )
        {
        // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1455:1: ( ruleValidID )
        // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1456:3: ruleValidID
        {
        pushFollow(FOLLOW_ruleValidID_in_synpred11_InternalPureXbase3633);
        ruleValidID();

        state._fsp--;
        if (state.failed) return ;

        }


        }

        pushFollow(FOLLOW_ruleOpSingleAssign_in_synpred11_InternalPureXbase3639);
        ruleOpSingleAssign();

        state._fsp--;
        if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred11_InternalPureXbase

    // $ANTLR start synpred12_InternalPureXbase
    public final void synpred12_InternalPureXbase_fragment() throws RecognitionException {   
        // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1510:8: ( ( () ( '.' | ( ( '?.' ) ) | ( ( '*.' ) ) ) ) )
        // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1510:9: ( () ( '.' | ( ( '?.' ) ) | ( ( '*.' ) ) ) )
        {
        // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1510:9: ( () ( '.' | ( ( '?.' ) ) | ( ( '*.' ) ) ) )
        // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1510:10: () ( '.' | ( ( '?.' ) ) | ( ( '*.' ) ) )
        {
        // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1510:10: ()
        // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1511:1: 
        {
        }

        // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1511:2: ( '.' | ( ( '?.' ) ) | ( ( '*.' ) ) )
        int alt81=3;
        switch ( input.LA(1) ) {
        case 35:
            {
            alt81=1;
            }
            break;
        case 36:
            {
            alt81=2;
            }
            break;
        case 37:
            {
            alt81=3;
            }
            break;
        default:
            if (state.backtracking>0) {state.failed=true; return ;}
            NoViableAltException nvae =
                new NoViableAltException("", 81, 0, input);

            throw nvae;
        }

        switch (alt81) {
            case 1 :
                // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1511:4: '.'
                {
                match(input,35,FOLLOW_35_in_synpred12_InternalPureXbase3742); if (state.failed) return ;

                }
                break;
            case 2 :
                // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1513:6: ( ( '?.' ) )
                {
                // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1513:6: ( ( '?.' ) )
                // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1514:1: ( '?.' )
                {
                // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1514:1: ( '?.' )
                // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1515:2: '?.'
                {
                match(input,36,FOLLOW_36_in_synpred12_InternalPureXbase3756); if (state.failed) return ;

                }


                }


                }
                break;
            case 3 :
                // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1520:6: ( ( '*.' ) )
                {
                // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1520:6: ( ( '*.' ) )
                // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1521:1: ( '*.' )
                {
                // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1521:1: ( '*.' )
                // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1522:2: '*.'
                {
                match(input,37,FOLLOW_37_in_synpred12_InternalPureXbase3776); if (state.failed) return ;

                }


                }


                }
                break;

        }


        }


        }
    }
    // $ANTLR end synpred12_InternalPureXbase

    // $ANTLR start synpred13_InternalPureXbase
    public final void synpred13_InternalPureXbase_fragment() throws RecognitionException {   
        // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1631:4: ( ( '(' ) )
        // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1632:1: ( '(' )
        {
        // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1632:1: ( '(' )
        // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1633:2: '('
        {
        match(input,39,FOLLOW_39_in_synpred13_InternalPureXbase4003); if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred13_InternalPureXbase

    // $ANTLR start synpred14_InternalPureXbase
    public final void synpred14_InternalPureXbase_fragment() throws RecognitionException {   
        // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1652:4: ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )
        // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1652:5: ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) )
        {
        // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1652:5: ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) )
        // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1652:6: () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) )
        {
        // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1652:6: ()
        // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1653:1: 
        {
        }

        // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1653:2: ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )?
        int alt83=2;
        int LA83_0 = input.LA(1);

        if ( (LA83_0==RULE_ID||LA83_0==39||LA83_0==69) ) {
            alt83=1;
        }
        switch (alt83) {
            case 1 :
                // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1653:3: ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )*
                {
                // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1653:3: ( ( ruleJvmFormalParameter ) )
                // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1654:1: ( ruleJvmFormalParameter )
                {
                // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1654:1: ( ruleJvmFormalParameter )
                // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1655:1: ruleJvmFormalParameter
                {
                pushFollow(FOLLOW_ruleJvmFormalParameter_in_synpred14_InternalPureXbase4055);
                ruleJvmFormalParameter();

                state._fsp--;
                if (state.failed) return ;

                }


                }

                // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1657:2: ( ',' ( ( ruleJvmFormalParameter ) ) )*
                loop82:
                do {
                    int alt82=2;
                    int LA82_0 = input.LA(1);

                    if ( (LA82_0==38) ) {
                        alt82=1;
                    }


                    switch (alt82) {
                	case 1 :
                	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1657:4: ',' ( ( ruleJvmFormalParameter ) )
                	    {
                	    match(input,38,FOLLOW_38_in_synpred14_InternalPureXbase4062); if (state.failed) return ;
                	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1658:1: ( ( ruleJvmFormalParameter ) )
                	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1659:1: ( ruleJvmFormalParameter )
                	    {
                	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1659:1: ( ruleJvmFormalParameter )
                	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1660:1: ruleJvmFormalParameter
                	    {
                	    pushFollow(FOLLOW_ruleJvmFormalParameter_in_synpred14_InternalPureXbase4069);
                	    ruleJvmFormalParameter();

                	    state._fsp--;
                	    if (state.failed) return ;

                	    }


                	    }


                	    }
                	    break;

                	default :
                	    break loop82;
                    }
                } while (true);


                }
                break;

        }

        // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1662:6: ( ( '|' ) )
        // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1663:1: ( '|' )
        {
        // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1663:1: ( '|' )
        // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1664:2: '|'
        {
        match(input,42,FOLLOW_42_in_synpred14_InternalPureXbase4083); if (state.failed) return ;

        }


        }


        }


        }
    }
    // $ANTLR end synpred14_InternalPureXbase

    // $ANTLR start synpred15_InternalPureXbase
    public final void synpred15_InternalPureXbase_fragment() throws RecognitionException {   
        // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1731:4: ( ( ruleXClosure ) )
        // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1732:1: ( ruleXClosure )
        {
        // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1732:1: ( ruleXClosure )
        // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:1733:1: ruleXClosure
        {
        pushFollow(FOLLOW_ruleXClosure_in_synpred15_InternalPureXbase4201);
        ruleXClosure();

        state._fsp--;
        if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred15_InternalPureXbase

    // $ANTLR start synpred16_InternalPureXbase
    public final void synpred16_InternalPureXbase_fragment() throws RecognitionException {   
        // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2014:2: ( ( ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )
        // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2014:3: ( ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) )
        {
        // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2014:3: ( ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) )
        // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2014:4: ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) )
        {
        // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2014:4: ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )?
        int alt85=2;
        int LA85_0 = input.LA(1);

        if ( (LA85_0==RULE_ID||LA85_0==39||LA85_0==69) ) {
            alt85=1;
        }
        switch (alt85) {
            case 1 :
                // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2014:5: ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )*
                {
                // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2014:5: ( ( ruleJvmFormalParameter ) )
                // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2015:1: ( ruleJvmFormalParameter )
                {
                // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2015:1: ( ruleJvmFormalParameter )
                // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2016:1: ruleJvmFormalParameter
                {
                pushFollow(FOLLOW_ruleJvmFormalParameter_in_synpred16_InternalPureXbase4974);
                ruleJvmFormalParameter();

                state._fsp--;
                if (state.failed) return ;

                }


                }

                // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2018:2: ( ',' ( ( ruleJvmFormalParameter ) ) )*
                loop84:
                do {
                    int alt84=2;
                    int LA84_0 = input.LA(1);

                    if ( (LA84_0==38) ) {
                        alt84=1;
                    }


                    switch (alt84) {
                	case 1 :
                	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2018:4: ',' ( ( ruleJvmFormalParameter ) )
                	    {
                	    match(input,38,FOLLOW_38_in_synpred16_InternalPureXbase4981); if (state.failed) return ;
                	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2019:1: ( ( ruleJvmFormalParameter ) )
                	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2020:1: ( ruleJvmFormalParameter )
                	    {
                	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2020:1: ( ruleJvmFormalParameter )
                	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2021:1: ruleJvmFormalParameter
                	    {
                	    pushFollow(FOLLOW_ruleJvmFormalParameter_in_synpred16_InternalPureXbase4988);
                	    ruleJvmFormalParameter();

                	    state._fsp--;
                	    if (state.failed) return ;

                	    }


                	    }


                	    }
                	    break;

                	default :
                	    break loop84;
                    }
                } while (true);


                }
                break;

        }

        // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2023:6: ( ( '|' ) )
        // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2024:1: ( '|' )
        {
        // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2024:1: ( '|' )
        // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2025:2: '|'
        {
        match(input,42,FOLLOW_42_in_synpred16_InternalPureXbase5002); if (state.failed) return ;

        }


        }


        }


        }
    }
    // $ANTLR end synpred16_InternalPureXbase

    // $ANTLR start synpred18_InternalPureXbase
    public final void synpred18_InternalPureXbase_fragment() throws RecognitionException {   
        // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2384:4: ( 'else' )
        // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2384:6: 'else'
        {
        match(input,45,FOLLOW_45_in_synpred18_InternalPureXbase5785); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred18_InternalPureXbase

    // $ANTLR start synpred19_InternalPureXbase
    public final void synpred19_InternalPureXbase_fragment() throws RecognitionException {   
        // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2438:2: ( ( ( ( ruleValidID ) ) ':' ) )
        // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2438:3: ( ( ( ruleValidID ) ) ':' )
        {
        // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2438:3: ( ( ( ruleValidID ) ) ':' )
        // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2438:4: ( ( ruleValidID ) ) ':'
        {
        // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2438:4: ( ( ruleValidID ) )
        // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2439:1: ( ruleValidID )
        {
        // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2439:1: ( ruleValidID )
        // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:2440:1: ruleValidID
        {
        pushFollow(FOLLOW_ruleValidID_in_synpred19_InternalPureXbase5925);
        ruleValidID();

        state._fsp--;
        if (state.failed) return ;

        }


        }

        match(input,47,FOLLOW_47_in_synpred19_InternalPureXbase5931); if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred19_InternalPureXbase

    // $ANTLR start synpred20_InternalPureXbase
    public final void synpred20_InternalPureXbase_fragment() throws RecognitionException {   
        // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3013:4: ( ( ( ( ruleJvmTypeReference ) ) ( ( ruleValidID ) ) ) )
        // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3013:5: ( ( ( ruleJvmTypeReference ) ) ( ( ruleValidID ) ) )
        {
        // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3013:5: ( ( ( ruleJvmTypeReference ) ) ( ( ruleValidID ) ) )
        // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3013:6: ( ( ruleJvmTypeReference ) ) ( ( ruleValidID ) )
        {
        // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3013:6: ( ( ruleJvmTypeReference ) )
        // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3014:1: ( ruleJvmTypeReference )
        {
        // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3014:1: ( ruleJvmTypeReference )
        // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3015:1: ruleJvmTypeReference
        {
        pushFollow(FOLLOW_ruleJvmTypeReference_in_synpred20_InternalPureXbase7171);
        ruleJvmTypeReference();

        state._fsp--;
        if (state.failed) return ;

        }


        }

        // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3017:2: ( ( ruleValidID ) )
        // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3018:1: ( ruleValidID )
        {
        // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3018:1: ( ruleValidID )
        // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3019:1: ruleValidID
        {
        pushFollow(FOLLOW_ruleValidID_in_synpred20_InternalPureXbase7180);
        ruleValidID();

        state._fsp--;
        if (state.failed) return ;

        }


        }


        }


        }
    }
    // $ANTLR end synpred20_InternalPureXbase

    // $ANTLR start synpred21_InternalPureXbase
    public final void synpred21_InternalPureXbase_fragment() throws RecognitionException {   
        // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3317:4: ( ( '(' ) )
        // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3318:1: ( '(' )
        {
        // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3318:1: ( '(' )
        // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3319:2: '('
        {
        match(input,39,FOLLOW_39_in_synpred21_InternalPureXbase7742); if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred21_InternalPureXbase

    // $ANTLR start synpred22_InternalPureXbase
    public final void synpred22_InternalPureXbase_fragment() throws RecognitionException {   
        // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3338:4: ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )
        // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3338:5: ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) )
        {
        // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3338:5: ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) )
        // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3338:6: () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) )
        {
        // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3338:6: ()
        // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3339:1: 
        {
        }

        // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3339:2: ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )?
        int alt89=2;
        int LA89_0 = input.LA(1);

        if ( (LA89_0==RULE_ID||LA89_0==39||LA89_0==69) ) {
            alt89=1;
        }
        switch (alt89) {
            case 1 :
                // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3339:3: ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )*
                {
                // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3339:3: ( ( ruleJvmFormalParameter ) )
                // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3340:1: ( ruleJvmFormalParameter )
                {
                // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3340:1: ( ruleJvmFormalParameter )
                // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3341:1: ruleJvmFormalParameter
                {
                pushFollow(FOLLOW_ruleJvmFormalParameter_in_synpred22_InternalPureXbase7794);
                ruleJvmFormalParameter();

                state._fsp--;
                if (state.failed) return ;

                }


                }

                // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3343:2: ( ',' ( ( ruleJvmFormalParameter ) ) )*
                loop88:
                do {
                    int alt88=2;
                    int LA88_0 = input.LA(1);

                    if ( (LA88_0==38) ) {
                        alt88=1;
                    }


                    switch (alt88) {
                	case 1 :
                	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3343:4: ',' ( ( ruleJvmFormalParameter ) )
                	    {
                	    match(input,38,FOLLOW_38_in_synpred22_InternalPureXbase7801); if (state.failed) return ;
                	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3344:1: ( ( ruleJvmFormalParameter ) )
                	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3345:1: ( ruleJvmFormalParameter )
                	    {
                	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3345:1: ( ruleJvmFormalParameter )
                	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3346:1: ruleJvmFormalParameter
                	    {
                	    pushFollow(FOLLOW_ruleJvmFormalParameter_in_synpred22_InternalPureXbase7808);
                	    ruleJvmFormalParameter();

                	    state._fsp--;
                	    if (state.failed) return ;

                	    }


                	    }


                	    }
                	    break;

                	default :
                	    break loop88;
                    }
                } while (true);


                }
                break;

        }

        // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3348:6: ( ( '|' ) )
        // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3349:1: ( '|' )
        {
        // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3349:1: ( '|' )
        // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3350:2: '|'
        {
        match(input,42,FOLLOW_42_in_synpred22_InternalPureXbase7822); if (state.failed) return ;

        }


        }


        }


        }
    }
    // $ANTLR end synpred22_InternalPureXbase

    // $ANTLR start synpred23_InternalPureXbase
    public final void synpred23_InternalPureXbase_fragment() throws RecognitionException {   
        // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3417:4: ( ( ruleXClosure ) )
        // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3418:1: ( ruleXClosure )
        {
        // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3418:1: ( ruleXClosure )
        // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3419:1: ruleXClosure
        {
        pushFollow(FOLLOW_ruleXClosure_in_synpred23_InternalPureXbase7940);
        ruleXClosure();

        state._fsp--;
        if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred23_InternalPureXbase

    // $ANTLR start synpred24_InternalPureXbase
    public final void synpred24_InternalPureXbase_fragment() throws RecognitionException {   
        // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3614:3: ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )
        // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3614:4: ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) )
        {
        // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3614:4: ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) )
        // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3614:5: () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) )
        {
        // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3614:5: ()
        // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3615:1: 
        {
        }

        // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3615:2: ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )?
        int alt91=2;
        int LA91_0 = input.LA(1);

        if ( (LA91_0==RULE_ID||LA91_0==39||LA91_0==69) ) {
            alt91=1;
        }
        switch (alt91) {
            case 1 :
                // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3615:3: ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )*
                {
                // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3615:3: ( ( ruleJvmFormalParameter ) )
                // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3616:1: ( ruleJvmFormalParameter )
                {
                // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3616:1: ( ruleJvmFormalParameter )
                // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3617:1: ruleJvmFormalParameter
                {
                pushFollow(FOLLOW_ruleJvmFormalParameter_in_synpred24_InternalPureXbase8431);
                ruleJvmFormalParameter();

                state._fsp--;
                if (state.failed) return ;

                }


                }

                // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3619:2: ( ',' ( ( ruleJvmFormalParameter ) ) )*
                loop90:
                do {
                    int alt90=2;
                    int LA90_0 = input.LA(1);

                    if ( (LA90_0==38) ) {
                        alt90=1;
                    }


                    switch (alt90) {
                	case 1 :
                	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3619:4: ',' ( ( ruleJvmFormalParameter ) )
                	    {
                	    match(input,38,FOLLOW_38_in_synpred24_InternalPureXbase8438); if (state.failed) return ;
                	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3620:1: ( ( ruleJvmFormalParameter ) )
                	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3621:1: ( ruleJvmFormalParameter )
                	    {
                	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3621:1: ( ruleJvmFormalParameter )
                	    // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3622:1: ruleJvmFormalParameter
                	    {
                	    pushFollow(FOLLOW_ruleJvmFormalParameter_in_synpred24_InternalPureXbase8445);
                	    ruleJvmFormalParameter();

                	    state._fsp--;
                	    if (state.failed) return ;

                	    }


                	    }


                	    }
                	    break;

                	default :
                	    break loop90;
                    }
                } while (true);


                }
                break;

        }

        // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3624:6: ( ( '|' ) )
        // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3625:1: ( '|' )
        {
        // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3625:1: ( '|' )
        // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3626:2: '|'
        {
        match(input,42,FOLLOW_42_in_synpred24_InternalPureXbase8459); if (state.failed) return ;

        }


        }


        }


        }
    }
    // $ANTLR end synpred24_InternalPureXbase

    // $ANTLR start synpred25_InternalPureXbase
    public final void synpred25_InternalPureXbase_fragment() throws RecognitionException {   
        // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3693:2: ( ( ruleXClosure ) )
        // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3694:1: ( ruleXClosure )
        {
        // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3694:1: ( ruleXClosure )
        // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:3695:1: ruleXClosure
        {
        pushFollow(FOLLOW_ruleXClosure_in_synpred25_InternalPureXbase8575);
        ruleXClosure();

        state._fsp--;
        if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred25_InternalPureXbase

    // $ANTLR start synpred26_InternalPureXbase
    public final void synpred26_InternalPureXbase_fragment() throws RecognitionException {   
        // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4017:2: ( ( ruleXExpression ) )
        // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4018:1: ( ruleXExpression )
        {
        // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4018:1: ( ruleXExpression )
        // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4019:1: ruleXExpression
        {
        pushFollow(FOLLOW_ruleXExpression_in_synpred26_InternalPureXbase9378);
        ruleXExpression();

        state._fsp--;
        if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred26_InternalPureXbase

    // $ANTLR start synpred27_InternalPureXbase
    public final void synpred27_InternalPureXbase_fragment() throws RecognitionException {   
        // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4088:5: ( 'catch' )
        // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4088:7: 'catch'
        {
        match(input,68,FOLLOW_68_in_synpred27_InternalPureXbase9523); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred27_InternalPureXbase

    // $ANTLR start synpred28_InternalPureXbase
    public final void synpred28_InternalPureXbase_fragment() throws RecognitionException {   
        // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4107:5: ( 'finally' )
        // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4107:7: 'finally'
        {
        match(input,67,FOLLOW_67_in_synpred28_InternalPureXbase9553); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred28_InternalPureXbase

    // $ANTLR start synpred30_InternalPureXbase
    public final void synpred30_InternalPureXbase_fragment() throws RecognitionException {   
        // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4255:3: ( '.' )
        // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4256:2: '.'
        {
        match(input,35,FOLLOW_35_in_synpred30_InternalPureXbase9900); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred30_InternalPureXbase

    // $ANTLR start synpred31_InternalPureXbase
    public final void synpred31_InternalPureXbase_fragment() throws RecognitionException {   
        // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4304:2: ( ( () '[' ']' ) )
        // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4304:3: ( () '[' ']' )
        {
        // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4304:3: ( () '[' ']' )
        // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4304:4: () '[' ']'
        {
        // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4304:4: ()
        // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4305:1: 
        {
        }

        match(input,41,FOLLOW_41_in_synpred31_InternalPureXbase10052); if (state.failed) return ;
        match(input,43,FOLLOW_43_in_synpred31_InternalPureXbase10056); if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred31_InternalPureXbase

    // $ANTLR start synpred32_InternalPureXbase
    public final void synpred32_InternalPureXbase_fragment() throws RecognitionException {   
        // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4458:4: ( '<' )
        // ../org.eclipse.xtext.purexbase/src-gen/org/eclipse/xtext/purexbase/parser/antlr/internal/InternalPureXbase.g:4458:6: '<'
        {
        match(input,24,FOLLOW_24_in_synpred32_InternalPureXbase10416); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred32_InternalPureXbase

    // Delegated rules

    public final boolean synpred31_InternalPureXbase() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred31_InternalPureXbase_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred32_InternalPureXbase() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred32_InternalPureXbase_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred13_InternalPureXbase() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred13_InternalPureXbase_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred15_InternalPureXbase() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred15_InternalPureXbase_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred11_InternalPureXbase() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred11_InternalPureXbase_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred20_InternalPureXbase() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred20_InternalPureXbase_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred3_InternalPureXbase() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred3_InternalPureXbase_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred19_InternalPureXbase() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred19_InternalPureXbase_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred23_InternalPureXbase() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred23_InternalPureXbase_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred26_InternalPureXbase() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred26_InternalPureXbase_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred18_InternalPureXbase() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred18_InternalPureXbase_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred12_InternalPureXbase() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred12_InternalPureXbase_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred27_InternalPureXbase() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred27_InternalPureXbase_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred22_InternalPureXbase() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred22_InternalPureXbase_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred1_InternalPureXbase() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred1_InternalPureXbase_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred14_InternalPureXbase() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred14_InternalPureXbase_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred10_InternalPureXbase() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred10_InternalPureXbase_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred6_InternalPureXbase() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred6_InternalPureXbase_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred25_InternalPureXbase() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred25_InternalPureXbase_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred8_InternalPureXbase() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred8_InternalPureXbase_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred21_InternalPureXbase() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred21_InternalPureXbase_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred28_InternalPureXbase() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred28_InternalPureXbase_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred7_InternalPureXbase() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred7_InternalPureXbase_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred9_InternalPureXbase() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred9_InternalPureXbase_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred5_InternalPureXbase() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred5_InternalPureXbase_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred4_InternalPureXbase() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred4_InternalPureXbase_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred24_InternalPureXbase() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred24_InternalPureXbase_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred2_InternalPureXbase() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred2_InternalPureXbase_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred30_InternalPureXbase() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred30_InternalPureXbase_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred16_InternalPureXbase() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred16_InternalPureXbase_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }


    protected DFA27 dfa27 = new DFA27(this);
    protected DFA26 dfa26 = new DFA26(this);
    protected DFA28 dfa28 = new DFA28(this);
    protected DFA34 dfa34 = new DFA34(this);
    protected DFA57 dfa57 = new DFA57(this);
    protected DFA56 dfa56 = new DFA56(this);
    protected DFA58 dfa58 = new DFA58(this);
    protected DFA64 dfa64 = new DFA64(this);
    protected DFA65 dfa65 = new DFA65(this);
    protected DFA67 dfa67 = new DFA67(this);
    protected DFA78 dfa78 = new DFA78(this);
    static final String DFA27_eotS =
        "\75\uffff";
    static final String DFA27_eofS =
        "\1\2\74\uffff";
    static final String DFA27_minS =
        "\1\4\1\0\73\uffff";
    static final String DFA27_maxS =
        "\1\105\1\0\73\uffff";
    static final String DFA27_acceptS =
        "\2\uffff\1\2\71\uffff\1\1";
    static final String DFA27_specialS =
        "\1\uffff\1\0\73\uffff}>";
    static final String[] DFA27_transitionS = {
            "\3\2\4\uffff\2\2\2\uffff\30\2\1\1\2\2\1\uffff\17\2\1\uffff\13"+
            "\2",
            "\1\uffff",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            ""
    };

    static final short[] DFA27_eot = DFA.unpackEncodedString(DFA27_eotS);
    static final short[] DFA27_eof = DFA.unpackEncodedString(DFA27_eofS);
    static final char[] DFA27_min = DFA.unpackEncodedStringToUnsignedChars(DFA27_minS);
    static final char[] DFA27_max = DFA.unpackEncodedStringToUnsignedChars(DFA27_maxS);
    static final short[] DFA27_accept = DFA.unpackEncodedString(DFA27_acceptS);
    static final short[] DFA27_special = DFA.unpackEncodedString(DFA27_specialS);
    static final short[][] DFA27_transition;

    static {
        int numStates = DFA27_transitionS.length;
        DFA27_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA27_transition[i] = DFA.unpackEncodedString(DFA27_transitionS[i]);
        }
    }

    class DFA27 extends DFA {

        public DFA27(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 27;
            this.eot = DFA27_eot;
            this.eof = DFA27_eof;
            this.min = DFA27_min;
            this.max = DFA27_max;
            this.accept = DFA27_accept;
            this.special = DFA27_special;
            this.transition = DFA27_transition;
        }
        public String getDescription() {
            return "1631:2: ( ( ( ( '(' ) )=> (lv_explicitOperationCall_16_0= '(' ) ) ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> (lv_memberCallArguments_17_0= ruleXShortClosure ) ) | ( ( (lv_memberCallArguments_18_0= ruleXExpression ) ) (otherlv_19= ',' ( (lv_memberCallArguments_20_0= ruleXExpression ) ) )* ) )? otherlv_21= ')' )?";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA27_1 = input.LA(1);

                         
                        int index27_1 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred13_InternalPureXbase()) ) {s = 60;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index27_1);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 27, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String DFA26_eotS =
        "\34\uffff";
    static final String DFA26_eofS =
        "\34\uffff";
    static final String DFA26_minS =
        "\1\4\2\0\31\uffff";
    static final String DFA26_maxS =
        "\1\105\2\0\31\uffff";
    static final String DFA26_acceptS =
        "\3\uffff\2\1\1\2\25\uffff\1\3";
    static final String DFA26_specialS =
        "\1\0\1\1\1\2\31\uffff}>";
    static final String[] DFA26_transitionS = {
            "\2\5\1\1\21\uffff\1\5\2\uffff\2\5\4\uffff\1\5\5\uffff\1\2\1"+
            "\33\1\5\1\4\1\uffff\1\5\1\uffff\1\5\1\uffff\1\5\3\uffff\3\5"+
            "\2\uffff\1\5\1\uffff\10\5\2\uffff\1\3",
            "\1\uffff",
            "\1\uffff",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            ""
    };

    static final short[] DFA26_eot = DFA.unpackEncodedString(DFA26_eotS);
    static final short[] DFA26_eof = DFA.unpackEncodedString(DFA26_eofS);
    static final char[] DFA26_min = DFA.unpackEncodedStringToUnsignedChars(DFA26_minS);
    static final char[] DFA26_max = DFA.unpackEncodedStringToUnsignedChars(DFA26_maxS);
    static final short[] DFA26_accept = DFA.unpackEncodedString(DFA26_acceptS);
    static final short[] DFA26_special = DFA.unpackEncodedString(DFA26_specialS);
    static final short[][] DFA26_transition;

    static {
        int numStates = DFA26_transitionS.length;
        DFA26_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA26_transition[i] = DFA.unpackEncodedString(DFA26_transitionS[i]);
        }
    }

    class DFA26 extends DFA {

        public DFA26(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 26;
            this.eot = DFA26_eot;
            this.eof = DFA26_eof;
            this.min = DFA26_min;
            this.max = DFA26_max;
            this.accept = DFA26_accept;
            this.special = DFA26_special;
            this.transition = DFA26_transition;
        }
        public String getDescription() {
            return "1652:2: ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> (lv_memberCallArguments_17_0= ruleXShortClosure ) ) | ( ( (lv_memberCallArguments_18_0= ruleXExpression ) ) (otherlv_19= ',' ( (lv_memberCallArguments_20_0= ruleXExpression ) ) )* ) )?";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA26_0 = input.LA(1);

                         
                        int index26_0 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA26_0==RULE_ID) ) {s = 1;}

                        else if ( (LA26_0==39) ) {s = 2;}

                        else if ( (LA26_0==69) && (synpred14_InternalPureXbase())) {s = 3;}

                        else if ( (LA26_0==42) && (synpred14_InternalPureXbase())) {s = 4;}

                        else if ( ((LA26_0>=RULE_INT && LA26_0<=RULE_STRING)||LA26_0==24||(LA26_0>=27 && LA26_0<=28)||LA26_0==33||LA26_0==41||LA26_0==44||LA26_0==46||LA26_0==48||(LA26_0>=52 && LA26_0<=54)||LA26_0==57||(LA26_0>=59 && LA26_0<=66)) ) {s = 5;}

                        else if ( (LA26_0==40) ) {s = 27;}

                         
                        input.seek(index26_0);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA26_1 = input.LA(1);

                         
                        int index26_1 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred14_InternalPureXbase()) ) {s = 4;}

                        else if ( (true) ) {s = 5;}

                         
                        input.seek(index26_1);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA26_2 = input.LA(1);

                         
                        int index26_2 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred14_InternalPureXbase()) ) {s = 4;}

                        else if ( (true) ) {s = 5;}

                         
                        input.seek(index26_2);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 26, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String DFA28_eotS =
        "\75\uffff";
    static final String DFA28_eofS =
        "\1\2\74\uffff";
    static final String DFA28_minS =
        "\1\4\1\0\73\uffff";
    static final String DFA28_maxS =
        "\1\105\1\0\73\uffff";
    static final String DFA28_acceptS =
        "\2\uffff\1\2\71\uffff\1\1";
    static final String DFA28_specialS =
        "\1\uffff\1\0\73\uffff}>";
    static final String[] DFA28_transitionS = {
            "\3\2\4\uffff\2\2\2\uffff\32\2\1\1\1\uffff\17\2\1\uffff\13\2",
            "\1\uffff",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            ""
    };

    static final short[] DFA28_eot = DFA.unpackEncodedString(DFA28_eotS);
    static final short[] DFA28_eof = DFA.unpackEncodedString(DFA28_eofS);
    static final char[] DFA28_min = DFA.unpackEncodedStringToUnsignedChars(DFA28_minS);
    static final char[] DFA28_max = DFA.unpackEncodedStringToUnsignedChars(DFA28_maxS);
    static final short[] DFA28_accept = DFA.unpackEncodedString(DFA28_acceptS);
    static final short[] DFA28_special = DFA.unpackEncodedString(DFA28_specialS);
    static final short[][] DFA28_transition;

    static {
        int numStates = DFA28_transitionS.length;
        DFA28_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA28_transition[i] = DFA.unpackEncodedString(DFA28_transitionS[i]);
        }
    }

    class DFA28 extends DFA {

        public DFA28(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 28;
            this.eot = DFA28_eot;
            this.eof = DFA28_eof;
            this.min = DFA28_min;
            this.max = DFA28_max;
            this.accept = DFA28_accept;
            this.special = DFA28_special;
            this.transition = DFA28_transition;
        }
        public String getDescription() {
            return "1731:3: ( ( ( ruleXClosure ) )=> (lv_memberCallArguments_22_0= ruleXClosure ) )?";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA28_1 = input.LA(1);

                         
                        int index28_1 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred15_InternalPureXbase()) ) {s = 60;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index28_1);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 28, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String DFA34_eotS =
        "\36\uffff";
    static final String DFA34_eofS =
        "\36\uffff";
    static final String DFA34_minS =
        "\1\4\2\0\33\uffff";
    static final String DFA34_maxS =
        "\1\105\2\0\33\uffff";
    static final String DFA34_acceptS =
        "\3\uffff\2\1\1\2\30\uffff";
    static final String DFA34_specialS =
        "\1\0\1\1\1\2\33\uffff}>";
    static final String[] DFA34_transitionS = {
            "\2\5\1\1\21\uffff\1\5\2\uffff\2\5\4\uffff\1\5\5\uffff\1\2\1"+
            "\uffff\1\5\1\4\2\5\1\uffff\1\5\1\uffff\1\5\3\uffff\6\5\1\uffff"+
            "\10\5\2\uffff\1\3",
            "\1\uffff",
            "\1\uffff",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            ""
    };

    static final short[] DFA34_eot = DFA.unpackEncodedString(DFA34_eotS);
    static final short[] DFA34_eof = DFA.unpackEncodedString(DFA34_eofS);
    static final char[] DFA34_min = DFA.unpackEncodedStringToUnsignedChars(DFA34_minS);
    static final char[] DFA34_max = DFA.unpackEncodedStringToUnsignedChars(DFA34_maxS);
    static final short[] DFA34_accept = DFA.unpackEncodedString(DFA34_acceptS);
    static final short[] DFA34_special = DFA.unpackEncodedString(DFA34_specialS);
    static final short[][] DFA34_transition;

    static {
        int numStates = DFA34_transitionS.length;
        DFA34_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA34_transition[i] = DFA.unpackEncodedString(DFA34_transitionS[i]);
        }
    }

    class DFA34 extends DFA {

        public DFA34(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 34;
            this.eot = DFA34_eot;
            this.eof = DFA34_eof;
            this.min = DFA34_min;
            this.max = DFA34_max;
            this.accept = DFA34_accept;
            this.special = DFA34_special;
            this.transition = DFA34_transition;
        }
        public String getDescription() {
            return "2014:1: ( ( ( ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> ( ( ( (lv_declaredFormalParameters_2_0= ruleJvmFormalParameter ) ) (otherlv_3= ',' ( (lv_declaredFormalParameters_4_0= ruleJvmFormalParameter ) ) )* )? ( (lv_explicitSyntax_5_0= '|' ) ) ) )?";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA34_0 = input.LA(1);

                         
                        int index34_0 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA34_0==RULE_ID) ) {s = 1;}

                        else if ( (LA34_0==39) ) {s = 2;}

                        else if ( (LA34_0==69) && (synpred16_InternalPureXbase())) {s = 3;}

                        else if ( (LA34_0==42) && (synpred16_InternalPureXbase())) {s = 4;}

                        else if ( ((LA34_0>=RULE_INT && LA34_0<=RULE_STRING)||LA34_0==24||(LA34_0>=27 && LA34_0<=28)||LA34_0==33||LA34_0==41||(LA34_0>=43 && LA34_0<=44)||LA34_0==46||LA34_0==48||(LA34_0>=52 && LA34_0<=57)||(LA34_0>=59 && LA34_0<=66)) ) {s = 5;}

                         
                        input.seek(index34_0);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA34_1 = input.LA(1);

                         
                        int index34_1 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred16_InternalPureXbase()) ) {s = 4;}

                        else if ( (true) ) {s = 5;}

                         
                        input.seek(index34_1);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA34_2 = input.LA(1);

                         
                        int index34_2 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred16_InternalPureXbase()) ) {s = 4;}

                        else if ( (true) ) {s = 5;}

                         
                        input.seek(index34_2);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 34, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String DFA57_eotS =
        "\75\uffff";
    static final String DFA57_eofS =
        "\1\2\74\uffff";
    static final String DFA57_minS =
        "\1\4\1\0\73\uffff";
    static final String DFA57_maxS =
        "\1\105\1\0\73\uffff";
    static final String DFA57_acceptS =
        "\2\uffff\1\2\71\uffff\1\1";
    static final String DFA57_specialS =
        "\1\uffff\1\0\73\uffff}>";
    static final String[] DFA57_transitionS = {
            "\3\2\4\uffff\2\2\2\uffff\30\2\1\1\2\2\1\uffff\17\2\1\uffff\13"+
            "\2",
            "\1\uffff",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            ""
    };

    static final short[] DFA57_eot = DFA.unpackEncodedString(DFA57_eotS);
    static final short[] DFA57_eof = DFA.unpackEncodedString(DFA57_eofS);
    static final char[] DFA57_min = DFA.unpackEncodedStringToUnsignedChars(DFA57_minS);
    static final char[] DFA57_max = DFA.unpackEncodedStringToUnsignedChars(DFA57_maxS);
    static final short[] DFA57_accept = DFA.unpackEncodedString(DFA57_acceptS);
    static final short[] DFA57_special = DFA.unpackEncodedString(DFA57_specialS);
    static final short[][] DFA57_transition;

    static {
        int numStates = DFA57_transitionS.length;
        DFA57_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA57_transition[i] = DFA.unpackEncodedString(DFA57_transitionS[i]);
        }
    }

    class DFA57 extends DFA {

        public DFA57(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 57;
            this.eot = DFA57_eot;
            this.eof = DFA57_eof;
            this.min = DFA57_min;
            this.max = DFA57_max;
            this.accept = DFA57_accept;
            this.special = DFA57_special;
            this.transition = DFA57_transition;
        }
        public String getDescription() {
            return "3317:2: ( ( ( ( '(' ) )=> (lv_explicitOperationCall_8_0= '(' ) ) ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> (lv_featureCallArguments_9_0= ruleXShortClosure ) ) | ( ( (lv_featureCallArguments_10_0= ruleXExpression ) ) (otherlv_11= ',' ( (lv_featureCallArguments_12_0= ruleXExpression ) ) )* ) )? otherlv_13= ')' )?";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA57_1 = input.LA(1);

                         
                        int index57_1 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred21_InternalPureXbase()) ) {s = 60;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index57_1);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 57, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String DFA56_eotS =
        "\34\uffff";
    static final String DFA56_eofS =
        "\34\uffff";
    static final String DFA56_minS =
        "\1\4\2\0\31\uffff";
    static final String DFA56_maxS =
        "\1\105\2\0\31\uffff";
    static final String DFA56_acceptS =
        "\3\uffff\2\1\1\2\25\uffff\1\3";
    static final String DFA56_specialS =
        "\1\0\1\1\1\2\31\uffff}>";
    static final String[] DFA56_transitionS = {
            "\2\5\1\1\21\uffff\1\5\2\uffff\2\5\4\uffff\1\5\5\uffff\1\2\1"+
            "\33\1\5\1\4\1\uffff\1\5\1\uffff\1\5\1\uffff\1\5\3\uffff\3\5"+
            "\2\uffff\1\5\1\uffff\10\5\2\uffff\1\3",
            "\1\uffff",
            "\1\uffff",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            ""
    };

    static final short[] DFA56_eot = DFA.unpackEncodedString(DFA56_eotS);
    static final short[] DFA56_eof = DFA.unpackEncodedString(DFA56_eofS);
    static final char[] DFA56_min = DFA.unpackEncodedStringToUnsignedChars(DFA56_minS);
    static final char[] DFA56_max = DFA.unpackEncodedStringToUnsignedChars(DFA56_maxS);
    static final short[] DFA56_accept = DFA.unpackEncodedString(DFA56_acceptS);
    static final short[] DFA56_special = DFA.unpackEncodedString(DFA56_specialS);
    static final short[][] DFA56_transition;

    static {
        int numStates = DFA56_transitionS.length;
        DFA56_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA56_transition[i] = DFA.unpackEncodedString(DFA56_transitionS[i]);
        }
    }

    class DFA56 extends DFA {

        public DFA56(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 56;
            this.eot = DFA56_eot;
            this.eof = DFA56_eof;
            this.min = DFA56_min;
            this.max = DFA56_max;
            this.accept = DFA56_accept;
            this.special = DFA56_special;
            this.transition = DFA56_transition;
        }
        public String getDescription() {
            return "3338:2: ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> (lv_featureCallArguments_9_0= ruleXShortClosure ) ) | ( ( (lv_featureCallArguments_10_0= ruleXExpression ) ) (otherlv_11= ',' ( (lv_featureCallArguments_12_0= ruleXExpression ) ) )* ) )?";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA56_0 = input.LA(1);

                         
                        int index56_0 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA56_0==RULE_ID) ) {s = 1;}

                        else if ( (LA56_0==39) ) {s = 2;}

                        else if ( (LA56_0==69) && (synpred22_InternalPureXbase())) {s = 3;}

                        else if ( (LA56_0==42) && (synpred22_InternalPureXbase())) {s = 4;}

                        else if ( ((LA56_0>=RULE_INT && LA56_0<=RULE_STRING)||LA56_0==24||(LA56_0>=27 && LA56_0<=28)||LA56_0==33||LA56_0==41||LA56_0==44||LA56_0==46||LA56_0==48||(LA56_0>=52 && LA56_0<=54)||LA56_0==57||(LA56_0>=59 && LA56_0<=66)) ) {s = 5;}

                        else if ( (LA56_0==40) ) {s = 27;}

                         
                        input.seek(index56_0);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA56_1 = input.LA(1);

                         
                        int index56_1 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred22_InternalPureXbase()) ) {s = 4;}

                        else if ( (true) ) {s = 5;}

                         
                        input.seek(index56_1);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA56_2 = input.LA(1);

                         
                        int index56_2 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred22_InternalPureXbase()) ) {s = 4;}

                        else if ( (true) ) {s = 5;}

                         
                        input.seek(index56_2);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 56, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String DFA58_eotS =
        "\75\uffff";
    static final String DFA58_eofS =
        "\1\2\74\uffff";
    static final String DFA58_minS =
        "\1\4\1\0\73\uffff";
    static final String DFA58_maxS =
        "\1\105\1\0\73\uffff";
    static final String DFA58_acceptS =
        "\2\uffff\1\2\71\uffff\1\1";
    static final String DFA58_specialS =
        "\1\uffff\1\0\73\uffff}>";
    static final String[] DFA58_transitionS = {
            "\3\2\4\uffff\2\2\2\uffff\32\2\1\1\1\uffff\17\2\1\uffff\13\2",
            "\1\uffff",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            ""
    };

    static final short[] DFA58_eot = DFA.unpackEncodedString(DFA58_eotS);
    static final short[] DFA58_eof = DFA.unpackEncodedString(DFA58_eofS);
    static final char[] DFA58_min = DFA.unpackEncodedStringToUnsignedChars(DFA58_minS);
    static final char[] DFA58_max = DFA.unpackEncodedStringToUnsignedChars(DFA58_maxS);
    static final short[] DFA58_accept = DFA.unpackEncodedString(DFA58_acceptS);
    static final short[] DFA58_special = DFA.unpackEncodedString(DFA58_specialS);
    static final short[][] DFA58_transition;

    static {
        int numStates = DFA58_transitionS.length;
        DFA58_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA58_transition[i] = DFA.unpackEncodedString(DFA58_transitionS[i]);
        }
    }

    class DFA58 extends DFA {

        public DFA58(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 58;
            this.eot = DFA58_eot;
            this.eof = DFA58_eof;
            this.min = DFA58_min;
            this.max = DFA58_max;
            this.accept = DFA58_accept;
            this.special = DFA58_special;
            this.transition = DFA58_transition;
        }
        public String getDescription() {
            return "3417:3: ( ( ( ruleXClosure ) )=> (lv_featureCallArguments_14_0= ruleXClosure ) )?";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA58_1 = input.LA(1);

                         
                        int index58_1 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred23_InternalPureXbase()) ) {s = 60;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index58_1);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 58, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String DFA64_eotS =
        "\34\uffff";
    static final String DFA64_eofS =
        "\34\uffff";
    static final String DFA64_minS =
        "\1\4\2\0\31\uffff";
    static final String DFA64_maxS =
        "\1\105\2\0\31\uffff";
    static final String DFA64_acceptS =
        "\3\uffff\2\1\1\2\25\uffff\1\3";
    static final String DFA64_specialS =
        "\1\0\1\1\1\2\31\uffff}>";
    static final String[] DFA64_transitionS = {
            "\2\5\1\1\21\uffff\1\5\2\uffff\2\5\4\uffff\1\5\5\uffff\1\2\1"+
            "\33\1\5\1\4\1\uffff\1\5\1\uffff\1\5\1\uffff\1\5\3\uffff\3\5"+
            "\2\uffff\1\5\1\uffff\10\5\2\uffff\1\3",
            "\1\uffff",
            "\1\uffff",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            ""
    };

    static final short[] DFA64_eot = DFA.unpackEncodedString(DFA64_eotS);
    static final short[] DFA64_eof = DFA.unpackEncodedString(DFA64_eofS);
    static final char[] DFA64_min = DFA.unpackEncodedStringToUnsignedChars(DFA64_minS);
    static final char[] DFA64_max = DFA.unpackEncodedStringToUnsignedChars(DFA64_maxS);
    static final short[] DFA64_accept = DFA.unpackEncodedString(DFA64_acceptS);
    static final short[] DFA64_special = DFA.unpackEncodedString(DFA64_specialS);
    static final short[][] DFA64_transition;

    static {
        int numStates = DFA64_transitionS.length;
        DFA64_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA64_transition[i] = DFA.unpackEncodedString(DFA64_transitionS[i]);
        }
    }

    class DFA64 extends DFA {

        public DFA64(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 64;
            this.eot = DFA64_eot;
            this.eof = DFA64_eof;
            this.min = DFA64_min;
            this.max = DFA64_max;
            this.accept = DFA64_accept;
            this.special = DFA64_special;
            this.transition = DFA64_transition;
        }
        public String getDescription() {
            return "3614:1: ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> (lv_arguments_9_0= ruleXShortClosure ) ) | ( ( (lv_arguments_10_0= ruleXExpression ) ) (otherlv_11= ',' ( (lv_arguments_12_0= ruleXExpression ) ) )* ) )?";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA64_0 = input.LA(1);

                         
                        int index64_0 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA64_0==RULE_ID) ) {s = 1;}

                        else if ( (LA64_0==39) ) {s = 2;}

                        else if ( (LA64_0==69) && (synpred24_InternalPureXbase())) {s = 3;}

                        else if ( (LA64_0==42) && (synpred24_InternalPureXbase())) {s = 4;}

                        else if ( ((LA64_0>=RULE_INT && LA64_0<=RULE_STRING)||LA64_0==24||(LA64_0>=27 && LA64_0<=28)||LA64_0==33||LA64_0==41||LA64_0==44||LA64_0==46||LA64_0==48||(LA64_0>=52 && LA64_0<=54)||LA64_0==57||(LA64_0>=59 && LA64_0<=66)) ) {s = 5;}

                        else if ( (LA64_0==40) ) {s = 27;}

                         
                        input.seek(index64_0);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA64_1 = input.LA(1);

                         
                        int index64_1 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred24_InternalPureXbase()) ) {s = 4;}

                        else if ( (true) ) {s = 5;}

                         
                        input.seek(index64_1);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA64_2 = input.LA(1);

                         
                        int index64_2 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred24_InternalPureXbase()) ) {s = 4;}

                        else if ( (true) ) {s = 5;}

                         
                        input.seek(index64_2);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 64, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String DFA65_eotS =
        "\75\uffff";
    static final String DFA65_eofS =
        "\1\2\74\uffff";
    static final String DFA65_minS =
        "\1\4\1\0\73\uffff";
    static final String DFA65_maxS =
        "\1\105\1\0\73\uffff";
    static final String DFA65_acceptS =
        "\2\uffff\1\2\71\uffff\1\1";
    static final String DFA65_specialS =
        "\1\uffff\1\0\73\uffff}>";
    static final String[] DFA65_transitionS = {
            "\3\2\4\uffff\2\2\2\uffff\32\2\1\1\1\uffff\17\2\1\uffff\13\2",
            "\1\uffff",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            ""
    };

    static final short[] DFA65_eot = DFA.unpackEncodedString(DFA65_eotS);
    static final short[] DFA65_eof = DFA.unpackEncodedString(DFA65_eofS);
    static final char[] DFA65_min = DFA.unpackEncodedStringToUnsignedChars(DFA65_minS);
    static final char[] DFA65_max = DFA.unpackEncodedStringToUnsignedChars(DFA65_maxS);
    static final short[] DFA65_accept = DFA.unpackEncodedString(DFA65_acceptS);
    static final short[] DFA65_special = DFA.unpackEncodedString(DFA65_specialS);
    static final short[][] DFA65_transition;

    static {
        int numStates = DFA65_transitionS.length;
        DFA65_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA65_transition[i] = DFA.unpackEncodedString(DFA65_transitionS[i]);
        }
    }

    class DFA65 extends DFA {

        public DFA65(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 65;
            this.eot = DFA65_eot;
            this.eof = DFA65_eof;
            this.min = DFA65_min;
            this.max = DFA65_max;
            this.accept = DFA65_accept;
            this.special = DFA65_special;
            this.transition = DFA65_transition;
        }
        public String getDescription() {
            return "3693:1: ( ( ( ruleXClosure ) )=> (lv_arguments_14_0= ruleXClosure ) )?";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA65_1 = input.LA(1);

                         
                        int index65_1 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred25_InternalPureXbase()) ) {s = 60;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index65_1);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 65, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String DFA67_eotS =
        "\75\uffff";
    static final String DFA67_eofS =
        "\1\31\74\uffff";
    static final String DFA67_minS =
        "\1\4\30\0\44\uffff";
    static final String DFA67_maxS =
        "\1\105\30\0\44\uffff";
    static final String DFA67_acceptS =
        "\31\uffff\1\2\42\uffff\1\1";
    static final String DFA67_specialS =
        "\1\uffff\1\0\1\1\1\2\1\3\1\4\1\5\1\6\1\7\1\10\1\11\1\12\1\13\1\14"+
        "\1\15\1\16\1\17\1\20\1\21\1\22\1\23\1\24\1\25\1\26\1\27\44\uffff}>";
    static final String[] DFA67_transitionS = {
            "\1\15\1\17\1\1\4\uffff\2\31\2\uffff\11\31\1\10\2\31\1\4\1\3"+
            "\4\31\1\2\5\31\1\30\1\31\1\12\1\uffff\1\31\1\21\1\31\1\7\1\31"+
            "\1\6\3\31\1\22\1\23\1\24\2\31\1\11\1\uffff\1\5\1\13\1\14\1\16"+
            "\1\20\1\25\1\26\1\27\3\31",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            ""
    };

    static final short[] DFA67_eot = DFA.unpackEncodedString(DFA67_eotS);
    static final short[] DFA67_eof = DFA.unpackEncodedString(DFA67_eofS);
    static final char[] DFA67_min = DFA.unpackEncodedStringToUnsignedChars(DFA67_minS);
    static final char[] DFA67_max = DFA.unpackEncodedStringToUnsignedChars(DFA67_maxS);
    static final short[] DFA67_accept = DFA.unpackEncodedString(DFA67_acceptS);
    static final short[] DFA67_special = DFA.unpackEncodedString(DFA67_specialS);
    static final short[][] DFA67_transition;

    static {
        int numStates = DFA67_transitionS.length;
        DFA67_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA67_transition[i] = DFA.unpackEncodedString(DFA67_transitionS[i]);
        }
    }

    class DFA67 extends DFA {

        public DFA67(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 67;
            this.eot = DFA67_eot;
            this.eof = DFA67_eof;
            this.min = DFA67_min;
            this.max = DFA67_max;
            this.accept = DFA67_accept;
            this.special = DFA67_special;
            this.transition = DFA67_transition;
        }
        public String getDescription() {
            return "4017:1: ( ( ( ruleXExpression ) )=> (lv_expression_2_0= ruleXExpression ) )?";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA67_1 = input.LA(1);

                         
                        int index67_1 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred26_InternalPureXbase()) ) {s = 60;}

                        else if ( (true) ) {s = 25;}

                         
                        input.seek(index67_1);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA67_2 = input.LA(1);

                         
                        int index67_2 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred26_InternalPureXbase()) ) {s = 60;}

                        else if ( (true) ) {s = 25;}

                         
                        input.seek(index67_2);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA67_3 = input.LA(1);

                         
                        int index67_3 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred26_InternalPureXbase()) ) {s = 60;}

                        else if ( (true) ) {s = 25;}

                         
                        input.seek(index67_3);
                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA67_4 = input.LA(1);

                         
                        int index67_4 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred26_InternalPureXbase()) ) {s = 60;}

                        else if ( (true) ) {s = 25;}

                         
                        input.seek(index67_4);
                        if ( s>=0 ) return s;
                        break;
                    case 4 : 
                        int LA67_5 = input.LA(1);

                         
                        int index67_5 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred26_InternalPureXbase()) ) {s = 60;}

                        else if ( (true) ) {s = 25;}

                         
                        input.seek(index67_5);
                        if ( s>=0 ) return s;
                        break;
                    case 5 : 
                        int LA67_6 = input.LA(1);

                         
                        int index67_6 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred26_InternalPureXbase()) ) {s = 60;}

                        else if ( (true) ) {s = 25;}

                         
                        input.seek(index67_6);
                        if ( s>=0 ) return s;
                        break;
                    case 6 : 
                        int LA67_7 = input.LA(1);

                         
                        int index67_7 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred26_InternalPureXbase()) ) {s = 60;}

                        else if ( (true) ) {s = 25;}

                         
                        input.seek(index67_7);
                        if ( s>=0 ) return s;
                        break;
                    case 7 : 
                        int LA67_8 = input.LA(1);

                         
                        int index67_8 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred26_InternalPureXbase()) ) {s = 60;}

                        else if ( (true) ) {s = 25;}

                         
                        input.seek(index67_8);
                        if ( s>=0 ) return s;
                        break;
                    case 8 : 
                        int LA67_9 = input.LA(1);

                         
                        int index67_9 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred26_InternalPureXbase()) ) {s = 60;}

                        else if ( (true) ) {s = 25;}

                         
                        input.seek(index67_9);
                        if ( s>=0 ) return s;
                        break;
                    case 9 : 
                        int LA67_10 = input.LA(1);

                         
                        int index67_10 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred26_InternalPureXbase()) ) {s = 60;}

                        else if ( (true) ) {s = 25;}

                         
                        input.seek(index67_10);
                        if ( s>=0 ) return s;
                        break;
                    case 10 : 
                        int LA67_11 = input.LA(1);

                         
                        int index67_11 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred26_InternalPureXbase()) ) {s = 60;}

                        else if ( (true) ) {s = 25;}

                         
                        input.seek(index67_11);
                        if ( s>=0 ) return s;
                        break;
                    case 11 : 
                        int LA67_12 = input.LA(1);

                         
                        int index67_12 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred26_InternalPureXbase()) ) {s = 60;}

                        else if ( (true) ) {s = 25;}

                         
                        input.seek(index67_12);
                        if ( s>=0 ) return s;
                        break;
                    case 12 : 
                        int LA67_13 = input.LA(1);

                         
                        int index67_13 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred26_InternalPureXbase()) ) {s = 60;}

                        else if ( (true) ) {s = 25;}

                         
                        input.seek(index67_13);
                        if ( s>=0 ) return s;
                        break;
                    case 13 : 
                        int LA67_14 = input.LA(1);

                         
                        int index67_14 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred26_InternalPureXbase()) ) {s = 60;}

                        else if ( (true) ) {s = 25;}

                         
                        input.seek(index67_14);
                        if ( s>=0 ) return s;
                        break;
                    case 14 : 
                        int LA67_15 = input.LA(1);

                         
                        int index67_15 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred26_InternalPureXbase()) ) {s = 60;}

                        else if ( (true) ) {s = 25;}

                         
                        input.seek(index67_15);
                        if ( s>=0 ) return s;
                        break;
                    case 15 : 
                        int LA67_16 = input.LA(1);

                         
                        int index67_16 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred26_InternalPureXbase()) ) {s = 60;}

                        else if ( (true) ) {s = 25;}

                         
                        input.seek(index67_16);
                        if ( s>=0 ) return s;
                        break;
                    case 16 : 
                        int LA67_17 = input.LA(1);

                         
                        int index67_17 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred26_InternalPureXbase()) ) {s = 60;}

                        else if ( (true) ) {s = 25;}

                         
                        input.seek(index67_17);
                        if ( s>=0 ) return s;
                        break;
                    case 17 : 
                        int LA67_18 = input.LA(1);

                         
                        int index67_18 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred26_InternalPureXbase()) ) {s = 60;}

                        else if ( (true) ) {s = 25;}

                         
                        input.seek(index67_18);
                        if ( s>=0 ) return s;
                        break;
                    case 18 : 
                        int LA67_19 = input.LA(1);

                         
                        int index67_19 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred26_InternalPureXbase()) ) {s = 60;}

                        else if ( (true) ) {s = 25;}

                         
                        input.seek(index67_19);
                        if ( s>=0 ) return s;
                        break;
                    case 19 : 
                        int LA67_20 = input.LA(1);

                         
                        int index67_20 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred26_InternalPureXbase()) ) {s = 60;}

                        else if ( (true) ) {s = 25;}

                         
                        input.seek(index67_20);
                        if ( s>=0 ) return s;
                        break;
                    case 20 : 
                        int LA67_21 = input.LA(1);

                         
                        int index67_21 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred26_InternalPureXbase()) ) {s = 60;}

                        else if ( (true) ) {s = 25;}

                         
                        input.seek(index67_21);
                        if ( s>=0 ) return s;
                        break;
                    case 21 : 
                        int LA67_22 = input.LA(1);

                         
                        int index67_22 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred26_InternalPureXbase()) ) {s = 60;}

                        else if ( (true) ) {s = 25;}

                         
                        input.seek(index67_22);
                        if ( s>=0 ) return s;
                        break;
                    case 22 : 
                        int LA67_23 = input.LA(1);

                         
                        int index67_23 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred26_InternalPureXbase()) ) {s = 60;}

                        else if ( (true) ) {s = 25;}

                         
                        input.seek(index67_23);
                        if ( s>=0 ) return s;
                        break;
                    case 23 : 
                        int LA67_24 = input.LA(1);

                         
                        int index67_24 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred26_InternalPureXbase()) ) {s = 60;}

                        else if ( (true) ) {s = 25;}

                         
                        input.seek(index67_24);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 67, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String DFA78_eotS =
        "\75\uffff";
    static final String DFA78_eofS =
        "\1\2\74\uffff";
    static final String DFA78_minS =
        "\1\4\1\0\73\uffff";
    static final String DFA78_maxS =
        "\1\105\1\0\73\uffff";
    static final String DFA78_acceptS =
        "\2\uffff\1\2\71\uffff\1\1";
    static final String DFA78_specialS =
        "\1\uffff\1\0\73\uffff}>";
    static final String[] DFA78_transitionS = {
            "\3\2\4\uffff\2\2\2\uffff\11\2\1\1\21\2\1\uffff\17\2\1\uffff"+
            "\13\2",
            "\1\uffff",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            ""
    };

    static final short[] DFA78_eot = DFA.unpackEncodedString(DFA78_eotS);
    static final short[] DFA78_eof = DFA.unpackEncodedString(DFA78_eofS);
    static final char[] DFA78_min = DFA.unpackEncodedStringToUnsignedChars(DFA78_minS);
    static final char[] DFA78_max = DFA.unpackEncodedStringToUnsignedChars(DFA78_maxS);
    static final short[] DFA78_accept = DFA.unpackEncodedString(DFA78_acceptS);
    static final short[] DFA78_special = DFA.unpackEncodedString(DFA78_specialS);
    static final short[][] DFA78_transition;

    static {
        int numStates = DFA78_transitionS.length;
        DFA78_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA78_transition[i] = DFA.unpackEncodedString(DFA78_transitionS[i]);
        }
    }

    class DFA78 extends DFA {

        public DFA78(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 78;
            this.eot = DFA78_eot;
            this.eof = DFA78_eof;
            this.min = DFA78_min;
            this.max = DFA78_max;
            this.accept = DFA78_accept;
            this.special = DFA78_special;
            this.transition = DFA78_transition;
        }
        public String getDescription() {
            return "4458:2: ( ( ( '<' )=>otherlv_1= '<' ) ( (lv_arguments_2_0= ruleJvmArgumentTypeReference ) ) (otherlv_3= ',' ( (lv_arguments_4_0= ruleJvmArgumentTypeReference ) ) )* otherlv_5= '>' )?";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA78_1 = input.LA(1);

                         
                        int index78_1 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred32_InternalPureXbase()) ) {s = 60;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index78_1);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 78, _s, input);
            error(nvae);
            throw nvae;
        }
    }
 

    public static final BitSet FOLLOW_ruleModel_in_entryRuleModel75 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleModel85 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSpecialBlockExpression_in_ruleModel130 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSpecialBlockExpression_in_entryRuleSpecialBlockExpression165 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleSpecialBlockExpression175 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXExpressionInsideBlock_in_ruleSpecialBlockExpression232 = new BitSet(new long[]{0xFBF1528219001872L,0x0000000000000007L});
    public static final BitSet FOLLOW_ruleImport_in_ruleSpecialBlockExpression259 = new BitSet(new long[]{0xFBF1528219001872L,0x0000000000000007L});
    public static final BitSet FOLLOW_11_in_ruleSpecialBlockExpression273 = new BitSet(new long[]{0xFBF1528219001872L,0x0000000000000007L});
    public static final BitSet FOLLOW_ruleImport_in_entryRuleImport313 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleImport323 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_12_in_ruleImport360 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_ruleQualifiedNameWithWildCard_in_ruleImport381 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualifiedNameWithWildCard_in_entryRuleQualifiedNameWithWildCard418 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleQualifiedNameWithWildCard429 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_ruleQualifiedNameWithWildCard476 = new BitSet(new long[]{0x0000000000002002L});
    public static final BitSet FOLLOW_13_in_ruleQualifiedNameWithWildCard495 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXExpression_in_entryRuleXExpression537 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXExpression547 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXAssignment_in_ruleXExpression593 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXAssignment_in_entryRuleXAssignment627 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXAssignment637 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleValidID_in_ruleXAssignment695 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_ruleOpSingleAssign_in_ruleXAssignment711 = new BitSet(new long[]{0xFBF1528219000070L,0x0000000000000007L});
    public static final BitSet FOLLOW_ruleXAssignment_in_ruleXAssignment731 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXOrExpression_in_ruleXAssignment761 = new BitSet(new long[]{0x0000000000008002L});
    public static final BitSet FOLLOW_ruleOpMultiAssign_in_ruleXAssignment814 = new BitSet(new long[]{0xFBF1528219000070L,0x0000000000000007L});
    public static final BitSet FOLLOW_ruleXAssignment_in_ruleXAssignment837 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleOpSingleAssign_in_entryRuleOpSingleAssign877 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleOpSingleAssign888 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_14_in_ruleOpSingleAssign925 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleOpMultiAssign_in_entryRuleOpMultiAssign965 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleOpMultiAssign976 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_15_in_ruleOpMultiAssign1013 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXOrExpression_in_entryRuleXOrExpression1052 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXOrExpression1062 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXAndExpression_in_ruleXOrExpression1109 = new BitSet(new long[]{0x0000000000010002L});
    public static final BitSet FOLLOW_ruleOpOr_in_ruleXOrExpression1162 = new BitSet(new long[]{0xFBF1528219000070L,0x0000000000000007L});
    public static final BitSet FOLLOW_ruleXAndExpression_in_ruleXOrExpression1185 = new BitSet(new long[]{0x0000000000010002L});
    public static final BitSet FOLLOW_ruleOpOr_in_entryRuleOpOr1224 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleOpOr1235 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_16_in_ruleOpOr1272 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXAndExpression_in_entryRuleXAndExpression1311 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXAndExpression1321 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXEqualityExpression_in_ruleXAndExpression1368 = new BitSet(new long[]{0x0000000000020002L});
    public static final BitSet FOLLOW_ruleOpAnd_in_ruleXAndExpression1421 = new BitSet(new long[]{0xFBF1528219000070L,0x0000000000000007L});
    public static final BitSet FOLLOW_ruleXEqualityExpression_in_ruleXAndExpression1444 = new BitSet(new long[]{0x0000000000020002L});
    public static final BitSet FOLLOW_ruleOpAnd_in_entryRuleOpAnd1483 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleOpAnd1494 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_17_in_ruleOpAnd1531 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXEqualityExpression_in_entryRuleXEqualityExpression1570 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXEqualityExpression1580 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXRelationalExpression_in_ruleXEqualityExpression1627 = new BitSet(new long[]{0x00000000000C0002L});
    public static final BitSet FOLLOW_ruleOpEquality_in_ruleXEqualityExpression1680 = new BitSet(new long[]{0xFBF1528219000070L,0x0000000000000007L});
    public static final BitSet FOLLOW_ruleXRelationalExpression_in_ruleXEqualityExpression1703 = new BitSet(new long[]{0x00000000000C0002L});
    public static final BitSet FOLLOW_ruleOpEquality_in_entryRuleOpEquality1742 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleOpEquality1753 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_18_in_ruleOpEquality1791 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_19_in_ruleOpEquality1810 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXRelationalExpression_in_entryRuleXRelationalExpression1850 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXRelationalExpression1860 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXOtherOperatorExpression_in_ruleXRelationalExpression1907 = new BitSet(new long[]{0x0000000001F00002L});
    public static final BitSet FOLLOW_20_in_ruleXRelationalExpression1943 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_ruleXRelationalExpression1968 = new BitSet(new long[]{0x0000000001F00002L});
    public static final BitSet FOLLOW_ruleOpCompare_in_ruleXRelationalExpression2029 = new BitSet(new long[]{0xFBF1528219000070L,0x0000000000000007L});
    public static final BitSet FOLLOW_ruleXOtherOperatorExpression_in_ruleXRelationalExpression2052 = new BitSet(new long[]{0x0000000001F00002L});
    public static final BitSet FOLLOW_ruleOpCompare_in_entryRuleOpCompare2092 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleOpCompare2103 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_21_in_ruleOpCompare2141 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_22_in_ruleOpCompare2160 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_23_in_ruleOpCompare2179 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_24_in_ruleOpCompare2198 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXOtherOperatorExpression_in_entryRuleXOtherOperatorExpression2238 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXOtherOperatorExpression2248 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXAdditiveExpression_in_ruleXOtherOperatorExpression2295 = new BitSet(new long[]{0x0000000006000002L});
    public static final BitSet FOLLOW_ruleOpOther_in_ruleXOtherOperatorExpression2348 = new BitSet(new long[]{0xFBF1528219000070L,0x0000000000000007L});
    public static final BitSet FOLLOW_ruleXAdditiveExpression_in_ruleXOtherOperatorExpression2371 = new BitSet(new long[]{0x0000000006000002L});
    public static final BitSet FOLLOW_ruleOpOther_in_entryRuleOpOther2410 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleOpOther2421 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_25_in_ruleOpOther2459 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_26_in_ruleOpOther2478 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXAdditiveExpression_in_entryRuleXAdditiveExpression2518 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXAdditiveExpression2528 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXMultiplicativeExpression_in_ruleXAdditiveExpression2575 = new BitSet(new long[]{0x0000000018000002L});
    public static final BitSet FOLLOW_ruleOpAdd_in_ruleXAdditiveExpression2628 = new BitSet(new long[]{0xFBF1528219000070L,0x0000000000000007L});
    public static final BitSet FOLLOW_ruleXMultiplicativeExpression_in_ruleXAdditiveExpression2651 = new BitSet(new long[]{0x0000000018000002L});
    public static final BitSet FOLLOW_ruleOpAdd_in_entryRuleOpAdd2690 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleOpAdd2701 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_27_in_ruleOpAdd2739 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_28_in_ruleOpAdd2758 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXMultiplicativeExpression_in_entryRuleXMultiplicativeExpression2798 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXMultiplicativeExpression2808 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXUnaryOperation_in_ruleXMultiplicativeExpression2855 = new BitSet(new long[]{0x00000001E0000002L});
    public static final BitSet FOLLOW_ruleOpMulti_in_ruleXMultiplicativeExpression2908 = new BitSet(new long[]{0xFBF1528219000070L,0x0000000000000007L});
    public static final BitSet FOLLOW_ruleXUnaryOperation_in_ruleXMultiplicativeExpression2931 = new BitSet(new long[]{0x00000001E0000002L});
    public static final BitSet FOLLOW_ruleOpMulti_in_entryRuleOpMulti2970 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleOpMulti2981 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_29_in_ruleOpMulti3019 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_30_in_ruleOpMulti3038 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_31_in_ruleOpMulti3057 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_32_in_ruleOpMulti3076 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXUnaryOperation_in_entryRuleXUnaryOperation3116 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXUnaryOperation3126 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleOpUnary_in_ruleXUnaryOperation3184 = new BitSet(new long[]{0xFBF1528219000070L,0x0000000000000007L});
    public static final BitSet FOLLOW_ruleXCastedExpression_in_ruleXUnaryOperation3205 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXCastedExpression_in_ruleXUnaryOperation3234 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleOpUnary_in_entryRuleOpUnary3270 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleOpUnary3281 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_33_in_ruleOpUnary3319 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_28_in_ruleOpUnary3338 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_27_in_ruleOpUnary3357 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXCastedExpression_in_entryRuleXCastedExpression3397 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXCastedExpression3407 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXMemberFeatureCall_in_ruleXCastedExpression3454 = new BitSet(new long[]{0x0000000400000002L});
    public static final BitSet FOLLOW_34_in_ruleXCastedExpression3489 = new BitSet(new long[]{0x0000008000000040L,0x0000000000000020L});
    public static final BitSet FOLLOW_ruleJvmTypeReference_in_ruleXCastedExpression3512 = new BitSet(new long[]{0x0000000400000002L});
    public static final BitSet FOLLOW_ruleXMemberFeatureCall_in_entryRuleXMemberFeatureCall3550 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXMemberFeatureCall3560 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXPrimaryExpression_in_ruleXMemberFeatureCall3607 = new BitSet(new long[]{0x0000003800000002L});
    public static final BitSet FOLLOW_35_in_ruleXMemberFeatureCall3656 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_ruleValidID_in_ruleXMemberFeatureCall3679 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_ruleOpSingleAssign_in_ruleXMemberFeatureCall3695 = new BitSet(new long[]{0xFBF1528219000070L,0x0000000000000007L});
    public static final BitSet FOLLOW_ruleXAssignment_in_ruleXMemberFeatureCall3717 = new BitSet(new long[]{0x0000003800000002L});
    public static final BitSet FOLLOW_35_in_ruleXMemberFeatureCall3803 = new BitSet(new long[]{0x0000000001000040L});
    public static final BitSet FOLLOW_36_in_ruleXMemberFeatureCall3827 = new BitSet(new long[]{0x0000000001000040L});
    public static final BitSet FOLLOW_37_in_ruleXMemberFeatureCall3864 = new BitSet(new long[]{0x0000000001000040L});
    public static final BitSet FOLLOW_24_in_ruleXMemberFeatureCall3893 = new BitSet(new long[]{0x0000008000000040L,0x0000000000000060L});
    public static final BitSet FOLLOW_ruleJvmArgumentTypeReference_in_ruleXMemberFeatureCall3914 = new BitSet(new long[]{0x0000004000800000L});
    public static final BitSet FOLLOW_38_in_ruleXMemberFeatureCall3927 = new BitSet(new long[]{0x0000008000000040L,0x0000000000000060L});
    public static final BitSet FOLLOW_ruleJvmArgumentTypeReference_in_ruleXMemberFeatureCall3948 = new BitSet(new long[]{0x0000004000800000L});
    public static final BitSet FOLLOW_23_in_ruleXMemberFeatureCall3962 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_ruleValidID_in_ruleXMemberFeatureCall3987 = new BitSet(new long[]{0x000002B800000002L});
    public static final BitSet FOLLOW_39_in_ruleXMemberFeatureCall4021 = new BitSet(new long[]{0xFBF1578219000070L,0x0000000000000027L});
    public static final BitSet FOLLOW_ruleXShortClosure_in_ruleXMemberFeatureCall4106 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXMemberFeatureCall4134 = new BitSet(new long[]{0x0000014000000000L});
    public static final BitSet FOLLOW_38_in_ruleXMemberFeatureCall4147 = new BitSet(new long[]{0xFBF1528219000070L,0x0000000000000007L});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXMemberFeatureCall4168 = new BitSet(new long[]{0x0000014000000000L});
    public static final BitSet FOLLOW_40_in_ruleXMemberFeatureCall4185 = new BitSet(new long[]{0x0000023800000002L});
    public static final BitSet FOLLOW_ruleXClosure_in_ruleXMemberFeatureCall4218 = new BitSet(new long[]{0x0000003800000002L});
    public static final BitSet FOLLOW_ruleXPrimaryExpression_in_entryRuleXPrimaryExpression4258 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXPrimaryExpression4268 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXConstructorCall_in_ruleXPrimaryExpression4315 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXBlockExpression_in_ruleXPrimaryExpression4342 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXSwitchExpression_in_ruleXPrimaryExpression4369 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXFeatureCall_in_ruleXPrimaryExpression4396 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXLiteral_in_ruleXPrimaryExpression4423 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXIfExpression_in_ruleXPrimaryExpression4450 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXForLoopExpression_in_ruleXPrimaryExpression4477 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXWhileExpression_in_ruleXPrimaryExpression4504 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXDoWhileExpression_in_ruleXPrimaryExpression4531 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXThrowExpression_in_ruleXPrimaryExpression4558 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXReturnExpression_in_ruleXPrimaryExpression4585 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXTryCatchFinallyExpression_in_ruleXPrimaryExpression4612 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXParenthesizedExpression_in_ruleXPrimaryExpression4639 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXLiteral_in_entryRuleXLiteral4674 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXLiteral4684 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXClosure_in_ruleXLiteral4731 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXBooleanLiteral_in_ruleXLiteral4758 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXIntLiteral_in_ruleXLiteral4785 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXNullLiteral_in_ruleXLiteral4812 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXStringLiteral_in_ruleXLiteral4839 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXTypeLiteral_in_ruleXLiteral4866 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXClosure_in_entryRuleXClosure4901 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXClosure4911 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_41_in_ruleXClosure4957 = new BitSet(new long[]{0xFBF15E8219000070L,0x0000000000000027L});
    public static final BitSet FOLLOW_ruleJvmFormalParameter_in_ruleXClosure5028 = new BitSet(new long[]{0x0000044000000000L});
    public static final BitSet FOLLOW_38_in_ruleXClosure5041 = new BitSet(new long[]{0x0000008000000040L,0x0000000000000020L});
    public static final BitSet FOLLOW_ruleJvmFormalParameter_in_ruleXClosure5062 = new BitSet(new long[]{0x0000044000000000L});
    public static final BitSet FOLLOW_42_in_ruleXClosure5084 = new BitSet(new long[]{0xFBF15A8219000070L,0x0000000000000007L});
    public static final BitSet FOLLOW_ruleXExpressionInClosure_in_ruleXClosure5121 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_43_in_ruleXClosure5133 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXExpressionInClosure_in_entryRuleXExpressionInClosure5169 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXExpressionInClosure5179 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXExpressionInsideBlock_in_ruleXExpressionInClosure5235 = new BitSet(new long[]{0xFBF1528219000872L,0x0000000000000007L});
    public static final BitSet FOLLOW_11_in_ruleXExpressionInClosure5248 = new BitSet(new long[]{0xFBF1528219000072L,0x0000000000000007L});
    public static final BitSet FOLLOW_ruleXShortClosure_in_entryRuleXShortClosure5288 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXShortClosure5298 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJvmFormalParameter_in_ruleXShortClosure5406 = new BitSet(new long[]{0x0000044000000000L});
    public static final BitSet FOLLOW_38_in_ruleXShortClosure5419 = new BitSet(new long[]{0x0000008000000040L,0x0000000000000020L});
    public static final BitSet FOLLOW_ruleJvmFormalParameter_in_ruleXShortClosure5440 = new BitSet(new long[]{0x0000044000000000L});
    public static final BitSet FOLLOW_42_in_ruleXShortClosure5462 = new BitSet(new long[]{0xFBF1528219000070L,0x0000000000000007L});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXShortClosure5498 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXParenthesizedExpression_in_entryRuleXParenthesizedExpression5534 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXParenthesizedExpression5544 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_39_in_ruleXParenthesizedExpression5581 = new BitSet(new long[]{0xFBF1528219000070L,0x0000000000000007L});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXParenthesizedExpression5603 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_40_in_ruleXParenthesizedExpression5614 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXIfExpression_in_entryRuleXIfExpression5650 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXIfExpression5660 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_44_in_ruleXIfExpression5706 = new BitSet(new long[]{0x0000008000000000L});
    public static final BitSet FOLLOW_39_in_ruleXIfExpression5718 = new BitSet(new long[]{0xFBF1528219000070L,0x0000000000000007L});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXIfExpression5739 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_40_in_ruleXIfExpression5751 = new BitSet(new long[]{0xFBF1528219000070L,0x0000000000000007L});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXIfExpression5772 = new BitSet(new long[]{0x0000200000000002L});
    public static final BitSet FOLLOW_45_in_ruleXIfExpression5793 = new BitSet(new long[]{0xFBF1528219000070L,0x0000000000000007L});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXIfExpression5815 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXSwitchExpression_in_entryRuleXSwitchExpression5853 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXSwitchExpression5863 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_46_in_ruleXSwitchExpression5909 = new BitSet(new long[]{0xFBF1528219000070L,0x0000000000000007L});
    public static final BitSet FOLLOW_ruleValidID_in_ruleXSwitchExpression5950 = new BitSet(new long[]{0x0000800000000000L});
    public static final BitSet FOLLOW_47_in_ruleXSwitchExpression5962 = new BitSet(new long[]{0xFBF1528219000070L,0x0000000000000007L});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXSwitchExpression5986 = new BitSet(new long[]{0x0001000000000000L});
    public static final BitSet FOLLOW_48_in_ruleXSwitchExpression5998 = new BitSet(new long[]{0x0008808000000040L,0x0000000000000020L});
    public static final BitSet FOLLOW_ruleXCasePart_in_ruleXSwitchExpression6019 = new BitSet(new long[]{0x000E808000000040L,0x0000000000000020L});
    public static final BitSet FOLLOW_49_in_ruleXSwitchExpression6033 = new BitSet(new long[]{0x0000800000000000L});
    public static final BitSet FOLLOW_47_in_ruleXSwitchExpression6045 = new BitSet(new long[]{0xFBF1528219000070L,0x0000000000000007L});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXSwitchExpression6066 = new BitSet(new long[]{0x0004000000000000L});
    public static final BitSet FOLLOW_50_in_ruleXSwitchExpression6080 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXCasePart_in_entryRuleXCasePart6116 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXCasePart6126 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJvmTypeReference_in_ruleXCasePart6172 = new BitSet(new long[]{0x0008800000000000L});
    public static final BitSet FOLLOW_51_in_ruleXCasePart6186 = new BitSet(new long[]{0xFBF1528219000070L,0x0000000000000007L});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXCasePart6207 = new BitSet(new long[]{0x0000800000000000L});
    public static final BitSet FOLLOW_47_in_ruleXCasePart6221 = new BitSet(new long[]{0xFBF1528219000070L,0x0000000000000007L});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXCasePart6242 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXForLoopExpression_in_entryRuleXForLoopExpression6278 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXForLoopExpression6288 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_52_in_ruleXForLoopExpression6334 = new BitSet(new long[]{0x0000008000000000L});
    public static final BitSet FOLLOW_39_in_ruleXForLoopExpression6346 = new BitSet(new long[]{0x0000008000000040L,0x0000000000000020L});
    public static final BitSet FOLLOW_ruleJvmFormalParameter_in_ruleXForLoopExpression6367 = new BitSet(new long[]{0x0000800000000000L});
    public static final BitSet FOLLOW_47_in_ruleXForLoopExpression6379 = new BitSet(new long[]{0xFBF1528219000070L,0x0000000000000007L});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXForLoopExpression6400 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_40_in_ruleXForLoopExpression6412 = new BitSet(new long[]{0xFBF1528219000070L,0x0000000000000007L});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXForLoopExpression6433 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXWhileExpression_in_entryRuleXWhileExpression6469 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXWhileExpression6479 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_53_in_ruleXWhileExpression6525 = new BitSet(new long[]{0x0000008000000000L});
    public static final BitSet FOLLOW_39_in_ruleXWhileExpression6537 = new BitSet(new long[]{0xFBF1528219000070L,0x0000000000000007L});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXWhileExpression6558 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_40_in_ruleXWhileExpression6570 = new BitSet(new long[]{0xFBF1528219000070L,0x0000000000000007L});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXWhileExpression6591 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXDoWhileExpression_in_entryRuleXDoWhileExpression6627 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXDoWhileExpression6637 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_54_in_ruleXDoWhileExpression6683 = new BitSet(new long[]{0xFBF1528219000070L,0x0000000000000007L});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXDoWhileExpression6704 = new BitSet(new long[]{0x0020000000000000L});
    public static final BitSet FOLLOW_53_in_ruleXDoWhileExpression6716 = new BitSet(new long[]{0x0000008000000000L});
    public static final BitSet FOLLOW_39_in_ruleXDoWhileExpression6728 = new BitSet(new long[]{0xFBF1528219000070L,0x0000000000000007L});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXDoWhileExpression6749 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_40_in_ruleXDoWhileExpression6761 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXBlockExpression_in_entryRuleXBlockExpression6797 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXBlockExpression6807 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_48_in_ruleXBlockExpression6853 = new BitSet(new long[]{0xFBF5528219000070L,0x0000000000000007L});
    public static final BitSet FOLLOW_ruleXExpressionInsideBlock_in_ruleXBlockExpression6875 = new BitSet(new long[]{0xFBF5528219000870L,0x0000000000000007L});
    public static final BitSet FOLLOW_11_in_ruleXBlockExpression6888 = new BitSet(new long[]{0xFBF5528219000070L,0x0000000000000007L});
    public static final BitSet FOLLOW_50_in_ruleXBlockExpression6904 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXExpressionInsideBlock_in_entryRuleXExpressionInsideBlock6940 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXExpressionInsideBlock6950 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXVariableDeclaration_in_ruleXExpressionInsideBlock6997 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXExpressionInsideBlock7024 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXVariableDeclaration_in_entryRuleXVariableDeclaration7059 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXVariableDeclaration7069 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_55_in_ruleXVariableDeclaration7122 = new BitSet(new long[]{0x0000008000000040L,0x0000000000000020L});
    public static final BitSet FOLLOW_56_in_ruleXVariableDeclaration7153 = new BitSet(new long[]{0x0000008000000040L,0x0000000000000020L});
    public static final BitSet FOLLOW_ruleJvmTypeReference_in_ruleXVariableDeclaration7201 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_ruleValidID_in_ruleXVariableDeclaration7222 = new BitSet(new long[]{0x0000000000004002L});
    public static final BitSet FOLLOW_ruleValidID_in_ruleXVariableDeclaration7251 = new BitSet(new long[]{0x0000000000004002L});
    public static final BitSet FOLLOW_14_in_ruleXVariableDeclaration7265 = new BitSet(new long[]{0xFBF1528219000070L,0x0000000000000007L});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXVariableDeclaration7286 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJvmFormalParameter_in_entryRuleJvmFormalParameter7324 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleJvmFormalParameter7334 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJvmTypeReference_in_ruleJvmFormalParameter7380 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_ruleValidID_in_ruleJvmFormalParameter7402 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFullJvmFormalParameter_in_entryRuleFullJvmFormalParameter7438 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleFullJvmFormalParameter7448 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJvmTypeReference_in_ruleFullJvmFormalParameter7494 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_ruleValidID_in_ruleFullJvmFormalParameter7515 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXFeatureCall_in_entryRuleXFeatureCall7551 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXFeatureCall7561 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleStaticQualifier_in_ruleXFeatureCall7618 = new BitSet(new long[]{0x0200000001000040L});
    public static final BitSet FOLLOW_24_in_ruleXFeatureCall7632 = new BitSet(new long[]{0x0000008000000040L,0x0000000000000060L});
    public static final BitSet FOLLOW_ruleJvmArgumentTypeReference_in_ruleXFeatureCall7653 = new BitSet(new long[]{0x0000004000800000L});
    public static final BitSet FOLLOW_38_in_ruleXFeatureCall7666 = new BitSet(new long[]{0x0000008000000040L,0x0000000000000060L});
    public static final BitSet FOLLOW_ruleJvmArgumentTypeReference_in_ruleXFeatureCall7687 = new BitSet(new long[]{0x0000004000800000L});
    public static final BitSet FOLLOW_23_in_ruleXFeatureCall7701 = new BitSet(new long[]{0x0200000001000040L});
    public static final BitSet FOLLOW_ruleIdOrSuper_in_ruleXFeatureCall7726 = new BitSet(new long[]{0x0000028000000002L});
    public static final BitSet FOLLOW_39_in_ruleXFeatureCall7760 = new BitSet(new long[]{0xFBF1578219000070L,0x0000000000000027L});
    public static final BitSet FOLLOW_ruleXShortClosure_in_ruleXFeatureCall7845 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXFeatureCall7873 = new BitSet(new long[]{0x0000014000000000L});
    public static final BitSet FOLLOW_38_in_ruleXFeatureCall7886 = new BitSet(new long[]{0xFBF1528219000070L,0x0000000000000007L});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXFeatureCall7907 = new BitSet(new long[]{0x0000014000000000L});
    public static final BitSet FOLLOW_40_in_ruleXFeatureCall7924 = new BitSet(new long[]{0x0000020000000002L});
    public static final BitSet FOLLOW_ruleXClosure_in_ruleXFeatureCall7957 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleIdOrSuper_in_entryRuleIdOrSuper7995 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleIdOrSuper8006 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleValidID_in_ruleIdOrSuper8053 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_57_in_ruleIdOrSuper8077 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleStaticQualifier_in_entryRuleStaticQualifier8118 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleStaticQualifier8129 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleValidID_in_ruleStaticQualifier8176 = new BitSet(new long[]{0x0400000000000000L});
    public static final BitSet FOLLOW_58_in_ruleStaticQualifier8194 = new BitSet(new long[]{0x0000000000000042L});
    public static final BitSet FOLLOW_ruleXConstructorCall_in_entryRuleXConstructorCall8235 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXConstructorCall8245 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_59_in_ruleXConstructorCall8291 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_ruleXConstructorCall8314 = new BitSet(new long[]{0x0000008001000000L});
    public static final BitSet FOLLOW_24_in_ruleXConstructorCall8327 = new BitSet(new long[]{0x0000008000000040L,0x0000000000000060L});
    public static final BitSet FOLLOW_ruleJvmArgumentTypeReference_in_ruleXConstructorCall8348 = new BitSet(new long[]{0x0000004000800000L});
    public static final BitSet FOLLOW_38_in_ruleXConstructorCall8361 = new BitSet(new long[]{0x0000008000000040L,0x0000000000000060L});
    public static final BitSet FOLLOW_ruleJvmArgumentTypeReference_in_ruleXConstructorCall8382 = new BitSet(new long[]{0x0000004000800000L});
    public static final BitSet FOLLOW_23_in_ruleXConstructorCall8396 = new BitSet(new long[]{0x0000008000000000L});
    public static final BitSet FOLLOW_39_in_ruleXConstructorCall8410 = new BitSet(new long[]{0xFBF1578219000070L,0x0000000000000027L});
    public static final BitSet FOLLOW_ruleXShortClosure_in_ruleXConstructorCall8482 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXConstructorCall8510 = new BitSet(new long[]{0x0000014000000000L});
    public static final BitSet FOLLOW_38_in_ruleXConstructorCall8523 = new BitSet(new long[]{0xFBF1528219000070L,0x0000000000000007L});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXConstructorCall8544 = new BitSet(new long[]{0x0000014000000000L});
    public static final BitSet FOLLOW_40_in_ruleXConstructorCall8561 = new BitSet(new long[]{0x0000020000000002L});
    public static final BitSet FOLLOW_ruleXClosure_in_ruleXConstructorCall8592 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXBooleanLiteral_in_entryRuleXBooleanLiteral8629 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXBooleanLiteral8639 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_60_in_ruleXBooleanLiteral8686 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_61_in_ruleXBooleanLiteral8710 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXNullLiteral_in_entryRuleXNullLiteral8760 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXNullLiteral8770 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_62_in_ruleXNullLiteral8816 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXIntLiteral_in_entryRuleXIntLiteral8852 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXIntLiteral8862 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleXIntLiteral8913 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXStringLiteral_in_entryRuleXStringLiteral8954 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXStringLiteral8964 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleXStringLiteral9015 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXTypeLiteral_in_entryRuleXTypeLiteral9056 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXTypeLiteral9066 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_63_in_ruleXTypeLiteral9112 = new BitSet(new long[]{0x0000008000000000L});
    public static final BitSet FOLLOW_39_in_ruleXTypeLiteral9124 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_ruleXTypeLiteral9147 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_40_in_ruleXTypeLiteral9159 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXThrowExpression_in_entryRuleXThrowExpression9195 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXThrowExpression9205 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_64_in_ruleXThrowExpression9251 = new BitSet(new long[]{0xFBF1528219000070L,0x0000000000000007L});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXThrowExpression9272 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXReturnExpression_in_entryRuleXReturnExpression9308 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXReturnExpression9318 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_65_in_ruleXReturnExpression9364 = new BitSet(new long[]{0xFBF1528219000072L,0x0000000000000007L});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXReturnExpression9395 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXTryCatchFinallyExpression_in_entryRuleXTryCatchFinallyExpression9432 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXTryCatchFinallyExpression9442 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_66_in_ruleXTryCatchFinallyExpression9488 = new BitSet(new long[]{0xFBF1528219000070L,0x0000000000000007L});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXTryCatchFinallyExpression9509 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000018L});
    public static final BitSet FOLLOW_ruleXCatchClause_in_ruleXTryCatchFinallyExpression9539 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000018L});
    public static final BitSet FOLLOW_67_in_ruleXTryCatchFinallyExpression9561 = new BitSet(new long[]{0xFBF1528219000070L,0x0000000000000007L});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXTryCatchFinallyExpression9583 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_67_in_ruleXTryCatchFinallyExpression9605 = new BitSet(new long[]{0xFBF1528219000070L,0x0000000000000007L});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXTryCatchFinallyExpression9626 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXCatchClause_in_entryRuleXCatchClause9664 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXCatchClause9674 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_68_in_ruleXCatchClause9719 = new BitSet(new long[]{0x0000008000000000L});
    public static final BitSet FOLLOW_39_in_ruleXCatchClause9732 = new BitSet(new long[]{0x0000008000000040L,0x0000000000000020L});
    public static final BitSet FOLLOW_ruleFullJvmFormalParameter_in_ruleXCatchClause9753 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_40_in_ruleXCatchClause9765 = new BitSet(new long[]{0xFBF1528219000070L,0x0000000000000007L});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXCatchClause9786 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_entryRuleQualifiedName9823 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleQualifiedName9834 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleValidID_in_ruleQualifiedName9881 = new BitSet(new long[]{0x0000000800000002L});
    public static final BitSet FOLLOW_35_in_ruleQualifiedName9909 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_ruleValidID_in_ruleQualifiedName9932 = new BitSet(new long[]{0x0000000800000002L});
    public static final BitSet FOLLOW_ruleJvmTypeReference_in_entryRuleJvmTypeReference9979 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleJvmTypeReference9989 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJvmParameterizedTypeReference_in_ruleJvmTypeReference10037 = new BitSet(new long[]{0x0000020000000002L});
    public static final BitSet FOLLOW_41_in_ruleJvmTypeReference10075 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_43_in_ruleJvmTypeReference10087 = new BitSet(new long[]{0x0000020000000002L});
    public static final BitSet FOLLOW_ruleXFunctionTypeRef_in_ruleJvmTypeReference10119 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXFunctionTypeRef_in_entryRuleXFunctionTypeRef10154 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXFunctionTypeRef10164 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_39_in_ruleXFunctionTypeRef10202 = new BitSet(new long[]{0x0000018000000040L,0x0000000000000020L});
    public static final BitSet FOLLOW_ruleJvmTypeReference_in_ruleXFunctionTypeRef10224 = new BitSet(new long[]{0x0000014000000000L});
    public static final BitSet FOLLOW_38_in_ruleXFunctionTypeRef10237 = new BitSet(new long[]{0x0000008000000040L,0x0000000000000020L});
    public static final BitSet FOLLOW_ruleJvmTypeReference_in_ruleXFunctionTypeRef10258 = new BitSet(new long[]{0x0000014000000000L});
    public static final BitSet FOLLOW_40_in_ruleXFunctionTypeRef10274 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000020L});
    public static final BitSet FOLLOW_69_in_ruleXFunctionTypeRef10288 = new BitSet(new long[]{0x0000008000000040L,0x0000000000000020L});
    public static final BitSet FOLLOW_ruleJvmTypeReference_in_ruleXFunctionTypeRef10309 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJvmParameterizedTypeReference_in_entryRuleJvmParameterizedTypeReference10345 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleJvmParameterizedTypeReference10355 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_ruleJvmParameterizedTypeReference10403 = new BitSet(new long[]{0x0000000001000002L});
    public static final BitSet FOLLOW_24_in_ruleJvmParameterizedTypeReference10424 = new BitSet(new long[]{0x0000008000000040L,0x0000000000000060L});
    public static final BitSet FOLLOW_ruleJvmArgumentTypeReference_in_ruleJvmParameterizedTypeReference10446 = new BitSet(new long[]{0x0000004000800000L});
    public static final BitSet FOLLOW_38_in_ruleJvmParameterizedTypeReference10459 = new BitSet(new long[]{0x0000008000000040L,0x0000000000000060L});
    public static final BitSet FOLLOW_ruleJvmArgumentTypeReference_in_ruleJvmParameterizedTypeReference10480 = new BitSet(new long[]{0x0000004000800000L});
    public static final BitSet FOLLOW_23_in_ruleJvmParameterizedTypeReference10494 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJvmArgumentTypeReference_in_entryRuleJvmArgumentTypeReference10532 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleJvmArgumentTypeReference10542 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJvmTypeReference_in_ruleJvmArgumentTypeReference10589 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJvmWildcardTypeReference_in_ruleJvmArgumentTypeReference10616 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJvmWildcardTypeReference_in_entryRuleJvmWildcardTypeReference10651 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleJvmWildcardTypeReference10661 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_70_in_ruleJvmWildcardTypeReference10707 = new BitSet(new long[]{0x0200000000000002L,0x0000000000000080L});
    public static final BitSet FOLLOW_ruleJvmUpperBound_in_ruleJvmWildcardTypeReference10729 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJvmLowerBound_in_ruleJvmWildcardTypeReference10756 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJvmUpperBound_in_entryRuleJvmUpperBound10794 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleJvmUpperBound10804 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_71_in_ruleJvmUpperBound10841 = new BitSet(new long[]{0x0000008000000040L,0x0000000000000020L});
    public static final BitSet FOLLOW_ruleJvmTypeReference_in_ruleJvmUpperBound10862 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJvmUpperBoundAnded_in_entryRuleJvmUpperBoundAnded10898 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleJvmUpperBoundAnded10908 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_72_in_ruleJvmUpperBoundAnded10945 = new BitSet(new long[]{0x0000008000000040L,0x0000000000000020L});
    public static final BitSet FOLLOW_ruleJvmTypeReference_in_ruleJvmUpperBoundAnded10966 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJvmLowerBound_in_entryRuleJvmLowerBound11002 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleJvmLowerBound11012 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_57_in_ruleJvmLowerBound11049 = new BitSet(new long[]{0x0000008000000040L,0x0000000000000020L});
    public static final BitSet FOLLOW_ruleJvmTypeReference_in_ruleJvmLowerBound11070 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleValidID_in_entryRuleValidID11109 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleValidID11120 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleValidID11159 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleOpMultiAssign_in_synpred1_InternalPureXbase782 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleOpOr_in_synpred2_InternalPureXbase1130 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleOpAnd_in_synpred3_InternalPureXbase1389 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleOpEquality_in_synpred4_InternalPureXbase1648 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_20_in_synpred5_InternalPureXbase1924 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleOpCompare_in_synpred6_InternalPureXbase1997 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleOpOther_in_synpred7_InternalPureXbase2316 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleOpAdd_in_synpred8_InternalPureXbase2596 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleOpMulti_in_synpred9_InternalPureXbase2876 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_34_in_synpred10_InternalPureXbase3470 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_35_in_synpred11_InternalPureXbase3624 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_ruleValidID_in_synpred11_InternalPureXbase3633 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_ruleOpSingleAssign_in_synpred11_InternalPureXbase3639 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_35_in_synpred12_InternalPureXbase3742 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_36_in_synpred12_InternalPureXbase3756 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_37_in_synpred12_InternalPureXbase3776 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_39_in_synpred13_InternalPureXbase4003 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJvmFormalParameter_in_synpred14_InternalPureXbase4055 = new BitSet(new long[]{0x0000044000000000L});
    public static final BitSet FOLLOW_38_in_synpred14_InternalPureXbase4062 = new BitSet(new long[]{0x0000008000000040L,0x0000000000000020L});
    public static final BitSet FOLLOW_ruleJvmFormalParameter_in_synpred14_InternalPureXbase4069 = new BitSet(new long[]{0x0000044000000000L});
    public static final BitSet FOLLOW_42_in_synpred14_InternalPureXbase4083 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXClosure_in_synpred15_InternalPureXbase4201 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJvmFormalParameter_in_synpred16_InternalPureXbase4974 = new BitSet(new long[]{0x0000044000000000L});
    public static final BitSet FOLLOW_38_in_synpred16_InternalPureXbase4981 = new BitSet(new long[]{0x0000008000000040L,0x0000000000000020L});
    public static final BitSet FOLLOW_ruleJvmFormalParameter_in_synpred16_InternalPureXbase4988 = new BitSet(new long[]{0x0000044000000000L});
    public static final BitSet FOLLOW_42_in_synpred16_InternalPureXbase5002 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_45_in_synpred18_InternalPureXbase5785 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleValidID_in_synpred19_InternalPureXbase5925 = new BitSet(new long[]{0x0000800000000000L});
    public static final BitSet FOLLOW_47_in_synpred19_InternalPureXbase5931 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJvmTypeReference_in_synpred20_InternalPureXbase7171 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_ruleValidID_in_synpred20_InternalPureXbase7180 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_39_in_synpred21_InternalPureXbase7742 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJvmFormalParameter_in_synpred22_InternalPureXbase7794 = new BitSet(new long[]{0x0000044000000000L});
    public static final BitSet FOLLOW_38_in_synpred22_InternalPureXbase7801 = new BitSet(new long[]{0x0000008000000040L,0x0000000000000020L});
    public static final BitSet FOLLOW_ruleJvmFormalParameter_in_synpred22_InternalPureXbase7808 = new BitSet(new long[]{0x0000044000000000L});
    public static final BitSet FOLLOW_42_in_synpred22_InternalPureXbase7822 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXClosure_in_synpred23_InternalPureXbase7940 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJvmFormalParameter_in_synpred24_InternalPureXbase8431 = new BitSet(new long[]{0x0000044000000000L});
    public static final BitSet FOLLOW_38_in_synpred24_InternalPureXbase8438 = new BitSet(new long[]{0x0000008000000040L,0x0000000000000020L});
    public static final BitSet FOLLOW_ruleJvmFormalParameter_in_synpred24_InternalPureXbase8445 = new BitSet(new long[]{0x0000044000000000L});
    public static final BitSet FOLLOW_42_in_synpred24_InternalPureXbase8459 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXClosure_in_synpred25_InternalPureXbase8575 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXExpression_in_synpred26_InternalPureXbase9378 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_68_in_synpred27_InternalPureXbase9523 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_67_in_synpred28_InternalPureXbase9553 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_35_in_synpred30_InternalPureXbase9900 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_41_in_synpred31_InternalPureXbase10052 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_43_in_synpred31_InternalPureXbase10056 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_24_in_synpred32_InternalPureXbase10416 = new BitSet(new long[]{0x0000000000000002L});

}