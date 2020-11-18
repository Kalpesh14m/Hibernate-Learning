package com.codedictator.funcs;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class AvgFunction {

	public static void main(String[] args) {
		Configuration configuration = new Configuration().configure();
		SessionFactory sessionFactory = configuration.buildSessionFactory();

		Session session = sessionFactory.openSession();

		String hql = "SELECT AVG(ord.price) FROM Order ord";

		Object avg = session.createQuery(hql).list().get(0);

		System.out.println("Average of price: " + avg);

		session.close();

	}
}
