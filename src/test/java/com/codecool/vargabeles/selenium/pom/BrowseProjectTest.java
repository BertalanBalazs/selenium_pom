package com.codecool.vargabeles.selenium.pom;

import com.codecool.vargabeles.selenium.pom.pageObjects.ProjectPage;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static org.junit.jupiter.api.Assertions.assertFalse;

public class BrowseProjectTest extends BaseTest{

    @ParameterizedTest
    @CsvFileSource(resources = "/projectTitles.csv", numLinesToSkip = 1)
    void everyProjectExists(String projectTitle) {
        ProjectPage projectPage = new ProjectPage(driver);
        projectPage.navigate("/projects/" + projectTitle);

        assertFalse(projectPage.getCurrentPageTitle().contains("Project not found"));
    }

    @Override
    protected void makePomInstances() {

    }
}


