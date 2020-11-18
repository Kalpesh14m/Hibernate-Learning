package com.codedictator.test;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class UpdateQuery {

	public static void main(String[] args) {
		Configuration configuration = new Configuration().configure();
		SessionFactory sessionFactory = configuration.buildSessionFactory();

		Session session = sessionFactory.openSession();

		String hql = "update Order SET price=26000 WHERE price=25000";

		Query query = session.createQuery(hql);
		int count = query.executeUpdate();

		System.out.println(count + " records are updated!");

		session.close();

	}
}
