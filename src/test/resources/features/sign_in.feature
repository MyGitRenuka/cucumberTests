@Sign_in
Feature: Sign in
	As a guest 
	I want to sign in to the application
	
Background: 
	Given I am at the sign-in page
	Then I can see the submit option
	
	Scenario: Sign in to the website
	When I enter my username as "guest"
	And I enter password as "guest"
	And Click on submit button
	Then I am logged on to the website
	
	Scenario Outline: Sign in as guest user
	When I enter my username as "<username>"
	And I enter password as "<password>"
	And Click on submit button
	Then I am logged on to the website
	
	 Examples: 
      | username | password |
      | guest    | guest 		|
 