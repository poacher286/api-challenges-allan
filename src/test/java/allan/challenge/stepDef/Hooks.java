package allan.challenge.stepDef;

import io.cucumber.java.After;
import io.cucumber.java.Scenario;

public class Hooks {

    @After
    public void afterScenario(Scenario scenario) {
        System.out.println("Scenario ended : " + scenario.getName() + " with status : " + scenario.getStatus());
    }
}
