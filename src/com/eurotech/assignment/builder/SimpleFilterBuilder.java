package com.eurotech.assignment.builder;

import com.eurotech.assignment.contracts.AbstractSimpleFilter;
import com.eurotech.assignment.contracts.AbstractSimpleFilterBuilder;
import com.eurotech.assignment.filters.IsPropertyPresentFilter;
import com.eurotech.assignment.filters.PropertyComparatorFilter;
import com.eurotech.assignment.filters.RegexFilter;
import com.eurotech.assignment.utils.Comparator;
import com.eurotech.assignment.utils.ConcatOperator;

public class SimpleFilterBuilder extends AbstractSimpleFilterBuilder {

	private AbstractSimpleFilter filter;

	public SimpleFilterBuilder(String filterName) {

		if(filterName.equals(IsPropertyPresentFilter.TAG))
			filter = new IsPropertyPresentFilter();
		
		else if(filterName.equals(PropertyComparatorFilter.TAG))
			filter = new PropertyComparatorFilter();
		
		else if(filterName.equals(RegexFilter.TAG))
			filter = new RegexFilter();
	}

	@Override
	public AbstractSimpleFilter getFilter() {
		return filter;
	}

	@Override
	public void setProperty(String property) {
		filter.setProperty(property);
	}

	@Override
	public void setValue(String value) {
		filter.setValue(value);
	}

	@Override
	public void setComparator(Comparator comparator) {
		filter.setComparator(comparator);
	}

	@Override
	public void setConcatOperator(ConcatOperator concatOperator) {
		filter.setConcatOperator(concatOperator);
	}
}
