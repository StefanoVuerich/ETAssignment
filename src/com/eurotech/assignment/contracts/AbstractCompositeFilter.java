package com.eurotech.assignment.contracts;

public abstract class AbstractCompositeFilter implements IFilter{

	public abstract void addFilter(AbstractSimpleFilter filter);
}
