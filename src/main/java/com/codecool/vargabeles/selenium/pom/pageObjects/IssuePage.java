package com.codecool.vargabeles.selenium.pom.pageObjects;

import org.openqa.selenium.WebDriver;

public class IssuePage extends BasePage{

    public IssuePage(WebDriver webDriver) {
        super(webDriver);
    }

    public String getPageTitle() {
        return driver.getTitle();
    }
}
