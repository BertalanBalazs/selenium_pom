package com.codecool.vargabeles.selenium.pom.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ProjectPage extends BasePage {

    @FindBy(xpath = "//span[@class='aui-button-label']")
    WebElement projectSetting;

    @FindBy(xpath = "//span[text()='Glass Documentation']")
    WebElement glassDocumentation;



    public ProjectPage(WebDriver webDriver) {
        super(webDriver);
    }

    public void clickOnProjectSetting(){
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[@class='aui-button-label']")));
        projectSetting.click();
    }

    public void clickOnGlassDocumentation(){
        glassDocumentation.click();
    }





}
