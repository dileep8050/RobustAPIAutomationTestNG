package com.learning.testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.learning.generateResponse.UpdateAPI;
import com.learning.utils.SupportClass;
import com.learning.utils.Validations;

import io.restassured.response.Response;


public class VerifyUpdatePlaceAPI extends SupportClass {
	UpdateAPI updateApi;
	Response response;
	@Test
	public void updatePlaceWithValidPlaceID() throws Exception
	{
		updateApi=new UpdateAPI();
		String placeid=addPayload();
		String beforeAddress="I am adding new address";
		
		response=updateApi.updateAPI(placeid,beforeAddress);
		Validations.validateStatusCode(response, 200);
		Validations.responseValidation(response, "msg", "Address successfully updated");
		
		String afterAddress=getAPI(placeid);
		Assert.assertEquals(beforeAddress, afterAddress);
		
		deleteAPI(placeid);
		
	}

}
