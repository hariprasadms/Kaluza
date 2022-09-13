package stepDefinitions;

import data.JourneyData;
import framework.ApiUtility;
import framework.TflApi;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.Assert;
import java.util.List;

public class TflSteps extends TflApi {

    Response response;

    @Given("I am able to access journey endpoint")
    public void iAmAbleToAccessJourneyEndpoint() {
        String endPoint = "/journey/journeyresults/paddington/to/westministor";

        // To verify the endpoint access the location points are hardcoded here.
        response = ApiUtility.doGetRequest(baseUrl, "/journey/journeyresults/paddington/to/westministor");
        response.then().statusCode(300);

    }

    @Given("journey endpoint is accessible")
    public void journeyEndpointIsAccessible() {
        ApiUtility.verifyStatusCode(response, 300);

    }

    @When("I look for a journey from {string} to {string}")
    public void iLookForAJourneyFromTo(String arg0, String arg1) {

        String endPoint = "/journey/journeyresults/" + arg0 + "/to/" + arg1;
        response = ApiUtility.doGetRequest(baseUrl, endPoint);
        ApiUtility.verifyStatusCode(response, 300);

    }

    @When("I search for any journey")
    public void iSearchForAnyJourney() {
        response = ApiUtility.doGetRequest(baseUrl, "/journey/journeyresults/paddington/to/westministor");
        ApiUtility.verifyStatusCode(response, 300);
    }

    @Then("the valid journey details displayed with status code")
    public void theValidJourneyDetailsDisplayedWithStatusCode() {
        ApiUtility.verifyStatusCode(response, 300);
    }

    @Then("verify valid type displayed")
    public void verifyValidTypeDisplayed() {

        List<String> m = JourneyData.getModes();
        String body = response.getBody().asString();
        String actualType = JsonPath.from(body).get("$type");
        Assert.assertEquals(JourneyData.getExpected_Type(), actualType);
    }
}
