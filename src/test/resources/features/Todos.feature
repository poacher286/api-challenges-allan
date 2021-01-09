@Todos
Feature: Todos

  Scenario: User verify Todos API

    Given User call "todos" API
    Then User verify Todos status code 200

  Scenario: User verify Todos API giving 404 error for not plural

    Given User call "todo" API
    Then User verify Todos status code 404

  @Todos_ID
  Scenario Outline: User verify Todos API with <Eligibility> ID giving status code <statusCode>

    Given User call "todos" API
    Then User call todos api with "<Eligibility>" ID
    Then User verify Todos status code <statusCode>

    Examples:
      | Eligibility | statusCode |
      | Eligible    | 200        |
      | Ineligible  | 404        |