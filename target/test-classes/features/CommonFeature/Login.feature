@login @Web 
Feature: This is login feature 

@validLogin 
Scenario: Testing with valid credentials
	Given login with valid credentials 
	Then HomePage should be visible
