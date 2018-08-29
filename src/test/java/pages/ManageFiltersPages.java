package pages;

import com.codeborne.selenide.Condition;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class ManageFiltersPages {

    public void clickMyButton() { $(By.id("my-filters-tab")).click(); }

    public void clickbuttonSettings(){ $(By.cssSelector("button.aui-button")).click(); }

    public void clickbuttonDelete(){ $(By.cssSelector("a.delete-filter[tabindex='-1']")).click(); }

    public void clickbuttonDeleteApprove(){ $(By.cssSelector("#delete-filter-submit")).click(); }

    public void checkAvailabilityFilter(String request){
        $(By.linkText(request)).shouldBe(Condition.visible); }

    public void checkMissFilter(){
        $(By.linkText("1 testSaveFilter")).shouldNotBe(Condition.visible); }

    public void deleteFilterIfExist(String request){
        $(".aui-page-panel-content").$(By.className("aui-page-header-main")).shouldHave(text("My Filters"));
        if ($(By.linkText(request)).isDisplayed()){
            clickbuttonSettings();
            clickbuttonDelete();
            clickbuttonDeleteApprove();}
    }
}


