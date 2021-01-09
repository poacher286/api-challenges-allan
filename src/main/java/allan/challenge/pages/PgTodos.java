package allan.challenge.pages;

import allan.challenge.base.APIBase;
import io.restassured.response.Response;

public class PgTodos extends APIBase {
    public Response getTodosResponse(String resource) {
        return this.getGetResponse(resource);
    }

}
