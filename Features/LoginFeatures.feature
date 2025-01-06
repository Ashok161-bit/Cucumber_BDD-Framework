 Feature: Login

Scenario: Successful Login in with Valid Credentials
    Given User Launch Chrome browser
    When  User opens URL "https://admin-demo.nopcommerce.com/login"
    And   User enters Email as"admin@yourstore.com" and Password as"admin"
    And   Click on Login
    Then  Page Title should be "Dashboard / nopCommerce administration"
    When  user click on Log out link
    Then  Page Title should be "your store. Login"
    And   close browser 
    
 Scenario: Login with DataDriven
    Given User Launch Chrome browser
    When  User opens URL "https://admin-demo.nopcommerce.com/login"
    And   User enters Email as"<email>" and Password as"<password>"
    And   Click on Login
    Then  Page Title should be "Dashboard / nopCommerce administration"
    When  user click on Log out link
    Then  Page Title should be "your store. Login"
    And   close browser 
    
    Examples:
     |email| |password|
     |admin@yourstore.com| |admin|
     |admin@yourstore.comss| |admin134|
     