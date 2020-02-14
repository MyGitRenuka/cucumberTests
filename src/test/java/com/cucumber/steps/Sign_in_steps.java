package com.cucumber.steps;

import org.apache.log4j.Logger;

import com.cucumber.init.TestSetup;
import com.cucumber.pages.HomePage;
import com.cucumber.pages.SignInPage;
import com.cucumber.utility.Config;
import com.cucumber.utility.Log;
import com.cucumber.validations.Verifier;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

/**
 * @author Renuka R Hosamani
 *
 * 
 */
public class Sign_in_steps extends TestSetup{

	HomePage homePage = new HomePage(driver);
	SignInPage signInPage;
	private static final Logger log = Log.getLogger(Sign_in_steps.class);

@Given("^I am in home page$")
public void i_am_in_home_page() throws Throwable {
	homePage.getUrl(Config.testConfig.getProperty("url"));
}

@Then("^I can see the sign in option$")
public void i_can_see_the_sign_in_option() throws Throwable {
	Verifier.verifyTrue(homePage.signInPresent(), "Sign in option present");
	log.info("Sign in option present");
}

@Given("^I am in sign in page$")
public void i_am_in_sign_in_page() throws Throwable {
	signInPage = homePage.goToSignInPage();
	log.info("Navigated to sign in page");
}

@When("^I enter the user email as \"([^\"]*)\"$")
public void i_enter_the_user_email_as(String emailId) throws Throwable {
	signInPage.enterEmail(emailId);
	signInPage.continueToPassword();
	log.info("Email entered successfully");
}

@When("^I enter the password as \"([^\"]*)\"$")
public void i_enter_the_password_as(String password) throws Throwable {
	signInPage.enterPassword(password);
	log.info("Password entered successfully");
}

@When("^Click on sign in submit button$")
public void click_on_sign_in_submit_button() throws Throwable {
	signInPage.submitSignIn();
	log.info("Sign in submitted successfully");
}

@Then("^I am signed in to the website$")
public void i_am_signed_in_to_the_website() throws Throwable {
	signInPage.clickOnNavigationMenu();
	signInPage.setConditionalWait(setExplicitWait(driver),explicitWait);
	signInPage.waiForSignOutVisibility();
}


}