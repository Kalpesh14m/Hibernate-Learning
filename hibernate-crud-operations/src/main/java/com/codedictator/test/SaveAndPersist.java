package com.codedictator.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.codedictator.domain.Customer;

public class SaveAndPersist {

	public static void main(String[] args) {
		Configuration configuration = new Configuration().configure();

		SessionFactory factory = configuration.buildSessionFactory();

		Customer customer1 = new Customer("Bunny", "Devil", "Bunny@gmail.com", 9876543210L);
		Customer customer2 = new Customer("Kalpesh", "Kalpesh", "Kalpesh@gmail.com", 8523697410L);

		// Save Customer-1 using save() method, it will return primary-key
		Session session1 = factory.openSession();
		Transaction transaction1 = session1.beginTransaction();
		Long id = (Long) session1.save(customer1);
		transaction1.commit();
		session1.close();

		// Save Customer-1 using persist() method
		Session session2 = factory.openSession();
		Transaction transaction2 = session2.beginTransaction();
		session2.persist(customer2);
		transaction2.commit();
		session2.close();

		System.out.println("Customer-1 ID:" + id);
		System.out.println("Record has been saved Successfully");

	}

}
