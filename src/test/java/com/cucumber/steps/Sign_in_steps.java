package com.cucumber.steps;

import static org.junit.Assert.assertTrue;
import com.cucumber.init.TestSetup;
import com.cucumber.pages.HomePage;
import com.cucumber.pages.SignInPage;
import com.cucumber.utility.Config;
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
	SignInPage signInPage = new SignInPage(driver);
	

@Given("^I am in home page$")
public void i_am_in_home_page() throws Throwable {
	homePage.getUrl(Config.testConfig.getProperty("url"));
}

@Then("^I can see the sign in option$")
public void i_can_see_the_sign_in_option() throws Throwable {
   assertTrue(homePage.signInPresent());
}

@Given("^I am in sign in page$")
public void i_am_in_sign_in_page() throws Throwable {
	homePage.goToSignInPage();
}

@When("^I enter the user email as \"([^\"]*)\"$")
public void i_enter_the_user_email_as(String emailId) throws Throwable {
	signInPage.enterEmail(emailId);
	signInPage.continueToPassword();
}

@When("^I enter the password as \"([^\"]*)\"$")
public void i_enter_the_password_as(String password) throws Throwable {
	signInPage.enterPassword(password);
}

@When("^Click on sign in submit button$")
public void click_on_sign_in_submit_button() throws Throwable {
	signInPage.submitSignIn();
}

@Then("^I am signed in to the website$")
public void i_am_signed_in_to_the_website() throws Throwable {
    assertTrue(signInPage.isItSignInPage());
}



}