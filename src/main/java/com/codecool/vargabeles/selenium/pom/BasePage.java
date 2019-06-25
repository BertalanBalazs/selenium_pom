package com.codecool.vargabeles.selenium.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

class BasePage {

    private WebDriver driver;
    WebDriverWait wait;

    BasePage(WebDriver webDriver) {
        this.driver = webDriver;
        wait = new WebDriverWait(this.driver, 10);
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 20), this);
    }

    void navigate(String subUrl){
        driver.navigate().to(System.getenv("baseUrl") + subUrl);
    }

    void navigate(){
        driver.navigate().to(System.getenv("baseUrl"));
    }
}
