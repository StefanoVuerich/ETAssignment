package com.eurotech.assignment.models;

import com.eurotech.assignment.utils.ConcatOperator;

public class ConcatValue {

	private boolean result;
	private ConcatOperator concat;
	
	public ConcatValue(boolean result, ConcatOperator concat) {
		this.result = result;
		this.concat = concat;
	}

	public boolean getResult() {
		return result;
	}

	public ConcatOperator getConcat() {
		return concat;
	};
	
	
}
