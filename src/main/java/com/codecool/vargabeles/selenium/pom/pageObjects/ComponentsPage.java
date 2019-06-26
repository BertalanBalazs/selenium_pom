package com.codecool.vargabeles.selenium.pom.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ComponentsPage extends BasePage {
    @FindBy(xpath = "//input[@name='name']")
    WebElement nameInput;
    @FindBy(xpath = "//input[@id='assigneeType-field']")
    WebElement assigneeInput;

    @FindBy(xpath = "//*[@id=\"component-filter\"]")
    WebElement componentFilter;
    @FindBy(xpath = "//button")
    WebElement addButton;
    @FindBy(xpath = "//span[text()='Issues']")
    WebElement issuesLink;
    @FindBy(xpath = "//*[@id=\"submit\"]")
    WebElement deleteSubmitButton;



    public ComponentsPage(WebDriver webDriver) {
        super(webDriver);
    }

    public void sendKeyToNameInput(String text) {
        nameInput.sendKeys(text);
    }

    public void sendKeyToAssigneeInput(String text) {
        assigneeInput.sendKeys(text);
    }

    public void clickToComponentFilter() {
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//*[@id=\"component-filter\"]")));
        componentFilter.click();
    }


    public void clickToAddButton() {
        addButton.click();
    }

    public void clickToIssuesLink() {
        issuesLink.click();
    }

    public void clickToDeleteSubmitButton() {
        deleteSubmitButton.click();
    }

    public void clickToNthElementAction(int i) {
        driver.findElement(By.cssSelector("#components-table > tbody.items > tr:nth-child(" + i + ") > td.dynamic-table__actions > div > a > span")).click();
    }

    public int getNthDataComponentId(int i) {
        return Integer.parseInt(driver.findElement(By.cssSelector("#components-table > tbody.items > tr:nth-child(" + i + ")")).getAttribute("data-component-id"));
    }

    public void clickToDeleteComponent(int id) {
        driver.findElement(By.xpath("//*[@id=\"deletecomponent_" + id + "\"]")).click();
    }

    public void clickToRemoveComponentRadioButton(int id) {
        driver.findElement(By.xpath("//*[@id=\"component-" + id + "-delete-dialog\"]/div[2]/div/form/div[1]/fieldset/div[2]/label")).click();
    }

    public void makeNewComponent(String name, String assingee) {
        sendKeyToNameInput(name);
        sendKeyToAssigneeInput(assingee);
        clickToComponentFilter();
        clickToAddButton();
    }

    public void deleteComponent(String componentName) {
        int i = 1;
        while (true) {
            try {
                if (componentName.equals(driver.findElement(By.cssSelector("#components-table > tbody.items > tr:nth-child(" + i + ") > td.components-table__name > div > a")).getText())) {
                    clickToNthElementAction(i);
                    getNthDataComponentId(i);
                    int id = getNthDataComponentId(i);
                    clickToDeleteComponent(id);
                    clickToRemoveComponentRadioButton(id);
                    clickToDeleteSubmitButton();
                    break;
                }
                i++;
            } catch (Exception e) {
                break;
            }
        }
    }

}
