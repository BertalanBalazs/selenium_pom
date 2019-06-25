package com.codecool.vargabeles.selenium.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CreateScreen extends BasePage {

    By projectDropdownLocator = By.id("project-field");
    By summaryFieldLocator = By.id("summary");
    By submitButtonLocator = By.id("create-issue-submit");
    By popUpLinkLocator = By.id(".issue-created-key");

    public CreateScreen(WebDriver webDriver) {
        super(webDriver);
    }

    public void waitUntilScreenLoaded() {
//  toDo:
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#create-issue-dialog > div.jira-dialog-heading > h2")));
    }

    public void chooseProject(String projectName) {
        WebElement projectDropdown = driver.findElement(projectDropdownLocator);

        projectDropdown.click();
        projectDropdown.sendKeys(projectName);
        projectDropdown.sendKeys(Keys.RETURN);
    }

    public void waitUntilSummaryIsLoaded() throws InterruptedException {
//        wait.until(ExpectedConditions.elementToBeClickable(By.id("summary")));
//  toDo:
        Thread.sleep(2000);
    }

    public void fillSummary(String summaryText) {
//        "Test summary for create issue"
        driver.findElement(summaryFieldLocator).sendKeys(summaryText);
    }

    public void pressSubmitButton() {
        driver.findElement(submitButtonLocator).click();
    }

    public void waitForPopUpLink() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(popUpLinkLocator));
        driver.findElement(popUpLinkLocator).click();
    }














}
