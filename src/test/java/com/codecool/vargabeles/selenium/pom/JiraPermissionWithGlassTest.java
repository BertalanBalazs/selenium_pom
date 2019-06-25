package com.codecool.vargabeles.selenium.pom;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class JiraPermissionWithGlassTest extends BaseTest {

    JiraPermissionWithGlass jiraPermissionWithGlass;



    @Test
    void checkPermissions() throws InterruptedException {
        jiraPermissionWithGlass = new JiraPermissionWithGlass(driver);
        assertEquals(jiraPermissionWithGlass.checkPermissions(), jiraPermissionWithGlass.checkPermissionsWithGlass());
    }

}