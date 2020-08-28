package com.mvc.controller.validations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Constraint(validatedBy = CourseCodeConstraintValidator.class)
@Target({ElementType.METHOD,ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface CourseCode {
	
	//define default course code
	public String value() default "LUV";
	
	// define default erroe msg
	public String message() default "must start with LUV";
	
	//define default groups ,we group validation constraint together
	public Class<?>[] groups() default{};
	
	//define default payload
	public Class<? extends Payload>[] payload() default{};
	

}
