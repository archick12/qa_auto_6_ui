package pages;

import com.codeborne.selenide.Condition;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.title; //aa


public class SearchPage {

    public void clickAdvancedButtonSelenide(){
        if($(By.name("jql")).isDisplayed()){ }
        else { $(By.cssSelector("[class='switcher-item active ']")).click(); } }

    public void advancedField(String request){ $(By.name("jql")).setValue(request); }

    public void clicksearchButton(){
        $(By.cssSelector("[class='aui-item aui-button aui-button-subtle search-button']")).click(); }

    public void clicksearchProjectButton(){
        if($(By.cssSelector(".criteria-selector.aui-button.aui-button-subtle.drop-arrow")).isDisplayed()){ }
        else { $(By.cssSelector("[class='switcher-item active ']")).click(); } }

    public void selectProjectQAAUTO6(String request){
        $(By.cssSelector(".criteria-selector.aui-button.aui-button-subtle.drop-arrow")).click();
        $(By.id("searcher-pid-input")).setValue(request);
        $(By.cssSelector("label[title='QAAUTO-6']")).click(); }

    public void uncheckSearchProjectFindProjects(){
        $(By.cssSelector(".criteria-selector.aui-button.aui-button-subtle.drop-arrow")).click();
        $(By.cssSelector("label[title='QAAUTO-6']")).click(); }

    public void clickSaveAsButton(){
        $(By.cssSelector(".aui-button.aui-button-light.save-as-new-filter")).click(); }

    public void enterFilterName(String request){ $(By.id("filterName")).setValue(request); }

    public void clickSubmitFilterName(){ $(By.cssSelector(".aui-button.submit")).click(); }

    public void clickfindFiltersButton(){ $(By.cssSelector(".find-filters")).click(); }

    public void clickFiterTypeIssue(){ $(By.cssSelector("button[data-id='issuetype']")).click(); }

    public void selectEpicFilter(){ $(By.cssSelector("input[value='10000']")).click(); }

    public void enterSearchTypeissue(String type){ $(By.cssSelector("button[data-id='issuetype']")).sendKeys(type);}

    public void clickSomePlace(){ $(By.cssSelector("div.header-section-primary")).click(); }

    public WebElement firstResultInFilterSearch(){ return $(By.cssSelector(".item-label")); }

    public void clickNewFilterButton() { $(By.cssSelector("a.new-search.aui-button.aui-button-light")).click(); }

    public boolean atRequiredPage() //проверяет, что мы на searchPage.
    { Assert.assertEquals(title(), "Issue Navigator - Hillel IT School JIRA");
        return true;
    }
}
