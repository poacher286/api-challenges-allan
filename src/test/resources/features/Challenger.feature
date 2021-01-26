Feature: Challenger

  Background: User set global URI
    Given User set base URI
    Then User set header
      | Accept | */* |

  @Challenger
  Scenario: Verify Challenger API

    Given User call Challenger API
    Then User verify Challenger status code 201