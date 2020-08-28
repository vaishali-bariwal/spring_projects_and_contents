package com.demo.hibernate;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.demo.entity.Course;
import com.demo.entity.Instructor;
import com.demo.entity.InstructorDetail;
import com.demo.entity.Review;
import com.demo.entity.Student;

public class GetCourseForSumitDemo {

	public static void main(String[] args) {
		
		//create SessionFactory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
									.addAnnotatedClass(Instructor.class)
									.addAnnotatedClass(InstructorDetail.class)
									.addAnnotatedClass(Course.class)
									.addAnnotatedClass(Review.class)
									.addAnnotatedClass(Student.class)
									.buildSessionFactory();
							
		// create Session
		
		Session session = factory.getCurrentSession();
		
		try {
			/*use session obj to save Java obj*/
			
			//start a transaction 
			session.beginTransaction();
			
			//get the student sumit from db
			int theId = 7;
			Student temoStudent = session.get(Student.class,theId );
			System.out.println("Student : "+temoStudent);
			System.out.println("Courses assign to mary : "+temoStudent.getCourses());
			
			//print the courses for sumit
			List<Course> courses = temoStudent.getCourses();
			for(Course c: courses)
			{
				System.out.println("Courses : "+c);
			}
			
			
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
