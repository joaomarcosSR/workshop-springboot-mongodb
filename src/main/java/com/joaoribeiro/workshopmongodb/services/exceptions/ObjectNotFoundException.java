package com.joaoribeiro.workshopmongodb.services.exceptions;

public class ObjectNotFoundException extends RuntimeException{
	private static final long serialVersionUID = 1761530152933112488L;

	public ObjectNotFoundException(String msg) {
		super(msg);
	}
	
}
