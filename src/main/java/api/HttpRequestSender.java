package api;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;

import static io.restassured.RestAssured.given;

public class HttpRequestSender {

  private String JSESSIONID = "";

  HttpRequestSender() {
    RestAssured.baseURI = "http://jira.hillel.it";
    RestAssured.port = 8080;
    authorize();
  }

  public ValidatableResponse get(String path) {
    return given().
        contentType(ContentType.JSON).
        header("Cookie", "JSESSIONID=" + JSESSIONID).
        when().
        get(path).then();
  }

  public ValidatableResponse post(String path, String json) {
    return given().
        contentType(ContentType.JSON).
        header("Cookie", "JSESSIONID=" + JSESSIONID).
        when().
        body(json).
        post(path).
        then();
  }

  public ValidatableResponse delete(String path, String json) {
    return given().
        contentType(ContentType.JSON).
        header("Cookie", "JSESSIONID=" + JSESSIONID).
        when().
        body(json).
        delete(path).
        then();
  }

  private void authorize() {
    String loginPath = "/rest/auth/1/session";
    JSESSIONID = post(loginPath, JiraApiJsonFixture.defaultLogin()).extract().path("session.value");
  }

}
