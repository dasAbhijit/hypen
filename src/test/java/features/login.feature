Feature: Login
  Description: The purpose of this feature is to test Login functionality.

  @Login
  Scenario Outline: Login
    Given user is on "<Login Page>"
    When user enters email "<Email Address>"
    And user clicks on send me a verification code button
    And user enters verification code "<Verification Code>"
    And user clicks on login button
    Then ensure user is logged in

    Examples:
      | Login Page                 | Email Address             | Verification Code |
      | https://app.gethyphen.com/ | hyphen_admin@acmetest.com | 34067             |