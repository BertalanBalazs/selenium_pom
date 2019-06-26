package com.codecool.vargabeles.selenium.pom.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {

    public WebDriver driver;
    public WebDriverWait wait;

    public BasePage(WebDriver webDriver) {
        this.driver = webDriver;
        wait = new WebDriverWait(this.driver, 10);
        PageFactory.initElements(driver,this);
    }

    public void navigate(String subUrl){
        driver.navigate().to(System.getenv("baseUrl") + subUrl);
    }

    public void navigate(){
        driver.navigate().to(System.getenv("baseUrl"));
    }
}
