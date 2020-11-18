package com.codedictator.test;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class SelectClause {

	public static void main(String[] args) {
		Configuration configuration = new Configuration().configure();
		SessionFactory sessionFactory = configuration.buildSessionFactory();

		Session session = sessionFactory.openSession();

		String hql = "select cust.id, cust.firstName from Customer cust";
		// String hql = "select cust.id, cust.firstName from Customer as cust";

		Query query = session.createQuery(hql);
		List customers = query.list();

		Iterator<Object[]> itr = customers.iterator();
		while (itr.hasNext()) {
			Object[] obj = itr.next();
			System.out.println("Customer ID: " + obj[0] + ", First Name: " + obj[1]);
		}

		session.close();

	}
}
