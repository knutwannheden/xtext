/**
 * <copyright>
 * </copyright>
 *
 */
package org.eclipse.xtext.common.types;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Jvm Delegate Type Reference</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.xtext.common.types.JvmDelegateTypeReference#getDelegate <em>Delegate</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.xtext.common.types.TypesPackage#getJvmDelegateTypeReference()
 * @model
 * @since 2.1
 * @generated
 */
public interface JvmDelegateTypeReference extends JvmTypeReference
{
	/**
	 * Returns the value of the '<em><b>Delegate</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Delegate</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Delegate</em>' reference.
	 * @see #setDelegate(JvmTypeReference)
	 * @see org.eclipse.xtext.common.types.TypesPackage#getJvmDelegateTypeReference_Delegate()
	 * @model
	 * @generated
	 */
	JvmTypeReference getDelegate();

	/**
	 * Sets the value of the '{@link org.eclipse.xtext.common.types.JvmDelegateTypeReference#getDelegate <em>Delegate</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Delegate</em>' reference.
	 * @see #getDelegate()
	 * @generated
	 */
	void setDelegate(JvmTypeReference value);

} // JvmDelegateTypeReference