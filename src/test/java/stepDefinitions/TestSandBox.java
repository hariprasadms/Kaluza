package stepDefinitions;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import java.util.HashMap;
import java.util.Map;
import static io.restassured.RestAssured.given;

public class TestSandBox {

    public static void main(String[] args) {

        //RestAssured.baseURI = "https://jsonplaceholder.typicode.com";
        RestAssured.baseURI = "https://www.mediawiki.org";
        given().get("/w/api.php").then().assertThat().statusCode(200);
        Map<String, Object> parms0 = new HashMap<String, Object>();
        parms0.put("action", "query");
        parms0.put("format", "json");
        parms0.put("meta", "tokens");
        parms0.put("type", "login");

        Response R = given().params(parms0).get("/w/api.php");
        String login_token_object = R.getBody().asString();

        String login_token = JsonPath.from(login_token_object).get("query.tokens.logintoken");

        System.out.println("Login token is :" + login_token);

        Map<String, Object> parms1 = new HashMap<String, Object>();
        parms1.put("action", "login");
        parms1.put("lgname", "Hari0910@harip");
        parms1.put("lgpassword", "c1k2qi4lbll7jsnt70ao6p22b72qc5nf");
        parms1.put("lgtoken", login_token);
        parms1.put("format", "json");

        Response R1 = given().params(parms1).post("/w/api.php");
        String CSRF_TOKEN_object = R1.getBody().asString();
        String CSRF_TOKEN = JsonPath.from(R1.asString()).get("query.tokens.csrftoken");
        System.out.println("CSRF_TOKEN token is :" + CSRF_TOKEN);

        Map<String, Object> parms2 = new HashMap<String, Object>();
        parms1.put("action", "edit");
        parms1.put("title", "Project:Sandbox");
        parms1.put("token", CSRF_TOKEN);
        parms1.put("format", "json");
        parms1.put("appendtext", "Hello");

        Response R3 = given().params(parms2).get("/w/api.php");

        String BODY = R3.getBody().asString();

        System.out.println("Body is :" + BODY);

        //Map<String, Object> header = new HashMap<String, Object>();

//       Map<String, Object> todos =  JsonPath.from(resp.asString()).get();
//       System.out.println(todos);
//
//        Response resp2 = given().get("/todos/1");
//        String id =  JsonPath.from(resp2.asString()).get("id").toString();
//        System.out.println(id);

    }

}
