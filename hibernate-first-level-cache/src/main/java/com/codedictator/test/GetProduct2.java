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
		Product product2 = session.get(Product.class, 1L);
		Product product3 = session.get(Product.class, 1L);
		Product product4 = session.get(Product.class, 1L);
		session.close();

		Session session2 = sessionFactory.openSession();
		Product product5 = session2.get(Product.class, 1L);
		Product product6 = session2.get(Product.class, 1L);
		Product product7 = session2.get(Product.class, 1L);
		Product product8 = session2.get(Product.class, 1L);
		session2.close();
	}
}
