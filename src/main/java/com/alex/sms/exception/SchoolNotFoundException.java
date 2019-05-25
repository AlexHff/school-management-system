package com.alex.sms.exception;

public class SchoolNotFoundException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public SchoolNotFoundException(Integer id) {
		super(String.format("School with id '%s' could not be found.", id));
	}

}
