package com.chandra.hibernate.client;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import com.chandra.hibernate.pojo.Product;

public class HQLClient {

	public static void main(String[] args) {
		/*
		 * StandardServiceRegistry ssr=new
		 * StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build
		 * (); Metadata meta=new
		 * MetadataSources(ssr).getMetadataBuilder().build();
		 * 
		 * SessionFactory factory=meta.getSessionFactoryBuilder().build();
		 * Session session=factory.openSession();
		 */
		
		Configuration cfg = new Configuration();
		cfg.configure();
		SessionFactory factory = cfg.buildSessionFactory();
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		

		Query query = session.createQuery("from Product");
		List<Product> products = query.list();
		for (Product product : products) {
			System.out.println(product);
		}
		session.close();
		factory.close();
	}

}
