@BestAnswer @Sanity
  Feature: Mark Best Answer
  
  
  Background: 
    Given the application is loaded on http://localhost:8080
    Scenario Outline: Marking the best Answer
      Given User logged in
      When User have authorization
      And Navigate to Question page
      Then User marked best reply

     
    Scenario Outline: Marking the best answer
      Given User is not logged in
      When User not have authorization
      Then User navigate to Login Page or registration page

 