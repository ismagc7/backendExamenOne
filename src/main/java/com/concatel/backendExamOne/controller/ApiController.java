package com.concatel.backendExamOne.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.concatel.backendExamOne.service.IDataService;

@RestController
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST})
@RequestMapping("/api/v1")
public class ApiController {
	
	private static final Logger logger = LoggerFactory.getLogger(ApiController.class);
	
	@Autowired
	private IDataService dataService;
	
	@GetMapping("/{number}")
	public ResponseEntity<?> init(@PathVariable(value="number") int number) throws Throwable {
		
		logger.info("Ha llegado al path /api/v1/"+number);
		logger.debug("Number"+number);
		
		try 
		{
			List <String> list = dataService.complete(number);
			logger.debug("List"+list);
			return new ResponseEntity<>(list, HttpStatus.OK);
		}
		catch(Exception e)
		{
			logger.error(""+e);
			return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
		}
	}
}
