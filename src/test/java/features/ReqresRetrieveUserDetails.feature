Feature: Retrieve user details

  @Integration
  Scenario Outline: Retrieve a single user details
    Given the API endpoint to retrieve a user details
    When the user send Get request to retrieve a single user details
    Then the response should contains the following details <Id>,<first_name>,<last_name> and <email>
    Examples:
      | Id | first_name | last_name | email                  |
      | 2  | Janet      | Weaver    | janet.weaver@reqres.in |

  @Integration
    Scenario Outline: Retrieve list users details
      Given the API endpoint to retrieve a user details
      When the user send Get request to retrieve a list users details
      Then the response status code has to be equal to <code>
      And the response must contains the following details id <Id> first name <first_name> last name <last_name> email <email> and index <index>
      Examples:
        | index | Id | first_name | last_name | email                      | code |
        | 0     | 7  | Michael    | Lawson    | michael.lawson@reqres.in   | 200  |
        | 1     | 8  | Lindsay    | Ferguson  | lindsay.ferguson@reqres.in | 200  |
        | 3     | 10 | Byron      | Fields    | byron.fields@reqres.in     | 200  |

  @Integration
Scenario: Retrieve list users with different approach
    //different approach
  Given the API endpoint to retrieve a user details
  When the user send Get request to retrieve a list users details
  Then the response status code has to be 200
  And validate output details of payload


