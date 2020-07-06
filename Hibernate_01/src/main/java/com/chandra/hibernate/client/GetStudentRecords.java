package com.chandra.hibernate.client;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.chandra.hibernate.Student;

public class GetStudentRecords {

	public static void main(String[] args) {
		Configuration cfg = new Configuration();
		cfg.configure();
		SessionFactory sf = cfg.buildSessionFactory();
		Session s = sf.openSession();
		Transaction tx = s.beginTransaction();
		
		Student s1 = (Student)s.get(Student.class, new Integer(200));
		System.out.println("Student Number  : "+s1.getSid());
	    System.out.println("Student Name    : "+s1.getSname());
		System.out.println("Student Marks   : "+s1.getMarks());
		
		tx.commit();
		s.close();
		sf.close();
	}

}
