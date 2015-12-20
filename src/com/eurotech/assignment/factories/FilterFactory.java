package com.eurotech.assignment.factories;

import com.eurotech.assignment.builder.Director;
import com.eurotech.assignment.builder.SimpleFilterBuilder;
import com.eurotech.assignment.contracts.AbstractSimpleFilterBuilder;
import com.eurotech.assignment.contracts.IFilter;
import com.eurotech.assignment.contracts.IFilterFactory;
import com.eurotech.assignment.utils.Comparator;
import com.eurotech.assignment.utils.ConcatOperator;

public class FilterFactory implements IFilterFactory{

	@Override
	public IFilter getFilter(String filtername, String property, String value, Comparator comparator,
			ConcatOperator concatOperator) {
		
		AbstractSimpleFilterBuilder sBuilder = new SimpleFilterBuilder(filtername);
		Director director = new Director(sBuilder);
		director.makeSimpleFilter(property, value, comparator, concatOperator);
		return director.getSimpleFilter();
	}

}
