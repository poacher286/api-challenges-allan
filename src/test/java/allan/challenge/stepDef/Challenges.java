package allan.challenge.stepDef;

import allan.challenge.base.TestBase;
import allan.challenge.pages.PgChallenges;
import com.aventstack.extentreports.Status;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.response.Response;

public class Challenges extends TestBase {
    private Response response;
    private final PgChallenges pgChallenges;

    public Challenges() {
        pgChallenges = new PgChallenges();
    }

    @Given("User call Challenges API")
    public void userCallChallengesApi() {
        response = pgChallenges.getChallengesResponse();
        test.log(Status.PASS, "Challenges API called");
    }

    @Then("User verify Challenges status code {int}")
    public void userVerifyChallengesStatusCode(int statusCode) {
        response.then().assertThat().statusCode(statusCode);
    }
}
