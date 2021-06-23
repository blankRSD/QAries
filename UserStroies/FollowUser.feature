@Follow @Sanity
  Feature: Follow Users
  
  Background: 
    Given the application is loaded on http://localhost:8080
  
  
    Scenario Outline: Follow Threw Button
      Given User logged in
      When User clicked button
      Then User start following

     

    Scenario Outline: Follow Threw Button
      Given User is not logged in
      When User clicked button
      Then User navigate to Login Page or registration page