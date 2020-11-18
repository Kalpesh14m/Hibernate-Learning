package com.codedictator.criteria;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Disjunction;

import org.hibernate.criterion.Restrictions;

import com.codedictator.domain.Order;

public class TestDisjunction {

	public static void main(String[] args) {
		Configuration configuration = new Configuration().configure();
		SessionFactory sessionFactory = configuration.buildSessionFactory();

		Session session = sessionFactory.openSession();

		Criteria criteria = session.createCriteria(Order.class);
		Disjunction disjunction = Restrictions.disjunction();
		disjunction.add(Restrictions.gt("price", 10000.00));
		disjunction.add(Restrictions.eq("itemName", "Mobile"));
		disjunction.add(Restrictions.eq("brand", "Apple"));

		List<Order> orders = criteria.add(disjunction).list();

		session.close();

		for (Order order : orders) {
			System.out.println(order);
		}
	}
}
