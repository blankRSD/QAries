@Registration @Sanity
Feature: Registration
  Used in registration page

  Background: 
    Given the application is loaded on http://localhost:8080
    And click on "SignUp" button on top right corner

  Scenario Outline: On successful registration
    Given the user enters valid name as "<name>"
    And email "<email>"
    And password "<password>"
    When the user click on submit button
    Then the user will get a message of successul  registration

    Examples: 
      | name        | email            | password   |
      | Akshit      | akshit@admin.com | admin@123  |
      | Raj Shekhar | raj@admin.com    | superadmin |

  Scenario Outline: On unsuccessfull registration
    Given the user enters invalid data
    When the user clicks on submit button
    Then the user will get invalid email message

    Examples: 
      | email          |
      | humanresources |
      | kgp@123        |
