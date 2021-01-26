package allan.challenge.pages;

import allan.challenge.base.APIBase;

import java.io.IOException;
import java.util.Map;

public class PgSpecBuilder extends APIBase {

    private void runAPIChallengeService() {
        try {
            Process process = Runtime.getRuntime().exec("java -jar apichallenges.jar");
            Runtime.getRuntime().addShutdownHook(new Thread(() -> {
                if (process.isAlive()) process.destroyForcibly();
            }));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void setBaseURI() {
        String endpoint;
        switch (System.getProperty("environment").toUpperCase()) {
            default:
            case "LOCAL":
            case "LOCALHOST":
                runAPIChallengeService();
                endpoint = "http://localhost:4567/";
                break;

            case "SERVER":
                endpoint = "https://apichallenges.herokuapp.com/";
                break;
        }
        specBuilder.get().setBaseUri(endpoint);
    }

    public void setHeaders(Map<String, String> dataMap) {
        specBuilder.get().addHeaders(dataMap);
    }
}
