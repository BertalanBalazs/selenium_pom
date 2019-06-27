package com.codecool.vargabeles.selenium.pom.pageObjects;

import com.codecool.vargabeles.selenium.pom.pageObjects.BasePage;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;


public class LoginPage extends BasePage{

    @FindBy(id="login-form-username")
    private WebElement userName;

    @FindBy(id="login-form-password")
    private WebElement password;

    @FindBy(id="login")
    private WebElement login;

    @FindBy(xpath = "//*[@id=\"usernameerror\"]/p")
    private WebElement errorMessage;

    public LoginPage(WebDriver driver){
        super(driver);
    }

    private void clickLogin(){
        login.click();
    }

    public void validLogin(String username, String password){
        navigate();
        wait.until(ExpectedConditions.visibilityOf(this.userName));
        wait.until(ExpectedConditions.visibilityOf(this.password));
        this.userName.sendKeys(username);
        this.password.sendKeys(password);
        this.clickLogin();
        MainPage mainPage = new MainPage(driver);
        wait.until(ExpectedConditions.visibilityOf(mainPage.getHeader()));
    }

    public String invalidLogin(String username, String password){
        navigate();
        wait.until(ExpectedConditions.visibilityOf(this.userName));
        wait.until(ExpectedConditions.visibilityOf(this.password));
        this.userName.sendKeys(username);
        this.password.sendKeys(password);
        this.clickLogin();
        wait.until(ExpectedConditions.visibilityOf(errorMessage));

        return errorMessage.getText();
    }

}


