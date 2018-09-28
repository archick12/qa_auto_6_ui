package api;

import api.JiraApiActions;
import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import utils.TestGroups;

public class LoginTest {

  private JiraApiActions jiraApiActions;

  @BeforeSuite(groups = {TestGroups.LOGIN, TestGroups.REGRESSION})
  public void setupMethod() {
    jiraApiActions = new JiraApiActions();
  }

  @Test(dependsOnMethods = "loginToJira", groups = {TestGroups.LOGIN, TestGroups.REGRESSION})
  public void wrongLogin() {
    ValidatableResponse response = jiraApiActions.login(JiraApiJsonFixture.login("webinar5", "wrongPassword"));
    response.statusCode(401);
    response.contentType(ContentType.JSON);
  }

  @Test(dependsOnMethods = "loginToJira", groups = {TestGroups.LOGIN, TestGroups.REGRESSION})
  public void wrongPassword() {
    ValidatableResponse response = jiraApiActions.login(JiraApiJsonFixture.login("wrongLogin", "webinar5"));
    response.statusCode(401);
    response.contentType(ContentType.JSON);
  }

  @Test(priority = 1, groups = { TestGroups.LOGIN, TestGroups.REGRESSION })
  public void loginToJira() {
    ValidatableResponse response = jiraApiActions.login(JiraApiJsonFixture.login("webinar5", "webinar5"));
    response.statusCode(200);
    response.contentType(ContentType.JSON);
  }
}
