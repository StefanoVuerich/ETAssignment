package com.eurotech.assignment.models;

import com.eurotech.assignment.utils.ConcatOperator;

public class ConcatenatedResult {

	private boolean result;
	private ConcatOperator concat;
	
	public ConcatenatedResult(boolean result, ConcatOperator concat) {
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
