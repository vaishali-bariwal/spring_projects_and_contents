package com.demo.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.demo.entity.Instructor;
import com.demo.entity.InstructorDetail;
import com.demo.entity.Student;

public class GetInstructorDetailDemo {

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
			
			//get the  InstructorDetail obj by primary key
			int id_temp = 2; 
			InstructorDetail theInstructorDetail = session.get(InstructorDetail.class,id_temp )	;	
			
			//print the InstructorDetail
			if(theInstructorDetail!=null) {
				System.out.println("theInstructorDetail  "+theInstructorDetail);
				//Note : this also fetch InstructorDetail object because of CascadeType.ALL
			    //print the associated Instructor
				System.out.println("Associated Instructor  "+theInstructorDetail.getInstructor());
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
