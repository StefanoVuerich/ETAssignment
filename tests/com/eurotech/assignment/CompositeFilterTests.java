package com.eurotech.assignment;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Map;

import org.junit.Test;

import com.eurotech.assignment.builder.CompositeFilterBuilder;
import com.eurotech.assignment.builder.Director;
import com.eurotech.assignment.builder.SimpleFilterBuilder;
import com.eurotech.assignment.contracts.AbstractCompositeFilter;
import com.eurotech.assignment.contracts.AbstractCompositeFilterBuilder;
import com.eurotech.assignment.contracts.AbstractSimpleFilter;
import com.eurotech.assignment.contracts.AbstractSimpleFilterBuilder;
import com.eurotech.assignment.filters.IsPropertyPresentFilter;
import com.eurotech.assignment.utils.ConcatOperator;

public class CompositeFilterTests {

	@Test
	public void test() {
		
		Map<String, String> user = UserCreator.createUser();

		AbstractSimpleFilterBuilder sBuilder;
		Director director;
		AbstractSimpleFilter filterATrue, filterBTrue;

		// Testing is property present funcionality

		sBuilder = new SimpleFilterBuilder(IsPropertyPresentFilter.TAG);
		director = new Director(sBuilder);
		
		director.makeSimpleFilter("firstname", null, null, null);
		filterATrue = director.getSimpleFilter();
		assertEquals("Property firstname is present", true, filterATrue.matches(user));

		director.makeSimpleFilter("halla", null, null, ConcatOperator.AND);
		filterBTrue = director.getSimpleFilter();
		assertEquals("Property firstname is present", false, filterBTrue.matches(user));
		
		ArrayList<AbstractSimpleFilter> filters = new ArrayList<AbstractSimpleFilter>();
		filters.add(filterATrue);
		filters.add(filterBTrue);
				
		AbstractCompositeFilterBuilder cBuilder = new CompositeFilterBuilder();
		director = new Director(cBuilder);
		director.makeCompositeFilter(filters);
		AbstractCompositeFilter cFilter = director.getCompositeFilter();
		assertEquals("Both filters are true AND", false, cFilter.matches(user));
		
		System.out.println("END APP");
	}

}
