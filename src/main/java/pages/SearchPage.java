package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import java.util.List;

import static com.codeborne.selenide.Condition.attribute;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;


public class SearchPage {

    public void clickAdvancedButtonSelenide(){
        if ($(By.cssSelector("span.aui-icon.icon-close")).isDisplayed()){
            $(By.cssSelector("span.aui-icon.icon-close")).click();}
        else{}
        if($(By.name("jql")).isDisplayed()){ }
        else { $(By.xpath("//a[contains(@class, 'switcher-item active ')]")).shouldBe(Condition.visible).shouldBe(Condition.enabled).click();
        }
    }

    public void advancedField(String request){ $(By.name("jql")).setValue(request); }

    public void clickSearchButton(){
        $(By.cssSelector("button.aui-item.aui-button.aui-button-subtle.search-button")).click(); }

    public void clickSearchProjectButton(){
        if ($(By.cssSelector("span.aui-icon.icon-close")).isDisplayed()){
            $(By.cssSelector("span.aui-icon.icon-close")).click();}
            else{}
        if($(By.cssSelector(".criteria-selector.aui-button.aui-button-subtle.drop-arrow")).isDisplayed()){ }
        else {
            $(By.xpath("//a[contains(@class, 'switcher-item active ')]")).shouldBe(Condition.visible).shouldBe(Condition.enabled).click(); }
    }

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

    public void clickFilterTypeIssue(){ $(By.cssSelector("button[data-id='issuetype']")).click(); }
    public void selectEpicFilter(){
        $(By.cssSelector("input[value='10000']")).shouldBe(Condition.visible).click(); }

    public void enterSearchTypeissue(String type){ $(By.cssSelector("button[data-id='issuetype']")).sendKeys(type);}

    public void clickSomePlace(){ $(By.cssSelector("div.header-section-primary")).click(); }

    public WebElement firstResultInFilterSearch(){ return $(By.cssSelector(".item-label")); }

    public void clickNewFilterButton() { $(By.cssSelector("a.new-search.aui-button.aui-button-light")).click(); }

    public void clickButtonChangeViews(){
        $(".aui-buttons").click();}

    public void clickDetailView(){
        $("a.aui-list-item-link[data-layout-key='split-view'").click(); }

    public void clickListView(){
        $("a.aui-list-item-link[data-layout-key='list-view']").click(); }

    public void titleTestNewIssue(){ $(By.cssSelector("[title='[Test Automation] Test New Issue']")).isDisplayed(); }

    public void errorMessageTable(){ $(By.xpath("//div[@class = 'aui-message error']")).isDisplayed(); }

    public void errorIcon(){$(By.id("jqlerrormsg")).isDisplayed();}

    public void defaultLabelsStatuses(){$$(By.cssSelector("span.fieldLabel")).shouldHaveSize(4);}

    public void iconEpmtyResults(){
        $(By.cssSelector("div.jira-adbox.jira-adbox-medium.no-results.no-results-message")).shouldBe(Condition.visible);
    }

    public void searchResultsContains(String request){
        $(By.className("fieldValue")).shouldHave(text(request));
    }

    public void selectProject(String request){
        $(By.cssSelector(".criteria-selector.aui-button.aui-button-subtle.drop-arrow")).click();
        $(By.id("searcher-pid-input")).setValue(request);
        $(By.cssSelector("label[title='" +request+"']")).click(); }

    public SelenideElement issueList(){
        return  $(".list-content").shouldBe(Condition.visible);
    }

    public void checkTypeOfFirstPositionInIssueList(String request){
        issueList().$("img").shouldHave(attribute("alt", request)); }

    public List<SelenideElement> fullListSelenideElementsImg(){
        return issueList().$$("img");}
}
