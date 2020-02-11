package com.cucumber.pages;

import java.util.Arrays;
import java.util.Base64;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.cucumber.init.TestSetup;
import com.cucumber.utility.ConditionalWait;

/**
 * @author Renuka R Hosamani
 *
 * 
 */
public class SignInPage extends TestSetup{
	
	private final WebDriver driver;
	private ConditionalWait conditionalWaits;
	
	public WebDriver getDriver() {
		return driver;
	}

	public SignInPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="//*[@id='ap_email']")
	public WebElement emailTextbox;
	
	@FindBy(xpath="//*[@id='continue']")
	public WebElement continueEmailBtn;
	
	@FindBy(xpath="//*[@id='ap_password']")
	public WebElement passwordTextbox;
	
	@FindBy(xpath="//*[@id='signInSubmit']")
	public WebElement signInSubmitBtn;
	
	@FindBy(xpath="//*[@aria-label='Open Menu']")
	public WebElement navigationBar;
	
	@FindBy(xpath="//div[contains(text(),'Sign Out')]")
	public WebElement signOutMenuOption;
	
	public WebElement getNavigationBar() {
		return navigationBar;
	}

	public WebElement getSignOutMenuOption() {
		return signOutMenuOption;
	}

	public WebElement getEmailTextbox() {
		return emailTextbox;
	}

	public WebElement getContinueEmailBtn() {
		return continueEmailBtn;
	}

	public WebElement getPasswordTextbox() {
		return passwordTextbox;
	}

	public WebElement getSignInSubmitBtn() {
		return signInSubmitBtn;
	}

	public void enterEmail(String email) {		
		getEmailTextbox().sendKeys(email);
	}
	
	public void enterPassword(String password) {
		byte[] encryptedPassword = Base64.getDecoder().decode(password.getBytes());
		String decodedString = new String(encryptedPassword);
		getPasswordTextbox().sendKeys(decodedString);
	}
	
	public void submitSignIn() {
		getSignInSubmitBtn().click();
	}

	public void continueToPassword() {
		getContinueEmailBtn().click();
	}
	
	public boolean isItSignInPage() {
		return getSignOutMenuOption().isDisplayed();
	}
	
	public void setConditionalWait(WebDriverWait webdriverWait,long timeout) {
		conditionalWaits = new ConditionalWait(webdriverWait, timeout);
	}
	
	public void waiForSignOutVisibility() {	
		getNavigationBar().click();
		conditionalWaits.waitForElementVisibility(getSignOutMenuOption(), "SIGN-OUT MENU OPTION");
	}

}
