package com.employee.exception;

public class EmployeeServiceException extends Exception {

	String msg;
	

	public EmployeeServiceException(String msg) {
		this.msg=msg;
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	@Override
	public String getMessage() {
		return msg;
	}

}
