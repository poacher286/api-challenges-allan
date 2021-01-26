package allan.challenge.base;

import allan.challenge.operations.Operation;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class APIBase {
    public static final ThreadLocal<RequestSpecBuilder> specBuilder = ThreadLocal.withInitial(RequestSpecBuilder::new);

    protected Response getPostResponse(RequestSpecification requestSpecification) {
        return RestAssured.given().spec(requestSpecification).post().then().extract().response();
    }

    protected Response getGetResponse(RequestSpecification requestSpecification) {
        return RestAssured.given().spec(requestSpecification).get().then().extract().response();
    }

    protected Response getHEADResponse(RequestSpecification requestSpecification) {
        return RestAssured.given().spec(requestSpecification).head().then().extract().response();
    }

    protected Response getOPTIONSResponse(RequestSpecification requestSpecification) {
        return RestAssured.given().spec(requestSpecification).options().then().extract().response();
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
