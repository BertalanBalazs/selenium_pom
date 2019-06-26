package com.codecool.vargabeles.selenium.pom;

import com.codecool.vargabeles.selenium.pom.pageObjects.IssuePage;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BrowseIssueTest extends BaseTest{

    @Test
    void createdIssueExists(){
        IssuePage issuePage = new IssuePage(driver);

        issuePage.navigate("/browse/SAND-40");
        assertTrue(issuePage.getPageTitle().contains("SAND-40"));
    }

    //TODO separate?
    @Test
    void projectJetiHasThreeIssuesAndIndexedProperly(){
        IssuePage issuePage = new IssuePage(driver);

        issuePage.navigate("/browse/JETI-1");
        assertTrue(issuePage.getPageTitle().contains("JETI-1"));

        issuePage.navigate("/browse/JETI-2");
        assertTrue(issuePage.getPageTitle().contains("JETI-2"));

        issuePage.navigate("/browse/JETI-3");
        assertTrue(issuePage.getPageTitle().contains("JETI-3"));
    }

    @Test
    void projectToucanHasThreeIssuesAndIndexedProperly(){
        IssuePage issuePage = new IssuePage(driver);

        issuePage.navigate("/browse/TOUCAN-1");
        assertTrue(issuePage.getPageTitle().contains("TOUCAN-1"));

        issuePage.navigate("/browse/TOUCAN-2");
        assertTrue(issuePage.getPageTitle().contains("TOUCAN-2"));

        issuePage.navigate("/browse/TOUCAN-3");
        assertTrue(issuePage.getPageTitle().contains("TOUCAN-3"));
    }

    @Test
    void projectCoalaHasThreeIssuesAndIndexedProperly(){
        IssuePage issuePage = new IssuePage(driver);

        issuePage.navigate("/browse/COALA-1");
        assertTrue(issuePage.getPageTitle().contains("COALA-1"));

        issuePage.navigate("/browse/COALA-2");
        assertTrue(issuePage.getPageTitle().contains("COALA-2"));

        issuePage.navigate("/browse/COALA-3");
        assertTrue(issuePage.getPageTitle().contains("COALA-3"));
    }
}


