package tests.ui;

import com.codeborne.selenide.Configuration;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.*;

public class NewIssueTest {

    private String issueKey = "";
    private String issueURL = "";

    @BeforeTest(groups = {"UI"})
    public void setup(){

        Configuration.browser = "chrome";

        LoginPage loginPage = new LoginPage();
        loginPage.navigate();
        loginPage.atRequiredPage();
        loginPage.enterLogin("webinar5");
        loginPage.enterPassword("webinar5");
        loginPage.clickSubmitButton();

    }

    @Test (priority = 1, groups = {"UI"})
    public void createNewIssueTest(){

        DashboardPage dashboardPage = new DashboardPage();
        dashboardPage.navigate();
        dashboardPage.atRequiredPage();
        dashboardPage.clickCreateIssueButton();

        NewIssuePage newIssuePage = new NewIssuePage();
        newIssuePage.atRequiredPage();
        newIssuePage.enterSummary("[Test Automation] QAAUTO6-T1_testing_issue (eagles)");
        newIssuePage.enterDescription("Testing issue created according to http://jira.hillel.it:8080/browse/QAAUT6-131 task");
        newIssuePage.clickAssignToMe();
        newIssuePage.clickCreateButton();

        NotificationDialog dialog = new NotificationDialog();
        issueKey = dialog.getCreatedIssueKey();
        issueURL = dialog.getCreatedIssueLink();

        System.out.println("Issue " + issueKey + " created \nURL: " + issueURL + "\n");

        Assert.assertTrue(dialog.isSuccessDialogDisplayed());
    }

    @Test (dependsOnMethods = {"createNewIssueTest"}, groups = {"UI"})
    public void deleteCreatedIssue(){

        IssuePage issuePage = new IssuePage();
        issuePage.navigateTo(issueURL);
        issuePage.atRequiredPage();
        issuePage.clickMenuMoreButton();
        issuePage.clickDeleteIssueButton();
        issuePage.confirmDeleteIssue();

        NotificationDialog dialog = new NotificationDialog();
        Assert.assertTrue(dialog.isSuccessDialogDisplayed());
    }
}
