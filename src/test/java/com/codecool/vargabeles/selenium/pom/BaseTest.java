package com.codecool.vargabeles.selenium.pom;

import com.codecool.vargabeles.selenium.pom.pageObject.JiraLogin;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseTest {

    WebDriver driver;

    @BeforeEach
    void setUp() {
        driver = new ChromeDriver();
        JiraLogin login = new JiraLogin(driver);
        System.setProperty("webdriver.chrome.driver", System.getenv("webdriverPath"));
        login.loginToJira(System.getenv("username"), System.getenv("password"));
    }

    @AfterEach
    void tearDown() {
        driver.close();
    }
}
