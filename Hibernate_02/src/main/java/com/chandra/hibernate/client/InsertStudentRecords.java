package com.chandra.hibernate.client;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.chandra.hibernate.Student;

public class InsertStudentRecords {

	public static void main(String[] args) {

		Configuration cfg = new Configuration();
		cfg.configure();
		SessionFactory sf = cfg.buildSessionFactory();
		Session s = sf.openSession();
		Transaction tx = s.beginTransaction();

		Student s1 = new Student();
		s1.setSid(100);
		s1.setSname("ABC");
		s1.setMarks(95);

		Student s2 = new Student();
		s2.setSid(200);
		s2.setSname("PQR");
		s2.setMarks(90);

		s.save(s1);
		s.save(s2);

		tx.commit();
		s.close();
		sf.close();
	}

}
