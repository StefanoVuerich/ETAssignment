package com.eurotech.assignment;

import static org.junit.Assert.assertEquals;

import java.util.Map;

import org.junit.Test;

import com.eurotech.assignment.contracts.IFilter;
import com.eurotech.assignment.factories.FilterFactory;
import com.eurotech.assignment.filters.simple.RegexFilter;

public class RegexFilterTests {

	@Test
	public void test() {
		
		Map<String, String> user = UserCreator.createUser();
		IFilter filter;

		// Testing regex present funcionality

		filter = new FilterFactory().getFilter(RegexFilter.TAG, "role", "[a-z]+");
		assertEquals("All characters are lowercase", true, filter.matches(user));
		
		user.put("role", "Administrator");
		assertEquals("All characters are not more lowercase", false, filter.matches(user));
		
		// This will throw PropertyNotFoundException
		filter = new FilterFactory().getFilter(RegexFilter.TAG, "notpresentproperty", "[a-z]+");
		filter.matches(user);
	}
}
