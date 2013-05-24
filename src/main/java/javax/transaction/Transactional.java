package javax.transaction;


import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.interceptor.InterceptorBinding;
import javax.enterprise.util.Nonbinding;


  /**
   * Annotation used by applications to control transaction boundaries on CDI managed beans, as well as
   * classes defined as managed beans by the Java EE specification such as servlets, JAX-RS resource classes, and JAX-WS
   * service endpoints, declaratively. This provides the semantics of EJB transaction attributes in CDI without
   * dependencies such as RMI. This support is implemented via an implementation of a CDI interceptor that conducts the
   * necessary suspending, resuming, etc.
   *  
   * By default checked exceptions do not result in the transactional interceptor marking the transaction for rollback
   * and instances of RuntimeException and its subclasses do. This default behavior can be overridden by specifying
   * which exceptions result in the interceptor marking the transaction for rollback. The rollbackOn element can be set
   * to indicate which exceptions should cause the interceptor to mark the transaction for rollback. Conversely, the
   * dontRollbackOn element can be set to indicate which exceptions should do not cause the interceptor to mark the
   * transaction for rollback. When a class is specified for either of these elements, the designated behavior applies
   * to subclasses of that class as well. If both elements are specified, dontRollbackOn takes precedence.
   *  
   * EJB application exceptions (i.e., runtime exceptions annotated with @ApplicationException) are treated just as any
   * other runtime exceptions unless otherwise specified.
   *  
   * When Transactional annotated managed beans are used in conjunction with EJB container managed transactions the EJB
   * container behavior is applied before the bean is called. When the bean is called the CDI behavior is applied before
   * calling the bean's methods. It is best practice to avoid such use of Transactional annotations in conjunction with
   * EJB container managed transactions in order to avoid possible confusion.
   *
   * @since JTA1.2
   *
   */

@Inherited
@InterceptorBinding
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.METHOD})
public @interface Transactional {

  /**
   * The TxType element of the Transactional annotation indicates whether a bean method
   * is to be executed within a transaction context.
   */
  TxType value() default TxType.REQUIRED;
 
  /**
   * The TxType element of the annotation indicates whether a bean method is to be
   * executed within a transaction context where the values provide the following
   * corresponding behavior.
   */
  public enum TxType {
        /**
         *  <p>If called outside a transaction context, the interceptor must begin a new
         *  JTA transaction, the managed bean method execution must then continue
         *  inside this transaction context, and the transaction must be completed by
         *  the interceptor.</p>
         *  <p>If called inside a transaction context, the managed bean
         *  method execution must then continue inside this transaction context.</p>
         */
        REQUIRED,

        /**
         *  <p>If called outside a transaction context, the interceptor must begin a new
         *  JTA transaction, the managed bean method execution must then continue
         *  inside this transaction context, and the transaction must be completed by
         *  the interceptor.</p>
         *  <p>If called inside a transaction context, the current transaction context must
         *  be suspended, a new JTA transaction will begin, the managed bean method
         *  execution must then continue inside this transaction context, the transaction
         *  must be completed, and the previously suspended transaction must be resumed.</p>
         */
        REQUIRES_NEW,

        /**
         *  <p>If called outside a transaction context, a TransactionalException with a
         *  nested TransactionRequiredException must be thrown.</p>
         *  <p>If called inside a transaction context, managed bean method execution will
         *  then continue under that context.</p>
         */
        MANDATORY,

        /**
         *  <p>If called outside a transaction context, managed bean method execution
         *  must then continue outside a transaction context.</p>
         *  <p>If called inside a transaction context, the managed bean method execution
         *  must then continue inside this transaction context.</p>
         */
        SUPPORTS,

        /**
         *  <p>If called outside a transaction context, managed bean method execution
         *  must then continue outside a transaction context.</p>
         *  <p>If called inside a transaction context, the current transaction context must
         *  be suspended, the managed bean method execution must then continue
         *  outside a transaction context, and the previously suspended transaction
         *  must be resumed by the interceptor that suspended it after the method
         *  execution has completed.</p>
         */
        NOT_SUPPORTED,

        /**
         *  <p>If called outside a transaction context, managed bean method execution
         *  must then continue outside a transaction context.</p>
         *  <p>If called inside a transaction context, a TransactionalException with
         *  a nested InvalidTransactionException must be thrown.</p>
         */
        NEVER
    }

    /**
     * The rollbackOn element can be set to indicate exceptions that must cause
     *  the interceptor to mark the transaction for rollback. Conversely, the dontRollbackOn
     *  element can be set to indicate exceptions that must not cause the interceptor to mark
     *  the transaction for rollback. When a class is specified for either of these elements,
     *  the designated behavior applies to subclasses of that class as well. If both elements
     *  are specified, dontRollbackOn takes precedence.
     * @return Class[] of Exceptions
     */
  @Nonbinding
  Class[] rollbackOn() default {};

    /**
     * The dontRollbackOn element can be set to indicate exceptions that must not cause
     *  the interceptor to mark the transaction for rollback. Conversely, the rollbackOn element
     *  can be set to indicate exceptions that must cause the interceptor to mark the transaction
     *  for rollback. When a class is specified for either of these elements,
     *  the designated behavior applies to subclasses of that class as well. If both elements
     *  are specified, dontRollbackOn takes precedence.
     * @return Class[] of Exceptions
     */
  @Nonbinding
  Class[] dontRollbackOn() default {};

}
