@Answer @Sanity
Feature: Answer
  Use cases on questions page

  Background: 
    Given the application is loaded on http://localhost:8080
    And the user is logged in
    And is on questions page
    And question not posted by user

  Scenario Outline: User wants to answer a question
    Given the question is open
    When user wants to give answer "<answer>" for question "<question>"
    Then post the answer
    And Enable edit answer button

    Examples: 
      | answer  | question  |
      | answer1 | question1 |
      | answer2 | question2 |

  Scenario Outline: Required fields missing
    When user post an empty answer
      | answer |
      |        |
    Then show required field can not be empty
