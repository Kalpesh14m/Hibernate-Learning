package com.codedictator.criteria;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;

import com.codedictator.domain.Order;

public class TestCriterion3 {

	public static void main(String[] args) {
		Configuration configuration = new Configuration().configure();
		SessionFactory sessionFactory = configuration.buildSessionFactory();

		Session session = sessionFactory.openSession();

		List<Order> orders = session.createCriteria(Order.class).add(Restrictions.lt("price", 20000.00)).list();

		session.close();

		for (Order order : orders) {
			System.out.println(order);
		}

	}
}
