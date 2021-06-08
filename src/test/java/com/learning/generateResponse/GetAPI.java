package com.learning.generateResponse;

import static io.restassured.RestAssured.given;

import java.io.IOException;

import com.learning.extentReports.ExtentLogger;
import com.learning.utils.BaseTest;
import com.learning.utils.HelperForLog;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
public class GetAPI extends BaseTest {

	RequestSpecification requestSpecification;
	Response response;
	AddAPI addApi;
	
	public Response getAPI(String placeid) throws IOException
	{
		ExtentLogger.info("Initialize getAPI and constructing the url, and using the placeid is : "+placeid);
		
		
		requestSpecification=given()
				.spec(reqSpec())
				.queryParam("place_id", placeid);
		
		response=requestSpecification.when().get(getApiResource("GetPlaceAPI"))
				.then().spec(resSpecification()).extract().response();
		HelperForLog.requestResponselog(requestSpecification, response, getApiResource("GetPlaceAPI"));
		
		return response;
	}
}
