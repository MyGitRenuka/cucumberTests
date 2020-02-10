package com.cucumber.init;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.cucumber.utility.Config;
import com.cucumber.utility.Log;

/**
 * @author Renuka R Hosamani
 *
 * 
 */
public class TestSetup {
	
	public static WebDriver driver;
	public static TimeUnit waitTimeUnit = TimeUnit.SECONDS;
	public static String browser;
	Logger log = Log.getLogger(TestSetup.class);
	
	public void setWebdriver() throws IOException {
		Config.setProperties();
		browser = Config.testConfig.getProperty("browser");
		switch(browser)
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
				//System.out.println("Unknown browser type");
				log.info("Unknown browser type\nSupported browser types: [chrome]");								
		}		
		initialiseDriverWaits(driver);		
	}
	
	public void initialiseDriverWaits(WebDriver driver) {
		setImplicitWait(driver);
		setPageLoadTime(driver);
		deleteAllCookies(driver);
		log.info("------------Deleted all cookies------------");
	}
	
	public long readWaitTimeFromConfig(String key) {
		long value = Long.parseLong(Config.testConfig.get(key).toString());
		return value;	
	}
	
	public WebDriverWait setExplicitWait(WebDriver driver) {
		long timeout = readWaitTimeFromConfig("explicitWait");
		log.info("Explicit wait time set to [" + timeout + "] " + waitTimeUnit.toString());
		return  new WebDriverWait(driver, timeout);	
	}
	
	public void setImplicitWait(WebDriver driver) {
		long timeout = readWaitTimeFromConfig("implicitWait");
		driver.manage().timeouts().implicitlyWait(timeout,waitTimeUnit);
		log.info(browser + " driver initialized with implicit wait time [" + timeout + "] " + waitTimeUnit.toString());
	}
	
	public void setPageLoadTime(WebDriver driver) {
		long timeout = readWaitTimeFromConfig("pageLoadTime");
		driver.manage().timeouts().pageLoadTimeout(timeout,waitTimeUnit);
		log.info(browser + " driver initialized with page load time [" + timeout +"] " + waitTimeUnit.toString());
	}
	
	public void deleteAllCookies(WebDriver driver) {
		driver.manage().deleteAllCookies();
	}

}
