package com.codecool.vargabeles.selenium.pom;

import com.codecool.vargabeles.selenium.pom.pageObjects.BasePage;
import com.codecool.vargabeles.selenium.pom.pageObjects.CreateScreen;
import com.codecool.vargabeles.selenium.pom.pageObjects.IssuePage;
import com.codecool.vargabeles.selenium.pom.pageObjects.MainPage;
import org.junit.Before;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CreateIssueTest extends BaseTest {



    @Test
    void createGeneralIssueTest() throws InterruptedException {

        BasePage basePage = new BasePage(driver);
        CreateScreen createScreen = new CreateScreen(driver);
        IssuePage issuePage = new IssuePage(driver);
        MainPage mainPage = new MainPage(driver);

        basePage.navigate();
        mainPage.clickCreateIssueButton();

        createScreen.chooseProject("Sandbox (SAND)");
        createScreen.fillSummary("Test summary for create general issue");
        createScreen.pressSubmitButton();

        createScreen.clickPopUpLink();

        issuePage.deleteIssueFromItsPage();
    }

    @Test
    void correctIssueTypeTest() {
        BasePage basePage = new BasePage(driver);
        MainPage mainPage = new MainPage(driver);
        CreateScreen createScreen = new CreateScreen(driver);
        IssuePage issuePage = new IssuePage(driver);

        String issueType = "Task";

        basePage.navigate();
        mainPage.clickCreateIssueButton();

        createScreen.chooseProject("Sandbox (SAND)");
        createScreen.chooseIssueType(issueType);

        createScreen.fillSummary("Test summary for create issue, type test");
        createScreen.pressSubmitButton();

        createScreen.clickPopUpLink();

        Assertions.assertTrue(issuePage.isIssueTypeCorrect(issueType));

        issuePage.deleteIssueFromItsPage();

    }
}
