package org.eclipse.xtext.xbase.ui.tests.refactoring

import javax.inject.Inject
import org.eclipse.jface.text.TextSelection
import org.eclipse.xtext.junit4.InjectWith
import org.eclipse.xtext.junit4.XtextRunner
import org.eclipse.xtext.junit4.util.ParseHelper
import org.eclipse.xtext.junit4.validation.ValidationTestHelper
import org.eclipse.xtext.resource.ILocationInFileProvider
import org.eclipse.xtext.resource.XtextResource
import org.eclipse.xtext.xbase.XExpression
import org.eclipse.xtext.xbase.ui.refactoring.ExpressionUtil
import org.junit.Test
import org.junit.runner.RunWith
import org.eclipse.xtext.xbase.tests.XbaseInjectorProvider

import static org.junit.Assert.*

/**
 * @author Jan Koehnlein
 */
@RunWith(typeof(XtextRunner))
@InjectWith(typeof(XbaseInjectorProvider))
class ExpressionUtilTest {

	@Inject ExpressionUtil util
	
	@Inject ParseHelper<XExpression> parseHelper
	
	@Inject ValidationTestHelper validationHelper
	
	@Inject ILocationInFileProvider locationInFileProvider
	
	@Test
	def testSelectedExpression() {
		assertExpressionSelected('$$123+456', '123')
		assertExpressionSelected('$1$23+456', '123')
		assertExpressionSelected('$12$3+456', '123')
		assertExpressionSelected('$123$+456', '123')
		assertExpressionSelected('1$$23+456', '123')
		assertExpressionSelected('12$$3+456', '123')
		assertExpressionSelected('123$$+456', '123')
		assertExpressionSelected('123+$$456', '456')
		assertExpressionSelected('123$+$456', '123+456')
		assertExpressionSelected('12$3+$456', '123+456')
		assertExpressionSelected('123$+4$56', '123+456')
		
		assertExpressionSelected('if($$true) null', 'true')
		assertExpressionSelected('if(true$$) null', 'true')
		assertExpressionSelected('if(true)$$ null', 'if(true) null')
		assertExpressionSelected('if(true) null$$ else null', 'null')
		assertExpressionSelected('if(true) null $$else null', 'if(true) null else null')

		assertExpressionSelected("newArrayList('jan','hein','claas','pit').map[$it|toFirstUpper]$", '[it|toFirstUpper]')
		assertExpressionSelected("newArrayList('jan','hein','claas','pit').map[it$|$toFirstUpper]", '[it|toFirstUpper]')
		assertExpressionSelected("newArrayList('jan','hein','claas','pit').map$[it|toFirstUpper]$", '[it|toFirstUpper]')
		assertExpressionSelected("newArrayList('jan','hein','claas','pit').map$[it|toFirstUpper$]", '[it|toFirstUpper]')
	}

	@Test
	def testSelectedExpressions() {
		assertSiblingExpressionsSelected('$$123+456', '123')
		assertSiblingExpressionsSelected('$1$23+456', '123')
		assertSiblingExpressionsSelected('$12$3+456', '123')
		assertSiblingExpressionsSelected('$123$+456', '123')
		assertSiblingExpressionsSelected('1$$23+456', '123')
		assertSiblingExpressionsSelected('12$$3+456', '123')
		assertSiblingExpressionsSelected('123$$+456', '123')
		assertSiblingExpressionsSelected('123+$$456', '456')
		assertSiblingExpressionsSelected('123$+$456', '123+456')
		assertSiblingExpressionsSelected('12$3+$456', '123+456')
		assertSiblingExpressionsSelected('123$+4$56', '123+456')
		
		assertSiblingExpressionsSelected('if($$true) null', 'true')
		assertSiblingExpressionsSelected('if(true$$) null', 'true')
		assertSiblingExpressionsSelected('if(true)$$ null', 'if(true) null')
		assertSiblingExpressionsSelected('if(true) null$$ else null', 'null')
		assertSiblingExpressionsSelected('if(true) null $$else null', 'if(true) null else null')
	}
	
	@Test
	def testSelectedExpressions_1() {
		assertSiblingExpressionsSelected('{ val x=$1 val y=3$ val z=5 }', 'val x=1 val y=3')
		assertSiblingExpressionsSelected('{ val x=1$ val y=3 $val z=5 }', 'val y=3')
		assertSiblingExpressionsSelected('{ val x=1 $val y=3$ val z=5 }', 'val y=3')
		assertSiblingExpressionsSelected('{ val x=1 $val y=3 $val z=5 }', 'val y=3')
		assertSiblingExpressionsSelected('{ val x=1 $val y=3 v$al z=5 }', 'val y=3 val z=5')
	}

