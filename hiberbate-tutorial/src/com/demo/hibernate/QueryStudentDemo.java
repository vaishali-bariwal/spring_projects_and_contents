package com.demo.hibernate;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.demo.entity.Student;

public class QueryStudentDemo {

	public static void main(String[] args) {
		
		//create SessionFactory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
									.addAnnotatedClass(Student.class)
									.buildSessionFactory();
		
		// create Session
		
		Session session = factory.getCurrentSession();
		
		try {
			/*use session obj to query Java obj*/
			
			//start a transaction 
			session.beginTransaction();
			
			//Query student
			//List<Student> allStudents = session.createQuery("from Student").list();
			//List<Student> allStudents = session.createQuery("from Student s where s.lastName='Sea' or s.lastName='Duck'").list();
			List<Student> allStudents = session.createQuery("from Student s where s.lastName LIKE'%a%'").list();
			
			//Display Students
			for(Student s: allStudents) {
				System.out.println(s);
				
			}
			
			//commit the transaction
			session.getTransaction().commit();
			System.out.println("Done");
		}
		finally {
			factory.close();
		}

	}

}
