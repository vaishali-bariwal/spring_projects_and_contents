package com.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/student")
public class StudentController {
	
	@RequestMapping("/showForm")
	public String showForm(Model theModel) {
		
		// create a student obj
		Student theStudent = new Student();
		
		// add student obj to the model
		theModel.addAttribute("student",theStudent);
		
		return "student-form";
	}
	@RequestMapping("/processForm")
		
	public String processForm(@ModelAttribute("student") Student theStudent) {
		
		//theStudent.setCountry(theStudent.getCountryOptions().get(theStudent.getCountry()));
		
		System.out.println("theStudent "+theStudent.getFirstName() +"  "+theStudent.getLastName()+" "+theStudent.getCountry()+" "+theStudent.getCountryOptions().get(theStudent.getCountry()));
		
		return "student_confirmation";
		
	}
	

	
}
