package com.codecool.vargabeles.selenium.pom.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class GlassDocumentationPermissionPage extends BasePage {
    public GlassDocumentationPermissionPage(WebDriver webDriver) {
        super(webDriver);
    }

    public Boolean[][] getPermissionList() {
        Boolean[][] permissionList = new Boolean[4][34];
        for (int column = 2; column < 6; column++) {
            for (int row = 1; row < 35; row++){
                try {
                    WebElement trueIcon = driver.findElement(By.xpath("//*[@id=\"glass-permissions-panel\"]/div/table/tbody/tr["+row+"]/td["+column+"]/div"));
                    permissionList[column-2][row-1] = true;
                } catch (Exception e){
                    permissionList[column-2][row-1] = false;
                }
            }
        }

        return permissionList;
    }
}
