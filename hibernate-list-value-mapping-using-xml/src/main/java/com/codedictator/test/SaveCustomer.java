package com.codedictator.test;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.codedictator.domain.Customer;

public class SaveCustomer {

	public static void main(String[] args) {
		Configuration configuration = new Configuration().configure();

		SessionFactory factory = configuration.buildSessionFactory();

		Customer customer = new Customer("Kalpesh", "Mahajan", "Kalpesh121@gmail.com");

		List<Long> mobiles = new ArrayList<>();
		mobiles.add(8892550034L);
		mobiles.add(9916712669L);
		mobiles.add(9308378200L);
		mobiles.add(9739947975L);

		customer.setMobiles(mobiles);

		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();
		session.save(customer);
		transaction.commit();
		session.close();

		System.out.println("Reacord have been successfully saved");

	}

}
