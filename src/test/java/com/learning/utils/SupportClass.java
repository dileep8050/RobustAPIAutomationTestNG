package com.learning.utils;

import static io.restassured.RestAssured.given;

import java.io.IOException;

import com.learning.extentReports.ExtentLogger;
import com.learning.requestPayloadBody.AddPayload;
import com.learning.requestPayloadBody.DeletePayload;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class SupportClass extends BaseTest {
	
	RequestSpecification requestSpecification;
	Response response;

	public String addPayload() throws Exception {
		
				requestSpecification=given()
					.spec(reqSpec())
					.body(AddPayload.staticAddPayloadBody());
				
		response=requestSpecification.when().post(getApiResource("AddPlaceAPI"))
				.then().spec(resSpecification()).extract().response();
		
		String placeid=ParseJsonResponse.getKeyValue(response, "place_id");
		ExtentLogger.info("Newly created place id is: "+ placeid);
		return placeid;
		
	}
	
	public void deleteAPI(String placeid) throws IOException
	{
	
		requestSpecification=given().spec(reqSpec()).body(DeletePayload.deletePayload(placeid));	
		
		response = requestSpecification.when().delete(getApiResource("DeletePlaceAPI"))
				.then().spec(resSpecification()).extract().response();
		ExtentLogger.info("As part of clean up activity we deleted the newly created record with the place id : "+placeid);
	}
	
	public String getAPI(String placeid) throws IOException
	{
		requestSpecification=given()
				.spec(reqSpec())
				.queryParam("place_id", placeid);
		
		response=requestSpecification.when().get(getApiResource("GetPlaceAPI"))
				.then().spec(resSpecification()).extract().response();
		String address=ParseJsonResponse.getKeyValue(response, "address");
		return address;

	}
}
