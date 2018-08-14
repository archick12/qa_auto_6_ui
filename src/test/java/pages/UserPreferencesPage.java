package pages;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class UserPreferencesPage {

    String userPreferencesEditButton = "//section/div/div[1]/div[2]/div[1]/ul/li/a/span";
    String timeZoneDropDownMenu = "//*[@id=\'timeZoneRegion\']";
    String elementsAtTZDropDown = "//fieldset/div[5]/div[1]/select/option[8]";
    String elemntsAtLocationDropDown = "//fieldset/div[5]/div[2]/select/option[44]";
    String updateButton = "//*[@id=\"update-user-preferences-submit\"]";
    String fulHeaderButtonId = "//header/nav/div/div[3]/ul/li[4]/a/span/span/img";
    String profileId = "//*[@id=\'view_profile\']";

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
