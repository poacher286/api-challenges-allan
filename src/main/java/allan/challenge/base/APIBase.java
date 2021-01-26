package allan.challenge.base;

import allan.challenge.operations.Operation;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class APIBase {
    public static final ThreadLocal<RequestSpecBuilder> specBuilder = ThreadLocal.withInitial(RequestSpecBuilder::new);

    private RequestSpecification reqSpec(RequestSpecification requestSpecification) {
        return RestAssured.given().spec(requestSpecification);
    }

    private Response getPostResponse(RequestSpecification requestSpecification) {
        return reqSpec(requestSpecification).post().thenReturn();
    }

    private Response getGetResponse(RequestSpecification requestSpecification) {
        return reqSpec(requestSpecification).get().thenReturn();
    }

    private Response getHEADResponse(RequestSpecification requestSpecification) {
        return reqSpec(requestSpecification).head().thenReturn();
    }

    private Response getOPTIONSResponse(RequestSpecification requestSpecification) {
        return reqSpec(requestSpecification).options().thenReturn();
    }

    protected Response getResponse(RequestSpecification requestSpecification, Operation operation) {
        switch (operation) {
            case GET:
                return this.getGetResponse(requestSpecification);
            case POST:
                return this.getPostResponse(requestSpecification);
            case OPTIONS:
                return this.getOPTIONSResponse(requestSpecification);
            default:
            case HEAD:
                return this.getHEADResponse(requestSpecification);
        }
    }
}
