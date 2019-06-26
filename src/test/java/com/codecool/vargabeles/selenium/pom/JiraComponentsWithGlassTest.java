package com.codecool.vargabeles.selenium.pom;

import org.junit.Assert;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class JiraComponentsWithGlassTest extends BaseTest {
    JiraComponentsWithGlass jiraComponentsWithGlass;


    @Test
    void categorizeIssues() {
        int result = jiraComponentsWithGlass.categorizeIssues();
        Assert.assertEquals(result, 1);
        jiraComponentsWithGlass.clearCategorizeIssues();
    }

    @Override
    protected void makeInstance() {
        jiraComponentsWithGlass = new JiraComponentsWithGlass(driver);
    }
}