package com.codecool.vargabeles.selenium.pom;

import com.codecool.vargabeles.selenium.pom.pageObjects.GlassDocumentationPage;
import com.codecool.vargabeles.selenium.pom.pageObjects.ReleasesPage;
import org.junit.jupiter.api.Test;
import java.util.Random;
import static org.junit.jupiter.api.Assertions.assertTrue;

class JiraVersionsWithGlassTest extends BaseTest{

    private String randomVersionNameToTheTest = "TestVersion-" + new Random().nextInt(9999);

    @Test
    void createNewVersionAndCheckVisibilityInGlassTest() throws InterruptedException {
        ReleasesPage releasesPage = new ReleasesPage(driver);
        GlassDocumentationPage glassDocumentationPage = new GlassDocumentationPage(driver);

        releasesPage.navigate("/projects/PP3?selectedItem=com.atlassian.jira.jira-projects-plugin:release-page");
        releasesPage.addNewVersion(randomVersionNameToTheTest);

        glassDocumentationPage.navigate("/projects/PP3?selectedItem=com.codecanvas.glass:glass");
        glassDocumentationPage.clickOnVersions();

        assertTrue(glassDocumentationPage.checkNewlyCreatedTestVersion(randomVersionNameToTheTest));

        releasesPage.navigate("/projects/PP3?selectedItem=com.atlassian.jira.jira-projects-plugin:release-page");
        releasesPage.deleteVersion(randomVersionNameToTheTest);
    }

    @Test
    void connectIssueToVersion() {
        //TODO
        assertTrue(true);
    }

    @Override
    protected void makePomInstances() {

    }
}
