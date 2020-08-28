package com.springdemo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

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
