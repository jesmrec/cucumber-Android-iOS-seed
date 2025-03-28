Feature: Login

  Scenario: Login in the app

    Given Alice is on the login page
    When Alice enters the server URL
    And Alice clicks on the login button
    Then Alice should be redirected to the home page
    And Alice should see the folder named TestForE2EAuto