package com.codecool.vargabeles.selenium.pom;

import com.codecool.vargabeles.selenium.pom.pageObjects.IssuePage;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static org.junit.jupiter.api.Assertions.*;

public class BrowseIssueTest extends BaseTest{

    @Test
    void createdIssueExists(){
        IssuePage issuePage = new IssuePage(driver);

        issuePage.navigate("/browse/SAND-40");
        assertTrue(issuePage.getPageTitle().contains("SAND-40"));
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/issueTitles.csv",numLinesToSkip = 1)
    void everyProjectHasThreeIssuesAndIndexedProperly(String issueTitle){
        IssuePage issuePage = new IssuePage(driver);

        issuePage.navigate("/browse/" + issueTitle);
        assertTrue(issuePage.getPageTitle().contains(issueTitle));
    }
}


