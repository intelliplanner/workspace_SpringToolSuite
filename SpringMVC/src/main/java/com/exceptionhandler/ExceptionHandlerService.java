package com.exceptionhandler;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class ExceptionHandlerService {
	@ExceptionHandler(value= Exception.class)
	public ModelAndView exceptionHandler(Exception e) {
		System.out.println("Exception: "+e);
		ModelAndView m = new ModelAndView("ExceptionHandler","exception" ,e);
		return m;
	}
}
