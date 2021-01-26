package allan.challenge.pages;

import allan.challenge.base.APIBase;
import allan.challenge.operations.Operation;
import io.restassured.response.Response;

public class PgTodos extends APIBase {
    public Response getTodosResponse(String resource) {
        return this.getTodosResponse(resource, Operation.GET);
    }

    public Response getTodosResponse(String resource, Operation operation) {
        specBuilder.get().setBasePath(resource);
        return this.getResponse(specBuilder.get().build(), operation);
    }

}
