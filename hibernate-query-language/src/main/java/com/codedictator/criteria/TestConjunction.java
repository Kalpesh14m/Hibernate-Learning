package com.codedictator.criteria;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Conjunction;
import org.hibernate.criterion.Restrictions;

import com.codedictator.domain.Order;

public class TestConjunction {

	public static void main(String[] args) {
		Configuration configuration = new Configuration().configure();
		SessionFactory sessionFactory = configuration.buildSessionFactory();

		Session session = sessionFactory.openSession();

		Criteria criteria = session.createCriteria(Order.class);
		Conjunction conjunction = Restrictions.conjunction();
		conjunction.add(Restrictions.gt("price", 10000.00));
		conjunction.add(Restrictions.eq("itemName", "Mobile"));
		conjunction.add(Restrictions.eq("brand", "Apple"));

		List<Order> orders = criteria.add(conjunction).list();

		session.close();

		for (Order order : orders) {
			System.out.println(order);
		}
	}
}
