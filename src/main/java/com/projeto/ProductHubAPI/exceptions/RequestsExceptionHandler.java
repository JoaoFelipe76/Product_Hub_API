package com.projeto.ProductHubAPI.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import jakarta.persistence.EntityNotFoundException;

@RestControllerAdvice
public class RequestsExceptionHandler extends ResponseEntityExceptionHandler{
	
	@ExceptionHandler(EntityNotFoundException.class)
	public ResponseEntity<String> EntityNotFoundException(EntityNotFoundException exception) {
		
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Dado não encontrado");
		
	}

}
