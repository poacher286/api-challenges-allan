package allan.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(glue = {"allan.challenge.stepDef"},
                 features = {"src/test/resources/features"},
                 tags = "not @Ignore",
                 publish = true,
                 plugin = {"pretty",
                         "json:target/cucumber/cucumber.json",
                         "html:target/cucumber/html"})
public class Allan_Runner extends AbstractTestNGCucumberTests {
}
