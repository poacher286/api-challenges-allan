package allan.challenge.stepDef;

import allan.challenge.base.TestBase;
import allan.challenge.pages.PgChallenger;
import com.aventstack.extentreports.Status;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.response.Response;

public class Challenger extends TestBase{
    private final PgChallenger pgChallenger;
    private Response response;

    public Challenger() {
        pgChallenger = new PgChallenger();
    }

    @Given("User call Challenger API")
    public void userCallChallengerApi() {
        response = pgChallenger.getChallengerResponse();
        test.log(Status.PASS, "Challenger API called");
    }

    @Then("User verify Challenger status code {int}")
    public void userVerifyStatusCode(int statusCode) {
        response.then()
                .assertThat()
                .statusCode(statusCode);
    }
}
