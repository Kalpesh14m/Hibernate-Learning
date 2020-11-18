package com.codedictator.criteria;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import com.codedictator.domain.Order;

public class TestProjection {

	public static void main(String[] args) {
		Configuration configuration = new Configuration().configure();
		SessionFactory sessionFactory = configuration.buildSessionFactory();

		Session session = sessionFactory.openSession();

		List<String> orders = session.createCriteria(Order.class).add(Restrictions.gt("price", 10000.00))
				.addOrder(org.hibernate.criterion.Order.desc("price")).setProjection(Projections.property("itemName"))
				.list();

		session.close();

		for (String itemName : orders) {
			System.out.println(itemName);
		}

	}
}
