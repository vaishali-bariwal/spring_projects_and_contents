package com.demo.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.demo.entity.Instructor;
import com.demo.entity.InstructorDetail;
import com.demo.entity.Student;

public class DeleteDemo {

	public static void main(String[] args) {
		
		//create SessionFactory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
									.addAnnotatedClass(Instructor.class)
									.addAnnotatedClass(InstructorDetail.class)
									.buildSessionFactory();
							
		// create Session
		
		Session session = factory.getCurrentSession();
		
		try {
			//start a transaction 
			session.beginTransaction();
			
			//get the  Instructor by primary key
			int id_temp = 1; 
			Instructor theInstructor = session.get(Instructor.class,id_temp )	;	
			
			//delete the Instructor
			if(theInstructor!=null) {
				System.out.println("Deleting  "+theInstructor);
				//Note : this also delete InstructorDetail object because of CascadeType.ALL
				session.delete(theInstructor);
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
