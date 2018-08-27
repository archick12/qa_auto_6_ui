package pages;

import com.codeborne.selenide.ElementsCollection;
import org.openqa.selenium.WebElement;

import java.util.Collection;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
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
        return $(byXpath("//div[@data-issue-key='" + issueKey + "']"));
    }

    public WebElement getGhxColumnByName(String name){
        String columnId = $(byXpath("//h2[contains(text(),'" + name + "')]//ancestor::li")).getAttribute("data-id");

        return $(byXpath("//li[@data-column-id='" + columnId  + "']"));
    }
}
