package org.eclipse.xtext.xbase.junit.formatter

import com.google.inject.Inject
import java.util.Collection
import org.eclipse.emf.ecore.EObject
import org.eclipse.xtext.junit4.util.ParseHelper
import org.eclipse.xtext.resource.XtextResource
import org.eclipse.xtext.xbase.configuration.MapBasedConfigurationValues
import org.eclipse.xtext.xbase.formatting.AbstractFormatter
import org.eclipse.xtext.xbase.formatting.IFormatter
import org.eclipse.xtext.xbase.formatting.IFormatterConfigKeys
import org.eclipse.xtext.xbase.formatting.TextReplacement
import org.junit.Assert

@SuppressWarnings("restriction")
class FormatterTester {
	@Inject extension ParseHelper<EObject>
	@Inject IFormatter formatter
	@Inject IFormatterConfigKeys keys

	def assertFormatted((AssertingFormatterData)=>void init) {
		val data = new AssertingFormatterData
		data.cfg = new MapBasedConfigurationValues(keys)
		init.apply(data)
		assertFormatted(data)
	}

	def assertFormatted(AssertingFormatterData it) {
		val fullToBeParsed = (prefix + toBeFormatted + postfix)
		val parsed = fullToBeParsed.parse
		if (!allowErrors)
			Assert::assertEquals(parsed.eResource.errors.join("\n"), 0, parsed.eResource.errors.size)
		val oldDocument = (parsed.eResource as XtextResource).parseResult.rootNode.text

		switch formatter { AbstractFormatter: formatter.allowIdentityEdits = true }

		// Step 1: Ensure formatted document equals expectation
		val start = prefix.length
		val length = toBeFormatted.length
		val edits = <TextReplacement>newLinkedHashSet
		edits += formatter.format(parsed.eResource as XtextResource, start, length, cfg)
		if (!allowErrors)
			edits += createMissingEditReplacements(parsed.eResource as XtextResource, edits, start, length)
		val newDocument = oldDocument.applyEdits(edits)
		try {
			Assert::assertEquals((prefix + expectation + postfix).toString, newDocument.toString)
		} catch (AssertionError e) {
			println(oldDocument.applyDebugEdits(edits))
			println()
			throw e
		}

		// Step 2: Ensure formatting the document again doesn't change the document
		val parsed2Doc = fullToBeParsed.applyEdits(
			formatter.format(parsed.eResource as XtextResource, 0, fullToBeParsed.length, cfg))
		val parsed2 = parsed2Doc.parse
		if (!allowErrors)
			Assert::assertEquals(0, parsed2.eResource.errors.size)
		val edits2 = formatter.format(parsed2.eResource as XtextResource, 0, parsed2Doc.length, cfg)
		val newDocument2 = parsed2Doc.applyEdits(edits2)
		try {
			Assert::assertEquals(parsed2Doc, newDocument2.toString)
		} catch (AssertionError e) {
			println(newDocument.applyDebugEdits(edits2))
			println()
			throw e
		}
	}

	def protected String applyEdits(String oldDocument, Collection<TextReplacement> edits) {
		var lastOffset = 0
		val newDocument = new StringBuilder()
		for (edit : edits.sortBy[offset]) {
			newDocument.append(oldDocument.substring(lastOffset, edit.offset))
			newDocument.append(edit.text)
			lastOffset = edit.offset + edit.length
		}
		newDocument.append(oldDocument.substring(lastOffset, oldDocument.length))
		newDocument.toString
	}

	def protected String applyDebugEdits(String oldDocument, Collection<TextReplacement> edits) {
		var lastOffset = 0
		val debugTrace = new StringBuilder()
		for (edit : edits.sortBy[offset]) {
			debugTrace.append(oldDocument.substring(lastOffset, edit.offset))
			debugTrace.append('''[�oldDocument.substring(edit.offset, edit.offset + edit.length)�|�edit.text�]''')
			lastOffset = edit.offset + edit.length
		}
		debugTrace.append(oldDocument.substring(lastOffset, oldDocument.length))
		debugTrace.toString
	}

	def protected createMissingEditReplacements(XtextResource res, Collection<TextReplacement> edits, int offset,
		int length) {
		val offsets = edits.map[it.offset].toSet
		val result = <TextReplacement>newArrayList
		var lastOffset = 0
		for (leaf : res.parseResult.rootNode.leafNodes)
			if (!leaf.hidden || !leaf.text.trim.nullOrEmpty) {
				if ((lastOffset >= offset) && (leaf.offset <= offset + length) && !offsets.contains(lastOffset))
					result += new TextReplacement(lastOffset, leaf.offset - lastOffset, "!!")
				lastOffset = leaf.offset + leaf.length
			}
		result
	}
}

class AssertingFormatterData {
	@Property MapBasedConfigurationValues cfg
	@Property CharSequence expectation
	@Property CharSequence toBeFormatted
	@Property String prefix
	@Property String postfix
	@Property boolean allowErrors
}
