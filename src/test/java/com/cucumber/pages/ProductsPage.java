package com.cucumber.pages;

import java.util.List;
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
public class ProductsPage {
	
	private WebDriver driver;
	private static Logger log = Logger.getLogger(ProductsPage.class);

	public ProductsPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//h2/a/span[@dir='auto']")
	public List<WebElement> productLinks;

	public List<WebElement> getProductLinks() {
		return productLinks;
	}
	
	public void isProductInTheList(String product) {

		List<WebElement> list_of_prods = getProductLinks();
		boolean flag=false;
		String message= "Product \"" +  product + " \" is in the search result"; 		
		for(WebElement ele: list_of_prods)
		{
			if(product.equals(ele.getText())) {
				flag=true;
				break;
			}
		}
		if(flag)
			Verifier.verifyTrue(true, message);
		else
			Verifier.verifyTrue(false, message);
		
	}

	public ProductPage goToProductPage(String product) {
		
		List<WebElement> list_of_prods = getProductLinks();
		
		for(WebElement ele: list_of_prods)
		{
			if(product.equals(ele.getText())) {
				ele.click();
				break;
			}
		}
		
		return new ProductPage(driver);
	}
			
}
