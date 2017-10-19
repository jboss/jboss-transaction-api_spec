/**
 *
 * @author Tomaz Cerar (c) 2017 Red Hat Inc.
 */
module java.transaction {
    exports javax.transaction;
    requires java.sql;
    requires java.rmi;
    requires cdi.api;
    requires beta.jboss.interceptor.api_1_2;
}