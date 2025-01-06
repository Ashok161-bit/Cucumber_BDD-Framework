
Feature: Customer

 Background: Steps common for all scenrios
  Given User Launch Chrome browser 
	  When User opens URL "http://admin-demo.nopcommerce.com/login" 
	  And User enters Email as "admin@yourstore.com" and Password as "admin" 
	  And Click on Login 
	  Then User can view Dashboad 
	
	
  Scenario: Add New Customer
   
   
    When  user click on customer menu
    And   click on customer Menu Item
    And   click on Add new button
    Then  user can view Add new Customer Page
    When  user  enter custmer Info
    And   click on save button
    Then  user can view confirmation message"The new customer has been added successfuly"
    And   close broswer
    
   Scenario: Search Customer by Email
	
	When User click on customers Menu 
	And click on customers Menu Item 
	And Enter customer EMail
	When Click on search button
	Then User should found Email in the Search table
	And close browser 
	
	
	Scenario: Search Customer by Name
	
	When User click on customers Menu 
	And click on customers Menu Item 
	And Enter customer FirstName
	And Enter customer LastName
	When Click on search button
	Then User should found Name in the Search table
	And close browser 