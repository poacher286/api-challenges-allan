package allan.challenge.stepDef;

import allan.challenge.pages.PgChallenges;
import allan.challenge.pages.PgTodos;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.response.Response;

public class Todos {
    private PgTodos pgTodos;

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

}
