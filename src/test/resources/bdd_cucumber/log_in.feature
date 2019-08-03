Feature: Log In
  Log in to Jira

  Scenario Outline: We're logged out yet.
    Given I am on the Jira login page
    When Type the "<username>" to the username field
    When Type the "<password>" to the password field
    Then We have to be logged in

    Examples:
      | username | password        |
      | userke   | CodeCanvas19.   |
      | user1    | sajopeti        |
      | user1    | CodeCanvas19.   |