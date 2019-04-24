package com.lmo.springboot.exception;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;


@ControllerAdvice
public class ExceptionHandlerCentral extends ResponseEntityExceptionHandler {
	@Autowired
	ExceptionTemplate exp;

	@ExceptionHandler(NoDataFoundException.class)
	public ResponseEntity<Object> NoDataFoundHandler(RuntimeException ex) {
		System.out.println("No Data Found launched!");
		exp.setCode("20001");
		exp.setMessage(ex.getLocalizedMessage());
		System.out.println(exp);
		return new ResponseEntity<Object>(exp, HttpStatus.OK);
	}

}