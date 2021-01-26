Feature: Challenges

  Background: User set global URI
    Given User set base URI
    Then User set header
      | Accept | */* |
    And User call Challenger API
    And User set X-Challenger value in header

  @Challenges
  Scenario: User verify Challenges API

    Given User call Challenges API
    Then User verify Challenges status code 200