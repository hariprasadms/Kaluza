# Cucumber BDD API Automation Test framework
This is a simple API test framework built using Restassured and cucumber BDD feature.

Framework contains below items.
- Data
- Framework
- Api utility files
- Test Runner
- Step definitions
- Features files

### Project structure looks as below  ###

<img src="https://github.com/hariprasadms/Kaluza/blob/master/images/project_structure.jpg"/>

### Below are the scenarios considerd to automate TFL and MediaWiki rest services.###

Below scenarios - TFL

```gherkin

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
      
 ```
Below scenarios - TFL

 ```gherkin
 
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
 
 ```

Note - Below scenarios are not able write tests as actual end points where not working.

- Mediawiki - Create and edit pages
