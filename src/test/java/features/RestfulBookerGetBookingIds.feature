Feature: Retrieve RestfulBooker Booking Ids
  @SmokeTest
  Scenario: Retrieve booking Ids successful
    Given the API endPoint for getting booking
    When I send a get request
    Then the status code must be 200
    And I should retrieve booking Ids

  @SmokeTest
  Scenario Outline: Retrieve booking first names successful
    Given the API endPoint for getting booking
    When I send request to retrieve first and last name by providing booking <Id>
    Then status code should equal to 200
    And I should retrieve booking first name <firstName> and last name <lastName>
    Examples:
      | Id | firstName | lastName |
      | 1  | Eric      | Ericsson |
      | 2  | Jim       | Smith    |
      | 10 | Josh      | Allen    |
#      | 0   | Josh      | Allen    |

