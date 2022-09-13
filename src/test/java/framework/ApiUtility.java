package framework;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;

import java.util.Map;

public class ApiUtility {

    public static Response doPostRequest(String baseUrl, String resource) {
        RestAssured.baseURI = baseUrl;
        RequestSpecification request = RestAssured.given();
        request.header("Content-Type", "application/json");
        return request.post(resource);
    }

    public static Response doGetRequest(String baseUrl, String endpoint, Map<String, Object> params) {
        RestAssured.baseURI = baseUrl;
        RequestSpecification request = RestAssured.given();
        request.header("Content-Type", "application/json");
        return request.params(params).get(endpoint);
    }

    public static Response doGetRequest(String baseUrl, String resource) {
        RestAssured.baseURI = baseUrl;
        RequestSpecification request = RestAssured.given();
        request.header("Content-Type", "application/json");
        return request.get(resource);
    }

    public static void verifyStatusCode(Response response, int expectedStatusCode) {
        Assert.assertEquals(expectedStatusCode, response.statusCode());
    }

    public static void verifyMesage(Response response, String jsonPath, String expMsg) {
        Assert.assertEquals(JsonPath.from(response.body().asString()).get(jsonPath),expMsg);
    }
}
