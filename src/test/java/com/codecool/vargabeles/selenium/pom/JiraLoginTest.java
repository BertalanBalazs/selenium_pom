package com.codecool.vargabeles.selenium.pom;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.*;

class JiraLoginTest {
    private WebDriver driver;
    private JiraLogin jiraLogin;

    @BeforeEach
    void setUp() {
        System.setProperty("webdriver.chrome.driver", System.getenv("webdriverRoute"));
        driver = new ChromeDriver();
        jiraLogin = new JiraLogin(driver);
    }

    @AfterEach
    void tearDown() {
        driver.close();
    }

    @Test
    void loginToJira() {
        jiraLogin.loginToJira();
    }
}