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
		session.close();

		if (product == null) {
			System.out.println("Product not Found!!!");
		} else {
			System.out.println("Product Detials: " + product);
			System.out.println("Product Colors: " + product.getColors());
		}
	}

}
