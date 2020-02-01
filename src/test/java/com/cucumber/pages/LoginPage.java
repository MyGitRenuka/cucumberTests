package com.cucumber.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * @author Renuka R Hosamani
 *
 * 
 */
public class LoginPage {
	
private final WebDriver driver;
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
		
	@FindBy(xpath="//input[@name='userName']")
	public WebElement user;
	
	@FindBy(xpath="//input[@name='password']")
	public WebElement password;

	@FindBy(xpath="//input[@alt='Login']")
	public WebElement submit;
	
	@FindBy(xpath="//*[contains(@href,'mercurysignoff.php')]")
	public WebElement signOff;
	
	
	public void getUrl(String url) {
		driver.get(url);
	}
	public WebElement getSignOff() {
		return signOff;
	}
	public WebElement getSubmit() {
		return submit;
	}

	public void submit() {
		getSubmit().click();
	}

	public WebElement getPassword() {
		return password;
	}

	public void enterPassword(String password) {
		getPassword().sendKeys(password);
	}

	public WebElement getUser() {
		return user;
	}

	public void enterUsername(String user) {
		getUser().sendKeys(user);
	}
	
}
