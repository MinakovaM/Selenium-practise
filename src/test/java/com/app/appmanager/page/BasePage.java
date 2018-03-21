package com.app.appmanager.page;

import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class BasePage {
    protected WebDriver driver;

    public BasePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    protected void type(WebElement inputField, String value) {
        inputField.click();
        inputField.clear();
        inputField.sendKeys(value);
    }
    protected void select (WebElement el, String value) {
        new Select(el).selectByValue(value);
        }
    protected void select (WebElement el, int index){
        new Select(el).selectByIndex(index);
    }

    protected  void click(WebElement button) {
        button.click();
    }

    protected void selectByValue(WebElement select, String value) {

    }
}