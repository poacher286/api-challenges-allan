package allan.challenge.base;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

public class APIBase {
    private Logger logger = LoggerFactory.getLogger(APIBase.class);

    private final String endpoint ;
    protected Map<String, String> header = new HashMap<>();

    public APIBase() {
        switch (System.getProperty("environment").toUpperCase()){
            default:
            case "LOCALHOST":
                endpoint = "http://localhost:4567";
                break;

            case "SERVER":
                endpoint = "https://apichallenges.herokuapp.com";
                break;
        }
        header.put("Accept", "*/*");
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
            System.out.println("Exception in calling API " + resource + " : " + e.getMessage());
        }
        return response;
    }

}
