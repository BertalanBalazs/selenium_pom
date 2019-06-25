package com.codecool.vargabeles.selenium.pom.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ProjectPage extends BasePage {

    @FindBy(xpath = "//a[@class='aui-button aui-button-subtle aui-sidebar-settings-button']/span[@class='aui-icon aui-icon-small aui-iconfont-configure' and 1]")
    WebElement projectSetting;

    @FindBy(xpath = "//span[text()='Glass Documentation']")
    WebElement glassDocumentation;

    @FindBy(xpath = "//span[text()='Components']")
    WebElement components;



    public ProjectPage(WebDriver webDriver) {
        super(webDriver);
    }

    public void clickOnProjectSetting(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@class='aui-button aui-button-subtle aui-sidebar-settings-button']/span[@class='aui-icon aui-icon-small aui-iconfont-configure' and 1]")));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@class='aui-button aui-button-subtle aui-sidebar-settings-button']/span[@class='aui-icon aui-icon-small aui-iconfont-configure' and 1]")));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@class='aui-button aui-button-subtle aui-sidebar-settings-button']/span[@class='aui-icon aui-icon-small aui-iconfont-configure' and 1]")));
        projectSetting.click();
    }

    public void clickOnGlassDocumentation(){
        glassDocumentation.click();
    }

    public void clickOnComponents(){
        components.click();
    }





}
