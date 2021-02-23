package com.concatel.backendExamOne.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class DataServiceImpl implements IDataService{
	
	private static final Logger logger = LoggerFactory.getLogger(DataServiceImpl.class);
	
	enum words{
		Fizz,Buzz,FizzBuzz
	};

   @Override
	public List<String> complete(int max) throws Throwable { 
		
		try {
			
			List <String> fizzOrBuzz = new ArrayList<String>();
			
			fizzOrBuzz.add("0");

			if (integerValidator(max))
			{
				for (int cont=1; cont<=max; cont++)
				{
					if( cont%15 == 0 )
					{
						fizzOrBuzz.add("FizzBuzz");
					}
					else if( cont%5 == 0 )
					{
						fizzOrBuzz.add("Buzz");
					}
					else if( cont%3 == 0 )
					{
						fizzOrBuzz.add("Fizz");
					}
					else
					{
						fizzOrBuzz.add(Integer.toString(cont));
					}	
				}
			}
			return fizzOrBuzz;
		}
		catch (Exception e)
		{
			e.getMessage();
			throw new Exception();
		}
	}
   
   private boolean integerValidator (int number) throws Throwable {
	   
	   boolean result = false;
	   	
	   if (number >= 0)
	   {
		   result = true;
	   }
	   else {
		   logger.error(number+" is lower than 0.");
		   throw new Exception();
	   }
	   
	   return result;
   }
   }

