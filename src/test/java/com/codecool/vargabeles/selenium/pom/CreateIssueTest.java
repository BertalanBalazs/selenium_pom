package com.codecool.vargabeles.selenium.pom;

import com.codecool.vargabeles.selenium.pom.pageObject.BasePage;
import com.codecool.vargabeles.selenium.pom.pageObject.CreateScreen;
import com.codecool.vargabeles.selenium.pom.pageObject.IssuePage;
import com.codecool.vargabeles.selenium.pom.pageObject.MainPage;
import org.junit.Before;
import org.junit.jupiter.api.Test;

public class CreateIssueTest extends BaseTest {



    @Test
    void createIssueTest() throws InterruptedException {

        BasePage basePage = new BasePage(driver);
        CreateScreen createScreen = new CreateScreen(driver);
        IssuePage issuePage = new IssuePage(driver);
        MainPage mainPage = new MainPage(driver);

        basePage.navigate();
        mainPage.clickCreateIssueButton();

        createScreen.chooseProject("Sandbox (SAND)");
        createScreen.fillSummary("Test summary for create issue");
        createScreen.pressSubmitButton();

        createScreen.clickPopUpLink();

        issuePage.deleteIssueFromItsPage();
    }
}
