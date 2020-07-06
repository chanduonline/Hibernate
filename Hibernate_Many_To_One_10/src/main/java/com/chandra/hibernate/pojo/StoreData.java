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
	      
	    Employee e2=new Employee();  
	    e2.setName("Chandra Sekhar");  
	    e2.setEmail("chandramca04@gmail.com");  
	        
	    Address address1=new Address();    
	    address1.setAddressLine1("West Venkatapuram,DinakarNager");    
	    address1.setCity("Secundrabad");    
	    address1.setState("TS");    
	    address1.setCountry("India");    
	    address1.setPincode(500015);    
	        
	    e1.setAddress(address1);    
	    e2.setAddress(address1);  
	  
	    session.persist(e1);    
	    session.persist(e2);  
	    t.commit();    
	        
	    session.close();    
	    factory.close();
	    System.out.println("success");    

	}

}
