package pages;

import com.codeborne.selenide.Condition;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class NotificationDialog {

    private String mainContainerID = "aui-flag-container";
    private String createdKeyLinkXPath = "//a[@class = 'issue-created-key issue-link']";

    public String getCreatedIssueKey(){
        return $(byXpath(createdKeyLinkXPath)).getAttribute("data-issue-key");
    }

    public String getCreatedIssueLink(){
        return $(byXpath(createdKeyLinkXPath)).getAttribute("href");
    }

    public boolean isSuccessDialogDisplayed(){
        return $(byXpath("//*[@id='" + mainContainerID + "']//div[contains(@class,'success')]")).shouldBe(Condition.visible).isDisplayed();
    }
}
