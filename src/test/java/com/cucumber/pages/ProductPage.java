package com.cucumber.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import com.cucumber.utility.Config;

/**
 * @author Renuka R Hosamani
 *
 * 
 */
public class ProductPage {
	
	private WebDriver driver;
	private static Logger log = Logger.getLogger(ProductPage.class);
		
	public WebDriver getDriver() {
		return this.driver;
	}
	public ProductPage(WebDriver driver) {
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
	
	public void priceDisplayed() {		
		Assert.assertTrue(getSalePrice().isDisplayed(),"Product price is displyed");
		
	}
	
	public void reviewDisplayed() {
		Assert.assertTrue(getRatings().isDisplayed(),"Review rating is displayed");
	}
			
	public void verifyPrice(String price) {
		boolean cond = getSalePrice().getText().equals(price);
		log.info("Expected price is " + price + " and actual price is " + getSalePrice().getText());
		Assert.assertTrue(cond, "Actual and expected price are same");
	}
	
	public void verifyRating(String rating) {
		boolean cond = getRatings().getAttribute("textContent").contains(Config.testConfig.getProperty(rating));
		Assert.assertTrue(cond, "Actual and expected review ratings are same");
	}
	
}

