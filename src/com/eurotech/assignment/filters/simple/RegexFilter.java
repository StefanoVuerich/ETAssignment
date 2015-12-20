package com.eurotech.assignment.filters.simple;

import java.util.Map;

import com.eurotech.assignment.contracts.AbstractSimpleFilter;
import com.eurotech.assignment.customexceptions.PropertyNotFoundException;
import com.eurotech.assignment.utils.Comparator;
import com.eurotech.assignment.utils.ConcatOperator;
import com.eurotech.assignment.utils.IsPropertyPresentTester;

public class RegexFilter extends AbstractSimpleFilter{

	public static final String TAG = RegexFilter.class.getSimpleName();
	
	@Override
	public void setProperty(String property) {
		if(property != null)
			this.property = property;
	}

	@Override
	public void setValue(String value) {
		if(value != null)
			regex = value;
	}

	@Override
	public void setComparator(Comparator comparator) {}
	
	@Override
	public ConcatOperator getConcatOperator() {
		return concatOperator;
	}

	@Override
	public void setConcatOperator(ConcatOperator operator) {
		if(operator != null)
			concatOperator = operator;
	}

	@Override
	public boolean matches(Map<String, String> resource) {
		
		boolean result = false;
		
		try{
			
			IsPropertyPresentTester.test(resource, property);
			result = resource.get(property).matches(regex);
			
		} catch(PropertyNotFoundException ex) {
			
			System.out.println(ex.getMessage());
		}
		
		return result;
	}
}
