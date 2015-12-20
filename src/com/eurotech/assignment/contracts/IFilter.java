package com.eurotech.assignment.contracts;

import java.util.Map;

public interface IFilter {

	boolean matches(Map<String,String> resource);
}
