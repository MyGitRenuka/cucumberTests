package com.cucumber.steps;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;
import static org.junit.Assert.*;
import com.cucumber.init.TestSetup;
import com.cucumber.pages.LoginPage;
import com.cucumber.utility.Config;


/**
 * @author Renuka R Hosamani
 *
 * 
 */
public class Stepdefs extends TestSetup{

	LoginPage loginPage = new LoginPage(driver);
	
	@Given("^I am at the sign-in page$")
	public void i_am_at_the_sign_in_page() throws Throwable {
	    loginPage.getUrl(Config.testConfig.getProperty("url"));
	}

	@Then("^I can see the submit option$")
	public void i_can_see_the_submit_option() throws Throwable {
		assertTrue(loginPage.getSubmit().isDisplayed());
	}

	@When("^I enter my username as \"([^\"]*)\"$")
	public void i_enter_my_username_as(String username) throws Throwable {
	    loginPage.enterUsername(username);
	}

	@When("^I enter password as \"([^\"]*)\"$")
	public void i_enter_password_as(String password) throws Throwable {
	   loginPage.enterPassword(password);
	}

	@When("^Click on submit button$")
	public void click_on_submit_button() throws Throwable {
	    loginPage.submit();
	}

	@Then("^I am logged on to the website$")
	public void i_am_logged_on_to_the_website() throws Throwable {
	    assertTrue(loginPage.getSignOff().isDisplayed());
	}


}