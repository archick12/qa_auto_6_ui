package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.*;

public class newIssueTest {

    private String issueKey = "";
    private String issueURL = "";

    @BeforeTest
    public void setup(){

        LoginPage loginPage = new LoginPage();
        loginPage.navigate();
        loginPage.atRequiredPage();
        loginPage.enterLogin("webinar5");
        loginPage.enterPassword("webinar5");
        loginPage.clickSubmitButton();

    }

    @Test (priority = 1)
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

    @Test (priority = 10)
    public void deleteCreatedIssue(){
        IssuePage issuePage = new IssuePage();
    }
}
