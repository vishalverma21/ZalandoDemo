@zalando 
Feature: Move The Item To Wishlist 

Background: 
	Given login with valid credentials 
	Then HomePage should be visible 
	
@zalando 
Scenario Outline: Validate Wishlist 
	Given Go to the Search box and search for <article> 
	When Add item to the cart 
	And Go to the cart and change the <quantity> of item 
	And Move the items from the basket to the wishlist 
	Then Verify item is moved to the wishlist 
	
	##Positive flow with valid article and valid quantity
	##Any article number can be provided in below example with quantity
	@Sanity
	Examples: 
		| 	 article   	 | quantity   |
		| DK151H09R-Q11  | 	 2  	  |
	
	##Negative flow with valid and invalid article with invalid and valid quantity
	@Negative
	Examples: 
		| 	 article   	 | quantity   |
		| DK151H09R-Q11  | 	 12  	  |
		| DK151H09R-Q12 | 	 2  	  |
		
