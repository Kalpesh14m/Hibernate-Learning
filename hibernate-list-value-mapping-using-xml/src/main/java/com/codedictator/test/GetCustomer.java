package com.codedictator.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.codedictator.domain.Customer;

public class GetCustomer {

	public static void main(String[] args) {
		Configuration configuration = new Configuration().configure();

		SessionFactory sessionFactory = configuration.buildSessionFactory();

		Session session = sessionFactory.openSession();
		Customer customer = session.get(Customer.class, 1L);
		System.out.println(customer);
		System.out.println("Mobiles :" + customer.getMobiles());
		session.close();

	}

}
