package com.codedictator.test;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.codedictator.domain.Customer;

public class WhereClause {

	public static void main(String[] args) {
		Configuration configuration = new Configuration().configure();
		SessionFactory sessionFactory = configuration.buildSessionFactory();

		Session session = sessionFactory.openSession();

		String hql = "select ord.itemName, ord.price" + " from Order ord WHERE ord.id=2";

		Query query = session.createQuery(hql);
		List customers = query.list();

		Iterator<Object[]> itr = customers.iterator();
		while (itr.hasNext()) {
			Object[] obj = itr.next();
			System.out.println("Item Name: " + obj[0] + ", Price: " + obj[1]);
		}

		session.close();

	}
}
