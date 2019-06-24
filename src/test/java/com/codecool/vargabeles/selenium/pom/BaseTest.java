package com.codecool.vargabeles.selenium.pom;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseTest {

    WebDriver driver;

    @BeforeEach
    void setUp() {
        JiraLogin login = new JiraLogin(driver);
        System.setProperty("webdriver.chrome.driver", System.getenv("webdriverPath"));
        driver = new ChromeDriver();
        login.loginToJira(System.getenv("username"), System.getenv("password"));
    }

    @AfterEach
    void tearDown() {
        driver.close();
    }
}