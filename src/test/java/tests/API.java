package tests;

import io.restassured.RestAssured;
import io.restassured.response.ValidatableResponse;
import org.json.simple.JSONObject;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class API {
    String username = "webinar5";
    String password = "webinar5";
    String sessionId;
    String issueId;
    String commentId;

    @BeforeSuite
    public void setupMethod(){
        RestAssured.baseURI = "http://jira.hillel.it";
        RestAssured.port = 8080;
        JSONObject login = new JSONObject();
        login.put("username",username);
        login.put("password",password);

        sessionId = given().
                header("Content-Type", "application/json").
                body(login.toString()).
                when().
                post("/rest/auth/1/session").
                then().
                extract().path("session.value");
    }

    @Test
    public void loginJira(){
        ValidatableResponse response = given().
                header("Content-Type", "application/json").
                header("Cookie", "JSESSIONID=" + sessionId).
                when().
                get("rest/api/2/issue/createmeta").
                then().
                statusCode(200);

        String issueKey = response.extract().asString();
    }

    @Test
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

    @Test
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
