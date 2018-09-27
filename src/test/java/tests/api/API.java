package java.tests.api;

import api.JiraApiActions;
import api.JiraApiJsonFixture;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;
import org.json.simple.JSONObject;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class API {
  String issueId;

  @BeforeSuite(groups = {"API"})
  public void setupMethod() {

  }

  @Test(priority = 1, groups = {"API"})
  public void loginJira() {
    JiraApiActions jiraApiActions = new JiraApiActions();
    ValidatableResponse response = jiraApiActions.login(JiraApiJsonFixture.login("webinar5", "webinar5"));
    response.statusCode(201);
    response.contentType(ContentType.JSON);
  }

  @Test(groups = {"API"})
  public void createIssueTest() {

    JiraApiActions jiraApiActions = new JiraApiActions();
    ValidatableResponse response = jiraApiActions.createIssue();

    response.statusCode(201); // Code 201: Returns a link to the created issue.
    response.contentType(ContentType.JSON);
    issueId = response.extract().path("id");
    // TODO validate with regex
  }

  @AfterTest(groups = {"API"})
  public void deleteIssueTest() {
//    ValidatableResponse responseDelete = given().
//        header("Content-Type", "application/json").
//        header("Cookie", "JSESSIONID=" + sessionId).
//        when().
//        delete("/rest/api/2/issue/" + issueId).
//        then().
//        statusCode(204);  //Code 204: Returned if the issue was successfully removed.
//
//    //Check that issue was delete and not found.
//    given().
//        header("Content-Type", "application/json").
//        header("Cookie", "JSESSIONID=" + sessionId).
//        when().
//        get("/rest/api/2/issue/" + issueId).
//        then().
//        statusCode(404); //Code 404: Returned if the requested issue was not found, or the user does not have permission to view it.
  }

}
