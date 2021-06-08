package com.learning.extentReports;

import java.util.Objects;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public final class ExtentReport {
	
	private ExtentReport() {};
	private static ExtentReports extent;
	
	public static void initReports()
	{
		if(Objects.isNull(extent))
		{
			ExtentSparkReporter spark=new ExtentSparkReporter("index.html");
			extent=new ExtentReports();
			extent.attachReporter(spark);
			spark.config().setTheme(Theme.STANDARD);
			spark.config().setDocumentTitle("Learning extent");
			spark.config().setReportName("Dileep");	
		}
	}
	
	public static void flushReports()
	{
		if(Objects.nonNull(extent))
		{
			extent.flush();
		}
	}
	
	public static void createTest(String testName)
	{
		ExtentManager.setExtentTest(extent.createTest(testName));
	}
}
