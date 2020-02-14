package com.cucumber.runner;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import cucumber.api.CucumberOptions;
import cucumber.api.testng.CucumberFeatureWrapper;
import cucumber.api.testng.TestNGCucumberRunner;
import org.testng.annotations.DataProvider;

/**
 * @author Renuka R Hosamani
 *
 * 
 */
@CucumberOptions(features= {"src/test/resources/features"},
				 glue= {"com.cucumber.steps"}, plugin = { "pretty", "html:target/cucumber-reports/cucumber-pretty",
							"json:target/cucumber-reports/CucumberTestReport.json", 
							"rerun:target/cucumber-reports/rerun.txt" })

public class RunCucumberTest {
	
	   private TestNGCucumberRunner testNGCucumberRunner;

	    @BeforeClass(alwaysRun = true)
	    public void setUpClass() throws Exception {
	        testNGCucumberRunner = new TestNGCucumberRunner(this.getClass());
	    }

	    
	    @Test(groups = "cucumber", description = "Runs Cucumber Feature", dataProvider = "features")
	    public void feature(CucumberFeatureWrapper cucumberFeature) {
	        testNGCucumberRunner.runCucumber(cucumberFeature.getCucumberFeature());
	    }

	    /**
	     * @return returns two dimensional array of {@link CucumberFeatureWrapper} objects.
	     */
	    @DataProvider
	    public Object[][] features() {
	        return testNGCucumberRunner.provideFeatures();
	    }

	    @AfterClass(alwaysRun = true)
	    public void tearDownClass() throws Exception {
	        testNGCucumberRunner.finish();
	    }

	
	}