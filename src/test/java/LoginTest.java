import com.codecool.vargabeles.selenium.pom.pageObjects.LoginPage;
import com.codecool.vargabeles.selenium.pom.pageObjects.MainPage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class LoginTest {

    private LoginPage loginPage;
    private MainPage mainPage;
    private WebDriver driver;

    @BeforeEach
    void setUp() throws MalformedURLException {
        String nodeUrl = "http://localhost:4444/wd/hub";
        FirefoxOptions capability = new FirefoxOptions();
        driver = new RemoteWebDriver(new URL(nodeUrl), capability);
        loginPage = new LoginPage(driver);


    }


    @AfterEach
    void tearDown() {
        driver.quit();
    }

    @Test
    void testLoginWithValidCredentials() {
        loginPage.validLogin(System.getProperty("username"), System.getProperty("password"));
        mainPage = new MainPage(driver);
        assertTrue(mainPage.isLoggedIn());
    }

    @Test
    void testLoginWithEmptyFields() {
        String errormessage = loginPage.invalidLogin("", "");
        assertEquals("Sorry, your username and password are incorrect - please try again.", errormessage);

    }

    @Test
    void testLoginWithWrongPassword() {
        String errormessage = loginPage.invalidLogin(System.getProperty("username"), "");
        assertEquals("Sorry, your username and password are incorrect - please try again.", errormessage);
    }

}