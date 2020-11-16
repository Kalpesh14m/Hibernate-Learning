# Caching in Hibernate: 

Hibernate much more than an ORM tool i.e. Hibernate provide the lots of other features. In which Cache is very important feature one of them. Hibernate is actually a very powerful, consistent, and reliable database mapping tool.
Mapping between objects in Java to relational databases has many facets that you must be aware of. Hibernate does a particularly good job of making the process simple to start, and providing the facilities to allow it to scale well and meet exceedingly complex mapping demands.

- First Level Cache 

- Second Level Cache 
 
---

## Caching in Hibernate
 
Caching is all about application performance optimization and it sits between your application and the database to avoid the number of database hits as many as possible to give a better performance for performance critical applications.
 
Caching is important to Hibernate as well which utilizes a multilevel caching schemes as explained below:

![](https://user-images.githubusercontent.com/25608527/99272703-1cc27c00-284e-11eb-9014-bf426a71262a.png)


One of the primary concerns of mappings between a database and our Java application is performance.  This is the common concern of the all guys who working with hibernate and spent the more time in ORM tools for performance-enhancing changes to particular queries and retrievals.

1. **First Level Cache:** Hibernate first level cache is associated with the Session object. Hibernate first level cache is enabled by default and there is no way to disable it. However hibernate provides methods through which we can delete selected objects from the cache or clear the cache completely.
Any object cached in a session will not be visible to other sessions and when the session is closed, all the cached objects will also be lost.

2. **Second Level Cache:** Hibernate Second Level cache is disabled by default but we can enable it through configuration. Currently EHCache and Infinispan provides implementation for Hibernate Second level cache and we can use them. We will look into this in the next tutorial for hibernate caching.

3. **Query Cache:** Hibernate can also cache result set of a query. Hibernate Query Cache doesn’t cache the state of the actual entities in the cache; it caches only identifier values and results of value type. So it should always be used in conjunction with the second-level cache.

---

### The first-level cache:

The first level cache type is the session cache. The session cache caches object within the current session but this is not enough for long level i.e. session factory scope.


**First Level Cache in Hibernate Important Points**

Important Points about First level cache in Hibernate that can be derived from above program are:

1. Hibernate First Level cache is enabled by default, there are no configurations needed for this.

2. Hibernate first level cache is session specific, that’s why when we are getting the same data in same session there is no query fired whereas in other session query is fired to load the data.

3. Hibernate first level cache can have old values, but it didn’t get reflected in the same session. But in other session, we got the updated value.

4. We can use session `evict()` method to remove a single object from the hibernate first level cache.

5. We can use session `clear()` method to clear the cache i.e delete all the objects from the cache.

6. We can use session `contains()` method to check if an object is present in the hibernate cache or not, if the object is found in cache, it returns true or else it returns false.

7. Since hibernate cache all the objects into session first level cache, while running bulk queries or batch updates it’s necessary to clear the cache at certain intervals to avoid memory issues.


### First level cache retrieval example

In this example, we are fetching student object from the database using a hibernate session. we will retrieve it multiple times and will observe the SQL logs to see the differences

```
package com.codedictator.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.codedictator.domain.Product;

public class FirstLevelCacheDemo {
	public static void main(String[] args) {

		Transaction transaction = null;
		Configuration configuration = new Configuration().configure();
		SessionFactory sessionFactory = configuration.buildSessionFactory();
		try (Session session = sessionFactory.openSession();) {

			// start the transaction
			transaction = session.beginTransaction();

			// get the student entity using id
			Product student1 = session.load(Product.class, 1L);

			System.out.println(student1.getName());
			System.out.println(student1.getModel());
			System.out.println(student1.getPrice());

			// load student entity by id
			Product student2 = session.load(Product.class, 1L);
			System.out.println(student2.getName());
			System.out.println(student2.getModel());
			System.out.println(student2.getPrice());

			// commit transaction
			transaction.commit();
		}
	}
}
```

```
Hibernate: select product0_.PRODUCT_ID as PRODUCT_1_0_0_, product0_.brand as brand2_0_0_, product0_.category as category3_0_0_, product0_.model as model4_0_0_, product0_.NAME as NAME5_0_0_, product0_.price as price6_0_0_ from PRODUCT_MASTER6 product0_ where product0_.PRODUCT_ID=?
Mobile
iPhone5
20000.0
Mobile
iPhone5
20000.0
```

***As you can see that second “session.load()” statement does not execute the select query again and loads the student entity directly.***

---

### Removing cache objects from first level cache example

Though we can not disable the first level cache in hibernate, we can certainly remove some of the objects from it when needed. This is done using two methods :

- `Session.evict()`

- `Session.clear()`

Here `Session.evict()` is used to remove a particular object from the cache associated with a session, and a `clear()` method is used to remove all cached objects associated with a session. So they are essentially like remove one and remove all.

```
package com.codedictator.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.codedictator.domain.Product;

public class RemoveFirstCacheDemo {
	public static void main(String[] args) {
		Transaction transaction = null;
		Configuration configuration = new Configuration().configure();
		SessionFactory sessionFactory = configuration.buildSessionFactory();

		try (Session session = sessionFactory.openSession();) {
			// start the transaction
			transaction = session.beginTransaction();

			// get the student entity using id
			Product product1 = session.load(Product.class, 1L);

			System.out.println(product1.getName());
			System.out.println(product1.getModel());
			System.out.println(product1.getPrice());

			// load student entity by id
			Product product2 = session.load(Product.class, 1L);
			System.out.println(product2.getName());
			System.out.println(product2.getModel());
			System.out.println(product2.getPrice());

			// remove obj
			session.evict(product2);
			System.out.println("==>" + product2.getName());

			// load student entity by id
			Product product3 = session.load(Product.class, 1L);
			System.out.println(product3.getName());
			System.out.println(product3.getModel());
			System.out.println(product3.getPrice());

			// clear session
			session.clear();
			// commit transaction
			transaction.commit();
		}
	}
}
```

```
Hibernate: select product0_.PRODUCT_ID as PRODUCT_1_0_0_, product0_.brand as brand2_0_0_, product0_.category as category3_0_0_, product0_.model as model4_0_0_, product0_.NAME as NAME5_0_0_, product0_.price as price6_0_0_ from PRODUCT_MASTER6 product0_ where product0_.PRODUCT_ID=?
Mobile
iPhone5
20000.0
Mobile
iPhone5
20000.0
==>Mobile
Hibernate: select product0_.PRODUCT_ID as PRODUCT_1_0_0_, product0_.brand as brand2_0_0_, product0_.category as category3_0_0_, product0_.model as model4_0_0_, product0_.NAME as NAME5_0_0_, product0_.price as price6_0_0_ from PRODUCT_MASTER6 product0_ where product0_.PRODUCT_ID=?
Mobile
iPhone5
20000.0
```

***Clearly, `Session.evict()` method removed the student object from the cache so that it was fetched again from the database.***

---

### The second-level cache:

The second-level cache is called ‘second-level’ because there is already a cache operating for you in Hibernate for the duration you have a session open. A Hibernate Session is a transaction-level cache of persistent data. It is possible to configure a SessionFactory-level cache on a class-by-class and collection-by-collection basis.

— Across sessions in an Application

— Across applications (different applications on same servers with same database)

— Across clusters (different applications on different servers with same database)

**NOTE:** Be careful Caches are never aware of changes made to the persistent store by another application i.e. suppose one application deploy one server with using hibernate and get the data from database and put to the cache for further using purpose but another application deployed another server which does not using any ORM tool so it does mot know about Cache and direct interacting with database and may be update data of database. Now data in Cache is invalid.

Hibernate uses **first-level cache** by default and you have nothing to do to use first-level cache. Let’s go straight to the optional **second-level cache**. Not all classes benefit from caching, so it’s important to be able to disable the second-level cache.

The **second-level** cache exists as long as the session factory is alive. The second-level cache holds on to the ‘data’ for all properties and associations (and collections if requested) for individual entities that are marked to be cached.

---

### In hibernate configuration file (hibernate.cfg.xml)  we wrote the following line.
For Disabling the second level of cache we have to made following change to hibernate configuration file.

```
<!-- Disable the second-level cache -->  
<property name="cache.provider_class">org.hibernate.cache.NoCacheProvider</property> 
```
 
### For Enabling the second level of cache we have to made following change to hibernate configuration file.

```
<!-- Enable the second-level cache -->  
<property name="cache.use_second_level_cache">true</property>
   <property name="cache.provider_class">org.hibernate.cache.EhCacheProvider</property> 
```

---

### 1. Cache Strategy using with Annotation as some changes made to the Model class also.

```
@Cacheable
@Cache(usage = CacheConcurrencyStrategy.READ_ONLY)
@Entity
@Table(name="STUDENT")
public class Student implements Serializable 
{
  ....
```

---

### 2. Cache Strategy using with Mapping file(.hbm.xml) .

```
<hibernate-mapping>
   <class name="Student" table="STUDENT">
      
         This class contains the student detail. 
      
      <cache usage="read-only">
      <id column="ID" name="id" type="java.lang.Long">
         <generator class="native">
      </generator></id>
      <property column="STUDENT_NAME" name="studentName" type="java.lang.String">
      <property column="lCOURSE" name="course" type="java.lang.String">
      <property column="ROLL_NUMBER" name="rollNumber" type="java.lang.Long">
   </property></property></property></cache></class>
</hibernate-mapping>
```

### Concurrency strategies:

A concurrency strategy is a mediator which responsible for storing items of data in the cache and retrieving them from the cache. If you are going to enable a 
second-level cache, you will have to decide, for each persistent class and collection, which cache concurrency strategy to use.

- Transactional: Use this strategy for read-mostly data where it is critical to prevent stale data in concurrent transactions,in the rare case of an update.

- Read-write: Again use this strategy for read-mostly data where it is critical to prevent stale data in concurrent transactions,in the rare case of an update.

- Nonstrict-read-write: This strategy makes no guarantee of consistency between the cache and the database. Use this strategy if data hardly ever changes and a small likelihood of stale data is not of critical concern.

- Read-only: A concurrency strategy suitable for data which never changes. Use it for reference data only.

