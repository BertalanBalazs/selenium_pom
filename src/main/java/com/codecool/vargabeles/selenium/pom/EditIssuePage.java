package com.codecool.vargabeles.selenium.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

class EditIssuePage extends BasePage {

    private By editPageLocator = By.id("edit-issue-dialog");
    private By summaryFieldLocator = By.id("summary");
    private By submitButtonLocator = By.id("edit-issue-submit");


    EditIssuePage(WebDriver webDriver) {
        super(webDriver);
    }

    void editSummaryField(String testText) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(editPageLocator));
        driver.findElement(summaryFieldLocator).sendKeys(testText);
        driver.findElement(submitButtonLocator).click();
    }

    void restoreSummeryField(String origiText) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(editPageLocator));
        driver.findElement(summaryFieldLocator).sendKeys(origiText);
        driver.findElement(submitButtonLocator).click();
    }
}
