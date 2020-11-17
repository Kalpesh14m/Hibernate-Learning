# Hibernate Properties

Hibernate requires to know in advance — where to find the mapping information that defines how your Java classes relate to the database tables. Hibernate also requires a set of configuration settings related to database and other related parameters. All such information is usually supplied as a standard Java properties file called hibernate.properties, or as an XML file named hibernate.cfg.xml.

I will consider XML formatted file `hibernate.cfg.xml` to specify required Hibernate properties in my examples. Most of the properties take their default values and it is not required to specify them in the property file unless it is really required. This file is kept in the root directory of your application's classpath.
Hibernate Properties

### Following is the list of important properties, you will be required to configure for a databases in a standalone situation −

| Properties | Description |
| :----- | :------ |
| hibernate.dialect | This property makes Hibernate generate the appropriate SQL for the chosen database. |
| hibernate.connection.driver_class | The JDBC driver class. |
| hibernate.connection.url | The JDBC URL to the database instance. |
| hibernate.connection.username | The database username. |
| hibernate.connection.password | The database password. |
| hibernate.connection.pool_size | Limits the number of connections waiting in the Hibernate database connection pool. |
| hibernate.connection.autocommit | Allows autocommit mode to be used for the JDBC connection. |

### If you are using a database along with an application server and JNDI, then you would have to configure the following properties −
| Properties | Description |
| :----- | :----- |
| hibernate.connection.datasource | The JNDI name defined in the application server context, which you are using for the application. |
| hibernate.jndi.class | The InitialContext class for JNDI. |
| hibernate.jndi.<JNDIpropertyname> | Passes any JNDI property you like to the JNDI InitialContext. |
| hibernate.jndi.url | Provides the URL for JNDI. |
| hibernate.connection.username | The database username. |
| hibernate.connection.password | The database password. |
  
### Hibernate with MySQL Database

MySQL is one of the most popular open-source database systems available today. Let us create hibernate.cfg.xml configuration file and place it in the root of your application's classpath. You will have to make sure that you have testdb database available in your MySQL database and you have a user test available to access the database.

The XML configuration file must conform to the [Hibernate 3 Configuration DTD, which is available at](http://www.hibernate.org/dtd/hibernate-configuration-3.0.dtd)
```
<?xml version = "1.0" encoding = "utf-8"?>
<!DOCTYPE hibernate-configuration SYSTEM 
"http://www.hibernate.org/dtd/hibernate-configuration-3.0.dtd">
<hibernate-configuration>
   <session-factory>
      <property name = "hibernate.dialect">
         org.hibernate.dialect.MySQLDialect
      </property>
      <property name = "hibernate.connection.driver_class">
         com.mysql.jdbc.Driver
      </property>
      <!-- Assume test is the database name -->
      <property name = "hibernate.connection.url">
         jdbc:mysql://localhost/test
      </property>
      <property name = "hibernate.connection.username">
         root
      </property>
      <property name = "hibernate.connection.password">
         root123
      </property>
      <!-- List of XML mapping files -->
      <mapping resource = "Employee.hbm.xml"/>
   </session-factory>
</hibernate-configuration>
```
