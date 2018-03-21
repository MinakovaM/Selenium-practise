package com.app.appmanager.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

    @FindBy(id="email")
    private WebElement loginField;
    @FindBy(id="passwd")
    private WebElement passwField;
    @FindBy(id="SubmitLogin")
    private WebElement signInButton;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public LoginPage inputLogin(String login) {
        type(loginField, login);
        return new LoginPage(driver);
    }


    public LoginPage inputPassword(String passw) {
        type(passwField, passw);
        return new LoginPage(driver);
    }

    public AccountPage submitLogin() {
        signInButton.click();
        return new AccountPage(driver);
    }
}