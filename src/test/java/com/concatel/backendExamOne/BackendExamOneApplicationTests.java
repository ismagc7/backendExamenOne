package com.concatel.backendExamOne;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.concatel.backendExamOne.service.IDataService;

@SpringBootTest
class BackendExamOneApplicationTests {
	
	@Autowired
	private IDataService iDataServiceTest;
	
	@Test
	@DisplayName("Correct size and correct values in List")
	void FizzBuzzTest() throws Throwable {
		
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
	
	@Test
	@DisplayName("Load Testing and correct funcionality")
	@RepeatedTest(50)
	void FizzBuzzOverLoadTest() throws Throwable{
		
		//Prepare
		int number = 100;
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
