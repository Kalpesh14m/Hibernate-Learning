package com.codedictator.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.codedictator.domain.Customer;

public class GetAndLoad {

	public static void main(String[] args) {
		Configuration configuration = new Configuration().configure();

		SessionFactory factory = configuration.buildSessionFactory();

		/*
		 * Get Object using get() method, it performs Early Loading, if Object does not
		 * exist return null
		 */
		Session session1 = factory.openSession();
		Customer customer1 = session1.get(Customer.class, 1L);
		System.out.println(customer1);
		session1.close();

		/*
		 * Get Object using load() method, it performs Lazy Loading, if Object does not
		 * exist throw ObjetNotFoundException, performs Lazy loading within session
		 * only, otherwise throws LazyInitializationException
		 */
		Session session2 = factory.openSession();
		Customer customer2 = session2.load(Customer.class, 2L);
		System.out.println(customer2);
		session2.close();
	}
}
