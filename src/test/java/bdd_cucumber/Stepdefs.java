package bdd_cucumber;
import com.codecool.vargabeles.selenium.pom.pageObjects.LoginPage;
import com.codecool.vargabeles.selenium.pom.pageObjects.MainPage;

import cucumber.api.Scenario;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;
import org.junit.After;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.Assert.*;

public class Stepdefs {
    private MainPage mainPage;
    private WebDriver driver;
    private WebDriverWait wait;
    private LoginPage loginPage;

    @FindBy(id="header-details-user-fullname")
    private WebElement header;

    @FindBy(id = "login-form-username")
    private WebElement userName;

    @FindBy(id = "login-form-passWord")
    private WebElement passWord;

    @FindBy(id = "login")
    private WebElement login;

    @FindBy(xpath = "//*[@id=\"usernameerror\"]/p")
    private WebElement errorMessage;


    void setUp() {
        System.setProperty("webdriver.chrome.driver", System.getenv("webdriverPath"));
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        loginPage = new LoginPage(driver);
        wait = new WebDriverWait(this.driver, 10);
    }

    @After
    public void tearDown(Scenario scenario) {
        if (scenario.isFailed()) {
            // Take a screenshot...
            final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            scenario.embed(screenshot, "image/png"); // ... and embed it in the report.
        }
    }

    @Given("^I am on the Jira login page$")
    public void I_visit_jira() {
        setUp();
        driver.get("https://jira.codecool.codecanvas.hu/secure/Dashboard.jspa");
    }

    @When("^Type the \"([^\"]*)\" to the username field$")
    public void type_username(String username) {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        userName.sendKeys(username);
    }

    @When("^Type the \"([^\"]*)\" to the password field$")
    public void type_password(String password) {
        wait.until(ExpectedConditions.visibilityOf(this.passWord));
        this.passWord.sendKeys(password);
        login.click();
        wait.until(ExpectedConditions.visibilityOf(errorMessage));
    }

    @Then("^We have to be logged in$")
    public void i_should_be_told(String expectedAnswer) {
        mainPage = new MainPage(driver);
        boolean isLoggedin = mainPage.isLoggedIn();
        assertTrue(isLoggedin);
        driver.close();
    }


}
