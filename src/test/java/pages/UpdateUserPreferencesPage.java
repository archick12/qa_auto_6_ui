package pages;

import com.codeborne.selenide.Condition;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class UpdateUserPreferencesPage {

    String intPageSizeValue;
    String pageSizeXpath = "//*[@id = 'update-user-preferences-pagesize']";
    String emailTypeXpath = "//*[@id = 'update-user-preferences-mailtype']";
    String languageXpath = "//*[@id = 'update-user-preferences-locale']";
    String timeZoneRegionXpath = "//*[@id = 'timeZoneRegion']";
    String timeZoneDefaultXpath = "//*[@id = 'defaultUserTimeZone']";
    String sharingXpath = "//*[@id = 'shareDefault']";
    String keyboardShortcutsXpath = "//*[@id = 'update-user-preferences-keyboard-shortcuts']";
    String autowatchXpath = "//*[@id = 'update-user-preferences-auto-watch-preference']";
    String updateButtonXpath = "//*[@id = 'update-user-preferences-submit']";
    String cancelButtonXpath = "//*[@id = 'update-user-preferences-cancel']";


    public void pageSize(String intPageSizeValue) {

        this.intPageSizeValue = intPageSizeValue;
        $(By.xpath(pageSizeXpath)).waitUntil(Condition.visible, 3000).click();
        $(By.xpath(pageSizeXpath)).clear();
        $(By.xpath(pageSizeXpath)).sendKeys(intPageSizeValue);
        $(By.xpath(updateButtonXpath)).click();
    }
}

