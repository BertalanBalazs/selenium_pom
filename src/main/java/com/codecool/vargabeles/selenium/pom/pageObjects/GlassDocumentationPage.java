package com.codecool.vargabeles.selenium.pom.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.ArrayList;
import java.util.List;

public class GlassDocumentationPage extends BasePage {
    @FindBy(xpath = "//a[text()='Permissions']")
    WebElement permission;

    public GlassDocumentationPage(WebDriver webDriver) {
        super(webDriver);
    }


    public void clickOnPermission() {
        permission.click();
    }


    public int getNumOfComponentsOfIssue(){
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Components ']")));
        int i = 1;
        //investigate the correction
        while (true) {
            try {
                if ("testing".equals(driver.findElement(By.cssSelector("#components-table > tbody.items > tr:nth-child(" + i + ") > td.components-table__name > div > a")).getText())) {
                    return Integer.parseInt(driver.findElement(By.cssSelector("#components-table > tbody.items > tr:nth-child(" + i + ") > td.components-table__issues-count > div > a")).getText());
                }
                i++;
            } catch (NumberFormatException e) {
                break;
            }
        }
        return Integer.parseInt(null);
    }
}
