package com.codecool.vargabeles.selenium.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

class BasePage {

    WebDriver driver;
    WebDriverWait wait;

    BasePage(WebDriver webDriver) {
        this.driver = webDriver;
        wait = new WebDriverWait(this.driver, 5);
    }

    void navigate(String subUrl){
        driver.navigate().to(System.getenv("baseUrl") + subUrl);
    }

    void navigate(){
        driver.navigate().to(System.getenv("baseUrl"));
    }
}
