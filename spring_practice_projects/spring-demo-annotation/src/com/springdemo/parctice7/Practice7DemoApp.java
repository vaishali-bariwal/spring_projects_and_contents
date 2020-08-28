package com.springdemo.parctice7;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.springdemo.Coach;
import com.springdemo.KarateConfig;

public class Practice7DemoApp {

	public static void main(String[] args) {
		
		//read spring config java class
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(KarateConfig.class);
		
		// get the bean from spring container
		Coach theCoach = context.getBean("karateCoach",Coach.class);
		
		// call a method on the bean
		System.out.println(theCoach.getDailyWorkout());
		System.out.println(theCoach.getDailyFortune());
		//System.out.println("EmailAddress :  "+theCoach.getEmailAddress()+"\nTeam : "+theCoach.getTeam());
		
		// close the context
		context.close();
	}

}
