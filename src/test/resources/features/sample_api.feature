Feature: Sample API automation for users endpoint
  As an API test engineer
  I want to validate basic users API behaviors
  So that I can ensure responses are correct

  Background:
    Given the API base URL is "https://jsonplaceholder.typicode.com"

  Scenario: Get users list
    When I send a GET request to "/users"
    Then the response status code should be 200
    And the response should contain "name"

  Scenario: Get single user by id
    When I send a GET request to "/users/2"
    Then the response status code should be 200
    And the response should contain "username"

  Scenario: Create new user
    Given I set request body:
      """
      {
        "title": "sample post",
        "body": "this is a sample payload",
        "userId": 1
      }
      """
    When I send a POST request to "/posts"
    Then the response status code should be 201
    And the response should contain "id"
