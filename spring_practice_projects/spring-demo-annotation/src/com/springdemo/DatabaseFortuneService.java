package com.springdemo;

import org.springframework.stereotype.Component;

@Component
public class DatabaseFortuneService implements FortuneService {

	public DatabaseFortuneService() {
		System.out.println("this is a DatabaseFortuneService classs");
	}

	@Override
	public String getFortune() {
		// TODO Auto-generated method stub
		return "Database Fortune Service" ;
	}

}
