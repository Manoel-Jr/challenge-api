package br.com.challenge.api.exception.handler;


import java.util.Date;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import br.com.challenge.api.exception.ClienteNotExistException;

@ControllerAdvice
public class ResourceExceptionHandler extends ResponseEntityExceptionHandler {

	
	@ExceptionHandler(ClienteNotExistException.class)
	public ResponseEntity<ApiError> handlerClienteNotExistException(ClienteNotExistException ex){
		ApiError error = new ApiError(HttpStatus.NOT_FOUND.value(), ex.getMessage(), new Date());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
	}
	
	@ExceptionHandler(EmptyResultDataAccessException.class)
	public ResponseEntity<ApiError> handlerEmptyResultDataAccessException(EmptyResultDataAccessException ex){
		ApiError error = new ApiError(HttpStatus.NOT_FOUND.value(), "O id do cliente não existe", new Date());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
	}
}
