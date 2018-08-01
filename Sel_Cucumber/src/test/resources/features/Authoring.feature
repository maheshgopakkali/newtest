Feature: The automation practice login test 

@Valid
Scenario Outline: Test login with invalid credentials 
	Given Opne chrome and start app 
	When User clicks on signin button 
	Then User provides valid "<email>" and "<password>" 
	Then User clicks on submit button 
	Then User logged in successfully 
	
	Examples: 
		| email | password |
		| ashish@gmail.com | ashish1 |
		
		
		
 
 @Invalid
 Scenario Outline: Test login with valid credentials 
	Given Opne chrome and start app 
	When User clicks on signin button 
	Then User provides valid email "<email>"
	Then User provides valid password "<password>" 
	Then User clicks on submit button 
	Then User did not log in successfully
	
	Examples: 
		| email | password |
		| ashish@gmail.com | ashish |
		
@Search
Scenario Outline: User searches for some string in homepage
Given Opne chrome and start app
When "<User>" enters search text and clicks search button
Then search results should be displayed correctly

Examples:
|User|
|Ashish|
|Bittu|