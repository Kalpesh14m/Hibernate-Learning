package com.codedictator.criteria;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.codedictator.domain.Order;

public class TestOrder1 {

	public static void main(String[] args) {
		Configuration configuration = new Configuration().configure();
		SessionFactory sessionFactory = configuration.buildSessionFactory();

		Session session = sessionFactory.openSession();

		List<Order> orders = session.createCriteria(Order.class).addOrder(org.hibernate.criterion.Order.asc("price"))
				.list();

		session.close();

		for (Order order : orders) {
			System.out.println(order);
		}

	}
}
