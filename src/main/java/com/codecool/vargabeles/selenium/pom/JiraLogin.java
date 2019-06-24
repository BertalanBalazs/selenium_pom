package com.codecool.vargabeles.selenium.pom;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;


public class JiraLogin {

    WebDriver driver;

    By userName = By.name(System.getenv("JiraUsername"));

    By password = By.name(System.getenv("JiraPassword"));

    By titleText =By.className("barone");

    By login = By.name("btnLogin");

    public JiraLogin(WebDriver driver){
        this.driver = driver;
    }


    //Click on login button

    public void clickLogin(){

        driver.findElement(login).click();

    }

    //Get the title of Login Page

    public String getLoginTitle(){
        return    driver.findElement(titleText).getText();

    }


    public void loginToJira(){
        this.clickLogin();
    }

}
