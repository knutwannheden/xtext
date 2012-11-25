/*
Generated with Xtext
 */
package org.eclipse.xtext.parsetree.formatter;

import org.eclipse.xtext.formatting.IFormatter;
import org.eclipse.xtext.formatting.ILineSeparatorInformation;
import org.eclipse.xtext.formatting.IWhitespaceInformationProvider;

/**
 * used to register components to be used within the IDE.
 */
public class FormatterTestLanguageRuntimeModule extends
		AbstractFormatterTestLanguageRuntimeModule {

	@Override
	public Class<? extends IFormatter> bindIFormatter() {
		return FormatterTestConfig.class;
	}

	@Override
	public Class<? extends org.eclipse.xtext.conversion.IValueConverterService> bindIValueConverterService() {
		return FormatterTestValueConverters.class;
	}

	public Class<? extends ILineSeparatorInformation> bindILineSeparatorInformation() {
		return FormatterTestLineSeparatorInformation.class;
	} 
}
