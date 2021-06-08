package com.learning.utils;

import java.util.HashMap;
import java.util.Map;

import com.aventstack.extentreports.markuputils.CodeLanguage;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.learning.extentReports.ExtentLogger;

import io.restassured.response.Response;
import io.restassured.specification.QueryableRequestSpecification;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.SpecificationQuerier;

public class HelperForLog {
	
	public static void requestResponselog(RequestSpecification request, Response response, String resources) {

		QueryableRequestSpecification queryable = SpecificationQuerier.query(request);	
		
		Map<String,String> map=new HashMap<String, String>();
		map.put("Request method ", queryable.getMethod());
		map.put("Request URI ", queryable.getBaseUri()+resources);
		map.put("Request params ", queryable.getQueryParams().toString());
		
		ExtentLogger.info(MarkupHelper.createLabel("Header", ExtentColor.GREEN));
		ExtentLogger.info(MarkupHelper.createUnorderedList(map).getMarkup());
		
		if(queryable.getBody()!=null) {
			ExtentLogger.info(MarkupHelper.createLabel("Body", ExtentColor.GREEN));
			ExtentLogger.info(MarkupHelper.createCodeBlock(queryable.getBody().toString(), CodeLanguage.JSON));
		}
		else {}
		
		ExtentLogger.info(MarkupHelper.createLabel("Status code we got : "+ response.getStatusCode(), ExtentColor.GREEN));
		ExtentLogger.info(MarkupHelper.createLabel("Response", ExtentColor.GREEN));
		ExtentLogger.info(MarkupHelper.createCodeBlock(response.asString(), CodeLanguage.JSON));
		
	}

}
