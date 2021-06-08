package com.learning.generateResponse;

import static io.restassured.RestAssured.*;

import java.io.IOException;

import com.learning.requestPayloadBody.UpdatePayload;
import com.learning.utils.BaseTest;
import com.learning.utils.HelperForLog;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class UpdateAPI extends BaseTest {
	RequestSpecification requestSpecification;
	Response response;
	public Response updateAPI(String placeid, String address) throws IOException
	{
		requestSpecification=given().spec(reqSpec()).body(UpdatePayload.updatePayload(placeid, address));		
		response=requestSpecification.when().put(getApiResource("UpdatePlaceAPI"))
				.then().spec(resSpecification()).extract().response();
		HelperForLog.requestResponselog(requestSpecification,response,getApiResource("UpdatePlaceAPI"));
		return response;
	}
}
