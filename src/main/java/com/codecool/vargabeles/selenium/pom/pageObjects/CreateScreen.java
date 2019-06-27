package com.codecool.vargabeles.selenium.pom.pageObjects;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CreateScreen extends BasePage {

    private By projectDropdownLocator = By.id("project-field");
    private By summaryFieldLocator = By.id("summary");
    private By submitButtonLocator = By.id("create-issue-submit");
    private By popUpLinkLocator = By.className("issue-created-key");

    public CreateScreen(WebDriver driver) {
        super(driver);
    private By issueTypeDropdownLocator = By.id("issuetype-field");


    public CreateScreen(WebDriver webDriver) {
        super(webDriver);
    }

    private void waitUntilCreateScreenIsLoaded() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("create-issue-submit")));
    }
//    public void waitUntilCreateScreenIsLoaded() {
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("create-issue-submit")));
//    }

    public void chooseProject(String projectName) {
//        waitUntilCreateScreenIsLoaded();
        waitUntilFieldsAreLoaded();

        WebElement projectDropdown = driver.findElement(projectDropdownLocator);

        projectDropdown.click();
        projectDropdown.sendKeys(projectName);
        projectDropdown.sendKeys(Keys.RETURN);
    }

    public void chooseIssueType(String issueType) {
//        waitUntilCreateScreenIsLoaded();
        waitUntilFieldsAreLoaded();

        WebElement issueTypeDropdown = driver. findElement(issueTypeDropdownLocator);

        issueTypeDropdown.click();
        issueTypeDropdown.sendKeys(issueType);
        issueTypeDropdown.sendKeys(Keys.RETURN);
    }

    public void waitUntilFieldsAreLoaded() {

        wait.until((ExpectedCondition<Boolean>) driver -> {
            assert driver != null;
            WebElement summaryField = driver.findElement(summaryFieldLocator);
            String disabled = summaryField.getAttribute("disabled");
            return disabled == null;
        });

    }

    public void fillSummary(String summaryText) {
        waitUntilFieldsAreLoaded();
        driver.findElement(summaryFieldLocator).click();
        driver.findElement(summaryFieldLocator).sendKeys(summaryText);
    }

    public void pressSubmitButton() {
        driver.findElement(submitButtonLocator).click();
    }

    private void waitForPopUpLink() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("issue-created-key")));
    }

    public void clickPopUpLink() {
        waitForPopUpLink();
        driver.findElement(popUpLinkLocator).click();
    }
}