package com.demo.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.demo.entity.Course;
import com.demo.entity.Instructor;
import com.demo.entity.InstructorDetail;
import com.demo.entity.Student;

public class FetchJoinDemo {

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
			
			//get the instructor from db
			int theId = 1;
			Query<Instructor> q = session.createQuery("select i from Instructor i "
													+ "Join fetch i.courses "
													+"where i.id=:theinstructorid",
													Instructor.class);
			
			q.setParameter("theinstructorid", theId);
			
			Instructor theInstructor = q.getSingleResult();
			
			System.out.println("HIBERNATE : theInstructor  "+theInstructor);
			
			//get courses for the instructor
			System.out.println("HIBERNATE : courses  "+theInstructor.getCourses());
			
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
