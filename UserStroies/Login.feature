@Login @Sanity
Feature: Login
  Use cases in login page

  Background: 
    Given the application is loaded on http://localhost:8080
    And the user clicks on"Login" button on the top right corner

  Scenario Outline: On successfull login
    Given user enters his valid email as "<email>"
    And password as "<password>"
    When the user clicks on login button
    Then the popup of successful login is displayed
    And the user redirected to the home page

    Examples: 
      | email             | password    |
      | akshit@admin.com  | admin@123   |
      | prateek@gmail.com | parteek%321 |

  Scenario Outline: On unsuccessful login
    Given the user enters invalid email/password
    When the user clicks on "login" button
    Then the message of error will be displayed as invalid credentials

    Examples: 
      | email      | password     |
      | akshit@min | password@123 |
