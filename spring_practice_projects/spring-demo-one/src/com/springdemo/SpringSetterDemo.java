package com.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringSetterDemo {

public static void main(String[] args) {
		
		//load the spring confg file
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		//Retrieve bean from spring container
		CricketCoach theCoach = context.getBean("myCricketCoach",CricketCoach.class);
		
		//call method on beans 
		System.out.println(theCoach.getDailyWorkout());
		
		System.out.println(theCoach.getDailyFortune());
		
		System.out.println(theCoach.getEmailAddress());
		
		System.out.println(theCoach.getTeam());
		//context close
		context.close();
		

	}

}
