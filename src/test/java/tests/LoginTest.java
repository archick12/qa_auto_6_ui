package tests;


import org.testng.annotations.Test;
import pages.LoginPage;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.title;

public class LoginTest {

    @Test
    public void JiraLoginTest(){

        open("http://jira.hillel.it:8080/login.jsp");
        LoginPage loginPage = new LoginPage();

        loginPage.enterLogin("webinar5");
        loginPage.enterPassword("webinar5");
        loginPage.clickSubmitButton();

        title().contentEquals("System Dashboard");

    }
}
