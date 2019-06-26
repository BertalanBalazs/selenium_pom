package com.codecool.vargabeles.selenium.pom.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class IssuePage extends BasePage {

    private By moreButtonLocator = By.id("opsbar-operations_more");
    private By deleteIssueButtonLocator = By.cssSelector("aui-item-link[title=\"Delete this issue\"]");
    private By deleteIssueConfirmButtonLocator = By.id("delete-issue-submit");


    public IssuePage(WebDriver webDriver) {
        super(webDriver);
    }

    public void clickMoreButton() {
        driver.findElement(moreButtonLocator).click();
    }

    public void clickDeleteIssueButton() {
        driver.findElement(deleteIssueButtonLocator).click();
    }

    public void waitForDeleteIssueConfirmButton(){
            wait.until(ExpectedConditions.visibilityOfElementLocated(deleteIssueConfirmButtonLocator));
    }

    public String getPageTitle() {
        return driver.getTitle();
    }

    public void clickdeleteIssueConfirmButton() {
        driver.findElement(deleteIssueConfirmButtonLocator).click();
    }

    public void deleteIssueFromItsPage() {
        clickMoreButton();
        clickDeleteIssueButton();
        waitForDeleteIssueConfirmButton();
        clickdeleteIssueConfirmButton();
    }
}
