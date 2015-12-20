package com.eurotech.assignment.filters.simple;

import java.util.Map;

import com.eurotech.assignment.contracts.AbstractSimpleFilter;
import com.eurotech.assignment.utils.Comparator;
import com.eurotech.assignment.utils.ConcatOperator;

public class IsPropertyPresentFilter extends AbstractSimpleFilter{

	public static final String TAG = IsPropertyPresentFilter.class.getSimpleName();
	
	@Override
	public void setProperty(String property) {
		if(property != null)
			this.property = property;
	}

	@Override
	public void setValue(String value) {}
	
	@Override
	public boolean matches(Map<String, String> resource) {
		return resource.containsKey(property);
	}

	@Override
	public void setComparator(Comparator comparator) {}
	
	@Override
	public void setConcatOperator(ConcatOperator operator) {
		if(operator != null)
			concatOperator = operator;
	}

	@Override
	public ConcatOperator getConcatOperator() {
		return concatOperator;
	}
}
