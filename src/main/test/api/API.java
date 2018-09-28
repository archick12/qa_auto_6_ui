package api;

import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class API {
  String issueId;
  JiraApiActions jiraApiActions;

  @BeforeSuite(groups = {"API"})
  public void setupMethod() {
    jiraApiActions = new JiraApiActions();
  }

  @Test(priority = 1, groups = {"API"})
  public void loginJira() {
    ValidatableResponse response = jiraApiActions.login(JiraApiJsonFixture.login("webinar5", "webinar5"));
    response.statusCode(201);
    response.contentType(ContentType.JSON);
  }

  @Test(groups = {"API"})
  public void createIssueTest() {
    ValidatableResponse response = jiraApiActions.createIssue();
    response.statusCode(201); // Code 201: Returns a link to the created issue.
    response.contentType(ContentType.JSON);
    issueId = response.extract().path("id");
    // TODO validate with regex that ticket it is present in the response

    response = jiraApiActions.deleteIssue(issueId);
    response.statusCode(204);
    response.contentType(ContentType.JSON);

    response = jiraApiActions.getIssue(issueId);
    response.statusCode(404);
    response.contentType(ContentType.JSON);
  }

  @AfterTest(groups = {"API"})
  public void deleteIssueTest() {
    // TODO add negative scenarios for delete
    // TODO add boundary case scenarios for delete
  }

}
