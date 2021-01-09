package allan.challenge.base;

import com.aventstack.extentreports.Status;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class APIBase {
    private final Logger logger = LoggerFactory.getLogger(APIBase.class);

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
            TestBase.test.log(Status.PASS, "API request success : " + resource);
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
            TestBase.test.log(Status.PASS, "API request success : " + resource);
        } catch (Exception | AssertionError e) {
            logger.error(e.getMessage());
        }
        return response;
    }

}
