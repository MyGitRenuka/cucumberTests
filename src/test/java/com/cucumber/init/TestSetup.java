package com.cucumber.init;

import java.io.File;
import java.io.IOException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import java.util.concurrent.TimeUnit;
import org.apache.commons.io.FileUtils;
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
	public static TimeUnit waitTimeUnit;
	public static long explicitWait;
	public static String browser;
	public static int screenshotCnt=0;
	private static final Logger log = Log.getLogger(TestSetup.class);
	
	public void setWebdriver() throws IOException {
		Config.setProperties();
		browser = Config.testConfig.getProperty("browser").toLowerCase();
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
				System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + 
						Config.testConfig.getProperty("chromeDriver"));	    
				System.out.println(System.getProperty("webdriver.chrome.driver"));
				TestSetup.driver = new ChromeDriver();							
		}		
		initialiseDriverWaits(driver);		
	}
	
	public void setWaitTimeUnit() {		
		String unitFromConfig = Config.testConfig.getProperty("timeUnit").toLowerCase();
		switch(unitFromConfig) {
		case "seconds":
			waitTimeUnit=TimeUnit.SECONDS;
		case "milliseconds":
			waitTimeUnit=TimeUnit.MILLISECONDS;
		case "microseconds":
			waitTimeUnit=TimeUnit.MICROSECONDS;
		case "minutes":
			waitTimeUnit=TimeUnit.MINUTES;
		default:
			waitTimeUnit=TimeUnit.SECONDS;		
		}	
		log.info("Wait time unit successfully set to " + unitFromConfig);
	}
	
	public void initialiseDriverWaits(WebDriver driver) {
		setWaitTimeUnit();
		setImplicitWait(driver);
		setPageLoadTime(driver);
		explicitWait=readWaitTimeFromConfig("explicitWait");
		deleteAllCookies(driver);
		log.info("Successfully initialised the webdriver");
	}
	
	public long readWaitTimeFromConfig(String key) {
		long value = Long.parseLong(Config.testConfig.get(key).toString());
		return value;	
	}
	
	public WebDriverWait setExplicitWait(WebDriver driver) {
		log.info("Creating Web driver wait object with explicit wait timeout of [" + explicitWait + "] " + 
						waitTimeUnit.name().toLowerCase());
		return  new WebDriverWait(driver, explicitWait);	
	}
	
	
	public WebDriverWait setCustomExplicitWait(WebDriver driver,long timeout) {
		log.info("Creating Web driver wait object with custom explicit wait timeout of[" +  timeout+"] " +
				waitTimeUnit.name().toLowerCase());
		return  new WebDriverWait(driver, timeout);	
	}
	
	public void setImplicitWait(WebDriver driver) {
		long timeout = readWaitTimeFromConfig("implicitWait");
		driver.manage().timeouts().implicitlyWait(timeout,waitTimeUnit);
		log.info(browser + " driver initialized with implicit wait time [" + timeout + "] " +
				waitTimeUnit.name().toLowerCase());
	}
	
	public void setPageLoadTime(WebDriver driver) {
		long timeout = readWaitTimeFromConfig("pageLoadTime");
		driver.manage().timeouts().pageLoadTimeout(timeout,waitTimeUnit);
		log.info(browser + " driver initialized with page load time [" + timeout +"] " + 
							waitTimeUnit.name().toLowerCase());
	}
	
	public void deleteAllCookies(WebDriver driver) {
		driver.manage().deleteAllCookies();
		log.info("Deleted all cookies");
	}

	public static String captureScreen(WebDriver driver,String fileName) {
		
		File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		screenshotCnt++;
		try
		{
			FileUtils.copyFile(src, new File(Config.testConfig.getProperty("screenshotLoc")+
					fileName + '_' + screenshotCnt+".png")); 
			return "Screenshot captured successfully";
		} 
		catch (IOException e)
		{
			return(e.getMessage()); 
		}	
	}
	
}
