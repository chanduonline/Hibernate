package com.chandra.hibernate.client;

import java.util.Iterator;
import java.util.List;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import com.chandra.hibernate.pojo.Product;

public class NativeSQLClient {

	public static void main(String[] args) {

		StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
		Metadata meta = new MetadataSources(ssr).getMetadataBuilder().build();
		SessionFactory factory = meta.getSessionFactoryBuilder().build();
		Session session = factory.openSession();//Transient State
		Transaction tx = session.beginTransaction();
		
		
		SQLQuery query = session.createSQLQuery("select * from PRODUCT").addEntity(Product.class);//Persistent
	
		List<Product> products = query.list();
		Iterator it = products.iterator();
		while(it.hasNext())
		{
			Product p = (Product) it.next();
			System.out.println(p.getPid()+"\t"+p.getPname()+"\t"+p.getQty()+"\t"+p.getPrice());
		}
		tx.commit();
		session.close();//Detached state
		
		
		factory.close();
		

	}

}
