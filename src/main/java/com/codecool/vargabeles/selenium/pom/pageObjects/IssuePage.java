package com.codecool.vargabeles.selenium.pom.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;


public class IssuePage extends BasePage {

    @FindBy(id="edit-issue") private WebElement editButtonLocator;
    @FindBy(id="aui-flag-container") private WebElement updatedPopupLocator;
    @FindBy(id="summary-val") private WebElement summaryField;
    @FindBy(id="type-val") private WebElement issueTypeLocator;
    @FindBy(id="issuetype-single-select") private WebElement issueTypeSelectLocator;
    @FindBy(xpath="//span[@class='aui-icon aui-icon-small aui-iconfont-success']") private WebElement submitButtonLocator;
//    @FindBy(xpath="//*[@id=\"issuetype-form\"]/span") private WebElement loadingSubmitLocator;

    public IssuePage(WebDriver webDriver) {
        super(webDriver);
    }

    public void clickOnEditButton() {
        this.editButtonLocator.click();
    }

    public boolean validateSummaryEdited(String textText) {
        wait.until(ExpectedConditions.visibilityOf(updatedPopupLocator));
        return this.summaryField.getText().equals(textText);
    }

    public void editIssueType(String issueType) {
        this.issueTypeLocator.click();
        wait.until(ExpectedConditions.visibilityOf(issueTypeSelectLocator));
        this.issueTypeSelectLocator.click();
        driver.findElement(By.id(issueType)).click();
        wait.until(ExpectedConditions.visibilityOf(submitButtonLocator));
        this.submitButtonLocator.click();
    }

    public boolean validateIssueTypeEdited(String type) {
//        wait.until(ExpectedConditions.invisibilityOf(loadingSubmitLocator));
        wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.xpath("//*[@id=\"issuetype-form\"]/span"))));
        return this.issueTypeLocator.getText().equals(type);
    }
}


