package com.codedictator.test;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteQuery {

	public static void main(String[] args) {
		Configuration configuration = new Configuration().configure();
		SessionFactory sessionFactory = configuration.buildSessionFactory();

		Session session = sessionFactory.openSession();

		String hql = "delete from Order ord WHERE ord.id=?";

		System.out.print("Enter Order ID: ");
		Long id = new Scanner(System.in).nextLong();

		int count = session.createQuery(hql).setParameter(0, id).executeUpdate();

		System.out.println(count + " records are deleted!");

		session.close();

	}
}
