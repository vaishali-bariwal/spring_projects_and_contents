package com.demo.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.demo.entity.Course;
import com.demo.entity.Instructor;
import com.demo.entity.InstructorDetail;
import com.demo.entity.Student;

public class CreateInstructorDemo {

	public static void main(String[] args) {
		
		//create SessionFactory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
									.addAnnotatedClass(Instructor.class)
									.addAnnotatedClass(InstructorDetail.class)
									.addAnnotatedClass(Course.class)
									.buildSessionFactory();
							
		// create Session
		
		Session session = factory.getCurrentSession();
		
		try {
			/*use session obj to save Java obj*/
			
			//create a  objects
			Instructor theInstructor = new Instructor("Mohan","Ram","mohan@gmail");
			InstructorDetail theInstructorDetail = new InstructorDetail("http://www.kj mask/youtube","Teaching");
			
			// associate the objects
			System.out.println("Creating new Instructor Object");
			theInstructor.setInstructorDetail(theInstructorDetail);
			
			//start a transaction 
			session.beginTransaction();
			
			//save instructor obj to database
			//Note : this also save InstructorDetail object because of CascadeType.ALL
			System.out.println("Saving Instructor Object"+theInstructor);
			session.save(theInstructor);
			
			//commit the transaction
			session.getTransaction().commit();
			System.out.println("Done");
		}
		finally {
			//add clean up code
			session.close();
			factory.close();
		}

	}

}
