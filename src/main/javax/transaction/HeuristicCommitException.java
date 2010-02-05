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

/**
 *  This exception is meant to be thrown by the rollback operation on
 *  a resource to report that a heuristic decision was made and that all
 *  relevant updates have been committed. 
 *  <p>
 *  But though defined in JTA this exception is used nowhere in JTA, and
 *  it seems impossible to report a heuristic commit decision with the JTA
 *  API in a portable way.
 *
 *  @version $Revision$
 */
public class HeuristicCommitException extends Exception
{

    /**
     *  Creates a new <code>HeuristicMixedException</code> without a
     *  detail message.
     */
    public HeuristicCommitException()
    {
    }

    /**
     *  Constructs an <code>HeuristicCommitException</code> with the
     *  specified detail message.
     *
     *  @param msg the detail message.
     */
    public HeuristicCommitException(String msg)
    {
        super(msg);
    }
}
