package pages;

import com.codeborne.selenide.Condition;

import static com.codeborne.selenide.Selectors.byId;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class NewIssuePage {

    public boolean atRequiredPage () {
        $(byId("create-issue-dialog")).waitUntil(Condition.visible,10000);
        return true;
    }
    public  void enterProjectName(String projectName){
        $(byId("project-field")).setValue(projectName).pressEnter();
    }
    public  void enterIssueType(String issueType){
        $(byId("issuetype-field")).setValue(issueType).pressEnter();
    }
    public  void enterSummary(String summary){
        $(byId("summary")).clear();
        $(byId("summary")).setValue(summary);
    }
    public  void enterDescription(String description){
        $(byXpath("//li[@data-mode='source']/a")).click();
        $(byId("description")).clear();
        $(byId("description")).setValue(description);
    }
    public void clickAssignToMe(){
        $(byId("assign-to-me-trigger")).click();
    }
    public void clickCreateButton(){
        $(byId("create-issue-submit")).click();
    }
    public boolean isIssueCreated () {
        $(byXpath("//*[@id='create-issue-dialog']")).shouldNot(Condition.visible);
         return true;
    }
}
