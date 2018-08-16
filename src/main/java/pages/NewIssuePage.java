package pages;

import com.codeborne.selenide.Condition;

import static com.codeborne.selenide.Selectors.byId;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class NewIssuePage {
    private String inputProjectID = "project-field";
    private String inputIssueTypeID = "issuetype-field";
    private String inputSummaryID = "summary";
    private String inputDescriptionID = "description";
    private String clickTextTabButtonXpath = "//*[@class=\"tabs-menu\"]/li[2]";
    private String assignToMeButtonID = "assign-to-me-trigger";
    private String createButtonID = "create-issue-submit";

    public boolean atRequiredPage () {
        $(byXpath("//*[@id=\"create-issue-dialog\"]/div[1]/h2")).should(Condition.visible);
        return true;
    }
    public  void enterProjectName(String projectName){
        $(byId(inputProjectID)).setValue(projectName).pressEnter();
    }
    public  void enterIssueType(String issueType){
        $(byId(inputIssueTypeID)).setValue(issueType).pressEnter();
    }
    public  void enterSummary(String summary){
        $(byId(inputSummaryID)).clear();
        $(byId(inputSummaryID)).setValue(summary);
    }
    public  void enterDescription(String description){
        $(byXpath(clickTextTabButtonXpath)).click();
        $(byId(inputDescriptionID)).clear();
        $(byId(inputDescriptionID)).setValue(description);
    }
    public void clickAssignToMe(){
        $(byId(assignToMeButtonID)).click();
    }
    public void clickCreateButton(){
        $(byId(createButtonID)).click();
    }
    public boolean isIssueCreated () {
        $(byXpath("//*[@id=\"create-issue-dialog\"]/div[1]/h2")).shouldNot(Condition.visible); // проверяет, что после нажатия кнопки, окно закрылось.
         return true;
    }
}
