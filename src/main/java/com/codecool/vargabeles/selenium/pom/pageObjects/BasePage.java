package com.codecool.vargabeles.selenium.pom.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {

    protected final WebDriver driver;
    protected WebDriverWait wait;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(this.driver, 10);
        PageFactory.initElements(this.driver,  this);
    }

    public void navigate(String subUrl) {
        driver.navigate().to("https://jira.codecool.codecanvas.hu/secure/Dashboard.jspa" + subUrl);
    }

    public void navigate() {
        driver.navigate().to("https://jira.codecool.codecanvas.hu/secure/Dashboard.jspa");
    }

    public String getCurrentPageTitle() {
        return driver.getTitle();
    }
}