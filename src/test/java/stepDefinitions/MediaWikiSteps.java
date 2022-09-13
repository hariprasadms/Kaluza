package stepDefinitions;

import framework.ApiUtility;
import framework.MediaApi;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.Assert;

import java.util.HashMap;
import java.util.Map;

public class MediaWikiSteps extends MediaApi {

    Response response;
    private String login_token;

    @Given("i can access the token generate endpoint")
    public void iCanAccessTheTokenGenerateEndpoint() {

        Map<String, Object> parms0 = new HashMap<String, Object>();
        parms0.put("action", "query");
        parms0.put("format", "json");
        parms0.put("meta", "tokens");
        parms0.put("type", "login");

        response = ApiUtility.doGetRequest(baseUrl, endPoint, parms0);


    }

    @When("i send the get request with required details")
    public void iSendTheGetRequestWithRequiredDetails() {
        ApiUtility.verifyStatusCode(response, 200);

    }

    @Then("it generated the token Id")
    public void itGeneratedTheTokenId() {
        login_token = JsonPath.from(response.body().asString()).get("query.tokens.logintoken");
        Assert.assertTrue(!login_token.isEmpty());
    }

    @Given("i can access the endpoint")
    public void iCanAccessTheEndpoint() {
        Map<String, Object> parms0 = new HashMap<String, Object>();
        parms0.put("action", "query");
        parms0.put("format", "json");
        parms0.put("type", "login");
        response = ApiUtility.doGetRequest(baseUrl, endPoint, parms0);
    }

    @When("i send the get request with incorrect param details")
    public void iSendTheGetRequestWithIncorrectParamDetails() {
        ApiUtility.verifyStatusCode(response, 200);
    }

    @Then("it displayed validation message")
    public void itDisplayedValidationMessage() {
        ApiUtility.verifyMesage(response,"warnings.main.*", "Unrecognized parameter: type");

    }

}

