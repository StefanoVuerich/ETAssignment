package com.eurotech.assignment;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.eurotech.assignment.models.ConcatValue;
import com.eurotech.assignment.utils.ConcatOperator;
import com.eurotech.assignment.utils.Evaluator;

public class EvaluatorTests {

	@Test
	public void test() {
		
		List<ConcatValue> list = new ArrayList<ConcatValue>();
		
		// A=0 && B=0 r=0
		list.add(new ConcatValue(false, null));
		list.add(new ConcatValue(false, ConcatOperator.AND));
		assertEquals("False", false, Evaluator.eveluate(list));
		list.clear();
		
		// A=1 && B=1 r=1
		list.add(new ConcatValue(true, null));
		list.add(new ConcatValue(true, ConcatOperator.AND));
		assertEquals("True", true, Evaluator.eveluate(list));
		list.clear();
		
		// A=0 && B=1 r=0
		list.add(new ConcatValue(false, null));
		list.add(new ConcatValue(true, ConcatOperator.AND));
		assertEquals("False", false, Evaluator.eveluate(list));
		list.clear();
		
		// A=1 && B=0 r=0
		list.add(new ConcatValue(true, null));
		list.add(new ConcatValue(false, ConcatOperator.AND));
		assertEquals("False", false, Evaluator.eveluate(list));
		list.clear();
		
		// A=0 || B=0 r=0
		list.add(new ConcatValue(false, null));
		list.add(new ConcatValue(false, ConcatOperator.OR));
		assertEquals("False", false, Evaluator.eveluate(list));
		list.clear();
		
		// A=1 || B=1 r=1
		list.add(new ConcatValue(true, null));
		list.add(new ConcatValue(true, ConcatOperator.OR));
		assertEquals("True", true, Evaluator.eveluate(list));
		list.clear();
		
		// A=1 || B=0 r=1
		list.add(new ConcatValue(true, null));
		list.add(new ConcatValue(false, ConcatOperator.OR));
		assertEquals("True", true, Evaluator.eveluate(list));
		list.clear();
		
		// A=0 || B=1 r=1
		list.add(new ConcatValue(false, null));
		list.add(new ConcatValue(true, ConcatOperator.OR));
		assertEquals("True", true, Evaluator.eveluate(list));
		list.clear();
		
		// A=0 && !B=0(1) r=0
		list.add(new ConcatValue(false, null));
		list.add(new ConcatValue(false, ConcatOperator.NOT));
		assertEquals("False", false, Evaluator.eveluate(list));
		list.clear();
		
		// A=1 && !B=1(0) r=0
		list.add(new ConcatValue(true, null));
		list.add(new ConcatValue(true, ConcatOperator.NOT));
		assertEquals("False", false, Evaluator.eveluate(list));
		list.clear();
		
		// A=0 && !B=1(0) r=0
		list.add(new ConcatValue(false, null));
		list.add(new ConcatValue(true, ConcatOperator.NOT));
		assertEquals("False", false, Evaluator.eveluate(list));
		list.clear();
		
		// A=1 && !B=0(1) r=1
		list.add(new ConcatValue(true, null));
		list.add(new ConcatValue(false, ConcatOperator.NOT));
		assertEquals("True", true, Evaluator.eveluate(list));
		list.clear();
	}

}
