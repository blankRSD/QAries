@closeQuestion @Sanity
  Feature: User Closed Question
  
   Background: 
    Given the application is loaded on http://localhost:8080
    
    Scenario Outline: Question Can Close
      Given User logged in
      When User have authorization
      And navigate to question page
      Then User Closed the question

    
    Scenario Outline: Question Can not close the question
      Given User logged in
      When User not have authorization
      Then User can't close

  