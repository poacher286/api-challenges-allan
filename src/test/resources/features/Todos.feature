@Todos
Feature: Todos

  Scenario: User verify Todos API

    Given User call "todos" API
    Then User verify Todos status code 200

  Scenario: User verify Todo API giving 404 error for not plural

    Given User call "todo" API
    Then User verify Todos status code 404

  @Todos_ID
  Scenario Outline: User verify Todos API with ID <ID> giving status code <statusCode>

    Given User call "todos/<ID>" API
    Then User verify Todos status code <statusCode>

    Examples:
      | ID | statusCode |
      | 0  | 200        |
      | 1  | 200        |
      | 2  | 200        |
      | 3  | 200        |
      | 4  | 200        |
      | 5  | 200        |
      | 6  | 200        |
      | 7  | 200        |
      | 8  | 200        |
      | 9  | 200        |
      | 10 | 200        |

    Examples:
      | ID | statusCode |
      | 11 | 404        |