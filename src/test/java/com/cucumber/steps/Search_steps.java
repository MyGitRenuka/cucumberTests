package com.cucumber.steps;

import static org.junit.Assert.assertTrue;
import com.cucumber.init.TestSetup;
import com.cucumber.pages.HomePage;
import com.cucumber.pages.ProductPage;
import com.cucumber.pages.ProductsPage;
import com.cucumber.pages.SignInPage;
import com.cucumber.utility.Config;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

/**
 * @author Renuka R Hosamani
 *
 * 
 */
public class Search_steps extends TestSetup {
		
	ProductPage product = new ProductPage(driver);
	
	@When("^I search for the product \"([^\"]*)\"$")
	public void i_search_for_the_product(String prod) throws Throwable {
		product.enterSearchText(prod);
		product.clickSearch();
	}

	@When("^I click on the product \"([^\"]*)\"$")
	public void i_click_on_the_product(String prod) throws Throwable {
		assertTrue(product.isProductInTheList(prod));
		product.clickOnProduct(prod);
	}

	@Then("^I can see the \"([^\"]*)\" and \"([^\"]*)\" of the selected product$")
	public void i_can_see_the_and_of_the_selected_product(String price, String reviews) throws Throwable {
		
		assertTrue(product.verifyPrice(price));
		assertTrue(product.verifyRating(reviews));
		 
	}
	
}
