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
public class ProductsPage extends HomePage{
	
	private WebDriver driver;
		
	public ProductsPage(WebDriver driver) {
		super(driver);
		this.driver=getDriver();
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//h2/a/span[@dir='auto']")
	public List<WebElement> productLinks;

	public List<WebElement> getProductLinks() {
		return productLinks;
	}
	
	public boolean isProductInTheList(String product) {

		List<WebElement> list_of_prods = getProductLinks();
		
		for(WebElement ele: list_of_prods)
		{
			if(product.equals(ele.getText())) {
				return true;
			}
			//System.out.println("\n" + ele.getText() +".........................................");
		}
		return false;
	}

	public void clickOnProduct(String product) {
		
		List<WebElement> list_of_prods = getProductLinks();
		
		for(WebElement ele: list_of_prods)
		{
			if(product.equals(ele.getText())) {
				ele.click();
				break;
			}
		}
	}
			
}
