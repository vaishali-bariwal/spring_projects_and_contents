package com.springdemo.parctice7;

import com.springdemo.Coach;
import com.springdemo.FortuneService;

public class KarateCoach implements Coach {

	public FortuneService fortuneService;
	
	public KarateCoach(FortuneService theFortuneService)
	{
		fortuneService = theFortuneService;
	}
	
	@Override
	public String getDailyWorkout() {
		// TODO Auto-generated method stub
		return "work on your punching skills";
	}

	@Override
	public String getDailyFortune() {
		// TODO Auto-generated method stub
		return fortuneService.getFortune();
	}

}
