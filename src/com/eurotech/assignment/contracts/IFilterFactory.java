package com.eurotech.assignment.contracts;

import java.util.List;

import com.eurotech.assignment.utils.Comparator;
import com.eurotech.assignment.utils.ConcatOperator;

public interface IFilterFactory {

	IFilter getFilter(String filtername, String property, String value, 
						Comparator comparator, ConcatOperator concatOperator);
	
	IFilter getFilter(List<AbstractSimpleFilter> filters);
}
