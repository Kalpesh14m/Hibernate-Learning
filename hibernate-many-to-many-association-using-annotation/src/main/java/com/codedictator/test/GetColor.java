package com.codedictator.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.codedictator.domain.Color;

public class GetColor {

	public static void main(String[] args) {
		Configuration configuration = new Configuration().configure();
		SessionFactory sessionFactory = configuration.buildSessionFactory();

		Session session = sessionFactory.openSession();
		Color color = session.get(Color.class, 1L);
		session.close();

		System.out.println("Color Details: " + color);
	}

}
