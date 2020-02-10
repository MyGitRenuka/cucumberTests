package com.cucumber.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.cucumber.validations.Verifier;

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
		
		Verifier.verifyElementDisplayed(getSalePrice(),"Product price");
	}
	
	public void reviewDisplayed() {
		Verifier.verifyElementDisplayed(getRatings(),"Review rating");
	}
			
	public void verifyPrice(String price) {
		String message = "Actual and expected sale price are same";
		log.info("Expected price is " + price + " and actual price is " + getSalePrice().getText());
		Verifier.verifyText(price, getSalePrice().getText(),message);
	}
	
	public void verifyRating(String rating,String ratingFromJson) {
		
		Verifier.verifyTrue(getRatings().getAttribute("textContent").contains(ratingFromJson), 
				"Actual and expected review ratings are same");
	}
	
}

