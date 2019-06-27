package com.codecool.vargabeles.selenium.pom;

import com.codecool.vargabeles.selenium.pom.pageObjects.*;
import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertTrue;

class JiraVersionsWithGlassTest extends BaseTest {

    private int randomNumber = new Random().nextInt(99999);
    private String randomVersionNameToTheTest = "TestVersion-" + randomNumber;
    private String randomIssueToTheTest = "TestIssue-" + randomNumber;

    @Test
    void createNewVersionAndCheckVisibilityInGlassTest() throws InterruptedException {
        GlassDocumentationPage glassDocumentationPage = new GlassDocumentationPage(driver);

        createNewVersion();

        glassDocumentationPage.navigate("/projects/PP3?selectedItem=com.codecanvas.glass:glass");
        glassDocumentationPage.clickOnVersions();

        assertTrue(glassDocumentationPage.checkNewlyCreatedTestVersion(randomVersionNameToTheTest));

        deleteRecentlyCreatedVersion();
    }

    @Test
    void connectIssueToTheRecentlyCreatedVersion() throws InterruptedException {
        ReleasesPage releasesPage = new ReleasesPage(driver);
        IssuePage issuePage = new IssuePage(driver);
        EditIssuePopUpScreen editIssuePopUpScreen = new EditIssuePopUpScreen(driver);

        createNewVersion();
        createAndChooseNewIssue();

        issuePage.clickEditIssueButton();
        editIssuePopUpScreen.fillVersionNameInputField(randomVersionNameToTheTest);
        editIssuePopUpScreen.clickUpdateIssueButton();

        releasesPage.navigate("/projects/PP3?selectedItem=com.atlassian.jira.jira-projects-plugin:release-page");
        releasesPage.openASpecifiedVersionPage(randomVersionNameToTheTest);
        assertTrue(releasesPage.checkIssueIsConnectedToTheVersion(randomIssueToTheTest));

        deleteRecentlyCreatedIssue();
        deleteRecentlyCreatedVersion();
    }

    void createNewVersion() {
        ReleasesPage releasesPage = new ReleasesPage(driver);

        releasesPage.navigate("/projects/PP3?selectedItem=com.atlassian.jira.jira-projects-plugin:release-page");
        releasesPage.addNewVersion(randomVersionNameToTheTest);
    }

    void createAndChooseNewIssue() {
        MainPage mainPage = new MainPage(driver);
        CreateScreen createScreen = new CreateScreen(driver);

        mainPage.clickCreateIssueButton();

        createScreen.chooseProject("Private Project 3 (PP3)");
        createScreen.fillSummary(randomIssueToTheTest);
        createScreen.pressSubmitButton();

        createScreen.clickPopUpLink();
    }

    void deleteRecentlyCreatedIssue() {
        ReleasesPage releasesPage = new ReleasesPage(driver);
        IssuePage issuePage = new IssuePage(driver);

        releasesPage.openRecentlyCreatedIssueSummaryPage();
        issuePage.deleteIssueFromItsPage();
    }

    void deleteRecentlyCreatedVersion() throws InterruptedException {
        ReleasesPage releasesPage = new ReleasesPage(driver);

        releasesPage.navigate("/projects/PP3?selectedItem=com.atlassian.jira.jira-projects-plugin:release-page");
        releasesPage.deleteVersion(randomVersionNameToTheTest);
    }

    @Override
    protected void makePomInstances() {

    }
}