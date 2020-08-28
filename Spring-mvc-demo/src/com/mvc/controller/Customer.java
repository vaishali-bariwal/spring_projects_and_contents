package com.mvc.controller;
import com.mvc.controller.validations.CourseCode;
import javax.validation.constraints.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Customer {
	
	private String firstName;
	
	@NotNull(message="is required")
	@Size(min=1,message="is required")
	private String lastName;
     
	@NotNull(message="is required")
	@Min(value = 0,message="minimum value should be 0")
	@Max(value = 10,message="maximum value should be 10")
	private Integer freePasses;
	
	@Pattern(regexp="^[0-9]{5}",message="Only 5 digits")
	private String postalcode;
	
	@CourseCode(value="UVOO",message="must start with UV")
	private String courseCode;
	
	

	public String getCourseCode() {
		return courseCode;
	}

	public void setCourseCode(String courseCode) {
		this.courseCode = courseCode;
	}

	public String getPostalcode() {
		return postalcode;
	}

	public void setPostalcode(String postalcode) {
		this.postalcode = postalcode;
	}
	
	public Integer getFreePasses() {
		return freePasses;
	}

	public void setFreePasses(Integer freePasses) {
		this.freePasses = freePasses;
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
