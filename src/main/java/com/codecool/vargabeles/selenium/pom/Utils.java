package com.codecool.vargabeles.selenium.pom;

import org.openqa.selenium.WebDriver;

public class Utils {

    private static WebDriver webDriver;

    public static void navigate(String subUrl){
        webDriver.navigate().to(System.getenv("baseUrl") + subUrl);
    }

    public static void navigate(){
        webDriver.navigate().to(System.getenv("baseUrl"));
    }

    static void setDriver(WebDriver driver) {
        webDriver = driver;
    }
}
