package com.mvc.controller;

import java.util.LinkedHashMap;

public class Student 
{
	private String firstName;
	private String lastName;
	private String country;
	private String favoriteLanguage;
	private String[] operatingSystems;
	
	
	public String[] getOperatingSystems() {
		return operatingSystems;
	}



	public void setOperatingSystems(String[] operatingSystems) {
		this.operatingSystems = operatingSystems;
	}

	private LinkedHashMap<String,String> countryOptions;
	private LinkedHashMap<String, String> favoriteLanguageOptions;
	private LinkedHashMap<String, String>  operatingSystemsOptions;
	
	public Student() {
		
		countryOptions = new LinkedHashMap<>();
		countryOptions.put("BR", "Brazil");
		countryOptions.put("IN", "India");
		countryOptions.put("GE", "Germany");
		countryOptions.put("Fr", "France");
		countryOptions.put("USA", "United State Of America");
		countryOptions.put("JP", "Japan");
		
		favoriteLanguageOptions = new LinkedHashMap<>();

		    // parameter order: value, display label
		    //
	    favoriteLanguageOptions.put("Java", "Java");
	    favoriteLanguageOptions.put("C#", "C#");
	    favoriteLanguageOptions.put("PHP", "PHP");
	    favoriteLanguageOptions.put("Ruby", "Ruby");  
	    
	    operatingSystemsOptions = new LinkedHashMap<>();
	    
	    operatingSystemsOptions.put("MacOS", "MacOS");
	    operatingSystemsOptions.put("Linux", "Linux");
	    operatingSystemsOptions.put("Ubuntu", "Ubuntu");
	    operatingSystemsOptions.put("Window", "Window");  
	    

		
	}
	 // populate favorite language options
   


	public LinkedHashMap<String, String> getOperatingSystemsOptions() {
		return operatingSystemsOptions;
	}



	public LinkedHashMap<String, String> getFavoriteLanguageOptions() {
	    return favoriteLanguageOptions;
	}
	
	public String getFavoriteLanguage() {
		return favoriteLanguage;
	}


	public void setFavoriteLanguage(String favoriteLanguage) {
		this.favoriteLanguage = favoriteLanguage;
	}

	
	public LinkedHashMap<String, String> getCountryOptions() {
		return countryOptions;
	}


	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	

}
