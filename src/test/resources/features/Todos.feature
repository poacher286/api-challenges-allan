@Todos
Feature: Todos

  Background: User set global URI
    Given User set base URI
    And User call Challenger API
    And User set X-Challenger value in header

  @Todo_start
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

  @Todos_Operation
  Scenario Outline: User verify Todos API with <operation> request

    Given User call "todos" API with "<operation>" request
    Then User verify Todos status code 200

    Examples:
      | operation |
      | HEAD      |
      | OPTIONS   |

  @Todos_Accept_Challenge
  Scenario Outline: User verify Todos API with <accept> as Accept header request

    Then User set header
      | <headerKey> | <accept> |
    Given User call "todos" API
    Then User verify Todos status code <statusCode>

    Examples:
      | headerKey | accept                            | statusCode |
      | Accept    | */*                               | 200        |
      | Accept    | application/xml                   | 200        |
      | Accept    | application/json                  | 200        |
      | Accept    | application/xml, application/json | 200        |
      | Accept    | application/gzip                  | 406        |

  @Todos_Accept_Challenge_No_Header
  Scenario: User verify Todos API with no Accept header request

    Then User remove header
      |Accept|
    Given User call "todos" API
    Then User verify Todos status code 200