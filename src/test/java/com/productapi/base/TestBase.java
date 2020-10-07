package com.productapi.base;

import java.util.Date;

import org.apache.log4j.Logger;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TestBase {

	public static RequestSpecification httpRequest;
	public static Response response;
	public String prodID="346646";
	
	public static ExtentHtmlReporter htmlReporter;
	public static ExtentReports reports;
	public static ExtentTest test;
	
	public Logger logger=Logger.getLogger(TestBase.class);
	
	@BeforeSuite
	public void setUp()
	{
		htmlReporter=new ExtentHtmlReporter("./reports/"+new Date().toString().replace(":","-")+"E.html");
		reports=new ExtentReports();
		reports.attachReporter(htmlReporter);
	}
	@AfterSuite
	public void tearrDown()
	{
		reports.flush();
		
	}
}	
