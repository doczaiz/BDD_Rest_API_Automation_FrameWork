Feature: Create a token to use for access to the PUT and DELETE /booking
  @Integration
  Scenario: Create a token successful
    Given the endpoint for creating a token
    When I send a post request with userName and password
    Then the response status code and token should be displayed

  @Integration
  Scenario Outline: the user should not be able to create a token with out credentials
    Given the endpoint for creating a token
    When I send a post request with wrong credentials:
      | username   | password   |
      | <username> | <password> |
    Then the response status code to create a token should be 200
    And the reason message should be displayed <reason>

    Examples:
      | username  | password    | reason          |
      |           |             | Bad credentials |
      | wrongUser | wrongPass   | Bad credentials |
      | Admin     |             | Bad credentials |
      |           | password123 | Bad credentials |