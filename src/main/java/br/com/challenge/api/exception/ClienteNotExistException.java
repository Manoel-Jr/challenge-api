package br.com.challenge.api.exception;

public class ClienteNotExistException extends RuntimeException {

	private static final long serialVersionUID = -5844195710198591898L;

	public ClienteNotExistException(String msg) {
		super(msg);
	}

}
