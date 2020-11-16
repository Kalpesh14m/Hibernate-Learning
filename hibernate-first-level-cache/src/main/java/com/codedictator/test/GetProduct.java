package com.codedictator.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.codedictator.domain.Product;

public class GetProduct {

	public static void main(String[] args) {
		Configuration configuration = new Configuration().configure();
		SessionFactory sessionFactory = configuration.buildSessionFactory();

		Session session = sessionFactory.openSession();
		Product product1 = session.get(Product.class, 1L);
		Product product2 = session.get(Product.class, 1L);
		Product product3 = session.get(Product.class, 1L);
		Product product4 = session.get(Product.class, 1L);
		session.clear();
	}
}
/*
 * Caching in Hibernate: First Level and Second Level Cache in Hibernate
 * 
 * Hibernate much more than an ORM tool i.e. Hibernate provide the lots of other
 * features. In which Cache is very important feature one of them. Hibernate is
 * actually a very powerful, consistent, and reliable database mapping tool.
 * Mapping between objects in Java to relational databases has many facets that
 * you must be aware of. Hibernate does a particularly good job of making the
 * process simple to start, and providing the facilities to allow it to scale
 * well and meet exceedingly complex mapping demands.
 * 
 * Caching in Hibernate
 * 
 * Caching is all about application performance optimization and it sits between
 * your application and the database to avoid the number of database hits as
 * many as possible to give a better performance for performance critical
 * applications.
 * 
 * Caching is important to Hibernate as well which utilizes a multilevel caching
 * schemes as explained below:
 * 
 */
