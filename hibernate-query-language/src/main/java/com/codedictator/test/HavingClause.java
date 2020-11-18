package com.codedictator.test;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.codedictator.domain.Order;

public class HavingClause {

	public static void main(String[] args) {
		Configuration configuration = new Configuration().configure();
		SessionFactory sessionFactory = configuration.buildSessionFactory();

		Session session = sessionFactory.openSession();

		String hql = "select ord.itemName from Order ord GROUP BY ord.brand HAVING ord.brand in ('Lenovo')";

		Query query = session.createQuery(hql);
		List list = query.list();
		Iterator itr = list.iterator();

		while (itr.hasNext()) {
			System.out.println("Item Name:" + itr.next());
		}

		session.close();

	}
}
