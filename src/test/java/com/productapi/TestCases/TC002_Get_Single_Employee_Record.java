package com.productapi.TestCases;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.productapi.base.TestBase;

import io.restassured.RestAssured;
import io.restassured.http.Method;

public class TC002_Get_Single_Employee_Record extends TestBase{
	@BeforeClass
	void getAllEmployees() throws InterruptedException
	{
		logger.info("-------------Started TC001_Get_All_Products------------------");
		
		RestAssured.baseURI="http://localhost:3030";
		
		httpRequest=RestAssured.given();
		
		response=httpRequest.request(Method.GET, "/products/"+prodID);
		
		Thread.sleep(3000);
				
	}
	@Test
	void checkResponseBody()
	{
		logger.info("-------------checking Response Body------------------");
		
		String responseBody = response.getBody().asString();
		logger.info("response body is---->"+responseBody);
		
        Assert.assertEquals(responseBody.contains(prodID), true);		
	}
	@Test
	void checkStatusCode()
	{
		logger.info("-------------checking Status Code------------------");
		
		int statusCode = response.getStatusCode();
		
		logger.info("status code is---->"+statusCode);
		
		Assert.assertEquals(statusCode, 200);
		
	}
	@Test
	void checkResponseTime()
	{
		logger.info("-------------checking Response Time------------------");
		
		long responseTime = response.getTime();
		
		logger.info("response Time is ---->"+responseTime);
		
		if(responseTime>2000)
			logger.warn("Response Time is Greater Than 2000");
		Assert.assertTrue(responseTime<2000);
		
	}

	
	  @Test void checkStatusLine() {
	  logger.info("-------------checking Status Line------------------");
	 
	 String statusLine = response.getStatusLine();
	 
	  logger.info("Status Line is ---->"+statusLine);
	  
	  
	  Assert.assertEquals(statusLine, "HTTP/1.1 200 OK");
	  
	  
	  }
	 
	@Test
	void checkContentType()
	{
		logger.info("-------------checking Content Type------------------");
		
		 String contentType = response.header("Content-Type");
		
		logger.info("response Time is ---->"+contentType);
		
		
		Assert.assertEquals(contentType, "application/json; charset=utf-8");

		
	}
	@Test
	void checkContentEncoding()
	{
		logger.info("-------------checking Content Encoding------------------");
		
		 String contentEncoding = response.header("content-encoding");
		
		logger.info("response Time is ---->"+contentEncoding);
		
		
		Assert.assertEquals(contentEncoding, "gzip");

		
	}
	@AfterClass
	void tearDown()
	{
		logger.info("-------------Finished TC001_Get_All_Products------------------");
		test.assignAuthor("Dhananjaya"); 
		test.assignCategory("GUI automation");
		  test.assignDevice("laptop"); 
		  reports.setSystemInfo("windows", "10");
	}
	
	
}
