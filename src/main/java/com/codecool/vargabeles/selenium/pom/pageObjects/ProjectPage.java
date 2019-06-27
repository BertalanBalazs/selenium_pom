package com.codecool.vargabeles.selenium.pom.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProjectPage extends BasePage {

    @FindBy(xpath = "//a[@class='aui-button aui-button-subtle aui-sidebar-settings-button']/span[@class='aui-icon aui-icon-small aui-iconfont-configure' and 1]")
    WebElement projectSetting;

    @FindBy(xpath = "//span[text()='Glass Documentation']")
    WebElement glassDocumentation;

    public ProjectPage(WebDriver driver) {
        super(driver);
    }

    public void clickOnProjectSetting() {
        projectSetting.click();
    }

    public void clickOnGlassDocumentation() {
        glassDocumentation.click();
    }
}
