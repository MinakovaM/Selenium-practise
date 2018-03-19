package com.app;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import java.io.File;
import java.util.concurrent.TimeUnit;

public class BaseTest {
    protected WebDriver driver;
    protected String baseUrl;
    boolean acceptNextAlert = true;
    protected StringBuffer verificationErrors = new StringBuffer();

    @Parameters("browser")
    @BeforeClass
    public void setUp(String browser) throws Exception {
        if (browser.equals("chrome")) {
            System.setProperty("webdriver.chrome.driver", "d:/Java/chromedriver.exe");
            driver = new ChromeDriver();
        }
        else if (browser.equals("firefox")) {
            System.setProperty("webdriver.gecko.driver", "d:/Java/geckodriver.exe");
            driver = new FirefoxDriver();
        }
        else if(browser.equals("IE")) {
            File ie = new File("d:/Java/IEDriverServer.exe");
            System.setProperty("webdriver.ie.driver", ie.getAbsolutePath());
            driver = new InternetExplorerDriver();
        }
        else if (browser.equals("edge")) {
            System.setProperty("webdriver.edge.driver", "d:/Java/MicrosoftWebDriver.exe");
            driver = new EdgeDriver();
        }

        baseUrl = "http://automationpractice.com/index.php";
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @AfterClass(alwaysRun = true)
    public void tearDown() throws Exception {
        driver.quit();
    }
    private boolean isAlertPresent() {
        try {
            driver.switchTo().alert();
            return true;
        } catch (NoAlertPresentException e) {
            return false;
        }
    }
    @AfterMethod (alwaysRun = true)
    public void logOut()throws Exception{
        driver.findElement(By.cssSelector(".logout")).click();
    }

    public String closeAlertAndGetItsText() {
        try {
            Alert alert = driver.switchTo().alert();
            String alertText = alert.getText();
            if (acceptNextAlert) {
                alert.accept();
            } else {
                alert.dismiss();
            }
            return alertText;
        } finally {
            acceptNextAlert = true;
        }
    }
}