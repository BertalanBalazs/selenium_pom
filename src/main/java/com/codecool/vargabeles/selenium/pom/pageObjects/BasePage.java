package com.codecool.vargabeles.selenium.pom.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {

    protected WebDriver driver;
    protected WebDriverWait wait;

    private final int TimeoutValue = 7;

    protected BasePage(WebDriver webDriver) {
        this.driver = webDriver;
        wait = new WebDriverWait(driver, 10);
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, TimeoutValue), this);
    }


    protected void navigate(String subUrl){
        driver.navigate().to(System.getenv("baseUrl") + subUrl);
    }

    protected void navigate(){
        driver.navigate().to(System.getenv("baseUrl"));
    }
}
