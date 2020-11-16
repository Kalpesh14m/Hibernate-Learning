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

## The second-level cache:

The second-level cache is called ‘second-level’ because there is already a cache operating for you in Hibernate for the duration you have a session open. A Hibernate Session is a transaction-level cache of persistent data. It is possible to configure a SessionFactory-level cache on a class-by-class and collection-by-collection basis.

— Across sessions in an Application

— Across applications (different applications on same servers with same database)

— Across clusters (different applications on different servers with same database)

**NOTE:** Be careful Caches are never aware of changes made to the persistent store by another application i.e. suppose one application deploy one server with using hibernate and get the data from database and put to the cache for further using purpose but another application deployed another server which does not using any ORM tool so it does mot know about Cache and direct interacting with database and may be update data of database. Now data in Cache is invalid.

Hibernate uses **first-level cache** by default and you have nothing to do to use first-level cache. Let’s go straight to the optional **second-level cache**. Not all classes benefit from caching, so it’s important to be able to disable the second-level cache.

The **second-level** cache exists as long as the session factory is alive. The second-level cache holds on to the ‘data’ for all properties and associations (and collections if requested) for individual entities that are marked to be cached.

One of the major benefit of using Hibernate in large application is it’s support for cache, hence reducing database queries and better performance.

**Hibernate Second Level cache** providers include **`EHCache`** and **`Infinispan`**, but EHCache is more popular and we will use it for our example project. However before we move to our project, we should know different strategies for caching an object.

1. **Read Only:** This caching strategy should be used for persistent objects that will always read but never updated. It’s good for reading and caching application configuration and other static data that are never updated. This is the simplest strategy with best performance because there is no overload to check if the object is updated in database or not.

2. **Read Write:** It’s good for persistent objects that can be updated by the hibernate application. However if the data is updated either through backend or other applications, then there is no way hibernate will know about it and data might be stale. So while using this strategy, make sure you are using Hibernate API for updating the data.

3. **Nonrestricted Read Write:** If the application only occasionally needs to update data and strict transaction isolation is not required, a nonstrict-read-write cache might be appropriate.

4. **Transactional:** The transactional cache strategy provides support for fully transactional cache providers such as JBoss TreeCache. Such a cache can only be used in a JTA environment and you must specify hibernate.transaction.manager_lookup_class.


### Hibernate EHCache

Since EHCache supports all the above cache strategies, it’s the best choice when you are looking for second level cache in hibernate. I would not go into much detail about EHCache, my main focus will be to get it working for hibernate application.

### Hibernate EHCache Maven Dependencies

For hibernate second level cache, we would need to add ehcache-core and hibernate-ehcache dependencies in our application. EHCache uses slf4j for logging, so I have also added slf4j-simple for logging purposes. I am using the latest versions of all these APIs, there is a slight chance that hibernate-ehcache APIs are not compatible with the ehcache-core API, in that case you need to check the pom.xml of hibernate-ehcache to find out the correct version to use. Our final pom.xml looks like below.

```
<dependencies>
		<dependency>
			<groupId>org.hibernate</groupId>
			<artifactId>hibernate-core</artifactId>
			<version>5.1.0.Final</version>
		</dependency>

		<dependency>
			<groupId>org.hibernate</groupId>
			<artifactId>hibernate-ehcache</artifactId>
			<version>5.1.0.Final</version>
		</dependency>

		<dependency>
			<groupId>org.hibernate</groupId>
			<artifactId>hibernate-c3p0</artifactId>
			<version>5.1.0.Final</version>
		</dependency>

		<dependency>
			<groupId>mysql</groupId>
			<artifactId>mysql-connector-java</artifactId>
			<version>5.1.6</version>
		</dependency>
	</dependencies>
```

### Hibernate Second Level Cache – Hibernate EHCache Configuration

Hibernate Second level cache is disabled by default, so we would need to enable it and add some configurations to get it working. Our hibernate.cfg.xml file looks like below.


```
<hibernate-configuration>
	<session-factory>
		<!-- Data Source Details -->
		<property name="hibernate.connection.driver_class">com.mysql.jdbc.Driver</property>
		<property name="hibernate.connection.url">jdbc:mysql://localhost:3306/hibernatedb</property>
		<property name="hibernate.connection.username">root</property>
		<property name="hibernate.connection.password">root</property>

		<!-- Hibernate Properties -->
		<property name="hibernate.dialect">org.hibernate.dialect.MySQLDialect</property>
		<property name="hibernate.hbm2ddl.auto">update</property>
		<property name="hibernate.show_sql">true</property>

		<!-- Enable Second Level Cache -->
		<property name="hibernate.cache.use_second_level_cache">true</property>
		<property name="hibernate.cache.use_query_cache">true</property>
		<property name="hibernate.cache.provider_class">org.hibernate.cache.EhCacheProvider</property>
		<property name="hibernate.cache.region.factory_class">org.hibernate.cache.ehcache.EhCacheRegionFactory</property>

		<!-- Connection Pooling using C3P0 -->
		<property name="hibernate.c3p0.min_size">50</property>
		<property name="hibernate.c3p0.max_size">100</property>
		<property name="hibernate.timeout">120</property>
		<property name="hibernate.c3p0.max_statements">50</property>
		<property name="hibernate.c3p0.idle_test_period">200</property>

		<!-- Resource Mapping -->
		<mapping class="com.codedictator.domain.Product" />
	</session-factory>
</hibernate-configuration>
```

**Some important points about hibernate second level cache configurations are:**

