package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.DashboardPage;
import pages.LoginPage;
import pages.ManageFiltersPages;
import pages.SearchPage;
import utils.ConfigProperties;

import static com.codeborne.selenide.Selenide.open;

public class SearchJira {

        public static LoginPage loginPage;
        public static SearchPage searchPage;
        public static DashboardPage dashboardPage;
        public static ManageFiltersPages manageFiltersPages;

        @BeforeMethod
        public void setup(){
            loginPage = new LoginPage();
            dashboardPage = new DashboardPage();
            searchPage = new SearchPage();
            manageFiltersPages = new ManageFiltersPages();
            Configuration.browser = ConfigProperties.getTestProperty("useBrowser");
            open(ConfigProperties.getTestProperty("jiraURL"));
            loginPage.enterLogin(ConfigProperties.getTestProperty("LoginWebinar5"));
            loginPage.enterPassword(ConfigProperties.getTestProperty("PasswordWebinar5"));
            loginPage.clickSubmitButton();
            }

    @Test
    public void testValidJQL(){
        dashboardPage.atRequiredPage();
        dashboardPage.clickIssueButton();
        dashboardPage.clickSearchOfIssues();
        searchPage.clickAdvancedButtonSelenide();
        searchPage.advancedField("project = QAAUT6 AND text ~ \"Test new issue\" order by lastViewed DESC");
        searchPage.clickSearchButton();
        searchPage.titleTestNewIssue();
    }

    @Test
    public void testCheckingOfProjectFilter(){
        dashboardPage.atRequiredPage();
        dashboardPage.clickIssueButton();
        dashboardPage.clickSearchOfIssues();
        searchPage.clickSearchProjectButton();
        searchPage.selectProjectQAAUTO6("QAAUTO-6");
        Assert.assertEquals(searchPage.firstResultInFilterSearch().getAttribute("title"), "QAAUTO-6");
    }

    @Test
    public void testInvalidJQL() {
        dashboardPage.atRequiredPage();
        dashboardPage.clickIssueButton();
        dashboardPage.clickSearchOfIssues();
        searchPage.clickAdvancedButtonSelenide();
        searchPage.advancedField("project = QAAUT6 AND text ~ \"Test new issue\" order by lastViewed DEssSC");
        searchPage.clickSearchButton();
        searchPage.errorIcon();
        searchPage.errorMessageTable();
    }

    @Test
    public void uncheckTheBoxes(){
        dashboardPage.atRequiredPage();
        dashboardPage.clickIssueButton();
        dashboardPage.clickSearchOfIssues();
        searchPage.clickSearchProjectButton();
        searchPage.selectProjectQAAUTO6("QAAUTO-6");
        searchPage.clickFiterTypeIssue();
        searchPage.selectEpicFilter();
        searchPage.clickSomePlace();
        searchPage.clickFiterTypeIssue();
        searchPage.selectEpicFilter();
        searchPage.uncheckSearchProjectFindProjects();
        searchPage.defaultLabelsStatuses();
    }

    @Test
    public void checkingOfNewFilterButton(){
        dashboardPage.atRequiredPage();
        dashboardPage.clickIssueButton();
        dashboardPage.clickSearchOfIssues();
        searchPage.clickSearchProjectButton();
        searchPage.selectProjectQAAUTO6("QAAUTO-6");
        searchPage.clickFiterTypeIssue();
        searchPage.selectEpicFilter();
        searchPage.clickNewFilterButton();
        searchPage.defaultLabelsStatuses();
    }

    @Test
    public void epmtyResultsIssue() {
        dashboardPage.atRequiredPage();
        dashboardPage.clickIssueButton();
        dashboardPage.clickSearchOfIssues();
        searchPage.clickAdvancedButtonSelenide();
        searchPage.advancedField("project = QAAUT6 AND issuetype = Task AND status = \"In Progress\" AND creator in (currentUser())");
        searchPage.clickSearchButton();
        searchPage.iconEpmtyResults();
    }


    @AfterMethod
    public void close1(){
        WebDriverRunner.getWebDriver().quit();
    }

    @AfterSuite
    public void printProperties(){
        System.out.println("Browser:" + ConfigProperties.getTestProperty("useBrowser"));
        System.out.println("URL:" + ConfigProperties.getTestProperty("jiraURLr"));
        System.out.println("Login:" + ConfigProperties.getTestProperty("LoginWebinar5"));
        System.out.println("Password:" + ConfigProperties.getTestProperty("PasswordWebinar5"));
    }
}
