package com.codecool.vargabeles.selenium.pom;

import com.codecool.vargabeles.selenium.pom.pageObjects.IssuePage;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BrowseIssueTest extends BaseTest{

    @Test
    void createdIssueExists(){
        IssuePage issuePage = new IssuePage(driver);

        issuePage.navigate("/browse/SAND-40");
        assertTrue(issuePage.getPageTitle().contains("[SAND-40]"));
    }
}


