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
package javax.transaction.xa;

/**
 *  The Xid interface is a Java mapping of the X/Open transaction identifier
 *  XID structure.
 *  <p>
 *  A transaction id is an aggregate of three parts:
 *  <ul>
 *  <li> The format identifier indicates the transaction family and tells
 *       how the other two parts should be interpreted.
 *  </li>
 *  <li> The global transaction id denotes, with the format specifier, the
 *       id of the global transaction.
 *  </li>
 *  <li> The branch qualifier denotes a particular branch of the global
 *       transaction.
 *  </li>
 *  </ul>
 *  <p>
 *  The Xid interface is used by the application server, the transaction manager
 *  and the resource managers, and is not used in application programs.
 *
 *  @version $Revision$
 */
public interface Xid
{
    /**
     *  The maximum possible size of a global transaction id.
     *  This is the largest possible array returned by the 
     *  {@link #getGlobalTransactionId() getGlobalTransactionId} method.
     */
    public static final int MAXGTRIDSIZE = 64;

    /**
     *  The maximum possible size of a transaction branch qualifier.
     *  This is the largest possible array returned by the 
     *  {@link #getBranchQualifier() getBranchQualifier} method.
     */
    public static final int MAXBQUALSIZE = 64;

    /**
     *  Get the format identifier.
     *
     *  @return An integer denoting the family of this transaction, and
     *          telling how the two other parts can be interpreted.
     */
    public int getFormatId();

    /**
     *  Get the global transaction id of this transaction.
     *
     *  Please note that JTA does not define if this method returns
     *  a copy or a reference to an internal byte array. For maximum
     *  portability, do not modify the returned array.
     *
     *  @return A byte array that together with the format ID
     *          defines the globally unique ID of this transaction.
     */
    public byte[] getGlobalTransactionId();

    /**
     *  Get the transaction branch qualifier of this transaction.
     *
     *  Please note that JTA does not define if this method returns
     *  a copy or a reference to an internal byte array. For maximum
     *  portability, do not modify the returned array.
     *
     *  @return A byte array that identifies the branch of this
     *          transaction.
     */
    public byte[] getBranchQualifier();
}
