package com.mvc.controller;

import javax.validation.Valid;

import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/customer")
public class CustomerController {
	
	//add an initbinder ...to convert trim input strings
	//remove leading and trailing whitespaces
	//resolve issue for our validation
	
	@InitBinder
	public void initBinder (WebDataBinder dataBinder) {
		
		StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
		dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
	}
	
	@RequestMapping("/showForm")
	public String showForm(Model theModel) {
		
		// create a student obj
		Customer theCustomer = new Customer();
		
		// add student obj to the model
		theModel.addAttribute("customer",theCustomer);
		
		return "customer-form";
	}
	
	@RequestMapping("/processForm")
	public String processForm(@Valid @ModelAttribute("customer") Customer theCustomer,BindingResult theBindingResult) {
		
		if(theBindingResult.hasErrors()){
			return "customer-form";
			}
		
		else{
			System.out.println("thecustomer "+theCustomer.getFirstName() +"  "+theCustomer.getLastName());
			
		    return "customer-confirmation";
			}
		
	}

}
