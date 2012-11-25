package org.eclipse.xtext.xbase.jvmmodel

import com.google.inject.Inject
import org.eclipse.emf.common.notify.impl.AdapterImpl
import org.eclipse.xtext.common.types.JvmConstructor
import org.eclipse.xtext.common.types.JvmIdentifiableElement
import org.eclipse.xtext.xbase.compiler.CompilationStrategyAdapter
import org.eclipse.xtext.xbase.compiler.output.ITreeAppendable
import org.eclipse.emf.ecore.util.EcoreUtil

class JvmTypeExtensions {
	
	@Inject extension ILogicalContainerProvider 
	
	def (ITreeAppendable)=>void getCompilationStrategy(JvmIdentifiableElement it) {
		val adapter = eAdapters.filter(typeof(CompilationStrategyAdapter)).head
		return adapter?.compilationStrategy
	}
	
	def isSingleSyntheticDefaultConstructor(JvmConstructor it) {
		return parameters.empty && associatedExpression == null && compilationStrategy == null && declaringType.members.filter(typeof(JvmConstructor)).size == 1
	}
	
	def isSynthetic(JvmIdentifiableElement element) {
		element.metaData.synthetic
	}
	
	def void setSynthetic(JvmIdentifiableElement element, boolean isSynthetic) {
		element.metaData.synthetic = isSynthetic
	}
	
	def protected JvmIdentifiableMetaData getMetaData(JvmIdentifiableElement element) {
		var metaData = EcoreUtil::getAdapter(element.eAdapters, typeof(JvmIdentifiableMetaData)) as JvmIdentifiableMetaData
		if (metaData == null) {
			metaData = new JvmIdentifiableMetaData
			element.eAdapters += metaData
		}
		return metaData
	}
	
}

class JvmIdentifiableMetaData extends AdapterImpl {
	@Property boolean synthetic
	
	override isAdapterForType(Object type) {
		typeof(JvmIdentifiableMetaData) == type
	}
	
}