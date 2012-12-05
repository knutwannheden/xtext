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
public class ReceiverFeatureScope extends AbstractSessionBasedScope {

	private final TypeBucket bucket;
	private final OperatorMapping operatorMapping;
	private final LightweightTypeReference receiverType;
	private final XExpression receiver;
	private final boolean implicit;
	private Map<JvmTypeParameter, LightweightMergedBoundTypeArgument> receiverTypeParameterMapping;

	protected ReceiverFeatureScope(IScope parent, IFeatureScopeSession session, XExpression receiver, LightweightTypeReference receiverType, boolean implicit,
			XAbstractFeatureCall featureCall, TypeBucket bucket, OperatorMapping operatorMapping) {
		super(parent, session, featureCall);
		this.receiver = receiver;
		this.receiverType = receiverType;
		this.implicit = implicit;
		this.bucket = bucket;
		this.operatorMapping = operatorMapping;
	}
	
	@Override
	protected Collection<IEObjectDescription> getLocalElementsByName(QualifiedName name) {
		final Set<JvmFeature> allFeatures = Sets.newLinkedHashSet();
		processFeatureNames(name, new NameAcceptor() {
			public void accept(String simpleName, int order) {
				for(JvmType type: bucket.getTypes()) {
					if (type instanceof JvmDeclaredType) {
						Iterable<JvmFeature> features = ((JvmDeclaredType) type).findAllFeaturesByName(simpleName);
						Iterables.addAll(allFeatures, features);
					}
				}
			}
		});
		if (allFeatures.isEmpty())
			return Collections.emptyList();
		List<IEObjectDescription> allDescriptions = Lists.newArrayListWithCapacity(allFeatures.size());
		for(JvmFeature feature: allFeatures) {
			allDescriptions.add(createDescription(name, feature, bucket));
		}
		return allDescriptions;
	}

	protected IEObjectDescription createDescription(QualifiedName name, JvmFeature feature, TypeBucket bucket) {
		// TODO handle static features
		if (implicit) {
			if (feature.isStatic())
				return new StaticFeatureDescription(name, feature, bucket.getId(), getSession().isVisible(feature));
			return new InstanceFeatureDescriptionWithImplicitReceiver(name, feature, receiver, receiverType, getReceiverTypeParameterMapping(), bucket.getId(), getSession().isVisible(feature));
		}
		return new InstanceFeatureDescription(name, feature, receiver, receiverType, getReceiverTypeParameterMapping(), bucket.getId(), getSession().isVisible(feature));
	}

	protected Map<JvmTypeParameter, LightweightMergedBoundTypeArgument> getReceiverTypeParameterMapping() {
		if (receiverTypeParameterMapping == null) {
			receiverTypeParameterMapping = Collections.emptyMap();
			if (receiverType != null) {
				receiverTypeParameterMapping = new DeclaratorTypeArgumentCollector().getTypeParameterMapping(receiverType);
			}
		}
		return receiverTypeParameterMapping;
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

	@Override
	protected Iterable<IEObjectDescription> getAllLocalElements() {
		Set<JvmFeature> allFeatures = Sets.newLinkedHashSet();
		for(JvmType type: bucket.getTypes()) {
			if (type instanceof JvmDeclaredType) {
				Iterable<JvmFeature> features = ((JvmDeclaredType) type).getAllFeatures();
				Iterables.addAll(allFeatures, features);
			}
		}
		if (allFeatures.isEmpty())
			return Collections.emptyList();
		List<IEObjectDescription> allDescriptions = Lists.newArrayListWithCapacity(allFeatures.size());
		for(JvmFeature feature: allFeatures) {
			QualifiedName featureName = QualifiedName.create(feature.getSimpleName());
			// TODO property names?
			allDescriptions.add(createDescription(featureName, feature, bucket));
			QualifiedName operator = operatorMapping.getOperator(featureName);
			if (operator != null) {
				allDescriptions.add(createDescription(operator, feature, bucket));
			}
		}
		return allDescriptions;
	}

}
