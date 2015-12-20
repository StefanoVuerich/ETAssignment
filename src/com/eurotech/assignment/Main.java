package com.eurotech.assignment;

import java.util.ArrayList;
import java.util.Map;

import com.eurotech.assignment.contracts.IFilter;
import com.eurotech.assignment.factories.FilterFactory;
import com.eurotech.assignment.filters.simple.IsPropertyPresentFilter;
import com.eurotech.assignment.filters.simple.PropertyComparatorFilter;
import com.eurotech.assignment.filters.simple.RegexFilter;
import com.eurotech.assignment.utils.Comparator;

public class Main {

	public static void main(String[] args) {

		Map<String, String> user = UserCreator.createUser();
		IFilter filterA, filterB, filterC, compositeFilter;

		// Testing simple filters
		
		filterA = new FilterFactory()
				.getFilter(IsPropertyPresentFilter.TAG, "firstname");
		assert filterA.matches(user);
		
		filterB = new FilterFactory()
				.getFilter(PropertyComparatorFilter.TAG, "role", "administrator", Comparator.EQUALS);
		assert filterB.matches(user);
		
		filterC = new FilterFactory()
				.getFilter(RegexFilter.TAG, "role", "[a-z]+");
		assert filterC.matches(user);
			
		// Testing composite filter
		
		ArrayList<IFilter> filters = new ArrayList<IFilter>();
		filters.add(filterA);
		filters.add(filterB);
		filters.add(filterC);
		
		compositeFilter = new FilterFactory()
					.getFilter(filters);
		assert compositeFilter.matches(user);
		
		System.out.println("Application Exit Code 0");
	}
}
