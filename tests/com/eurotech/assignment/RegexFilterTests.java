package com.eurotech.assignment;

import static org.junit.Assert.assertEquals;

import java.util.Map;

import org.junit.Test;

import com.eurotech.assignment.builder.Director;
import com.eurotech.assignment.builder.SimpleFilterBuilder;
import com.eurotech.assignment.contracts.AbstractSimpleFilter;
import com.eurotech.assignment.contracts.AbstractSimpleFilterBuilder;
import com.eurotech.assignment.filters.simple.RegexFilter;

public class RegexFilterTests {

	@Test
	public void test() {
		
		Map<String, String> user = UserCreator.createUser();

		AbstractSimpleFilterBuilder sBuilder;
		Director director;
		AbstractSimpleFilter filter;

		// Testing regex present funcionality
		
		sBuilder = new SimpleFilterBuilder(RegexFilter.TAG);
		director = new Director(sBuilder);
		director.makeSimpleFilter("role", "[a-z]+", null, null);
		filter = director.getSimpleFilter();

		assertEquals("All characters are lowercase", true, filter.matches(user));
		
		user.put("role", "Administrator");
		assertEquals("All characters are not more lowercase", false, filter.matches(user));
	}
}
