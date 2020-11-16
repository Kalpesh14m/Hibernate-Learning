package com.codedictator.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.codedictator.domain.Customer;

public class Delete {

	public static void main(String[] args) {
		Configuration configuration = new Configuration().configure();

		SessionFactory factory = configuration.buildSessionFactory();

		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();
		Customer customer = session.get(Customer.class, 4L);
		session.delete(customer);
		transaction.commit();
		session.close();

		System.out.println("Record has been deleted successfully");
	}
}
