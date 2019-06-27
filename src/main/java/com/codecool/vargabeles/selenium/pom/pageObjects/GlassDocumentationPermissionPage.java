package com.codecool.vargabeles.selenium.pom.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class GlassDocumentationPermissionPage extends BasePage {
    public GlassDocumentationPermissionPage(WebDriver webDriver) {
        super(webDriver);
    }

    public String[][] getPermissionList() {
        String[][] permissionList = new String[34][12];
        for (int row = 1; row < 35; row++) {
            for (int column = 2; column < 14; column++) {
                try {
                    driver.findElement(By.xpath("//*[@id=\"glass-permissions-panel\"]/div/table/tbody/tr[" + row + "]/td[" + column + "]/div"));
                    permissionList[row - 1][column - 2] = "true";
                } catch (Exception e) {
                    permissionList[row - 1][column - 2] = "false";
                }
            }
        }

        return permissionList;
    }

    public String[][] readPermissionDataFromCsv() {
        String[][] records = new String[34][12];
        try (BufferedReader br = new BufferedReader(new FileReader("../selenium_pom/src/main/resources/permissionDatas.csv"))) {
            String line;
            int i = 0;
            while ((line = br.readLine()) != null) {
                if (i != 0) {
                    String[] values = line.split(",");
                    records[i - 1] = values;
                }
                i++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return records;
    }
}
