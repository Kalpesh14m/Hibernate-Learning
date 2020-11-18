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

		Order order1 = new Order("Laptop", "Lenovo", 35000.00);
		Order order2 = new Order("Mobile", "Apple", 15000.00);
		Order order3 = new Order("Printer", "HP", 14000.00);

		List<Order> orders = new ArrayList<>();
		orders.add(order1);
		orders.add(order2);
		orders.add(order3);

		Customer customer = new Customer("Kalpesh", "Mahajan", "Kalpesh@gmail.com", 9916712669L);
		customer.setOrders(orders);

		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		session.save(customer);
		transaction.commit();
		session.close();

		System.out.println("Record has been saved successfully!");
	}
}
