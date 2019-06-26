package com.codecool.vargabeles.selenium.pom.pageObjects;

import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ReleasesPage extends BasePage {

    @FindBy(xpath = "//div[@class='releases-add__name']/input[@class='text' and 1]")
    private
    WebElement versionNameInputField;

    @FindBy(xpath = "//input[@id='version-filter-text']")
    private
    WebElement searchVersionInputField;

    @FindBy(xpath = "//button")
    private
    WebElement newVersionAddButton;

    @FindBy(xpath = "//span[@class='aui-icon aui-icon-small aui-iconfont-more']")
    private
    WebElement versionDropdownMenu;

    @FindBy(xpath = "//a[@class='project-config-operations-delete']")
    private
    WebElement deleteVersionButton;

    @FindBy(xpath = "//input[@id='submit']")
    private
    WebElement confirmDeleteButton;

    public ReleasesPage(WebDriver webDriver) {
        super(webDriver);
    }

    public void addTextToTheInputField(String versionName){
        versionNameInputField.sendKeys(versionName);
    }

    public void clickOnNewVersionAddButton(){
        newVersionAddButton.click();
    }

    public void addNewVersion(String versionName){
        addTextToTheInputField(versionName);
        clickOnNewVersionAddButton();
    }

    public void findVersion(String versionName){
        searchVersionInputField.sendKeys(versionName);
    }

    public void deleteVersion(String versionName) throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOf(searchVersionInputField));
        findVersion(versionName);
        Thread.sleep(100);
        versionDropdownMenu.click();
        deleteVersionButton.click();
        confirmDeleteButton.click();
    }
}
