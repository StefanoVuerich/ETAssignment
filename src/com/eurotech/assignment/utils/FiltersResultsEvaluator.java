package com.eurotech.assignment.utils;

import java.util.List;

import com.eurotech.assignment.models.ConcatenatedResult;

public class FiltersResultsEvaluator {

	public static boolean eveluate(List<ConcatenatedResult> values) {

		/*
		 * Evaluate the total result of the concatenation of the results
		 * stored in values. Concatenation is ruled by the concatenation operator
		 * stored in each ConcatValue class.
		 * This class is fully tested and high testable
		 */
		
		boolean result = false;
		int i = 0;

		while (i < values.size()) {

			ConcatenatedResult currentValue = values.get(i);
			boolean currentResult = currentValue.getResult();
			ConcatOperator currentOperator = currentValue.getConcat();

			if (i == 0) {

				if (currentOperator == ConcatOperator.AND_NOT)
					result = !currentResult;
				else
					result = currentResult;

			} else {

				switch (currentOperator) {

				case AND:
					result = result && currentResult;
					break;

				case OR:
					result = result || currentResult;
					break;

				case AND_NOT:
					result = result && !currentResult;
					break;
				}
			}

			++i;
		}

		return result;
	}
}
