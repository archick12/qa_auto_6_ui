package pages;

import com.codeborne.selenide.Condition;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class ManageFiltersPages {

    public void clickMyButton() { $(By.id("my-filters-tab")).click(); }

    public void clickbuttonSettings(){ $(By.cssSelector("button.aui-button")).click(); }

    public void clickbuttonDelete(){ $(By.cssSelector("a.delete-filter[tabindex='-1']")).click(); }

    public void clickbuttonDeleteApprove(){ $(By.cssSelector("#delete-filter-submit")).click(); }

    public void checkAvailabilityFilter(){
        $(By.linkText("1 testSaveFilter")).shouldBe(Condition.visible); }

    public void checkMissFilter(){
        $(By.linkText("1 testSaveFilter")).shouldNotBe(Condition.visible); }
}


