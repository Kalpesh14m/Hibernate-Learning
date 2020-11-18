package com.codedictator.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.codedictator.domain.Color;

public class SaveColor {

	public static void main(String[] args) {
		Configuration configuration = new Configuration().configure();
		SessionFactory sessionFactory = configuration.buildSessionFactory();

		Color color1 = new Color("Grey");
		Color color2 = new Color("Black");
		Color color3 = new Color("Golden");

		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		session.save(color1);
		session.save(color2);
		session.save(color3);
		transaction.commit();
		session.close();

		System.out.println("Record have been saved Successfully");

	}

}
