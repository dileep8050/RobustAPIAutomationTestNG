package com.learning.utils;

import org.junit.Assert;

import com.learning.extentReports.ExtentLogger;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;


public class Validations {
	
	
	public static void validateStatusCode(Response response, int expectedStatusCode)
	{
		int actualStatuscode=response.getStatusCode();
		
		if(actualStatuscode==expectedStatusCode)
		{
			ExtentLogger.pass("Expected status code is : "+expectedStatusCode+" We got status code from response is: "+actualStatuscode +" , so validation status code is passed ");
			Assert.assertEquals(expectedStatusCode, actualStatuscode);
		}
		else
		{
			ExtentLogger.fail("Expected status code is : "+expectedStatusCode+"We got status code from response is: "+actualStatuscode+" , so validation status code is failed ");
			Assert.assertEquals(expectedStatusCode, actualStatuscode);
		}
	}
	
	public static void responseValidation(Response response, String expectedKey,String expectedValue)
	{
		String resp= response.asString();
		JsonPath js=new JsonPath(resp);
		String actualvalue=js.get(expectedKey).toString();
		if(expectedValue.equals(actualvalue))
		{
			ExtentLogger.pass("In Response Expected value is ("+expectedValue+") and Actual status key value is also ("+actualvalue+") so both are matched");
			Assert.assertEquals(expectedValue, actualvalue);
		}
		else
		{
			ExtentLogger.fail("In Response Expected value is ("+expectedValue+") and Actual status code ("+actualvalue+") is not matched and validation failed");
			Assert.assertEquals(expectedValue, actualvalue);
		}
	}
		
}
