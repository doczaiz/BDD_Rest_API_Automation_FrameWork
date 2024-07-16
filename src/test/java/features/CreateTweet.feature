Feature: Twitter Can should be able to tweet using Authentication

  @Mahmud
  Scenario: Verify Authenticated user able to tweet successfully
    Given Twitter user have the Auth token
    When user send a POST request to tweets endPoint
    Then user verify the status code is "201"
    And user verify the tweet message


  Scenario: Verify Authenticated user is not able to retweet successfully
    Given Twitter user have the Auth token
    When user send a POST request to tweets endPoint
    Then user verify the status code is "403" error
    And user verify the retweet error message


#  Scenario: Verify Authenticated user is not able to tweet successfully if text is empty
#    Given Twitter user have the Auth token
#    When user send a POST request to tweets endPoint
#    Then user verify the status code is "201"
#    And user verify the tweet message
#
#  Scenario: Verify UnAuthenticated user not able to tweet successfully
#    Given Twitter user have the Auth token
#    When user send a POST request to tweets endPoint
#    Then user verify the status code is "201"
#    And user verify the tweet message
#
  @Mahmud
  Scenario: Verify Authenticated user able to create tweet and delete the tweet successfully
    Given Twitter user have the Auth token
    When user send a POST request to tweets endPoint
    Then user verify the status code is "201" with tweet message
    And user have a tweetId from the response
    When user send a DELETE request to tweets endPoint following by id
    Then user verify the status code "200" with deleted property value is "true"

