package com.chandra.hibernate.client;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import com.chandra.hibernate.Employee;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
		Metadata meta = new MetadataSources(ssr).getMetadataBuilder().build();

		SessionFactory factory = meta.getSessionFactoryBuilder().build();
		Session session1 = factory.openSession();
		Transaction tx  = session1.beginTransaction();
		
    	Employee e1 = new Employee();
		e1.setId(1);
		e1.setName("abc");
		e1.setSalary(4000);

		Employee e2 = new Employee();
		e2.setId(2);
		e2.setName("pqr");
		e2.setSalary(6000);

		session1.save(e1);
		session1.save(e2);
		tx.commit();
		session1.close();
		factory.close();
    }
}
