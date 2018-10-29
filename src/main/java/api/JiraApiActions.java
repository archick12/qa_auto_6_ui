package api;

import io.qameta.allure.Step;
import io.restassured.response.ValidatableResponse;

public class JiraApiActions {

  private HttpRequestSender requestSender;

  String loginPath = "/rest/auth/1/session";
  private static String createIssuePath = "/rest/api/2/issue";
  private static String deleteIssuePath = "/rest/api/2/issue/%s";
  private static String getIssuePath = "/rest/api/2/issue/%s";


  public JiraApiActions() {
    requestSender = new HttpRequestSender();
  }

  public ValidatableResponse login(String json) {
    ValidatableResponse response = requestSender.post(loginPath, json);
    return response;
  }

  @Step("Step description")
  public ValidatableResponse createIssue() {
    ValidatableResponse response = requestSender.post(createIssuePath, JiraApiJsonFixture.defaultIssue());
    return response;
  }

  @Step
  public ValidatableResponse deleteIssue(String issueId) {
    deleteIssuePath = String.format(deleteIssuePath, issueId);
    ValidatableResponse response = requestSender.delete(deleteIssuePath, JiraApiJsonFixture.defaultIssue());
    return response;
  }

  @Step
  public ValidatableResponse getIssue(String issueId) {
    getIssuePath = String.format(getIssuePath, issueId);
    ValidatableResponse response = requestSender.get(getIssuePath);
    return response;
  }
}
