package com.codecool.vargabeles.selenium.pom;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class JiraPermissionWithGlassTest extends BaseTest {

    JiraPermissionWithGlass jiraPermissionWithGlass;


    @Override
    protected void makeInstance() {
        jiraPermissionWithGlass = new JiraPermissionWithGlass(driver);
    }

    @Test
    void checkPermissions() {
        assertEquals(jiraPermissionWithGlass.checkPermissions(), jiraPermissionWithGlass.checkPermissionsWithGlass());
    }
}