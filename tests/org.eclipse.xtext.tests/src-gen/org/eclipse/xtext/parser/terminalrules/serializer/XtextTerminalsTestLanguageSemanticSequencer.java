package org.eclipse.xtext.parser.terminalrules.serializer;

import com.google.inject.Inject;
import com.google.inject.Provider;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.terminalrules.services.XtextTerminalsTestLanguageGrammarAccess;
import org.eclipse.xtext.parser.terminalrules.xtextTerminalsTestLanguage.Action;
import org.eclipse.xtext.parser.terminalrules.xtextTerminalsTestLanguage.Alternatives;
import org.eclipse.xtext.parser.terminalrules.xtextTerminalsTestLanguage.Assignment;
import org.eclipse.xtext.parser.terminalrules.xtextTerminalsTestLanguage.CharacterRange;
import org.eclipse.xtext.parser.terminalrules.xtextTerminalsTestLanguage.CrossReference;
import org.eclipse.xtext.parser.terminalrules.xtextTerminalsTestLanguage.EnumLiteralDeclaration;
import org.eclipse.xtext.parser.terminalrules.xtextTerminalsTestLanguage.EnumRule;
import org.eclipse.xtext.parser.terminalrules.xtextTerminalsTestLanguage.GeneratedMetamodel;
import org.eclipse.xtext.parser.terminalrules.xtextTerminalsTestLanguage.Grammar;
import org.eclipse.xtext.parser.terminalrules.xtextTerminalsTestLanguage.Group;
import org.eclipse.xtext.parser.terminalrules.xtextTerminalsTestLanguage.Keyword;
import org.eclipse.xtext.parser.terminalrules.xtextTerminalsTestLanguage.NegatedToken;
import org.eclipse.xtext.parser.terminalrules.xtextTerminalsTestLanguage.ParserRule;
import org.eclipse.xtext.parser.terminalrules.xtextTerminalsTestLanguage.ReferencedMetamodel;
import org.eclipse.xtext.parser.terminalrules.xtextTerminalsTestLanguage.RuleCall;
import org.eclipse.xtext.parser.terminalrules.xtextTerminalsTestLanguage.TerminalRule;
import org.eclipse.xtext.parser.terminalrules.xtextTerminalsTestLanguage.TypeRef;
import org.eclipse.xtext.parser.terminalrules.xtextTerminalsTestLanguage.UntilToken;
import org.eclipse.xtext.parser.terminalrules.xtextTerminalsTestLanguage.Wildcard;
import org.eclipse.xtext.parser.terminalrules.xtextTerminalsTestLanguage.XtextTerminalsTestLanguagePackage;
import org.eclipse.xtext.serializer.acceptor.ISemanticSequenceAcceptor;
import org.eclipse.xtext.serializer.diagnostic.ISemanticSequencerDiagnosticProvider;
import org.eclipse.xtext.serializer.diagnostic.ISerializationDiagnostic.Acceptor;
import org.eclipse.xtext.serializer.sequencer.AbstractDelegatingSemanticSequencer;
import org.eclipse.xtext.serializer.sequencer.GenericSequencer;
import org.eclipse.xtext.serializer.sequencer.ISemanticSequencer;
import org.eclipse.xtext.serializer.sequencer.ITransientValueService;

@SuppressWarnings("all")
public class XtextTerminalsTestLanguageSemanticSequencer extends AbstractDelegatingSemanticSequencer {

	@Inject
	private XtextTerminalsTestLanguageGrammarAccess grammarAccess;
	
