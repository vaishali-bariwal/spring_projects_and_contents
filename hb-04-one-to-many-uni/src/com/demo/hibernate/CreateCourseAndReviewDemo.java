package com.demo.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.demo.entity.Course;
import com.demo.entity.Instructor;
import com.demo.entity.InstructorDetail;
import com.demo.entity.Review;
import com.demo.entity.Student;

public class CreateCourseAndReviewDemo {

	public static void main(String[] args) {
		
		//create SessionFactory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
									.addAnnotatedClass(Instructor.class)
									.addAnnotatedClass(InstructorDetail.class)
									.addAnnotatedClass(Course.class)
									.addAnnotatedClass(Review.class)
									.buildSessionFactory();
							
		// create Session
		
		Session session = factory.getCurrentSession();
		
		try {
			/*use session obj to save Java obj*/
			
			//start a transaction 
			session.beginTransaction();
			
			//create a course
			Course temCourse = new Course("ComputerGame");
			
			
			// add some reviews
			temCourse.addReview(new Review("Great"));
			temCourse.addReview(new Review("Good"));
			temCourse.addReview(new Review("Bad"));
			
			//save course .... and leverage the cascade all
			System.out.println("Saving the course");
			System.out.println(temCourse);
			System.out.println(temCourse.getReviews());
			session.save(temCourse);
			
			//commit the transaction
			session.getTransaction().commit();
			System.out.println("Done!");
		}
		finally {
			//add clean up code
			session.close();
			factory.close();
		}

	}

}
