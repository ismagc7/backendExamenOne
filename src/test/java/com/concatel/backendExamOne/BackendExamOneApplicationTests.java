package com.concatel.backendExamOne;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.concatel.backendExamOne.service.IDataService;

@SpringBootTest
class BackendExamOneApplicationTests {
	
	@Autowired
	private IDataService iDataServiceTest;
	
	@Test
	void contextLoads() throws Throwable {
		
		//Prepare
		int number = 30;
		//Use
		List<String> response = iDataServiceTest.complete(number);
		//Assert
		assertEquals(response.get(0),Integer.toString(0));
		assertEquals(response.get(3),"Fizz");
		assertEquals(response.get(25),"Buzz");
		assertEquals(response.get(15),"FizzBuzz");
		assertEquals(response.size(),(number+1));
	}

}
