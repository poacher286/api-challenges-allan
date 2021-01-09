package allan.challenge.stepDef;

import allan.challenge.pages.PgTodos;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.response.Response;

public class Todos {
    private final PgTodos pgTodos;

    private Response todosResponse;

    public Todos() {
        pgTodos = new PgTodos();
    }

    @Given("User call {string} API")
    public void userCallTodosAPI(String resource) {
        todosResponse = pgTodos.getTodosResponse(resource);
    }

    @Then("User verify Todos status code {int}")
    public void userVerifyTodosStatusCode(int statusCode) {
        todosResponse.then().assertThat().statusCode(statusCode);
    }

    @Then("User call todos api with {string} ID")
    public void userCallTodosApiWithID(String eligibility) {
        switch (eligibility.toUpperCase()) {
            case "ELIGIBLE":
                todosResponse = pgTodos.getTodosResponse("todos/" +
                        todosResponse.jsonPath().getJsonObject("todos.id[0]"));
                break;
            default:
            case "INELIGIBLE":
                todosResponse = pgTodos.getTodosResponse("todos/0");
                break;
        }
    }
}
