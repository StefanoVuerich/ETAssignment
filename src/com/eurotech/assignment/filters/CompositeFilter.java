package com.eurotech.assignment.filters;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.eurotech.assignment.contracts.AbstractCompositeFilter;
import com.eurotech.assignment.contracts.AbstractSimpleFilter;
import com.eurotech.assignment.models.ConcatValue;
import com.eurotech.assignment.utils.Evaluator;

public class CompositeFilter extends AbstractCompositeFilter {

	private List<AbstractSimpleFilter> filters = new ArrayList<AbstractSimpleFilter>();
	private Map<String, String> resource;

	@Override
	public void addFilter(AbstractSimpleFilter filter) {

		filters.add(filter);
	}

	@Override
	public boolean matches(Map<String, String> resource) {

		List<ConcatValue> values = new ArrayList<ConcatValue>();

		int i = 0;

		while (i < filters.size()) {

			AbstractSimpleFilter tmpFilter = filters.get(i);
			values.add(new ConcatValue(tmpFilter.matches(resource), tmpFilter.getConcatOperator()));
			
			++i;
		}
		return Evaluator.eveluate(values);
	}
}