	@Test
	def testInsertionPoint() {
		assertInsertionPoint('{ val x = 1 $2+3 }', '2+3')
		assertInsertionPoint('{ val x = 1 2$+3 }', '2+3')
		assertInsertionPoint('{ val x = 1 2+$3 }', '2+3')
		assertInsertionPoint('{ val x = $1 2+$3 }', 'val x = 1')
		assertInsertionPoint('{ val x = 1$ 2+$3 }', 'val x = 1')
	}

	@Test 
	def testInsertionPointIf() {
		assertInsertionPoint('if($1==2) true', null)
		assertInsertionPoint('{ if($1==2) true }', 'if(1==2) true')
		assertInsertionPoint('if(1==2) $true', 'true')
		assertInsertionPoint('if(1==2) true else $false', 'false')
		assertInsertionPoint('if(1==2) { val x = 7 + $8 }', 'val x = 7 + 8')
	}
	
	@Test 
	def testInsertionPointSwitch() {
		assertInsertionPoint('switch 1 { case 1: 2+$3 }', '2+3')
		assertInsertionPoint('switch 1 { case 2: true default: 2+$3 }', '2+3')
	}
		
	@Test 
	def testInsertionPointWhile() {
		assertInsertionPoint('while(true) new $String()', 'new String()')
		assertInsertionPoint('while($true) new $String()', null)
		assertInsertionPoint('do new $String() while(true)', 'new String()')
		assertInsertionPoint('do new String() while($true)', null)
	}
	
	@Test 
	def testInsertionPointFor() {
		assertInsertionPoint('for(i: 1..2) new $String()', 'new String()')
		assertInsertionPoint('for(i: $1..2) new $String()', null)
	}
	
	@Test 
	def testInsertionPointClosure() {
		assertInsertionPoint('[|2+$3]', '2+3')
	}
	
	@Test 
	def testInsertionPointTry() {
		assertInsertionPoint('try 2+$3 catch(Exception e) true', '2+3')
		assertInsertionPoint('try true catch(Exception e) new $String()', 'new String()')
		assertInsertionPoint('try true finally new $String()', 'new String()')
	}

	def protected assertExpressionSelected(String modelWithSelectionMarkup, String expectedSelection) {
		val cleanedModel = modelWithSelectionMarkup.replaceAll("\\$", "")
		val expression = cleanedModel.parse()
		val selectionOffset = modelWithSelectionMarkup.indexOf("$")
		val selectionLength = modelWithSelectionMarkup.lastIndexOf("$")- selectionOffset - 1
		val selectedExpression = util.findSelectedExpression(expression.eResource as XtextResource, 
			new TextSelection(selectionOffset, selectionLength))
		val selectedRegion = locationInFileProvider.getFullTextRegion(selectedExpression)
		assertEquals(expectedSelection, cleanedModel.substring(selectedRegion.offset, selectedRegion.offset + selectedRegion.length))
	}

	def protected assertSiblingExpressionsSelected(String modelWithSelectionMarkup, String expectedSelection) {
		val cleanedModel = modelWithSelectionMarkup.replaceAll("\\$", "")
		val expression = cleanedModel.parse()
		val selectionOffset = modelWithSelectionMarkup.indexOf("$")
		val selectionLength = modelWithSelectionMarkup.lastIndexOf("$")- selectionOffset - 1
		val selectedExpressions = util.findSelectedSiblingExpressions(expression.eResource as XtextResource, 
			new TextSelection(selectionOffset, selectionLength))
		val selectedRegion = selectedExpressions
			.map[locationInFileProvider.getFullTextRegion(it)]
			.reduce[a,b| a.merge(b)]
		assertEquals(expectedSelection, cleanedModel.substring(selectedRegion.offset, selectedRegion.offset + selectedRegion.length))
	}

	def protected assertInsertionPoint(String modelWithInsertionMarkup, String expectedSuccessor) {
		val cleanedModel = modelWithInsertionMarkup.replaceAll("\\$", "")
		val expression = cleanedModel.parse()
		val selectionOffset = modelWithInsertionMarkup.indexOf("$") 
		val selectedExpression = util.findSelectedExpression(expression.eResource as XtextResource, 
			new TextSelection(selectionOffset, 0))
		val successor = util.findSuccessorExpressionForVariableDeclaration(selectedExpression)
		if(expectedSuccessor == null) 
			assertNull(successor)
		else {
			assertNotNull(successor)
			val selectedRegion = locationInFileProvider.getFullTextRegion(successor)
			assertEquals(expectedSuccessor, cleanedModel.substring(selectedRegion.offset, selectedRegion.offset + selectedRegion.length))
		}
	}

	def protected parse(CharSequence string)  {
		val expression = parseHelper.parse(string)
		validationHelper.assertNoErrors(expression)
		expression
	}
}