package br.com.challenge.api.exception;

import org.springframework.web.bind.annotation.RestControllerAdvice;

public class ClienteNotExistException extends RuntimeException {

	private static final long serialVersionUID = -5844195710198591898L;

	public ClienteNotExistException(String msg) {
		super(msg);
	}

}
