package javax.transaction;

/**
 *  The TransactionalException thrown from Transactional annotation interceptors implementation
 *  contains the original exception as its nested exception and is a RuntimeException; therefore, by
 *  default any transaction that was started as a result of a Transactional annotation earlier in the call
 *  stream will be marked for rollback as a result of the TransactionalException being thrown by the Transactional
 *  interceptor of the second bean.
 *
 *  @since JTA1.2
 *
 */
public class TransactionalException extends RuntimeException
{
    /**
     * Create a TransactionalException with a given string and nested Throwable.
     */
    public TransactionalException(String s, Throwable throwable)
    {
        super(s, throwable);
    }

}
