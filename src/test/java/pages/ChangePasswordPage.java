package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import static com.codeborne.selenide.Selenide.$;

public class ChangePasswordPage {

    private String fulHeaderButtonId = "//header/nav/div/div[3]/ul/li[4]/a/span/span/img";
    private String profileId = "//*[@id='view_profile']";
    private String changePassId = "//*[@id='view_change_password']";
    private String currentPassInPopUpId = "//form/div[1]/fieldset/div[2]/input";
    private String newPassInPopUpId = "//*[@id='change-password-new-password']";
    private String confirmPassInPopUpId = "//*[@id='change-password-confirm-password']";
    private String updateButtonId = "//*[@id='change-password-submit']";
    private String settingsUpdatedNotifyPopUpId = "//section/div/div[1]/div[1]/div[2]/div";

    public void clickOnfulHeaderButtonId() {
        $(By.xpath(fulHeaderButtonId)).click();
    }

    public void clickOnProfileButton() {
        $(By.xpath(profileId)).click();
    }

    public void clickOnChangePassLink() {
        $(By.xpath(changePassId)).click();
    }

    public void enterCurrentPass(String currentPass) {
        $(By.xpath(currentPassInPopUpId)).sendKeys(currentPass);
    }

    public void enterNewPass(String newPass) {
        $(By.xpath(newPassInPopUpId)).sendKeys(newPass);
    }

    public void enterNewPassForConfirm(String passForConfirm) {
        $(By.xpath(confirmPassInPopUpId)).sendKeys(passForConfirm);
    }

    public void clickOnupdateButton() {
        $(By.xpath(updateButtonId)).sendKeys(Keys.ENTER);
    }

    public boolean popUp() {
        return $(By.xpath(settingsUpdatedNotifyPopUpId)).isDisplayed();
    }

}

