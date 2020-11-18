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
		Product product = session.get(Product.class, 1L);
		System.out.println(product);
		System.out.println("Props :" + product.getProps());
		session.close();
	}
}
