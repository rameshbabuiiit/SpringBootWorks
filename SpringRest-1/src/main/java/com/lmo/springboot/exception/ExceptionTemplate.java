package com.lmo.springboot.exception;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonRootName;

@Component
@JsonRootName(value = "Exception")
public class ExceptionTemplate {
	private String code;
	private String message;

	public ExceptionTemplate() {
	}

	public ExceptionTemplate(String code, String message) {
		super();
		this.code = code;
		this.message = message;
	}
	/**
	 * @return the code
	 */
	public String getCode() {
		return code;
	}
	
	/**
	 * @param code the code to set
	 */
	public void setCode(String code) {
		this.code = code;
	}

	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * @param message the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "NoData [code=" + code + ", message=" + message + "]";
	}


}