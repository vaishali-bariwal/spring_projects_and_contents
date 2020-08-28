package com.demo.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.demo.entity.Course;
import com.demo.entity.Instructor;
import com.demo.entity.InstructorDetail;
import com.demo.entity.Review;
import com.demo.entity.Student;

public class CreateCourseAndStudentDemo {

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
			
			//create a course
			Course temCourse = new Course("ComputerGraphi cs");
			
			//save course .... 
			System.out.println("Saving the course.....");
			session.save(temCourse);
			System.out.println("Saved  course : "+ temCourse);
			
			
			//create student 
			Student tempStudent1 = new Student("Sumit","Murari","sumit@gmail.com");
			Student tempStudent2 = new Student("amit","Murari","amit@gmail.com");
			
			//add students to the course 
			temCourse.addStudent(tempStudent1);
			temCourse.addStudent(tempStudent2);
			
			// save student
			System.out.println("Saving the Students......");
			session.save(tempStudent1);
			session.save(tempStudent2);
			System.out.println("Saved students "+temCourse.getStudents());
					
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
