package com.codecool.vargabeles.selenium.pom;

import com.codecool.vargabeles.selenium.pom.pageObjects.EditIssuePage;
import com.codecool.vargabeles.selenium.pom.pageObjects.IssuePage;
import com.codecool.vargabeles.selenium.pom.pageObjects.LoginPage;
import org.junit.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

class EditIssueTest extends BaseTest {

    @Override
    protected void makePomInstances() {
    }


    @Test
    void testEditIssueWithButtonEdit() {
        IssuePage issuePage = new IssuePage(driver);
        EditIssuePage editIssuePage = new EditIssuePage(driver);

        issuePage.navigate("/browse/SAND-1");
        issuePage.clickOnEditButton();
        editIssuePage.editSummaryField("Test Story");
        Assert.assertTrue(issuePage.validateSummaryEdited("Test Story"));
        issuePage.clickOnEditButton();
        editIssuePage.editSummaryField("Story");
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/issueTitles.csv", numLinesToSkip = 1)
    void testEditIssueWithButtonEditFromCsvFile(String username, String issueTitle) {
        IssuePage issuePage = new IssuePage(driver);
        EditIssuePage editIssuePage = new EditIssuePage(driver);

        issuePage.navigate("/browse/" + issueTitle);
        issuePage.clickOnEditButton();
        editIssuePage.editSummaryField("Test Story");
        Assert.assertTrue(issuePage.validateSummaryEdited("Test Story"));
        issuePage.clickOnEditButton();
        editIssuePage.editSummaryField("Story");
    }

    @Test
    void testEditIssueOnTheIssuePage() {
        IssuePage issuePage = new IssuePage(driver);

        issuePage.navigate("/browse/SAND-25");
        issuePage.editIssueType("task-1");
        Assert.assertTrue(issuePage.validateIssueTypeEdited("Task"));
        issuePage.navigate("/browse/SAND-25");
        issuePage.editIssueType("story-1");
    }

//    @ParameterizedTest
//    @CsvFileSource(resources = "/issueTitles.csv", numLinesToSkip = 1)
//    void testEditIssueOnTheIssuePageFromCsvFile(String username, String issueTitle) {
//        IssuePage issuePage = new IssuePage(driver);
//
//        loginPage.validLogin(username, System.getenv("password"));
//        issuePage.navigate("/browse/" + issueTitle);
//        issuePage.editIssueType("task-1");
//        Assert.assertTrue(issuePage.validateIssueTypeEdited("Task"));
//        issuePage.navigate("/browse/" + issueTitle);
//        issuePage.editIssueType("story-1");
//    }

}
