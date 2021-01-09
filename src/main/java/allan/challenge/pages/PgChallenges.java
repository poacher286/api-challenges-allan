package allan.challenge.pages;

import allan.challenge.base.APIBase;
import io.restassured.response.Response;

public class PgChallenges extends APIBase {
    private static final String RESOURCE = "challenges";

    public PgChallenges() {
        this.header.put("X-Challenger", "rest-api-challenges-single-player");
    }

    public Response getChallengesResponse() {
        return this.getGetResponse(RESOURCE);
    }

}
