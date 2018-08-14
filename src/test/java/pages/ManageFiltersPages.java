package pages;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class ManageFiltersPages {

    public void searchButton() {
        $(By.id("search-filters-tab")).click();
    }

    public void myButton() { $(By.id("my-filters-tab")).click(); }

    public void buttonSettings(){
        $(By.cssSelector("button.aui-button")).click();
    }

    public void buttonDelete(){
        $(By.cssSelector("a.delete-filter[tabindex='-1']")).click();
    }

    public void buttonDeleteApprove(){
        $(By.cssSelector("#delete-filter-submit")).click();
    }
}


