package com.codecool.vargabeles.selenium.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;


public class JiraLogin extends BasePage{

    By userName = By.id("login-form-username");

    By password = By.id("login-form-username");

    By login = By.id("login");

    By header = By.id("header-details-user-fullname");

    public JiraLogin(WebDriver driver){
        super(driver);
    }

    public void clickLogin(){
        driver.findElement(login).click();

    }

    boolean isLoggedIn() {
        try {
            driver.findElement(By.id("header-details-user-fullname")).isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
        return true;
    }

    public void loginToJira(String username, String password){
        navigate();
        wait.until(ExpectedConditions.visibilityOfElementLocated(this.userName));
        wait.until(ExpectedConditions.visibilityOfElementLocated(this.password));
        driver.findElement(this.userName).sendKeys(username);
        driver.findElement(this.password).sendKeys(password);
        this.clickLogin();
        wait.until(ExpectedConditions.visibilityOfElementLocated(this.header));
    }

}
