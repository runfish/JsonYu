package com.dp.hibernate.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.dp.hiberbate.domain.Student;

public class StudentTest1 {

	public static void main(String[] args) {
		Student student = new Student();

		Configuration cfg = new Configuration();

		SessionFactory sessionFactory = cfg.configure().buildSessionFactory();
		
		Session session = sessionFactory.openSession();
		
		session.beginTransaction();
		
		session.save(student);
		
		session.getTransaction().commit();
		
		session.close();
		
		sessionFactory.close();
		
		
		
		

	}
}