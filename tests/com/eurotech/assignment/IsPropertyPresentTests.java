package com.eurotech.assignment;

import static org.junit.Assert.*;

import java.util.LinkedHashMap;
import java.util.Map;

import org.junit.Test;

import com.eurotech.assignment.builder.Director;
import com.eurotech.assignment.builder.SimpleFilterBuilder;
import com.eurotech.assignment.contracts.AbstractSimpleFilter;
import com.eurotech.assignment.contracts.AbstractSimpleFilterBuilder;
import com.eurotech.assignment.filters.IsPropertyPresentFilter;
import com.eurotech.assignment.filters.PropertyComparatorFilter;
import com.eurotech.assignment.utils.Comparator;

public class IsPropertyPresentTests {

	@Test
	public void test() {
		
		Map<String,String> user = UserCreator.createUser();
		
		AbstractSimpleFilterBuilder sBuilder;
		Director director;
		AbstractSimpleFilter filter;
		
		// Testing is property present funcionality
		
		sBuilder = new SimpleFilterBuilder(IsPropertyPresentFilter.TAG);
		director = new Director(sBuilder);
		director.makeSimpleFilter("firstname", null, null, null);
		filter = director.getSimpleFilter();
		
		assertEquals("Property firstname is present", true, filter.matches(user));
		
		user.remove("firstname");
		assertEquals("Property firstname is not more present", false, filter.matches(user));
		
		director.makeSimpleFilter("Surname", null, null, null);
		filter = director.getSimpleFilter();
		assertEquals("Test for case sensitivity", false, filter.matches(user));
	}

}
