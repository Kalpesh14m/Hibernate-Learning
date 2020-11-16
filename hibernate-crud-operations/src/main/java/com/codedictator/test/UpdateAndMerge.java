package com.codedictator.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.codedictator.domain.Customer;

public class UpdateAndMerge {

	public static void main(String[] args) {
		Configuration configuration = new Configuration().configure();

		SessionFactory factory = configuration.buildSessionFactory();

		Session session1 = factory.openSession();
		Transaction transaction1 = session1.beginTransaction();
		Customer customer1 = session1.get(Customer.class, 2L);
		customer1.setEmail("Mahajan@gmail.com");
		transaction1.commit();
		session1.close();

		Session session2 = factory.openSession();
		Transaction transaction2 = session2.beginTransaction();
		Customer customer2 = session2.get(Customer.class, 3L);
		customer2.setLastName("Mali");
		session2.merge(customer1);
		transaction2.commit();
		session2.close();
	}
}
