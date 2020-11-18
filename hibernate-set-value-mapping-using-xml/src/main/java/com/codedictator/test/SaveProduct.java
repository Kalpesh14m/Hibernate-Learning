package com.codedictator.test;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.codedictator.domain.Product;

public class SaveProduct {

	public static void main(String[] args) {
		Configuration configuration = new Configuration().configure();

		SessionFactory sessionFactory = configuration.buildSessionFactory();

		Product product = new Product("mobile", "iphone", "Apple", "electronics", 60000D);

		Set<String> colors = new HashSet<>();
		colors.add("black");
		colors.add("grey");
		colors.add("white");
		colors.add("grey");

		product.setColors(colors);

		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		session.save(product);
		transaction.commit();
		session.close();

		System.out.println("Reacord have been successfully saved");

	}

}
