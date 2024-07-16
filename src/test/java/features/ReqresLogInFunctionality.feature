Feature:login successful Functionality

  @SmokeTest
  Scenario Outline: User should be able to login successful with a valid credentials
    Given the API endpoint for login
    When I send a POST request with the email <email> and password <password>
    Then the response status code should be <statusCode>
    And the response body should contain a valid token
    Examples:
      | email              | password   | statusCode |
      | eve.holt@reqres.in | cityslicka | 200        |


  @SmokeTest
  Scenario Outline: User should not be able to login without a valid credentials
    Given the API endpoint for login
    When I send a POST request with the email <email> and password <password>
    Then the response status code should be <statusCode>
    And the response body should contain an error message <errors>
    Examples:
      | email              |  | password   | statusCode | errors                    |
      |                    |  | cityslicka | 400        | Missing email or username |
      | eve.holt@reqres.in |  |            | 400        | Missing password          |
      |                    |  |            | 400        | Missing email or username |
      | test@test.com      |  | test       | 400        | user not found            |
      | t                  |  | t          | 400        | user not found            |
      |                    |  |            | 400        | Missing email or username |
