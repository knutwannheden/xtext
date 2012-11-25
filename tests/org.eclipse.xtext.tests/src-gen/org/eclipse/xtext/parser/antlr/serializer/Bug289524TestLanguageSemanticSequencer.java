package org.eclipse.xtext.parser.antlr.serializer;

import com.google.inject.Inject;
import com.google.inject.Provider;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.bug289524Test.Bug289524TestPackage;
import org.eclipse.xtext.parser.antlr.bug289524Test.Contained;
import org.eclipse.xtext.parser.antlr.bug289524Test.Model;
import org.eclipse.xtext.parser.antlr.bug289524Test.ModelElement;
import org.eclipse.xtext.parser.antlr.services.Bug289524TestLanguageGrammarAccess;
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
public class Bug289524TestLanguageSemanticSequencer extends AbstractDelegatingSemanticSequencer {

	@Inject
	private Bug289524TestLanguageGrammarAccess grammarAccess;
	
	public void createSequence(EObject context, EObject semanticObject) {
		if(semanticObject.eClass().getEPackage() == Bug289524TestPackage.eINSTANCE) switch(semanticObject.eClass().getClassifierID()) {
			case Bug289524TestPackage.CONTAINED:
				if(context == grammarAccess.getContainedRule()) {
					sequence_Contained(context, (Contained) semanticObject); 
					return; 
				}
				else break;
			case Bug289524TestPackage.MODEL:
				if(context == grammarAccess.getModelRule()) {
					sequence_Model(context, (Model) semanticObject); 
					return; 
				}
				else break;
			case Bug289524TestPackage.MODEL_ELEMENT:
				if(context == grammarAccess.getModelElementRule()) {
					sequence_ModelElement(context, (ModelElement) semanticObject); 
					return; 
				}
				else break;
			}
		if (errorAcceptor != null) errorAcceptor.accept(diagnosticProvider.createInvalidContextOrTypeDiagnostic(semanticObject, context));
	}
	
	/**
	 * Constraint:
	 *     name=ID
	 */
	protected void sequence_Contained(EObject context, Contained semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, Bug289524TestPackage.Literals.CONTAINED__NAME) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, Bug289524TestPackage.Literals.CONTAINED__NAME));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getContainedAccess().getNameIDTerminalRuleCall_1_0(), semanticObject.getName());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     (containments+=Contained | (refs+=[Contained|ID] refs+=[Contained|ID]*))+
	 */
	protected void sequence_ModelElement(EObject context, ModelElement semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (refs+=ModelElement*)
	 */
	protected void sequence_Model(EObject context, Model semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
}
