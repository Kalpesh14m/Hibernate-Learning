# Hibernet

## What is ORM?

Object-relational mapping or ORM is the programming technique to map application domain model objects to the relational database tables. Hibernate is a Java-based ORM tool that provides a framework for mapping application domain objects to the relational database tables and vice versa.

---

## What is JDBC?

JDBC stands for Java Database Connectivity. It provides a set of Java API for accessing the relational databases from Java program. These Java APIs enables Java programs to execute SQL statements and interact with any SQL compliant database.

JDBC provides a flexible architecture to write a database independent application that can run on different platforms and interact with different DBMS without any modification.

| Pros of JDBC | Cons of JDBC |
| :----------- | :----------- |
| Clean and simple SQL processing | Complex if it is used in large projects |
| Good performance with large data | Large programming overhead |
| Very good for small applications | No encapsulation |
| Simple syntax so easy to learn | Hard to implement MVC concept |
|  | Query is DBMS specific |
	
---

## Why Object Relational Mapping (ORM)?

When we work with an object-oriented system, there is a mismatch between the object model and the relational database. RDBMSs represent data in a tabular format whereas object-oriented languages, such as Java or C# represent it as an interconnected graph of objects.

```
public class Employee {
   private int id;
   private String first_name; 
   private String last_name;   
   private int salary;  

   public Employee() {}
   public Employee(String fname, String lname, int salary) {
      this.first_name = fname;
      this.last_name = lname;
      this.salary = salary;
   }
   
   public int getId() {
      return id;
   }
   
   public String getFirstName() {
      return first_name;
   }
   
   public String getLastName() {
      return last_name;
   }
   
   public int getSalary() {
      return salary;
   }
}
```

Consider the above objects are to be stored and retrieved into the following RDBMS table −
```
create table EMPLOYEE (
   id INT NOT NULL auto_increment,
   first_name VARCHAR(20) default NULL,
   last_name  VARCHAR(20) default NULL,
   salary     INT  default NULL,
   PRIMARY KEY (id)
);
```

First problem, what if we need to modify the design of our database after having developed a few pages or our application? Second, loading and storing objects in a relational database exposes us to the following five mismatch problems −

1. **Granularity:** Sometimes you will have an object model, which has more classes than the number of corresponding tables in the database.

2. **Inheritance:** RDBMSs do not define anything similar to Inheritance, which is a natural paradigm in object-oriented programming languages.

3. **Identity:** An RDBMS defines exactly one notion of 'sameness': the primary key. Java, however, defines both object identity (a==b) and object equality (a.equals(b)).

4. **Associations:** Object-oriented languages represent associations using object references whereas an RDBMS represents an association as a foreign key column.

5 **Navigation:** The ways you access objects in Java and in RDBMS are fundamentally different.


**The Object-Relational Mapping (ORM) is the solution to handle all the above impedance mismatches.**

An ORM system has the following advantages over plain JDBC −

1 	Let’s business code access objects rather than DB tables.

2 	Hides details of SQL queries from OO logic.

3 	Based on JDBC 'under the hood.'

4 	No need to deal with the database implementation.

5 	Entities based on business concepts rather than database structure.

6 	Transaction management and automatic key generation.

7 	Fast development of application.

---

## What is Hibernate Framework?

Hibernate is a java based ORM tool that provides a framework for mapping application domain objects to the relational database tables and vice versa.

Hibernate is probably the most popular JPA implementation and one of the most popular Java frameworks in general. Hibernate acts as an additional layer on top of JDBC and enables you to implement a database-independent persistence layer. It provides an object-relational mapping implementation that maps your database records to Java objects and generates the required SQL statements to replicate all operations to the database.

Example: Below diagram shows an Object Relational Mapping between Student Java class and student table in the database.

