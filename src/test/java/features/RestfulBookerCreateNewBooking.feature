Feature: Creates a new booking in the API

  @SmokeTest
  Scenario Outline: Creates a new booking in the API successful
    Given the API endpoint for creating a new booking
    When I send a Post request to create a new booking
    Then the response status code for create a new booking must be 200
    And the response body should contains this deatails:
      | firstname   | lastname   | checkIn   | checkout   |
      | <firstname> | <lastname> | <checkIn> | <checkout> |
    Examples:
      | firstname | lastname | checkIn    | checkout   |
      | Rachid    | Zaiz     | 2024-01-01 | 2024-01-03 |