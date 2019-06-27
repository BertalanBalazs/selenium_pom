package com.codecool.vargabeles.selenium.pom;

import com.codecool.vargabeles.selenium.pom.pageObjects.IssuePage;
import com.codecool.vargabeles.selenium.pom.pageObjects.LoginPage;
import com.codecool.vargabeles.selenium.pom.pageObjects.ProjectPage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class BrowseProjectTest extends BaseTest{

    @ParameterizedTest
    @CsvFileSource(resources = "/projectTitles.csv", numLinesToSkip = 1)
    void everyProjectExists(String projectTitle) {
        ProjectPage projectPage = new ProjectPage(driver);
        projectPage.navigate("/projects/" + projectTitle);

        assertFalse(projectPage.getCurrentPageTitle().contains("Project not found"));
    }
}


