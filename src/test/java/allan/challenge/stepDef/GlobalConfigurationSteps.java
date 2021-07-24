package allan.challenge.stepDef;

import allan.challenge.base.TestBase;
import allan.challenge.pages.PgSpecBuilder;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

import java.util.List;
import java.util.Map;

public class GlobalConfigurationSteps extends TestBase {
    private final PgSpecBuilder pgSpecBuilder;

    public GlobalConfigurationSteps() {
        pgSpecBuilder = new PgSpecBuilder();
    }

    @Given("User set base URI")
    public void userSetBaseURI() {
        pgSpecBuilder.setBaseURI();
    }

    @Then("User set header")
    public void userSetHeader(DataTable dataTable) {
        Map<String, String> dataMap = dataTable.asMap(String.class, String.class);
        pgSpecBuilder.setHeaders(dataMap);
    }

    @Then("User remove header")
    public void userRemoveHeader(DataTable dataTable) {
        List<String> headers = dataTable.asList(String.class);
        headers.forEach(pgSpecBuilder::removeHeader);
    }
}
