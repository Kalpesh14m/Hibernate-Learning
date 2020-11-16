package com.codedictator.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.codedictator.domain.Customer;

public class UpdateandSaveOrUpdate {

	public static void main(String[] args) {
		Configuration configuration = new Configuration().configure();

		SessionFactory factory = configuration.buildSessionFactory();

		// It will update ID-1 Record- execute UPDATE Query
		Session session1 = factory.openSession();
		Transaction transaction1 = session1.beginTransaction();
		Customer customer1 = session1.get(Customer.class, 1L);
		customer1.setEmail("support@codedictator.com");
		session1.update(customer1);
		transaction1.commit();
		session1.close();

		// It will create new Record- Execute INSERT Query
		Session session2 = factory.openSession();
		Transaction transaction2 = session2.beginTransaction();
		Customer customer2 = new Customer("Xyz", "PQR", "xyz@codedictator.com", 8892550034L);
		session2.saveOrUpdate(customer2);
		transaction2.commit();
		session2.close();

		// It will update id-2 Record- Execute UPDATE Query
		Session session3 = factory.openSession();
		Transaction transaction3 = session3.beginTransaction();
		Customer customer3 = new Customer("Jayesh", "Wagh", "Jayesh@gmail.com", 7728902579L);
		customer3.setId(2L);
		session3.saveOrUpdate(customer3);
		transaction3.commit();
		session3.close();
	}
}
