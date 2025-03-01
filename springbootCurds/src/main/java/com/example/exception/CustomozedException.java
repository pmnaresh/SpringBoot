package com.example.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
@ControllerAdvice
public class CustomozedException extends ResponseEntityExceptionHandler {

	@ExceptionHandler(ProductNotFoundException.class)
	public ResponseEntity<Object> handleExceptions(ProductNotFoundException exception, WebRequest webRequest) {
	ExceptionResponse response = new ExceptionResponse();
    response.setDateTime(LocalDateTime.now());
    response.setMessage("Record is not available in the db");
	return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
	}

}
