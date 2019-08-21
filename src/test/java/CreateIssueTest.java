import com.codecool.vargabeles.selenium.pom.pageObjects.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class CreateIssueTest extends BaseTest{

    @Override
    protected void makePomInstances() {
    }

    @Test
    void createGeneralIssueTest() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        BasePage basePage = new BasePage(driver);
        CreateScreen createScreen = new CreateScreen(driver);
        IssuePage issuePage = new IssuePage(driver);
        MainPage mainPage = new MainPage(driver);

        String summaryText = "Test summary for create general issue";

        basePage.navigate();
        mainPage.clickCreateIssueButton();

        createScreen.chooseProject("Sandbox (SAND)");
        createScreen.fillSummary(summaryText);
        createScreen.pressSubmitButton();

        createScreen.clickPopUpLink();
        assertEquals(summaryText,issuePage.getSummaryText());

        issuePage.deleteIssueFromItsPage();
    }

    @Test
    void correctIssueTypeTest() {
        LoginPage loginPage = new LoginPage(driver);
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

        assertTrue(issuePage.isIssueTypeCorrect(issueType));

        issuePage.deleteIssueFromItsPage();

    }

    @ParameterizedTest
    @CsvFileSource(resources = "/issueTypes.csv", numLinesToSkip = 1)
    void expectedIssueTypesTest(String username, String projectName, String issueType) {

        LoginPage loginPage = new LoginPage(driver);
        BasePage basePage = new BasePage(driver);
        MainPage mainPage = new MainPage(driver);
        CreateScreen createScreen = new CreateScreen(driver);

        basePage.navigate();
        mainPage.clickCreateIssueButton();

        createScreen.chooseProject(projectName);
        assertTrue(createScreen.isProjectNameValid());
        createScreen.chooseIssueType(issueType);
        assertTrue(createScreen.isIssueTypeValid());
    }
}