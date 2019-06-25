package com.codecool.vargabeles.selenium.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{

    @FindBy(id="login-form-username")
    private WebElement userName;

    @FindBy(id="login-form-password")
    private WebElement password;

    @FindBy(id="login")
    private WebElement login;

    public LoginPage(WebDriver driver){
        super(driver);
    }

    public void clickLogin(){
        login.click();
    }


    public void login(String username, String password){
        navigate();
        this.userName.sendKeys(username);
        this.password.sendKeys(password);
        this.clickLogin();
    }

}
