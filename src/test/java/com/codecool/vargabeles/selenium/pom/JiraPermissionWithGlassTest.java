package com.codecool.vargabeles.selenium.pom;

import com.codecool.vargabeles.selenium.pom.pageObjects.GlassDocumentationPage;
import com.codecool.vargabeles.selenium.pom.pageObjects.GlassDocumentationPermissionPage;
import com.codecool.vargabeles.selenium.pom.pageObjects.ProjectPage;
import com.codecool.vargabeles.selenium.pom.pageObjects.ProjectSettingPage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class JiraPermissionWithGlassTest extends BaseTest {

    ProjectPage projectPage;
    ProjectSettingPage projectSettingPage;
    GlassDocumentationPermissionPage glassDocumentationPermissionPage;
    GlassDocumentationPage glassDocumentationPage;

    @BeforeEach
    void setup() {

    }

    @Override
    protected void makePomInstances() {
        projectPage = new ProjectPage(driver);
        projectSettingPage = new ProjectSettingPage(driver);
        glassDocumentationPermissionPage = new GlassDocumentationPermissionPage(driver);
        glassDocumentationPage = new GlassDocumentationPage(driver);
    }


    @Test
    void checkPermissions() {
        String[][] dataFromCsv = glassDocumentationPermissionPage.readPermissionDataFromCsv();
        projectPage.navigate("/projects/PERMTEST?selectedItem=com.codecanvas.glass:glass");
        glassDocumentationPage.clickOnPermission();
        String[][] checkPermissionWithGlassList = glassDocumentationPermissionPage.getPermissionList();
        assertArrayEquals(dataFromCsv, checkPermissionWithGlassList);
    }
}