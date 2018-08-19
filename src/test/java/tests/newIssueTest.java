package tests;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.LoginPage;

public class newIssueTest {

    @BeforeTest
    public void setup(){

        LoginPage loginPage = new LoginPage();
        loginPage.atRequiredPage();
    }

    @Test
    public void createNewIssueTest(){

    }
}
