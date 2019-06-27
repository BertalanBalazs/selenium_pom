package com.codecool.vargabeles.selenium.pom.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;


public class EditIssuePage extends BasePage {

    @FindBy(id = "edit-issue-dialog")
    private WebElement editPageLocator;
    @FindBy(id = "summary")
    private WebElement summaryFieldLocator;
    @FindBy(id = "edit-issue-submit")
    private WebElement submitButtonLocator;


    public EditIssuePage(WebDriver webDriver) {
        super(webDriver);
    }

    public void editSummaryField(String testText) {
        wait.until(ExpectedConditions.visibilityOf(editPageLocator));
        this.summaryFieldLocator.sendKeys(testText);
        this.submitButtonLocator.click();
    }

}