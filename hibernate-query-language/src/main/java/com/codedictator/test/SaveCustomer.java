package com.codedictator.test;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.codedictator.domain.Customer;
import com.codedictator.domain.Order;

public class SaveCustomer {

	public static void main(String[] args) {
		Configuration configuration = new Configuration().configure();
		SessionFactory sessionFactory = configuration.buildSessionFactory();

		List<Order> orders = new ArrayList<>();
		orders.add(new Order("Mobile", "Iphone6", "Apple", 25000.00, 1));
		orders.add(new Order("Mobile", "4A", "Redmi", 7000.00, 4));
		orders.add(new Order("Laptop", "G50", "Lenovo", 35000.00, 1));

		Customer customer = new Customer("Kalpesh", "Mahajan", "Kalpesh@gmail.com", "9916712669");
		customer.setOrders(orders);

		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		session.save(customer);
		transaction.commit();
		session.close();

		System.out.println("Record has been saved successfully!");

	}

}
