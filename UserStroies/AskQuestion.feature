@Login @Sanity
Feature: Ask Question
  Used when user wants to ask question on the app

  Background: 
    Given the application is loaded on http://localhost:8080
    When the user clicks on the "Ask Question"button in the homescreen
    Then the user will be redirected to the new window to ask question

  Scenario Outline: The user ask question
    Given the user is logged in successsfully
    And enters a question title in "<title>"
    And enters his question in the question description "<despcrption>"
    When the user clicks on "Post the question"
    Then the question will be posted on the homepage
    And the user will be redirected to the homepage

    Examples: 
      | title        | descritpion                           |
      | what is java | details about what is the exact query |

  Scenario Outline: the field is missing
    When the user ddinot enter the title or description
    Then the user will see a field missing alert
      | title            | descrption |
      |                  | detaills   |
      | why we use java? |            |
      |                  |            |
      
    Scenario Outline:  The user is not loggged in
    Given the user is not logged in
    When the user clicks on "Post the question"
    Then the user is redirected to the login page
