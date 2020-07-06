package com.chandra.hibernate.client;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import com.chandra.hibernate.pojo.Product;

public class CrietriaClient {

	public static void main(String[] args) {
		Configuration cfg = new Configuration();
		cfg.configure();
		SessionFactory factory = cfg.buildSessionFactory();
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		
		Criteria c = session.createCriteria(Product.class);
		/*c.setFirstResult(1);
		c.setMaxResults(2);*/
		
		/*c.add(Restrictions.gt("price", 1200.0));*/
		c.addOrder(Order.asc("price"));
		List<Product> products = c.list();
		for(Product p:products)
		{
			System.out.println(p);
		}
		session.close();
		factory.close();
	}

}
