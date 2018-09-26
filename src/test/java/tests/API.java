package tests;

import io.restassured.RestAssured;
import io.restassured.response.ValidatableResponse;
import org.json.simple.JSONObject;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class API {
    String username = "webinar5";
    String password = "webinar5";
    String sessionId;
    String issueId;
    String commentId;
    String projectKey="QAAUT6";

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

    @Test
    public void createIssueTest() {

        String fieldsSummary = "The Issue was create via API test";
        String issueTypeId = "10105";
        String assigneeName = "Klepikov_Vjacheslav";

        JSONObject issueCreate = new JSONObject();
        JSONObject fields = new JSONObject();
        JSONObject project = new JSONObject();
        JSONObject issueType = new JSONObject();
        JSONObject assignee = new JSONObject();

        project.put("key", projectKey);
        issueType.put("id", issueTypeId);
        assignee.put("name", assigneeName);
        fields.put("project", project);
        fields.put("issuetype", issueType);
        fields.put("assignee", assignee);
        fields.put("summary", fieldsSummary);
        issueCreate.put("fields", fields);

        ValidatableResponse response = given().
                header("Content-Type", "application/json").
                header("Cookie", "JSESSIONID=" + sessionId).
                body(issueCreate.toString()).
                when().
                post("/rest/api/2/issue").
                then().
                statusCode(201); // Code 201: Returns a link to the created issue.
        issueId = response.extract().path("id");
    }

    @AfterTest
    public void deleteIssueTest() {
        ValidatableResponse responseDelete = given().
                header("Content-Type", "application/json").
                header("Cookie", "JSESSIONID=" + sessionId).
                when().
                delete("/rest/api/2/issue/" + issueId).
                then().
                statusCode(204);  //Code 204: Returned if the issue was successfully removed.

        //Check that issue was delete and not found.
                given().
                header("Content-Type", "application/json").
                header("Cookie", "JSESSIONID=" + sessionId).
                when().
                get("/rest/api/2/issue/" + issueId ).
                then().
                statusCode(404); //Code 404: Returned if the requested issue was not found, or the user does not have permission to view it.
    }

}
