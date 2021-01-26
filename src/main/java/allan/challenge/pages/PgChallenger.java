package allan.challenge.pages;

import allan.challenge.base.APIBase;
import allan.challenge.operations.Operation;
import io.restassured.response.Response;

public class PgChallenger extends APIBase {
    private static final String RESOURCE = "challenger";

    public Response getChallengerResponse() {
        specBuilder.get().setBasePath(RESOURCE);
        return this.getResponse(specBuilder.get().build(), Operation.POST);
    }

}
