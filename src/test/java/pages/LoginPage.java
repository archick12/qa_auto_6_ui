package pages;

import org.openqa.selenium.By;
import org.testng.Assert;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.title;

public class LoginPage {

    public void enterLogin(String login){
        $(By.id("login-form-username")).sendKeys(login);
    }

    public void enterPassword(String password){
        $(By.id("login-form-password")).setValue(password);
    }

    public void clickSubmitButton(){ $(By.id("login-form-submit")).click(); }

}
