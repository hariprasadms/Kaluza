Feature: Media wiki testing generate token and page modifications
  Description: This is the test feature to test generate token and page modifications

  Background: Use can access the token generate end point

  Scenario: Verify status code is valid

    Given i can access the token generate endpoint
    When i send the get request with required details
    Then it generated the token Id

  Scenario: Verify appropriate validation message for wrong requests

    Given i can access the endpoint
    When i send the get request with incorrect param details
    Then it displayed validation message