package api;


import io.restassured.internal.RestAssuredResponseImpl;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;

public class JiraApiActions {

  private HttpRequestSender requestSender;

  String loginPath = "/rest/auth/1/session";
  private static String createIssuePath = "/rest/api/2/issue";


  public JiraApiActions() {
    requestSender = new HttpRequestSender();
  }

  public ValidatableResponse login(String json) {
    ValidatableResponse response = requestSender.post(loginPath, json);
    return response;
  }

  public ValidatableResponse createIssue() {
    ValidatableResponse response = requestSender.post(createIssuePath, JiraApiJsonFixture.defaultIssue());
    return response;
  }

  public Response deleteIssue() {

    return new RestAssuredResponseImpl();
  }

}
