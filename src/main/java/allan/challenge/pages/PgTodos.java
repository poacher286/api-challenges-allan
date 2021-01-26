package allan.challenge.pages;

import allan.challenge.base.APIBase;
import io.restassured.response.Response;

public class PgTodos extends APIBase {
    public Response getTodosResponse(String resource) {
        return this.getTodosResponse(resource, "GET");
    }

    public Response getTodosResponse(String resource, String operation) {
        switch (operation.toUpperCase()) {
            case "HEAD":
                return this.getHEADResponse(resource);
            case "OPTIONS":
                return this.getOPTIONSResponse(resource);
            default:
            case "GET":
                return this.getGetResponse(resource);
        }
    }

}
