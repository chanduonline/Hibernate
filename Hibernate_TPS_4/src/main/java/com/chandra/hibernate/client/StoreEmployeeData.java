package com.chandra.hibernate.client;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import com.chandra.hibernate.pojo.ContractEmployee;
import com.chandra.hibernate.pojo.Employee;
import com.chandra.hibernate.pojo.RegularEmployee;


public class StoreEmployeeData {

	public static void main(String[] args) {
		StandardServiceRegistry ssr = new  StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
		Metadata meta = new MetadataSources(ssr).getMetadataBuilder().build();
        SessionFactory factory = meta.getSessionFactoryBuilder().build();
        Session s = factory.openSession();
        Transaction tx = s.beginTransaction();
        
        Employee e1 = new Employee();
        e1.setName("Chandra");
        
        RegularEmployee e2 = new RegularEmployee();
        e2.setName("Charan");
        e2.setSalary(45000);
        e2.setBonus(5);
        
        ContractEmployee e3 = new ContractEmployee();
        e3.setName("Murali");
        e3.setPay_per_hour(1000);
        e3.setContract_duration("15 hours");
        
        s.persist(e1);
        s.persist(e2);
        s.persist(e3);
        
        tx.commit();
        s.close();
        factory.close();
        System.out.println("Successfully Employee Records Inserted...");
        
	}

}
