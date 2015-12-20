package com.eurotech.assignment.filters;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.eurotech.assignment.contracts.AbstractCompositeFilter;
import com.eurotech.assignment.contracts.AbstractSimpleFilter;

public class CompositeFilter extends AbstractCompositeFilter {

	private List<AbstractSimpleFilter> filters = new ArrayList<AbstractSimpleFilter>();
	private Map<String, String> resource;

	@Override
	public void addFilter(AbstractSimpleFilter filter) {
		
		filters.add(filter);
	}

	@Override
	public boolean matches(Map<String, String> resource) {
		
		// first of all check if the composite filter has more than one filter
		
		this.resource = resource;
		return evaluate(filters.get(0));
	}

	private boolean evaluate(AbstractSimpleFilter filter) {

		boolean result = filter.matches(resource);

		for (int i = 1; i < filters.size(); ++i) {

			filter = filters.get(i);

			switch (filter.getConcatOperator()) {

			case AND:
				result = result && filter.matches(resource);
				break;

			case OR:
				result = result || filter.matches(resource);
				break;

			case NOT:
				result = result && !filter.matches(resource);
				break;
			}
		}
		return result;
	}
}
