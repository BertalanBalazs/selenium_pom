package com.codecool.vargabeles.selenium.pom;

import com.codecool.vargabeles.selenium.pom.pageObjects.ComponentsPage;
import com.codecool.vargabeles.selenium.pom.pageObjects.GlassDocumentationPage;
import com.codecool.vargabeles.selenium.pom.pageObjects.IssuePage;
import com.codecool.vargabeles.selenium.pom.pageObjects.ProjectPage;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

class JiraComponentsWithGlassTest extends BaseTest {
    ProjectPage projectPage;
    ComponentsPage componentsPage;
    IssuePage issuePage;
    GlassDocumentationPage glassDocumentationPage;

    @Override
    protected void makePomInstances() {
        projectPage = new ProjectPage(driver);
        componentsPage = new ComponentsPage(driver);
        issuePage = new IssuePage(driver);
        glassDocumentationPage = new GlassDocumentationPage(driver);
    }

    @Test
    void categorizeIssues() {
        projectPage.navigate("/projects/PP1?selectedItem=com.atlassian.jira.jira-projects-plugin:components-page");
        componentsPage.deleteComponent("testing");
        componentsPage.makeNewComponent("testing", "Project lead (Administrator)");
        componentsPage.clickToIssuesLink();
        issuePage.addComponentToIssue("testing");
        issuePage.navigate("/projects/PP1?selectedItem=com.codecanvas.glass:glass");

        int result = glassDocumentationPage.getNumOfComponentsOfIssue();
        Assert.assertEquals(result, 1);

        projectPage.clickOnComponents();
        componentsPage.deleteComponent("testing");
    }
}