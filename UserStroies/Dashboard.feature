@Dashboard @Sanity
Feature: Viewing user dashboard 

   Background: 
    Given the application is loaded on http://localhost:8080
    And the user is logged in
  Scenario: 
    When viewing his dashboard
    Then his/her profile including name, email, social links
    And display a list of few questions and comments

  Scenario: 
    When viewing his dashboard
    And the user clicks on myQuestions button
    Then display his/her all the questions

  Scenario: 
    When viewing his dashboard
    And the user clicks on myComments button
    Then display his/her all comments