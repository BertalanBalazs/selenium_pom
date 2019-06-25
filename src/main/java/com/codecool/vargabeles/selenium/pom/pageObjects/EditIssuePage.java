package com.codecool.vargabeles.selenium.pom.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;


public class EditIssuePage extends BasePage {

    private By editPageLocator = By.id("edit-issue-dialog");
    private By summaryFieldLocator = By.id("summary");
    private By submitButtonLocator = By.id("edit-issue-submit");


    public EditIssuePage(WebDriver webDriver) {
        super(webDriver);
    }

    public void editSummaryField(String testText) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(editPageLocator));
        driver.findElement(summaryFieldLocator).sendKeys(testText);
        driver.findElement(submitButtonLocator).click();
    }

    public void restoreSummeryField(String origiText) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(editPageLocator));
        driver.findElement(summaryFieldLocator).sendKeys(origiText);
        driver.findElement(submitButtonLocator).click();
    }
}
