package com.cucumber.steps;

import com.cucumber.init.TestSetup;
import com.cucumber.pages.HomePage;
import com.cucumber.pages.ProductPage;
import com.cucumber.pages.ProductsPage;
import com.cucumber.utility.Config;
import com.cucumber.utility.JsonReader;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.testng.Assert;

/**
 * @author Renuka R Hosamani
 *
 * 
 */
public class Search_steps extends TestSetup {
		
	ProductPage product;
	ProductsPage products;
	HomePage homePage = new HomePage(driver);
	JsonReader jsonReader = new JsonReader(Config.testConfig.getProperty("searchTestFile"),
								Config.testConfig.getProperty("searchTestFilePath"));
	
	@When("^I search for the product \"([^\"]*)\"$")
	public void i_search_for_the_product(String prod) throws Throwable {
		homePage.enterSearchText(prod);
		products = homePage.goToProductsPage();
	}

	@When("^I click on the product \"([^\"]*)\"$")
	public void i_click_on_the_product(String prod) throws Throwable {
		products.isProductInTheList(prod);
		product = products.goToProductPage(prod);
	}

	@Then("^I can see the price \"([^\"]*)\" and review \"([^\"]*)\" of the selected product$")
	public void i_can_see_the_price_and_review_of_the_selected_product(String price, String reviews) throws Throwable {
		
		product.priceDisplayed();
		product.reviewDisplayed();
		product.verifyPrice(price);
		product.verifyRating(reviews,jsonReader.getValue(reviews));
	}
	
}
