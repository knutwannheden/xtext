/**
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.xbase;

import org.eclipse.emf.common.util.EList;

import org.eclipse.xtext.common.types.JvmIdentifiableElement;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>XSwitch Expression</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.xtext.xbase.XSwitchExpression#getSwitch <em>Switch</em>}</li>
 *   <li>{@link org.eclipse.xtext.xbase.XSwitchExpression#getCases <em>Cases</em>}</li>
 *   <li>{@link org.eclipse.xtext.xbase.XSwitchExpression#getDefault <em>Default</em>}</li>
 *   <li>{@link org.eclipse.xtext.xbase.XSwitchExpression#getLocalVarName <em>Local Var Name</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.xtext.xbase.XbasePackage#getXSwitchExpression()
 * @model
 * @generated
 */
public interface XSwitchExpression extends XExpression, JvmIdentifiableElement
{
	/**
	 * Returns the value of the '<em><b>Switch</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Switch</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Switch</em>' containment reference.
	 * @see #setSwitch(XExpression)
	 * @see org.eclipse.xtext.xbase.XbasePackage#getXSwitchExpression_Switch()
	 * @model containment="true"
	 * @generated
	 */
	XExpression getSwitch();

	/**
	 * Sets the value of the '{@link org.eclipse.xtext.xbase.XSwitchExpression#getSwitch <em>Switch</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Switch</em>' containment reference.
	 * @see #getSwitch()
	 * @generated
	 */
	void setSwitch(XExpression value);

	/**
	 * Returns the value of the '<em><b>Cases</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.xtext.xbase.XCasePart}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Cases</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Cases</em>' containment reference list.
	 * @see org.eclipse.xtext.xbase.XbasePackage#getXSwitchExpression_Cases()
	 * @model containment="true"
	 * @generated
	 */
	EList<XCasePart> getCases();

	/**
	 * Returns the value of the '<em><b>Default</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Default</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Default</em>' containment reference.
	 * @see #setDefault(XExpression)
	 * @see org.eclipse.xtext.xbase.XbasePackage#getXSwitchExpression_Default()
	 * @model containment="true"
	 * @generated
	 */
	XExpression getDefault();

	/**
	 * Sets the value of the '{@link org.eclipse.xtext.xbase.XSwitchExpression#getDefault <em>Default</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Default</em>' containment reference.
	 * @see #getDefault()
	 * @generated
	 */
	void setDefault(XExpression value);

	/**
	 * Returns the value of the '<em><b>Local Var Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Local Var Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Local Var Name</em>' attribute.
	 * @see #setLocalVarName(String)
	 * @see org.eclipse.xtext.xbase.XbasePackage#getXSwitchExpression_LocalVarName()
	 * @model
	 * @generated
	 */
	String getLocalVarName();

	/**
	 * Sets the value of the '{@link org.eclipse.xtext.xbase.XSwitchExpression#getLocalVarName <em>Local Var Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Local Var Name</em>' attribute.
	 * @see #getLocalVarName()
	 * @generated
	 */
	void setLocalVarName(String value);

} // XSwitchExpression
