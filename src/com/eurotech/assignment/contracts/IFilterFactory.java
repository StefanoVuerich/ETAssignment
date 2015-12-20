package com.eurotech.assignment.contracts;

import java.util.List;

import com.eurotech.assignment.utils.Comparator;
import com.eurotech.assignment.utils.ConcatOperator;

public interface IFilterFactory {

	/*
	 * IsPropertyPresentFilter Constructor
	 */
	IFilter getFilter(String filtername, String property);

	/*
	 * RegexFilter Constructor
	 */
	IFilter getFilter(String filtername, String property, String value);

	/*
	 * PropertyComparatorFilter Constructor
	 */
	IFilter getFilter(String filtername, String property, String value, Comparator comparator);

	/*
	 * Filter constructor to be used for construct simple filters than can be
	 * then used in a composite filter
	 * 
	 * @param concatOperator = operator for the concatenation, can be
	 * ConcatOperator.AND, ConcatOperator.OR, ConcatOperator.AND_NOT
	 * 
	 */
	IFilter getFilter(String filtername, String property, String value, Comparator comparator,
			ConcatOperator concatOperator);
	
	/*
	 * Used to create composite filters
	 * @param filters = list of filters to be inserted in the complex filter
	 */
	IFilter getFilter(List<IFilter> filters);
}
