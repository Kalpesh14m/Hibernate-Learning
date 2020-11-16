package com.codedictator.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.codedictator.domain.Product;

public class SaveProduct {

	public static void main(String[] args) {
		Configuration configuration = new Configuration().configure();
		SessionFactory sessionFactory = configuration.buildSessionFactory();

		Product product = new Product("Mobile", "iPhone5", "Apple", "Electronics", 20000.00);

		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		session.save(product);
		transaction.commit();
		session.clear();

		System.out.println("Record has been saved successfully!");
	}

}
