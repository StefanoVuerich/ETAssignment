package com.eurotech.assignment.builder;

import java.util.List;

import com.eurotech.assignment.contracts.AbstractCompositeFilter;
import com.eurotech.assignment.contracts.AbstractCompositeFilterBuilder;
import com.eurotech.assignment.contracts.AbstractSimpleFilter;
import com.eurotech.assignment.contracts.AbstractSimpleFilterBuilder;
import com.eurotech.assignment.utils.Comparator;
import com.eurotech.assignment.utils.ConcatOperator;

public class Director {

	private AbstractSimpleFilterBuilder sBuilder;
	private AbstractCompositeFilterBuilder cBuilder;
	
	public Director(AbstractSimpleFilterBuilder builder) {
		
		sBuilder = builder;
	}
	
	public Director(AbstractCompositeFilterBuilder builder) {
		
		cBuilder = builder;
	}
	
	public AbstractSimpleFilter getSimpleFilter() {
		
		return (AbstractSimpleFilter) sBuilder.getFilter();
	}
	
	public AbstractCompositeFilter getCompositeFilter() {
		
		return (AbstractCompositeFilter) cBuilder.getFilter();
	}
	
	public void makeSimpleFilter(String property, String value, 
							Comparator comparator, ConcatOperator operator) {
		
		sBuilder.setProperty(property);
		sBuilder.setValue(value);
		sBuilder.setComparator(comparator);
		sBuilder.setConcatOperator(operator);
	}
	
	public void makeCompositeFilter(List<AbstractSimpleFilter> sFilters){
		
		for(AbstractSimpleFilter sFilter : sFilters)
			cBuilder.addFilter(sFilter);			
	}
}
