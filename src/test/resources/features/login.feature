Feature: Login Test- The user should be able to login with valid credentials


  Background: Go to home page login
    Given The user is on the login page

  @wip
  Scenario:Positive Scenario 1 - user should be able to login
    When The user enters valid credentials
    Then verify "Welcome laz ziya"

  @wip2
  Scenario: Positive Scenario 2 - user should be able to login
    When The user enters "laz ziya" and "lazziya" and click login button
    Then verify "Welcome laz ziya"

  @loginWithScenarioOutline
  Scenario Outline: Positive Scenario 3 - user should be able to login
    When The user enters "<username>" and "<password>" and click login button
    Then verify "<welcomeUser>"

    Examples:
      | username | password | welcomeUser      |
      | laz ziya | lazziya  | Welcome laz ziya |


  @loginWithDataTableAndScenarioOutline
  Scenario Outline: Positive Scenario 4 - user should be able to login
    When The user enters valid username and password
      | username | <user>     |
      | password | <password> |
    Then verify "<welcomeUser>"

    Examples:
      | user         | password | welcomeUser          |
      | laz ziya     | lazziya  | Welcome laz ziya     |
      | KayitOlArtik | 123456AA | Welcome KayitOlArtik |
      | ktb2         | Test1234 | Welcome ktb2         |