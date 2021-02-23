package com.concatel.backendExamOne.service;

import java.util.List;

public interface IDataService {
	
	/**
	 * @param max as a number of elements
	 * @returns a complete and transformed list of Strings
	 * 
	 */
	public List <String> complete(int max) throws Throwable;
	
}
