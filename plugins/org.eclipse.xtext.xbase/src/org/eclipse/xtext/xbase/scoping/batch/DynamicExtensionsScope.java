/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.scoping.batch;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.xtext.common.types.JvmDeclaredType;
import org.eclipse.xtext.common.types.JvmFeature;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.common.types.JvmTypeParameter;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.scoping.IScope;
import org.eclipse.xtext.xbase.XAbstractFeatureCall;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.scoping.featurecalls.OperatorMapping;
import org.eclipse.xtext.xbase.typesystem.references.LightweightMergedBoundTypeArgument;
import org.eclipse.xtext.xbase.typesystem.references.LightweightTypeReference;
import org.eclipse.xtext.xbase.typesystem.util.DeclaratorTypeArgumentCollector;

import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import com.google.common.collect.Sets;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class DynamicExtensionsScope extends AbstractSessionBasedScope {

	private final OperatorMapping operatorMapping;
	private final XExpression firstArgument;
	private final LightweightTypeReference argumentType;
	private final boolean implicit;
	private Map<JvmTypeParameter, LightweightMergedBoundTypeArgument> argumentTypeParameterMapping;

	public DynamicExtensionsScope(IScope parent, IFeatureScopeSession session, 
			XExpression firstArgument, LightweightTypeReference argumentType, boolean implicit,
			XAbstractFeatureCall context, OperatorMapping operatorMapping) {
		super(parent, session, context);
		this.firstArgument = firstArgument;
		this.argumentType = argumentType;
		this.implicit = implicit;
		this.operatorMapping = operatorMapping;
	}
	
	protected Map<JvmTypeParameter, LightweightMergedBoundTypeArgument> getArgumentTypeParameterMapping() {
		if (argumentTypeParameterMapping == null) {
			argumentTypeParameterMapping = Collections.emptyMap();
			if (argumentType != null) {
				argumentTypeParameterMapping = new DeclaratorTypeArgumentCollector().getTypeParameterMapping(argumentType);
			}
		}
		return argumentTypeParameterMapping;
	}

	@Override
	protected Iterable<IEObjectDescription> getAllLocalElements() {
		List<ExpressionBucket> buckets = getBuckets();
		if (buckets.isEmpty()) {
			return Collections.emptyList();
		}
		List<IEObjectDescription> result = Lists.newArrayList();
		for (ExpressionBucket bucket : buckets) {
			Map<XExpression, LightweightTypeReference> extensionProviders = bucket.getExtensionProviders();
			for (Map.Entry<XExpression, LightweightTypeReference> extensionProvider : extensionProviders.entrySet()) {
				Set<JvmFeature> allFeatures = Sets.newLinkedHashSet();
				LightweightTypeReference extensionType = extensionProvider.getValue();
				List<JvmType> types = extensionType.getRawTypes();
				for (JvmType type : types) {
					if (type instanceof JvmDeclaredType) {
						Iterable<JvmFeature> features = ((JvmDeclaredType) type).getAllFeatures();
						Iterables.addAll(allFeatures, features);
					}
				}
				if (!allFeatures.isEmpty()) {
					for (JvmFeature feature : allFeatures) {
						addDescriptions(feature, extensionProvider.getKey(), extensionType, bucket, result);
					}
				}
			}
		}
		return result;
	}

	protected void addDescriptions(JvmFeature feature, XExpression receiver, LightweightTypeReference receiverType,
			ExpressionBucket bucket, List<IEObjectDescription> result) {
		// TODO property names?
		QualifiedName featureName = QualifiedName.create(feature.getSimpleName());
		if (firstArgument != null)
			result.add(createDescription(featureName, feature, receiver, receiverType, bucket));
		if (implicit) {
			result.add(createReceiverDescription(featureName, feature, receiver, receiverType, bucket));
		}
		QualifiedName operator = operatorMapping.getOperator(featureName);
		if (operator != null) {
			if (firstArgument != null)
				result.add(createDescription(operator, feature, receiver, receiverType, bucket));
			if (implicit) {
				result.add(createReceiverDescription(operator, feature, receiver, receiverType, bucket));
			}
		}
	}
	
	protected List<ExpressionBucket> getBuckets() {
		return getSession().getExtensionProviders();
	}
	
	@Override
	protected Collection<IEObjectDescription> getLocalElementsByName(final QualifiedName name) {
		final List<ExpressionBucket> buckets = getBuckets();
		if (buckets.isEmpty()) {
			return Collections.emptyList();
		}
		final List<IEObjectDescription> result = Lists.newArrayList();
		
		for (ExpressionBucket bucket : buckets) {
			Map<XExpression, LightweightTypeReference> extensionProviders = bucket.getExtensionProviders();
			for (Map.Entry<XExpression, LightweightTypeReference> extensionProvider : extensionProviders.entrySet()) {
				LightweightTypeReference extensionType = extensionProvider.getValue();
				if (extensionType == null)
					throw new IllegalStateException("extensionType is null");
				final List<JvmType> types = extensionType.getRawTypes();
				final Set<JvmFeature> allFeatures = Sets.newLinkedHashSet();
				processFeatureNames(name, new NameAcceptor() {
					public void accept(String simpleName, int order) {
						for(JvmType type: types) {
							if (type instanceof JvmDeclaredType) {
								Iterable<JvmFeature> features = ((JvmDeclaredType) type).findAllFeaturesByName(simpleName);
								Iterables.addAll(allFeatures, features);
							}
						}
					}
				});
				if (!allFeatures.isEmpty()) {
					for(JvmFeature feature: allFeatures) {
						if (firstArgument != null)
							result.add(createDescription(name, feature, extensionProvider.getKey(), extensionType, bucket));
						if (implicit) {
							result.add(createReceiverDescription(name, feature, extensionProvider.getKey(), extensionType, bucket));
						}
					}
				}
			}
		}
		return result;
	}

	@Override
	protected void processFeatureNames(QualifiedName name, NameAcceptor acceptor) {
		QualifiedName methodName = operatorMapping.getMethodName(name);
		if (methodName != null) {
			acceptor.accept(methodName.toString(), 2);
		} else {
			super.processFeatureNames(name, acceptor);
			processAsPropertyNames(name, acceptor);
		}
	}
	
	protected BucketedEObjectDescription createDescription(QualifiedName name, JvmFeature feature, XExpression receiver, LightweightTypeReference receiverType, ExpressionBucket bucket) {
		if (implicit) {
			return new InstanceExtensionDescriptionWithImplicitFirstArgument(name, feature, receiver, receiverType, Collections.<JvmTypeParameter, LightweightMergedBoundTypeArgument>emptyMap(), firstArgument, argumentType, getArgumentTypeParameterMapping(), bucket.getId(), getSession().isVisible(feature));
		}
		return new InstanceExtensionDescription(name, feature, receiver, receiverType, Collections.<JvmTypeParameter, LightweightMergedBoundTypeArgument>emptyMap(), firstArgument, argumentType, getArgumentTypeParameterMapping(), bucket.getId(), getSession().isVisible(feature));
	}
	
	protected BucketedEObjectDescription createReceiverDescription(QualifiedName name, JvmFeature feature, XExpression receiver, LightweightTypeReference receiverType, ExpressionBucket bucket) {
		return new InstanceFeatureDescriptionWithImplicitReceiver(name, feature, receiver, receiverType, Collections.<JvmTypeParameter, LightweightMergedBoundTypeArgument>emptyMap(), bucket.getId(), getSession().isVisible(feature));
	}
	
}
