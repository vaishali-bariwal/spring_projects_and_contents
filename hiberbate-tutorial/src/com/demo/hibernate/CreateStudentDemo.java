package com.demo.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.demo.entity.Student;

public class CreateStudentDemo {

	public static void main(String[] args) {
		
		//create SessionFactory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class).buildSessionFactory();
		
		// create Session
		
		Session session = factory.getCurrentSession();
		
		try {
			/*use session obj to save Java obj*/
			
			//create a student obj
			System.out.println("Creating new Student Object");
			Student st = new  Student("Ram","radhea","radhea@ramayan");
			
			//start a transaction 
			session.beginTransaction();
			
			//save java obj to database
			System.out.println("Saving new Student Object");
			session.save(st);
			
			//commit the transaction
			session.getTransaction().commit();
			System.out.println("Done");
		}
		finally {
			factory.close();
		}

	}

}
