package com.eurotech.assignment;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
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
import com.eurotech.assignment.filters.IsPropertyPresentFilter;
import com.eurotech.assignment.filters.PropertyComparatorFilter;
import com.eurotech.assignment.filters.RegexFilter;
import com.eurotech.assignment.models.ConcatValue;
import com.eurotech.assignment.utils.Comparator;
import com.eurotech.assignment.utils.ConcatOperator;
import com.eurotech.assignment.utils.Evaluator;

public class Main {

	public static void main(String[] args) {

		Map<String, String> user = new LinkedHashMap<String, String>();
		user.put("firstname", "Joe");
		user.put("surname", "Bloggs");
		user.put("role", "administrator");
		user.put("age", "35");

		// Testing simple filters
		
		AbstractSimpleFilterBuilder sBuilder;
		Director director;
		AbstractSimpleFilter filterA, filterB, filterC;
		
		sBuilder = new SimpleFilterBuilder(IsPropertyPresentFilter.TAG);
		director = new Director(sBuilder);
		director.makeSimpleFilter("firstname", null, null, null);
		filterA = director.getSimpleFilter();
		assert filterA.matches(user);
		
		IFilter filter = new FilterFactory()
				.getFilter(IsPropertyPresentFilter.TAG, "firstname", null, null, null);
		assert filter.matches(user);
		
		sBuilder = new SimpleFilterBuilder(PropertyComparatorFilter.TAG);
		director = new Director(sBuilder);
		director.makeSimpleFilter("role", "administrator", Comparator.EQUALS, null);
		filterB = director.getSimpleFilter();
		assert filterB.matches(user);
		
		sBuilder = new SimpleFilterBuilder(RegexFilter.TAG);
		director = new Director(sBuilder);
		director.makeSimpleFilter("role", "[a-z]+", null, null);
		filterC = director.getSimpleFilter();
		assert filterC.matches(user);
		
		// Testing composite filter
		
		ArrayList<AbstractSimpleFilter> filters = new ArrayList<AbstractSimpleFilter>();
		filters.add(filterA);
		filters.add(filterB);
		filters.add(filterC);
				
		AbstractCompositeFilterBuilder cBuilder = new CompositeFilterBuilder();
		director = new Director(cBuilder);
		director.makeCompositeFilter(filters);
		AbstractCompositeFilter cFilter = director.getCompositeFilter();
		assert cFilter.matches(user);
		
		System.out.println("END APP");
	}
}
