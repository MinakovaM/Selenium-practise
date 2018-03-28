package com.app.appmanager.helpers;

import com.app.appmanager.page.HomePage;
import com.app.appmanager.page.LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SessionHelper {
    private WebDriver driver;

    public SessionHelper(WebDriver driver) {
        this.driver = driver;
    }


    public void login(String login, String password) {
        new HomePage(driver).goToLoginPage()
                .inputLogin(login)
                .inputPassword(password)
                .submitLogin();
    }
}