package com.codecool.vargabeles.selenium.pom;

import org.junit.Assert;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class JiraComponentsWithGlassTest extends BaseTest {
    JiraComponentsWithGlass jiraComponentsWithGlass;


    @Test
    void categorizeIssues() {
        jiraComponentsWithGlass = new JiraComponentsWithGlass(driver);
        int result = jiraComponentsWithGlass.categorizeIssues();
        Assert.assertEquals(result, 1);
        jiraComponentsWithGlass.clearCategorizeIssues();
    }
}