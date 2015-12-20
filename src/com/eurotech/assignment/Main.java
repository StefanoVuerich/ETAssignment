package com.eurotech.assignment;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

import com.eurotech.assignment.builder.CompositeFilterBuilder;
import com.eurotech.assignment.builder.Director;
import com.eurotech.assignment.builder.SimpleFilterBuilder;
import com.eurotech.assignment.contracts.AbstractCompositeFilter;
import com.eurotech.assignment.contracts.AbstractCompositeFilterBuilder;
import com.eurotech.assignment.contracts.AbstractSimpleFilter;
import com.eurotech.assignment.contracts.AbstractSimpleFilterBuilder;
import com.eurotech.assignment.contracts.IFilter;
import com.eurotech.assignment.factories.FilterFactory;
import com.eurotech.assignment.filters.simple.IsPropertyPresentFilter;
import com.eurotech.assignment.filters.simple.PropertyComparatorFilter;
import com.eurotech.assignment.filters.simple.RegexFilter;
import com.eurotech.assignment.utils.Comparator;
import com.eurotech.assignment.utils.ConcatOperator;

public class Main {

	public static void main(String[] args) {

		Map<String, String> user = new LinkedHashMap<String, String>();
		user.put("firstname", "Joe");
		user.put("surname", "Bloggs");
		user.put("role", "administrator");
		user.put("age", "35");

		// Testing simple filters
		
		IFilter filterA, filterB, filterC, compositeFilter;
		
		filterA = new FilterFactory()
				.getFilter(IsPropertyPresentFilter.TAG, "firstname", null, null, null);
		assert filterA.matches(user);
		
		filterB = new FilterFactory()
				.getFilter(PropertyComparatorFilter.TAG, "role", "administrator", Comparator.EQUALS, null);
		assert filterB.matches(user);
		
		filterC = new FilterFactory()
				.getFilter(RegexFilter.TAG, "role", "[a-z]+", null, null);
		assert filterC.matches(user);
			
		// Testing composite filter
		
		ArrayList<AbstractSimpleFilter> filters = new ArrayList<AbstractSimpleFilter>();
		filters.add((AbstractSimpleFilter) filterA);
		filters.add((AbstractSimpleFilter) filterB);
		filters.add((AbstractSimpleFilter) filterC);
		
		compositeFilter = new FilterFactory()
					.getFilter(filters);

		assert compositeFilter.matches(user);
		
		System.out.println("Application Exit Code 0");
	}
}
