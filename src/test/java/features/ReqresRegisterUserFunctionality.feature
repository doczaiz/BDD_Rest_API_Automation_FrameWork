Feature: Register a User

  @SmokeTest
  Scenario Outline: Successful registration with valid email and password
    Given the API endpoint for register a user
    When the client sends a POST request with the following user details email <email> and password <password>
    Then the response status code must be <statusCode>
    And the response should contain a user ID
    Examples:
      | email              | password   | statusCode |
      | eve.holt@reqres.in | cityslicka | 200        |


  @SmokeTest

  @Rachidd
  Scenario Outline: Unsuccessful registration without valid email and password
    Given the API endpoint for register a user
    When the client sends a POST request with the following user details email <email> and password <password>
    Then the response status code must be <statusCode>
    And the response should contain an error message <errors>
    Examples:
      | email              |  | password   | statusCode | errors                                        |
      |                    |  | cityslicka | 400        | Missing email or username                     |
      | eve.holt@reqres.in |  |            | 400        | Missing password                              |
      |                    |  |            | 400        | Missing email or username                     |
      | test@test.com      |  | test       | 400        | Note: Only defined users succeed registration |
      | t                  |  | t          | 400        | Note: Only defined users succeed registration |
      |                    |  |            | 400        | Missing email or username                     |