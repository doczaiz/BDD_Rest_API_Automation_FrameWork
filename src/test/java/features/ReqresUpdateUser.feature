Feature: Update User Details
  @SmokeTest
  Scenario Outline: The user should be able to update name and job title
    Given the API endpoint to update a user details
    When the client sends a Put request with the following user details name <name> and job <job>
    Then the response status-code must be <code>
    And the response should contain an update time reference message <updateTime>
    Examples:
      | name   | job  | code | updateTime |
      | Rachid | SDET | 200  | updatedAt  |

  @SmokeTest
  Scenario Outline: The User should be able to update Name
    Given the API endpoint to update a user details
    When the client sends a Put request with the following user name <name>
    Then the response status-code must be <code>
    And the response should contain an update time reference message <updateTime>
    Examples:
      | name | code | updateTime |
      | Joud | 200  | updatedAt  |
      | Adam | 200  | updatedAt  |
      |      | 200  | updatedAt  |

  @SmokeTest
  Scenario Outline: The User should be able to update Job
    Given the API endpoint to update a user details
    When the client sends a Put request to update job title <job>
    Then the response status-code must be <code>
    And the response should contain an update time reference message <updateTime>
    Examples:
      | job    | code | updateTime |
      | Pilot  | 200  | updatedAt  |
      | Doctor | 200  | updatedAt  |
      |        | 200  | updatedAt  |