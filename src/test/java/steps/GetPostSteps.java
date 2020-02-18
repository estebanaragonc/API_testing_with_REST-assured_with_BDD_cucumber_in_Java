package steps;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ResponseOptions;
import utilities.RestAssuredExtension;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;
import static org.hamcrest.CoreMatchers.hasItem;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;


public class GetPostSteps {

    private static ResponseOptions<Response> response;

    @Given("^I perform GET operation for \"([^\"]*)\"$")
    public void iPerformGETOperationFor(String url) throws Throwable {
        response = RestAssuredExtension.GetOps(url);
    }

    @Then("^I should see the author name as \"([^\"]*)\"$")
    public void iShouldSeeTheAutorNameAs(String authorName) throws Throwable {
        assertThat(response.getBody().jsonPath().get("author"), hasItem(authorName));
    }

    @Then("^I should see the author names$")
    public void iShouldSeeTheAuthorNames() {
        BDDStyledMethod.PerformContainsCollection();
    }

    @Then("^I should verify get parameter$")
    public void iShouldVerifyGetParameter() {
        BDDStyledMethod.PerformPathParameter();
    }

    @Then("^I should verify get parameter with query parameter$")
    public void iShouldVerifyGetParameterWithQueryParameter() {
        BDDStyledMethod.PerformQueryParameter();
    }
}
