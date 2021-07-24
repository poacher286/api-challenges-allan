package allan.runner;

import allan.challenge.base.TestBase;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;

@CucumberOptions(glue = {"allan.challenge.stepDef"},
        features = {"src/test/resources/features"},
        tags = "not @Ignore",
        publish = true,
        plugin = {"pretty",
                "json:target/cucumber-reports/cucumber.json",
                "html:target/cucumber-reports/cucumber.html",
                "junit:target/cucumber-reports/Cucumber.xml",})
public class Allan_Runner extends TestBase {
    @DataProvider(parallel = true)
    @Override
    public Object[][] scenarios() {
        return super.scenarios();
    }
}
