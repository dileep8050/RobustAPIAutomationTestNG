package com.learning.testCases;

import org.testng.annotations.Test;

import com.learning.generateResponse.GetAPI;
import com.learning.utils.SupportClass;
import com.learning.utils.Validations;

import io.restassured.response.Response;

public class VerifyGetPlaceAPITest extends SupportClass {
	GetAPI getApi;
	Response response;
	
	@Test
	public void getplaceWithValidPlaceID() throws Exception
	{
		getApi=new GetAPI();
		String placeid=addPayload();
		response=getApi.getAPI(placeid);
		Validations.validateStatusCode(response, 200);
		deleteAPI(placeid);
	}

}
