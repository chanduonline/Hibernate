package com.chandra.hibernate.client;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.chandra.hibernate.Student;

public class UpdateStudent {

	public static void main(String[] args) {
		Configuration cfg = new Configuration();
		cfg.configure();
		SessionFactory sf = cfg.buildSessionFactory();
		Session s = sf.openSession();
		Transaction tx = s.beginTransaction();
		
		Student s1 = (Student)s.get(Student.class, new Integer(200));
		s1.setSname("PPP");
		s.update(s1);
		tx.commit();
		s.close();
		sf.close();
	}

}
