@VoteAnswer @Sanity
Feature: Vote Comment of a answer
  User wants to up/down vode a answer not posted by the user

  Background: 
    Given the application is loaded on http://localhost:8080
    And user is logged in
    And has opened a question
    And the answer is not posted by the user

  Scenario Outline: User up-voted the answer
    When user clicks on up-vote
    And user has not already voted the answer
    Then increase vote count of the answer by 1
    And disable up-vote for the user for that answer

  Scenario Outline: User down-voted the answer
    When user clicks on down-vote
    And user has not already voted the answer
    Then decrease vote count of the answer by 1
    And disable down-vote for the user for that answer

  Scenario Outline: User up-voted the answer which was already down-voted by the user
    When user clicks on up-vote
    And user has already down-voted the answer before
    Then increase vote count of the answer by 2
    And disable up-vote for the user for that answer
    And enable down-vote for the user for that answer

  Scenario Outline: User down-voted the answer which was already up-voted by the user
    When user clicks on down-vote
    And user has already up-voted the answer before
    Then decrease vote count of the answer by 2
    And disable down-vote for the user for that answer
    And enable up-vote for the user for that answer