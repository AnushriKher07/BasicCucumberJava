@SmokeScenario
Feature: feature to test login functionality of Parabank app

  
  Scenario Outline: Check Login functionality with valid/invalid credentials
    Given user is on login page
    When user enters: "<username>" and "<password>"
    And clicks on login page
    Then User is navigated to Homepage
    Then close the browser
    
        Examples: 
      | username | password  |
      | Test_1    | Pass@123 |
      | Test_2    | Pass@123 |
      | Test_3    |Pass@1234|
    
    
    #Scenario: Check Login is successfull with valid credentials
    #Given user is on login page
    #When user enters username and password
    #And clicks on login page
    #And close the browser
    #
  
  