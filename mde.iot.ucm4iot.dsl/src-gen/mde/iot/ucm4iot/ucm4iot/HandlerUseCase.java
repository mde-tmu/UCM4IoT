/**
 * generated by Xtext 2.25.0
 */
package mde.iot.ucm4iot.ucm4iot;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Handler Use Case</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link mde.iot.ucm4iot.ucm4iot.HandlerUseCase#getHandlerClass <em>Handler Class</em>}</li>
 *   <li>{@link mde.iot.ucm4iot.ucm4iot.HandlerUseCase#getContextExceptions <em>Context Exceptions</em>}</li>
 * </ul>
 *
 * @see mde.iot.ucm4iot.ucm4iot.Ucm4iotPackage#getHandlerUseCase()
 * @model
 * @generated
 */
public interface HandlerUseCase extends UseCase
{
  /**
   * Returns the value of the '<em><b>Handler Class</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Handler Class</em>' attribute.
   * @see #setHandlerClass(String)
   * @see mde.iot.ucm4iot.ucm4iot.Ucm4iotPackage#getHandlerUseCase_HandlerClass()
   * @model
   * @generated
   */
  String getHandlerClass();

  /**
   * Sets the value of the '{@link mde.iot.ucm4iot.ucm4iot.HandlerUseCase#getHandlerClass <em>Handler Class</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Handler Class</em>' attribute.
   * @see #getHandlerClass()
   * @generated
   */
  void setHandlerClass(String value);

  /**
   * Returns the value of the '<em><b>Context Exceptions</b></em>' containment reference list.
   * The list contents are of type {@link mde.iot.ucm4iot.ucm4iot.ContextExceptionMapping}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Context Exceptions</em>' containment reference list.
   * @see mde.iot.ucm4iot.ucm4iot.Ucm4iotPackage#getHandlerUseCase_ContextExceptions()
   * @model containment="true"
   * @generated
   */
  EList<ContextExceptionMapping> getContextExceptions();

} // HandlerUseCase
