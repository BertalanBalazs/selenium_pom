package com.codecool.vargabeles.selenium.pom;

import com.codecool.vargabeles.selenium.pom.pageObjects.GlassDocumentationPage;
import com.codecool.vargabeles.selenium.pom.pageObjects.GlassDocumentationPermissionPage;
import com.codecool.vargabeles.selenium.pom.pageObjects.ProjectPage;
import com.codecool.vargabeles.selenium.pom.pageObjects.ProjectSettingPage;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class JiraPermissionWithGlassTest extends BaseTest {

    ProjectPage projectPage;
    ProjectSettingPage projectSettingPage;
    GlassDocumentationPermissionPage glassDocumentationPermissionPage;
    GlassDocumentationPage glassDocumentationPage;


    @Override
    protected void makePomInstances() {
        projectPage = new ProjectPage(driver);
        projectSettingPage = new ProjectSettingPage(driver);
        glassDocumentationPermissionPage = new GlassDocumentationPermissionPage(driver);
        glassDocumentationPage = new GlassDocumentationPage(driver);
    }

    @Test
    void checkPermissions() {
        Boolean[][] permissionList = getPermissionList();


        projectPage.navigate("projects/PP1?selectedItem=com.codecanvas.glass:glass");
        glassDocumentationPage.clickOnPermission();
        Boolean[][] checkPermissionWithGlassList = glassDocumentationPermissionPage.getPermissionList();
        assertArrayEquals(permissionList, checkPermissionWithGlassList);
    }

    private Boolean[][] getPermissionList() {
        Boolean[][] permissionList = new Boolean[][]{
            { true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, false, true, true, true, true, true},
            { true, false, true, true, true, true, true, true, false, false, false, false, true, true, true, false, false, true, true, true, true, true, true, false, false, true, true, true, false, true, true, true, true, true},
            { false, true, false, false, false, false, false, false, true, true, true, true, false, false, false, true, true, false, false, false, false, false, false, true, true, false, false, false, false, false, false, false, false, false},
            { false, false, false, false, false, false, false, false, false, false, false, true, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false},
        };
        return permissionList;
    }
}