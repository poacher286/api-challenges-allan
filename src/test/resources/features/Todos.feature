@Todos
Feature: Todos

  Scenario: User verify Todos API

    Given User call "todos" API
    Then User verify Todos status code 200

  Scenario: User verify Todo API giving 404 error for plural

    Given User call "todo" API
    Then User verify Todos status code 404