package allan.challenge.stepDef;

import allan.challenge.pages.PgChallenger;
import allan.challenge.pages.PgChallenges;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.response.Response;

public class Challenges {
    private Response response;
    private final PgChallenges pgChallenges;

    public Challenges() {
        pgChallenges = new PgChallenges();
    }

    @Given("User call Challenges API")
    public void userCallChallengesApi() {
        response = pgChallenges.getChallengesResponse();
    }

    @Then("User verify Challenges status code {int}")
    public void userVerifyChallengesStatusCode(int statusCode) {
        response.then().assertThat().statusCode(statusCode);
    }
}
