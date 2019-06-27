package com.codecool.vargabeles.selenium.pom.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainPage extends BasePage{

    @FindBy(id="header-details-user-fullname")
    private WebElement header;

    @FindBy(id="create_link")
    private WebElement createIssueButton;


    public MainPage(WebDriver webDriver) {
        super(webDriver);
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
}
