package com.eurotech.assignment;

import static org.junit.Assert.assertEquals;

import java.util.Map;

import org.junit.Test;

import com.eurotech.assignment.builder.Director;
import com.eurotech.assignment.builder.SimpleFilterBuilder;
import com.eurotech.assignment.contracts.AbstractSimpleFilter;
import com.eurotech.assignment.contracts.AbstractSimpleFilterBuilder;
import com.eurotech.assignment.filters.simple.PropertyComparatorFilter;
import com.eurotech.assignment.utils.Comparator;

public class PropertyComparatorTests {

	@Test
	public void test() {

		Map<String, String> user = UserCreator.createUser();

		AbstractSimpleFilterBuilder sBuilder;
		Director director;
		AbstractSimpleFilter filter;
		
		// Testing String comparator functionality
		
		sBuilder = new SimpleFilterBuilder(PropertyComparatorFilter.TAG);
		director = new Director(sBuilder);
		
		director.makeSimpleFilter("role", "administrator", Comparator.EQUALS, null);
		filter = director.getSimpleFilter();
		assertEquals("Testing for String equality", true, filter.matches(user));
		
		user.put("role", "Administrator");
		assertEquals("Testing for String case insensitivity", true, filter.matches(user));
		
		director.makeSimpleFilter("role", "user", Comparator.EQUALS, null);
		filter = director.getSimpleFilter();
		assertEquals("Testing for non matching values", false, filter.matches(user));
		
		// Testing int comparator functionality
		
		director.makeSimpleFilter("age", "35", Comparator.EQUALS, null);
		filter = director.getSimpleFilter();
		assertEquals("age is 35", true, filter.matches(user));
		
		director.makeSimpleFilter("age", "34", Comparator.MINUS, null);
		filter = director.getSimpleFilter();
		assertEquals("34 is < than 35", true, filter.matches(user));
		
		director.makeSimpleFilter("age", "36", Comparator.PLUS, null);
		filter = director.getSimpleFilter();
		assertEquals("36 is > than 35", true, filter.matches(user));
		
		user.put("age", "40");
		
		director.makeSimpleFilter("age", "35", Comparator.EQUALS, null);
		filter = director.getSimpleFilter();
		assertEquals("age is 40", false, filter.matches(user));
		
		director.makeSimpleFilter("age", "41", Comparator.MINUS, null);
		filter = director.getSimpleFilter();
		assertEquals("41 is not < than 40", false, filter.matches(user));
		
		director.makeSimpleFilter("age", "39", Comparator.PLUS, null);
		filter = director.getSimpleFilter();
		assertEquals("39 is not > di 40", false, filter.matches(user));
		
	}
}
