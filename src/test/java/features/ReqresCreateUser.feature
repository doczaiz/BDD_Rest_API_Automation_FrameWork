Feature: Create a User

  @SmokeTest
  Scenario: I should be able to create a user successful
    Given the API endpoint for creating a user
    When I send a Post request to create a user
    Then the status code should be 201
    And the response should contain name and job

