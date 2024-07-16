Feature: Updates a current booking

  @Integration
  Scenario Outline: Updates an existing booking in the API successfully
    Given the API endpoint for updating a booking
    When I send a Put request to update a booking with <firstname>, <lastname>, <checkIn>, and <checkout>
    Then the response status code for updating a booking must be 200
    And the response body should contain the updated details:
      | firstname   | lastname   | checkIn   | checkout   |
      | <firstname> | <lastname> | <checkIn> | <checkout> |
    Examples:
      | firstname | lastname | checkIn    | checkout   |
      | Joud      | Zaizouny | 2024-01-01 | 2024-01-03 |

  @Integration
  Scenario Outline: Partial Update Booking
    Given the API endpoint for updating a booking
    When I send a Patch request to update a booking with <firstname> and <lastname>
    Then the response status code for updating a booking must be 200
    And the response body should contain the partial updated details:
      | firstname | lastname |
      | <firstname>  | <lastname> |
    Examples:
      | firstname | lastname |
      | Danial    | Adam     |
