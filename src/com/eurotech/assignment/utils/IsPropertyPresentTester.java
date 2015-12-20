package com.eurotech.assignment.utils;

import java.util.Map;

import com.eurotech.assignment.customexceptions.PropertyNotFoundException;

public class IsPropertyPresentTester {

	public static void test(Map<String, String> resource, String property) throws PropertyNotFoundException {
		if (!resource.containsKey(property))
			throw new PropertyNotFoundException(property);
	}
}
