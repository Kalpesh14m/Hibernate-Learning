package com.codedictator.test;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.codedictator.domain.Color;
import com.codedictator.domain.Product;

public class SaveProduct {

	public static void main(String[] args) {
		Configuration configuration = new Configuration().configure();
		SessionFactory sessionFactory = configuration.buildSessionFactory();

		Product product = new Product("Mobile", "Iphone8", "Apple", 55000.00);
		Product product1 = new Product("Mobile", "Iphone7", "Apple", 55000.00);
		Product product2 = new Product("Mobile", "Iphone6", "Apple", 55000.00);

		Set<Color> colors = new HashSet<>();

		Session session = sessionFactory.openSession();

		colors.add(session.get(Color.class, 1L));
		colors.add(session.get(Color.class, 2L));
		colors.add(session.get(Color.class, 3L));

		product.setColors(colors);
		product1.setColors(colors);
		product2.setColors(colors);

		Transaction transaction = session.beginTransaction();
		session.saveOrUpdate(product);
		session.saveOrUpdate(product1);
		session.saveOrUpdate(product2);
		transaction.commit();
		session.close();

		System.out.println("Record have been Saved Successfully");

	}

}
