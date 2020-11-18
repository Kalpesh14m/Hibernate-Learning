package com.codedictator.test;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.codedictator.domain.Customer;

public class SelectClause2 {

	public static void main(String[] args) {
		Configuration configuration = new Configuration().configure();
		SessionFactory sessionFactory = configuration.buildSessionFactory();

		Session session = sessionFactory.openSession();

		String hql = "select cust.id, cust.firstName, ord.itemName, ord.price" + " from Customer cust, Order ord";

		Query query = session.createQuery(hql);
		List customers = query.list();

		Iterator<Object[]> itr = customers.iterator();
		while (itr.hasNext()) {
			Object[] obj = itr.next();
			System.out.println("Customer ID: " + obj[0] + ", First Name: " + obj[1]);
			System.out.println("Item Name: " + obj[2] + ", Price: " + obj[3]);
		}

		session.close();

	}
}
