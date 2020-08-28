package com.demo.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.demo.entity.Course;
import com.demo.entity.Instructor;
import com.demo.entity.InstructorDetail;
import com.demo.entity.Student;

public class DeleteCourseDemo {

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
			
			//start a transaction 
			session.beginTransaction();
			
			//get a course from db
			int theId = 10;
			Course tempCourse = session.get(Course.class,theId );
			
			//delete that course
			session.delete(tempCourse);

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
