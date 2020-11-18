package com.codedictator.test;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.codedictator.domain.Customer;

public class FromClause {

	public static void main(String[] args) {
		Configuration configuration = new Configuration().configure();
		SessionFactory sessionFactory = configuration.buildSessionFactory();

		Session session = sessionFactory.openSession();
		String hql = "from Customer";
		// String hql = "from Customer cust";
		// String hql = "from Customer as cust";

		Query query = session.createQuery(hql);
		List<Customer> customers = query.list();

		for (Customer customer : customers) {
			System.out.println(customer);
			System.out.println(customer.getOrders());
		}

		session.close();

	}
}
