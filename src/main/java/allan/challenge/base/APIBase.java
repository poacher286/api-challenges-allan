package allan.challenge.base;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class APIBase {
    public static final ThreadLocal<String> X_CHALLENGER =new ThreadLocal<>();
    private final Logger logger = LogManager.getLogger(APIBase.class);

    private final String endpoint;
    protected Map<String, String> header = new HashMap<>();

    public APIBase() {
        switch (System.getProperty("environment").toUpperCase()) {
            default:
            case "LOCAL":
            case "LOCALHOST":
                try {
                    Runtime.getRuntime().exec("java -jar apichallenges.jar");
                } catch (IOException e) {
                    e.printStackTrace();
                }
                endpoint = "http://localhost:4567/";
                break;

            case "SERVER":
                endpoint = "https://apichallenges.herokuapp.com/";
                break;
        }
        header.put("Accept", "*/*");
        if (X_CHALLENGER.get()==null){
            X_CHALLENGER.set(this.getPostResponse("challenger", null).getHeader("X-Challenger"));
        }
        header.put("X-Challenger", X_CHALLENGER.get());
    }

    public Response getPostResponse(String resource, String payload) {
        Response response = null;
        try {
            RestAssured.baseURI = endpoint + resource;
            response = RestAssured.given()
                    .headers(header)
                    .body(payload == null ? "" : payload)
                    .post(RestAssured.baseURI)
                    .then()
                    .extract().response();
            logger.info("API request success ");
        } catch (Exception | AssertionError e) {
            logger.error(e.getMessage());
        }
        return response;
    }

    public Response getGetResponse(String resource) {
        Response response = null;
        try {
            RestAssured.baseURI = endpoint + resource;
            response = RestAssured.given()
                    .headers(header)
                    .get(RestAssured.baseURI)
                    .then()
                    .extract().response();
            logger.info("API request success ");
        } catch (Exception | AssertionError e) {
            logger.error(e.getMessage());
        }
        return response;
    }

}
