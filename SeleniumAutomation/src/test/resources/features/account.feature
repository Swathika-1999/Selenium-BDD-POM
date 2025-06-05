Feature: Account Creation and Login

  Scenario: User creates an account and logs in
    Given user launches the browser
    When user navigates to Magento homepage
    And user creates a new account with valid details
    And user logs into the application
    Then browser is closed

  Scenario: Try to create an account without filling fields
    Given user launches the browser
    When user navigates to Magento homepage
    And user clicks create account with empty form
    Then error message should be shown
    Then browser is closed

  Scenario: Try to create account with invalid email
    Given user launches the browser
    When user navigates to Magento homepage
    And user enters invalid email while creating account
    Then error message should be shown
    Then browser is closed

  Scenario: Try to login with incorrect password
    Given user launches the browser
    When user navigates to Magento homepage
    And user tries to login with invalid password
    Then login error should be shown
     Then browser is closed
