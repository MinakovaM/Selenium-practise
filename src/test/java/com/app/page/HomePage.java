package com.app.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends BasePage{

    @FindBy(linkText = "Sign in")
    private WebElement signInLink;
    @FindBy(linkText = "Sign out")
    private WebElement signOutLink;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public LoginPage goToLoginPage() {
        signInLink.click();
        return new LoginPage(driver);
    }
    public HomePage doLogOut(){
        signOutLink.click();
        return new HomePage(driver);
    }
}