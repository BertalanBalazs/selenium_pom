package com.codecool.vargabeles.selenium.pom;

import com.codecool.vargabeles.selenium.pom.pageObjects.LoginPage;
import com.codecool.vargabeles.selenium.pom.pageObjects.MainPage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.*;

class JiraLoginTest {

    private LoginPage loginPage;
    private MainPage mainPage;
    private WebDriver driver;

    @BeforeEach
    void setUp() {
        System.setProperty("webdriver.chrome.driver", System.getenv("webdriverPath"));
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        loginPage = new LoginPage(driver);
    }

    @AfterEach
    void tearDown() {
        driver.close();
    }

    @Test
    void testLoginWithValidCredentials() {
        loginPage.validLogin(System.getenv("username"),System.getenv("password"));
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
        String errormessage = loginPage.invalidLogin(System.getenv("username"), "");
        assertEquals("Sorry, your username and password are incorrect - please try again.", errormessage);
    }

}
