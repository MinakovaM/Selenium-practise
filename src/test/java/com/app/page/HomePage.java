package com.app.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
    private WebDriver driver;

    public HomePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy (linkText = "Sign in")
    private WebElement linkSingIn;

    public LoginPage goToLoginPage(){
        linkSingIn.click();
        return new LoginPage(driver);
    }
}
