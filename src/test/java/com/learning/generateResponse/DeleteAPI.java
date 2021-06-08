package com.learning.generateResponse;

import static io.restassured.RestAssured.*;
import java.io.IOException;

import com.learning.extentReports.ExtentLogger;
import com.learning.requestPayloadBody.DeletePayload;
import com.learning.utils.BaseTest;
import com.learning.utils.HelperForLog;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class DeleteAPI extends BaseTest {
	RequestSpecification requestSpecification;
	Response response;
	
	public Response deleteAPI(String placeid) throws IOException
	{
		ExtentLogger.info("Initialize deleteAPI and constructing the url, and using the placeid is : "+placeid);
		requestSpecification=given().spec(reqSpec()).body(DeletePayload.deletePayload(placeid));	
		response = requestSpecification.when().delete(getApiResource("DeletePlaceAPI"))
				.then().spec(resSpecification()).extract().response();
		HelperForLog.requestResponselog(requestSpecification,response,getApiResource("DeletePlaceAPI"));
		return response;
	}

}
