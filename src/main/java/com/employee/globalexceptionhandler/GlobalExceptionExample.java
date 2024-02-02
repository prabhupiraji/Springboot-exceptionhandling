package com.employee.globalexceptionhandler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.employee.customexception.NoIdException;

@ControllerAdvice
public class GlobalExceptionExample {
	
     @ExceptionHandler(NoIdException.class)
	public ResponseEntity<String> checkId(NoIdException NoIdException){
		return new ResponseEntity<String> ("no id is present in data base please provide valid id",HttpStatus.NOT_FOUND);
	}
	
}
