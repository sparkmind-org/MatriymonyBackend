Feature: Profile Management

  Scenario: Create a new profile
    Given the profile API is available
    When I send a POST request to "/profiles" with the following data:
      | active | lastSeen             | lastLoggedIn        |
      | true   | 2023-08-06T12:00:00  | 2023-08-06T12:00:00 |
    Then the response status code should be 201
    And the response should contain the profile ID

  Scenario: Retrieve profile details
    Given the profile API is available
    When I send a GET request to "/profiles/{profileId}"
    Then the response status code should be 200
    And the response should contain profile details

  Scenario: Update an existing profile
    Given the profile API is available
    When I send a PUT request to "/profiles/{profileId}" with the following data:
      | active | lastSeen             | lastLoggedIn        |
      | false  | 2023-08-07T12:00:00  | 2023-08-07T12:00:00 |
    Then the response status code should be 200
    And the response should reflect the updated details

  Scenario: Delete a profile
    Given the profile API is available
    When I send a DELETE request to "/profiles/{profileId}"
    Then the response status code should be 200
