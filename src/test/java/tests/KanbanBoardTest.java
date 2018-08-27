package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.KanbanBoardPage;
import pages.LoginPage;

public class KanbanBoardTest {

    @BeforeTest
    public void setup(){

        Configuration.browser = "chrome";

        LoginPage loginPage = new LoginPage();
        loginPage.navigate();
        loginPage.atRequiredPage();
//        loginPage.enterLogin("webinar5");
//        loginPage.enterPassword("webinar5");
        loginPage.enterLogin("Vadim_Lizogub");
        loginPage.enterPassword("t@stPsSwd");
        loginPage.clickSubmitButton();

    }

    @Test
    public void moveFromBacklogToDevelopment(){

        String issueKey = "QAAUT6-165";

        KanbanBoardPage kanbanPage = new KanbanBoardPage();
        kanbanPage.navigate();

        if(! kanbanPage.isOnlyMyIssuesSelected()){
            kanbanPage.clickOnlyMyIssues();
        }

        Actions actions = new Actions(WebDriverRunner.getWebDriver());

        actions.dragAndDropBy(kanbanPage.getIssueBlock(issueKey),500,200).perform();


        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
