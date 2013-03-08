package javax.transaction;


import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.interceptor.InterceptorBinding;


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
   * @since:  JTA 1.2
   *
   **/

@Inherited
@InterceptorBinding
@Retention(java.lang.annotation.RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.METHOD})
public @interface Transactional {
      TxType value() default TxType.REQUIRED;
 
  public enum TxType {
      REQUIRED,
      REQUIRES_NEW,
      MANDATORY,
      SUPPORTS,
      NOT_SUPPORTED,
      NEVER
  }

  Class[] rollbackOn() default {};

  Class[] dontRollbackOn() default {};

  }
