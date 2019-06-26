package com.codecool.vargabeles.selenium.pom;

import com.codecool.vargabeles.selenium.pom.pageObjects.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class JiraComponentsWithGlass extends BasePage {


    ProjectPage projectPage;
    ComponentsPage componentsPage;
    IssuePage issuePage;
    GlassDocumentationPage glassDocumentationPage;

    protected JiraComponentsWithGlass(WebDriver webDriver) {
        super(webDriver);
        projectPage = new ProjectPage(driver);
        componentsPage = new ComponentsPage(driver);
        issuePage = new IssuePage(driver);
    }

    public int categorizeIssues() {
        navigate("projects/PP3?selectedItem=com.atlassian.jira.jira-projects-plugin:components-page");

        //Save component
        projectPage.clickOnComponents();
        clearCategorizeIssues();
        componentsPage.sendKeyToNameInput("test");
        componentsPage.sendKeyToAssigneeInput("Project lead (Administrator)");
        componentsPage.clickToComponentFilter();
        componentsPage.clickToAddButton();

        //add component to issue
        componentsPage.clickToIssuesLink();
        issuePage.clickToEditButton();
        issuePage.sendKeyToComponentsTextarea("test");
        issuePage.clickToEditSubmitButton();
        issuePage.clickToGlassDocumentation();
        return glassDocumentationPage.getNumOfComponentsOfIssue();
    }


    public void clearCategorizeIssues() {
        //TODO
        projectPage.clickOnComponents();
        int i = 1;
        while (true) {
            try {

                if ("test".equals(driver.findElement(By.cssSelector("#components-table > tbody.items > tr:nth-child(" + i + ") > td.components-table__name > div > a")).getText())) {
                    componentsPage.clickToNthElementAction(i);
                    componentsPage.getNthDataComponentId(i);
                    int id = componentsPage.getNthDataComponentId(i);
                    componentsPage.clickToDeleteComponent(id);
                    componentsPage.clickToRemoveComponentRadioButton(id);
                    componentsPage.clickToDeleteSubmitButton();
                    break;
                }
                i++;
            } catch (Exception e){
                break;
            }
        }
    }
}
