package allan.challenge.pages;

import allan.challenge.base.APIBase;
import io.restassured.response.Response;

public class PgTodos extends APIBase {

    public Response getTodosResponse(String resource) {
        this.header.put("X-Challenger", "rest-api-challenges-single-player");
        return this.getGetResponse(resource);
    }

}
