package com.eurotech.assignment.contracts;

import com.eurotech.assignment.utils.Comparator;
import com.eurotech.assignment.utils.ConcatOperator;

public abstract class AbstractSimpleFilterBuilder implements IFilterBuilder{

	public abstract void setProperty(String property);
	
	public abstract void setValue(String value);
	
	public abstract void setComparator(Comparator comparator);
	
	public abstract void setConcatOperator(ConcatOperator concatOperator);
}
