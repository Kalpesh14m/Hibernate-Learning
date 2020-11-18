package com.codedictator.funcs;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class SumFunction {

	public static void main(String[] args) {
		Configuration configuration = new Configuration().configure();
		SessionFactory sessionFactory = configuration.buildSessionFactory();

		Session session = sessionFactory.openSession();

		String hql = "SELECT SUM(ord.price) FROM Order ord " + "WHERE ord.itemName='Mobile'";

		Object sum = session.createQuery(hql).uniqueResult();
		// .list()
		// .get(0);

		System.out.println("Sum of price where Item Name is Mobile: " + sum);

		session.close();

	}
}
