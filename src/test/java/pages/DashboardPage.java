package pages;

import org.openqa.selenium.By;
import org.testng.Assert;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.title;

public class DashboardPage {

    public void clickIssueButton(){ $(By.id("find_link")).click(); }

    public void clickSearchOfIssues(){ $("#issues_new_search_link_lnk").click(); }

    public boolean atRequiredPage() //проверяет, что мы на dashboardPage.
    { Assert.assertEquals(title(), "System Dashboard - Hillel IT School JIRA"); return true; }

    public void clickCreateIssueButton() { $(By.id("create_link")).click();}
}
