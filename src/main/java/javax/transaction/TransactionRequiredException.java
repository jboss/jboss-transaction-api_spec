/*
* JBoss, Home of Professional Open Source
* Copyright 2005, JBoss Inc., and individual contributors as indicated
* by the @authors tag. See the copyright.txt in the distribution for a
* full listing of individual contributors.
*
* This is free software; you can redistribute it and/or modify it
* under the terms of the GNU Lesser General Public License as
* published by the Free Software Foundation; either version 2.1 of
* the License, or (at your option) any later version.
*
* This software is distributed in the hope that it will be useful,
* but WITHOUT ANY WARRANTY; without even the implied warranty of
* MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
* Lesser General Public License for more details.
*
* You should have received a copy of the GNU Lesser General Public
* License along with this software; if not, write to the Free
* Software Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA
* 02110-1301 USA, or see the FSF site: http://www.fsf.org.
*/
package javax.transaction;

import java.rmi.RemoteException;

/**
 *  This exception indicates that a remote invocation request carried a null
 *  transaction context, but that an active transaction context was needed.
 *
 *  @version $Revision$
 */
public class TransactionRequiredException extends RemoteException
{

    /**
     *  Creates a new <code>TransactionRequiredException</code> without a
     *  detail message.
     */
    public TransactionRequiredException()
    {
    }

    /**
     *  Constructs an <code>TransactionRequiredException</code> with the
     *  specified detail message.
     *
     *  @param msg the detail message.
     */
    public TransactionRequiredException(String msg)
    {
        super(msg);
    }
}
