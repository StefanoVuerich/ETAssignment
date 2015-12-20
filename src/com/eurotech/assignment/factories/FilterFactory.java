package com.eurotech.assignment.factories;

import java.util.List;

import com.eurotech.assignment.builder.CompositeFilterBuilder;
import com.eurotech.assignment.builder.Director;
import com.eurotech.assignment.builder.SimpleFilterBuilder;
import com.eurotech.assignment.contracts.AbstractCompositeFilterBuilder;
import com.eurotech.assignment.contracts.AbstractSimpleFilterBuilder;
import com.eurotech.assignment.contracts.IFilter;
import com.eurotech.assignment.contracts.IFilterFactory;
import com.eurotech.assignment.utils.Comparator;
import com.eurotech.assignment.utils.ConcatOperator;

public class FilterFactory implements IFilterFactory {

	private Director director;

	@Override
	public IFilter getFilter(String filtername, String property) {
		
		return construct(filtername, property, null, null, null);
	}

	@Override
	public IFilter getFilter(String filtername, String property, String value) {
		
		return construct(filtername, property, value, null, null);
	}
	
	@Override
	public IFilter getFilter(String filtername, String property, String value, Comparator comparator) {
		return construct(filtername, property, value, comparator, null);
	}

	@Override
	public IFilter getFilter(String filtername, String property, String value, Comparator comparator,
			ConcatOperator concatOperator) {
		
		return construct(filtername, property, value, comparator, concatOperator);
	}
	
	
	@Override
	public IFilter getFilter(List<IFilter> filters) {
		
		if(filters == null)
			return null;
		
		AbstractCompositeFilterBuilder cBuilder = new CompositeFilterBuilder();
		director = new Director(cBuilder);
		director.makeCompositeFilter(filters);
		return director.getCompositeFilter();
	}

	private IFilter construct(String filtername, String property, String value, Comparator comparator,
			ConcatOperator concatOperator) {

		AbstractSimpleFilterBuilder sBuilder = new SimpleFilterBuilder(filtername);
		director = new Director(sBuilder);
		director.makeSimpleFilter(property, value, comparator, concatOperator);
		return director.getSimpleFilter();
	}
}
