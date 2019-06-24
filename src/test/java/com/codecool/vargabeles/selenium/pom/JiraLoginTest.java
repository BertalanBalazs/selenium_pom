package com.codecool.vargabeles.selenium.pom;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.*;

class JiraLoginTest extends BaseTest{
    private JiraLogin jiraLogin;


    @BeforeAll
    static void init(){

    }

    @Test
    void loginToJira() {
        jiraLogin = new JiraLogin();
        Utils.navigate();
        jiraLogin.loginToJira(System.getenv("username"), System.getenv("password"));
    }

}