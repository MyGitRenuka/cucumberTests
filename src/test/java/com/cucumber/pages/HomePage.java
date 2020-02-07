package com.cucumber.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.cucumber.init.TestSetup;

/**
 * @author Renuka R Hosamani
 *
 * 
 */
public class HomePage {
	
	private WebDriver driver;
	
	public WebDriver getDriver() {
		return this.driver;
	}

	public void getUrl(String url) {
		this.driver.get(url);
	}
	
	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//*[@id='nav-link-accountList']/span[1]")
	public WebElement SignIn;
	
	@FindBy(xpath="//*[@id='twotabsearchtextbox']")
	public WebElement searchTextbox;
	
	@FindBy(xpath="//*[@value='Go']")
	public WebElement searchSubmit;
			
	
	public WebElement getSearchSubmit() {
		return searchSubmit;
	}

	public ProductsPage goToProductsPage() {
		getSearchSubmit().click();
		return new ProductsPage(driver);
	}
		
	public WebElement getSearchTextbox() {
		return searchTextbox;
	}

	public void enterSearchText(String searchFor) {
		getSearchTextbox().sendKeys(searchFor);
	}
	
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
