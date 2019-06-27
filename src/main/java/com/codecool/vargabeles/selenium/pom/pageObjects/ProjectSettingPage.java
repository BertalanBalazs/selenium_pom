package com.codecool.vargabeles.selenium.pom.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class ProjectSettingPage extends BasePage {

    @FindBy(xpath = "//a[@id='view_project_permissions']")
    WebElement permission;

    public ProjectSettingPage(WebDriver webDriver) {
        super(webDriver);
    }

    public void clickOnPermission() {
        permission.click();
    }

    public List<Boolean> getPermissionList() {
        List<Boolean> permissionList = new ArrayList<>();
        if (driver.findElement(By.cssSelector(".permissions-group:nth-child(2) tr:nth-child(4) dd")).getText().equals("Any logged in user")) {
            permissionList.add(true);
        } else {
            permissionList.add(false);
        }
        if (driver.findElement(By.xpath("//*[@id=\"project-config-panel-permissions\"]/jira-permissions-table/div[2]/table/tbody/tr[5]/td[2]/dl/dd")).getText().equals("Any logged in user")) {
            permissionList.add(true);
        } else {
            permissionList.add(false);
        }
        if (driver.findElement(By.cssSelector(".permissions-group:nth-child(2) tr:nth-child(6) dd")).getText().equals("Any logged in user")) {
            permissionList.add(true);
        } else {
            permissionList.add(false);
        }
        return permissionList;
    }
}