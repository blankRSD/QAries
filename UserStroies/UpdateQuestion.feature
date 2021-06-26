@Update @Sanity
Feature: UpdateQuestion
  Use cases on questions page

  Background: 
    Given the application is loaded on http://localhost:8080
    And the user is logged in
    And is on questions page
    And question is posted by user

  Scenario Outline: User wants to delete the  question
    When user wants to delete question 
    Then delete the question
    And delete its answers
    And delete its comments
    
   
 
    Scenario Outline:User wants to edit the  question
    When the ser wants to edit the question 
    And clicks on "Edit" button
    Then update the given question is updated with the new question
    
 
    

    