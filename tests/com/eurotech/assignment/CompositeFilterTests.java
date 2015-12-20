package com.eurotech.assignment;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Map;

import org.junit.Test;

import com.eurotech.assignment.builder.Director;
import com.eurotech.assignment.contracts.AbstractSimpleFilterBuilder;
import com.eurotech.assignment.contracts.IFilter;
import com.eurotech.assignment.factories.FilterFactory;
import com.eurotech.assignment.filters.simple.IsPropertyPresentFilter;

public class CompositeFilterTests {

	@Test
	public void test() {
		
		Map<String, String> user = UserCreator.createUser();

		AbstractSimpleFilterBuilder sBuilder;
		Director director;
		IFilter filterA, filterB, compositeFilter;

		// Testing is property present funcionality
		
		filterA = new FilterFactory().getFilter(IsPropertyPresentFilter.TAG, "firstname");
		assertEquals("Property firstname is present", true, filterA.matches(user));

		filterB = new FilterFactory().getFilter(IsPropertyPresentFilter.TAG, "notpresent");
		assertEquals("Property firstname is present", false, filterB.matches(user));
		
		ArrayList<IFilter> filters = new ArrayList<IFilter>();
		filters.add(filterA);
		filters.add(filterB);
				
		compositeFilter = new FilterFactory().getFilter(filters);
		assertEquals("Both filters are true AND", false, compositeFilter.matches(user));
	}
}
