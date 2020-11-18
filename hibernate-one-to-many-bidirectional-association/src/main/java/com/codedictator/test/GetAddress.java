package com.codedictator.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.codedictator.domain.Address;

public class GetAddress {

	public static void main(String[] args) {
		Configuration configuration = new Configuration().configure();
		SessionFactory sessionFactory = configuration.buildSessionFactory();

		Session session = sessionFactory.openSession();
		Address address = session.get(Address.class, 1L);
		System.out.println(address);
		System.out.println("Customer: " + address.getCustomer());
		session.close();
	}
}
