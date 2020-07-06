package com.chandra.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class FetchTest {
	public static void main(String[] args) {
		StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
		Metadata meta = new MetadataSources(ssr).getMetadataBuilder().build();

		SessionFactory factory = meta.getSessionFactoryBuilder().build();
		Session session1 = factory.openSession();//Transient
     
		Employee emp1 = (Employee) session1.load(Employee.class, 1);//Persistent
		System.out.println(session1.contains(emp1));//true
		System.out.println(emp1.getId() + " " + emp1.getName() + " " + emp1.getSalary());
		session1.close();//Detached state
		System.out.println(session1.contains(emp1));//false


		Session session2 = factory.openSession();
		Employee emp2 = (Employee) session2.load(Employee.class, 1);
		System.out.println(emp2.getId() + " " + emp2.getName() + " " + emp2.getSalary());
		session2.close();
		
		session1.close();
		session2.close();
		factory.close();

	}
}