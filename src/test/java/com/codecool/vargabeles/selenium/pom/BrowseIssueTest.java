package com.codecool.vargabeles.selenium.pom;

import com.codecool.vargabeles.selenium.pom.pageObjects.IssuePage;
import com.codecool.vargabeles.selenium.pom.pageObjects.LoginPage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class BrowseIssueTest extends BaseTest {

    private LoginPage loginPage;
    private WebDriver driver;

    @BeforeEach
    void setUp() {
        System.setProperty("webdriver.chrome.driver", System.getenv("webdriverPath"));
        driver = new ChromeDriver();
        loginPage = new LoginPage(driver);
    }

    @AfterEach
    void tearDown() {
        driver.close();
    }

    @Test
    void createdIssueExists() {
        loginPage.validLogin(System.getenv("username"), System.getenv("password"));
        IssuePage issuePage = new IssuePage(driver);
        issuePage.navigate("/browse/SAND-40");
        assertTrue(issuePage.getPageTitle().contains("SAND-40"));
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/issueTitles.csv", numLinesToSkip = 1)
    void everyProjectHasThreeIssuesAndIndexedProperly(String username, String issueTitle) {
        IssuePage issuePage = new IssuePage(driver);
        loginPage.validLogin(username, System.getenv("password"));
        issuePage.navigate("/browse/" + issueTitle);

        assertTrue(issuePage.getPageTitle().contains(issueTitle));
    }
}


