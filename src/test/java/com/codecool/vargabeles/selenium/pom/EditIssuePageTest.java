package com.codecool.vargabeles.selenium.pom;

import org.junit.Assert;
import org.junit.jupiter.api.Test;


class EditIssuePageTest extends BaseTest{


    @Test
    void testEditIssueWithButtonEdit() {
        IssuePage issuePage = new IssuePage(driver);
        issuePage.navigateToIssue("https://jira.codecool.codecanvas.hu/browse/SAND-1");
        EditIssuePage editIssuePage = new EditIssuePage(driver);
        editIssuePage.editSummaryField("Test Story");
        Assert.assertTrue(issuePage.validateSummaryEdited("Test Story"));
        issuePage.navigateToIssue("https://jira.codecool.codecanvas.hu/browse/SAND-1");
        editIssuePage.restoreSummeryField("Story");
    }

}

