package org.eclipse.xtext.example.domainmodel.tests

import com.google.inject.Inject
import org.junit.Assert
import org.eclipse.xtext.example.domainmodel.domainmodel.DomainModel
import org.eclipse.xtext.example.domainmodel.domainmodel.Entity
import org.eclipse.xtext.example.domainmodel.domainmodel.PackageDeclaration
import org.eclipse.xtext.example.domainmodel.domainmodel.Property
import org.eclipse.xtext.junit4.InjectWith
import org.eclipse.xtext.junit4.XtextRunner
import org.eclipse.xtext.junit4.util.ParseHelper
import org.eclipse.xtext.junit4.validation.ValidationTestHelper
import org.junit.Test
import org.junit.runner.RunWith
import org.eclipse.xtext.example.domainmodel.domainmodel.Operation
import org.eclipse.xtext.xbase.jvmmodel.IJvmModelAssociations
import org.eclipse.xtext.common.types.JvmOperation

@RunWith(typeof(XtextRunner))
@InjectWith(typeof(InjectorProviderCustom))
class ParserTest {
	
	@Inject extension ParseHelper<DomainModel>
	@Inject extension ValidationTestHelper
	@Inject extension IJvmModelAssociations

	@Test
	def void testParsing() {
		val model = '''
			package example {
			  entity MyEntity {
			    property : String
			  }
			}
		'''.parse
		
		val pack = model.getElements().get(0) as PackageDeclaration
		Assert::assertEquals("example", pack.getName())
		
		val entity = pack.getElements().get(0) as Entity
		Assert::assertEquals("MyEntity", entity.getName())
		
		val property = entity.getFeatures().get(0) as Property
		Assert::assertEquals("property", property.getName());
		Assert::assertEquals("java.lang.String", property.getType().getIdentifier());
	}
	
	@Test
	def void testParsingAndLinking() {
		'''
			package example {
			  entity MyEntity {
			    property : String
			    op foo(String s) : String {
			    	this.property = s
			    	return s.toUpperCase
			    }
			  }
			}
		'''.parse.assertNoErrors
	}
	
	@Test
	def void testReturnTypeInference() {
		val model = '''
			package example {
			  entity MyEntity {
			    property : String
			    op foo(String s) {
			    	return property.toUpperCase + s
			    }
			  }
			}
		'''.parse
		val pack = model.elements.head as PackageDeclaration
		val entity = pack.elements.head as Entity
		val op = entity.features.last as Operation
		val method = op.jvmElements.head as JvmOperation
		Assert::assertEquals("String", method.returnType.simpleName)
	}
}