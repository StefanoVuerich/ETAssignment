package com.eurotech.assignment.contracts;

import com.eurotech.assignment.utils.Comparator;
import com.eurotech.assignment.utils.ConcatOperator;

public interface IFilterFactory {

	IFilter getFilter(String filtername, String property, String value, 
						Comparator comparator, ConcatOperator concatOperator);
}
