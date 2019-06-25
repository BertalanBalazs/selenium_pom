package com.codecool.vargabeles.selenium.pom;

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
        loginPage = new LoginPage(driver);
    }

    @AfterEach
    void tearDown() {
        driver.close();
    }

    @Test
    void testLoginWithValidCredentials() {
        loginPage.login(System.getenv("username"), System.getenv("password"));
        mainPage = new MainPage(driver);
        assertTrue(mainPage.isLoggedIn());
    }

}