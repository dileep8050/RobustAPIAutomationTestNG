package com.learning.generateResponse;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import static io.restassured.RestAssured.*;

import com.learning.extentReports.ExtentLogger;
import com.learning.payloadsFromFiles.ReadPayloadBodyFromFiles;
import com.learning.requestPayloadBody.AddPayload;
import com.learning.utils.BaseTest;
import com.learning.utils.HelperForLog;

public class AddAPI extends BaseTest {
	RequestSpecification requestSpecification;
	Response response;

	public Response addAPIPayload(String type, String apifilename) throws Exception {
		ExtentLogger.info("Initialize addAPI and constructing the url, body is taking from the  source type : "+type);
		
			if(type=="javaclass")
			{
				requestSpecification=given()
					.spec(reqSpec())
					.body(AddPayload.staticAddPayloadBody());
				}
			else if(type=="txtfile")
			{
				requestSpecification=given()
					.spec(reqSpec())
					.body(ReadPayloadBodyFromFiles.txtFile(apifilename));
			}
			else if(type=="jsonfile")
			{

				requestSpecification=given()
						.spec(reqSpec())
						.body(ReadPayloadBodyFromFiles.jsonFile(apifilename));
			}
			else if(type=="hashmap")
			{
				requestSpecification=given()
						.spec(reqSpec())
						.body(AddPayload.addPayloadUsingHashmap());
			}
			else if(type=="excelfile")
			{
				requestSpecification=given()
						.spec(reqSpec())
						.body(AddPayload.addPayloadFromExcel());			
			}

		response=requestSpecification.when().post(getApiResource("AddPlaceAPI"))
				.then().spec(resSpecification()).extract().response();
		HelperForLog.requestResponselog(requestSpecification,response,getApiResource("AddPlaceAPI"));
		
		return response;
	}
	
}
