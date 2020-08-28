package com.demo.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.demo.entity.Student;

public class ReadStudentDemo {

	public static void main(String[] args) {
		
		//create SessionFactory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class).buildSessionFactory();
		
		// create Session
		
		Session session = factory.getCurrentSession();
		
		try {
			/*use session obj to save Java obj*/
			
			//create a student obj
			System.out.println("Creating new Student Object");
			Student st = new  Student("Daffy","Duck","daffuduck@ramayan");
			
			//start a transaction 
			session.beginTransaction();
			
			//save java obj to database
			System.out.println("Saving new Student Object");
			System.out.println(st);
			session.save(st);
			
			//commit the transaction
			session.getTransaction().commit();
			
			//find out the student primary key
			System.out.println("Saved student Generated id : "+st.getId());
			
			//now get a new session and start transaction
			session = factory.getCurrentSession();
			session.beginTransaction();
			
			//retrieve student based on id : primary key
			System.out.println("\nGetting student with id "+st.getId());
			Student st_result = session.get(Student.class, st.getId());
			System.out.println("Retrieved "+st_result);
			//commit transaction
			session.getTransaction().commit();
			
			System.out.println("Done");
		}
		finally {
			factory.close();
		}

	}

}
