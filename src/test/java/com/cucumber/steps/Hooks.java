package com.cucumber.steps;

import java.io.IOException;
import org.apache.log4j.Logger;

import com.cucumber.init.TestSetup;
import com.cucumber.utility.Log;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;

/**
 * @author Renuka R Hosamani
 *
 * 
 */
public class Hooks {
	
	TestSetup testBase;
	Logger log = Log.getLogger(Hooks.class);
	
	@Before(order=0)
	public void clearCookies() throws IOException {
		log.info("Hooks before_0: Clearing the cookies");
		testBase = new TestSetup();
		testBase.setWebdriver();
		TestSetup.driver.manage().deleteAllCookies();
	}
	
	@Before(order=1)
	public void beforeScenarioStart(Scenario scenario) throws IOException {
		log.info("Hooks before_1: Scenario started \"" + scenario.getName() + "\" started");
	}
	
	@After(order=0)
	public void afterScenarioEnd(Scenario scenario) {
		log.info("Hooke after_0: End of scenario \"" + scenario.getName() + "\"");
		if(scenario.isFailed())
		{
			log.info("Hooks after_0: Scenario \"" + scenario.getName() + "\" failed");
		}
		else
		{
			log.info("Hooks after_0: Scenario \"" + scenario.getName() + "\" passed");
		}
	}
	
	@After(order=1)
	public void quitBrowser(Scenario scenario) {
		log.info("Hooks after_1: quitting the browser");
		TestSetup.driver.quit();
	}
}
