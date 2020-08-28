package com.demo.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.demo.entity.Student;

public class PrimaryKeyDemo {

	public static void main(String[] args) {
		
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class).buildSessionFactory();
		
		// create Session
		
		Session session = factory.getCurrentSession();
		
		try {
			/*use session obj to save Java obj*/
			
			//create 3 student obj
			System.out.println("Creating 3 Student Objects");
			Student st = new  Student("Ram","radhea","radhea@ramayan");
			Student st1 = new  Student("Gam","rdhea","radea@ramayan");
			Student st2 = new  Student("Sam","Sea","Sea@ramayan");
			//start a transaction 
			session.beginTransaction();
			
			//save java obj to database
			System.out.println("Saving 3 Student Objects");
			session.save(st);
			session.save(st2);
			session.save(st1);
			
			//commit the transaction
			session.getTransaction().commit();
			System.out.println("Done");
		}
		finally {
			factory.close();
		}

	}


}
