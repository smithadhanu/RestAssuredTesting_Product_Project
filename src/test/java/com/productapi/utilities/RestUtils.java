package com.productapi.utilities;

import org.apache.commons.lang3.RandomStringUtils;

public class RestUtils {

	public static String prodName()
	{
		String generatedString = RandomStringUtils.randomAlphabetic(1);
		return ("John"+generatedString);
		
	}
	public static String prodType()
	{
		String generatedString = RandomStringUtils.randomAlphabetic(1);
		return ("verygood"+generatedString);
		
	}
	public static String prodPrice()
	{
		String generatedString = RandomStringUtils.randomNumeric(5);
		return (generatedString);
		
	}
	public static String prodShipping()
	{
		String generatedString = RandomStringUtils.randomNumeric(4);
		return (generatedString);
		
	}
	public static String prodUpc()
	{
		String generatedString = RandomStringUtils.randomAlphabetic(1);
		return ("test001"+generatedString);
		
	}
	public static String prodDescription()
	{
		String generatedString = RandomStringUtils.randomAlphabetic(1);
		return ("hihello"+generatedString);
		
	}
	public static String prodManufacturer()
	{
		String generatedString = RandomStringUtils.randomAlphabetic(1);
		return ("rssuper"+generatedString);
		
	}
	public static String prodModel()
	{
		String generatedString = RandomStringUtils.randomAlphabetic(1);
		return ("TC001"+generatedString);
		
	}
	public static String prodUrl()
	{
		String generatedString = RandomStringUtils.randomAlphabetic(1);
		return ("http://www.dhanu.com"+generatedString);
		
	}
	public static String prodImage()
	{
		String generatedString = RandomStringUtils.randomAlphabetic(1);
		return ("http://www.xyz.com"+generatedString);
		
	}
	
	
	
}
