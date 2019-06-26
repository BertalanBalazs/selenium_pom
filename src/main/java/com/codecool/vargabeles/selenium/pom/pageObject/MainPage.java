package com.codecool.vargabeles.selenium.pom.pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class MainPage extends BasePage{

    private By createIssueButton = By.id("create_link");




    public MainPage(WebDriver webDriver) {
        super(webDriver);
    }

    public void clickCreateIssueButton() {
        driver.findElement(createIssueButton).click();
    }

}
