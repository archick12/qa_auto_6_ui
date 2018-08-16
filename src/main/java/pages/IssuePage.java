package pages;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byId;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.open;

public class IssuePage {

    String commentButtonID = "footer-comment-button";
    String textTabButtonID = "aui-uid-1";
    String commentTextAreaXPath = "//*[@id='comment-wiki-edit']/textarea";
    String addCommentSubmitButtonID = "issue-comment-add-submit";
    String issueActionsContainerID = "issue_actions_container";
    String issueActionsTextXPath = "//*[@id='issue_actions_container']//folowing::[@class='action-body flooded']";
    String priorityElementID = "priority-val";
    String priorityFieldID = "priority-field";
    String priorityFormSubmitButtonXPath = "//form[@id='priority-form']/div[@class='save-options']/button[@type='submit']";

    public void navigateTo(String url){
        open(url);
    }

    public void clickAddCommentButton(){
        $(byId(commentButtonID)).click();
    }

    public void clickTextareaTabButton(){
        $(byId(textTabButtonID)).click();
    }

    public void enterTextToTextarea(String text){
        $(byXpath(commentTextAreaXPath)).sendKeys(text);
    }

    public void clickSubmitCommentButton(){
        $(byId(addCommentSubmitButtonID)).click();
    }

    public String getLastComment(){
        return $$(byXpath(issueActionsTextXPath)).last().getText();
    }

    public void checkLastCommentText(String text){
        $$(byXpath(issueActionsTextXPath)).last().shouldHave(text(text));
    }

    public void clickPriorityElement(){
        $(byId(priorityElementID)).click();
    }

    public void enterPriorityText(String text){
        $(byId(priorityFieldID)).sendKeys(text);
        $(byId(priorityFieldID)).pressEnter();
    }

    public void clickSubmitAtPriorityForm(){
        $(byXpath(priorityFormSubmitButtonXPath)).click();
    }

}
