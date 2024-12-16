package com.employees.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.employees.exception.custom.ErrorResponse;
import com.employees.exception.custom.ResourceNotFoundException;

@RestControllerAdvice
public class GlobalException {

	@ExceptionHandler(ResourceNotFoundException.class)

	public ResponseEntity<ErrorResponse> resourceNotFoundExceptionHandler(ResourceNotFoundException ex) {
		ErrorResponse errorResponse = new ErrorResponse(LocalDateTime.now(), HttpStatus.NOT_FOUND.value(),
				ex.getMessage(), "Resource not found with the given data :");
		return new ResponseEntity<ErrorResponse>(errorResponse, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorResponse> globalExceptionHandler(Exception e) {
		ErrorResponse errorResponse = new ErrorResponse(LocalDateTime.now(), HttpStatus.INTERNAL_SERVER_ERROR.value(),
				e.getMessage(), "An error occured :");
		return new ResponseEntity<ErrorResponse>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
