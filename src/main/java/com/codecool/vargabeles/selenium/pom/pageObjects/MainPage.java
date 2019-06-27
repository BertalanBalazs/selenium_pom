package com.codecool.vargabeles.selenium.pom.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class MainPage extends BasePage {

    @FindBy(id="header-details-user-fullname")
    private WebElement header;

    @FindBy(id="create_link")
    private WebElement createIssueButton;

    @FindBy(id="log_out")
    WebElement logoutOption;


    public MainPage(WebDriver driver) {
        super(driver);
    }

    public WebElement getHeader() {
        return header;
    }

    public boolean isLoggedIn() {
        try {
            header.isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
        return true;
    }

    public void clickCreateIssueButton() {
        createIssueButton.click();
    }

    public void logout() {
        header.click();
        wait.until(ExpectedConditions.visibilityOf(logoutOption));
        logoutOption.click();
    }
}