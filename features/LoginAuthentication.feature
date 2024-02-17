Feature: Validating the Authentication feature

  Scenario: Testing the login functionality with valid credentials

    Given User navigates to swaglabs website
    When User enters valid credentials and enter login
    Then User is successfully logged in