package com.learning.constants;

public final class FrameworkConstants {
	
	private FrameworkConstants(){};
	
	private static final String RESOURCEPATH = System.getProperty("user.dir")+"/src/test/resources";
	private static final String EXCELPATH = RESOURCEPATH+"/excelFile";
	private static final String CONFIGFILEPATH = RESOURCEPATH+"/config/config.properties";
	private static final String PAYLOADFILEPATH = RESOURCEPATH+"/payloadFiles";
	

	public static String getExcelPath() {
		return EXCELPATH;
	}
	public static String getConfigFilePath() {
		return CONFIGFILEPATH;
	}
	public static String getPayloadFilePath() {
		return PAYLOADFILEPATH;
	}
}
