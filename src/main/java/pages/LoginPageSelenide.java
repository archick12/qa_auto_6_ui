package pages;

import org.openqa.selenium.By;
import static com.codeborne.selenide.Selenide.*;

public class LoginPageSelenide {

    public void enterLogin(String login){
        $(By.xpath("//input[@id='login-form-username']")).sendKeys(login);
    }

    public void enterPassword(String password){
        $(By.xpath("//input[@id='login-form-password']")).sendKeys(password);
    }

    public void clickSubmit(){
        $(By.xpath("//input[@id='login-form-submit']")).click();
    }
}
