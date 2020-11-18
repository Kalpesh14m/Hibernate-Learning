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

		Product product = new Product("IPhone", "iPhone-7", "Apple", 45000.00);

		Set<Color> colors = new HashSet<>();

		Session session = sessionFactory.openSession();

		colors.add(session.get(Color.class, 1L));
		colors.add(session.get(Color.class, 2L));
		colors.add(session.get(Color.class, 3L));

		product.setColors(colors);

		Transaction transaction = session.beginTransaction();
		session.saveOrUpdate(product);
		transaction.commit();
		session.close();

		System.out.println("Record has been saved successfully!");
	}

}
