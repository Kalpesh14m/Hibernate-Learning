package com.codedictator.criteria;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.codedictator.domain.Order;

public class TestCriteria {

	public static void main(String[] args) {
		Configuration configuration = new Configuration().configure();
		SessionFactory sessionFactory = configuration.buildSessionFactory();

		Session session = sessionFactory.openSession();

		Criteria criteria = session.createCriteria(Order.class);
		List<Order> orders = criteria.list();

		session.close();

		for (Order order : orders) {
			System.out.println(order);
		}

	}
}
