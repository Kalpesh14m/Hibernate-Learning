package com.codedictator.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class InsertQuery {

	public static void main(String[] args) {
		Configuration configuration = new Configuration().configure();
		SessionFactory sessionFactory = configuration.buildSessionFactory();

		Session session = sessionFactory.openSession();

		String hql = "INSERT INTO NewOrder(itemName,brand,price) "
				+ "SELECT ord.itemName, ord.brand, ord.price FROM Order ord";

		int count = session.createQuery(hql).executeUpdate();

		System.out.println(count + " records are created!");

		session.close();

	}
}
