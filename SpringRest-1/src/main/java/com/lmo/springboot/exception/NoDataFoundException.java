package com.lmo.springboot.exception;

public class NoDataFoundException extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public NoDataFoundException() {
		super("No Data Found");
	}
}
