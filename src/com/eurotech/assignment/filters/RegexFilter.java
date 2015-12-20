package com.eurotech.assignment.filters;

import java.util.Map;

import com.eurotech.assignment.contracts.AbstractSimpleFilter;
import com.eurotech.assignment.utils.Comparator;
import com.eurotech.assignment.utils.ConcatOperator;

public class RegexFilter extends AbstractSimpleFilter{

	public static final String TAG = RegexFilter.class.getSimpleName();
	
	private String property;
	private String regex;
	
	@Override
	public void setProperty(String property) {
		this.property = property;
	}

	@Override
	public void setValue(String value) {
		this.regex = value;
	}

	@Override
	public void setComparator(Comparator comparator) {}
	
	@Override
	public ConcatOperator getConcatOperator() {
		return super.concatOperator;
	}

	@Override
	public void setConcatOperator(ConcatOperator operator) {
		if(operator != null)
			super.concatOperator = operator;
	}

	@Override
	public boolean matches(Map<String, String> resource) {
		if(resource.containsKey(property))
			return resource.get(property).matches(regex);
		else
			return false;
	}
}
