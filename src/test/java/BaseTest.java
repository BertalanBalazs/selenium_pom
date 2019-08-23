import com.codecool.vargabeles.selenium.pom.pageObjects.LoginPage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

abstract class BaseTest {

    WebDriver driver;
    String nodeUrl;


    //The chromedriver and the Selenium Standalone driver have to be in the same folder!
    @BeforeEach
    void setUp() throws MalformedURLException {
        nodeUrl = "http://localhost:4444/wd/hub";
        FirefoxOptions capability = new FirefoxOptions();
        driver = new RemoteWebDriver(new URL(nodeUrl), capability);
        LoginPage login = new LoginPage(driver);
        login.validLogin(System.getProperty("username"), System.getProperty("password"));
        makePomInstances();
    }

    void makePomInstances(){ }

    @AfterEach
    void tearDown() {
        driver.quit();
    }
}