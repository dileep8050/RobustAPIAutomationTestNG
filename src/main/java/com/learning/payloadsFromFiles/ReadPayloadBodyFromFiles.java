package com.learning.payloadsFromFiles;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import com.learning.constants.FrameworkConstants;

public class ReadPayloadBodyFromFiles {
	public static String jsonFile(String filename) throws IOException
	{
		String payload=new String(Files.readAllBytes(Paths.get(FrameworkConstants.getPayloadFilePath()+"\\"+filename+".json")));
		return payload;
	}
	
	public static String txtFile(String filename) throws IOException 
	{
		String payload=new String(Files.readAllBytes(Paths.get(FrameworkConstants.getPayloadFilePath()+"\\"+filename+".txt")));
		return payload;
	}
}
