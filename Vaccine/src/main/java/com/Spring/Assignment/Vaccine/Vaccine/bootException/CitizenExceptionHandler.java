package com.Spring.Assignment.Vaccine.Vaccine.bootException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CitizenExceptionHandler {
	@ExceptionHandler
	public ResponseEntity<VaccineError> notFoundHandler(CitizenNotFound cnf){

		VaccineError error = new VaccineError(HttpStatus.NOT_FOUND.value() ,cnf.getMessage(),System.currentTimeMillis() );
		
		return new ResponseEntity<>(error , HttpStatus.NOT_FOUND);
	}
	@ExceptionHandler
	public ResponseEntity<VaccineError> dateHandler(DateInvalid dnf){

		VaccineError error = new VaccineError(HttpStatus.BAD_REQUEST.value(),dnf.getMessage(),System.currentTimeMillis() );
		
		return new ResponseEntity<>(error , HttpStatus.BAD_REQUEST);
	}
	@ExceptionHandler
	public ResponseEntity<VaccineError> anyExceptionHandler(Exception enf){

		VaccineError error = new VaccineError(HttpStatus.BAD_REQUEST.value(),enf.getMessage(),System.currentTimeMillis() );
		
		return new ResponseEntity<>(error , HttpStatus.BAD_REQUEST);
	}
	
		
		

}
