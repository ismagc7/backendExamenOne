package com.concatel.backendExamOne.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.concatel.backendExamOne.ValidateNumberException;
import com.concatel.backendExamOne.enums.FizzBuzz;

@Service
public class DataServiceImpl implements IDataService{
	
	private static final Logger logger = LoggerFactory.getLogger(DataServiceImpl.class);
	

   @Override
	public List<String> complete(int max) throws Throwable { 
		
		try {
			logger.info("Inside of complete(int max) on max : "+max);
			logger.debug("Number: "+max);
			
			List <String> fizzOrBuzz = new ArrayList<String>();
			
			fizzOrBuzz.add("0");
			
			logger.debug("List values: "+fizzOrBuzz);
			integerValidator(max);
			
			for (int cont=1; cont<=max; cont++)
			{
				if( cont%15 == 0 )
				{
					fizzOrBuzz.add(FizzBuzz.FizzBuzz.toString());
					
				}
				else if( cont%5 == 0 )
				{
					fizzOrBuzz.add(FizzBuzz.Buzz.toString());
				}
				else if( cont%3 == 0 )
				{
					fizzOrBuzz.add(FizzBuzz.Fizz.toString());
				}
				else
				{
					fizzOrBuzz.add(Integer.toString(cont));
				}	
				
				logger.debug("List values: "+fizzOrBuzz);
			}
			
			return fizzOrBuzz;
		}
		catch(ValidateNumberException e){
			
			throw  new ValidateNumberException(e.getMessage());
		}
		catch (Exception e)
		{
			logger.error("Try failed");
			e.getMessage();
			throw new Exception();
		}
	}
   
   private void integerValidator (int number) throws Throwable {
	   	
	   if (number < 0)
	   {
		  throw new ValidateNumberException(String.format("The number (%d) is lower than 0.", number));
	   }
	  
   }
 

}

