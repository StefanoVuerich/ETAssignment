package com.eurotech.assignment.filters.composite;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.eurotech.assignment.contracts.AbstractCompositeFilter;
import com.eurotech.assignment.contracts.AbstractSimpleFilter;
import com.eurotech.assignment.models.ConcatenatedResult;
import com.eurotech.assignment.utils.FiltersResultsEvaluator;

public class CompositeFilter extends AbstractCompositeFilter {

	private List<AbstractSimpleFilter> filters = new ArrayList<AbstractSimpleFilter>();

	@Override
	public void addFilter(AbstractSimpleFilter filter) {

		filters.add(filter);
	}

	@Override
	public boolean matches(Map<String, String> resource) {

		/*
		 * Evaluate filters result and store them in the ArrayList
		 * ConcatenatedResult class is made by the result of the filter
		 * evaluation and the concatenation operator, used the concatenate
		 * results using AND, OR, AND NOT
		 */

		List<ConcatenatedResult> values = new ArrayList<ConcatenatedResult>();

		int i = 0;

		while (i < filters.size()) {

			AbstractSimpleFilter tmpFilter = filters.get(i);
			values.add(new ConcatenatedResult(tmpFilter.matches(resource), tmpFilter.getConcatOperator()));

			++i;
		}
		
		return FiltersResultsEvaluator.eveluate(values);
	}
}
