package com.codecool.vargabeles.selenium.pom.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;


public class IssuePage extends BasePage {

    private By editButtonLocator = By.id("edit-issue");
    private By updatedPopupLocator = By.id("aui-flag-container");
    private By summaryField = By.id("summary-val");

    public IssuePage(WebDriver webDriver) {
        super(webDriver);
    }

    public void navigateToIssue(String issueUrl) {
        driver.navigate().to(issueUrl);
        driver.findElement(editButtonLocator).click();
    }

    public boolean validateSummaryEdited(String textText) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(updatedPopupLocator));
        return driver.findElement(summaryField).getText().equals(textText);
    }
}

