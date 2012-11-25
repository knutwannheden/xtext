package org.eclipse.xtext.grammarinheritance.serializer;

import com.google.inject.Inject;
import com.google.inject.Provider;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.grammarinheritance.ametamodel.AModel;
import org.eclipse.xtext.grammarinheritance.ametamodel.AType;
import org.eclipse.xtext.grammarinheritance.ametamodel.AmetamodelPackage;
import org.eclipse.xtext.grammarinheritance.services.AbstractTestLanguageGrammarAccess;
import org.eclipse.xtext.serializer.acceptor.ISemanticSequenceAcceptor;
import org.eclipse.xtext.serializer.acceptor.SequenceFeeder;
import org.eclipse.xtext.serializer.diagnostic.ISemanticSequencerDiagnosticProvider;
import org.eclipse.xtext.serializer.diagnostic.ISerializationDiagnostic.Acceptor;
import org.eclipse.xtext.serializer.sequencer.AbstractDelegatingSemanticSequencer;
import org.eclipse.xtext.serializer.sequencer.GenericSequencer;
import org.eclipse.xtext.serializer.sequencer.ISemanticNodeProvider.INodesForEObjectProvider;
import org.eclipse.xtext.serializer.sequencer.ISemanticSequencer;
import org.eclipse.xtext.serializer.sequencer.ITransientValueService;
import org.eclipse.xtext.serializer.sequencer.ITransientValueService.ValueTransient;

@SuppressWarnings("all")
public abstract class AbstractAbstractTestLanguageSemanticSequencer extends AbstractDelegatingSemanticSequencer {

	@Inject
	private AbstractTestLanguageGrammarAccess grammarAccess;
	
	public void createSequence(EObject context, EObject semanticObject) {
		if(semanticObject.eClass().getEPackage() == AmetamodelPackage.eINSTANCE) switch(semanticObject.eClass().getClassifierID()) {
			case AmetamodelPackage.AMODEL:
				if(context == grammarAccess.getAbstractCallExtendedParserRuleRule()) {
					sequence_AbstractCallExtendedParserRule(context, (AModel) semanticObject); 
					return; 
				}
				else if(context == grammarAccess.getAbstractCallOverridenParserRuleRule()) {
					sequence_AbstractCallOverridenParserRule(context, (AModel) semanticObject); 
					return; 
				}
				else break;
			case AmetamodelPackage.ATYPE:
				if(context == grammarAccess.getExtendableParserRuleRule()) {
					sequence_ExtendableParserRule(context, (AType) semanticObject); 
					return; 
				}
				else if(context == grammarAccess.getInheritedParserRuleRule()) {
					sequence_InheritedParserRule(context, (AType) semanticObject); 
					return; 
				}
				else if(context == grammarAccess.getOverridableParserRule2Rule()) {
					sequence_OverridableParserRule2(context, (AType) semanticObject); 
					return; 
				}
				else if(context == grammarAccess.getOverridableParserRuleRule()) {
					sequence_OverridableParserRule(context, (AType) semanticObject); 
					return; 
				}
				else break;
			}
		if (errorAcceptor != null) errorAcceptor.accept(diagnosticProvider.createInvalidContextOrTypeDiagnostic(semanticObject, context));
	}
	
	/**
	 * Constraint:
	 *     elements+=ExtendableParserRule*
	 */
	protected void sequence_AbstractCallExtendedParserRule(EObject context, AModel semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     elements+=OverridableParserRule*
	 */
	protected void sequence_AbstractCallOverridenParserRule(EObject context, AModel semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     name=ID
	 */
	protected void sequence_ExtendableParserRule(EObject context, AType semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, AmetamodelPackage.Literals.ATYPE__NAME) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, AmetamodelPackage.Literals.ATYPE__NAME));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getExtendableParserRuleAccess().getNameIDTerminalRuleCall_1_0(), semanticObject.getName());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     name=ID
	 */
	protected void sequence_InheritedParserRule(EObject context, AType semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, AmetamodelPackage.Literals.ATYPE__NAME) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, AmetamodelPackage.Literals.ATYPE__NAME));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getInheritedParserRuleAccess().getNameIDTerminalRuleCall_1_0(), semanticObject.getName());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     name=STRING
	 */
	protected void sequence_OverridableParserRule2(EObject context, AType semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, AmetamodelPackage.Literals.ATYPE__NAME) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, AmetamodelPackage.Literals.ATYPE__NAME));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getOverridableParserRule2Access().getNameSTRINGTerminalRuleCall_1_0(), semanticObject.getName());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     name=ID
	 */
	protected void sequence_OverridableParserRule(EObject context, AType semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, AmetamodelPackage.Literals.ATYPE__NAME) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, AmetamodelPackage.Literals.ATYPE__NAME));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getOverridableParserRuleAccess().getNameIDTerminalRuleCall_1_0(), semanticObject.getName());
		feeder.finish();
	}
}
