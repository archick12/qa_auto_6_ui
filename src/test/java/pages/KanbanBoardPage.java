package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.WebElement;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class KanbanBoardPage {

    private String onlyMyIssuesButtonXpath = "//*[@id='js-work-quickfilters']//a[text() = 'Only My Issues']";

    public void navigate(){
        open("http://jira.hillel.it:8080/secure/RapidBoard.jspa?rapidView=302");
    }

    public boolean isOnlyMyIssuesSelected(){
        return $(byXpath(onlyMyIssuesButtonXpath)).getAttribute("class").contains("ghx-active");
    }

    public void clickOnlyMyIssues(){
        $(byXpath(onlyMyIssuesButtonXpath)).click();
    }

    public WebElement getIssueBlock(String issueKey){
        return $(byXpath("//a[@title='" + issueKey + "']")); //  //div[@data-issue-key='" + issueKey + "']
    }
}
