package api;

import org.json.simple.JSONObject;

public class JiraApiJsonFixture {

  public static String defaultLogin() {
    JSONObject login = new JSONObject();
    login.put("username", "webinar5");
    login.put("password", "webinar5");
    return login.toJSONString();
  }

  public static String login(String userName, String password) {
    JSONObject login = new JSONObject();
    login.put("username", userName);
    login.put("password", password);
    return login.toJSONString();
  }

  public static String defaultIssue() {
    String fieldsSummary = "The Issue was create via API test";
    String issueTypeId = "10105";
    String assigneeName = "Webinar5";
    String projectKey = "QAAUT6";

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

    return issueCreate.toJSONString();
  }
}
