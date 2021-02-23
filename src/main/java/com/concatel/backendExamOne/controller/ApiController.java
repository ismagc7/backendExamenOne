package com.concatel.backendExamOne.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.concatel.backendExamOne.service.IDataService;

@RestController
@RequestMapping("/api/v1")
public class ApiController {
	
	List <String> list;
	private static final Logger logger = LoggerFactory.getLogger(ApiController.class);
	
	
	@Autowired
	private IDataService dataService;
	
	@GetMapping("/{number}")
	public ResponseEntity<List<String>> inicio(@PathVariable(value="number") int number) throws Throwable {
		
		try 
		{
			list = dataService.complete(number);
			
			return new ResponseEntity<List<String>>(list, HttpStatus.OK);
		}
		catch(Exception e)
		{
			logger.error(""+e);
			e.getMessage();
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}
  
}
