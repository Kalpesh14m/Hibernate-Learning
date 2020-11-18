package com.codedictator.criteria;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import com.codedictator.domain.Order;

public class TestProjection2 {

	public static void main(String[] args) {
		Configuration configuration = new Configuration().configure();
		SessionFactory sessionFactory = configuration.buildSessionFactory();

		Session session = sessionFactory.openSession();

		ProjectionList projectionList = Projections.projectionList();
		projectionList.add(Projections.property("itemName"));
		projectionList.add(Projections.property("brand"));

		List<Object[]> orders = session.createCriteria(Order.class).add(Restrictions.gt("price", 10000.00))
				.addOrder(org.hibernate.criterion.Order.desc("price")).setProjection(projectionList).list();

		session.close();

		for (Object[] object : orders) {
			System.out.println("Item Name=" + object[0] + ", Brand=" + object[1]);
		}

	}
}
