package com.eurotech.assignment.customexceptions;

public class PropertyNotFoundException extends Exception{

	private static final long serialVersionUID = 1L;
	private String property;
	
	public PropertyNotFoundException(String property) {
		this.property = property;
	}
	
	@Override
	public String getMessage() {
		return "Property not found Exception : " + property;
	}
}
