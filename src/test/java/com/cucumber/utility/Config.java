package com.cucumber.utility;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Properties;

/**
 * @author Renuka R Hosamani
 *
 * 
 */
public class Config {
	
	public static Properties testConfig;
	
	public static void setProperties() throws IOException {
		FileReader reader = new FileReader("src/test/resources/config/setupProps");
		testConfig = new Properties();
		testConfig.load(reader);	
		
	}
	
	
}
