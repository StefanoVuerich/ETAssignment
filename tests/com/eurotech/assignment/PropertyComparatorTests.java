package com.eurotech.assignment;

import static org.junit.Assert.assertEquals;

import java.util.Map;

import org.junit.Test;

import com.eurotech.assignment.contracts.IFilter;
import com.eurotech.assignment.factories.FilterFactory;
import com.eurotech.assignment.filters.simple.PropertyComparatorFilter;
import com.eurotech.assignment.utils.Comparator;

public class PropertyComparatorTests {

	@Test
	public void test() {

		Map<String, String> user = UserCreator.createUser();
		IFilter filter;

		// Testing String comparator functionality

		filter = new FilterFactory().getFilter(PropertyComparatorFilter.TAG, "role", "administrator",
				Comparator.EQUALS);
		assertEquals("Testing for String equality", true, filter.matches(user));

		user.put("role", "Administrator");
		assertEquals("Testing for String case insensitivity", true, filter.matches(user));

		filter = new FilterFactory().getFilter(PropertyComparatorFilter.TAG, "role", "user", Comparator.EQUALS);
		assertEquals("Testing for non matching values", false, filter.matches(user));

		// Testing int comparator functionality

		filter = new FilterFactory().getFilter(PropertyComparatorFilter.TAG, "age", "35", Comparator.EQUALS);
		assertEquals("age is 35", true, filter.matches(user));

		filter = new FilterFactory().getFilter(PropertyComparatorFilter.TAG, "age", "34", Comparator.MINUS);
		assertEquals("34 is < than 35", true, filter.matches(user));

		filter = new FilterFactory().getFilter(PropertyComparatorFilter.TAG, "age", "36", Comparator.PLUS);
		assertEquals("36 is > than 35", true, filter.matches(user));

		user.put("age", "40");

		filter = new FilterFactory().getFilter(PropertyComparatorFilter.TAG, "age", "35", Comparator.EQUALS);
		assertEquals("age is 40", false, filter.matches(user));

		filter = new FilterFactory().getFilter(PropertyComparatorFilter.TAG, "age", "41", Comparator.MINUS);
		assertEquals("41 is not < than 40", false, filter.matches(user));

		filter = new FilterFactory().getFilter(PropertyComparatorFilter.TAG, "age", "39", Comparator.PLUS);
		assertEquals("39 is not > di 40", false, filter.matches(user));
		
		// This will throw PropertyNotFoundException
		filter = new FilterFactory().getFilter(PropertyComparatorFilter.TAG, "notpresentproperty", "hello");
		filter.matches(user);
	}
}
