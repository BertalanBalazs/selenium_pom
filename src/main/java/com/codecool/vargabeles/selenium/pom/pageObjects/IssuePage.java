package com.codecool.vargabeles.selenium.pom.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class IssuePage extends BasePage {
    @FindBy(xpath = "//a[@id='edit-issue']/span[@class='trigger-label' and 2]")
    WebElement editButton;
    @FindBy(id = "edit-issue-submit")
    WebElement editSubmitButton;
    @FindBy(xpath = "//span[text()='Glass Documentation']")
    WebElement glassDocumentation;
    @FindBy(xpath = "//textarea[@id='components-textarea']")
    WebElement componentsTextarea;

    public IssuePage(WebDriver webDriver) {
        super(webDriver);
    }

    public void sendKeyToComponentsTextarea(String text) {
        componentsTextarea.sendKeys(text);
    }

    public void clickToEditButton() {
        editButton.click();
    }

    public void clickToEditSubmitButton() {
        editSubmitButton.click();
    }

    public void clickToGlassDocumentation() {
        glassDocumentation.click();
    }

}
