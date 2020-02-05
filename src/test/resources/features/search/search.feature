@search

Feature: Search

Scenario Outline: Search for a product and get the details of a specific product from search results
Given I am in home page
When I search for the product "<product>"
And I click on the product "<product_name>"
Then I can see the "<price>" and "<reviews>" of the selected product

Examples:
	| product 		| product_name 																																						 																								 | price  		| reviews |
	| arris modem | ARRIS Surfboard Docsis 3.1 Gigabit Cable Modem Plus AC2350 Dual Band Wi-Fi Router, Certified for Xfinity, and Cox 1 GB Service (SBG8300) | $257.99		| average	|
	| led tv			| LG Electronics 24LH4830-PU 24-Inch Smart LED TV (2016 Model) 																																						 | $111.99	  |	good		|
