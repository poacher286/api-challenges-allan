package allan.challenge.pages;

import allan.challenge.base.APIBase;
import allan.challenge.operations.Operation;
import io.restassured.response.Response;

public class PgChallenges extends APIBase {
    private static final String RESOURCE = "challenges";

    public Response getChallengesResponse() {
        specBuilder.get().setBasePath(RESOURCE);
        return this.getResponse(specBuilder.get().build(), Operation.GET);
    }

}
