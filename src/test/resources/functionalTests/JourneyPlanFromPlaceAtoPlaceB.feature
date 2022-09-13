Feature: Plan a journey from place A to place B
  Description: This is verify journey plan details from place A to B

  Background: User can access the journey endpoint

    Given I am able to access journey endpoint

  Scenario: Verify status code is valid

    Given journey endpoint is accessible
    When I search for any journey
    Then the valid journey details displayed with status code

  Scenario Outline: Verify journey details displayed successfully

    Given journey endpoint is accessible
    When I look for a journey from "<PlaceA>" to "<PlaceB>"
    Then verify valid type displayed
    Examples:
      | PlaceA     | PlaceB       |
      | Paddington | westministor |
      | Reading | Paddington |

