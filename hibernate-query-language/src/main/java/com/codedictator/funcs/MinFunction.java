package com.codedictator.funcs;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class MinFunction {

	public static void main(String[] args) {
		Configuration configuration = new Configuration().configure();
		SessionFactory sessionFactory = configuration.buildSessionFactory();

		Session session = sessionFactory.openSession();

		String hql = "SELECT MIN(ord.price) FROM Order ord";

		Object min = session.createQuery(hql).uniqueResult();

		System.out.println("Minimum Item Price: " + min);

		session.close();

	}
}
