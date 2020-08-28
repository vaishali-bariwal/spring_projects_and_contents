package com.springdemo;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.*;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component()
//@Scope("prototype")
public class TennisCoach implements Coach {
	
	// field injection 
	//spring will set value behind the scene using java Reflection Technology
	@Autowired
	@Qualifier("randomFortuneService")
	private FortuneService fortuneService;
	
	//define constructor for dependency injection
    /* 
    @Autowired
	public TennisCoach (FortuneService theFortuneService) {
		fortuneService = theFortuneService;
	}
	*/
	
	// setter injection
	
	/*@Autowired
	public void setFortuneService(FortuneService fortuneService) {
		this.fortuneService = fortuneService;
	}*/
	
	// method injection
	
	/*
	 * @Autowired public void anyMethodName(FortuneService fortuneService) {
	 * this.fortuneService = fortuneService; }
	 */
	
	@Override
	public String getDailyWorkout() {
		
		return "Practice your backhand volley";
	}
	
	public FortuneService getFortuneService() {
		return fortuneService;
	}
	@Override
	public String getDailyFortune() {
		// TODO Auto-generated method stub
		return fortuneService.getFortune();
	}
	
	/*
	 * USING QUALIFIER IN CONSTRUCTION IS LITTLE DEFFERENT
	 
	 @Autowired
	public TennisCoach (@Qualifier("RESTFortuneService") FortuneService theFortuneService) {
		fortuneService = theFortuneService;
	 }
	 * */
	
	//Define my init method
	@PostConstruct
	 public void doMyStartupStuff() {
		 System.out.println("Inside doMyStartupStuff");
	 }
	
	//Define my destroy method
	@PreDestroy
	 public void doMycleanupStuff() {
		 System.out.println("Inside doMycleanupStuff");
	 }
	

}
