package pages;

import org.openqa.selenium.By;
import org.testng.Assert;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.title;
import static com.codeborne.selenide.WebDriverRunner.url;

public class LoginPage {

    private String loginPageURL = "http://jira.hillel.it:8080/login.jsp";

    public void enterLogin(String login){
        $(By.id("login-form-username")).sendKeys(login);
    }

    public void enterPassword(String password){
        $(By.id("login-form-password")).setValue(password);
    }

    public void clickSubmitButton(){ $(By.id("login-form-submit")).click(); }

    public boolean atRequiredPage(){
        return url().equalsIgnoreCase(loginPageURL);
    }

    public void navigate(){
        open(loginPageURL);
    }
}
