package com.learning.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import com.learning.apiResources.APIResources;
import com.learning.constants.FrameworkConstants;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class BaseTest {
	public static RequestSpecification reqSpec;
	public ResponseSpecification resSpec;


	/**
	 * To construct the url with Query params and headers
	 * 
	 */

	public RequestSpecification reqSpec() throws IOException
	{
		reqSpec =new RequestSpecBuilder()
					.setBaseUri(getGlobalValue("baseUrl"))
					.addQueryParam("key", "qaclick123")
					.setContentType(ContentType.JSON)
					.build();

			return reqSpec;
	}


	/**
	 * To validate the response code based on user input
	 * 
	 */
	public ResponseSpecification resSpecification()
	{
		resSpec=new ResponseSpecBuilder().expectContentType(ContentType.JSON).build();
		return resSpec;
	}


	/**
	 * To get the resource for Add,Get,Update,Delete
	 * 
	 */
	public String getApiResource(String apiResource)
	{
		APIResources resourceAPI=APIResources.valueOf(apiResource);
		String apiRes=resourceAPI.getResource();
		return apiRes;
	}


	/**
	 * To read the properties file and fetch the values based on key we requested and we are giving as string
	 * 
	 */

	public String getGlobalValue(String key) throws IOException
	{
		Properties prop=new Properties();
		FileInputStream fis=new FileInputStream(FrameworkConstants.getConfigFilePath());
		prop.load(fis);
		return prop.getProperty(key);		
	}

}
