package com.codecool.vargabeles.selenium.pom;

import com.codecool.vargabeles.selenium.pom.pageObjects.IssuePage;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class BrowseIssueTest extends BaseTest{

    @Override
    protected void makePomInstances() {

    }

    @Test
    void createdIssueExists() {
        IssuePage issuePage = new IssuePage(driver);
        issuePage.navigate("/browse/SAND-40");
        assertTrue(issuePage.getCurrentPageTitle().contains("SAND-40"));
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/issueTitles.csv", numLinesToSkip = 1)
    void everyProjectHasThreeIssuesAndIndexedProperly(String username, String issueTitle) {
        IssuePage issuePage = new IssuePage(driver);

        issuePage.navigate("/browse/" + issueTitle);
        assertTrue(issuePage.getCurrentPageTitle().contains(issueTitle));
    }
}