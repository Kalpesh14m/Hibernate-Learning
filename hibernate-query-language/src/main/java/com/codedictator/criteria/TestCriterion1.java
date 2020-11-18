package com.codedictator.criteria;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;

import com.codedictator.domain.Order;

public class TestCriterion1 {

	public static void main(String[] args) {
		Configuration configuration = new Configuration().configure();
		SessionFactory sessionFactory = configuration.buildSessionFactory();

		Session session = sessionFactory.openSession();

		List<Order> orders = session.createCriteria(Order.class).add(Restrictions.gt("price", 10000.00)).list();

		session.close();

		Iterator itr = orders.iterator();

		while (itr.hasNext()) {
			Order order = (Order) itr.next();
			System.out.println("Order ID:" + order.getId());
			System.out.println("Item Name:" + order.getItemName());
			System.out.println("Price:" + order.getPrice());
			// It will return the Customer details.
			// System.out.println("Customer ID:"+order.getCustomer());
		}

	}
}
