package com.chandra.hibernate.pojo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class StoreData {

	public static void main(String[] args) {
		 StandardServiceRegistry ssr=new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();  
		    Metadata meta=new MetadataSources(ssr).getMetadataBuilder().build();  
		      
		    SessionFactory factory=meta.getSessionFactoryBuilder().build();  
		    Session session=factory.openSession();  
		      
		    Transaction t=session.beginTransaction();   
		      
		    Employee e1=new Employee();    
		    e1.setName("Sai Charan");    
		    e1.setEmail("charan@gmail.com");    
		        
		    Address address1=new Address();    
		    address1.setAddressLine1("West Venkatapuram,Dinakar Nagar");    
		    address1.setCity("Secundrabad");    
		    address1.setState("TS");    
		    address1.setCountry("India");    
		    address1.setPincode(500015);    
		        
		    e1.setAddress(address1);    
		    address1.setEmployee(e1);    
		        
		    session.persist(e1);    
		    t.commit();    
		        
		    session.close();    
		    System.out.println("success");    
		    factory.close();

	}

}
