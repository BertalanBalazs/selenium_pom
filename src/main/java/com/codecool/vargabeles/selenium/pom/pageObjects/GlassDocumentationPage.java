package com.codecool.vargabeles.selenium.pom.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

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

    public List<Boolean> getPermissionList(){
        List<Boolean> permissionList = new ArrayList<>();

        if (driver.findElement(By.xpath("//*[@id=\"glass-permissions-panel\"]/div/table/tbody/tr[6]/td[3]/div")).getAttribute("class").equals("glass-true-icon")) {
            permissionList.add(true);
        } else {
            permissionList.add(false);
        }
        if (driver.findElement(By.xpath("//*[@id=\"glass-permissions-panel\"]/div/table/tbody/tr[12]/td[3]")).getAttribute("class").equals("glass-true-icon")) {
            permissionList.add(true);
        } else {
            permissionList.add(false);
        }
        if (driver.findElement(By.xpath("//*[@id=\"glass-permissions-panel\"]/div/table/tbody/tr[18]/td[3]/div")).getAttribute("class").equals("glass-true-icon")) {
            permissionList.add(true);
        } else {
            permissionList.add(false);
        }
        return permissionList;
    }
}
