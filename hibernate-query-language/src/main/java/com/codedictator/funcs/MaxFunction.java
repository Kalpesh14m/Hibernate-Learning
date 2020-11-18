package com.codedictator.funcs;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class MaxFunction {

	public static void main(String[] args) {
		Configuration configuration = new Configuration().configure();
		SessionFactory sessionFactory = configuration.buildSessionFactory();

		Session session = sessionFactory.openSession();

		String hql = "SELECT MAX(ord.price) FROM Order ord " + "WHERE ord.itemName='Mobile'";

		Object max = session.createQuery(hql).uniqueResult();

		System.out.println("Max Mobile Price: " + max);

		session.close();

	}
}
