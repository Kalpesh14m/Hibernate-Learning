package com.codedictator.test;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.codedictator.domain.Customer;
import com.codedictator.domain.Order;

public class OrderByClause {

	public static void main(String[] args) {
		Configuration configuration = new Configuration().configure();
		SessionFactory sessionFactory = configuration.buildSessionFactory();

		Session session = sessionFactory.openSession();

		String hql = "from Order as ord ORDER BY ord.price ASC";

		Query query = session.createQuery(hql);
		List<Order> orders = query.list();

		for (Order order : orders) {
			System.out.println(order);
		}

		session.close();

	}
}
