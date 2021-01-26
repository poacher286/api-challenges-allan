package allan.challenge.stepDef;

import allan.challenge.base.TestBase;
import allan.challenge.pages.PgChallenger;
import com.aventstack.extentreports.Status;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.response.Response;

import static allan.challenge.base.APIBase.specBuilder;

public class Challenger extends TestBase {
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
        response.then().assertThat().statusCode(statusCode);
    }

    @And("User set X-Challenger value in header")
    public void userSetXChallengerValueInHeader() {
        specBuilder.get().addHeader("X-Challenger", response.getHeader("X-Challenger"));
    }
}
