package com.cucumber.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.cucumber.init.TestSetup;
import com.cucumber.utility.Config;

/**
 * @author Renuka R Hosamani
 *
 * 
 */
public class ProductPage extends ProductsPage {
	
	private WebDriver driver;
	
	public WebDriver getDriver() {
		return this.driver;
	}
	public ProductPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//*[@id='priceblock_ourprice' or @id='priceblock_saleprice']")
	public WebElement salePrice;
	
	@FindBy(xpath="//*[@id='centerCol']//*[@id='acrPopover']/span[1]/a/i[1]")
	public WebElement ratings;

	public WebElement getSalePrice() {
		return salePrice;
	}

	public WebElement getRatings() {
		return ratings;
	}
	
	public boolean verifyPrice(String price) {
		return getSalePrice().getText().equals(price);
	}
	
	public boolean verifyRating(String rating) {
		return getRatings().getAttribute("textContent").contains(Config.testConfig.getProperty(rating));
	}
}

