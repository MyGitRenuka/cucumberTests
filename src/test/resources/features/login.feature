@login
Feature: Sign in
	As a registered user 
	I want to sign in to the application
	
Background: 
	Given I am in home page
	Then I can see the sign in option
	
	Scenario: Sign in to the website using valid credentials
	Given I am in sign in page
	When I enter the user email as "user@gmail.com"
	And I enter the password as "password"
	And Click on sign in submit button
	Then I am signed in to the website