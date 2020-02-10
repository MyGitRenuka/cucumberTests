package com.cucumber.validations;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
//import org.testng.asserts.SoftAssert;

public class Verifier {
	
	private static Logger log = Logger.getLogger(Verifier.class);
	
	public static void verifyElementDisplayed(WebElement element,String elementToBeVerified){
		log.info("Verifying: " + elementToBeVerified);
		Assert.assertTrue(element.isDisplayed(), "Actual and expected price are same");	
	}

	public static void verifyText(String str1,String str2,String message){
		log.info("Verifying: " + message);
		Assert.assertTrue(str1.equals(str2),message);			
	}
		
	public static void verifyTrue(boolean condition, String conditionToBeVerified){
		log.info("Verifying: " + conditionToBeVerified);
		Assert.assertTrue(condition,conditionToBeVerified);
	}
	
	public static void verifyFalse(boolean condition, String conditionToBeVerified){
		log.info("Verifying: " + conditionToBeVerified);
		Assert.assertFalse(condition,conditionToBeVerified);
	}
}
