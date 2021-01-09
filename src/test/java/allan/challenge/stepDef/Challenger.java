package allan.challenge.stepDef;

import allan.challenge.pages.PgChallenger;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.response.Response;

public class Challenger {
    private final PgChallenger pgChallenger;
    private Response response;
    public Challenger() {
        pgChallenger = new PgChallenger();
    }

    @Given("User call Challenger API")
    public void userCallChallengerApi() {
        response = pgChallenger.getChallengerResponse();
    }

    @Then("User verify status code {int}")
    public void userVerifyStatusCode(int statusCode) {
        response.then()
                .assertThat()
                .statusCode(statusCode);
    }
}
