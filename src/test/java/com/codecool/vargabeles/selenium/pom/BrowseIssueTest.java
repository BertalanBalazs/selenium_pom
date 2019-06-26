package com.codecool.vargabeles.selenium.pom;

import com.codecool.vargabeles.selenium.pom.pageObjects.IssuePage;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

public class BrowseIssueTest extends BaseTest{

    @Test
    void createdIssueExists(){
        IssuePage issuePage = new IssuePage(driver);

        issuePage.navigate("/browse/SAND-40");
        assertTrue(issuePage.getPageTitle().contains("SAND-40"));
    }

    //TODO separate?
    @ParameterizedTest
    @ValueSource(strings = {"JETI-1", "JETI-2","JETI-3"})
    void projectJetiHasThreeIssuesAndIndexedProperly(String issueTitle){
        IssuePage issuePage = new IssuePage(driver);

        issuePage.navigate("/browse/" + issueTitle);
        assertTrue(issuePage.getPageTitle().contains(issueTitle));
    }

    @ParameterizedTest
    @ValueSource(strings = {"TOUCAN-1", "TOUCAN-2","TOUCAN-3"})
    void projectToucanHasThreeIssuesAndIndexedProperly(String issueTitle){
        IssuePage issuePage = new IssuePage(driver);

        issuePage.navigate("/browse/" + issueTitle);
        assertTrue(issuePage.getPageTitle().contains(issueTitle));
    }

    @ParameterizedTest
    @ValueSource(strings = {"COALA-1", "COALA-2","COALA-3"})
    void projectCoalaHasThreeIssuesAndIndexedProperly(String issueTitle){
        IssuePage issuePage = new IssuePage(driver);

        issuePage.navigate("/browse/" + issueTitle);
        assertTrue(issuePage.getPageTitle().contains(issueTitle));
    }
}


