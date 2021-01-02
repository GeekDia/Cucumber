Feature: Login 
	As a user
	I want to login to application with my credentails
  	In order to use the application features.

Background: User navigates to Application URL
	Given I am on the login page URL "http://automationpractice.com/index.php?controller=authentication&back=my-account" 
	Then I should  see login page

@sanity	
Scenario: Sign in with valid credentials
	When I fill in username with "bdia.sne@yopmail.com" 
	And I fill in password with "admin123*" 
	And I clicked on Signin button 
	Then I should see the selfcare page 
	And The title of the page should be "My account - My Store" 
	
	
@sanity
Scenario Outline: Sign in with invalid credentials 
	When I fill in username with "<username>"
	And I fill in password with "<password>"
	And I clicked on Signin button 
	Then the error message shoul be "Authentication failed." 
	
	
	
	Examples: 
		|	username 		 |password      |
		| bdia.sne@gmail.com |456464546HGHm.|
		| bdia@gmail.com     |admin123*     |
		| bdia@gmail.com     |456464546HGHm.|