package com.codecool.vargabeles.selenium.pom;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

abstract public class BaseTest {

    WebDriver driver;

    @BeforeEach
    void setUp() {
        System.setProperty("webdriver.chrome.driver", System.getenv("webdriverPath"));
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        JiraLogin login = new JiraLogin(driver);
        login.loginToJira(System.getenv("username"), System.getenv("password"));
        makeInstance();
    }

    abstract protected void makeInstance();

    @AfterEach
    void tearDown() {
        driver.close();
    }
}
