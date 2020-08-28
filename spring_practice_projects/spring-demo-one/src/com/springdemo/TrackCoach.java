package com.springdemo;

public class TrackCoach implements Coach {

	private FortuneService fortuneService;
	
	//define constructor for dependency injection
	public TrackCoach (FortuneService theFortuneService) {
		fortuneService = theFortuneService;
	}
	@Override
	public String getDailyWorkout() {
		// TODO Auto-generated method stub
		return "Run a hard 5k";
	}

	@Override
	public String getDailyFortune() {
		// TODO Auto-generated method stub
		return fortuneService.getFortune();
		
	
	}
	
	//add an init method
	public void doMyStartuoStuff()
	{
		System.out.println("TrackCoach: inside init method - doMyStartuoStuff");
	}
	
	//add a destroy method
	
	public void doMyCleanUpStuffYoYo()
	{
		System.out.println("TrackCoach: inside destroy method - doMyCleanUpStuffYoYo");
	}

}
