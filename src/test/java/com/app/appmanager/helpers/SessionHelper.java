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


    public void login() {
        new HomePage(driver).goToLoginPage()
                .inputLogin("testt@gmail.com")
                .inputPassword("12369874")
                .submitLogin();
//        driver.findElement(By.linkText("Sign in")).click();
//        driver.findElement(By.id("email")).click();
//        driver.findElement(By.id("email")).clear();
//        driver.findElement(By.id("email")).sendKeys("testT@gmail.com");
//        driver.findElement(By.id("passwd")).clear();
//        driver.findElement(By.id("passwd")).sendKeys("12369874");
//        driver.findElement(By.id("SubmitLogin")).click();
    }
}