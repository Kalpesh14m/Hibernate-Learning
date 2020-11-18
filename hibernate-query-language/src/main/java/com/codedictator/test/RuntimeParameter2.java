package com.codedictator.test;

import java.util.List;
import java.util.Scanner;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.codedictator.domain.Order;

public class RuntimeParameter2 {

	public static void main(String[] args) {
		Configuration configuration = new Configuration().configure();
		SessionFactory sessionFactory = configuration.buildSessionFactory();

		System.out.print("Enter Order ID: ");
		long id = new Scanner(System.in).nextLong();

		Session session = sessionFactory.openSession();

		String hql = "from Order as ord WHERE ord.id=:xyz";

		Query query = session.createQuery(hql);
		query.setParameter("xyz", id);
		List<Order> orders = query.list();

		for (Order order : orders) {
			System.out.println(order);
		}

		session.close();
	}
}
