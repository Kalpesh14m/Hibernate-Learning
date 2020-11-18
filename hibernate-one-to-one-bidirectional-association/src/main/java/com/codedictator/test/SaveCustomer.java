package com.codedictator.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.codedictator.domain.Address;
import com.codedictator.domain.Customer;

public class SaveCustomer {

	public static void main(String[] args) {

		Configuration configuration = new Configuration().configure();
		SessionFactory sessionfactory = configuration.buildSessionFactory();

		Address address = new Address("42", "Swapnapurti", "Pune", "Near Police Station", "Maharashtra", 560078L);

		Customer customer = new Customer("Kalpesh", "Mahajan", "Kalpesh@gmail.com", 9876543210L);

		customer.setAddress(address);

		Session session = sessionfactory.openSession();
		Transaction transaction = session.beginTransaction();
		session.save(customer);
		transaction.commit();
		session.close();

		System.out.println("Record have been saved successfully");
	}
}