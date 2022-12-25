package com.employee.exception;

public class EmployeeDaoException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String msg;
	
	public EmployeeDaoException(String msg) {
		this.msg=msg;
	}
	
	@Override
	public String getMessage() {
		return msg;
	}

}
