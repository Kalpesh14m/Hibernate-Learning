package com.codedictator.joins;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class RightJoinQuery {

	public static void main(String[] args) {
		Configuration configuration = new Configuration().configure();
		SessionFactory sessionFactory = configuration.buildSessionFactory();

		Session session = sessionFactory.openSession();

		// Left Join
		String hql = "SELECT cust.firstName, cust.mobile, ord.itemName, ord.price "
				+ "FROM Order ord RIGHT JOIN Customer cust ON cust.id = ord.customer.id";

		List<Object[]> records = session.createQuery(hql).list();

		for (Object[] obj : records) {
			System.out.println(
					"First Name: " + obj[0] + ", Mobile:" + obj[1] + ", Item Name:" + obj[2] + ", Price:" + obj[3]);
		}

		session.close();

	}
}