	public void createSequence(EObject context, EObject semanticObject) {
		if(semanticObject.eClass().getEPackage() == XtextTerminalsTestLanguagePackage.eINSTANCE) switch(semanticObject.eClass().getClassifierID()) {
			case XtextTerminalsTestLanguagePackage.ACTION:
				if(context == grammarAccess.getAbstractTokenWithCardinalityRule()) {
					sequence_AbstractTokenWithCardinality_Action(context, (Action) semanticObject); 
					return; 
				}
				else if(context == grammarAccess.getAbstractTerminalRule() ||
				   context == grammarAccess.getAbstractTokenRule() ||
				   context == grammarAccess.getActionRule() ||
				   context == grammarAccess.getAlternativesRule() ||
				   context == grammarAccess.getAlternativesAccess().getAlternativesGroupsAction_1_0() ||
				   context == grammarAccess.getGroupRule() ||
				   context == grammarAccess.getGroupAccess().getGroupTokensAction_1_0() ||
				   context == grammarAccess.getParenthesizedElementRule()) {
					sequence_Action(context, (Action) semanticObject); 
					return; 
				}
				else break;
			case XtextTerminalsTestLanguagePackage.ALTERNATIVES:
				if(context == grammarAccess.getAbstractTokenRule() ||
				   context == grammarAccess.getAbstractTokenWithCardinalityRule() ||
				   context == grammarAccess.getAlternativesAccess().getAlternativesGroupsAction_1_0() ||
				   context == grammarAccess.getGroupRule() ||
				   context == grammarAccess.getGroupAccess().getGroupTokensAction_1_0()) {
					sequence_AbstractTokenWithCardinality_Alternatives(context, (Alternatives) semanticObject); 
					return; 
				}
				else if(context == grammarAccess.getAbstractTerminalRule() ||
				   context == grammarAccess.getAlternativesRule() ||
				   context == grammarAccess.getParenthesizedElementRule()) {
					sequence_Alternatives(context, (Alternatives) semanticObject); 
					return; 
				}
				else if(context == grammarAccess.getAssignableAlternativesRule() ||
				   context == grammarAccess.getAssignableAlternativesAccess().getAlternativesGroupsAction_1_0() ||
				   context == grammarAccess.getAssignableTerminalRule() ||
				   context == grammarAccess.getParenthesizedAssignableElementRule()) {
					sequence_AssignableAlternatives(context, (Alternatives) semanticObject); 
					return; 
				}
				else if(context == grammarAccess.getEnumLiteralsRule()) {
					sequence_EnumLiterals(context, (Alternatives) semanticObject); 
					return; 
				}
				else if(context == grammarAccess.getParenthesizedTerminalElementRule() ||
				   context == grammarAccess.getTerminalAlternativesRule() ||
				   context == grammarAccess.getTerminalTokenElementRule()) {
					sequence_TerminalAlternatives(context, (Alternatives) semanticObject); 
					return; 
				}
				else if(context == grammarAccess.getTerminalAlternativesAccess().getAlternativesGroupsAction_1_0() ||
				   context == grammarAccess.getTerminalGroupRule() ||
				   context == grammarAccess.getTerminalGroupAccess().getGroupTokensAction_1_0() ||
				   context == grammarAccess.getTerminalTokenRule()) {
					sequence_TerminalAlternatives_TerminalToken(context, (Alternatives) semanticObject); 
					return; 
				}
				else break;
			case XtextTerminalsTestLanguagePackage.ASSIGNMENT:
				if(context == grammarAccess.getAbstractTerminalRule() ||
				   context == grammarAccess.getAbstractTokenRule() ||
				   context == grammarAccess.getAbstractTokenWithCardinalityRule() ||
				   context == grammarAccess.getAlternativesRule() ||
				   context == grammarAccess.getAlternativesAccess().getAlternativesGroupsAction_1_0() ||
				   context == grammarAccess.getGroupRule() ||
				   context == grammarAccess.getGroupAccess().getGroupTokensAction_1_0() ||
				   context == grammarAccess.getParenthesizedElementRule()) {
					sequence_AbstractTokenWithCardinality_Assignment(context, (Assignment) semanticObject); 
					return; 
				}
				else if(context == grammarAccess.getAssignmentRule()) {
					sequence_Assignment(context, (Assignment) semanticObject); 
					return; 
				}
				else break;
			case XtextTerminalsTestLanguagePackage.CHARACTER_RANGE:
				if(context == grammarAccess.getCharacterRangeRule() ||
				   context == grammarAccess.getTerminalTokenElementRule()) {
					sequence_CharacterRange(context, (CharacterRange) semanticObject); 
					return; 
				}
				else if(context == grammarAccess.getParenthesizedTerminalElementRule() ||
				   context == grammarAccess.getTerminalAlternativesRule() ||
				   context == grammarAccess.getTerminalAlternativesAccess().getAlternativesGroupsAction_1_0() ||
				   context == grammarAccess.getTerminalGroupRule() ||
				   context == grammarAccess.getTerminalGroupAccess().getGroupTokensAction_1_0() ||
				   context == grammarAccess.getTerminalTokenRule()) {
					sequence_CharacterRange_TerminalToken(context, (CharacterRange) semanticObject); 
					return; 
				}
				else break;
			case XtextTerminalsTestLanguagePackage.CROSS_REFERENCE:
				if(context == grammarAccess.getAssignableAlternativesRule() ||
				   context == grammarAccess.getAssignableAlternativesAccess().getAlternativesGroupsAction_1_0() ||
				   context == grammarAccess.getAssignableTerminalRule() ||
				   context == grammarAccess.getCrossReferenceRule() ||
				   context == grammarAccess.getParenthesizedAssignableElementRule()) {
					sequence_CrossReference(context, (CrossReference) semanticObject); 
					return; 
				}
				else break;
			case XtextTerminalsTestLanguagePackage.ENUM_LITERAL_DECLARATION:
				if(context == grammarAccess.getEnumLiteralDeclarationRule() ||
				   context == grammarAccess.getEnumLiteralsRule() ||
				   context == grammarAccess.getEnumLiteralsAccess().getAlternativesGroupsAction_1_0()) {
					sequence_EnumLiteralDeclaration(context, (EnumLiteralDeclaration) semanticObject); 
					return; 
				}
				else break;
			case XtextTerminalsTestLanguagePackage.ENUM_RULE:
				if(context == grammarAccess.getAbstractRuleRule() ||
				   context == grammarAccess.getEnumRuleRule()) {
					sequence_EnumRule(context, (EnumRule) semanticObject); 
					return; 
				}
				else break;
			case XtextTerminalsTestLanguagePackage.GENERATED_METAMODEL:
				if(context == grammarAccess.getAbstractMetamodelDeclarationRule() ||
				   context == grammarAccess.getGeneratedMetamodelRule()) {
					sequence_GeneratedMetamodel(context, (GeneratedMetamodel) semanticObject); 
					return; 
				}
				else break;
			case XtextTerminalsTestLanguagePackage.GRAMMAR:
				if(context == grammarAccess.getGrammarRule()) {
					sequence_Grammar(context, (Grammar) semanticObject); 
					return; 
				}
				else break;
			case XtextTerminalsTestLanguagePackage.GROUP:
				if(context == grammarAccess.getAbstractTokenRule() ||
				   context == grammarAccess.getAbstractTokenWithCardinalityRule() ||
				   context == grammarAccess.getGroupAccess().getGroupTokensAction_1_0()) {
					sequence_AbstractTokenWithCardinality_Group(context, (Group) semanticObject); 
					return; 
				}
				else if(context == grammarAccess.getAbstractTerminalRule() ||
				   context == grammarAccess.getAlternativesRule() ||
				   context == grammarAccess.getAlternativesAccess().getAlternativesGroupsAction_1_0() ||
				   context == grammarAccess.getGroupRule() ||
				   context == grammarAccess.getParenthesizedElementRule()) {
					sequence_Group(context, (Group) semanticObject); 
					return; 
				}
				else if(context == grammarAccess.getParenthesizedTerminalElementRule() ||
				   context == grammarAccess.getTerminalAlternativesRule() ||
				   context == grammarAccess.getTerminalAlternativesAccess().getAlternativesGroupsAction_1_0() ||
				   context == grammarAccess.getTerminalGroupRule() ||
				   context == grammarAccess.getTerminalTokenElementRule()) {
					sequence_TerminalGroup(context, (Group) semanticObject); 
					return; 
				}
				else if(context == grammarAccess.getTerminalGroupAccess().getGroupTokensAction_1_0() ||
				   context == grammarAccess.getTerminalTokenRule()) {
					sequence_TerminalGroup_TerminalToken(context, (Group) semanticObject); 
					return; 
				}
				else break;
			case XtextTerminalsTestLanguagePackage.KEYWORD:
				if(context == grammarAccess.getAbstractTokenRule() ||
				   context == grammarAccess.getAbstractTokenWithCardinalityRule() ||
				   context == grammarAccess.getAlternativesRule() ||
				   context == grammarAccess.getAlternativesAccess().getAlternativesGroupsAction_1_0() ||
				   context == grammarAccess.getGroupRule() ||
				   context == grammarAccess.getGroupAccess().getGroupTokensAction_1_0() ||
				   context == grammarAccess.getParenthesizedElementRule()) {
					sequence_AbstractTokenWithCardinality_Keyword(context, (Keyword) semanticObject); 
					return; 
				}
				else if(context == grammarAccess.getAbstractTerminalRule() ||
				   context == grammarAccess.getAssignableAlternativesRule() ||
				   context == grammarAccess.getAssignableAlternativesAccess().getAlternativesGroupsAction_1_0() ||
				   context == grammarAccess.getAssignableTerminalRule() ||
				   context == grammarAccess.getCharacterRangeRule() ||
				   context == grammarAccess.getCharacterRangeAccess().getCharacterRangeLeftAction_1_0() ||
				   context == grammarAccess.getCrossReferenceableTerminalRule() ||
				   context == grammarAccess.getKeywordRule() ||
				   context == grammarAccess.getParenthesizedAssignableElementRule() ||
				   context == grammarAccess.getTerminalTokenElementRule()) {
					sequence_Keyword(context, (Keyword) semanticObject); 
					return; 
				}
				else if(context == grammarAccess.getParenthesizedTerminalElementRule() ||
				   context == grammarAccess.getTerminalAlternativesRule() ||
				   context == grammarAccess.getTerminalAlternativesAccess().getAlternativesGroupsAction_1_0() ||
				   context == grammarAccess.getTerminalGroupRule() ||
				   context == grammarAccess.getTerminalGroupAccess().getGroupTokensAction_1_0() ||
				   context == grammarAccess.getTerminalTokenRule()) {
					sequence_Keyword_TerminalToken(context, (Keyword) semanticObject); 
					return; 
				}
				else break;
			case XtextTerminalsTestLanguagePackage.NEGATED_TOKEN:
				if(context == grammarAccess.getAbstractNegatedTokenRule() ||
				   context == grammarAccess.getNegatedTokenRule() ||
				   context == grammarAccess.getTerminalTokenElementRule()) {
					sequence_NegatedToken(context, (NegatedToken) semanticObject); 
					return; 
				}
				else if(context == grammarAccess.getParenthesizedTerminalElementRule() ||
				   context == grammarAccess.getTerminalAlternativesRule() ||
				   context == grammarAccess.getTerminalAlternativesAccess().getAlternativesGroupsAction_1_0() ||
				   context == grammarAccess.getTerminalGroupRule() ||
				   context == grammarAccess.getTerminalGroupAccess().getGroupTokensAction_1_0() ||
				   context == grammarAccess.getTerminalTokenRule()) {
					sequence_NegatedToken_TerminalToken(context, (NegatedToken) semanticObject); 
					return; 
				}
				else break;
			case XtextTerminalsTestLanguagePackage.PARSER_RULE:
				if(context == grammarAccess.getAbstractRuleRule() ||
				   context == grammarAccess.getParserRuleRule()) {
					sequence_ParserRule(context, (ParserRule) semanticObject); 
					return; 
				}
				else break;
			case XtextTerminalsTestLanguagePackage.REFERENCED_METAMODEL:
				if(context == grammarAccess.getAbstractMetamodelDeclarationRule() ||
				   context == grammarAccess.getReferencedMetamodelRule()) {
					sequence_ReferencedMetamodel(context, (ReferencedMetamodel) semanticObject); 
					return; 
				}
				else break;
			case XtextTerminalsTestLanguagePackage.RULE_CALL:
				if(context == grammarAccess.getAbstractTokenRule() ||
				   context == grammarAccess.getAbstractTokenWithCardinalityRule() ||
				   context == grammarAccess.getAlternativesRule() ||
				   context == grammarAccess.getAlternativesAccess().getAlternativesGroupsAction_1_0() ||
				   context == grammarAccess.getGroupRule() ||
				   context == grammarAccess.getGroupAccess().getGroupTokensAction_1_0() ||
				   context == grammarAccess.getParenthesizedElementRule()) {
					sequence_AbstractTokenWithCardinality_RuleCall(context, (RuleCall) semanticObject); 
					return; 
				}
				else if(context == grammarAccess.getAbstractTerminalRule() ||
				   context == grammarAccess.getAssignableAlternativesRule() ||
				   context == grammarAccess.getAssignableAlternativesAccess().getAlternativesGroupsAction_1_0() ||
				   context == grammarAccess.getAssignableTerminalRule() ||
				   context == grammarAccess.getCrossReferenceableTerminalRule() ||
				   context == grammarAccess.getParenthesizedAssignableElementRule() ||
				   context == grammarAccess.getRuleCallRule() ||
				   context == grammarAccess.getTerminalTokenElementRule()) {
					sequence_RuleCall(context, (RuleCall) semanticObject); 
					return; 
				}
				else if(context == grammarAccess.getParenthesizedTerminalElementRule() ||
				   context == grammarAccess.getTerminalAlternativesRule() ||
				   context == grammarAccess.getTerminalAlternativesAccess().getAlternativesGroupsAction_1_0() ||
				   context == grammarAccess.getTerminalGroupRule() ||
				   context == grammarAccess.getTerminalGroupAccess().getGroupTokensAction_1_0() ||
				   context == grammarAccess.getTerminalTokenRule()) {
					sequence_RuleCall_TerminalToken(context, (RuleCall) semanticObject); 
					return; 
				}
				else break;
			case XtextTerminalsTestLanguagePackage.TERMINAL_RULE:
				if(context == grammarAccess.getAbstractRuleRule() ||
				   context == grammarAccess.getTerminalRuleRule()) {
					sequence_TerminalRule(context, (TerminalRule) semanticObject); 
					return; 
				}
				else break;
			case XtextTerminalsTestLanguagePackage.TYPE_REF:
				if(context == grammarAccess.getTypeRefRule()) {
					sequence_TypeRef(context, (TypeRef) semanticObject); 
					return; 
				}
				else break;
			case XtextTerminalsTestLanguagePackage.UNTIL_TOKEN:
				if(context == grammarAccess.getParenthesizedTerminalElementRule() ||
				   context == grammarAccess.getTerminalAlternativesRule() ||
				   context == grammarAccess.getTerminalAlternativesAccess().getAlternativesGroupsAction_1_0() ||
				   context == grammarAccess.getTerminalGroupRule() ||
				   context == grammarAccess.getTerminalGroupAccess().getGroupTokensAction_1_0() ||
				   context == grammarAccess.getTerminalTokenRule()) {
					sequence_TerminalToken_UntilToken(context, (UntilToken) semanticObject); 
					return; 
				}
				else if(context == grammarAccess.getAbstractNegatedTokenRule() ||
				   context == grammarAccess.getTerminalTokenElementRule() ||
				   context == grammarAccess.getUntilTokenRule()) {
					sequence_UntilToken(context, (UntilToken) semanticObject); 
					return; 
				}
				else break;
			case XtextTerminalsTestLanguagePackage.WILDCARD:
				if(context == grammarAccess.getParenthesizedTerminalElementRule() ||
				   context == grammarAccess.getTerminalAlternativesRule() ||
				   context == grammarAccess.getTerminalAlternativesAccess().getAlternativesGroupsAction_1_0() ||
				   context == grammarAccess.getTerminalGroupRule() ||
				   context == grammarAccess.getTerminalGroupAccess().getGroupTokensAction_1_0() ||
				   context == grammarAccess.getTerminalTokenRule()) {
					sequence_TerminalToken(context, (Wildcard) semanticObject); 
					return; 
				}
				else if(context == grammarAccess.getTerminalTokenElementRule() ||
				   context == grammarAccess.getWildcardRule()) {
					sequence_Wildcard(context, (Wildcard) semanticObject); 
					return; 
				}
				else break;
			}
		if (errorAcceptor != null) errorAcceptor.accept(diagnosticProvider.createInvalidContextOrTypeDiagnostic(semanticObject, context));
	}
	
