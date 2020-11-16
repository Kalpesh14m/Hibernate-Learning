package com.codedictator.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.codedictator.domain.Product;

public class GetProduct {

	public static void main(String[] args) {
		Configuration configuration = new Configuration().configure();
		SessionFactory sessionFactory = configuration.buildSessionFactory();

		try (Session session = sessionFactory.openSession();) {
			Product product1 = session.get(Product.class, 1L);
			System.out.println(product1.getName());

			Product product2 = session.get(Product.class, 1L);
			System.out.println(product2.getName());

			Product product3 = session.get(Product.class, 1L);
			System.out.println(product3.getName());

			Product product4 = session.get(Product.class, 1L);
			System.out.println(product4.getName());

			session.clear();
		}
	}
}