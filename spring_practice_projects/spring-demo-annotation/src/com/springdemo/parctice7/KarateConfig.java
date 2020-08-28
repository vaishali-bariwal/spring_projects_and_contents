package com.springdemo.parctice7;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.springdemo.Coach;
import com.springdemo.FortuneService;

@Configuration
public class KarateConfig {
	
	@Bean 
	public FortuneService karateFortuneService() {
		return new KarateFortuneService();
	}
	@Bean
	public Coach karateCoach()
	{
		return new KarateCoach(karateFortuneService());
	}

}
