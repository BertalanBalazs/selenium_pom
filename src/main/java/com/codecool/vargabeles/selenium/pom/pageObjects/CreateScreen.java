package com.codecool.vargabeles.selenium.pom.pageObjects;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CreateScreen extends BasePage {

    @FindBy(id="project-field") private WebElement projectDropdown;
    @FindBy(id="summary") private WebElement summaryField;
    @FindBy(id="create-issue-submit") private WebElement submitButton;
    @FindBy(className="issue-created-key") private WebElement popUpLink;
    @FindBy(id="issuetype-field") private WebElement issueTypeDropdown;


    public CreateScreen(WebDriver webDriver) {
        super(webDriver);
    }

    public void chooseProject(String projectName) {
        waitUntilFieldsAreLoaded();

        projectDropdown.click();
        projectDropdown.sendKeys(projectName);
        projectDropdown.sendKeys(Keys.RETURN);
    }

    public void chooseIssueType(String issueType) {
        waitUntilFieldsAreLoaded();

        issueTypeDropdown.click();
        issueTypeDropdown.sendKeys(issueType);
        issueTypeDropdown.sendKeys(Keys.RETURN);
    }

    public void waitUntilFieldsAreLoaded() {

        wait.until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver driver) {
                String disabled = summaryField.getAttribute("disabled");
                if(disabled == null) {
                    return true;
                }
                else {
                    return false;
                }
            }
        });

    }

    public void fillSummary(String summaryText) {
        waitUntilFieldsAreLoaded();
        summaryField.click();
        summaryField.sendKeys(summaryText);
    }

    public void pressSubmitButton() {
        submitButton.click();
    }

    public void waitForPopUpLink() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("issue-created-key")));
    }

    public void clickPopUpLink() {
        waitForPopUpLink();
        popUpLink.click();
    }














}
