package com.codedictator.criteria;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;

import com.codedictator.domain.Order;

public class TestProjection3 {

	public static void main(String[] args) {
		Configuration configuration = new Configuration().configure();
		SessionFactory sessionFactory = configuration.buildSessionFactory();

		Session session = sessionFactory.openSession();

		ProjectionList projectionList = Projections.projectionList();
		projectionList.add(Projections.max("price"));
		projectionList.add(Projections.min("price"));
		projectionList.add(Projections.sum("price"));
		projectionList.add(Projections.avg("price"));
		projectionList.add(Projections.count("price"));

		List<Object[]> orders = session.createCriteria(Order.class).setProjection(projectionList).list();
		session.close();

		for (Object[] object : orders) {
			System.out.println("Max Price: " + object[0]);
			System.out.println("Min Price: " + object[1]);
			System.out.println("Sum of Price: " + object[2]);
			System.out.println("Avg of Price: " + object[3]);
			System.out.println("No of Records: " + object[4]);
		}
	}
}
