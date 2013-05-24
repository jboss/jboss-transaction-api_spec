package javax.transaction;


import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.interceptor.InterceptorBinding;
import javax.enterprise.util.Nonbinding;


  /**
   *<p>The javax.transaction.Transactional annotation provides the application
   * the ability to declaratively control transaction boundaries on CDI managed beans, as
   * well as classes defined as managed beans by the Java EE specification, at both the class
   * and method level where method level annotations override those at the class level.</p>
   * <p>See the EJB specification for restrictions on the use of @Transactional with EJBs.</p>
   * <p>This support is provided via an implementation of CDI interceptors that conduct the
   * necessary suspending, resuming, etc. The Transactional interceptor interposes on business method
   * invocations only and not on lifecycle events. Lifecycle methods are invoked in an unspecified
   * transaction context.</p>
   * <p>If an attempt is made to call any method of the UserTransaction interface from within the
   * scope of a bean or method annotated with @Transactional and a Transactional.TxType other than
   * NOT_SUPPORTED or NEVER, an IllegalStateException must be thrown. The use of the UserTransaction
   * is allowed within life cycle events. The use of the TransactionSynchronizationRegistry is allowed
   * regardless of any @Transactional annotation.</p>
   * <p>The Transactional interceptors must have a priority of
   * Interceptor.Priority.PLATFORM_BEFORE+200.
   * Refer to the Interceptors specification for more details.</p>
   * <p>The TxType element of the annotation indicates whether a bean method is to be executed within
   * a transaction context.  TxType.REQUIRED is the default.</p>
   * <p>By default checked exceptions do not result in the transactional interceptor marking the transaction for rollback
   * and instances of RuntimeException and its subclasses do. This default behavior can be modified by specifying
   * exceptions that result in the interceptor marking the transaction for rollback and/or exceptions that do not result in rollback.</p>
   * <p>The rollbackOn element can be set to indicate which exceptions should cause the interceptor to mark the transaction for rollback.</p>
   * <p>Conversely, the dontRollbackOn element can be set to indicate which exceptions should do not cause the interceptor to mark the
   * transaction for rollback.</p>
   * <p>When a class is specified for either of these elements, the designated behavior applies
   * to subclasses of that class as well. If both elements are specified, dontRollbackOn takes precedence.</p>
   *
   * @since JTA1.2
   *
   */

@Inherited
@InterceptorBinding
@Retention(value = RetentionPolicy.RUNTIME)
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
