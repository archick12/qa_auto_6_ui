package pages;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class UserPreferencesPage {

    private String userPreferencesEditButton = "//section/div/div[1]/div[2]/div[1]/ul/li/a/span";
    private String timeZoneDropDownMenu = "//*[@id='timeZoneRegion']";
    private String elementsAtTZDropDown = "//fieldset/div[5]/div[1]/select/option[8]";
    private String elemntsAtLocationDropDown = "//fieldset/div[5]/div[2]/select/option[44]";
    private String updateButton = "//*[@id='update-user-preferences-submit']";
    private String fulHeaderButtonId = "//header/nav/div/div[3]/ul/li[4]/a/span/span/img";
    private String profileId = "//*[@id='view_profile']";

    public void clickOnfulHeaderButtonId() {
        $(By.xpath(fulHeaderButtonId)).click();
    }

    public void clickOnProfileButton() {
        $(By.xpath(profileId)).click();
    }

    public void clickOnPrefEditButton() {
        $(By.xpath(userPreferencesEditButton)).click();
    }

    public void clickOnTimeZoneMenu() {
        $(By.xpath(timeZoneDropDownMenu)).click();
    }

    public void clickOnElementInDDM() {
        $(By.xpath(elementsAtTZDropDown)).click();
    }

    public void clickOnElementInLocalization() {
        $(By.xpath(elemntsAtLocationDropDown)).click();
    }

    public void clickOnUpdateButton() {
        $(By.xpath(updateButton)).click();
    }

}
