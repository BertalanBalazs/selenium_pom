package com.codecool.vargabeles.selenium.pom;


import com.codecool.vargabeles.selenium.pom.pageObjects.EditIssuePage;
import com.codecool.vargabeles.selenium.pom.pageObjects.IssuePage;
import org.junit.Assert;
import org.junit.jupiter.api.Test;


public class EditIssuePageTest extends BaseTest{

    @Test
    void testEditIssueWithButtonEdit() {
        IssuePage issuePage = new IssuePage(driver);
        EditIssuePage editIssuePage = new EditIssuePage(driver);

        issuePage.navigateToIssue("https://jira.codecool.codecanvas.hu/browse/SAND-1");
        editIssuePage.editSummaryField("Test Story");
        Assert.assertTrue(issuePage.validateSummaryEdited("Test Story"));
        issuePage.navigateToIssue("https://jira.codecool.codecanvas.hu/browse/SAND-1");
        editIssuePage.restoreSummeryField("Story");
    }

}