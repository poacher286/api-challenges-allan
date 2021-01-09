package allan.challenge.pages;

import allan.challenge.base.APIBase;
import io.restassured.response.Response;

public class PgTodos extends APIBase {
    public PgTodos() {
        this.header.put("X-Challenger", "rest-api-challenges-single-player");
    }

    public Response getTodosResponse(String resource) {
        return this.getGetResponse(resource);
    }

}
