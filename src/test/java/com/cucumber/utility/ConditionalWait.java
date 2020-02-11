package com.cucumber.utility;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.cucumber.init.TestSetup;

public class ConditionalWait {
	
	Logger log = Log.getLogger(TestSetup.class);
	private WebDriverWait webdriverWait;
	private long timeout;
	
	public ConditionalWait(WebDriverWait webdriverWait,long timeout) {
		this.webdriverWait=webdriverWait;
		this.timeout = timeout;
	}
	
	public void waitForElementVisibility(WebElement element,String elementName) {
		log.info("Waiting for visibility of element " + elementName + " for [" + timeout + "] seconds");		
		webdriverWait.until(ExpectedConditions.visibilityOf(element));
		log.info(elementName + " is visible now");
	}
	
	public void waitUntilElementClickable(WebElement element,String elementName) {
		log.info("Waiting for " + elementName + " to be clickable with timeout [" + timeout + "] seconds");
		webdriverWait.until(ExpectedConditions.elementToBeClickable(element));
		log.info(elementName + " is clickable now");
	}

	
	
}
