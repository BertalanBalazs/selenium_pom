package com.codecool.vargabeles.selenium.pom;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainPage extends BasePage{

    @FindBy(id="header-details-user-fullname")
    WebElement header;

   public MainPage(WebDriver webDriver) {
        super(webDriver);
    }

    boolean isLoggedIn() {
        try {
            header.isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
        return true;
    }
}
