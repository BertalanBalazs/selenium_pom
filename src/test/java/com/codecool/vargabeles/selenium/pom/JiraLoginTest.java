package com.codecool.vargabeles.selenium.pom;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.assertTrue;

class JiraLoginTest{
    private JiraLogin login;
    private WebDriver driver;

    @BeforeEach
    void setUp() {
        System.setProperty("webdriver.chrome.driver", System.getenv("webdriverPath"));
        driver = new ChromeDriver();
        login = new JiraLogin(driver);
    }

    @AfterEach
    void tearDown() {
        driver.close();
    }

    @Test
    void loginToJira() {
        login.loginToJira(System.getenv("username"), System.getenv("password"));
        assertTrue(login.isLoggedIn());
    }

}