package tests;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.DashboardPage;
import pages.LoginPage;

public class newIssueTest {

    @BeforeTest
    public void setup(){

        LoginPage loginPage = new LoginPage();
        loginPage.navigate();
        loginPage.atRequiredPage();
        loginPage.enterLogin("webinar5");
        loginPage.enterPassword("webinar5");
        loginPage.clickSubmitButton();

    }

    @Test
    public void createNewIssueTest(){

        DashboardPage dashboardPage = new DashboardPage();
        dashboardPage.clickCreateIssueButton();
    }
}