	/**
	 * Constraint:
	 *     (type=TypeRef (feature=ID (operator='=' | operator='+='))? (cardinality='?' | cardinality='*' | cardinality='+')?)
	 */
	protected void sequence_AbstractTokenWithCardinality_Action(EObject context, Action semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (groups+=Alternatives_Alternatives_1_0 groups+=Group+ (cardinality='?' | cardinality='*' | cardinality='+')?)
	 */
	protected void sequence_AbstractTokenWithCardinality_Alternatives(EObject context, Alternatives semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (feature=ID (operator='+=' | operator='=' | operator='?=') terminal=AssignableTerminal (cardinality='?' | cardinality='*' | cardinality='+')?)
	 */
	protected void sequence_AbstractTokenWithCardinality_Assignment(EObject context, Assignment semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (tokens+=Group_Group_1_0 tokens+=AbstractToken+ (cardinality='?' | cardinality='*' | cardinality='+')?)
	 */
	protected void sequence_AbstractTokenWithCardinality_Group(EObject context, Group semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (value=STRING (cardinality='?' | cardinality='*' | cardinality='+')?)
	 */
	protected void sequence_AbstractTokenWithCardinality_Keyword(EObject context, Keyword semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (rule=[AbstractRule|ID] (cardinality='?' | cardinality='*' | cardinality='+')?)
	 */
	protected void sequence_AbstractTokenWithCardinality_RuleCall(EObject context, RuleCall semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (type=TypeRef (feature=ID (operator='=' | operator='+='))?)
	 */
	protected void sequence_Action(EObject context, Action semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (groups+=Alternatives_Alternatives_1_0 groups+=Group+)
	 */
	protected void sequence_Alternatives(EObject context, Alternatives semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (groups+=AssignableAlternatives_Alternatives_1_0 groups+=AssignableTerminal+)
	 */
	protected void sequence_AssignableAlternatives(EObject context, Alternatives semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (feature=ID (operator='+=' | operator='=' | operator='?=') terminal=AssignableTerminal)
	 */
	protected void sequence_Assignment(EObject context, Assignment semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (left=CharacterRange_CharacterRange_1_0 right=Keyword)
	 */
	protected void sequence_CharacterRange(EObject context, CharacterRange semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (left=CharacterRange_CharacterRange_1_0 right=Keyword (cardinality='?' | cardinality='*' | cardinality='+')?)
	 */
	protected void sequence_CharacterRange_TerminalToken(EObject context, CharacterRange semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (type=TypeRef terminal=CrossReferenceableTerminal?)
	 */
	protected void sequence_CrossReference(EObject context, CrossReference semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (enumLiteral=[EEnumLiteral|ID] literal=Keyword?)
	 */
	protected void sequence_EnumLiteralDeclaration(EObject context, EnumLiteralDeclaration semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (groups+=EnumLiterals_Alternatives_1_0 groups+=EnumLiteralDeclaration+)
	 */
	protected void sequence_EnumLiterals(EObject context, Alternatives semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (name=ID type=TypeRef? alternatives=EnumLiterals)
	 */
	protected void sequence_EnumRule(EObject context, EnumRule semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (name=ID ePackage=[EPackage|STRING] alias=ID?)
	 */
	protected void sequence_GeneratedMetamodel(EObject context, GeneratedMetamodel semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (
	 *         name=GrammarID 
	 *         (usedGrammars+=[Grammar|GrammarID] usedGrammars+=[Grammar|GrammarID]*)? 
	 *         (definesHiddenTokens?='hidden' (hiddenTokens+=[AbstractRule|ID] hiddenTokens+=[AbstractRule|ID]*)?)? 
	 *         metamodelDeclarations+=AbstractMetamodelDeclaration* 
	 *         rules+=AbstractRule+
	 *     )
	 */
	protected void sequence_Grammar(EObject context, Grammar semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (tokens+=Group_Group_1_0 tokens+=AbstractToken+)
	 */
	protected void sequence_Group(EObject context, Group semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     value=STRING
	 */
	protected void sequence_Keyword(EObject context, Keyword semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (value=STRING (cardinality='?' | cardinality='*' | cardinality='+')?)
	 */
	protected void sequence_Keyword_TerminalToken(EObject context, Keyword semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     terminal=TerminalTokenElement
	 */
	protected void sequence_NegatedToken(EObject context, NegatedToken semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (terminal=TerminalTokenElement (cardinality='?' | cardinality='*' | cardinality='+')?)
	 */
	protected void sequence_NegatedToken_TerminalToken(EObject context, NegatedToken semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (
	 *         name=ID 
	 *         type=TypeRef? 
	 *         (definesHiddenTokens?='hidden' (hiddenTokens+=[AbstractRule|ID] hiddenTokens+=[AbstractRule|ID]*)?)? 
	 *         alternatives=Alternatives
	 *     )
	 */
	protected void sequence_ParserRule(EObject context, ParserRule semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (ePackage=[EPackage|STRING] alias=ID?)
	 */
	protected void sequence_ReferencedMetamodel(EObject context, ReferencedMetamodel semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     rule=[AbstractRule|ID]
	 */
	protected void sequence_RuleCall(EObject context, RuleCall semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (rule=[AbstractRule|ID] (cardinality='?' | cardinality='*' | cardinality='+')?)
	 */
	protected void sequence_RuleCall_TerminalToken(EObject context, RuleCall semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (groups+=TerminalAlternatives_Alternatives_1_0 groups+=TerminalGroup+)
	 */
	protected void sequence_TerminalAlternatives(EObject context, Alternatives semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (groups+=TerminalAlternatives_Alternatives_1_0 groups+=TerminalGroup+ (cardinality='?' | cardinality='*' | cardinality='+')?)
	 */
	protected void sequence_TerminalAlternatives_TerminalToken(EObject context, Alternatives semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (tokens+=TerminalGroup_Group_1_0 tokens+=TerminalToken+)
	 */
	protected void sequence_TerminalGroup(EObject context, Group semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (tokens+=TerminalGroup_Group_1_0 tokens+=TerminalToken+ (cardinality='?' | cardinality='*' | cardinality='+')?)
	 */
	protected void sequence_TerminalGroup_TerminalToken(EObject context, Group semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (name=ID type=TypeRef? alternatives=TerminalAlternatives)
	 */
	protected void sequence_TerminalRule(EObject context, TerminalRule semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (terminal=TerminalTokenElement (cardinality='?' | cardinality='*' | cardinality='+')?)
	 */
	protected void sequence_TerminalToken_UntilToken(EObject context, UntilToken semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     ((cardinality='?' | cardinality='*' | cardinality='+')?)
	 */
	protected void sequence_TerminalToken(EObject context, Wildcard semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (metamodel=[AbstractMetamodelDeclaration|ID]? classifier=[EClassifier|ID])
	 */
	protected void sequence_TypeRef(EObject context, TypeRef semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     terminal=TerminalTokenElement
	 */
	protected void sequence_UntilToken(EObject context, UntilToken semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     {Wildcard}
	 */
	protected void sequence_Wildcard(EObject context, Wildcard semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
}
