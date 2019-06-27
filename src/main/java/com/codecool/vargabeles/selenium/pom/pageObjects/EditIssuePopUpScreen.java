package com.codecool.vargabeles.selenium.pom.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class EditIssuePopUpScreen extends BasePage {

    @FindBy(xpath = "//textarea[@id='fixVersions-textarea']")
    private WebElement versionsInputField;

    @FindBy(xpath = "//input[@id='edit-issue-submit']")
    private WebElement updateIssueButton;

    public EditIssuePopUpScreen(WebDriver driver) {
        super(driver);
    }

    public void fillVersionNameInputField(String versionName) {
        versionsInputField.sendKeys(versionName);
    }

    public void clickUpdateIssueButton() {
        updateIssueButton.click();
    }
}