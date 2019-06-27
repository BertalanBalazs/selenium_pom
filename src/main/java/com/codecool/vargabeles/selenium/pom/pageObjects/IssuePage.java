package com.codecool.vargabeles.selenium.pom.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class IssuePage extends BasePage {

    @FindBy(xpath = "//a[@id='edit-issue']")
    private WebElement editIssueButton;

    private By moreButtonLocator = By.id("opsbar-operations_more");
    private By deleteIssueButtonLocator = By.cssSelector("aui-item-link[title=\"Delete this issue\"]");
    private By deleteIssueConfirmButtonLocator = By.id("delete-issue-submit");

    public IssuePage(WebDriver webDriver) {
        super(webDriver);
    }

    public void clickEditIssueButton() {
        editIssueButton.click();
    }

    private void clickMoreButton() {
        driver.findElement(moreButtonLocator).click();
    }

    private void clickDeleteIssueButton() {
        driver.findElement(deleteIssueButtonLocator).click();
    }

    private void waitForDeleteIssueConfirmButton() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(deleteIssueConfirmButtonLocator));
    }

    public String getPageTitle() {
        return driver.getTitle();
    }

    private void clickdeleteIssueConfirmButton() {
        driver.findElement(deleteIssueConfirmButtonLocator).click();
    }

    public void deleteIssueFromItsPage() {
        clickMoreButton();
        clickDeleteIssueButton();
        waitForDeleteIssueConfirmButton();
        clickdeleteIssueConfirmButton();
    }
}