![](https://user-images.githubusercontent.com/25608527/99453422-eae30f80-294a-11eb-9170-234337ef70c1.png)

---

### Hibernate Advantages

- Hibernate takes care of mapping Java classes to database tables using XML files and without writing any line of code.

- Provides simple APIs for storing and retrieving Java objects directly to and from the database.

- If there is change in the database or in any table, then you need to change the XML file properties only.

- Abstracts away the unfamiliar SQL types and provides a way to work around familiar Java Objects.

- Hibernate does not require an application server to operate.

- Manipulates Complex associations of objects of your database.

- Minimizes database access with smart fetching strategies.

- Provides simple querying of data.

### Supported Databases

Hibernate supports almost all the major RDBMS. Following is a list of few of the database engines supported by Hibernate −

- HSQL Database Engine

- DB2/NT

- MySQL

- PostgreSQL

- FrontBase

- Oracle

- Microsoft SQL Server Database

- Sybase SQL Server

- Informix Dynamic Server

Supported Technologies

### Hibernate supports a variety of other technologies, including −

- XDoclet Spring

- J2EE

- Eclipse plug-ins

- Maven




### How does Hibernate relate to JDBC?

Hibernate uses JDBC for all database communications. Hibernate uses JDBC to interact with the database.

Hibernate acts as an additional layer on top of JDBC and enables you to implement a database-independent persistence layer:

![](https://user-images.githubusercontent.com/25608527/99453414-e9b1e280-294a-11eb-9afe-33bd17724a97.png)

### System Requirements

- Hibernate 5.2 and later versions require at least Java 1.8 and JDBC 4.2.

- Hibernate 5.1 and older versions require at least Java 1.6 and JDBC 4.0.

---

## Architecture

Following is a very high level view of the Hibernate Application Architecture.

![](https://user-images.githubusercontent.com/25608527/99453780-7b215480-294b-11eb-91d9-5156be6852c7.png)

Following is a detailed view of the Hibernate Application Architecture with its important core classes.

![](https://user-images.githubusercontent.com/25608527/99453786-7ceb1800-294b-11eb-842c-0c363cee0302.png)

Hibernate uses various existing Java APIs, like JDBC, Java Transaction API(JTA), and Java Naming and Directory Interface (JNDI). JDBC provides a rudimentary level of abstraction of functionality common to relational databases, allowing almost any database with a JDBC driver to be supported by Hibernate. JNDI and JTA allow Hibernate to be integrated with J2EE application servers.

**Configuration Object:** The Configuration object is the first Hibernate object you create in any Hibernate application. It is usually created only once during application initialization. It represents a configuration or properties file required by the Hibernate.

The Configuration object provides two keys components −

1. **Database Connection −** This is handled through one or more configuration files supported by Hibernate. These files are hibernate.properties and hibernate.cfg.xml.

2. **Class Mapping Setup −** This component creates the connection between the Java classes and database tables.


**SessionFactory (org.hibernate.SessionFactory):** A thread-safe (and immutable) representation of the mapping of the application domain model to a database. Acts as a factory for org.hibernate.Session instances. The EntityManagerFactory is the JPA equivalent of a SessionFactory and basically, those two converge into the same SessionFactory implementation.
A SessionFactory is very expensive to create, so, for any given database, the application should have only one associated SessionFactory. The SessionFactory maintains services that Hibernate uses across all Session(s) such as second-level caches, connection pools, transaction system integrations, etc.

**Session (org.hibernate.Session):** A single-threaded, short-lived object conceptually modeling a "Unit of Work". In JPA nomenclature, the Session is represented by an EntityManager.
Behind the scenes, the Hibernate Session wraps a JDBC java.sql.Connection and acts as a factory for org.hibernate.Transaction instances. It maintains a generally "repeatable read" persistence context (first level cache) of the application domain model.

**Transaction (org.hibernate.Transaction):** A single-threaded, short-lived object used by the application to demarcate individual physical transaction boundaries. EntityTransaction is the JPA equivalent and both act as an abstraction API to isolate the application from the underlying transaction system in use (JDBC or JTA).

**Query objects** use SQL or Hibernate Query Language (HQL) string to retrieve data from the database and create objects. A Query instance is used to bind query parameters, limit the number of results returned by the query, and finally to execute the query.
Criteria Object

**Criteria objects** are used to create and execute object oriented criteria queries to retrieve objects.
