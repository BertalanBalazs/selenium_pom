package com.codecool.vargabeles.selenium.pom;

import com.codecool.vargabeles.selenium.pom.pageObjects.BasePage;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class JiraLogin extends BasePage {

    @FindBy(id = "login-form-username")
    WebElement userName;
    @FindBy(id = "login-form-password")
    WebElement password;
    @FindBy(id = "login")
    WebElement login;
    @FindBy(id = "header-details-user-fullname")
    WebElement header;

    public JiraLogin(WebDriver driver){
        super(driver);
    }

    public void clickLogin(){
        login.click();
    }

    boolean isLoggedIn() {
        try {
            header.isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
        return true;
    }

    public void loginToJira(String username, String password){
        navigate();
        userName.sendKeys(username);
        this.password.sendKeys(password);
        this.clickLogin();
    }

}
