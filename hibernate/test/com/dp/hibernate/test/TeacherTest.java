package com.dp.hibernate.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.dp.hiberbate.domain.Student;
import com.dp.hiberbate.domain.Teacher;

public class TeacherTest {

	private static SessionFactory sf;

	@BeforeClass
	public  static void beforeClass() {
		try {

			sf = new Configuration().configure().buildSessionFactory();
			System.out.println(sf);

		} catch (Exception e) {
			// TODO: handle exception
		}

	}
	

	@Test
	public void main() {
		Teacher teacher = new Teacher();
		//teacher.setId(2);
		teacher.setName("lh");
		teacher.setTitle("教授");

		Session session = sf.openSession();

		session.beginTransaction();

		session.save(teacher);

		session.getTransaction().commit();

		session.close();

	}
	
//	public static void main(String[] args) {
//		beforeClass();
//	}

	@AfterClass
	public static void afterClass() {
		sf.close();
	}
}