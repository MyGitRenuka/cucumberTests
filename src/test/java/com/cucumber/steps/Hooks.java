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

	Logger log = Log.getLogger(Hooks.class);
	TestSetup initTest = new TestSetup();
	
	
	@Before
	public void initiate(Scenario scenario) throws IOException {
		log.info("Initialising webdriver");
		initTest.setWebdriver();
		System.out.println("SCENARIO NAME:" + scenario.getName());        
        log.info("SCENARIO NAME: " + scenario.getName());
        
   }
	
	@After(order=1)
	public void afterScenarioEnd(Scenario scenario) {
		 String status = scenario.getStatus();
	     System.out.println("SCENARIO STATUS: " + status);
	     log.info("SCENARIO NAME| " + scenario.getName() + " | STATUS |" + status );
	}

	@After(order=0)
	public void quitBrowser(Scenario scenario) {
		log.info("-----------------quitting the browser---------------------\n\n");
		TestSetup.driver.quit();		
	}

}
