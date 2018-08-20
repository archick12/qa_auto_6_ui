package tests;

import org.testng.annotations.Test;
import pages.DashboardPage;
import pages.NewIssuePage;

import static com.codeborne.selenide.Selenide.open;

public class NewIssueTest {

    @Test
    public void addNewIssue(){

        DashboardPage dashboardPage = new DashboardPage();
        open("http://jira.hillel.it:8080/secure/Dashboard.jspa");
        dashboardPage.clickCreateIssueButton();

        NewIssuePage newIssuePage = new NewIssuePage();
        newIssuePage.enterSummary("QAAUTO6_T1_test03");
        newIssuePage.enterDescription("Testing Issue. Project QAAUTO6 Team1");
        newIssuePage.clickAssignToMe();
        newIssuePage.clickCreateButton();
    }
}
