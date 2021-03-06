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
    @FindBy(xpath = "//input[@id='component-filter-text']")
    WebElement componentFilterInput;


    public ComponentsPage(WebDriver webDriver) {
        super(webDriver);
    }

    private void sendKeyToNameInput(String text) {
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//input[@name='name']")));
        nameInput.sendKeys(text);
    }

    private void sendKeyToAssigneeInput(String text) {
        assigneeInput.sendKeys(text);
    }

    private void clickToComponentFilter() {
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//*[@id=\"component-filter\"]")));
        componentFilter.click();
    }


    private void clickToAddButton() {
        addButton.click();
    }

    public void clickToIssuesLink() {
        issuesLink.click();
    }

    private void clickToDeleteSubmitButton() {
        deleteSubmitButton.click();
    }

    private void clickToElementAction() {
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//tr[2]/td[@class='components-table__name' and 1]")));
        driver.findElement(By.cssSelector("#components-table > tbody.items > tr:nth-child(1) > td.dynamic-table__actions > div > a > span")).click();
    }

    private int getDataComponentId() {
        return Integer.parseInt(driver.findElement(By.cssSelector("#components-table > tbody.items > tr:nth-child(1)")).getAttribute("data-component-id"));
    }

    private void clickToDeleteComponent(int id) {
        driver.findElement(By.xpath("//*[@id=\"deletecomponent_" + id + "\"]")).click();
    }

    private void clickToRemoveComponentRadioButton(int id) {
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"component-" + id + "-delete-dialog\"]/div[2]/div/form/div[1]/fieldset/div[2]/label")));
        driver.findElement(By.xpath("//*[@id=\"component-" + id + "-delete-dialog\"]/div[2]/div/form/div[1]/fieldset/div[2]/label")).click();
    }

    private void sendKeyToComponentFilterInput(String componentName) {
        componentFilterInput.sendKeys(componentName);
    }

    public void makeNewComponent(String name, String assignee) {
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        sendKeyToNameInput(name);
        sendKeyToAssigneeInput(assignee);
        clickToComponentFilter();
        clickToAddButton();
    }

    public void deleteComponent(String componentName, int projectId) {
        navigate("/projects/PP" + projectId + "?selectedItem=com.atlassian.jira.jira-projects-plugin:components-page");
        sendKeyToComponentFilterInput(componentName);
        clickToElementAction();
        getDataComponentId();
        int id = getDataComponentId();
        clickToDeleteComponent(id);
        clickToRemoveComponentRadioButton(id);
        clickToDeleteSubmitButton();

    }
}