package com.eurotech.assignment.contracts;

public abstract class AbstractCompositeFilterBuilder implements IFilterBuilder{

	public abstract void addFilter(AbstractSimpleFilter filter);
}
