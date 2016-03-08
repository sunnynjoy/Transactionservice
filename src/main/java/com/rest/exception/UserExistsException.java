package com.rest.exception;

public class UserExistsException extends RuntimeException {

    /**
	 * 
	 */
	private static final long serialVersionUID = 6387788521305560526L;

	public UserExistsException(String message){
        super(message);
    }
}
