package api;

import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;
import org.testng.annotations.Test;

public class ApiNegative {

    @Test(groups = {"API"})
    public void wrongLogin() {
        JiraApiActions jiraApiActions = new JiraApiActions();
        ValidatableResponse response = jiraApiActions.login(JiraApiJsonFixture.login("webinar5", "wrongPassword"));
        response.statusCode(401);
        response.contentType(ContentType.JSON);
    }

    @Test(groups = {"API"})
    public void wrongPassword() {
        JiraApiActions jiraApiActions = new JiraApiActions();
        ValidatableResponse response = jiraApiActions.login(JiraApiJsonFixture.login("wrongLogin", "webinar5"));
        response.statusCode(401);
        response.contentType(ContentType.JSON);
    }
}
