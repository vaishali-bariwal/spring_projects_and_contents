package com.springdemo;

import org.springframework.beans.factory.annotation.Value;

public class SwimCoach2 implements Coach {

	private FortuneService fortuneSrvice;
	
	@Value("${foo.email}")
	private String emailAddress;
	
	@Value("${foo.team}")
	private String team;
	
	
	
	public String getEmailAddress() {
		return emailAddress;
	}
	public String getTeam() {
		return team;
	}
	
	public SwimCoach2 (FortuneService thefortuneSrvice)
	{
		fortuneSrvice = thefortuneSrvice; 
	}
	@Override
	public String getDailyWorkout() {
		// TODO Auto-generated method stub
		return "Swim for 100 miles";
	}

	@Override
	public String getDailyFortune() {
		// TODO Auto-generated method stub
		return fortuneSrvice.getFortune();
	}

}
