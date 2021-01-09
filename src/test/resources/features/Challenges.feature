Feature: Challenges

  @Challenges
  Scenario: User verify Challenges API

    Given User call Challenges API
    Then User verify Challenges status code 200