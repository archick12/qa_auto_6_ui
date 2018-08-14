package pages;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class DashboardPage {

    public void clickIssueButton(){ $(By.id("find_link")).click(); }

    public void clickSearchOfIssues(){ $("#issues_new_search_link_lnk").click(); }
}
