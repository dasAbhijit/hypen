Feature: Post
  Description: The purpose of this feature is to test Post functionality.

  @CreateNewPost
  Scenario Outline: Create New Post
    Given user is on "<Login Page>"
    And user logs in with "<Email Address>" and "<Verification Code>"
    When user clicks on create new post button
    And user clicks on Open button
    And user selects an option from dropdown
    And user clicks on select button
    And user types "<Text>" opinion or question or feedback
    And user clicks on publish button
    Then user should be able to create post

    Examples:
      | Login Page                 | Email Address             | Verification Code | Text      |
      | https://app.gethyphen.com/ | hyphen_admin@acmetest.com | 34067             | test text |

