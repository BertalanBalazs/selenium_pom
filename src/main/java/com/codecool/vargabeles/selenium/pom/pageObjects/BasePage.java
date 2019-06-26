package com.codecool.vargabeles.selenium.pom.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {

    WebDriver driver;
    WebDriverWait wait;

    public BasePage(WebDriver webDriver) {
        this.driver = webDriver;
        wait = new WebDriverWait(this.driver, 10);
    }

    public void navigate(String subUrl){
        driver.navigate().to(System.getenv("baseUrl") + subUrl);
    }

    public void navigate(){
        driver.navigate().to(System.getenv("baseUrl"));
    }
}
