package allan.challenge.pages;

import allan.challenge.base.APIBase;
import io.restassured.response.Response;

public class PgChallenger extends APIBase {
    private static final String RESOURCE = "/challenger";

    public Response getChallengerResponse() {
        return this.getPostResponse(RESOURCE, null);
    }

}
