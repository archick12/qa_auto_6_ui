package pages;

import com.codeborne.selenide.Condition;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static com.codeborne.selenide.Selenide.$;


public class SearchPage {

    public void advancedButton(){
        try { $(By.name("jql")); }
        catch (Exception e){ $(By.cssSelector("[class='switcher-item active ']")).click(); } }

    public void advancedButtonSelenide(){
        if($(By.name("jql")).isDisplayed()){ }
        else { $(By.cssSelector("[class='switcher-item active ']")).click(); } }


    public void advancedField(String request){ $(By.name("jql")).setValue(request); }

    public void searchButton(){
        $(By.cssSelector("[class='aui-item aui-button aui-button-subtle search-button']")).click(); }

    public void searchProjectButton(){
        try {
            $(By.cssSelector(".criteria-selector.aui-button.aui-button-subtle.drop-arrow")).shouldBe(Condition.visible);
            $(By.cssSelector(".criteria-selector.aui-button.aui-button-subtle.drop-arrow")).click(); }
        catch (Exception e){
            $(By.cssSelector("[class='switcher-item active ']")).click(); } }

    public void searchProjectButtonSelenide(){
        if($(By.cssSelector(".criteria-selector.aui-button.aui-button-subtle.drop-arrow")).isDisplayed()){ }
        else { $(By.cssSelector("[class='switcher-item active ']")).click(); } }


     public void enterSearchProjectFindProjects(String request){
        $(By.cssSelector(".criteria-selector.aui-button.aui-button-subtle.drop-arrow")).click();
        $(By.id("searcher-pid-input")).setValue(request);
        $(By.cssSelector("label[title='QAAUTO-6']")).click(); }

    public void uncheckSearchProjectFindProjects(){
        $(By.cssSelector(".criteria-selector.aui-button.aui-button-subtle.drop-arrow")).click();
        $(By.cssSelector("label[title='QAAUTO-6']")).click(); }

    public void saveAsButton(){
        $(By.cssSelector(".aui-button.aui-button-light.save-as-new-filter")).click(); }

    public void enterFilterName(String request){
        $(By.id("filterName")).setValue(request); }

    public void submitFilterName(){
        $(By.cssSelector(".aui-button.submit")).click();
    }

    public void findFiltersButton(){ $(By.cssSelector(".find-filters")).click(); }

    public void fiterProject(){
        $(By.cssSelector("button[data-id='project']")).click();
    }

    public void fiterTypeIssue(){
        $(By.cssSelector("button[data-id='issuetype']")).click();
    }

    public void selectQAAUTO6Profect(){
        $(By.cssSelector("input[value='11400']")).click();
    }

    public void selectEpicFilter(){
        $(By.cssSelector("input[value='10000']")).click();
    }

    public void enterSearchTypeissue(String type){ $(By.cssSelector("button[data-id='issuetype']")).sendKeys(type);}

    public void clickSomePlace(){
        $(By.cssSelector("div.header-section-primary")).click();
    }

    public void filledProject(){
        $(By.cssSelector("button[data-id='project']")).click();
    }

    public boolean emptyJQL(){
        try { $(By.id("jqlerrormsg")).isDisplayed();
            return false; }
        catch (Exception e){ return true; } }

    public WebElement basicButton(){
        return $(By.linkText("Basic"));
    }

    public WebElement firstResultInFilterSearch(){
        return $(By.cssSelector(".item-label"));
    }

    public void enterSearchTypeFindProjectsCheckEpikLink() {
        $(By.cssSelector("a.new-search.aui-button.aui-button-light")).click(); }
}
