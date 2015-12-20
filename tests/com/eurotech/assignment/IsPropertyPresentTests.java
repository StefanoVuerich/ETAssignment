package com.eurotech.assignment;

import static org.junit.Assert.assertEquals;

import java.util.Map;

import org.junit.Test;

import com.eurotech.assignment.contracts.IFilter;
import com.eurotech.assignment.factories.FilterFactory;
import com.eurotech.assignment.filters.simple.IsPropertyPresentFilter;

public class IsPropertyPresentTests {

	@Test
	public void test() {

		Map<String, String> user = UserCreator.createUser();
		IFilter filter;

		// Testing is property present funcionality

		filter = new FilterFactory().getFilter(IsPropertyPresentFilter.TAG, "firstname");
		assertEquals("Property firstname is present", true, filter.matches(user));

		user.remove("firstname");
		assertEquals("Property firstname is not more present", false, filter.matches(user));

		filter = new FilterFactory().getFilter(IsPropertyPresentFilter.TAG, "Surname");
		assertEquals("Test for case sensitivity", false, filter.matches(user));
	}
}
