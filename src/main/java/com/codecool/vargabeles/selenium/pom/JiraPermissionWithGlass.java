package com.codecool.vargabeles.selenium.pom;

import com.codecool.vargabeles.selenium.pom.pageObjects.BasePage;
import com.codecool.vargabeles.selenium.pom.pageObjects.GlassDocumentationPage;
import com.codecool.vargabeles.selenium.pom.pageObjects.ProjectPage;
import com.codecool.vargabeles.selenium.pom.pageObjects.ProjectSettingPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class JiraPermissionWithGlass extends BasePage {

    JiraPermissionWithGlass(WebDriver driver) {
        super(driver);
    }

    public List<Boolean> checkPermissions() {
        ProjectPage projectPage = new ProjectPage(driver);
        ProjectSettingPage projectSettingPage = new ProjectSettingPage(driver);

        wait.until(ExpectedConditions.urlToBe(System.getenv("baseUrl")));
        navigate("projects/PP1?selectedItem=com.codecanvas.glass:glass");
        projectPage.clickOnProjectSetting();
        projectSettingPage.clickOnPermission();
        return projectSettingPage.getPermissionList();
    }

    public List<Boolean> checkPermissionsWithGlass() throws InterruptedException {
        ProjectPage projectPage = new ProjectPage(driver);
        GlassDocumentationPage glassDocumentationPage = new GlassDocumentationPage(driver);

        navigate("projects/PP1?selectedItem=com.codecanvas.glass:glass");
        projectPage.clickOnGlassDocumentation();
        glassDocumentationPage.clickOnPermission();
        return glassDocumentationPage.getPermissionList();
    }
}

