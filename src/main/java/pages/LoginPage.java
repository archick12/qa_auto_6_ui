package pages;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.url;

public class LoginPage {

    private String loginPageURL = "http://jira.hillel.it:8080/defaultLogin.jsp";

    public void enterLogin(String login){
        $(By.id("defaultLogin-form-username")).sendKeys(login);
    }

    public void enterPassword(String password){
        $(By.id("defaultLogin-form-password")).setValue(password);
    }

    public void clickSubmitButton(){ $(By.id("defaultLogin-form-submit")).click(); }

    public boolean atRequiredPage(){
        return url().equalsIgnoreCase(loginPageURL);
    }

    public void navigate(){
        open(loginPageURL);
    }
}
