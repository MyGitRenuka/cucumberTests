package com.cucumber.steps;

import java.io.IOException;
import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
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
		log.info("#########################################   NEW SCENARIO  #########################################");
		log.info("SCENARIO NAME || " + scenario.getName() + " || STATUS || started"); 
		log.info("Initialising webdriver");
		initTest.setWebdriver();                
   }
	
	@After(order=1)
	public void afterScenarioEnd(Scenario scenario) {
		 String status = scenario.getStatus();
	     System.out.println("SCENARIO STATUS: " + status);
	     log.info("SCENARIO NAME || " + scenario.getName() + " || STATUS ||" + status );	     
	     try {
	    	 scenario.embed(((TakesScreenshot) TestSetup.driver).getScreenshotAs(OutputType.BYTES), "image/png");
	     }
	     catch(Exception e)
	     {
	    	 log.info(e.getMessage());
	    	 e.printStackTrace();
	     }
	     
	}

	@After(order=0)
	public void quitBrowser(Scenario scenario) {
		log.info("Teardown started..");
		TestSetup.driver.quit();
		log.info("Closed all the browser windows");
		log.info("#########################################   END OF SCENARIO  ########################################\n");
	}

}
