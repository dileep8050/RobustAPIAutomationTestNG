package com.learning.testCases;

import org.testng.annotations.Test;

import com.learning.generateResponse.AddAPI;
import com.learning.utils.ParseJsonResponse;
import com.learning.utils.SupportClass;
import com.learning.utils.Validations;

import io.restassured.response.Response;

public class VerifyAddPlaceAPITest extends SupportClass{
	AddAPI addApi;
	Response response;
	
	@Test
	public void addingPlaceUsingJsonFile() throws Exception
	{
		
	addApi=new AddAPI();
	response = addApi.addAPIPayload("jsonfile", "addplace");
	Validations.validateStatusCode(response, 200);
	Validations.responseValidation(response, "status", "OK");
	
	deleteAPI(ParseJsonResponse.getKeyValue(response, "place_id"));
	
	}

}