1. **`hibernate.cache.region.factory_class`** is used to define the Factory class for Second level caching, I am using `org.hibernate.cache.ehcache.EhCacheRegionFactory` for this. If you want the factory class to be singleton, you should use `org.hibernate.cache.ehcache.SingletonEhCacheRegionFactory` class.

 2. If you are using **Hibernate 3**, corresponding classes will be `net.sf.ehcache.hibernate.EhCacheRegionFactory` and `net.sf.ehcache.hibernate.SingletonEhCacheRegionFactory`.

3. `hibernate.cache.use_second_level_cache` is used to enable the second level cache.

4. `hibernate.cache.use_query_cache` is used to enable the query cache, without it HQL queries results will not be cached.

5. `net.sf.ehcache.configurationResourceName` is used to define the EHCache configuration file location, it’s an optional parameter and if it’s not present EHCache will try to locate ehcache.xml file in the application classpath.


### Hibernate EHCache Configuration File

Our EHCache configuration file myehcache.xml looks like below.

```
<ehcache xmlns:xsi="https://www.w3.org/2001/XMLSchema-instance"
	xsi:noNamespaceSchemaLocation="ehcache.xsd" updateCheck="true"
	monitoring="autodetect" dynamicConfig="true">

	<diskStore path="java.io.tmpdir/ehcache" />

	<defaultCache maxEntriesLocalHeap="10000" eternal="true"
		timeToIdleSeconds="120" timeToLiveSeconds="200"
		diskSpoolBufferSizeMB="30" maxEntriesLocalDisk="10000000"
		diskExpiryThreadIntervalSeconds="120" memoryStoreEvictionPolicy="LRU"
		statistics="true" maxElementsInMemory="200">
		<persistence strategy="localTempSwap" />
	</defaultCache>

	<!-- For specified object -->
	<cache name="com.codedictator.domain.Product" eternal="true"
		timeToLiveSeconds="200" timeToIdleSeconds="100"
		maxElementsInMemory="200" maxEntriesLocalHeap="10000">
		<persistence strategy="localTempSwap" />
	</cache>

	<cache name="org.hibernate.cache.internal.StandardQueryCache"
		maxEntriesLocalHeap="5" eternal="false" timeToLiveSeconds="120">
		<persistence strategy="localTempSwap" />
	</cache>

	<cache name="org.hibernate.cache.spi.UpdateTimestampsCache"
		maxEntriesLocalHeap="5000" eternal="true">
		<persistence strategy="localTempSwap" />
	</cache>
</ehcache>
```

Hibernate EHCache provides a lot of options, I won’t go into much detail but some of the important configurations above are:

1. **diskStore:** EHCache stores data into memory but when it starts overflowing, it start writing data into file system. We use this property to define the location where EHCache will write the overflown data.

2. **defaultCache:** It’s a mandatory configuration, it is used when an Object need to be cached and there are no caching regions defined for that.

3. **cache name=”com.codedictator.domain.Product”:** We use cache element to define the region and it’s configurations. We can define multiple regions and their properties, while defining model beans cache properties, we can also define region with caching strategies. The cache properties are easy to understand and clear with the name.

4. **Cache regions:** `org.hibernate.cache.internal.StandardQueryCache` and `org.hibernate.cache.spi.UpdateTimestampsCache` are defined because EHCache was giving warning to that.

---

### Hibernate Second Level Cache – Model Bean Caching Strategy

We use `org.hibernate.annotations.Cache` annotation to provide the caching configuration. `org.hibernate.annotations.CacheConcurrencyStrategy` is used to define the caching strategy and we can also define the cache region to use for the model beans.

```
package com.codedictator.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Entity
@Table(name = "PRODUCT_MASTER6")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE/* ,region = "",include = "" */) // Required -> NONE, READ_ONLY, READ_WRITE, NONSTRICT_READ_WRITE, TRANSACTIONAL
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "PRODUCT_ID")
	private Long id;

	@Column(name = "NAME")
	private String name;
	private String model;
	private String brand;
	private String category;
	private Double price;

	//Constructor()
	//Getter()
	//Setter()
	//toString()
}

```

Step by step explanation of the program:

1. Before we load any data in our application, all the stats are 0 as expected.

2. When we are loading the Employee with id=1 for the first time, it’s first searched into first level cache and then second level cache. If not found in cache, database query is executed and hence fetch count becomes 1. Once the object is loaded, it’s saved into first level cache and second level cache both. So secondary level hit count remains 0 and miss count becomes 1. Notice that put count is 2, that is because Employee object consists of Address too, so both the objects are saved into second level cache and count is increased to 2.

3. Next, we are again loading the employee with id=1, this time it’s present in the first level cache. So you don’t see any database query and all other secondary level cache stats also remains same.

4. Next we are using evict() method to remove the employee object from the first level cache, now when we are trying to load it, hibernate finds it in the second level cache. That’s why no database query is fired and fetch count remains 1. Notice that hit count goes from 0 to 2 because both Employee and Address objects are read from the second level cache. Second level miss and put count remains at the earlier value.

5. Next we are loading an employee with id=3, database query is executed and fetch count increases to 2, miss count increases from 1 to 2 and put count increases from 2 to 4.

6. Next we are trying to load employee with id=1 in another session, Since hibernate second level cache is shared across sessions, it’s found in the second level cache and no database query is executed. Fetch count, miss count and put count remains same whereas hit count increases from 2 to 4.

So it’s clear that our Hibernate second level cache; Hibernate EHCache; is working fine. Hibernate statistics are helpful in finding the bottleneck in the system and optimize it to reduce the fetch count and load more data from the cache.
