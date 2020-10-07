package com.productapi.TestCases;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.productapi.base.TestBase;
import com.productapi.utilities.RestUtils;

import io.restassured.RestAssured;
import io.restassured.http.Method;

public class TC004_Put_Products_Record extends TestBase {
	
	   String prodName=RestUtils.prodName();
	   String prodType=RestUtils.prodType();
	   String prodPrice=RestUtils.prodPrice();
	   String prodShipping=RestUtils.prodShipping();
	   String prodUpc=RestUtils.prodUpc();
	   String prodDescription=RestUtils.prodDescription();
	   String prodManufacturer=RestUtils.prodManufacturer();
	   String prodModel=RestUtils.prodModel();
	   String prodUrl=RestUtils.prodUrl();
	   String prodImage=RestUtils.prodImage();
		
		@BeforeTest
		void createProduct() throws InterruptedException
		{
			RestAssured.baseURI="http://localhost:3030";
			
			httpRequest=RestAssured.given();
			
			JSONObject requestParams=new JSONObject();
			requestParams.put("name", prodName);
			requestParams.put("type", prodType);
			requestParams.put("price", Integer.parseInt(prodPrice));
			requestParams.put("shipping", Integer.parseInt(prodPrice));
			requestParams.put("upc", prodUpc);
			requestParams.put("description", prodDescription);
			requestParams.put("manufacturer", prodManufacturer);
			requestParams.put("model", prodModel);
			requestParams.put("url", prodUrl);
			requestParams.put("image", prodImage);
			
			httpRequest.header("Content-Type", "application/json");
			httpRequest.body(requestParams.toJSONString());
			
			response=httpRequest.request(Method.PUT,"/products/"+prodID);
			Thread.sleep(5000);
		}
		@Test
		void checkResponseBody()
		{
			logger.info("-------------checking Response Body------------------");
			
			String responseBody = response.getBody().asString();
			logger.info("response body is---->"+responseBody);
			
	        Assert.assertEquals(responseBody.contains(prodName), true);	
	        Assert.assertEquals(responseBody.contains(prodType), true);
	        Assert.assertEquals(responseBody.contains(prodManufacturer), true);		

	        Assert.assertEquals(responseBody.contains(prodModel), true);		


		}
		@Test
		void checkStatusCode()
		{
			logger.info("-------------checking Status Code------------------");
			
			int statusCode = response.getStatusCode();
			
			logger.info("status code is---->"+statusCode);
			
			Assert.assertEquals(statusCode, 200);
			
		}
		/*
		 * @Test void checkResponseTime() {
		 * logger.info("-------------checking Response Time------------------");
		 * 
		 * long responseTime = response.getTime();
		 * 
		 * logger.info("response Time is ---->"+responseTime);
		 * 
		 * if(responseTime>2000) logger.warn("Response Time is Greater Than 2000");
		 * Assert.assertTrue(responseTime<2000);
		 * 
		 * }
		 */

		
		/*
		 * @Test void checkStatusLine() {
		 * logger.info("-------------checking Status Line------------------");
		 * 
		 * String statusLine = response.getStatusLine();
		 * 
		 * logger.info("Status Line is ---->"+statusLine);
		 * 
		 * 
		 * Assert.assertEquals(statusLine, "HTTP/1.1 200 OK");
		 * 
		 * 
		 * }
		 */
		 
		@Test
		void checkContentType()
		{
			logger.info("-------------checking Content Type------------------");
			
			 String contentType = response.header("Content-Type");
			
			logger.info("response Time is ---->"+contentType);
			
			
			Assert.assertEquals(contentType, "application/json; charset=utf-8");

			
		}
		@Test
		void checkContentLength()
		{
			logger.info("-------------checking Content Length------------------");
			
			 String contentLength = response.header("content-length");
			
			logger.info("content Length ---->"+contentLength);
			
			
			//Assert.assertEquals(contentLength, "261");
			Assert.assertTrue(Integer.parseInt(contentLength)<1000);

			
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
