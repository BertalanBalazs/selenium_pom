package com.codecool.vargabeles.selenium.pom.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ProjectPage extends BasePage {

    @FindBy(xpath = "//span[@class='aui-button-label']") WebElement projectSetting;
    @FindBy(xpath = "//span[text()='Glass Documentation']")
    WebElement glassDocumentation;

    @FindBy(xpath = "//span[text()='Components']")
    WebElement components;



    public ProjectPage(WebDriver webDriver) {
        super(webDriver);
    }

    public void clickOnProjectSetting(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='aui-button-label']")));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[@class='aui-button-label']")));
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//span[@class='aui-button-label']")));
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//span[@class='aui-button-label']")));
        projectSetting.click();
    }

    public void clickOnGlassDocumentation(){
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//span[text()='Glass Documentation']")));
        glassDocumentation.click();
    }

    public void clickOnComponents(){
        components.click();
    }





}
