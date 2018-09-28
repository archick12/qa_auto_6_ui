package api;

import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import utils.TestGroups;

public class IssueTest {

  private String issueId;
  private JiraApiActions jiraApiActions;

  @BeforeSuite(groups = {TestGroups.ISSUE, TestGroups.REGRESSION })
  public void setupMethod() {
    jiraApiActions = new JiraApiActions();
  }

  @Test(groups = {TestGroups.ISSUE, TestGroups.REGRESSION})
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

  @AfterTest(groups = { TestGroups.ISSUE, TestGroups.REGRESSION })
  public void deleteIssueTest() {
    // TODO add negative scenarios for delete
    // TODO add boundary case scenarios for delete
  }

}
