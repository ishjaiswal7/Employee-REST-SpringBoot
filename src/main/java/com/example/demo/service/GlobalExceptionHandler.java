package com.example.demo.service;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.example.demo.exceptions.BadRequestException;
import com.example.demo.exceptions.ResourceNotFoundException;

@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(Exception.class) 
	public ResponseEntity<String> handleGlobalException(Exception e){
		return new ResponseEntity<>(
			"An unexcepted error occured: " +
					e.getMessage(),
			HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<String> handleResourceNotFoundException(
				ResourceNotFoundException e) {
		return new ResponseEntity<>(
				"Resource not found: "
					+ e.getMessage(),
				HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(BadRequestException.class)
	public ResponseEntity<String> handleBadRequestException(
				BadRequestException e) {
		return new ResponseEntity<>(
				"Bad Reuest: "
					+ e.getMessage(),
				HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<String> handleValidationException(
				MethodArgumentNotValidException e) {
		String errorMessage = e.getBindingResult().
				getFieldError().getDefaultMessage();
		return new ResponseEntity<>(
					"Validation error: "+ errorMessage,
				HttpStatus.BAD_REQUEST);
	}
}
