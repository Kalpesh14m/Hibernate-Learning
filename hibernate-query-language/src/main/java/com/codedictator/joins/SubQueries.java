package com.codedictator.joins;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.codedictator.domain.Order;

public class SubQueries {
	public static void main(String[] args) {
		Configuration configuration = new Configuration().configure();
		SessionFactory sessionFactory = configuration.buildSessionFactory();

		Session session = sessionFactory.openSession();

		String hql = "from Order as ord where ord.price > (select avg(ord1.price) from Order as ord1)";
		Query query = session.createQuery(hql);

		List list = query.list();
		Iterator itr = list.iterator();

		while (itr.hasNext()) {
			Order order = (Order) itr.next();
			System.out.println("Order ID:" + order.getId());
			System.out.println("Item Name:" + order.getItemName());
			System.out.println("Price:" + order.getPrice());
		}

	}

}
