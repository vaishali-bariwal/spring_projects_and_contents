package com.demo.hibernate;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.demo.entity.Student;

public class UpdateStudentDemo {

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
			
			//get student 
			//this is to update for single object
			/*Student st_result = session.get(Student.class, 2);
			System.out.println("Retrieved "+st_result);
			
			st_result.setFirstName("VAishu");		*/
			
			
			// to upadte multiple row at Students
			session.createQuery("update Student set email='vaishali@gmail' where firstName='VAishu'").executeUpdate();
			
			
			//commit the transaction
			session.getTransaction().commit();
			System.out.println("Done");
		}
		finally {
			factory.close();
		}

	}

}
