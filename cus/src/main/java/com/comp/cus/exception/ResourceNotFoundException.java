package com.comp.cus.exception;

public class ResourceNotFoundException extends RuntimeException {

	
	public ResourceNotFoundException(String string) {
		// TODO Auto-generated constructor stub
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String message;

}
