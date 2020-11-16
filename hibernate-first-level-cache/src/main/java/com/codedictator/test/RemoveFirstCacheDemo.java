package com.codedictator.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.codedictator.domain.Product;

public class RemoveFirstCacheDemo {
	public static void main(String[] args) {
		Transaction transaction = null;
		Configuration configuration = new Configuration().configure();
		SessionFactory sessionFactory = configuration.buildSessionFactory();

		try (Session session = sessionFactory.openSession();) {
			// start the transaction
			transaction = session.beginTransaction();

			// get the student entity using id
			Product product1 = session.load(Product.class, 1L);

			System.out.println(product1.getName());
			System.out.println(product1.getModel());
			System.out.println(product1.getPrice());

			// load student entity by id
			Product product2 = session.load(Product.class, 1L);
			System.out.println(product2.getName());
			System.out.println(product2.getModel());
			System.out.println(product2.getPrice());

			// remove obj
			session.evict(product2);
			System.out.println("==>" + product2.getName());

			// load student entity by id
			Product product3 = session.load(Product.class, 1L);
			System.out.println(product3.getName());
			System.out.println(product3.getModel());
			System.out.println(product3.getPrice());

			// clear session
			session.clear();
			// commit transaction
			transaction.commit();
		}
	}
}
