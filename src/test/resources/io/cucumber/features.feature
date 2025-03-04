Feature: Login

  Scenario Outline: Login in the app

    Given <displayName> is on the login page
    When <displayName> enters <username> and <password>
    And <displayName> clicks on the login button
    Then <displayName> should be redirected to the home page

    Examples:

      | username | password | displayName  |
      | user1    | a        | "Joeh Smith" |