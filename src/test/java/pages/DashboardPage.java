package pages;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class DashboardPage {

    public void issueButton(){
        $(By.id("find_link")).click();
    }

    public void currentSearch(){
        try{
            $(By.id("jira.top.navigation.bar:issues_drop_current_lnk")).click();
        }catch (Exception e){
            searchOfIssues(); } }

    public void searchOfIssues(){
        $("#issues_new_search_link_lnk").click();
    }







}
