package com.eurotech.assignment.utils;

import java.util.List;

import com.eurotech.assignment.models.ConcatValue;

public class Evaluator {

	public static boolean eveluate(List<ConcatValue> values) {

		boolean result = false;
		int i = 0;

		while (i < values.size()) {

			ConcatValue currentValue = values.get(i);
			boolean currentResult = currentValue.getResult();
			ConcatOperator currentOperator = currentValue.getConcat();

			if (i == 0) {

				if (currentOperator == ConcatOperator.NOT)
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

				case NOT:
					result = result && !currentResult;
					break;
				}
			}

			++i;
		}

		return result;
	}
}
