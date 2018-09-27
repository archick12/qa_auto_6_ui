package tests.api;

import io.restassured.RestAssured;
import io.restassured.response.ValidatableResponse;
import org.json.simple.JSONObject;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class ApiNegative {
    String username = "webinar5";
    String password = "webinar5";


    @BeforeSuite(groups = {"API"})
    public void setupMethod() {
        RestAssured.baseURI = "http://jira.hillel.it";
        RestAssured.port = 8080;
        JSONObject login = new JSONObject();
    }

    @Test(groups = {"API"})
    public void wrongLogin() {
        JSONObject login = new JSONObject();
        login.put("username", "blabla");
        login.put("password", password);

        ValidatableResponse responseWrongPass = given().
                header("Content-Type", "application/json").
                body(login.toString()).
                when().
                post("/rest/auth/1/session").
                then().
                statusCode(401);
    }

    @Test(groups = {"API"})
    public void wrongPassword() {
        JSONObject login = new JSONObject();
        login.put("username", username);
        login.put("password", "pass");

        ValidatableResponse responseWrongPass = given().
                header("Content-Type", "application/json").
                body(login.toString()).
                when().
                post("/rest/auth/1/session").
                then().
                statusCode(401);
    }
}
