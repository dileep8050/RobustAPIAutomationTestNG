package com.learning.testCases;

import org.testng.annotations.Test;

import com.learning.generateResponse.DeleteAPI;
import com.learning.utils.SupportClass;
import com.learning.utils.Validations;

import io.restassured.response.Response;

public class VerifyDeletePlaceAPI extends SupportClass {
	DeleteAPI deleteApi;
	Response response;
	
	@Test
	public void deltePlaceWithValidPlaceID() throws Exception
	{
		deleteApi=new DeleteAPI();
		String placeid=addPayload();
		
		response=deleteApi.deleteAPI(placeid);
		Validations.validateStatusCode(response, 200);

	}

}
