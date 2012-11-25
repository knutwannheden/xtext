package org.eclipse.xtext.xbase.ui.tests.refactoring

import com.google.inject.Provider
import javax.inject.Inject
import org.eclipse.jface.text.TextSelection
import org.eclipse.xtext.junit4.InjectWith
import org.eclipse.xtext.junit4.XtextRunner
import org.eclipse.xtext.junit4.util.ParseHelper
import org.eclipse.xtext.junit4.validation.ValidationTestHelper
import org.eclipse.xtext.resource.XtextResource
import org.eclipse.xtext.xbase.XExpression
import org.eclipse.xtext.xbase.tests.XbaseInjectorProvider
import org.eclipse.xtext.xbase.ui.refactoring.ExpressionUtil
import org.eclipse.xtext.xbase.ui.refactoring.NewFeatureNameUtil
import org.junit.Test
import org.junit.runner.RunWith
import org.eclipse.ltk.core.refactoring.RefactoringStatus

import static org.junit.Assert.*
import static org.eclipse.ltk.core.refactoring.RefactoringStatus.*

/**
 * @author Jan Koehnlein
 */
@RunWith(typeof(XtextRunner))
@InjectWith(typeof(XbaseInjectorProvider))
class NewFeatureNameUtilTest {

	@Inject ExpressionUtil util
	
	@Inject Provider<NewFeatureNameUtil> nameUtilProvider 
	
	@Inject ParseHelper<XExpression> parseHelper
	
	@Inject ValidationTestHelper validationHelper
	
	@Test
	def testDefaultNamePrimitive() {
		assertDefaultName('{2+$3}', 'i')
		assertDefaultName('{2+$3f}', 'f')
		assertDefaultName('{2+$3l}', 'l')
		assertDefaultName('{2+$3.0}', 'd')
		assertDefaultName('{$true}', 'b')
	}

	@Test
	def testDefaultNameFeatureCall() {
		assertDefaultName('{val CAMEL_CASE_NAME = 1 $CAMEL_CASE_NAME}', 'camelCaseName')
		assertDefaultName('{"".$getBytes}', 'bytes')
		assertDefaultName('{"".$length}', 'length')
	}

	@Test
	def testDefaultNameType() {
		assertDefaultName('{$2+3$}', 'i')
		assertDefaultName('{"$"}', 'string')
	}

	@Test
	def testDefaultNameAlternate() {
		assertDefaultName('{val i=1 2+$3}', 'i1')
		assertDefaultName('{val j=2+$3 val i=1}', 'i1')
		assertDefaultName('{val i=1 {val j=2+$3}}', 'i1')
		assertDefaultName('{val i=1 {val i1=1 val j=2+$3}}', 'i2')
		assertDefaultName('{{val j=2+$3} val i=1 }', 'i')
	}

	@Test
	def testDefaultNameClosure() {
		assertDefaultName('{newArrayList("").map[toFirstUpper]$$}', 'function')
	}
		
	@Test 
	def testInvalidNameNull() {
		assertInvalidName(null, FATAL, "Choose a name")
		"".assertInvalidName(FATAL, "Choose a name")
	}

	@Test 
	def testInvalidNameSyntax() {
		"%".assertInvalidName(FATAL, "character")
		"g�rkenbr�d".assertInvalidName(FATAL, "character")
		"&".assertInvalidName(FATAL, "character")
	}

	@Test 
	def testInvalidNameKeyword() {
		"if".assertInvalidName(FATAL, "keyword")
		"else".assertInvalidName(FATAL, "keyword")
		"while".assertInvalidName(FATAL, "keyword")
		"do".assertInvalidName(FATAL, "keyword")
		"switch".assertInvalidName(FATAL, "keyword")
		"case".assertInvalidName(FATAL, "keyword")
	}

	@Test 
	def testInvalidNamePrimitive() {
		"boolean".assertInvalidName(FATAL, "reserved")
		"short".assertInvalidName(FATAL, "reserved")
		"char".assertInvalidName(FATAL, "reserved")
		"int".assertInvalidName(FATAL, "reserved")
		"long".assertInvalidName(FATAL, "reserved")
		"float".assertInvalidName(FATAL, "reserved")
		"double".assertInvalidName(FATAL, "reserved")
	}

	@Test 
	def testInvalidNameUpperCase() {
		"CamelCase".assertInvalidName(ERROR, "lowercase")
	}

	def protected assertDefaultName(String modelWithSelectionMarkup, String expectedName) {
		val cleanedModel = modelWithSelectionMarkup.replaceAll("\\$", "")
		val expression = cleanedModel.parse()
		val selectionOffset = modelWithSelectionMarkup.indexOf("$")
		val selectionLength = modelWithSelectionMarkup.lastIndexOf("$")- selectionOffset - 1
		val selectedExpression = util.findSelectedExpression(expression.eResource as XtextResource, 
			new TextSelection(selectionOffset, selectionLength))
		val successor = util.findSuccessorExpressionForVariableDeclaration(selectedExpression)
		val nameUtil = nameUtilProvider.get()
		nameUtil.setFeatureScopeContext(successor)
		val defaultName = nameUtil.getDefaultName(selectedExpression)
		assertEquals(expectedName, defaultName)
	}
	
	def protected assertInvalidName(String name, int severity, String messageFragment) {
		val status = new RefactoringStatus
		val nameUtil = nameUtilProvider.get()
		nameUtil.checkNewFeatureName(name, false, status)
		assertEquals(severity, status.severity)
		val message = status.entryWithHighestSeverity.message
		assertTrue(message, message.contains(messageFragment))
	}

	def protected parse(CharSequence string)  {
		val expression = parseHelper.parse(string)
		validationHelper.assertNoErrors(expression)
		expression
	}
}

