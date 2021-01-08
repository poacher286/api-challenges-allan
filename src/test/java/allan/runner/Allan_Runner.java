package allan.runner;

import io.cucumber.testng.CucumberOptions;

@CucumberOptions(glue = {"src/test/java"},
        features = {"src/test/resources/features"},
        plugin = {"pretty", "json:target/cucumber/cucumber.json", "html:target/cucumber/html"})
public class Allan_Runner {
}
