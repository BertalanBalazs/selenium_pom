package com.codecool.vargabeles.selenium.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

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

    public void clickdeleteIssueConfirmButton() {
        driver.findElement(deleteIssueConfirmButtonLocator).click();
    }
}
