package com.codecool.vargabeles.selenium.pom;

import com.codecool.vargabeles.selenium.pom.pageObjects.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class JiraPermissionWithGlass extends BasePage {

    ProjectPage projectPage;
    ProjectSettingPage projectSettingPage;
    GlassDocumentationPermissionPage glassDocumentationPermissionPage;
    GlassDocumentationPage glassDocumentationPage;

    JiraPermissionWithGlass(WebDriver driver) {
        super(driver);
        projectPage = new ProjectPage(driver);
        projectSettingPage = new ProjectSettingPage(driver);
        glassDocumentationPermissionPage = new GlassDocumentationPermissionPage(driver);
        glassDocumentationPage =new GlassDocumentationPage(driver);
    }

    public List<Boolean> checkPermissions() {
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span/img[1]")));
        navigate("projects/PP1?selectedItem=com.codecanvas.glass:glass");
        projectPage.clickOnProjectSetting();
        projectSettingPage.clickOnPermission();
        return projectSettingPage.getPermissionList();
    }

    public List<Boolean> checkPermissionsWithGlass() {
        navigate("projects/PP1?selectedItem=com.codecanvas.glass:glass");
        projectPage.clickOnGlassDocumentation();
        glassDocumentationPage.clickOnPermission();
        return glassDocumentationPermissionPage.getPermissionList();
    }
}

