package com.eurotech.assignment;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Map;

import org.junit.Test;

import com.eurotech.assignment.builder.Director;
import com.eurotech.assignment.contracts.AbstractSimpleFilter;
import com.eurotech.assignment.contracts.AbstractSimpleFilterBuilder;
import com.eurotech.assignment.contracts.IFilter;
import com.eurotech.assignment.factories.FilterFactory;
import com.eurotech.assignment.filters.simple.IsPropertyPresentFilter;
import com.eurotech.assignment.utils.ConcatOperator;

public class CompositeFilterTests {

	@Test
	public void test() {

		Map<String, String> user = UserCreator.createUser();

		IFilter filterA, filterB, filterC, compositeFilter;
		ArrayList<IFilter> filters = new ArrayList<IFilter>();

		// Testing is property present funcionality

		filterA = new FilterFactory().getFilter(IsPropertyPresentFilter.TAG, "firstname");
		assertEquals("Property firstname is present", true, filterA.matches(user));

		filterB = new FilterFactory().getFilter(IsPropertyPresentFilter.TAG, "notpresent", null, null,
				ConcatOperator.AND);
		assertEquals("Property notpresent is present", false, filterB.matches(user));
		
		filterC = new FilterFactory().getFilter(IsPropertyPresentFilter.TAG, "firstname", null, null,
				ConcatOperator.OR);
		assertEquals("Property lalla is present", true, filterC.matches(user));

		filters.add(filterA);
		filters.add(filterB);
		filters.add(filterC);

		compositeFilter = new FilterFactory().getFilter(filters);
		assertEquals("true && false || true", true, compositeFilter.matches(user));
		filters.clear();

		// changes

		filterB = new FilterFactory().getFilter(IsPropertyPresentFilter.TAG, "notpresent", null, null,
				ConcatOperator.OR);
		filters.add(filterA);
		filters.add(filterB);

		compositeFilter = new FilterFactory().getFilter(filters);
		assertEquals("Property firstname is present or property notpresent is present", true,
				compositeFilter.matches(user));
		filters.clear();

		// changes

		filterB = new FilterFactory().getFilter(IsPropertyPresentFilter.TAG, "notpresent", null, null,
				ConcatOperator.AND_NOT);
		filters.add(filterA);
		filters.add(filterB);

		compositeFilter = new FilterFactory().getFilter(filters);
		assertEquals("Property firstname is present and property notpresent is not present", true,
				compositeFilter.matches(user));
	}
}
