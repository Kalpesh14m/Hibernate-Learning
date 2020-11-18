package com.codedictator.test;

import java.util.HashMap;
import java.util.Map;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.codedictator.domain.Product;

public class SaveProduct {

	public static void main(String[] args) {
		Configuration configuration = new Configuration().configure();

		SessionFactory sessionFactory = configuration.buildSessionFactory();

		Product product = new Product("mobile", "iphone8", "Apple", "electronics", 60000D);

		Map<String, String> props = new HashMap<>();
		props.put("RAM", "4GB");
		props.put("MEMORY", "64GB");
		props.put("COLOR", "Black");

		product.setProps(props);

		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		session.save(product);
		transaction.commit();
		session.close();

		System.out.println("Reacord have been successfully saved");

	}

}
