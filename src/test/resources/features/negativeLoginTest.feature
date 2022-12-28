Feature: Negative Login test - The user should NOT be able to login with invalid credentials

  Background: Go to home page login
    Given The user is on the login page

  @negativeScenario
  Scenario Outline: Negative Scenario-User should NOT be able to login with invalid credentials
    When The user enters "<invalidUsername>" and "<invalidPassword>" and click login button
    Then verify that invalid "<message>"

    Examples:
      | invalidUsername | invalidPassword | message                                |
      | laz ziya        |                 | Please fill out Username and Password. |
      |                 | lazziya         | Please fill out Username and Password. |
      |                 | invalidPassword | Please fill out Username and Password. |
      |                 |                 | Please fill out Username and Password. |
      | laz ziya        | invalidPassword | Wrong password.                        |
      | notExistUser    | invalidPassword | User does not exist.                   |
      | ktn21           | lazziya         | User does not exist.                   |