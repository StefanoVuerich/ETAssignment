package com.eurotech.assignment;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.eurotech.assignment.models.ConcatenatedResult;
import com.eurotech.assignment.models.ConcatenatedResult;
import com.eurotech.assignment.utils.ConcatOperator;
import com.eurotech.assignment.utils.FiltersResultsEvaluator;

public class EvaluatorTests {

	@Test
	public void test() {
		
		List<ConcatenatedResult> list = new ArrayList<ConcatenatedResult>();
		
		// A=0 && B=0 r=0
		list.add(new ConcatenatedResult(false, null));
		list.add(new ConcatenatedResult(false, ConcatOperator.AND));
		assertEquals("False", false, FiltersResultsEvaluator.eveluate(list));
		list.clear();
		
		// A=1 && B=1 r=1
		list.add(new ConcatenatedResult(true, null));
		list.add(new ConcatenatedResult(true, ConcatOperator.AND));
		assertEquals("True", true, FiltersResultsEvaluator.eveluate(list));
		list.clear();
		
		// A=0 && B=1 r=0
		list.add(new ConcatenatedResult(false, null));
		list.add(new ConcatenatedResult(true, ConcatOperator.AND));
		assertEquals("False", false, FiltersResultsEvaluator.eveluate(list));
		list.clear();
		
		// A=1 && B=0 r=0
		list.add(new ConcatenatedResult(true, null));
		list.add(new ConcatenatedResult(false, ConcatOperator.AND));
		assertEquals("False", false, FiltersResultsEvaluator.eveluate(list));
		list.clear();
		
		// A=0 || B=0 r=0
		list.add(new ConcatenatedResult(false, null));
		list.add(new ConcatenatedResult(false, ConcatOperator.OR));
		assertEquals("False", false, FiltersResultsEvaluator.eveluate(list));
		list.clear();
		
		// A=1 || B=1 r=1
		list.add(new ConcatenatedResult(true, null));
		list.add(new ConcatenatedResult(true, ConcatOperator.OR));
		assertEquals("True", true, FiltersResultsEvaluator.eveluate(list));
		list.clear();
		
		// A=1 || B=0 r=1
		list.add(new ConcatenatedResult(true, null));
		list.add(new ConcatenatedResult(false, ConcatOperator.OR));
		assertEquals("True", true, FiltersResultsEvaluator.eveluate(list));
		list.clear();
		
		// A=0 || B=1 r=1
		list.add(new ConcatenatedResult(false, null));
		list.add(new ConcatenatedResult(true, ConcatOperator.OR));
		assertEquals("True", true, FiltersResultsEvaluator.eveluate(list));
		list.clear();
		
		// A=0 && !B=0(1) r=0
		list.add(new ConcatenatedResult(false, null));
		list.add(new ConcatenatedResult(false, ConcatOperator.AND_NOT));
		assertEquals("False", false, FiltersResultsEvaluator.eveluate(list));
		list.clear();
		
		// A=1 && !B=1(0) r=0
		list.add(new ConcatenatedResult(true, null));
		list.add(new ConcatenatedResult(true, ConcatOperator.AND_NOT));
		assertEquals("False", false, FiltersResultsEvaluator.eveluate(list));
		list.clear();
		
		// A=0 && !B=1(0) r=0
		list.add(new ConcatenatedResult(false, null));
		list.add(new ConcatenatedResult(true, ConcatOperator.AND_NOT));
		assertEquals("False", false, FiltersResultsEvaluator.eveluate(list));
		list.clear();
		
		// A=1 && !B=0(1) r=1
		list.add(new ConcatenatedResult(true, null));
		list.add(new ConcatenatedResult(false, ConcatOperator.AND_NOT));
		assertEquals("True", true, FiltersResultsEvaluator.eveluate(list));
		list.clear();
	}

}
