package com.cucumber.init;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.cucumber.utility.Config;


/**
 * @author Renuka R Hosamani
 *
 * 
 */
public class TestSetup {
	
	public static WebDriver driver;
	
	public void setWebdriver() throws IOException {
		Config.setProperties();
		switch(Config.testConfig.getProperty("browser"))
		{
			case "chrome":
				System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + 
						Config.testConfig.getProperty("chromeDriver"));	    
				System.out.println(System.getProperty("webdriver.chrome.driver"));
				TestSetup.driver = new ChromeDriver();
				break;
		    
			/*FIREFOX:
			IE:
			 */
			default: 
				System.out.println("Unknown browser type");
								
		}
	}

}
