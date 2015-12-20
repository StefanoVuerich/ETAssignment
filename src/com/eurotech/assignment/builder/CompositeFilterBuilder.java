package com.eurotech.assignment.builder;

import com.eurotech.assignment.contracts.AbstractCompositeFilter;
import com.eurotech.assignment.contracts.AbstractCompositeFilterBuilder;
import com.eurotech.assignment.contracts.AbstractSimpleFilter;
import com.eurotech.assignment.contracts.IFilter;
import com.eurotech.assignment.filters.composite.CompositeFilter;

public class CompositeFilterBuilder extends AbstractCompositeFilterBuilder{

	private AbstractCompositeFilter cFilter;
	
	public CompositeFilterBuilder() {
		
		cFilter = new CompositeFilter();
	}
	
	@Override
	public AbstractCompositeFilter getFilter() {
		return cFilter;
	}

	@Override
	public void addFilter(IFilter filter) {
		
		if(filter instanceof AbstractSimpleFilter)
			cFilter.addFilter((AbstractSimpleFilter)filter);
	}
}
