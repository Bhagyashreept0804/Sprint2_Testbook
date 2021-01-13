##Author : bhagyashree-jagannath.patil@capgemini.com


@transactionsBAP
Feature: billings and payments
  I want to purchase pass wiht different payment options

	@courses
	Scenario: payment options through courses
			Given user on testbook pass page
			When purchased through courses
			Then payments options should displayed


	@passbtndisp
	Scenario: Get Pass button display
			Given user is on testbook home page
			Then get pass button is displayed

	@getpassclick
	Scenario: view purchase plan
			Given user is on testbook buy page
			When click on get pass
			Then able to view all purchase plan
    
	@paymentplans  
	Scenario: View Payment options
			Given user is on testbook pass page
			When click on buy pass
			Then able to view different payment options
    
	@creditdetails    
	Scenario Outline: Users should be able to update his valid Card details.
			Given user select card payment option
			When enter details of<cardname><cvv><ex_Date>
			Then able to pay
    
			Examples: 
	    | cardname      | cvv | ex_Date  |
      | 123456789012  | 322 | 1123     |
      
  
      
      
