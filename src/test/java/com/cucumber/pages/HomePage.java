package com.cucumber.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.cucumber.init.TestSetup;

public class HomePage extends TestSetup{
	
	private final WebDriver driver;
	
	public WebDriver getDriver() {
		return driver;
	}

	public void getUrl(String url) {
		driver.get(url);
	}
	
	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//*[@id='nav-link-accountList']/span[1]")
	public WebElement SignIn;
	
	public WebElement getSignIn() {
		return SignIn;
	}
	
	public void goToSignInPage() {
		getSignIn().click();		
	}
	
	public boolean signInPresent() {
		return getSignIn().isDisplayed();
	}

}
