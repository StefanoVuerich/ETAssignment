package com.eurotech.assignment.filters.simple;

import java.util.Map;

import com.eurotech.assignment.contracts.AbstractSimpleFilter;
import com.eurotech.assignment.customexceptions.PropertyNotFoundException;
import com.eurotech.assignment.utils.Comparator;
import com.eurotech.assignment.utils.ConcatOperator;
import com.eurotech.assignment.utils.IsPropertyPresentTester;

public class PropertyComparatorFilter extends AbstractSimpleFilter {

	public static final String TAG = PropertyComparatorFilter.class.getSimpleName();

	@Override
	public void setProperty(String property) {
		if (property != null)
			this.property = property;
	}

	@Override
	public void setValue(String value) {
		if (value != null)
			this.value = value;
	}

	@Override
	public void setComparator(Comparator comparator) {
		if (comparator != null)
			this.comparator = comparator;
	}

	@Override
	public void setConcatOperator(ConcatOperator operator) {
		if (operator != null)
			concatOperator = operator;
	}

	@Override
	public boolean matches(Map<String, String> resource) {

		boolean result = false;

		try {

			IsPropertyPresentTester.test(resource, property);

			int inValue = -1, propertyValue = -1;
			boolean isNumber = true;

			// Try parse input parameters to int
			try {
				inValue = Integer.parseInt(resource.get(property));
				propertyValue = Integer.parseInt(value);
			} catch (NumberFormatException ex) {
				isNumber = false;
			}

			switch (super.comparator) {

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

		} catch (PropertyNotFoundException ex) {

			System.out.println(ex.getMessage());
		}
		return result;
	}

	@Override
	public ConcatOperator getConcatOperator() {
		return concatOperator;
	}
}
