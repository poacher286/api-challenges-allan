Feature: Challenger

  @Challenger
  Scenario: Verify Challenger API

    Given User call Challenger API
    Then User verify Challenger status code 201