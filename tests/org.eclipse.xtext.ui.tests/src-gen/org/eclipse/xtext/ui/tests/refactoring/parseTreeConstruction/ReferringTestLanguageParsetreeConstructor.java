/*
* generated by Xtext
*/
package org.eclipse.xtext.ui.tests.refactoring.parseTreeConstruction;

import org.eclipse.emf.ecore.*;
import org.eclipse.xtext.*;
import org.eclipse.xtext.parsetree.reconstr.IEObjectConsumer;
import org.eclipse.xtext.parsetree.reconstr.impl.AbstractParseTreeConstructor;

import org.eclipse.xtext.ui.tests.refactoring.services.ReferringTestLanguageGrammarAccess;

import com.google.inject.Inject;

@SuppressWarnings("all")
public class ReferringTestLanguageParsetreeConstructor extends AbstractParseTreeConstructor {
		
	@Inject
	private ReferringTestLanguageGrammarAccess grammarAccess;
	
	@Override
	protected AbstractToken getRootToken(IEObjectConsumer inst) {
		return new ThisRootNode(inst);	
	}
	
protected class ThisRootNode extends RootToken {
	public ThisRootNode(IEObjectConsumer inst) {
		super(inst);
	}
	
	@Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new Main_ReferencedAssignment(this, this, 0, inst);
			case 1: return new Reference_Group(this, this, 1, inst);
			default: return null;
		}	
	}	
}
	

/************ begin Rule Main ****************
 *
 * Main:
 * 	referenced+=Reference*;
 *
 **/

// referenced+=Reference*
protected class Main_ReferencedAssignment extends AssignmentToken  {
	
	public Main_ReferencedAssignment(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Assignment getGrammarElement() {
		return grammarAccess.getMainAccess().getReferencedAssignment();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new Reference_Group(this, this, 0, inst);
			default: return null;
		}	
	}

    @Override	
	public IEObjectConsumer tryConsume() {
		if((value = eObjectConsumer.getConsumable("referenced",false)) == null) return null;
		IEObjectConsumer obj = eObjectConsumer.cloneAndConsume("referenced");
		if(value instanceof EObject) { // org::eclipse::xtext::impl::RuleCallImpl
			IEObjectConsumer param = createEObjectConsumer((EObject)value);
			if(param.isInstanceOf(grammarAccess.getReferenceRule().getType().getClassifier())) {
				type = AssignmentType.PARSER_RULE_CALL;
				element = grammarAccess.getMainAccess().getReferencedReferenceParserRuleCall_0(); 
				consumed = obj;
				return param;
			}
		}
		return null;
	}

    @Override
	public AbstractToken createFollowerAfterReturn(AbstractToken next,	int actIndex, int index, IEObjectConsumer inst) {
		if(value == inst.getEObject() && !inst.isConsumed()) return null;
		switch(index) {
			case 0: return new Main_ReferencedAssignment(lastRuleCallOrigin, next, actIndex, consumed);
			default: return lastRuleCallOrigin.createFollowerAfterReturn(next, actIndex , index - 1, consumed);
		}	
	}	
}

/************ end Rule Main ****************/


/************ begin Rule Reference ****************
 *
 * Reference:
 * 	"ref" referenced=[ecore::EObject|FQN];
 *
 **/

// "ref" referenced=[ecore::EObject|FQN]
protected class Reference_Group extends GroupToken {
	
	public Reference_Group(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Group getGrammarElement() {
		return grammarAccess.getReferenceAccess().getGroup();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new Reference_ReferencedAssignment_1(lastRuleCallOrigin, this, 0, inst);
			default: return null;
		}	
	}

    @Override
	public IEObjectConsumer tryConsume() {
		if(getEObject().eClass() != grammarAccess.getReferenceRule().getType().getClassifier())
			return null;
		return eObjectConsumer;
	}

}

// "ref"
protected class Reference_RefKeyword_0 extends KeywordToken  {
	
	public Reference_RefKeyword_0(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Keyword getGrammarElement() {
		return grammarAccess.getReferenceAccess().getRefKeyword_0();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			default: return lastRuleCallOrigin.createFollowerAfterReturn(this, index, index, inst);
		}	
	}

}

// referenced=[ecore::EObject|FQN]
protected class Reference_ReferencedAssignment_1 extends AssignmentToken  {
	
	public Reference_ReferencedAssignment_1(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Assignment getGrammarElement() {
		return grammarAccess.getReferenceAccess().getReferencedAssignment_1();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new Reference_RefKeyword_0(lastRuleCallOrigin, this, 0, inst);
			default: return null;
		}	
	}

    @Override	
	public IEObjectConsumer tryConsume() {
		if((value = eObjectConsumer.getConsumable("referenced",true)) == null) return null;
		IEObjectConsumer obj = eObjectConsumer.cloneAndConsume("referenced");
		if(value instanceof EObject) { // org::eclipse::xtext::impl::CrossReferenceImpl
			IEObjectConsumer param = createEObjectConsumer((EObject)value);
			if(param.isInstanceOf(grammarAccess.getReferenceAccess().getReferencedEObjectCrossReference_1_0().getType().getClassifier())) {
				type = AssignmentType.CROSS_REFERENCE;
				element = grammarAccess.getReferenceAccess().getReferencedEObjectCrossReference_1_0(); 
				return obj;
			}
		}
		return null;
	}

}


/************ end Rule Reference ****************/


}
