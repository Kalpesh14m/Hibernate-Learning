package com.codedictator.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.codedictator.domain.Product;

public class GetProduct2 {

	public static void main(String[] args) {
		Configuration configuration = new Configuration().configure();
		SessionFactory sessionFactory = configuration.buildSessionFactory();

		Session session = sessionFactory.openSession();

		Product product1 = session.get(Product.class, 1L);
		System.out.println(product1.getName());

		Product product2 = session.get(Product.class, 1L);
		System.out.println(product2.getName());

		Product product3 = session.get(Product.class, 1L);
		System.out.println(product3.getName());

		Product product4 = session.get(Product.class, 1L);
		System.out.println(product4.getName());

		session.close();

		Session session2 = sessionFactory.openSession();

		Product product5 = session2.get(Product.class, 1L);
		System.out.println(product5.getName());

		Product product6 = session2.get(Product.class, 1L);
		System.out.println(product6.getName());

		Product product7 = session2.get(Product.class, 1L);
		System.out.println(product7.getName());

		Product product8 = session2.get(Product.class, 1L);
		System.out.println(product8.getName());

		session2.close();
	}
}
