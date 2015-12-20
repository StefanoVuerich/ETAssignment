package com.eurotech.assignment.filters.simple;

import java.util.Map;

import com.eurotech.assignment.contracts.AbstractSimpleFilter;
import com.eurotech.assignment.utils.Comparator;
import com.eurotech.assignment.utils.ConcatOperator;

public class PropertyComparatorFilter extends AbstractSimpleFilter {

	public static final String TAG = PropertyComparatorFilter.class.getSimpleName();

	private String property;
	private String value;
	private Comparator comparator;

	@Override
	public void setProperty(String property) {
		this.property = property;
	}

	@Override
	public void setValue(String value) {
		this.value = value;
	}

	@Override
	public void setComparator(Comparator comparator) {
		this.comparator = comparator;
	}

	@Override
	public void setConcatOperator(ConcatOperator operator) {
		if(operator != null)
			super.concatOperator = operator;
	}

	@Override
	public boolean matches(Map<String, String> resource) {

		if (resource.containsKey(property)) {

			boolean result = false;
			int inValue = -1, propertyValue = -1;
			boolean isNumber = true;

			// Try parse input parameters to int
			try {
				inValue = Integer.parseInt(resource.get(property));
				propertyValue = Integer.parseInt(value);
			} catch (NumberFormatException ex) {
				isNumber = false;
			}

			switch (comparator) {

			case PLUS:
				if (isNumber && inValue >= 0 && propertyValue >= 0)
					result = propertyValue > inValue;
				break;

			case MINUS:
				if (isNumber && inValue >= 0 && propertyValue >= 0)
					result = propertyValue < inValue;
				;
				break;

			case EQUALS:
				if (isNumber && inValue >= 0 && propertyValue >= 0)
					result = propertyValue == inValue;
				else {
					String first = resource.get(property);
					String second = value;
					result = first.toLowerCase().equals(second.toLowerCase());
				}
				break;
			}
			return result;
		} else
			return false;
	}

	@Override
	public ConcatOperator getConcatOperator() {
		return super.concatOperator;
	}
}
