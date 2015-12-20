package com.eurotech.assignment;

import java.util.LinkedHashMap;
import java.util.Map;

public class UserCreator {

	public static Map<String,String> createUser() {
		
		Map<String, String> user = new LinkedHashMap<String, String>();
		user.put("firstname", "Joe");
		user.put("surname", "Bloggs");
		user.put("role", "administrator");
		user.put("age", "35");
		
		return user;
	}
}
