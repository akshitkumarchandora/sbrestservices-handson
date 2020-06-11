package com.cognizant.springlearn.exception;

import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;

@SuppressWarnings("serial")
@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Country not found")
public class CountryNotFoundException extends RuntimeException{
	private String message;
	public CountryNotFoundException()
	{}
	public CountryNotFoundException(String message)
	{
		super(message);
		this.message=message;
		
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
}
