package com.codecool.vargabeles.selenium.pom.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

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
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//textarea[@id='components-textarea']")));
        componentsTextarea.sendKeys(text);
    }

    public void clickToEditButton() {
        editButton.click();
    }

    public void clickToEditSubmitButton() {
        editSubmitButton.click();
    }

    public void clickToGlassDocumentation() {
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Glass Documentation']")));
        glassDocumentation.click();
    }


    public void addComponentToIssue(String component) {
        clickToEditButton();
        sendKeyToComponentsTextarea(component);
        clickToEditSubmitButton();
    }
}
